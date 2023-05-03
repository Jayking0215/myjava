<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="user.model.*" %>
 <%
 	//컨텍스트명 알아내기
 	String myctx=request.getContextPath();
 	//System.out.println("myctx="+myctx); //=> "/MyWeb"
 	UserVO loginUser=(UserVO)session.getAttribute("loginUser");
 	
 	boolean isLogin=(loginUser==null)?false:true;
	
 %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>homepage</title>
	<!-- layout.css link참조 -->
    <link rel="stylesheet" type="text/css" href="<%=myctx%>/css/layout.css">

</head>
<body>
    <div id="wrap">
		<!-- header: logo이미지, 검색form, 목차 등 -->
		<header>
			<!-- header -->
			<a href="main.jsp">
				<img src="<%=myctx%>/images/logo.png" alt="1">
			</a>
		</header>
		<div class="cls"></div>
		<!-- nav-bar: menu -->
		<nav>
			<!-- nav -->
			<ul>
				<li><a href="<%=myctx%>/main.jsp">HOME</a></li>
				<%
				if(!isLogin){//로그인 안했을 경우
				%>
					<li><a href="<%=myctx%>/member/join.jsp">SignUp</a></li>
					<li><a href="<%=myctx%>/login/login.jsp">SignIn</a></li>
				<%}else{//로그인 했을 경우 %>
					<li><a href="<%=myctx%>/login/logout.jsp">Logout</a></li>
				<%}%>
				<li><a href="<%=myctx%>/board/list.jsp">Board</a></li>
				<li><a href="<%=myctx%>/member/list.jsp">Users</a></li>
				
				<% if(isLogin){ %>
				<li style="background-color:#19376D; border-radius:5px">
				<a href="#" style="color:white"><%=loginUser.getUserid()%>님 로그인 중...</a></li>
				<%}%>
			</ul>
		</nav>
		<div class="cls"></div>
		<!-- article: contents영역 -->
		<article>