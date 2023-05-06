<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, board.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:useBean id="dao" class="board.BoardDAO"/>
<%
	int num=Integer.parseInt(request.getParameter("num"));
	dao.deleteBoard(num);
%>
<c:redirect url="${paeContext.request.contextPath}/board/list.jsp"/>
