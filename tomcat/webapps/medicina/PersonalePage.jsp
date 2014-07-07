<!-- Eseguo gli import necessari -->
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="dbms.*"%>
<%@page isErrorPage="false" %>
<html>
<% 
    // Genero un oggetto della classe DBMS per gestire l'interzione con la base di dati
    DBMS dbms = new DBMS();

    Vector p = dbms.getPersonaleMedico(); 
%>

<%= ((PersonaleBean)p.get(0)).getNome() %> <%= ((PersonaleBean)p.get(0)).getCognome() %>