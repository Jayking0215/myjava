<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/top.jsp"/>
	<div style="padding:2em">
		<h1>request - form</h1>
		<br><br>
		<form id="frm" action="ex08_requestResult.jsp" method="get">
		Name: <input type="text" name="userName" placeholder="write your name"><br>
		ID: <input type="text" name="userid"><br>
		Password: <input type="password" name="userpw" placeholder="password"><br>
		Photo: <input type="file" name="photo"><br>
		
		Sex: 
		<input type="radio" name="gender" value="M">Male
		<input type="radio" name="gender" value="F" checked>Female
		<br>
		<!-- 
			단일선택 radio버튼(같은 name일 경우 그 중 1개만 선택가능)
			다중선택 checkbox버튼
		-->
		Hobby: 
		<input type="checkbox" name="hobby" value="Sports" checked="checked">Sports
		<input type="checkbox" name="hobby" value="Reading">Reading
		<input type="checkbox" name="hobby" value="Music">Listening
		<input type="checkbox" name="hobby" value="Movie">Watching
		<br>		
		<!-- 
			select : 
			-단일선택(기본), 
			-multiple속성(다중선택)
			-size속성(펼친형태)
		 -->
		DropdownList:
		<select name="job">
			<option value="">::select a job</option>
			<option value="Developer">Developer</option>
			<option value="Designer">Designer</option>
			<option value="Teacher">Teacher</option>
		</select>
		<br>
		<select name="lang" multiple size="7">
			<option value="">::useable Language</option>
			<option value="HTML">HTML</option>
			<option value="Java">Java</option>
			<option value="SQL">SQL</option>
			<option value="JavaScript">JavaScript</option>
		</select>
		<br>
		PR:
		<textarea name="intro" cols="70" rows="5" placeholder="PR under 100 words"></textarea>
		<br>
		Hidden field:
		<input type="hidden" name="secret" value="TopSecret">
		<br>
		<!-- 
			submit버튼 : 서버로 데이터를 전송하는 버튼
			reset버튼 : 초기화 기능
			button버튼 : 아무기능 없음 => JavaScript와 함께 사용
		-->
		<input type="submit" value="Join">
		<input type="reset" value="Reset">
		<input type="button" value="Button" onclick="alert('May i help you?')">
		<!-- 이미지 버튼 -->
		<a onclick="alert('GoodBye~')"><img src="images/icon2.png"></a>

		<!-- input type="image" => submit 기능을 갖는다 -->
		<input type="image" src="images/login.png">
		
	</form>
	</div>
<jsp:include page="/foot.jsp"/>