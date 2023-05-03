/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.73
 * Generated at: 2023-04-20 00:15:13 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class idCheck_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"../css/layout.css\">\r\n");
      out.write("<script type=\"text/javascript\" src=\"../js/userCheck.js\"></script>\r\n");
 
	//요청방식
	String method=request.getMethod();
	out.println(method+"<br>");
	//GET방식일때는 아이디 입력 폼을 보여주고
	//POST방식일때는 아이디 사용 가능 여부 결과를 보여주자
	if(method.equalsIgnoreCase("get")){

      out.write("\r\n");
      out.write("<div class=\"container m2\" style=\"margin-top:2em\">\r\n");
      out.write("	<form name=\"idf\" action=\"idCheck.jsp\" method=\"post\">\r\n");
      out.write("		<label for=\"userid\">아이디</label>\r\n");
      out.write("		<input type=\"text\" name=\"userid\" id=\"userid\" placeholder=\"User ID\" autofocus=\"autofocus\">\r\n");
      out.write("		<button type=\"button\" onclick=\"id_check()\">확  인</button>\r\n");
      out.write("	</form>\r\n");
      out.write("</div>\r\n");
 }else{	
		//post방식일때- 사용자가 입력한 아이디값 받기
		String userid=request.getParameter("userid");
	
      out.write('\r');
      out.write('\n');
      user.model.UserDAO userDao = null;
      synchronized (session) {
        userDao = (user.model.UserDAO) _jspx_page_context.getAttribute("userDao", javax.servlet.jsp.PageContext.SESSION_SCOPE);
        if (userDao == null){
          userDao = new user.model.UserDAO();
          _jspx_page_context.setAttribute("userDao", userDao, javax.servlet.jsp.PageContext.SESSION_SCOPE);
        }
      }
      out.write('\r');
      out.write('\n');
 
	boolean isUse=userDao.idCheck(userid);
	if(isUse){

      out.write("	\r\n");
      out.write("<div class=\"container m2\" style=\"margin-top:2em\">\r\n");
      out.write("	<h3>ID로 [<span class=\"ck\">");
      out.print(userid);
      out.write("</span>]을 사용할 수 있습니다</h3>\r\n");
      out.write("	<br>\r\n");
      out.write("	<button onclick=\"set_id('");
      out.print(userid);
      out.write("')\">닫  기</button>\r\n");
      out.write("</div>    \r\n");
 
	}else{

      out.write("\r\n");
      out.write("<div class=\"container m2\" style=\"margin-top:2em\">\r\n");
      out.write("	<h3>ID로 [<span class=\"ck\">");
      out.print(userid);
      out.write("</span>]은 이미 사용중 입니다</h3>\r\n");
      out.write("	<br>\r\n");
      out.write("	\r\n");
      out.write("	<form name=\"idf\" action=\"idCheck.jsp\" method=\"post\">\r\n");
      out.write("		<label for=\"userid\">아이디</label>\r\n");
      out.write("		<input type=\"text\" name=\"userid\" id=\"userid\" placeholder=\"User ID\" autofocus=\"autofocus\">\r\n");
      out.write("		<button type=\"button\" onclick=\"id_check()\">확  인</button>\r\n");
      out.write("	</form>\r\n");
      out.write("</div>\r\n");

	}//else------
}//else------------------- 
      out.write("\r\n");
      out.write("\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
