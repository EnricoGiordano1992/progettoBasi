/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.35
 * Generated at: 2014-07-09 08:30:13 UTC
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

public final class PersonalePage_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!-- Eseguo gli import necessari -->\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
 
    // Genero un oggetto della classe DBMS per gestire l'interzione con la base di dati
    DBMS dbms = new DBMS();

    Vector p = dbms.getPersonaleMedico(); 
    Vector spec = new Vector();
    
    PrimarioBean primario = dbms.getPrimarioSpec();
    Vector specPrimario = dbms.getSpecializzazioni(primario.getId());

      out.write("\n");
      out.write("\n");
      out.write("\n");
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
      out.write("\t\t\t\t<h1>PERSONALE</h1>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\t\t<div align=\"center\">\n");
      out.write("\t\t\t<div class=\"title2\">\n");
      out.write("\t\t\t\t<h2>PRIMARIO</h2>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<a class=\"icon icon-arrow-right button\"></a> <br> <br>\n");
      out.write("\n");
      out.write("\n");
      out.write("\t\t\t<h1>\n");
      out.write("\t\t\t\t");
      out.print( primario.getNome() );
      out.write("\n");
      out.write("\t\t\t\t");
      out.print( primario.getCognome() );
      out.write("\n");
      out.write("\t\t\t</h1>\n");
      out.write("\n");
      out.write("\t\t\t<br>\n");
      out.write("\t\t\tspecializzato in\n");
      out.write("\t\t\t<br>\n");
      out.write("\t\t\t");
 for (int i=0; i < specPrimario.size() ; i++) {
      out.write("\n");
      out.write("\t\t\t<br>\n");
      out.write("\t\t\t<h3>");
      out.print( ((PersonaleBean)specPrimario.get(i)).getSpecializzazioni() );
      out.write("</h3>\n");
      out.write("\n");
      out.write("\t\t\t");
} 
      out.write("\n");
      out.write("\n");
      out.write("\t\t\t<br> <br> <a class=\"icon icon-arrow-right button\"></a> <br>\n");
      out.write("\t\t\t<br> <br> <br> <br>\n");
      out.write("\n");
      out.write("\n");
      out.write("\t\t\t<div class=\"title\">\n");
      out.write("\t\t\t\t<h2>PERSONALE MEDICO</h2>\n");
      out.write("\t\t\t</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\t\t\t<div id=\"portfolio-wrapper-div\">\n");
      out.write("\t\t\t\t<div id=\"portfolio\" class=\"container\">\n");
      out.write("\n");
      out.write("\t\t\t\t\t");
 for (int i=0; i < p.size() ; i++) {

	spec = dbms.getSpecializzazioni(((PersonaleBean)p.get(i)).getId());
	
	if( i%5 != 0) {

      out.write("\n");
      out.write("\n");
      out.write("\t\t\t\t\t<div id=\"column");
      out.print( i%5 );
      out.write("\">\n");
      out.write("\t\t\t\t\t\t<div class=\"title\">\n");
      out.write("\t\t\t\t\t\t\t<br>\n");
      out.write("\t\t\t\t\t\t\t<h2>");
      out.print( ((PersonaleBean)p.get(i)).getNome() );
      out.write("\n");
      out.write("\t\t\t\t\t\t\t\t");
      out.print( ((PersonaleBean)p.get(i)).getCognome() );
      out.write("</h2>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t\t\t\t\tinizio attivita':\n");
      out.write("\t\t\t\t\t\t<br>\n");
      out.write("\t\t\t\t\t\t<a class=\"icon icon-arrow-right button2\" background=\"#000000\">\n");
      out.write("\t\t\t\t\t\t");
      out.print( ((PersonaleBean)p.get(i)).getInizio() );
      out.write("\n");
      out.write("\t\t\t\t\t\t</a>\n");
      out.write("\t\t\t\t\t\t<br>\n");
      out.write("\t\t\t\t\t\t<br>\n");
      out.write("\n");
      out.write("\t\t\t\t\t\tnumero diagnosi effettuate:\n");
      out.write("\t\t\t\t\t\t<br>\n");
      out.write("\t\t\t\t\t\t<a class=\"icon icon-arrow-right button2\" background=\"#000000\">\n");
      out.write("\t\t\t\t\t\t");
      out.print( ((PersonaleBean)p.get(i)).getDiagnosi() );
      out.write("\n");
      out.write("\t\t\t\t\t\t</a>\n");
      out.write("\t\t\t\t\t\t<br>\n");
      out.write("\t\t\t\t\t\t<br>\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t");
 if (((PersonaleBean)p.get(i)).getNome().charAt(((PersonaleBean)p.get(i)).getNome().length()-1) == 'a'){ 
      out.write("\n");
      out.write("\t\t\t\t\t\tspecializzata in:\n");
      out.write("\t\t\t\t\t\t");
}  else {
      out.write("\n");
      out.write("\t\t\t\t\t\tspecializzato in:\n");
      out.write("\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t");
} 
      out.write("\n");
      out.write("\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t<a class=\"icon icon-arrow-right button2\" background=\"#000000\">\n");
      out.write("\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t");
 for (int j=0; j < spec.size() ; j++) { 
      out.write("\n");
      out.write("\t\t\t\t\t\t<br>");
      out.print( ((PersonaleBean)spec.get(j)).getSpecializzazioni() );
      out.write("<br>\n");
      out.write("\t\t\t\t\t\t");
} 
      out.write("\n");
      out.write("\t\t\t\t\t\t</a>\n");
      out.write("\t\t\t\t\t\t<br>\n");
      out.write("\t\t\t\t\t\t<br>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t\t\t\t");
} else {
      out.write("\n");
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
      out.write("\n");
      out.write("\t\t\t");
} 
      out.write("\n");
      out.write("\t\t\t");
} 
      out.write("\n");
      out.write("\n");
      out.write("\t\t</div>\n");
      out.write("\t</div>\n");
      out.write("\t<div id=\"footer-wrapper-div\">\n");
      out.write("\t\t<div id=\"footer\" class=\"container\"></div>\n");
      out.write("\t</div>\n");
      out.write("\n");
      out.write("\t</div>\n");
      out.write("\t</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
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
