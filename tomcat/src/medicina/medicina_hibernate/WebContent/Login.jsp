<%@page errorPage="error.jsp"%>
<%@page isErrorPage="false"%>
<%@page import="java.util.*"%>

<html>


<title>Login</title>

<head>

<link href="css/default.css" rel="stylesheet" type="text/css"
	media="all">
<link href="css/font.css" rel="stylesheet" type="text/css" media="all">

 <%  
 	int error = 0;
	 if (request.getAttribute("error") != null)
 		error = ((Integer)request.getAttribute("error"));
 
 %>
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
					<li class="current_page_item"><a href="?ps=login">Login</a></li>

				</ul>
			</div>
			<!-- end #menu -->
		</div>
		<br>
		<br>

		<br>
		<br>
		<br>
		<br>
		<br>

		<% if(error != 0) {
		
				switch(error){
				
				case 10: 
				
		%>
				
		<div align="center">
			<div class="title" style="color:Crimson;width:px;border-style:outset;background-color:Cornsilk;border-color:Red;margin:1ex;font-family:Courier 10 Pitch;padding:6;">
				<h1>Errore: <br>codice sanitario o password del paziente non corretti <br>
				</h1>
			</div>
		</div>
		
		<%		
					break;
					
				case 20:
		%>	
					<div align="center">
					<div class="title" style="color:Crimson;width:px;border-style:outset;background-color:Cornsilk;border-color:Red;margin:1ex;font-family:Courier 10 Pitch;padding:6;">
				<h1>Errore: <br>id o password del medico non corretti <br>
				</h1>
					</div>
				</div>

			<%		break;
				default:
					break;
				}
		}
		%>



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

