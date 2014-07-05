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
    if (request.getParameter("paziente") != null) // Ottengo se presente il parametro 'idDip'
	    paziente = (String)request.getParameter("paziente");
    else
	    paziente = "";

    //A seconda della presenza o meno del parametro la JSP varia il proprio comportamento
    if (paziente.equals("")) {  //parametro vuoto o assente: messaggio d'errore

%> 
	    <h2>Inserire il codice per gestire la mancanza del parametro idDip</h2>
       

<%
    } else { 
%>

<%          PazienteBean p = dbms.getPaziente(paziente); %>


<title>PazientePage</title>

<body>

qui si fanno tutti i get


</body>
</html>

