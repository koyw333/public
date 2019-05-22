<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file = "header.jsp" %>

	<form action="loginCheck" method="POST">

	   아이디 : <input type="text" name="userId">
	비밀번호 : <input type="password" name="userPw">

    		<input type="submit" value="로그인">
    </form>
</body>
</html>