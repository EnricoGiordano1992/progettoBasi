import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import did.*;

/**
 * Questa classe gestisce le richieste HTTP
 * 
 */
public class main extends HttpServlet {
    /**
     * Questo metodo risponde alle richieste HTTP di tipo GET. Elabora le richieste, impostando
     * gli eventuali attributi necessari, e ridirige la visualizzazione alle pagine jsp relative.
     *
     * @param request Oggetto HttpServletRequest dal quale ottenere informazioni circa la
     *                richiesta effettuata.
     * @param response Oggetto HttpServletResponse per l'invio delle risposte.
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {

		//Definizione e recupero dell'eventuale parametro della servlet
		String ps = "";
		//Dichiaro l'oggetto Dispatcher necessario per passare il controllo ad una JSP o una pagina HTML
		RequestDispatcher rd = null;
	
		if (request.getParameter("ps") != null) {// Ottengo se presente il parametro 'ps'
			ps = request.getParameter("ps");
		}
	
		try {
			// Oggetto per l'interazione con il Database
			DBMS dbms = new DBMS();
			if (ps.equals("")) {
				// Parametro ps assente o vuoto, visualizzo la home page del sito.
				// FUNZIONALIT� DA IMPLEMENTARE
				//Preparo il Dispatcher
				rd = request.getRequestDispatcher("../home.html");
			}			
			
			if (ps.equals("info")) { //visualizzo le informazioni di dettaglio del dipartimento
				//Delego l'esecuzione della query alla classe di interazione con il DB
				//Recupero il risultato della query come bean
				String info = dbms.getDirettore();
				//Aggiungo il Vector come attributo della richiesta HTTP
				request.setAttribute("info",info);
				//Preparo il Dispatcher
				rd = request.getRequestDispatcher("../info.jsp");	
			}
				
			if (ps.equals("did")) { //Visualizzo le info del corsi di studio attivi presso il dipartimento di informatica
				//Delego l'esecuzione della query alla classe di interazione con il DB
				//Recupero il risultato della query come vettore di bean
				Vector iddid = dbms.getIdDid(30);

                IdDidBean db = (IdDidBean) iddid.get(0);

                String id_stocazzo = dbms.getIdCorso(db.getCodice());

                request.setAttribute("did",iddid);
				//Preparo il Dispatcher
				rd = request.getRequestDispatcher("../didattica.jsp");
			}
			
			if (ps.equals("insegn")) { 

                
                //Visualizzo la lista di tutti gli insegnamenti erogati 
							  //nell'anno accademico 2013/2014 per il corso di studi "id"
				// FUNZIONALIT� DA IMPLEMENTARE
				String id = "";	//Recupero l'id del corso
                      if (request.getParameter("id") != null) {// Ottengo se presente il parametro 'id'
					    id = request.getParameter("id");
				        }
                      //Delego l'esecuzione della query alla classe di interazione con il DB
                      //Recupero il risultato della query come vettore di bean
                Vector insegn = dbms.getInsegnamenti(id);


                request.setAttribute("insegn",insegn);

                      //Preparo il Dispatcher
				rd = request.getRequestDispatcher("../insegnamenti.jsp");
								
			}
          if (ps.equals("add")) {
				// Parametro ps assente o vuoto, visualizzo la home page del sito.
				// FUNZIONALIT� DA IMPLEMENTARE
				//Preparo il Dispatcher
				rd = request.getRequestDispatcher("../address.html");
			}
            if (ps.equals("mail")) {
				// Parametro ps assente o vuoto, visualizzo la home page del sito.
				// FUNZIONALIT� DA IMPLEMENTARE
				//Preparo il Dispatcher
				rd = request.getRequestDispatcher("../mailing_list.html");
			}
                //Passo il controllo alla JSP
                rd.forward(request,response);

		} catch(Exception e) {  //Gestisco eventuali eccezioni visualizzando lo stack delle chiamate
			e.printStackTrace();
		}
    }
}

