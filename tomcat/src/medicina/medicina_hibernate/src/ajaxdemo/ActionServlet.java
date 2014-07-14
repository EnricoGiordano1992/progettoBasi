package ajaxdemo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dbms.*;
import bean.*;

/**
 * Servlet implementation class ActionServlet
 */

public class ActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public ActionServlet() {
		// TODO Auto-generated constructor stub
	}


	protected void doGet(HttpServletRequest request,   HttpServletResponse response) throws ServletException, IOException {

		String paziente=request.getParameter("paziente");
		Map<String, String> c = new LinkedHashMap<String, String>();
		DBMS dbms = new DBMS();

		ArrayList<CartellaClinica> cartelle = dbms.getCartelleDelPaziente(paziente);

		for(int i = 0; i < cartelle.size(); i++)
			c.put(cartelle.get(i).getId(), cartelle.get(i).getId() + " ( " + cartelle.get(i).getDataRicovero() + " <> " + cartelle.get(i).getDataDimissione() + " )");

		String json = null ;
		json= new Gson().toJson(c);   

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);       
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}