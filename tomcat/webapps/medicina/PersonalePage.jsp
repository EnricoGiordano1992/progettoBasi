<!-- Eseguo gli import necessari -->
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="dbms.*"%>
<%@page isErrorPage="false"%>

<% 
    // Genero un oggetto della classe DBMS per gestire l'interzione con la base di dati
    DBMS dbms = new DBMS();

    Vector p = dbms.getPersonaleMedico(); 
    Vector spec = new Vector();
    
    PrimarioBean primario = dbms.getPrimarioSpec();
    Vector specPrimario = dbms.getSpecializzazioni(primario.getId());
%>


<html>

<head>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="css/default.css" rel="stylesheet" type="text/css"
	media="all">
<link href="css/font.css" rel="stylesheet" type="text/css" media="all">

</head>
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
					<li class="current_page_item"><a href="?ps=personale">Personale</a></li>
					<li><a href="?ps=patologie">Patologie</a></li>
					<li><a href="?ps=login">Login</a></li>

				</ul>
			</div>
			<!-- end #menu -->
		</div>
		<div id="banner"></div>
		<br> <br>


		<div align="center">
			<div class="title">
				<h1>PERSONALE</h1>
			</div>
		</div>


		<div align="center">
			<div class="title2">
				<h2>PRIMARIO</h2>
			</div>
			<a class="icon icon-arrow-right button"></a> <br> <br>


			<h1>
				<%= primario.getNome() %>
				<%= primario.getCognome() %>
			</h1>

			<br>
			specializzato in
			<br>
			<% for (int i=0; i < specPrimario.size() ; i++) {%>
			<br>
			<h3><%= ((PersonaleBean)specPrimario.get(i)).getSpecializzazioni() %></h3>

			<%} %>

			<br> <br> <a class="icon icon-arrow-right button"></a> <br>
			<br> <br> <br> <br>


			<div class="title">
				<h2>PERSONALE MEDICO</h2>
			</div>


			<div id="portfolio-wrapper-div">
				<div id="portfolio" class="container">

					<% for (int i=0; i < p.size() ; i++) {

	spec = dbms.getSpecializzazioni(((PersonaleBean)p.get(i)).getId());
	
	if( i%5 != 0) {
%>

					<div id="column<%= i%5 %>">
						<div class="title">
							<br>
							<h2><%= ((PersonaleBean)p.get(i)).getNome() %>
								<%= ((PersonaleBean)p.get(i)).getCognome() %></h2>
						</div>

						inizio attivita':
						<br>
						<a class="icon icon-arrow-right button" background="#000000">
						<%= ((PersonaleBean)p.get(i)).getInizio() %>
						</a>
						<br>
						<br>

						numero diagnosi effettuate:
						<br>
						<a class="icon icon-arrow-right button" background="#000000">
						<%= ((PersonaleBean)p.get(i)).getDiagnosi() %>
						</a>
						<br>
						<br>

						<% if (((PersonaleBean)p.get(i)).getNome().charAt(((PersonaleBean)p.get(i)).getNome().length()-1) == 'a'){ %>
						specializzata in:
						<%}  else {%>
						specializzato in:
						
						<%} %>
						
						<a class="icon icon-arrow-right button" background="#000000">
						
						<% for (int j=0; j < spec.size() ; j++) { %>
						<br><%= ((PersonaleBean)spec.get(j)).getSpecializzazioni() %><br>
						<%} %>
						</a>
						<br>
						<br>
					</div>

					<%} else {%>

				</div>
			</div>
			<div id="footer-wrapper-div">
				<div id="footer" class="container"></div>
			</div>
		</div>

	</div>
	<div id="portfolio-wrapper-div">
		<div id="portfolio" class="container">


			<%} %>
			<%} %>

		</div>
	</div>
	<div id="footer-wrapper-div">
		<div id="footer" class="container"></div>
	</div>

	</div>
	</div>



</body>
</html>





