<!-- HOMEPAGE -->

<!-- Eseguo gli import necessari -->
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="dbms.*"%>
<%@page isErrorPage="false"%>
<html>
<% 
    // Genero un oggetto della classe DBMS per gestire l'interzione con la base di dati
    DBMS dbms = new DBMS();
    
    String primario = dbms.getPrimario(); 

%>


<title>HomePage</title>

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
					<li class="current_page_item"><a href="#">Homepage</a></li>
					<li><a href="?ps=info">Info</a></li>
					<li><a href="?ps=personale">Personale</a></li>
					<li><a href="?ps=patologie">Patologie</a></li>
				</ul>
			</div>
			<!-- end #menu -->
		</div>
		<div id="banner"></div>
		<br>
		<br>

		<div align="center">
			<div class="title2">
				<h2>PRIMARIO</h2>
			</div>
			<a class="icon icon-arrow-right button"><%= primario %></a>

		</div>

		<br>
		<br>
		<br>
		<br>
		<br>



		<div class="title" align="center">
			<h2>LOGIN PAZIENTE</h2>
		</div>
		<form action="?ps=paziente" method="post" class="dark-matter">
			Codice Sanitario: <input type="text" name="user"><br>
			Password:
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
				type="password" name="password" class="textarea"> <br>
			<input type="submit" class="button">
		</form>

		<br>
		<br>
		<br>


		<div class="title" align="center">
			<h2>LOGIN MEDICO</h2>
		</div>
		<form action="?ps=medico" method="post" class="dark-matter">
			ID medico: <input type="text" name="user"><br> Password:
			<input type="password" name="password" class="textarea"> <br>
			<input type="submit" class="button">
		</form>

		<br> <br> <br>
	</div>
	</div>
	<div id="banner2"></div>
	
</body>
</html>

