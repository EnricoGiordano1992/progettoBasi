<!-- Eseguo gli import necessari -->
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="dbms.*"%>
<%@page isErrorPage="false" %>
<html>
<% 
    // Genero un oggetto della classe DBMS per gestire l'interzione con la base di dati
    DBMS dbms = new DBMS();

    Vector patologie = new Vector();
    patologie = dbms.getPatologie();
%>


<body>

<% for(int i = 0; i < patologie.size(); i++) { %><br>
patologia: <%= ((PatologieBean)patologie.get(i)).getNomePatologia() %> <%= ((PatologieBean)patologie.get(i)).getICD10() %> , pazienti diagnosticati:  <%= ((PatologieBean)patologie.get(i)).getNumeroPazienti() %>
<%} %>
 
 <br>
 
</body>

