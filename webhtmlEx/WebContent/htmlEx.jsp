<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html><!-- 문서지정형식 HTML5 버전 -->	
<html>
<head>
<meta charset="UTF-8"><!--  한글 처리 -->
<title>JSP, HTML 기본</title>
</head>
<body>
		
		
	<form action = "memberJoin.do" method ="get" id="join">
	
                    아이디 :   <input type = "text" name ="userId" id="userId"><br>
                    비밀번호 : <input type = "password" name = "userPw" id ="userPw"><br>
                    이름 :    <input type = "text" name = "userName" id ="userName"><br>
                    나이 :    <input type = "text" name = "userAge" id ="userAge"><br>
                  <input type = "submit" value = "서버에전송">
	</form>
	
</body>
</html>