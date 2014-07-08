/**        DBMS.java        */
package dbms;

import java.sql.*;
import java.util.*;
/**
 * Questa classe mette a disposizione i metodi per effettuare interrogazioni
 * sulla base di dati.
 */
public class DBMS {

//	private String user = "userlab16";
//	private String passwd = "sediciLS";

	private String user = "postgres";
	private String passwd = "postgres";
	
	/*<protocollo>://<host del server>/<nome base di dati>.*/
	//private String url = "jdbc:postgresql://dbserver.sci.univr.it/did2014";
	private String url = "jdbc:postgresql://localhost:5432/mydb";

	/** Driver da utilizzare per la connessione e l'esecuzione delle query. */
	private String driver = "org.postgresql.Driver";

	//query per la homepage
	private final String queryPrimario =
			"select nome, cognome " +
					"from medico as m " +
					"where m.primario = 'si';";

	//query per la pazientepage
	private final String queryLoginPaziente =
			"select codsan from paziente as p where p.codsan = ? and p.psw = ?";

	private final String queryPaziente = 
			"select p.codsan, p.nome, p.cognome, p.nascita, p.citta, p.via, p.prov, p.cap, p.civico, r.nome_fattore, c.id as idcartelle, c.data_ricovero, c.data_dimissione, m.nome as nome_medico, m.cognome as cognome_medico " +
					"from paziente as p, rischi_paziente as r, cartella_clinica as c, diagnosi as d, medico as m " +
					"where p.codsan = ? " +
					"and p.codsan = c.codsan " +
					"and p.codsan = r.id_paziente " +
					"and d.id_paziente = p.codsan " +
					"and d.id_medico = m.id;";
	
	private final String queryCartellaDelPaziente =
			"select c.id, c.data_ricovero, c.data_dimissione " +
			"from cartella_clinica as c, paziente as p " +
			"where c.codsan = ? " +
			"and c.codsan = p.codsan;";
	
	
	private final String queryRischiPaziente = 
			"select nome_fattore " +
			"from paziente as p, rischi_paziente as r " +
			"where p.codsan = ? " +
			"and p.codsan = r.id_paziente; ";
	
	
	private final String queryMediciDelPaziente =
			"select m.nome, m.cognome " +
			"from paziente as p, medico as m, diagnosi as d " +
			"where p.codsan = ? " +
			"and p.codsan = d.id_paziente " +
			"and m.id = d.id_medico ;";

	//query per la cartellapage
	private final String queryCartella =
			"select c.* " +
					"from cartella_clinica as c, paziente as p " +
					"where c.id = ? ;";
	
	private final String queryTerapieDellaCartella =
			"select t.* " +
					"from cartella_clinica as c, terapie as t " +
					"where c.id = ? " +
					"and c.id = t.id_cartella ; ";

	private final String queryDiagnosiDellaCartella =
			"select d.*, m.nome, m.cognome " +
			"from cartella_clinica as c, diagnosi as d, paziente as p, medico as m " +
			"where c.id = ? " +
			"and p.codsan = d.id_paziente " +
			"and p.codsan = c.codsan " +
			"and d.id_medico = m.id;";


	//query per la personalepage
	private final String queryPrimarioPerSpec =
			"select id, nome, cognome " +
					"from medico as m " +
					"where m.primario = 'si' ;";

	private final String querySpecializzazioni =
			" select nome_specializzazione as nome_spec " +
			"from spec_del_medico as s " +
			"where s.id_medico = ? ;";
	
	private final String queryPersonale =
			"select m.*, count(d.id_medico) as count " +
					"from medico as m, spec_del_medico as s, diagnosi as d " +
					"where m.id = s.id_medico " +
					"and d.id_medico = m.id " +
					"group by m.id;";

	//query per la patologiepage
	private final String queryPatologie =
			"select d.patologia, d.icd10, count(*) as numeropazienti " +
					"from diagnosi as d, paziente as p " +
					"where d.id_paziente = p.codsan " +
					"group by d.icd10, d.patologia;";
	
	
	private final String queryPazientiDaIcd10 =
			"select p.codsan " +
			"from paziente as p, diagnosi as d " +
			"where p.codsan = d.id_paziente;";


	//query per la diagnosipage
	private final String queryMedicoLogin =
			"select id from medico as m where m.id = ? and m.psw = ?;";

