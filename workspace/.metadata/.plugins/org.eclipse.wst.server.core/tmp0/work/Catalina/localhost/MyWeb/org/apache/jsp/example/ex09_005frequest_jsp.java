/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.73
 * Generated at: 2023-04-19 08:47:17 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.example;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class ex09_005frequest_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/top.jsp", out, false);
      out.write("\r\n");
      out.write("	<div class=\"container\">\r\n");
      out.write("		<h1>request의 주요 메서드</h1>\r\n");
      out.write("	");

		String server=request.getServerName();//서버 도메인명
		int port=request.getServerPort();//서버에서 열어둔 포트번호
		StringBuffer buf=request.getRequestURL();//전체 URL을 반환
		String url=buf.toString();
		String uri=request.getRequestURI();
		//uri=>콘텍스트명 이후 경로를 반환
			//MyWeb/example/ex09_request.jsp
		String ctx=request.getContextPath();//"/MyWeb"
		String qStr=request.getQueryString();//query string을 반환
		String clientIp=request.getRemoteAddr();//client IP주소를 반환
		String proto=request.getProtocol();
		String path=request.getServletPath();//컨텍스트명을 포함하지 않는 경로 문자열을 반환
		
		//[실습1]: uri문자열에서 "/example/ex02_request.jsp" 문자열을 추출해서 출력하세요
    	String exp1=uri.replace(ctx,"");
		//[실습2]: uri문자열에서 "/example/ex02_request" 문자열을 추출해서 출력하세요
		String exp2=exp1.replace(".jsp","");
	
		int index=path.lastIndexOf(".jsp");
		//검색 문자열을 뒤에서 부터 찾아서 해당 인덱스 번호를 반환한다(없으면 -1)
		System.out.println(index);
		if(index>0){
			//path=path.substring(0,index);
		}
	
      out.write("\r\n");
      out.write("	<h2>서버 도메인명: ");
      out.print(server);
      out.write("</h2>\r\n");
      out.write("	<h2>서버 포트번호: ");
      out.print(port);
      out.write("</h2>\r\n");
      out.write("	<h2>요청 URL  : ");
      out.print(url);
      out.write("</h2>\r\n");
      out.write("	<h2>요청 URI  : ");
      out.print(uri);
      out.write("</h2>\r\n");
      out.write("	<h2>컨텍스트명  : ");
      out.print(ctx);
      out.write("</h2>\r\n");
      out.write("	<h2>쿼리 스트링 : ");
      out.print(qStr);
      out.write("</h2>\r\n");
      out.write("	<h2>클라이언트 IP: ");
      out.print(clientIp);
      out.write("</h2>\r\n");
      out.write("	<h2>프로토콜    : ");
      out.print(proto);
      out.write("</h2>\r\n");
      out.write("	<h2>서블릿 패스 : ");
      out.print(path);
      out.write("</h2>\r\n");
      out.write("	<h2>");
      out.print(exp1);
      out.write("</h2>\r\n");
      out.write("	<h2>");
      out.print(exp2);
      out.write("</h2>\r\n");
      out.write("	<h2></h2>\r\n");
      out.write("	</div>\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/foot.jsp", out, false);
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
