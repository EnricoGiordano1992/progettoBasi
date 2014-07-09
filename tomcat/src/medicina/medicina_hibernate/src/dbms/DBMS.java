/**        DBMS.java        */
package dbms;

import bean.*;
import bean.Medico;

import org.hibernate.*;

import java.sql.*;
import java.util.Vector;

public class DBMS {


	//query per la homepage
	String queryPrimario =
			"select * " +
					"from medico as m " +
					"where m.primario = 'si';";

	//query per la pazientepage
	String queryLoginPaziente =
			"select * from paziente as p where p.codsan = (:codsan) and p.psw = (:psw)";

	String queryPaziente = 
			"select p.* " +
			"from paziente as p " +
			"where p.codsan = (:codsan) ;";
	
	String queryCartellaDelPaziente =
			"select c.* " +
			"from cartella_clinica as c, paziente as p " +
			"where c.codsan = (:codsan) " +
			"and c.codsan = p.codsan;";
	
	
	String queryRischiPaziente = 
			"select r.* " +
			"from paziente as p, rischi_paziente as r " +
			"where p.codsan = (:codsan) " +
			"and p.codsan = r.id_paziente; ";
	
	
	String queryMediciDelPaziente =
			"select m.* " +
			"from paziente as p, medico as m, diagnosi as d " +
			"where p.codsan = (:codsan) " +
			"and p.codsan = d.id_paziente " +
			"and m.id = d.id_medico ;";

	//query per la cartellapage
	String queryCartella =
			"select c.* " +
					"from cartella_clinica as c, paziente as p " +
					"where c.id = (:id) ;";
	
	String queryTerapieDellaCartella =
			"select t.* " +
					"from cartella_clinica as c, terapie as t " +
					"where c.id = (:id) " +
					"and c.id = t.id_cartella ; ";

	//nome e cognome del medico li ho facendo accesso a d.getMedico().ecc...
	String queryDiagnosiDellaCartella =
			"select d.* " +
			"from cartella_clinica as c, diagnosi as d, paziente as p, medico as m " +
			"where c.id = (:id) " +
			"and p.codsan = d.id_paziente " +
			"and p.codsan = c.codsan; ";

	//query per la personalepage
	//so gia tutto del primario 
	
	String querySpecializzazioni =
			" select * " +
			"from spec_del_medico as s " +
			"where s.id_medico = (:id_medico) ;";
	
	String queryPersonale =
			"select m.* " +
					"from medico as m;";

	//query per la patologiepage
	String queryPatologie =
			"select d.* " +
					"from diagnosi as d; ";
	
	
	//per contare le patologie per ogni paziente fai paziente.size()
	


	//query per la diagnosipage
	String queryMedicoLogin =
			"select * from medico as m where m.id = (:id) and m.psw = (:psw);";

	String queryMedicoLoginOk =
			"select * from medico as m where m.id = (:id);";

	

	
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
	
	public String getPrimario() {
		
		Medico bean;
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction(); 

		bean = (Medico) session.createSQLQuery(queryPrimario).addEntity(Medico.class).uniqueResult();
		
		tx.commit();
		session.close();
		
		return bean.getNome() + " " + bean.getCognome();
	}



	/***********************************************************/
	/***********************************************************/
	//query per la pazientepage
	
	public Paziente getPaziente(String codsan){
		
		Paziente result = null;

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction(); 

		Query query = session.createSQLQuery(queryPaziente).addEntity(Paziente.class);
		query.setString("codsan", codsan);


		result = (Paziente) query.uniqueResult();

		tx.commit();
		session.close();

		return result;
	}


	
	public String PazienteLogin(String codsan, String password){

		Paziente result = null;

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction(); 

		Query query = session.createSQLQuery(queryLoginPaziente).addEntity(Paziente.class);
		query.setString("codsan", codsan);
		query.setString("psw", password);


		result = (Paziente) query.uniqueResult();

		tx.commit();
		session.close();

		return result.getCodsan();
	}

	
	
