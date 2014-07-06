
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

<a href="?ps=cartella&cartella=<%= p.getIdCartelle() %>"> <%= p.getIdCartelle() %> </a>

</body>
</html>

