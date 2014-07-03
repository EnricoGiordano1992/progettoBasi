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
					"from medico as m " +
					"where m.primario = 'si';";

	//query per la pazientepage
	private final String queryPaziente = 
			"select p.codsan, p.nome, p.cognome, p.nascita, p.citta, p.via, p.prov, p.cap, p.civico, r.nome, c.data_ricovero, c.data_dimissione, m.nome as nome_medico, m.cognome as cognome_medico" +
					"from paziente as p, rischi_paziente as r, cartella_clinica as c, diagnosi as d, medico as m " +
					"where and p.codsan = ? " +
					"and p.psw = ? " +
					"and p.id_cartella = c.id " +
					"and p.codsan = r.id_paziente " +
					"and d.id_paziente = p.codsan " +
					"and d.id_medico = m.id ";

	//query per la cartellapage
	private final String queryCartella =
			"select c.*, t.*, d.*, m.nome as nome_medico, m.cognome as cognome_medico " +
					"from cartella as c, paziente as p, diagnosi as d, terapie as t, medico as m " +
					"where and c.id = ?" +
					"and c.id = t.id_cartella " +
					"and c.codsan = p.codsan " +
					"and d.id_paziente = p.codsan ;";

	//query per la personalepage
	private final String querySpecPrimario =
			"select nome, cognome " +
					"from medico as m, spec_del_medico as s " +
					"where m.primario = 'si' " +
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





	/***************
	 * 
	 *  METODI GET
	 * 
	 */

	//query per la homepage
	//senza prepare statement
	public String getPrimario() {
		// Dichiarazione delle variabili
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String result = "";
		try {
			// Tentativo di connessione al database
			con = DriverManager.getConnection(url, user, passwd);
			// Connessione riuscita, ottengo l'oggetto per l'esecuzione dell'interrogazione.
			stmt = con.createStatement();
			// Eseguo l'interrogazione desiderata
			rs = stmt.executeQuery(queryPrimario);
			// Memorizzo il risultato dell'interrogazione nel Vector
			if(rs.next())
				result = rs.getString("nome") + " " + rs.getString("cognome");
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



	//query per la pazientepage
	//con prepare statement
	public PazienteBean getPaziente(String codsan, String password){
		// Dichiarazione delle variabili necessarie
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PazienteBean result = new PazienteBean();	
		try {
			// Tentativo di connessione al database
			con = DriverManager.getConnection(url, user, passwd);
			// Connessione riuscita, ottengo l'oggetto per l'esecuzione dell'interrogazione.
			pstmt = con.prepareStatement(queryPaziente); 
			pstmt.clearParameters();
			//Imposto i parametri della query dinamicamente
			pstmt.setString(1, codsan);
			pstmt.setString(2, password); 
			//Eseguo la query
			rs=pstmt.executeQuery(); 
			// Memorizzo il risultato dell'interrogazione in Vector di Bean
			while(rs.next())
				result = makePazienteBean(rs);
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

	
	//query per la pazientepage
	//con prepare statement
	public CartellaBean getCartella(String id){
		// Dichiarazione delle variabili necessarie
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CartellaBean result = new CartellaBean();	
		try {
			// Tentativo di connessione al database
			con = DriverManager.getConnection(url, user, passwd);
			// Connessione riuscita, ottengo l'oggetto per l'esecuzione dell'interrogazione.
			pstmt = con.prepareStatement(queryCartella); 
			pstmt.clearParameters();
			//Imposto i parametri della query dinamicamente
			pstmt.setString(1, id);
			//Eseguo la query
			rs=pstmt.executeQuery(); 
			// Memorizzo il risultato dell'interrogazione in Vector di Bean
			while(rs.next())
				result = makeCartellaBean(rs);
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

	
	
	
	//query per la personale page
	//(1)
	//senza prepare statement
	public PrimarioBean getPrimarioSpec() {
		// Dichiarazione delle variabili
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		PrimarioBean result = new PrimarioBean();
		try {
			// Tentativo di connessione al database
			con = DriverManager.getConnection(url, user, passwd);
			// Connessione riuscita, ottengo l'oggetto per l'esecuzione dell'interrogazione.
			stmt = con.createStatement();
			// Eseguo l'interrogazione desiderata
			rs = stmt.executeQuery(querySpecPrimario);
			// Memorizzo il risultato dell'interrogazione nel Vector
			if(rs.next())
				result = makePrimarioBean(rs);
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

	
	//(2)
	//senza prepare statement
	public Vector getPersonaleMedico() {
		// Dichiarazione delle variabili
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		Vector result = new Vector();
		try {
			// Tentativo di connessione al database
			con = DriverManager.getConnection(url, user, passwd);
			// Connessione riuscita, ottengo l'oggetto per l'esecuzione dell'interrogazione.
			stmt = con.createStatement();
			// Eseguo l'interrogazione desiderata
			rs = stmt.executeQuery(queryPersonale);
			// Memorizzo il risultato dell'interrogazione nel Vector
			if(rs.next())
				result.add(makePrimarioBean(rs));
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
	
	
	//query per la patologiepage
	//senza prepare statement
	public Vector getPatologie() {
		// Dichiarazione delle variabili
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		Vector result = new Vector();
		try {
			// Tentativo di connessione al database
			con = DriverManager.getConnection(url, user, passwd);
			// Connessione riuscita, ottengo l'oggetto per l'esecuzione dell'interrogazione.
			stmt = con.createStatement();
			// Eseguo l'interrogazione desiderata
			rs = stmt.executeQuery(queryPatologie);
			// Memorizzo il risultato dell'interrogazione nel Vector
			if(rs.next())
				result.add(makePatologieBean(rs));
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

	
	
}