
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
    Vector cartelle = dbms.getCartelleDelPaziente(p.getCODSAN());
	Vector rischi = dbms.getRischiDelPaziente(p.getCODSAN());
	Vector medici = dbms.getMediciDelPaziente(p.getCODSAN());
	
%>

<head>

<link href="css/default.css" rel="stylesheet" type="text/css"
	media="all">
<link href="css/font.css" rel="stylesheet" type="text/css" media="all">

</head>

<title>PazientePage</title>

<body>

	<div id="wrapper">
		<div id="header-wrapper">
			<div id="header" class="container">
				<div id="logo">
					<h1>
						<a href="#">Ospedale San Gibbordano</a>
					</h1>
					<p>Divisione ospedaliera di Medicina</p>
				</div>
			</div>
		</div>

		<div id="menu-wrapper">
			<div id="menu" class="container">
				<ul>
					<li><a href="?">Homepage</a></li>
					<li><a href="?ps=info">Info</a></li>
					<li><a href="?ps=personale">Personale</a></li>
					<li><a href="?ps=patologie">Patologie</a></li>
					<li class="current_page_item"><a href="?ps=login">Login</a></li>

				</ul>
			</div>
			<!-- end #menu -->
		</div>
		<br> <br>


		<div align="center">
			<div class="title">
				<h1>PAGINA PERSONALE</h1>
			</div>
		</div>




		<div align="center">
			<div class="title2">
				<h2>PAZIENTE</h2>
			</div>
			<h1>
				<a class="icon icon-arrow-right button"><%= p.getCODSAN() %></a>
			</h1>
		</div>

		<div id="page" class="container">
			<div id="content">
				<div class="title">
					<h2>DATI DI REPARTO</h2>
					<span class="byline">Cliccare sulla cartella per accedere alle
						singole cartelle cliniche</span>
				</div>
				<p>
					Medici che hanno diagnosticato il paziente:
					<strong><%= medici.size() %></strong></p>
				<% 
if(medici.size() > 0) {
	for(i = 0; i < medici.size(); i++) {
%>
				<strong><p><%= medici.get(i) %></p></strong>
				<% }
}
	else {%>

				<p>Il paziente non e' stato diagnosticato da medici
					dell'ospedale</p>

				<% } %>



				<% 
if(cartelle.size() > 0) {
	for(i = 0; i < cartelle.size(); i++) {
%>
				<p>
					<a class="icon icon-arrow-right button2"
						href="?ps=cartella&cartella=<%= ((CartellaBean)cartelle.get(i)).getCodice() %>">
						<%= ((CartellaBean)cartelle.get(i)).getCodice() %>
					</a>
					(<%= ((CartellaBean)cartelle.get(i)).getData() %>
					-
					<%= ((CartellaBean)cartelle.get(i)).getDataDimissione() %>)
				</p>
				<% }
}
	else {%>

				<p>Il paziente non ha cartelle cliniche</p>

				<% } %>

			</div>

			<div id="sidebar">
				<div class="box2">
					<div class="title">
						<h2>dati personali</h2>
					</div>
					<ul class="style2">
						<li>Nome: <strong><%= p.getNome()  %></strong>
						<li>Cognome: <strong><%= p.getCognome()  %></strong>
						<li>Nascita: <strong><%= p.getNascita()  %></strong>
						<li>Citta': <strong><%= p.getCitta()  %></strong>
						<li>Via: <strong><%= p.getVia()  %></strong>
						<li>Provincia: <strong><%= p.getProv()  %></strong>
						<li>CAP: <strong><%= p.getCap()  %></strong>
						<li>Civico: <strong><%= p.getCivico()  %></strong>
						<li>Rischi del paziente: <strong><% 
if(rischi.size() > 0) {
	for(i = 0; i < rischi.size(); i++) {
%> <br><%= rischi.get(i) %> <% }
}	else {%> <br>Il paziente non ha fattori a rischio <% } %></strong>
					</ul>
				</div>
			</div>


		</div>



	</div>

</body>
</html>