	public Vector getCartelleDelPaziente(String codsan){

		Vector result = null;

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction(); 

		Query query = session.createSQLQuery(queryCartellaDelPaziente).addEntity(CartellaClinica.class);
		query.setString("codsan", codsan);

		result = ( Vector ) query.list();
		
		tx.commit();
		session.close();

		return result;	
		
	}

	
	
	public Vector getRischiDelPaziente(String codsan){

		Vector result = null;

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction(); 

		Query query = session.createSQLQuery(queryRischiPaziente).addEntity(RischiPaziente.class);
		query.setString("codsan", codsan);

		result = ( Vector ) query.list();
		
		tx.commit();
		session.close();

		return result;	


	}
	
	
	
	public Vector getMediciDelPaziente(String codsan){
		
		Vector result = null;

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction(); 

		Query query = session.createSQLQuery(queryMediciDelPaziente).addEntity(Medico.class);
		query.setString("codsan", codsan);

		result = ( Vector ) query.list();
		
		tx.commit();
		session.close();

		return result;	

	}

	/***********************************************************/
	/***********************************************************/
	//query per la cartellaPage
	
	public CartellaClinica getCartella(String id){

		CartellaClinica result = null;

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction(); 

		Query query = session.createSQLQuery(queryLoginPaziente).addEntity(CartellaClinica.class);
		query.setString("id", id);


		result = (CartellaClinica) query.uniqueResult();

		tx.commit();
		session.close();

		return result;

	}


	
	
	public Vector getTerapieCartella(String id){

		Vector result = null;

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction(); 

		Query query = session.createSQLQuery(queryTerapieDellaCartella).addEntity(Terapie.class);
		query.setString("id", id);

		result = ( Vector ) query.list();
		
		tx.commit();
		session.close();

		return result;	

	}


	
	
	public Vector getDiagnosiCartella(String id){

		Vector result = null;

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction(); 

		Query query = session.createSQLQuery(queryDiagnosiDellaCartella).addEntity(Diagnosi.class);
		query.setString("id", id);

		result = ( Vector ) query.list();
		
		tx.commit();
		session.close();

		return result;	

	}


	/***********************************************************/
	/***********************************************************/
	//query per la personale page
	//(1)
	
	public Vector getPersonaleMedico() {

		Vector res;
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction(); 

		res = ( Vector ) session.createSQLQuery(queryPersonale).addEntity(Medico.class).list();
		tx.commit();
		session.close();

		return res;

	}
	
	
	
	
	public Vector getSpecializzazioni(String id){

		Vector result = null;

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction(); 

		Query query = session.createSQLQuery(querySpecializzazioni).addEntity(SpecDelMedico.class);
		query.setString("id", id);

		result = ( Vector ) query.list();
		
		tx.commit();
		session.close();

		return result;	

	}
	
	
	/***********************************************************/
	/***********************************************************/
	//query per la patologiepage
	
	public Vector getPatologie() {

		Vector res;
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction(); 

		res = ( Vector ) session.createSQLQuery(queryPatologie).addEntity(Diagnosi.class).list();
		tx.commit();
		session.close();

		return res;

	}
	
	

	
	/***********************************************************/
	/***********************************************************/
	//query per la diagnosipage
	
	public String MedicoLogin(String id, String pw){

		Medico result = null;

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction(); 

		Query query = session.createSQLQuery(queryMedicoLogin).addEntity(Paziente.class);
		query.setString("codsan", id);
		query.setString("psw", pw);


		result = (Medico) query.uniqueResult();

		tx.commit();
		session.close();

		return result.getId();

	}
	
	
	
	public String getMedico(String id){

		Medico result = null;

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction(); 

		Query query = session.createSQLQuery(queryMedicoLoginOk).addEntity(Medico.class);
		query.setString("id", id);


		result = (Medico) query.uniqueResult();

		tx.commit();
		session.close();

		return result.getNome() + " " + result.getCognome();

	}
	
	
}