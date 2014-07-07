<!-- CARTELLA PAGE -->

<!-- Eseguo gli import necessari -->
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="dbms.*"%>
<%@page errorPage="error.jsp"%>
<%@page isErrorPage="false" %>
<html>
<% 
    // Genero un oggetto della classe DBMS per gestire l'interzione con la base di dati
    DBMS dbms = new DBMS();
    String cartella;
	int i;

    if (request.getParameter("cartella") != null)
	    cartella = (String)request.getParameter("cartella");
    else
	    cartella = "";


%>

<% 

	CartellaBean c = new CartellaBean();
	c = dbms.getCartella(cartella);
	
	Vector terapie = new Vector();
	Vector diagnosi = new Vector();

%>

	<%= c.getCodice() %>	</p>
	<%= c.getData() %>	</p>
	<%= c.getDataDimissione() %>	</p>
	<%= c.getMotivo() %>	</p>
	<%= c.getPrognosi() %>	</p>

<% 
for (i = 0; i<terapie.size()-1; i++ ) {
%>

	<%= ((CartellaBean) terapie.get(i)).getTerapie_farmaco() %>	</p>

	
	<% } 
for (i = 0; i<diagnosi.size()-1; i++ ) {
%>

	<%= ((CartellaBean) diagnosi.get(i)).getDiagnosi_patologia() %>	</p>
	
	
<%} %>	
	