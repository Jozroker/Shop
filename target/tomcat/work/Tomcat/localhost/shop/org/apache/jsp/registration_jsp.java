/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2020-05-06 15:56:59 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class registration_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>Registration</title>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css\" integrity=\"sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh\" crossorigin=\"anonymous\">\r\n");
      out.write("    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>\r\n");
      out.write("    <script>\r\n");
      out.write("        $(document).ready(function () {\r\n");
      out.write("            $(\"#btn\").click(function () {\r\n");
      out.write("                let fname = $(\"#fname\").val();\r\n");
      out.write("                let lname = $(\"#lname\").val();\r\n");
      out.write("                let email = $(\"#email\").val();\r\n");
      out.write("                let pass = $(\"#password\").val();\r\n");
      out.write("                if (fname === \"\" || lname === \"\" || email === \"\" || pass === \"\") {\r\n");
      out.write("                    alert(\"Empty fields\");\r\n");
      out.write("                }\r\n");
      out.write("            })\r\n");
      out.write("        })\r\n");
      out.write("    </script>\r\n");
      out.write("    <style type=\"text/css\">\r\n");
      out.write("        .registrationFormDiv {\r\n");
      out.write("            margin-left: 40%;\r\n");
      out.write("            margin-top: 5%;\r\n");
      out.write("        }\r\n");
      out.write("        .form-control {\r\n");
      out.write("            width: 30%;\r\n");
      out.write("        }\r\n");
      out.write("        .btn {\r\n");
      out.write("            width: 30%;\r\n");
      out.write("            text-align: center;\r\n");
      out.write("        }\r\n");
      out.write("        #logInButton {\r\n");
      out.write("            margin-top: 0;\r\n");
      out.write("        }\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("    <form id=\"registrationForm\" action=\"/shop/registration\" method=\"post\">\r\n");
      out.write("    <div class=\"registrationFormDiv\">\r\n");
      out.write("        <div class=\"form-group\">\r\n");
      out.write("            <label for=\"fname\">First Name</label>\r\n");
      out.write("            <input type=\"text\" class=\"form-control\" id=\"fname\" name=\"fname\">\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"form-group\">\r\n");
      out.write("            <label for=\"lname\">Last Name</label>\r\n");
      out.write("            <input type=\"text\" class=\"form-control\" id=\"lname\" name=\"lname\">\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"form-group\">\r\n");
      out.write("            <label for=\"email\">Email</label>\r\n");
      out.write("            <input type=\"email\" class=\"form-control\" id=\"email\" name=\"email\" aria-describedby=\"emailHelp\">\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"form-group\">\r\n");
      out.write("            <label for=\"password\">Password</label>\r\n");
      out.write("            <input type=\"text\" class=\"form-control\" id=\"password\" name=\"password\">\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <button type=\"submit\" class=\"btn btn-primary\" id=\"btn\" class=\"btn\">Register</button>\r\n");
      out.write("    </div>\r\n");
      out.write("    </form>\r\n");
      out.write("    <form action=\"/shop/login\" method=\"get\">\r\n");
      out.write("        <div id=\"logInButton\" class=\"registrationFormDiv\">\r\n");
      out.write("            <button type=\"submit\" class=\"btn btn-primary\" class=\"btn\">Log in</button>\r\n");
      out.write("        </div>\r\n");
      out.write("    </form>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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