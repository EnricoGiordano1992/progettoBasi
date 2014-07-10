<!-- CARTELLA PAGE -->

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
    String cartella;
	int i;

    if (request.getParameter("cartella") != null)
	    cartella = (String)request.getParameter("cartella");
    else
	    cartella = "";


%>

<% 

	CartellaBean c = new CartellaBean();
	c = dbms.getCartella(cartella);
	
	Vector terapie = dbms.getTerapieCartella(c.getCodice());
	Vector diagnosi = dbms.getDiagnosiCartella(c.getCodice());

%>
<title>Cartella - <%= c.getCodice() %></title>

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
					<li><a href="/medicina/home">Homepage</a></li>
					<li><a href="?ps=info">Info</a></li>
					<li><a href="?ps=personale">Personale</a></li>
					<li><a href="?ps=patologie">Patologie</a></li>
					<li><a href="?ps=login">Login</a></li>

				</ul>
			</div>
			<!-- end #menu -->
		</div>
		<br> <br>
		<div align="center">
			<div class="title2">
				<h2>CARTELLA</h2>
			</div>
			<a class="button"><%= c.getCodice() %></a>
			<br><br><br>
		</div>
		
		<div style="float:left; width:50%;" align="right">
			<h2 style="display:inline;">DATA RICOVERO</h2>
		</div>
		<div style="float:left; width:50%;" align="left">
			<a class="button" style="margin-top:0px;background-color:#000000;"><%= c.getCodice() %></a>
		</div>
		<br><br>
		<div style="float:left; width:50%;" align="right">
			<h2 style="display:inline;">DATA DIMISSIONE</h2>
		</div>
		<div style="float:left; width:50%;" align="left">
			<a class="button" style="margin-top:0px;background-color:#000000;"><%= c.getDataDimissione() %></a>
		</div>
		<br><br>
		<div style="float:left; width:50%;" align="right">
			<h2 style="display:inline;">MOTIVO</h2>
		</div>
		<div style="float:left; width:50%;" align="left">
			<a class="button" style="margin-top:0px;background-color:#000000;"><%= c.getMotivo() %></a>
		</div>
		<br><br>
		<div style="float:left; width:50%;" align="right">
			<h2 style="display:inline;">PROGNOSI</h2>
		</div>
		<div style="float:left; width:50%;" align="left">
			<a class="button" style="margin-top:0px;background-color:#000000;"><%= c.getPrognosi() %></a>
		</div>
		<div style="clear:both">
			<br><br><br>
			<% 
			for (i = 0; i<terapie.size()-1; i++ ) {
			%>

				<%= ((CartellaBean) terapie.get(i)).getTerapie_farmaco() %>	</p>

	
				<% } 
			for (i = 0; i<diagnosi.size()-1; i++ ) {
			%>

				<%= ((CartellaBean) diagnosi.get(i)).getDiagnosi_patologia() %>	</p>
	

			<%} %>	
			
		
			<div id="banner3" style="background-color:#3CB371;"></div>
		</div>
</body>
	


	
