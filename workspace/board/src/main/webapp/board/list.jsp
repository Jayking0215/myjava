<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, board.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% 
	BoardDAO dao=new BoardDAO();
	List<BoardVO> ls=dao.listBoard();
	pageContext.setAttribute("ls",ls);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list.jsp</title>
</head>
<body>
<h2>게시글 목록</h2>
<table border="1">
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>등록일</th>
		<th>조회수</th>
	</tr>
<c:forEach var="board" items="${ls}">
	<tr>
		<td>${board.num}</td>
		<td><a href="${pageContext.request.contextPath}/board/boardDetail.jsp?num=${board.num}">${board.title}</a></td>
		<td>${board.writer}</td>
		<td>${board.regdate}</td>
		<td>${board.cnt}</td>
	</tr>
</c:forEach>
</table>
<a href="<c:url value="/board/registForm.jsp"/>"><button>글 등록</button></a>
<p>${board}</p>
</body>
</html>