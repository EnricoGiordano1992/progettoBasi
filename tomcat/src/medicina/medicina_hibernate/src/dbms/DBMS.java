/**        DBMS.java        */
package dbms;

import bean.*;

import org.hibernate.*;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.util.HashSet;
import java.util.Set;

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
			"and c.codsan = p.codsan "
			+ "order by c.id ;";
	
	
	String queryRischiPaziente = 
			"select r.* " +
			"from paziente as p, rischi_paziente as r " +
			"where p.codsan = (:codsan) " +
			"and p.codsan = r.id_paziente; ";
	
	
	String queryMediciDelPaziente =
			"select distinct m.* " +
			"from paziente as p, medico as m, diagnosi as d " +
			"where p.codsan = (:codsan) " +
			"and p.codsan = d.id_paziente " +
			"and m.id = d.id_medico "
			+ "order by m.id ;";

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

	
	String queryDiagnosiDellaCartella =
			"select d.*, m.* " +
			"from cartella_clinica as c, diagnosi as d, paziente as p, medico as m " +
			"where c.id = (:id) " +
			"and p.codsan = d.id_paziente " +
			"and p.codsan = c.codsan " +
			"and d.id_medico = m.id ;";
	
	String queryConfermeDellaDiagnosi = 
			"select c.* "
			+ "from conferme as c "
			+ "where c.id_cartella = (:id_cartella) "
			+ "and c.data = (:data_diagnosi) ;"
			+ "";

	String queryContraddizioniDellaDiagnosi = 
			"select c.* "
			+ "from contraddizioni as c "
			+ "where c.id_diagnosi = (:id_diagnosi) "
			+ "and c.data = (:data_diagnosi) ;";

	//query per la personalepage
	//so gia tutto del primario 
	
	String querySpecializzazioni =
			" select * " +
			"from spec_del_medico as s " +
			"where s.id_medico = (:id_medico) ;";
	
	String queryPersonale =
			"select m.* " +
					"from medico as m "
					+ "order by m.id ;";

	//query per la patologiepage
	String queryPatologie =
			"select d.* " +
					"from diagnosi as d; ";
	
	
	//per contare le patologie per ogni paziente fai paziente.size()
	String queryCountPatologie =
			"select count(*) "
			+ "from diagnosi "
			+ "where patologia = (:patologia) "
			+ "and icd10 = (:icd10) "
			+ "group by icd10, patologia;";
	
	


	//query per la diagnosipage
	String queryMedicoLogin =
			"select m.* from medico as m where m.id = (:id) and m.psw = (:psw);";

	String queryMedicoLoginOk =
			"select m.* from medico as m where m.id = (:id);";

	

	
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
	
	public Medico getPrimario() {
		
		Medico bean;
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction(); 

		bean = (Medico) session.createSQLQuery(queryPrimario).addEntity(Medico.class).uniqueResult();
		
		tx.commit();
		session.close();
		
		return bean;
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

		if(result == null)
			return "";
		else
			return result.getCodsan();
	}

	
	
	public ArrayList<CartellaClinica> getCartelleDelPaziente(String codsan){

		ArrayList<CartellaClinica> result = null;

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction(); 

		Query query = session.createSQLQuery(queryCartellaDelPaziente).addEntity(CartellaClinica.class);
		query.setString("codsan", codsan);

		result = ( ArrayList<CartellaClinica> ) query.list();
		
		tx.commit();
		session.close();

		return result;	
		
	}

	
	
	public ArrayList<RischiPaziente> getRischiDelPaziente(String codsan){

		ArrayList<RischiPaziente> result = null;

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction(); 

		Query query = session.createSQLQuery(queryRischiPaziente).addEntity(RischiPaziente.class);
		query.setString("codsan", codsan);

		result = ( ArrayList<RischiPaziente> ) query.list();
		
		tx.commit();
		session.close();

		return result;	


	}
	
	
	
	public ArrayList<Medico> getMediciDelPaziente(String codsan){
		
		ArrayList<Medico> result = null;

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction(); 

		Query query = session.createSQLQuery(queryMediciDelPaziente).addEntity(Medico.class);
		query.setString("codsan", codsan);

		result = ( ArrayList<Medico> ) query.list();
		
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

		Query query = session.createSQLQuery(queryCartella).addEntity(CartellaClinica.class);
		query.setString("id", id);


		result = (CartellaClinica) query.uniqueResult();

		tx.commit();
		session.close();

		return result;

	}


	
	
	public ArrayList<Terapie> getTerapieCartella(String id){

		ArrayList<Terapie> result = null;

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction(); 

		Query query = session.createSQLQuery(queryTerapieDellaCartella).addEntity(Terapie.class);
		query.setString("id", id);

		result = ( ArrayList<Terapie> ) query.list();
		
		tx.commit();
		session.close();

		return result;	

	}


	
	
	public ArrayList<Diagnosi> getDiagnosiCartella(String id){

		ArrayList<Diagnosi> result = null;

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction(); 

		Query query = session.createSQLQuery(queryDiagnosiDellaCartella).addEntity(Diagnosi.class);
		query.setString("id", id);

		result = ( ArrayList<Diagnosi> ) query.list();
		
		//inizializzo i medici che hanno effettuato le diagnosi
		for (Diagnosi d : result) {
		    Hibernate.initialize(d.getMedico());
		}
		
		tx.commit();
		session.close();

		return result;	

	}
	
	
	
	public ArrayList<Conferme> getConfermeDiagnosi(DiagnosiId dId){

		ArrayList<Conferme> result = null;

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction(); 

		Query query = session.createSQLQuery(queryConfermeDellaDiagnosi).addEntity(Diagnosi.class);
		query.setString("id_diagnosi", dId.getIdPaziente());
		
		query.setDate("data_diagnosi", dId.getData());

		result = ( ArrayList<Conferme> ) query.list();
		
		
		tx.commit();
		session.close();

		return result;	

	}

	public ArrayList<Contraddizioni> getContraddizioniDiagnosi(DiagnosiId dId){

		ArrayList<Contraddizioni> result = null;

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction(); 

		Query query = session.createSQLQuery(queryContraddizioniDellaDiagnosi).addEntity(Diagnosi.class);
		query.setString("id_diagnosi", dId.getIdPaziente());

		query.setDate("data_diagnosi", dId.getData());

		result = ( ArrayList<Contraddizioni> ) query.list();
		
		
		tx.commit();
		session.close();

		return result;	

	}


	/***********************************************************/
	/***********************************************************/
	//query per la personale page
	//(1)
	
	public ArrayList<Medico> getPersonaleMedico() {

		ArrayList<Medico> res;
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction(); 

		res = ( ArrayList<Medico> ) session.createSQLQuery(queryPersonale).addEntity(Medico.class).list();
		tx.commit();
		session.close();

		return res;

	}
	
	
	
	
	public ArrayList<SpecDelMedico> getSpecializzazioni(String id){

		ArrayList<SpecDelMedico> result = null;

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction(); 

		Query query = session.createSQLQuery(querySpecializzazioni).addEntity(SpecDelMedico.class);
		query.setString("id_medico", id);

		result = ( ArrayList<SpecDelMedico> ) query.list();
		
		tx.commit();
		session.close();

		return result;	

	}
	
	
	/***********************************************************/
	/***********************************************************/
	//query per la patologiepage
	
	public ArrayList<Diagnosi> getPatologie() {

		ArrayList<Diagnosi> res;
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction(); 

		res = ( ArrayList<Diagnosi> ) session.createSQLQuery(queryPatologie).addEntity(Diagnosi.class).list();
		tx.commit();
		session.close();

		return res;

	}
	
	
	
	public int getCountPatologie(String icd10, String patologia) {
	
		int result = 0;

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction(); 

		Query query = session.createSQLQuery(queryCountPatologie);
		query.setString("icd10", icd10);
		query.setString("patologia", patologia);
		
		result = ((Number) query.uniqueResult()).intValue();
		
		tx.commit();
		session.close();

		return result;	

		
	}

	
	/***********************************************************/
	/***********************************************************/
	//query per la diagnosipage
	
	public Medico MedicoLogin(String id, String pw){

		Medico result = null;

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction(); 

		Query query = session.createSQLQuery(queryMedicoLogin).addEntity(Medico.class);
		query.setString("id", id);
		query.setString("psw", pw);


		result = (Medico) query.uniqueResult();

		tx.commit();
		session.close();

		if(result == null)
			return null;
		else
			return result;

	}
	
	
	
	public Medico getMedico(String id){

		Medico result = null;

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction(); 

		Query query = session.createSQLQuery(queryMedicoLoginOk).addEntity(Medico.class);
		query.setString("id", id);


		result = (Medico) query.uniqueResult();

		tx.commit();
		session.close();

		return result;

	}
	
	
	public ArrayList<Paziente> getTuttiPazienti() {
		
		ArrayList<Paziente> res;
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction(); 

		res = ( ArrayList<Paziente> ) session.createSQLQuery("select * from paziente order by codsan").addEntity(Paziente.class).list();
		tx.commit();
		session.close();

		return res;

	}
	
	
	public int insertNewDiagnosi(int numargs, String id_cartella, String id_paziente, String data, 
			String id_medico, String icd10, String patologia, 
			ArrayList<String> sintomi, ArrayList<String> tipo, ArrayList<String> intensita) throws ParseException {
		
		
		Paziente paziente = getPaziente(id_paziente);
		CartellaClinica cartella = getCartella(id_cartella);
		Medico medico = getMedico(id_medico);

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = formatter.parse(data);

        Conferme conferme = new Conferme();
        Contraddizioni contraddizioni = new Contraddizioni();
        
		//popolo la tabella diagnosi
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

        Diagnosi d = new Diagnosi();
		d.setId(new DiagnosiId(paziente.getCodsan(), date, id_cartella));
		d.setIcd10(icd10);
		d.setMedico(medico);
		d.setPatologia(patologia);
		d.setPaziente(paziente);
		
		try{
        session.save(d);  
        session.getTransaction().commit(); 
		
        session.close();
		}catch(Exception e){
			return 1;
			}

        
		//popolo le tabelle conferme/contraddizioni
        for(int i = 0; i < tipo.size(); i++) {

            //prima però popolo la tabella sintomo che mi servirà per dopo
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();

    		SintomiId s_id = new SintomiId(sintomi.get(i), id_cartella);
    		Sintomi s = new Sintomi(s_id, cartella, intensita.get(i), date);

    		try{
			session.save(s);
	        session.getTransaction().commit(); 
	        session.close();
    		}catch(Exception e){
    			
    	        session.close();
    			
    			session = HibernateUtil.getSessionFactory().openSession();  
    			session.beginTransaction();  
    			
    			session.delete(d);  
    			session.getTransaction().commit();
    			
    			return 2;
    			}

        	//ora posso creare la conferma/contraddizione referenziandomi al sintomo
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
	
			if(tipo.get(i).equals("conferma")){
				conferme.setDiagnosi(d);
				
				ConfermeId c_id = new ConfermeId(s_id.getIdCartella(), sintomi.get(i), id_paziente, date, id_cartella);
				conferme.setId(c_id);
				
				conferme.setSintomi(s);
			}
			
			else{
				contraddizioni.setDiagnosi(d);
				
				ContraddizioniId c_id = new ContraddizioniId(s_id.getIdCartella(), sintomi.get(i), id_paziente, date, id_cartella);
				contraddizioni.setId(c_id);
				
				contraddizioni.setSintomi(s);
			}
			
		try{	
			if(tipo.get(i).equals("conferma"))
				session.save(conferme);
			else
				session.save(contraddizioni);
			
	        session.getTransaction().commit(); 
	        
	        session.close();
		}catch(Exception e){
			
	        session.close();
			
			session = HibernateUtil.getSessionFactory().openSession();  
			session.beginTransaction();  
			
			session.delete(d);
			session.delete(s);
			session.getTransaction().commit();
			
			return 3;
			}
       
        }
        return 0;

	}
	
}