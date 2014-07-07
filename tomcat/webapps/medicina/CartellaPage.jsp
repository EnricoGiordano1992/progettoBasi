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

    if (request.getParameter("cartella") != null)
	    cartella = (String)request.getParameter("cartella");
    else
	    cartella = "";


%>

<% 

	CartellaBean c = new CartellaBean();
	c = dbms.getCartella(cartella);

%>

	<%= c.getCodice() %>	</p>
	<%= c.getData() %>	</p>
	<%= c.getDataDimissione() %>	</p>
	<%= c.getMotivo() %>	</p>
	<%= c.getPrognosi() %>	</p>
