
<!-- Eseguo gli import necessari -->
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="dbms.*"%>
<%@page isErrorPage="false"%>
<html>
<% 
    // Genero un oggetto della classe DBMS per gestire l'interzione con la base di dati
    DBMS dbms = new DBMS();
    String paziente;
    int i;

    if (request.getParameter("user") != null)
	    paziente = (String)request.getParameter("user");
    else
	    paziente = "";

    
    PazienteBean p = dbms.getPaziente(paziente);
    Vector cartelle = new Vector();

    cartelle = dbms.getCartelleDelPaziente(p.getCODSAN());
     
%>


<title>PazientePage</title>

<body>


	Nome: <%= p.getNome()  %>
	<br>
	Cognome: <%= p.getCognome()  %>
	<br>

<% 
if(cartelle.size() > 0) {
	for(i = 0; i < cartelle.size()-1; i++) {
%>
	<br>
	<a href="?ps=cartella&cartella=<%= cartelle.get(i) %>"> <%= cartelle.get(i) %>
	<br>
	</a>

<% }
}
	else {%>

<h3>Il paziente non ha cartelle cliniche</h3>

<% } %>
</body>
</html>

