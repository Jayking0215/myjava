<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.*, java.text.*"%>
ex02.jsp
<%--[1]for루프 이용해서 Hello JSP를 5번 출력하세요--%>
<%
	for(int i=1; i<6; i++){
		out.println("<h2>Hello JSP "+i+"</h2>");
	}
%>
<hr color='red'>
<%
	for(int i=1; i<6; i++){
%>
	<h2>Hi JSP <%=i%></h2>
<%
	}
%>
<hr color='blue'>
<%--
[2] while루프 이용해서 구구단 8단을 출력하세요
--%>
<table border="1">
<%
	int i=1;
	int dan=8;
	while(i<10){
%>
	<tr><td><%=dan%>*<%=i%>=<%=dan*i%></td></tr>
<%
		i++;
	}
%>
</table>