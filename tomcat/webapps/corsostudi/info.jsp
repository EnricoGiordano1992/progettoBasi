<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="did.*"%>
<%@page errorPage="error.jsp"%>
<%@page isErrorPage="false" %>

<%
//Recupero i dati ottenuti dalle interrogazioni e passati attraverso l'oggetto request

String dir = (String)request.getAttribute("info");
%>

<html>
<head>
<title>DIPARTIMENTO DI INFORMATICA</title>
<link rel="stylesheet" type="text/css" href="../pagina.css" />
</head>
<body>
<h1>Informazioni Generali</h1>
<b>Sede :</b><br/>
    Strada le Grazie 15 - 37134 Verona<br/>
<b>Direttore :</b><br/>
    Prof. <%= dir %> <br/>
<b>Direttore Vicario :</b><br/>
    Prof. Leonard Peter  Bos<br/>
<b>Contatto :</b><br/>
    Segreteria amministrativa DI Informatica<br/>
<b>Edificio :</b><br/>
    Ca' Vignal 2<br/>
<b>Orario di apertura al pubblico :</b><br/>
    9.00 - 12.00<br/>
<b>Telefono :</b><br/>
    045 802 7071 - 045 8027802<br/>
<b>Fax :</b><br/>
    045 802 7068<br/>
<b>E-mail :</b><br/>
    segreteria.di@ateneo.univr.it<br/>
<br/>
<b><h4>Descrizione del dipartimento</h4></b><br/>
<br/>
 Il Dipartimento di Informatica promuove numerose attività didattiche e di ricerca basate su un continuo di competenze che vanno dalla matematica alla fisica attraverso l'informatica vista come scienze e ingegneria.
Le aree di ricerca attive sono: la matematica discreta e applicata, l'informatica teorica, i sistemi intelligenti, i sistemi informativi, l'ingegneria del software e la sicurezza, l'informatica applicata,
i sistemi ciberfisici e la fisica applicata e della materia.
A partire da queste competenze, il Dipartimento di Informatica ha rivolto da sempre particolare attenzione sia alla produzione scientifica (2000 pubblicazioni internazionali nell'ultimo settennio), alla
partecipazione a progetti finanziati da enti internazionali e nazionali (26 progetti per 7.7 milioni di euro) come all'attività di collaborazione con le imprese mediante ricerca applicata a forte ricaduta tecnologica
(5 spin-off, 10 brevetti, 253 progetti per 4.8 milioni di euro).<br/><br/> 

<br/><b><h4>Collegio Didattico di Informatica</h4></b><br/>
    Al Collegio Didattico di Informatica competono la definizione e la modifica di regolamenti, ordinamenti e piani didattici dei Corsi di Studio (CdS) afferenti alle classi di laurea L31 (Informatica e Bioinformatica) e LM18-32 (Ingegneria e scienze informatiche), la definizione dei carichi didattici, la proposta di affidamento dei vari insegnamenti ed utilizzo degli assistenti didattici, l’assicurazione della qualità dei CdS ai sensi di legge, l’amministrazione degli appelli d’esame e di laurea con l’identificazione delle relative commissioni, la gestione delle pratiche studenti. 
<br/><b><h4>Collegio Didattico di Matematica</h4></b><br/>
    Al Collegio Didattico di Matematica competono la definizione e la modifica di regolamenti, ordinamenti e piani didattici dei Corsi di Studio (CdS) afferenti alle classi di laurea L35 (Matematica Applicata) e LM40 (Matematica), la definizione dei carichi didattici, la proposta di affidamento dei vari insegnamenti ed utilizzo degli assistenti didattici, l’assicurazione della qualità dei CdS ai sensi di legge, l’amministrazione degli appelli d’esame e di laurea con l’identificazione delle relative commissioni, la gestione delle pratiche studenti. 
<br/><b><h4>Comitato Scientifico del Master Universitario in Computer game development (I livello)</h4></b><br/>
    Al comitato scientifico del master universitario in Computer game development competono la definizione delle linee guida del master, la stesura del piano didattico, la selezione delle aziende partner, l'identificazione delle prove intermedie e l'approvazione dell'esame finale. Inoltre è di competenza del comitato scientifico master la discussione e la presa in carico di casi particolari. 
<br/><b><h4>Consiglio del Dipartimento di Informatica</h4></b><br/>
    Le competenze del Consiglio di Dipartimento sono indicate nell'art. 35 dello Statuto dell'Università.
    In particolare il Consiglio approva il bilancio di previsione del Dipartimento, le eventuali note di variazione in corso d'anno, nonché il conto consuntivo
    Il Consiglio, inoltre, programma le attività del Dipartimento e svolge tutti gli altri compiti che gli sono attribuiti dalle leggi, dallo Statuto e dai Regolamenti dell'Ateneo.
    Il Consiglio, infine, può delegare alla Giunta l'esercizio di specifiche competenze.
    Le modalità di funzionamento del Consiglio sono contenute nel Regolamento del Dipartimento.
<br/><br/><br/><br/>
<a href=?ps> Home </a>
</body>
</html>
