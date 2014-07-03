/**        DBMS.java        */
package dbms;

import java.sql.*;
import java.util.*;
/**
 * Questa classe mette a disposizione i metodi per effettuare interrogazioni
 * sulla base di dati.
 */
public class DBMS {

	private String user = "userlab16";
    private String passwd = "sediciLS";
	
    /*<protocollo>://<host del server>/<nome base di dati>.*/
    private String url = "jdbc:postgresql://dbserver.sci.univr.it/did2014";
    
	/** Driver da utilizzare per la connessione e l'esecuzione delle query. */
    private String driver = "org.postgresql.Driver";

    //query per la homepage
    private final String queryPrimario =
    		"select nome, cognome " +
    		"from medico as m, primario as p " +
    		"where p.id = medico.id;";

    //query per la pazientepage
    private final String queryPaziente = 
    		"select p.*, r.nome, c.data_ricovero, c.data_dimissione, m.nome as nome_medico, m.cognome as cognome_medico" +
    		"from paziente as p, rischi_paziente as r, cartella_clinica as c, diagnosi as d, medico as m " +
    		"where p.id_cartella = c.id " +
    		"and p.codsan = r.id_paziente " +
    		"and d.id_paziente = p.codsan " +
    		"and d.id_medico = m.id;";
    
    //query per la cartellapage
    private final String queryCartella =
    		"select c.*, t.*, d.*, m.nome as nome_medico, m.cognome as cognome_medico " +
    		"from cartella as c, paziente as p, diagnosi as d, terapie as t, medico as m " +
    		"where c.id = t.id_cartella " +
    		"and c.codsan = p.codsan " +
    		"and d.id_paziente = p.codsan;";
    
    //query per la personalepage
    private final String querySpecPrimario =
    		"select nome, cognome " +
    		"from medico as m, primario as p, spec_del_medico as s " +
    		"where p.id = m.id " +
    		"and m.id = s.id_medico;";

    
    private final String queryPersonale =
    		"select m.*, s.nome as nome_spec, count(*) " +
    		"from medico as m, spec_del_medico as s, diagnosi as d " +
    		"where m.id = s.id_medico " +
    		"and d.id_medico = m.id " +
    		"group by m.id;";
    
    //query per la patologiepage
    private final String queryPatologie =
    		"select d.icd10, p.codsan " +
    		"from diagnosi as d, paziente as p " +
    		"where p.codsan = d.id_paziente;";
    

    

    /***************
     * 
     *  METODI MAKEBEAN
     * 
     */

    //per homepage
	private PrimarioBean makePrimarioBean(ResultSet rs) throws SQLException {
	
		PrimarioBean bean = new PrimarioBean();
		bean.setId(rs.getInt("id"));
		bean.setNome(rs.getString("nome"));
		bean.setCognome(rs.getString("cognome"));
		return bean;
    }

    
	//per pazientepage
	private PazienteBean makePazienteBean(ResultSet rs) throws SQLException {
		
		PazienteBean bean = new PazienteBean();
		bean.setCODSAN(rs.getString("codsan"));
		bean.setNome(rs.getString("nome"));
		
		return bean;
	}
    
    
    /***************
     * 
     *  METODI GET
     * 
     */
    
    
	public String getQualcosa() {
	// Dichiarazione delle variabili
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	String result="";
	try {
		// Tentativo di connessione al database
		con = DriverManager.getConnection(url, user, passwd);
		// Connessione riuscita, ottengo l'oggetto per l'esecuzione dell'interrogazione.
		stmt = con.createStatement();
		// Eseguo l'interrogazione desiderata
		rs = stmt.executeQuery("stringa query");
		// Memorizzo il risultato dell'interrogazione nel Vector
		if(rs.next())
			result = (rs.getString("Nome"))+ "  " +(rs.getString("Cognome"));
	} catch(SQLException sqle) {                
		sqle.printStackTrace();
	} finally {                                 
		try {
			con.close();
		} catch(SQLException sqle1) {
			sqle1.printStackTrace();
		}
	}
	return result;
}


    
    
    
    
	/*
	 * 
	 * codice generico da fare:

con prepare statement (quindi con query dinamica)

public Vector getQualcosa(int qualcosa1, int qualcosa2)
		// Dichiarazione delle variabili necessarie
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Vector result = new Vector();	
		try {
			// Tentativo di connessione al database
			con = DriverManager.getConnection(url, user, passwd);
			// Connessione riuscita, ottengo l'oggetto per l'esecuzione dell'interrogazione.
			pstmt = con.prepareStatement("stringa query"); 
			pstmt.clearParameters();
			//Imposto i parametri della query dinamicamente
			pstmt.setInt(1, qualcosa1);
            pstmt.setInt(2, qualcosa2); 
			//Eseguo la query
			rs=pstmt.executeQuery(); 
			// Memorizzo il risultato dell'interrogazione in Vector di Bean
			while(rs.next())
				result.add(makeQualcosa(rs));
		} catch(SQLException sqle) {                
			sqle.printStackTrace();
		} finally {                                 
			try {
				con.close();
			} catch(SQLException sqle1) {
				sqle1.printStackTrace();
			}
		}
		return result;





senza prepare statement (query statica)


		public String getQualcosa() {
		// Dichiarazione delle variabili
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String result="";
		try {
			// Tentativo di connessione al database
			con = DriverManager.getConnection(url, user, passwd);
			// Connessione riuscita, ottengo l'oggetto per l'esecuzione dell'interrogazione.
			stmt = con.createStatement();
			// Eseguo l'interrogazione desiderata
			rs = stmt.executeQuery("stringa query");
			// Memorizzo il risultato dell'interrogazione nel Vector
			if(rs.next())
				result = (rs.getString("Nome"))+ "  " +(rs.getString("Cognome"));
		} catch(SQLException sqle) {                
			sqle.printStackTrace();
		} finally {                                 
			try {
				con.close();
			} catch(SQLException sqle1) {
				sqle1.printStackTrace();
			}
		}
		return result;
    }



popolamento dati: makeQualcosa

	//Metodi per la creazione di un bean a partire dal record attuale del ResultSet dato come parametro
	private CorsoStudiBean makeCorsoStudiBean(ResultSet rs) throws SQLException {
		CorsoStudiBean bean = new CorsoStudiBean();
		bean.setId(rs.getInt("id"));
		bean.setNomeCorsoStudi(rs.getString("Nome"));
		bean.setCodice(rs.getString("Codice"));
		bean.setAbbreviazione(rs.getString("Abbreviazione"));
		bean.setDurataanni(rs.getInt("Durataanni"));
		bean.setSede(rs.getString("Sede"));
		bean.setInformativa(rs.getString("Informativa"));
		bean.setDipartimento(rs.getString("Dipart"));
		return bean;
    }


	 */
	
	
	
	public Vector getInfoPaziente() {
		// TODO Auto-generated method stub
		return null;
	}



	public Vector getInfoCartella() {
		// TODO Auto-generated method stub
		return null;
	}



	public Vector getPersonale() {
		// TODO Auto-generated method stub
		return null;
	}



	public Vector getPatologie() {
		// TODO Auto-generated method stub
		return null;
	}



	public String getPrimario() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
