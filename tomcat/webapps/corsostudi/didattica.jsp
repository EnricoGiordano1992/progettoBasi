<!--	Corsi.jsp: 
	La JSP visualizza la lista di tutti i corsi di studio attivi e gestiti da un
	diparitmento passato come parametro idDip.
-->

<!-- Eseguo gli import necessari -->
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="did.*"%>
<%@page errorPage="error.jsp"%>
<%@page isErrorPage="false" %>
<html>


<% 
            Vector iddid = (Vector) request.getAttribute("did");
//DBMS dbms = new DBMS();
//Vector iddid = dbms.getIdDid(30);
String cod="";
            String id_corso = (String) request.getAttribute("cod");

            IdDidBean iddidb;
%>

<title>Corsi di Studio Esistenti</title>
<link rel="stylesheet" type="text/css" href="../pagina.css" />
<body>

    <% iddidb = (IdDidBean) iddid.get(0); %>

    <h1>Corsi di studio attivi gestiti dal dipartimento ''<%= iddidb.getNomeDip() %>'' </h1> <br>
    <h2>CORSI DI LAUREA: </h2><br>


<% for (int i = 0; i < iddid.size(); i++)
{
    if(i != 0)
        iddidb = (IdDidBean) iddid.get(i); 

    //cerco le lauree
    if((iddidb.getId_tipocs() == 5 || iddidb.getId_tipocs() == 20 ) &&(iddidb.getCreditiTot() > 1 && iddidb.getNumIns() > 1)) {    
%>

    
     <% cod=iddidb.getCodice(); %>

     <%= cod %> - <%= iddidb.getNomeCorso() %> 

    <ul>
    
    <li> <b> Durata anni: </b> <%= iddidb.getDurata() %> </li>

    <li> <b>Sede:</b> <%= iddidb.getSede() %> </li>

    <li> <b>Presentazione:</b> <br><br><%= iddidb.getInformativa() %> </li>

    <li> <b>Numero insegnamenti attivi nell'anno 2013/2014:</b> <%= iddidb.getNumIns() %> </li>

    <li> <b>Numero totale crediti erogati nell'anno 2013/2014:</b> <%= iddidb.getCreditiTot() %> </li>

    <li> <a href="?ps=insegn&id=<%=cod%> " >ELENCO INSEGNAMENTI </a></li>

    </ul>
        <% }} %>


    <h2>CORSI DI LAUREA MAGISTRALE: </h2><br>


<% for (int i = 0; i < iddid.size(); i++)
{
    iddidb = (IdDidBean) iddid.get(i);

    //cerco le lauree magistrali     
    if((iddidb.getId_tipocs() == 25 || iddidb.getId_tipocs() == 23)  &&(iddidb.getCreditiTot() > 1 && iddidb.getNumIns() > 1)) {
%>

     <%= iddidb.getCodice() %> - <%= iddidb.getNomeCorso() %> 

    <ul>
    
    <li> <b> Durata anni: </b> <%= iddidb.getDurata() %> </li>

    <li> <b>Sede:</b> <%= iddidb.getSede() %> </li>

    <li> <b>Presentazione:</b> <br><br><%= iddidb.getInformativa() %> </li>

    <li> <b>Numero insegnamenti attivi nell'anno 2013/2014:</b> <%= iddidb.getNumIns() %> </li>

    <li> <b>Numero totale crediti erogati nell'anno 2013/2014:</b> <%= iddidb.getCreditiTot() %> </li>

    <li> <a href="?ps=insegn&id=<%=iddidb.getCodice()%> " >ELENCO INSEGNAMENTI </a></li>

    </ul>
        <% }} %>



    <h2>CORSI DI DOTTORATO: </h2>


<% for (int i = 0; i < iddid.size(); i++)
{
     iddidb = (IdDidBean) iddid.get(i); 

    //cerco i dottorati
    if(iddidb.getId_tipocs() == 14 ) {     
%>


     <%= iddidb.getCodice() %> - <%= iddidb.getNomeCorso() %> 

    <ul>
    
    <li> <b> Durata anni: </b> <%= iddidb.getDurata() %> </li>

    <li> <b>Sede:</b> <%= iddidb.getSede() %> </li>

    <li> <b>Presentazione:</b> <br><br><%= iddidb.getInformativa() %> </li>

    </ul>
        <% }} %>



<a href=?ps> Home </a>
</body>
</html>
