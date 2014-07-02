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