	private final String queryMedicoLoginOk =
			"select nome,cognome from medico as m where m.id = ?;";

	
	
    public DBMS() throws ClassNotFoundException {
		Class.forName(driver);
    }

    /***********************************************************/
	/***********************************************************/
	/**********************************************************
	 * 
	 *  METODI MAKEBEAN
	 * 
	/***********************************************************/
	/***********************************************************/
	/***********************************************************/


	//per homepage
	private PrimarioBean makePrimarioBean(ResultSet rs) throws SQLException {
	
		PrimarioBean bean = new PrimarioBean();
		bean.setId(rs.getString("id"));
		bean.setNome(rs.getString("nome"));
		bean.setCognome(rs.getString("cognome"));
		return bean;
    }

    
	/***********************************************************/
	/***********************************************************/
	//per pazientepage
	private PazienteBean makePazienteBean(ResultSet rs) throws SQLException {
		
		PazienteBean bean = new PazienteBean();
		bean.setCODSAN(rs.getString("codsan"));
		bean.setNome(rs.getString("nome"));
		bean.setCap(rs.getString("cap"));
		bean.setCitta(rs.getString("citta"));
		bean.setCivico(rs.getString("civico"));
		bean.setCognome(rs.getString("cognome"));
		bean.setNascita(rs.getString("nascita"));
		bean.setProv(rs.getString("prov"));
		bean.setVia(rs.getString("via"));
		bean.setFattori_a_rischio(rs.getString("nome_fattore"));
		
		return bean;
	}
	
	
	private CartellaBean makeCartellaDelPazienteBean(ResultSet rs)  throws SQLException{

		CartellaBean bean = new CartellaBean();
		
		bean.setCodice(rs.getString("id"));
		bean.setDataDimissione(rs.getString("data_dimissione"));
		bean.setData(rs.getString("data_ricovero"));
		
		return bean;
	}

	
	/***********************************************************/
	/***********************************************************/
	//per cartellapage
	private CartellaBean makeCartellaBean(ResultSet rs) throws SQLException {
			
			CartellaBean bean = new CartellaBean();
			bean.setCodice(rs.getString("id"));
			bean.setData(rs.getString("data_ricovero"));
			bean.setDataDimissione(rs.getString("data_dimissione"));
			bean.setMotivo(rs.getString("motivo"));
			bean.setPrognosi(rs.getString("prognosi"));
			return bean;
	}

	
	private CartellaBean makeTerapieDellaCartellaBean(ResultSet rs) throws SQLException {

		CartellaBean bean = new CartellaBean();

		bean.setTerapie_dosi(rs.getString("dose"));
		bean.setTerapie_farmaco(rs.getString("farmaco"));
		bean.setTerapie_fine(rs.getString("fine"));
		bean.setTerapie_frequenza(rs.getString("frequenza"));
		bean.setTerapie_id_cartella(rs.getString("id_cartella"));
		bean.setTerapie_inizio(rs.getString("inizio"));
		
		return bean;
	}

	
	private CartellaBean makeDiagnosiDellaCartellaBean(ResultSet rs) throws SQLException {

		CartellaBean bean = new CartellaBean();

		bean.setDiagnosi_data(rs.getString("data"));
		bean.setDiagnosi_icd10(rs.getString("icd10"));
		bean.setDiagnosi_patologia(rs.getString("patologia"));
		bean.setMedicoCognome(rs.getString("cognome"));
		bean.setMedicoNome(rs.getString("nome"));
		
		return bean;
	}
	
	/***********************************************************/
	/***********************************************************/
	//per personalepage
	private PersonaleBean makePersonaleBean(ResultSet rs) throws SQLException {
		
		PersonaleBean bean = new PersonaleBean();
		bean.setId(rs.getString("id"));
		bean.setNome(rs.getString("nome"));
		bean.setCognome(rs.getString("cognome"));
		bean.setInizio(rs.getString("inizio_attivita"));
		//da controllare
		bean.setDiagnosi(rs.getInt("count"));
		return bean;
	}
	
	private PersonaleBean makeSpecializzazioni(ResultSet rs) throws SQLException {
		
		PersonaleBean bean = new PersonaleBean();
		
		bean.setSpecializzazioni(rs.getString("nome_spec"));
		
		return bean;
		
	}
	
