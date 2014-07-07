
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

		PrintWriter out = response.getWriter();
		response.setContentType("text/html; charset=ISO-8859-1");

		//stringa ottenuta dal login paziente
		String p = "";

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

					//Preparo il Dispatcher
					rd = request.getRequestDispatcher("HomePage.html");

			}			


			if (ps.equals("info")) {
				// Parametro ps assente o vuoto, visualizzo la home page del sito.

					//Preparo il Dispatcher
					rd = request.getRequestDispatcher("Info.jsp");

			}			

			if (ps.equals("login")) {
				// Parametro ps assente o vuoto, visualizzo la home page del sito.

					//Preparo il Dispatcher
					rd = request.getRequestDispatcher("Login.html");

			}			

			
			if (ps.equals("cartella")) { 

				String c = request.getParameter("cartella");

				request.setAttribute("cartella",c);
				//Preparo il Dispatcher
				rd = request.getRequestDispatcher("CartellaPage.jsp");
			}

			if (ps.equals("patologie")) { 

				//Preparo il Dispatcher
				rd = request.getRequestDispatcher("PatologiePage.jsp");

			}
			if (ps.equals("personale")) {
				//prendo da ps user e password				
				//Preparo il Dispatcher
				rd = request.getRequestDispatcher("PersonalePage.jsp");

			}

			//Passo il controllo alla JSP
			rd.forward(request,response);

		} catch(Exception e) {  //Gestisco eventuali eccezioni visualizzando lo stack delle chiamate
			e.printStackTrace();
		}
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html; charset=ISO-8859-1");

		//stringa ottenuta dal login paziente
		String p = "";

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

			if (ps.equals("paziente")) { 
				/*
				visualizzo le informazioni di dettaglio del dipartimento
				Delego l'esecuzione della query alla classe di interazione con il DB
				Recupero il risultato della query come bean
				 */

				if (request.getParameter("user") != null && request.getParameter("password") != null) {

					//controllo se user e password sono giusti (vengono passati dal form)
					String user = "";
					String password = "";

					user = request.getParameter("user");
					password = request.getParameter("password");

					p = dbms.PazienteLogin(user, password);			

					if(p.equals(""))
						out.print("<br> <h1>Errore: utente o password non corretti</h1>" +
								"<br> <h2>torna alla <a target=\"\" href=\"home\">HOME</a>");//gestione errore
					else 
						rd = request.getRequestDispatcher("PazientePage.jsp");

				}
			}

			if (ps.equals("medico")) { 
				/*
				visualizzo le informazioni di dettaglio del dipartimento
				Delego l'esecuzione della query alla classe di interazione con il DB
				Recupero il risultato della query come bean
				 */

				if (request.getParameter("user") != null && request.getParameter("password") != null) {

					//controllo se user e password sono giusti (vengono passati dal form)
					String user = "";
					String password = "";

					user = request.getParameter("user");
					password = request.getParameter("password");

					p = dbms.MedicoLogin(user, password);			

					out.print(p);
					if(p.equals(""))
						out.print("<br> <h1>Errore: utente o password non corretti</h1>" +
								"<br> <h2>torna alla <a target=\"\" href=\"home\">HOME</a>");//gestione errore
					else 
						rd = request.getRequestDispatcher("DiagnosiPage.jsp");

				}
			}

			//Passo il controllo alla JSP
			rd.forward(request,response);

		} catch(Exception e) {  //Gestisco eventuali eccezioni visualizzando lo stack delle chiamate
			e.printStackTrace();
		}
	}

}

