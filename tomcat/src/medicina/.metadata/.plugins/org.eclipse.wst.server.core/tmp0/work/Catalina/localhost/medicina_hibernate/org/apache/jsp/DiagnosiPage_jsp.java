/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2014-07-10 09:49:33 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.util.*;
import dbms.*;
import bean.*;

public final class DiagnosiPage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			"error.jsp", true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!-- DIAGNOSI PAGE -->\n");
      out.write("\n");
      out.write("<!-- Eseguo gli import necessari -->\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
 
    // Genero un oggetto della classe DBMS per gestire l'interzione con la base di dati
    DBMS dbms = new DBMS();
    String medico;

    if (request.getParameter("user") != null)
	    medico = (String)request.getParameter("user");
    else
	    medico = "";

    Medico iAm = dbms.getMedico(medico); 

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("// Funzione che permette di aggiungere elementi al form (ESEMPIO 1)\n");
      out.write("var j = 1;\n");
      out.write("var old_j = 0;\n");
      out.write("var k = 0;\n");
      out.write("\n");
      out.write("var arrayString = new Array();\n");
      out.write("var arrayCheckConferma = new Array();\n");
      out.write("var arrayCheckContraddizione = new Array();\n");
      out.write("var arrayIntensita = new Array();\n");
      out.write("\n");
      out.write("function aggiornaString (stringa, pos) {\n");
      out.write("\n");
      out.write("\tarrayString[pos] = \"value = '\" + stringa.value + \"'\";\n");
      out.write("}\n");
      out.write("\n");
      out.write("function aggiornaCheckConferma(pos) {\n");
      out.write("\n");
      out.write("\tarrayCheckConferma[pos] = \"checked\";\n");
      out.write("\tarrayCheckContraddizione[pos] = \"\";\n");
      out.write("}\n");
      out.write("\n");
      out.write("function aggiornaCheckContraddizione(pos) {\n");
      out.write("\n");
      out.write("\tarrayCheckContraddizione[pos] = \"checked\";\n");
      out.write("\tarrayCheckConferma[pos] = \"\";\n");
      out.write("}\n");
      out.write("\n");
      out.write("\n");
      out.write("function deletePos(pos) {\n");
      out.write("\n");
      out.write("\tarrayCheckContraddizione[pos] = null;\n");
      out.write("\tarrayCheckConferma[pos] = null;\n");
      out.write("\tarrayString[pos] = null;\n");
      out.write("\tarrayIntensita[pos] = null;\n");
      out.write("}\n");
      out.write("\n");
      out.write("\n");
      out.write("function aggiornaIntensita(stringa, pos) {\n");
      out.write("\t\n");
      out.write("\tarrayIntensita[pos] = \"value = '\" + stringa.value + \"'\";;\n");
      out.write("}\n");
      out.write("\n");
      out.write("function AggiungiRiga(){\n");
      out.write("\tvar numero_righe = j++;\n");
      out.write("\tvar box = document.getElementById('box_righe');\n");
      out.write("\tif(isNaN(numero_righe)==true){\n");
      out.write("\t\tbox.innerHTML='';\n");
      out.write("\t}else{\n");
      out.write("\t    var righe = \"\";\n");
      out.write("\t\t// Inserisco una riga ad ogni ciclo\n");
      out.write("\t\tfor(i=1; i<=numero_righe; i++){\n");
      out.write("\t\t\tk=i+1;\n");
      out.write("\n");
      out.write("\t\t\trighe = righe+\"<br>Sintomo \"+(k) +\" : <input type=button onclick='EliminaRiga(\" + k + \")' value=X class=button><br><br>\" +\"<input type='text' \" + arrayString[k] + \" name='sintomo\"+k+\"' onkeyup='aggiornaString(this, \" + k + \")'  />\" +\n");
      out.write("\t\t\t\"<br> <input type='radio' name='tipo\" + k + \"' value='conferma' onclick='aggiornaCheckConferma(\"+ k + \")' \" + arrayCheckConferma[k] + \">Conferma \"+\n");
      out.write("\t\t\t\"<input type='radio' name='tipo\" + k + \"' value='contraddizione' onclick='aggiornaCheckContraddizione(\"+ k + \")' \" + arrayCheckContraddizione[k] +\">Contraddizione <br/>\" +\n");
      out.write("\t\t\t\"<br>Intensità \"+ k + \": <br><input type='text' \" + arrayIntensita[k] + \" name=intensita\"+k+\" onkeyup='aggiornaIntensita(this, \" + k + \")'><br>\";\n");
      out.write("\n");
      out.write("\t\t}\n");
      out.write("\t\t// Aggiorno il contenuto del box che conterrà gli elementi aggiunti\n");
      out.write("\t\tbox.innerHTML=righe;\n");
      out.write("\t\t\n");
      out.write("\t\told_j = j;\n");
      out.write("\t}\n");
      out.write("}\n");
      out.write("\n");
      out.write("function EliminaRiga(riga){\n");
      out.write("\tvar numero_righe = --j;\n");
      out.write("\tvar box = document.getElementById('box_righe');\n");
      out.write("\tif(isNaN(numero_righe)==true){\n");
      out.write("\t\tbox.innerHTML='';\n");
      out.write("\t}else{\n");
      out.write("\t    var righe = \"\";\n");
      out.write("\t\t// Inserisco una riga ad ogni ciclo\n");
      out.write("\t\tfor(i=1; i<=numero_righe; i++){\n");
      out.write("\t\t\tk=i+1;\n");
      out.write("\t\t\tif(k != riga){\n");
      out.write("\t\t\trighe = righe+\"<br>Sintomo \"+(k) +\" : <input type=button onclick='EliminaRiga(\" + k + \")' value=X class=button><br><br>\" +\"<input type='text' \" + arrayString[k] + \" name='sintomo\"+k+\"' onkeyup='aggiornaString(this, \" + k + \")'  />\" +\n");
      out.write("\t\t\t\"<br> <input type='radio' name='tipo\" + k + \"' value='conferma' onclick='aggiornaCheckConferma(\"+ k + \")' \" + arrayCheckConferma[k] + \">Conferma \"+\n");
      out.write("\t\t\t\"<input type='radio' name='tipo\" + k + \"' value='contraddizione' onclick='aggiornaCheckContraddizione(\"+ k + \")' \" + arrayCheckContraddizione[k] +\">Contraddizione <br/>\" +\n");
      out.write("\t\t\t\"<br>Intensità \"+ k + \": <br><input type='text' \" + arrayIntensita[k] + \" name=intensita\"+k+\" onkeyup='aggiornaIntensita(this, \" + k + \")'><br>\";\n");
      out.write("\t\t\t\t}\n");
      out.write("\t\t\telse\n");
      out.write("\t\t\t\tdeletePos(k);\n");
      out.write("\t\t}\n");
      out.write("\t\t// Aggiorno il contenuto del box che conterrà gli elementi aggiunti\n");
      out.write("\t\tbox.innerHTML=righe;\n");
      out.write("\t}\n");
      out.write("}\n");
      out.write("\n");
      out.write("\n");
      out.write("function checkInvio(form) {\n");
      out.write("\n");
      out.write("\t    if(form.elements[1].value == \"\"){\n");
      out.write("\t\t    alert(\"inserire la data\");\n");
      out.write("\t\t    form.elements[1].focus();\n");
      out.write("\t    }\n");
      out.write("\t\t    \n");
      out.write("\t\tfor(var i=0,max=form.elements.length;i<max;++i){\n");
      out.write("\t\t\tif(form.elements[i].type.toLowerCase()=='text' &&\n");
      out.write("\t\t\t!form.elements[i].value){\n");
      out.write("\t\t\t\talert(\"Il campo \"+form.elements[i].name+\" non puo' essere vuoto!\");\n");
      out.write("\t\t\t\tform.elements[i].focus();\n");
      out.write("\t\t\t\treturn false;\n");
      out.write("\t\t\t}\n");
      out.write("\t\t} \n");
      out.write("\n");
      out.write("\t\tvar j;\n");
      out.write("\t\tfor(var i=5,max=form.elements.length; i<max; i++){\n");
      out.write("\t\t\tif(form.elements[i].type.toLowerCase()=='radio' && form.elements[i+1].type.toLowerCase()=='radio') \n");
      out.write("\t\t\t\t\tif(!(form.elements[i].checked || form.elements[i+1].checked)){\n");
      out.write("\t\t\t\t\t\talert(\"Il campo \"+form.elements[i].name+\" non puo' essere vuoto!\");\n");
      out.write("\t\t\t\t\t\tform.elements[i].focus();\n");
      out.write("\t\t\t\t\t\treturn false;\n");
      out.write("\t\t\t}\n");
      out.write("\t\t} \n");
      out.write("\talert(\"Controllo effettuato con successo. Il modulo sarà inviato.\"); \n");
      out.write("\treturn true; \n");
      out.write("}\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<title>DiagnosiPage</title>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("<html>\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("<meta name=\"keywords\" content=\"\" />\n");
      out.write("<meta name=\"description\" content=\"\" />\n");
      out.write("<link href=\"css/default.css\" rel=\"stylesheet\" type=\"text/css\"\n");
      out.write("\tmedia=\"all\">\n");
      out.write("<link href=\"css/font.css\" rel=\"stylesheet\" type=\"text/css\" media=\"all\">\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("\t<div id=\"wrapper\">\n");
      out.write("\t\t<div id=\"header-wrapper\">\n");
      out.write("\t\t\t<div id=\"header\" class=\"container\">\n");
      out.write("\t\t\t\t<div id=\"logo\">\n");
      out.write("\t\t\t\t\t<h1>\n");
      out.write("\t\t\t\t\t\t<a href=\"#\">Ospedale San Gibbordano</a>\n");
      out.write("\t\t\t\t\t</h1>\n");
      out.write("\t\t\t\t\t<p>Divisione ospedaliera di Medicina</p>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\n");
      out.write("\t\t<div id=\"menu-wrapper\">\n");
      out.write("\t\t\t<div id=\"menu\" class=\"container\">\n");
      out.write("\t\t\t\t<ul>\n");
      out.write("\t\t\t\t\t<li><a href=\"?\">Homepage</a></li>\n");
      out.write("\t\t\t\t\t<li><a href=\"?ps=info\">Info</a></li>\n");
      out.write("\t\t\t\t\t<li class=\"current_page_item\"><a href=\"?ps=personale\">Personale</a></li>\n");
      out.write("\t\t\t\t\t<li><a href=\"?ps=patologie\">Patologie</a></li>\n");
      out.write("\t\t\t\t\t<li><a href=\"?ps=login\">Login</a></li>\n");
      out.write("\n");
      out.write("\t\t\t\t</ul>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<!-- end #menu -->\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<br> <br>\n");
      out.write("\n");
      out.write("\n");
      out.write("\t\t<div align=\"center\">\n");
      out.write("\t\t\t<div class=\"title\">\n");
      out.write("\t\t\t\t<h1>DIAGNOSI</h1>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\t\t<div align=\"center\">\n");
      out.write("\t\t\t<div class=\"title2\">\n");
      out.write("\t\t\t\t<h2> Benvenuto ");
      out.print( iAm.getNome() + " " + iAm.getCognome() );
      out.write(" </h2>\n");
      out.write("\t\t\t</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\t<h3>inserire la diagnosi</h3>\n");
      out.write("\n");
      out.write("\n");
      out.write("\t\t\t\t<form name=\"diagnosi\" action=\"?\" method=\"post\" class=\"dark-matter\" onSubmit=\"return checkInvio(this);\">\n");
      out.write("\t\t\t\t\tPaziente:<br> <input type=text name=paziente> \n");
      out.write("\t\t\t\t\t<br> \n");
      out.write("\t\t\t\t\t<label>Data:<br>\n");
      out.write("\t\t\t\t\t\t<input type=\"date\" name=\"data\">\n");
      out.write("\t\t\t\t\t</label> \n");
      out.write("\t\t\t\t\t<br> \n");
      out.write("\t\t\t\t\tICD10: <br><input type=text name=ICD10> \n");
      out.write("\t\t\t\t\t<br>\n");
      out.write("\t\t\t\t\tPatologia:<br> <input type=text name=patologia> \n");
      out.write("\t\t\t\t\t<br> \n");
      out.write("\t\t\t\t\tSintomo 1:<br> <input type=\"text\" name=\"sintomo1\" /><br> \n");
      out.write("\t\t\t\t\t<input type=\"radio\" name=\"tipo1\" value=\"conferma\">Conferma \n");
      out.write("\t\t\t\t\t<input type=\"radio\" name=\"tipo1\"\tvalue=\"contraddizione\">Contraddizione \n");
      out.write("\t\t\t\t\t<br><br>\n");
      out.write("\t\t\t\t\tIntensità 1: <br><input type=\"text\" name=intensita1> \n");
      out.write("\t\t\t\t\t<br> \n");
      out.write("\t\t\t\t\t<div id='box_righe'>\n");
      out.write("\t\t\t\t\t\t<!-- Box che conterrà le righe aggiunte. Inizialmente vuoto! -->\n");
      out.write("\t\t\t\t\t</div> \n");
      out.write("\t\t\t\t\t<input class=\"button\" align=left type=button onclick=\"AggiungiRiga()\" value=\"aggiungi sintomo\" />\n");
      out.write("\t\t\t\t\t<br> \n");
      out.write("\t\t\t\n");
      out.write("\t\t\t\t\t<br> <input class=\"button\" type=submit  value=\"invia\" />\n");
      out.write("\t\t\t\t</form>\n");
      out.write("\n");
      out.write("\n");
      out.write("\t\t\t<div id=\"portfolio-wrapper-div\">\n");
      out.write("\t\t\t\t<div id=\"portfolio\" class=\"container\">\n");
      out.write("\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div id=\"footer-wrapper-div\">\n");
      out.write("\t\t\t\t<div id=\"footer\" class=\"container\"></div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\n");
      out.write("\t</div>\n");
      out.write("\t<div id=\"portfolio-wrapper-div\">\n");
      out.write("\t\t<div id=\"portfolio\" class=\"container\">\n");
      out.write("\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t<div id=\"footer-wrapper-div\">\n");
      out.write("\t\t<div id=\"footer\" class=\"container\"></div>\n");
      out.write("\t</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\t<h2>\n");
      out.write("\t</h2>\n");
      out.write("\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
