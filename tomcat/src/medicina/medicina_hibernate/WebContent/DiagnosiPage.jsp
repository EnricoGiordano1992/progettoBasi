<!-- DIAGNOSI PAGE -->

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
    String medico;

    if (request.getParameter("user") != null)
	    medico = (String)request.getParameter("user");

    else if (request.getParameter("medico") != null)
	    medico = (String)request.getParameter("medico");

    else
	    medico = "";

    Medico iAm = dbms.getMedico(medico);
    ArrayList<Paziente> pazienti = dbms.getTuttiPazienti();
%>


<head>


<script type="text/javascript">
// Funzione che permette di aggiungere elementi al form (ESEMPIO 1)
var j = 1;
var old_j = 0;
var k = 0;

var arrayString = new Array();
var arrayCheckConferma = new Array();
var arrayCheckContraddizione = new Array();
var arrayIntensitaB = new Array();
var arrayIntensitaM = new Array();
var arrayIntensitaA = new Array();

function aggiornaString (stringa, pos) {

	arrayString[pos] = "value = '" + stringa.value + "'";
}

function aggiornaCheckConferma(pos) {

	arrayCheckConferma[pos] = "checked";
	arrayCheckContraddizione[pos] = "";
}

function aggiornaCheckContraddizione(pos) {

	arrayCheckContraddizione[pos] = "checked";
	arrayCheckConferma[pos] = "";
}


function deletePos(pos) {

	arrayCheckContraddizione[pos] = null;
	arrayCheckConferma[pos] = null;
	arrayString[pos] = null;
	arrayIntensitaB[pos] = null;
	arrayIntensitaM[pos] = null;
	arrayIntensitaA[pos] = null;
	
}


function aggiornaIntensita(stringa, pos) {

	var valore = stringa.value;
	if(valore == "bassa")
		arrayIntensitaB[pos] = "selected ='selected' ";
	else if (valore == "media")
		arrayIntensitaM[pos] = "selected ='selected' ";
	else
		arrayIntensitaA[pos] = "selected ='selected' ";
	
}

function AggiungiRiga(){
	var numero_righe = j++;
	var box = document.getElementById('box_righe');
	if(isNaN(numero_righe)==true){
		box.innerHTML='';
	}else{
	    var righe = "";
		// Inserisco una riga ad ogni ciclo
		for(var i=1; i<=numero_righe; i++){
			k=i+1;

			righe = righe+"<br>Sintomo "+(k) +" : <input type=button onclick='EliminaRiga(" + k + ")' value=X class=button><br><br>" +"<input type='text' " + arrayString[k] + " name='sintomo"+k+"' onkeyup='aggiornaString(this, " + k + ")'  />" +
			"<br> <input type='radio' name='tipo" + k + "' value='conferma' onclick='aggiornaCheckConferma("+ k + ")' " + arrayCheckConferma[k] + ">Conferma "+
			"<input type='radio' name='tipo" + k + "' value='contraddizione' onclick='aggiornaCheckContraddizione("+ k + ")' " + arrayCheckContraddizione[k] +">Contraddizione <br/>" +
			"<br>Intensità "+ k + ": <br><select name='intensita" + k +"' onchange='aggiornaIntensita(this, " + k +")' solid='#ccc' overflow='hidden' background='' style='background: url(./css/images/down_arrow_select.jpg) no-repeat right #dddd;margin:2px;azimuth:left-side;background-image:url(./css/images/down_arrow_select.jpg);'>" +
			   "<option value='bassa' " + arrayIntensitaB[k] + " > bassa " +
			   "<option value='media' " + arrayIntensitaM[k] + "> media " +
			   "<option value='alta' " + arrayIntensitaA[k] + "> alta " +
				"</select>";

		}
		// Aggiorno il contenuto del box che conterrà gli elementi aggiunti
		box.innerHTML=righe;
		
		old_j = j;
	}
}

function EliminaRiga(riga){
	var numero_righe = --j;
	var box = document.getElementById('box_righe');
	if(isNaN(numero_righe)==true){
		box.innerHTML='';
	}else{
	    var righe = "";
		// Inserisco una riga ad ogni ciclo
		for(var i=1; i<=numero_righe; i++){
			k=i+1;
			if(k != riga){
				righe = righe+"<br>Sintomo "+(k) +" : <input type=button onclick='EliminaRiga(" + k + ")' value=X class=button><br><br>" +"<input type='text' " + arrayString[k] + " name='sintomo"+k+"' onkeyup='aggiornaString(this, " + k + ")'  />" +
				"<br> <input type='radio' name='tipo" + k + "' value='conferma' onclick='aggiornaCheckConferma("+ k + ")' " + arrayCheckConferma[k] + ">Conferma "+
				"<input type='radio' name='tipo" + k + "' value='contraddizione' onclick='aggiornaCheckContraddizione("+ k + ")' " + arrayCheckContraddizione[k] +">Contraddizione <br/>" +
				"<br>Intensità "+ k + ": <br><select name='intensita" + k +"' onchange='aggiornaIntensita(this, " + k +")' solid='#ccc' overflow='hidden' background='' style='background: url(./css/images/down_arrow_select.jpg) no-repeat right #dddd;margin:2px;azimuth:left-side;background-image:url(./css/images/down_arrow_select.jpg);'>" +
				   "<option value='bassa' " + arrayIntensitaB[k] + " > bassa " +
				   "<option value='media' " + arrayIntensitaM[k] + "> media " +
				   "<option value='alta' " + arrayIntensitaA[k] + "> alta " +
					"</select>";
				}
			else
				deletePos(k);
		}
		// Aggiorno il contenuto del box che conterrà gli elementi aggiunti
		box.innerHTML=righe;
	}
}