	/***********************************************************/
	/***********************************************************/
	//per patologiepage
	private PatologieBean makePatologieBean(ResultSet rs) throws SQLException {
			
		PatologieBean bean = new PatologieBean();
		bean.setNomePatologia(rs.getString("patologia"));
		bean.setICD10(rs.getString("icd10"));
		bean.setNumeroPazienti(rs.getInt("numeropazienti"));
		return bean;
	}
	
	private PatologieBean makePazientiDaIcd10 (ResultSet rs) throws SQLException {
		
		PatologieBean bean = new PatologieBean();
		bean.setIdPaziente(rs.getString("codsan"));
		
		return bean;
		
	}
	
	/***********************************************************/
	/***********************************************************/
	/***********************************************************/
	 /* 
	 *  METODI GET
	 * 
	/***********************************************************/
	/***********************************************************/
	/***********************************************************/

	/***********************************************************/
	/***********************************************************/
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
			while(rs.next())
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



	/***********************************************************/
	/***********************************************************/
	//query per la pazientepage
	//con prepare statement
	public PazienteBean getPaziente(String codsan){
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


	//con prepare statement
	public String PazienteLogin(String codsan, String password){
		// Dichiarazione delle variabili necessarie
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String result = "";	
		try {
			// Tentativo di connessione al database
			con = DriverManager.getConnection(url, user, passwd);
			// Connessione riuscita, ottengo l'oggetto per l'esecuzione dell'interrogazione.
			pstmt = con.prepareStatement(queryLoginPaziente); 
			pstmt.clearParameters();
			//Imposto i parametri della query dinamicamente
			pstmt.setString(1, codsan);
			pstmt.setString(2, password); 
			//Eseguo la query
			rs=pstmt.executeQuery(); 
			// Memorizzo il risultato dell'interrogazione in Vector di Bean
			while(rs.next())
				result = rs.getString("codsan");
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

	
	//con prepare statement
	public Vector getCartelleDelPaziente(String codsan){
		// Dichiarazione delle variabili necessarie
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Vector result = new Vector();	
		try {
			// Tentativo di connessione al database
			con = DriverManager.getConnection(url, user, passwd);
			// Connessione riuscita, ottengo l'oggetto per l'esecuzione dell'interrogazione.
			pstmt = con.prepareStatement(queryCartellaDelPaziente); 
			pstmt.clearParameters();
			//Imposto i parametri della query dinamicamente
			pstmt.setString(1, codsan);
			//Eseguo la query
			rs=pstmt.executeQuery(); 
			// Memorizzo il risultato dell'interrogazione in Vector di Bean
			while(rs.next())
				result.add(makeCartellaDelPazienteBean(rs));
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

	
	//con prepare statement
	public Vector getRischiDelPaziente(String codsan){
		// Dichiarazione delle variabili necessarie
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Vector result = new Vector();	
		try {
			// Tentativo di connessione al database
			con = DriverManager.getConnection(url, user, passwd);
			// Connessione riuscita, ottengo l'oggetto per l'esecuzione dell'interrogazione.
			pstmt = con.prepareStatement(queryRischiPaziente); 
			pstmt.clearParameters();
			//Imposto i parametri della query dinamicamente
			pstmt.setString(1, codsan);
			//Eseguo la query
			rs=pstmt.executeQuery(); 
			// Memorizzo il risultato dell'interrogazione in Vector di Bean
			while(rs.next())
				result.add(rs.getString("nome_fattore"));
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
	
	
	//con prepare statement
	public Vector getMediciDelPaziente(String codsan){
		// Dichiarazione delle variabili necessarie
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Vector result = new Vector();	
		try {
			// Tentativo di connessione al database
			con = DriverManager.getConnection(url, user, passwd);
			// Connessione riuscita, ottengo l'oggetto per l'esecuzione dell'interrogazione.
			pstmt = con.prepareStatement(queryMediciDelPaziente); 
			pstmt.clearParameters();
			//Imposto i parametri della query dinamicamente
			pstmt.setString(1, codsan);
			//Eseguo la query
			rs=pstmt.executeQuery(); 
			// Memorizzo il risultato dell'interrogazione in Vector di Bean
			while(rs.next())
				result.add(rs.getString("nome") + " " + rs.getString("cognome"));
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

	/***********************************************************/
	/***********************************************************/
	//query per la cartellaPage
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


	
	//con prepare statement
	public Vector getTerapieCartella(String id){
		// Dichiarazione delle variabili necessarie
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Vector result = new Vector();	
		try {
			// Tentativo di connessione al database
			con = DriverManager.getConnection(url, user, passwd);
			// Connessione riuscita, ottengo l'oggetto per l'esecuzione dell'interrogazione.
			pstmt = con.prepareStatement(queryTerapieDellaCartella); 
			pstmt.clearParameters();
			//Imposto i parametri della query dinamicamente
			pstmt.setString(1, id);
			//Eseguo la query
			rs=pstmt.executeQuery(); 
			// Memorizzo il risultato dell'interrogazione in Vector di Bean
			while(rs.next())
				result.add(makeTerapieDellaCartellaBean(rs));
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


	
	//con prepare statement
	public Vector getDiagnosiCartella(String id){
		// Dichiarazione delle variabili necessarie
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Vector result = new Vector();	
		try {
			// Tentativo di connessione al database
			con = DriverManager.getConnection(url, user, passwd);
			// Connessione riuscita, ottengo l'oggetto per l'esecuzione dell'interrogazione.
			pstmt = con.prepareStatement(queryDiagnosiDellaCartella); 
			pstmt.clearParameters();
			//Imposto i parametri della query dinamicamente
			pstmt.setString(1, id);
			//Eseguo la query
			rs=pstmt.executeQuery(); 
			// Memorizzo il risultato dell'interrogazione in Vector di Bean
			while(rs.next())
				result.add(makeDiagnosiDellaCartellaBean(rs));
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


	/***********************************************************/
	/***********************************************************/
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
			rs = stmt.executeQuery(queryPrimarioPerSpec);
			// Memorizzo il risultato dell'interrogazione nel Vector
			while(rs.next())
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
			while(rs.next())
				result.add(makePersonaleBean(rs));
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
	
	
	
	//con prepare statement
	public Vector getSpecializzazioni(String id){
		// Dichiarazione delle variabili necessarie
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Vector result = new Vector();	
		try {
			// Tentativo di connessione al database
			con = DriverManager.getConnection(url, user, passwd);
			// Connessione riuscita, ottengo l'oggetto per l'esecuzione dell'interrogazione.
			pstmt = con.prepareStatement(querySpecializzazioni); 
			pstmt.clearParameters();
			//Imposto i parametri della query dinamicamente
			pstmt.setString(1, id);
			//Eseguo la query
			rs=pstmt.executeQuery(); 
			// Memorizzo il risultato dell'interrogazione in Vector di Bean
			while(rs.next())
				result.add(makeSpecializzazioni(rs));
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
	
	
	/***********************************************************/
	/***********************************************************/
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
			while(rs.next())
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
	
	public Vector getPazientiDaIcd10() {

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
			rs = stmt.executeQuery(queryPazientiDaIcd10);
			// Memorizzo il risultato dell'interrogazione nel Vector
			while(rs.next())
				result.add(makePazientiDaIcd10(rs));
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

	
	/***********************************************************/
	/***********************************************************/
	//query per la diagnosipage
	//con prepare statement
	public String MedicoLogin(String id, String pw){
		// Dichiarazione delle variabili necessarie
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String result = "";	
		try {
			// Tentativo di connessione al database
			con = DriverManager.getConnection(url, user, passwd);
			// Connessione riuscita, ottengo l'oggetto per l'esecuzione dell'interrogazione.
			pstmt = con.prepareStatement(queryMedicoLogin); 
			pstmt.clearParameters();
			//Imposto i parametri della query dinamicamente
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			//Eseguo la query
			rs=pstmt.executeQuery(); 
			// Memorizzo il risultato dell'interrogazione in Vector di Bean
			while(rs.next())
				result = rs.getString("id");
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
	
	
	//con prepare statement
	public String getMedico(String id){
		// Dichiarazione delle variabili necessarie
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String result = "";	
		try {
			// Tentativo di connessione al database
			con = DriverManager.getConnection(url, user, passwd);
			// Connessione riuscita, ottengo l'oggetto per l'esecuzione dell'interrogazione.
			pstmt = con.prepareStatement(queryMedicoLoginOk); 
			pstmt.clearParameters();
			//Imposto i parametri della query dinamicamente
			pstmt.setString(1, id);
			//Eseguo la query
			rs=pstmt.executeQuery(); 
			// Memorizzo il risultato dell'interrogazione in Vector di Bean
			while(rs.next())
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
	
	
}