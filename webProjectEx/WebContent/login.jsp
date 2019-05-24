<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function LoginOk()
	var loginForm=document.loginForm;
	
	if(loginForm.userId.value==null || loginForm.userId.value==""){
		alert("아이디 입력오류.. 다시 입력해주세요")
		loginForm.userId.focus();
		return false;
	}
	if(loginForm.userPw.value==null || loginForm.userPw.value==""){
		alert("비밀번호 입력오류.. 다시 입력해주세요")
		loginForm.userPw.focus();
		return false;
	
	alert("로그인GO");
	
	loginForm.submit();
	
</script>
</head>
<body>
<%@ include file ="header.jsp" %>
<div>
	<form action ="Login.do" name="LoginForm" method="post" id="LoginForm">
	  아이디 : <input type ="text" name="userId" id ="userId"><br>
	 비밀번호 : <input type ="password" name="userPw" id ="userPw"><br>
	
	<input type ="button" id ="LoginBtn" onclick="LoginOk()" value ="로그인 실행">
	</form>
</div>
</body>
</html>