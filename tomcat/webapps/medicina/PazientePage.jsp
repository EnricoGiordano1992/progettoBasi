<!--	Corsi.jsp: 
	La JSP visualizza la lista di tutti i corsi di studio attivi e gestiti da un
	diparitmento passato come parametro idDip.
-->

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
    String paziente;

    if (request.getParameter("user") != null)
	    paziente = (String)request.getParameter("user");
    else
	    paziente = "";


    PazienteBean p = dbms.getPaziente(paziente); 
%>


<title>PazientePage</title>

<body>


<%= p.getNome()  %>
<%= p.getCognome()  %>

<a href="?ps=cartella&cartella=<%= p.getCODSAN() %>"> <%= p.getCODSAN() %> </a>

</body>
</html>

