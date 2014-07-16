<%@ page isErrorPage="true" import="java.io.*" contentType="text/html"%>

<%@ page 
    pageEncoding="UTF-8"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="css/default.css" rel="stylesheet" type="text/css"
	media="all">
<link href="css/font.css" rel="stylesheet" type="text/css" media="all">

</head>

<title>Errore</title>
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
					<li><a href="home?">Homepage</a></li>
					<li><a href="home?ps=info">Info</a></li>
					<li><a href="home?ps=personale">Personale</a></li>
					<li ><a href="home?ps=patologie">Patologie</a></li>
					<li><a href="home?ps=login">Login</a></li>

				</ul>
			</div>
			<!-- end #menu -->
		</div>
		<br> <br>


		<div align="center">
			<div class="title">
				<h1>PAGINA DI ERRORE</h1>
			</div>
		</div>

<div align="center">
<p>Message:
<%=exception.getMessage()%></p>
<br><br><br><br><br><br><br><br>
StackTrace:
<%
	StringWriter stringWriter = new StringWriter();
	PrintWriter printWriter = new PrintWriter(stringWriter);
	exception.printStackTrace(printWriter);
	out.println(stringWriter);
	printWriter.close();
	stringWriter.close();
%>

</div>
</body>
</html>