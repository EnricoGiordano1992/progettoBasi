<!-- Eseguo gli import necessari -->
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="dbms.*"%>
<%@page import="bean.*"%>
<%@page errorPage="error.jsp"%>

<%@page isErrorPage="false"%>

<% 
    // Genero un oggetto della classe DBMS per gestire l'interzione con la base di dati
    DBMS dbms = new DBMS();
    
    Medico primario = dbms.getPrimario(); 

%>

<html>

<head>

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
					<li class="current_page_item"><a href="?ps=info">Info</a></li>
					<li><a href="?ps=personale">Personale</a></li>
					<li><a href="?ps=patologie">Patologie</a></li>
					<li><a href="?ps=login">Login</a></li>
					
				</ul>
			</div>
			<!-- end #menu -->
		</div>
		<br> <br>


		<div align="center">
			<div class="title">
				<h1>PRESENTAZIONE</h1>
			</div>
		</div>


		<div align="center">
			<div class="title2">
				<h2>PRIMARIO</h2>
			</div>
			<a class="button"><%= "" + primario.getNome() + " " + primario.getCognome() %></a>
			<br><br><br>
		</div>
		<div class="title, style2" style="margin-left:10%;margin-right:10%;" align="center">
			<p>Il reparto di Medicina Generale ha come obiettivo quello di curare i pazienti portatori di patologie internistiche con un approccio globale e rigoroso.</p>
			<img style="width:100%;" src="css/images/pic01.jpg" alt="image#1" />
			<p></p>
			<p>Il Reparto di Medicina &egrave situato al 6&ordm piano dell&prime;Ospedale S. Gibbordano (Blocco D) La dotazione &egrave di 31 posti-letto ubicati in 6 stanze da 2 letti e in 5 stanze da 4 letti tutte con servizio igienico, (tranne una a 2 letti).</p>
			<img style="width:100%;" src="css/images/pic06.jpg" alt="image#1" />
			<p></p>
			<p>In Reparto vi sono poi due locali attrezzati di personal computer per il lavoro medico. In uno di questi &egrave presente anche un lettino per visita medica. Vi &egrave inoltre una stanza per il lavoro infermieristico e una per la Coordinatrice Infermieristica.</p>
			<img style="width:100%;" src="css/images/pic07.png" alt="image#1" />
			<p></p>
			<p>Antistante al Reparto vi sono due ambulatori: uno per lo studio del sistema nervoso autonomo e uno per ecocardiografia.</p>
			<img style="width:100%;" src="css/images/pic08.jpg" alt="image#1" />
			<p></p>
			<p>L&prime;attivit&agrave di Day-Hospital (DH) &egrave svolta al 1&ordm piano dove &egrave situato il DH Generale di tutto l&prime;Ospedale S.Gibbordano.</p>
			<img style="width:100%;" src="css/images/pic09.jpg" alt="image#1" />
			<p></p>
			<br>
		</div>
			
	</div>
	<div id="banner3"></div>
</body>
</html>