function checkInvio(form) {

	    if(form.elements[1].value == ""){
		    alert("inserire la data");
		    form.elements[1].focus();
	    }
		    
		for(var i=0,max=form.elements.length;i<max;++i){
			if(form.elements[i].type.toLowerCase()=='text' &&
			!form.elements[i].value){
				alert("Il campo "+form.elements[i].name+" non puo' essere vuoto!");
				form.elements[i].focus();
				return false;
			}
		} 

		for(var i=5,max=form.elements.length; i<max; i++){
			if(form.elements[i].type.toLowerCase()=='radio' && form.elements[i+1].type.toLowerCase()=='radio') 
					if(!(form.elements[i].checked || form.elements[i+1].checked)){
						alert("Il campo "+form.elements[i].name+" non puo' essere vuoto!");
						form.elements[i].focus();
						return false;
			}
		} 
	alert("Controllo effettuato con successo. Il modulo sarà inviato."); 
	return true; 
}
</script>



<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
    $(document).ready(function() {
        $('#paziente').change(function(event) {  
        var $paziente=$("select#paziente").val();
           $.get('ActionServlet',{paziente:$paziente},function(responseJson) {   
            var $select = $('#cartelle');                           
               $select.find('option').remove();                          
               $.each(responseJson, function(key, value) {               
                   $('<option>').val(key).text(value).appendTo($select);      
                    });
            });
        });
    });          
</script>

</head>
<title>DiagnosiPage</title>

<body>
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
		<br> <br>


		<div align="center">
			<div class="title">
				<h1>DIAGNOSI</h1>
			</div>
		</div>


		<div align="center">
			<div class="title2">
				<h2> Benvenuto <%= iAm.getNome() + " " + iAm.getCognome() %> </h2>
			</div>


	<h3>inserire la diagnosi</h3>


				<form name="diagnosi" action="?ps=diagnosi&medico=<%= iAm.getId() %>" method="post" class="dark-matter" onSubmit="return checkInvio(this);">
					Paziente:<br> <select id = "paziente" name="paziente" style="background: url(./css/images/down_arrow_select.jpg) no-repeat right #dddd;margin:2px;azimuth:left-side;background-image:url(./css/images/down_arrow_select.jpg);">
					<% for (int i = 0; i < pazienti.size(); i++) { %>
					   <option value="<%= pazienti.get(i).getCodsan() %>" > <%= pazienti.get(i).getCodsan() %> 
					   ( <%= pazienti.get(i).getCognome() %> <%= pazienti.get(i).getNome() %>  ) </option>
					   <% } %>
					  </select> 
					<br> 
					
					
					Cartella Clinica del Paziente:
					<select id="cartelle" name="cartella" style="background: url(./css/images/down_arrow_select.jpg) no-repeat right #dddd;margin:2px;azimuth:left-side;background-image:url(./css/images/down_arrow_select.jpg);">
					<option>selezionare prima il paziente</option>
					</select>
					
					<label>Data:<br>
						<input type="date" name="data">
					</label> 
					<br> 
					ICD10: <br><input type=text name=ICD10> 
					<br>
					Patologia:<br> <input type=text name=patologia> 
					<br> 
					Sintomo 1:<br> <input type="text" name="sintomo1" /><br> 
					<input type="radio" name="tipo1" value="conferma">Conferma 
					<input type="radio" name="tipo1"	value="contraddizione">Contraddizione 
					<br><br>
					Intensità 1: <br><select name="intensita1" solid="#ccc" overflow="hidden" background="" style="background: url(./css/images/down_arrow_select.jpg) no-repeat right #dddd;margin:2px;azimuth:left-side;background-image:url(./css/images/down_arrow_select.jpg);">
					   <option value="bassa" > bassa
					   <option value="media" > media
					   <option value="alta" > alta
						</select> 
					<br> 
					<div id='box_righe'>
						<!-- Box che conterrà le righe aggiunte. Inizialmente vuoto! -->
					</div> 
					<input class="button" align=left type=button onclick="AggiungiRiga()" value="aggiungi sintomo" />
					<br> 
			
					<br> <input class="button" type=submit  value="invia" />
				</form>


			<div id="portfolio-wrapper-div">
				<div id="portfolio" class="container">

				</div>
			</div>
			<div id="footer-wrapper-div">
				<div id="footer" class="container"></div>
			</div>
		</div>

	</div>
	<div id="portfolio-wrapper-div">
		<div id="portfolio" class="container">

		</div>
	</div>
	<div id="footer-wrapper-div">
		<div id="footer" class="container"></div>
	</div>


	<h2>
	</h2>


</body>
</html>

