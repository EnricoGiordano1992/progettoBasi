<!-- CARTELLA PAGE -->

<!-- Eseguo gli import necessari -->
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="dbms.*"%>
<%@page import="bean.*"%>
<%@page errorPage="error.jsp"%>
<%@page isErrorPage="false"%>
<html>
<%
	// Genero un oggetto della classe DBMS per gestire l'interzione con la base di dati
	DBMS dbms = new DBMS();
	String cartella;
	int i;

	if (request.getParameter("cartella") != null)
		cartella = (String) request.getParameter("cartella");
	else
		cartella = "";
%>

<%
	CartellaClinica c = new CartellaClinica();
	c = dbms.getCartella(cartella);

	ArrayList<Terapie> terapie = dbms.getTerapieCartella(c.getId());
	ArrayList<Diagnosi> diagnosi = dbms.getDiagnosiCartella(c.getId());
	
	ArrayList<Conferme> conferme;
	ArrayList<Contraddizioni> contraddizioni;
%>
<title>Cartella - <%=c.getId()%></title>

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
			<a class="button"><%=c.getId()%></a> <br> <br> <br>

			<div style="float: left; width: 50%;" align="right">
				<h2 style="display: inline;">DATA RICOVERO</h2>
			</div>
			<div style="float: left; width: 50%;" align="left">
				<a class="button"
					style="margin-top: 0px; background-color: #000000;"> <%=c.getDataRicovero()%></a>
			</div>
			<br> <br>
			<div style="float: left; width: 50%;" align="right">
				<h2 style="display: inline;">DATA DIMISSIONE</h2>
			</div>
			<div style="float: left; width: 50%;" align="left">
				<a class="button"
					style="margin-top: 0px; background-color: #000000;"> 
					
					<% if(c.getDataDimissione().equals("")) { %>
						nessuna, paziente ricoverato </a>
					
					<%} else  {%>	
					<%=c.getDataDimissione()%></a>
					
					<% } %>
			</div>
			<br> <br>
			<div style="float: left; width: 50%;" align="right">
				<h2 style="display: inline;">MOTIVO</h2>
			</div>
			<div style="float: left; width: 50%;" align="left">
				<a class="button"
					style="margin-top: 0px; background-color: #000000;"> <%=c.getMotivo()%></a>
			</div>
			<br> <br>
			<div style="float: left; width: 50%;" align="right">
				<h2 style="display: inline;">PROGNOSI</h2>
			</div>
			<div style="float: left; width: 50%;" align="left">
				<a class="button"
					style="margin-top: 0px; background-color: #000000;"> 
					
					<%if(c.getPrognosi().equals("")) { %>
						non e' stata ancora decisa la prognosi </a>
					
					<% } else { %>
						<%=c.getPrognosi()%></a>
						
					<% } %>
			</div>
			
				<br> <br> <br> <br> <br> <br>
			<div style="float: center; width: 50%;" align="center">
				<h2 style="display: inline;">TERAPIE: <%= terapie.size() %></h2>
			</div>
			
			<div style="float: center; width: 50%;" align="center">
			
				<%
					for (i = 0; i < terapie.size() ; i++) {
				%>
				<p>
				<a class="button"
					style="margin-top: 0px; background-color: #000000;">
					farmaco prescritto: <%=terapie.get(i).getId().getFarmaco() %><br>
					dose del farmaco: <%=terapie.get(i).getId().getDose() %><br>
					posologia: <%=terapie.get(i).getId().getFrequenza() %><br>
					inizio cura: <%=terapie.get(i).getId().getInizio() %><br>
					fine cura: <%=terapie.get(i).getId().getFine() %><br>
					</a>
				</p>

			
				<% } %>
				
				</div>

				<br> <br> <br>
			<div style="float: center; width: 50%;" align="center">
				<h2 style="display: inline;">DIAGNOSI EFFETTUATE: <%= diagnosi.size() %></h2>
			</div>
			
			<div style="float: center; width: 50%;" align="center">
			
				<%
					for (i = 0; i < diagnosi.size(); i++) {
				%>
				<p>
				<a class="button"
					style="margin-top: 0px; background-color: #000000;">
					data: <%=diagnosi.get(i).getId().getData() %><br>
					
					medico:  
					<%= diagnosi.get(i).getMedico().getNome() %> <%= diagnosi.get(i).getMedico().getCognome() %><br>
 					patologia: <%=diagnosi.get(i).getPatologia() %><br>
					ICD10: <%=diagnosi.get(i).getIcd10() %><br>
					<br><br>
					sintomi che confermano la patologia: <%=diagnosi.get(i).getConfermes().size() %><br><br>
					
				<%
				
					for (int j = 0; j < diagnosi.get(i).getConfermes().size(); j++) {
				%>
					
					<%= ((Conferme)diagnosi.get(i).getConfermes().toArray()[j]).getSintomi().getId().getNome() %><br>
					
					<% } %>
					
										<br><br>
					sintomi che contraddicono la patologia: <%=diagnosi.get(i).getContraddizionis().size() %><br><br>
					
				<%
				
					for (int j = 0; j < diagnosi.get(i).getContraddizionis().size(); j++) {
				%>
					
					<%= ((Contraddizioni)diagnosi.get(i).getContraddizionis().toArray()[j]).getSintomi().getId().getNome() %><br>
					
					<% } %>
					
					
					</a>
				</p>

			
				<% } %>
				
				</div>

				<div id="portfolio-wrapper-div">
					<div id="portfolio" class="container"></div>
				</div>
				<div id="footer-wrapper-div">
					<div id="footer" class="container"></div>
				</div>
			</div>
		</div>
	</div>
	</div>
</body>
</html>