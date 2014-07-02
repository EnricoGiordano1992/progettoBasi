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
<%! String nome = ""; %>
<%! String nomePrec = ""; %>
<html>


<% 
            Vector iddid = (Vector) request.getAttribute("insegn");
            
            InsErogatoBean iddidb;
%>

<title>Corsi di Studio Esistenti</title>
<link rel="stylesheet" type="text/css" href="../pagina.css" />
<body>

    <h2>INSEGNAMENTI: </h2><br>

<hr align="left" size="5" width="100%" color="blue" noshade>

<% for (int i = 0; i < iddid.size(); i++)
{
        iddidb = (InsErogatoBean) iddid.get(i); 
        nome = iddidb.getNomeFromInsegn();
%>

<ul>

<% if (!nome.equals(nomePrec))
    {
%>
<hr align="left" size="1" width="100%" color="yellow" noshade>

    <li> <b> Codice: </b> <%= iddidb.getCodiceFromInsegn() %> </li>

    <li> <b> Nome:</b> <%= iddidb.getNomeFromInsegn() %> </li>

    <li> <b> Crediti:</b> <%= iddidb.getCreditiFromInsErogato() %> </li>


<% 
     }

    if ( iddidb.getNomeModuloFromInsErogato() != null )
    { 

    %>


        <li> <b> Nome Modulo:</b> <%= iddidb.getNomeModuloFromInsErogato() %>  </li>    

        <li> <b> CreditiModulo:</b> <%= iddidb.getCreditiModFromInsErogato() %> </li>

<%   }

%>
    </ul>

<%  nomePrec = nome;  } %>


<a href=?ps> Home </a>
</body>
</html>
