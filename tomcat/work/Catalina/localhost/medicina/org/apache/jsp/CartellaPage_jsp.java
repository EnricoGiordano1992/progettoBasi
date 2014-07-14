/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.35
 * Generated at: 2014-07-10 21:51:06 UTC
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

public final class CartellaPage_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!-- CARTELLA PAGE -->\n");
      out.write("\n");
      out.write("<!-- Eseguo gli import necessari -->\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
 
    // Genero un oggetto della classe DBMS per gestire l'interzione con la base di dati
    DBMS dbms = new DBMS();
    String cartella;
	int i;

    if (request.getParameter("cartella") != null)
	    cartella = (String)request.getParameter("cartella");
    else
	    cartella = "";



      out.write('\n');
      out.write('\n');
 

	CartellaBean c = new CartellaBean();
	c = dbms.getCartella(cartella);
	
	Vector terapie = dbms.getTerapieCartella(c.getCodice());
	Vector diagnosi = dbms.getDiagnosiCartella(c.getCodice());


      out.write("\n");
      out.write("<title>Cartella - ");
      out.print( c.getCodice() );
      out.write("</title>\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("\n");
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
      out.write("\t\t\t\t\t<li><a href=\"/medicina/home\">Homepage</a></li>\n");
      out.write("\t\t\t\t\t<li><a href=\"?ps=info\">Info</a></li>\n");
      out.write("\t\t\t\t\t<li><a href=\"?ps=personale\">Personale</a></li>\n");
      out.write("\t\t\t\t\t<li><a href=\"?ps=patologie\">Patologie</a></li>\n");
      out.write("\t\t\t\t\t<li><a href=\"?ps=login\">Login</a></li>\n");
      out.write("\n");
      out.write("\t\t\t\t</ul>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<!-- end #menu -->\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<br> <br>\n");
      out.write("\t\t<div align=\"center\">\n");
      out.write("\t\t\t<div class=\"title2\">\n");
      out.write("\t\t\t\t<h2>CARTELLA</h2>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<a class=\"button\">");
      out.print( c.getCodice() );
      out.write("</a>\n");
      out.write("\t\t\t<br><br><br>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t\n");
      out.write("\t\t<div style=\"float:left; width:50%;\" align=\"right\">\n");
      out.write("\t\t\t<h2 style=\"display:inline;\">DATA RICOVERO</h2>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div style=\"float:left; width:50%;\" align=\"left\">\n");
      out.write("\t\t\t<a class=\"button\" style=\"margin-top:0px;background-color:#000000;\">");
      out.print( c.getCodice() );
      out.write("</a>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<br><br>\n");
      out.write("\t\t<div style=\"float:left; width:50%;\" align=\"right\">\n");
      out.write("\t\t\t<h2 style=\"display:inline;\">DATA DIMISSIONE</h2>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div style=\"float:left; width:50%;\" align=\"left\">\n");
      out.write("\t\t\t<a class=\"button\" style=\"margin-top:0px;background-color:#000000;\">");
      out.print( c.getDataDimissione() );
      out.write("</a>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<br><br>\n");
      out.write("\t\t<div style=\"float:left; width:50%;\" align=\"right\">\n");
      out.write("\t\t\t<h2 style=\"display:inline;\">MOTIVO</h2>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div style=\"float:left; width:50%;\" align=\"left\">\n");
      out.write("\t\t\t<a class=\"button\" style=\"margin-top:0px;background-color:#000000;\">");
      out.print( c.getMotivo() );
      out.write("</a>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<br><br>\n");
      out.write("\t\t<div style=\"float:left; width:50%;\" align=\"right\">\n");
      out.write("\t\t\t<h2 style=\"display:inline;\">PROGNOSI</h2>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div style=\"float:left; width:50%;\" align=\"left\">\n");
      out.write("\t\t\t<a class=\"button\" style=\"margin-top:0px;background-color:#000000;\">");
      out.print( c.getPrognosi() );
      out.write("</a>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div style=\"clear:both\">\n");
      out.write("\t\t\t<br><br><br>\n");
      out.write("\t\t\t");
 
			for (i = 0; i<diagnosi.size()-1; i++ ) {
			
      out.write("\n");
      out.write("\n");
      out.write("\t\t\t\t");
      out.print( ((CartellaBean) diagnosi.get(i)).getDiagnosi_patologia() );
      out.write("\t</p>\n");
      out.write("\n");
      out.write("\t\t\t");
 }
			for (i = 0; i<terapie.size()-1; i++ ) {
			
      out.write("\n");
      out.write("\n");
      out.write("\t\t\t\t");
      out.print( ((CartellaBean) terapie.get(i)).getTerapie_farmaco() );
      out.write("\t</p>\n");
      out.write("\n");
      out.write("\t\t\t");
} 
      out.write("\n");
      out.write("\n");
      out.write("\t\t\t<div id=\"banner3\" style=\"background-color:#3CB371;\"></div>\n");
      out.write("\t\t</div>\n");
      out.write("</body>\n");
      out.write("\t\n");
      out.write("\n");
      out.write("\n");
      out.write("\t\n");
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
