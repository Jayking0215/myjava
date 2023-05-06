<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, board.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="vo" class="board.BoardVO"/>
<jsp:useBean id="dao" class="board.BoardDAO"/>
<jsp:setProperty name="vo" property="*"/>

<%
	dao.updateBoard(vo);
	pageContext.setAttribute("vo",vo);
	//responce.sendRedirect(reuest.getContextPath()+"/board/list.jsp");
%>
<c:redirect url="${paeContext.request.contextPath}/board/boardDetail.jsp?num=${vo.num}"/>
