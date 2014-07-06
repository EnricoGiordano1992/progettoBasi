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
    String medico;

    if (request.getParameter("user") != null)
	    medico = (String)request.getParameter("user");
    else
	    medico = "";


    String iAm = dbms.getMedico(medico); 
%>


<title>PazientePage</title>

<body>

<h2> Benvenuto <%= iAm %> </h2>

<h3> inserire la diagnosi </h3>



</body>
</html>

