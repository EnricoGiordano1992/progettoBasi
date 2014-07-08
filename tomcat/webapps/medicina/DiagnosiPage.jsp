<!-- DIAGNOSI PAGE -->

<!-- Eseguo gli import necessari -->
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="dbms.*"%>
<%@page errorPage="error.jsp"%>
<%@page isErrorPage="false"%>
<html>
<% 
    // Genero un oggetto della classe DBMS per gestire l'interzione con la base di dati
    DBMS dbms = new DBMS();
    String medico;

    if (request.getParameter("user") != null)
	    medico = (String)request.getParameter("user");
    else
	    medico = "";


    String iAm = dbms.getMedico(medico); 
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
var arrayIntensita = new Array();

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
	arrayIntensita[pos] = null;
}


function aggiornaIntensita(stringa, pos) {
	
	arrayIntensita[pos] = "value = '" + stringa.value + "'";;
}

function AggiungiRiga(){
	var numero_righe = j++;
	var box = document.getElementById('box_righe');
	if(isNaN(numero_righe)==true){
		box.innerHTML='';
	}else{
	    var righe = "";
		// Inserisco una riga ad ogni ciclo
		for(i=1; i<=numero_righe; i++){
			k=i+1;

			righe = righe+"Sintomo "+(k) +" : " +"<input type='text' " + arrayString[k] + " name='sintomo"+k+"' onkeyup='aggiornaString(this, " + k + ")'  />" +
			" <input type='radio' name='tipo" + k + "' value='conferma' onclick='aggiornaCheckConferma("+ k + ")' " + arrayCheckConferma[k] + ">Conferma "+
			"<input type='radio' name='tipo" + k + "' value='contraddizione' onclick='aggiornaCheckContraddizione("+ k + ")' " + arrayCheckContraddizione[k] +">Contraddizione <br/>" +
			"Intensità "+ k + ": <input type='text' " + arrayIntensita[k] + " name=intensita"+k+" onkeyup='aggiornaIntensita(this, " + k + ")'><br>";

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
		for(i=1; i<=numero_righe; i++){
			k=i+1;
			if(k != riga){
				righe = righe+"Sintomo "+(k) +" : " +"<input type='text' " + arrayString[k] + " name='sintomo"+k+"' onkeyup='aggiornaString(this, " + k + ")'  />" +
				" <input type='radio' name='tipo" + k + "' value='conferma' onclick='aggiornaCheckConferma("+ k + ")' " + arrayCheckConferma[k] + ">Conferma "+
				"<input type='radio' name='tipo" + k + "' value='contraddizione' onclick='aggiornaCheckContraddizione("+ k + ")' " + arrayCheckContraddizione[k] +">Contraddizione <br/>" +
				"Intensità "+ k + ": <input type='text' " + arrayIntensita[k] + " name=intensita"+k+" onkeyup='aggiornaIntensita(this, " + k + ")'><br>";
				}
			else
				deletePos(k);
		}
		// Aggiorno il contenuto del box che conterrà gli elementi aggiunti
		box.innerHTML=righe;
	}
}
</script>

</head>
<title>DiagnosiPage</title>

<body>

	<h2>
		Benvenuto
		<%= iAm %>
	</h2>

	<h3>inserire la diagnosi</h3>


	<form name="diagnosi" action="?" method="get">
		Paziente: <input type=text name=codsan> 
		<br> 
		<label>Data:
			<input type="date" name="mydatetime">
		</label> 
		<br> 
		ICD10: <input type=text name=ICD10> 
		<br>
		Patologia: <input type=text name=patologia> 
		<br> 
		Sintomo 1: <input type="text" name="righe" /> 
		<input type="radio" name="tipo" value="conferma">Conferma 
		<input type="radio" name="tipo"	value="contraddizione">Contraddizione 
		<br>
		Intensità 1: <input type="text" name=intensita> 
		<br> 
		<span id='box_righe'>
			<!-- Box che conterrà le righe aggiunte. Inizialmente vuoto! -->
		</span> 
		<input type=button onclick="AggiungiRiga()" value="aggiungi sintomo" />
		<br> 
		<input type=button onclick="EliminaRiga(riga.value)" value="elimina sintomo" /> 
		sintomo: <input type=text name=riga>

		<br> <input type=submit>
	</form>

</body>
</html>

