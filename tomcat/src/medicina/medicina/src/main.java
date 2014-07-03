
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import dbms.*;
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

				//recupero il nome del primario dal database
				String primario = dbms.getPrimario();

				//Aggiungo la stringa come attributo della richiesta HTTP
				request.setAttribute("primario",primario);

				//Preparo il Dispatcher
				rd = request.getRequestDispatcher("../Homepage.jsp");
			}			

			if (ps.equals("paziente")) { 
				/*
				visualizzo le informazioni di dettaglio del dipartimento
				Delego l'esecuzione della query alla classe di interazione con il DB
				Recupero il risultato della query come bean
				*/

				//passiamo il bean alla jsp
				PazienteBean p = dbms.getPaziente("bi", "bo");;

				//Aggiungo il Vector come attributo della richiesta HTTP
				request.setAttribute("info",p);

				//Preparo il Dispatcher
				rd = request.getRequestDispatcher("../PazientePage.jsp");	
			}

			if (ps.equals("cartella")) { 

				//passiamo il bean alla jsp
				CartellaBean c = dbms.getCartella("bi");

				//Aggiungo il Vector come attributo della richiesta HTTP
				request.setAttribute("info",c);
				//Preparo il Dispatcher
				rd = request.getRequestDispatcher("../CartellaPage.jsp");
			}

			if (ps.equals("patologie")) { 

				//passiamo il bean alla jsp
				Vector patologie = dbms.getPatologie();

				request.setAttribute("patologie",patologie);

				//Preparo il Dispatcher
				rd = request.getRequestDispatcher("../PatologiePage.jsp");

			}
			if (ps.equals("personale")) {

				//passiamo il bean alla jsp
				Vector personale = new Vector();
				
				personale.add(dbms.getPrimarioSpec());
				
				for(int i = 0; i < dbms.getPersonaleMedico().size(); i++)
					personale.add(dbms.getPersonaleMedico().get(i));

				request.setAttribute("persone",personale);

			}

			//Passo il controllo alla JSP
			rd.forward(request,response);

		} catch(Exception e) {  //Gestisco eventuali eccezioni visualizzando lo stack delle chiamate
			e.printStackTrace();
		}
	}
}

