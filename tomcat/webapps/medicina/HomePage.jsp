<!-- HOMEPAGE -->

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
    
<% 
            String primario = dbms.getPrimario(); %>

<%
            IdDidBean iddidb;
%>

<title>HomePage</title>

<body>


    <h1> Ospedale San Gibbordano </h1> <br>
    <h2> Divisione ospedaliera di Medicina </h2><br>

    <h3> Primario <%= primario %> </h3>

	<form action="paziente" target="PazientePage.jsp">
	Codice Sanitario: <input type="text" name="user"><br>
	Password: <input type="password" name="password">
	<br>
	<input type="submit">
	</form>


	<form action="medico" target="DiagnosiPage.jsp">
	ID medico: <input type="text" name="user"><br>
	Password: <input type="password" name="password">
	<br>
	<input type="submit">
	</form>


</body>
</html>
