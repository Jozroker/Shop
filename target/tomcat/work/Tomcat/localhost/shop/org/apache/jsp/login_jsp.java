/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2020-05-06 15:43:01 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <title>Log in</title>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css\" integrity=\"sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh\" crossorigin=\"anonymous\">\r\n");
      out.write("    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    <script>\r\n");
      out.write("        $(document).ready(function () {\r\n");
      out.write("\r\n");
      out.write("                $('#exampleInputEmail1').on('keyup', function() {\r\n");
      out.write("                    let thisEmpty = false;\r\n");
      out.write("                    let otherEmpty = $(\"#exampleInputPassword1\").val().length === 0;\r\n");
      out.write("\r\n");
      out.write("                    $('#exampleInputEmail1').each(function() {\r\n");
      out.write("                        thisEmpty = $(this).val().length === 0;\r\n");
      out.write("\r\n");
      out.write("                    });\r\n");
      out.write("\r\n");
      out.write("                    if (thisEmpty || otherEmpty)\r\n");
      out.write("                        $('#btn').attr('disabled', 'disabled');\r\n");
      out.write("                    else\r\n");
      out.write("                        $('#btn').attr('disabled', false);\r\n");
      out.write("                });\r\n");
      out.write("\r\n");
      out.write("            $('#exampleInputPassword1').on('keyup', function() {\r\n");
      out.write("                let thisEmpty = false;\r\n");
      out.write("                let otherEmpty = $(\"#exampleInputEmail1\").val().length === 0;\r\n");
      out.write("\r\n");
      out.write("                $('#exampleInputPassword1').each(function() {\r\n");
      out.write("                    thisEmpty = $(this).val().length === 0;\r\n");
      out.write("\r\n");
      out.write("                });\r\n");
      out.write("\r\n");
      out.write("                if (thisEmpty || otherEmpty)\r\n");
      out.write("                    $('#btn').attr('disabled', 'disabled');\r\n");
      out.write("                else\r\n");
      out.write("                    $('#btn').attr('disabled', false);\r\n");
      out.write("            });\r\n");
      out.write("\r\n");
      out.write("            $('#exampleInputEmail1').blur(function () {\r\n");
      out.write("                if (!checkFields) {\r\n");
      out.write("                    $('#btn').attr('disabled', 'disabled');\r\n");
      out.write("                }\r\n");
      out.write("            });\r\n");
      out.write("\r\n");
      out.write("            $('#exampleInputPassword1').blur(function () {\r\n");
      out.write("                if (!checkFields) {\r\n");
      out.write("                    $('#btn').attr('disabled', 'disabled');\r\n");
      out.write("                }\r\n");
      out.write("            });\r\n");
      out.write("\r\n");
      out.write("            function checkFields() {\r\n");
      out.write("                let thisEmpty = $('#exampleInputEmail1').val().length !== 0;\r\n");
      out.write("                let otherEmpty = $('#exampleInputPassword1').val().length !== 0;\r\n");
      out.write("                return thisEmpty & otherEmpty;\r\n");
      out.write("            }\r\n");
      out.write("                // $(\"#exampleInputEmail2\").on('input keyup', function () {\r\n");
      out.write("                //     if ($(\"#exampleInputEmail2\").val() !== \"\") {\r\n");
      out.write("                //         if ($(\"#exampleInputEmail1\").val() !== \"\") {\r\n");
      out.write("                //             $(\"#btn\").removeAttr(\"disabled\");\r\n");
      out.write("                //         }\r\n");
      out.write("                //     }\r\n");
      out.write("                // });\r\n");
      out.write("\r\n");
      out.write("                $(\"#btn\").click(function () {\r\n");
      out.write("                    if ($(\"#exampleInputEmail1\").val() === '') {\r\n");
      out.write("                        $(\"#exampleInputEmail1\").style.borderColor = 'red';\r\n");
      out.write("                    } else {\r\n");
      out.write("                        let email = $(\"#exampleInputEmail1\").val();\r\n");
      out.write("                        sessionStorage.setItem(\"email\", email);\r\n");
      out.write("                    }\r\n");
      out.write("                })\r\n");
      out.write("            }\r\n");
      out.write("        );\r\n");
      out.write("    </script>\r\n");
      out.write("    <style type=\"text/css\">\r\n");
      out.write("        #loginFormDiv {\r\n");
      out.write("            margin-left: 40%;\r\n");
      out.write("            margin-top: 5%;\r\n");
      out.write("        }\r\n");
      out.write("        .form-control {\r\n");
      out.write("            width: 30%;\r\n");
      out.write("        }\r\n");
      out.write("        #buttons {\r\n");
      out.write("            width: 30%;\r\n");
      out.write("            text-align: center;\r\n");
      out.write("        }\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("    <form id=\"loginForm\" action=\"/shop/login\" method=\"post\"></form>\r\n");
      out.write("    <form id=\"registerForm\" action=\"/shop/registration\" method=\"get\"></form>\r\n");
      out.write("    <div id=\"loginFormDiv\">\r\n");
      out.write("        <div class=\"form-group\">\r\n");
      out.write("            <label for=\"exampleInputEmail1\">Email address</label>\r\n");
      out.write("            <input form=\"loginForm\" type=\"email\" class=\"form-control\" id=\"exampleInputEmail1\" name=\"email\" aria-describedby=\"emailHelp\">\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"form-group\">\r\n");
      out.write("            <label for=\"exampleInputPassword1\">Password</label>\r\n");
      out.write("            <input form=\"loginForm\" type=\"password\" class=\"form-control\" id=\"exampleInputPassword1\" name=\"password\">\r\n");
      out.write("        </div>\r\n");
      out.write("        <div id=\"buttons\">\r\n");
      out.write("            <button form=\"loginForm\" type=\"submit\" class=\"btn btn-primary\" id=\"btn\" disabled=\"disabled\">Log in</button>\r\n");
      out.write("            <button form=\"registerForm\" type=\"submit\" class=\"btn btn-primary\">Register</button>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
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