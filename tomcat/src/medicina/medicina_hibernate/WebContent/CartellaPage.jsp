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
	
	Vector terapie = dbms.getTerapieCartella(c.getCodice());
	Vector diagnosi = dbms.getDiagnosiCartella(c.getCodice());

%>

	<%= c.getCodice() %>	</p>
	<%= c.getData() %>	</p>
	<%= c.getDataDimissione() %>	</p>
	<%= c.getMotivo() %>	</p>
	<%= c.getPrognosi() %>	</p>

<%= terapie.size() %>
<%= diagnosi.size() %>

<% 
for (i = 0; i<terapie.size(); i++ ) {
%>

	<%= ((CartellaBean) terapie.get(i)).getTerapie_farmaco() %>	</p>

	
	<% } 
for (i = 0; i<diagnosi.size(); i++ ) {
%>

	<%= ((CartellaBean) diagnosi.get(i)).getDiagnosi_patologia() %>	</p>
	
	
<%} %>	
	