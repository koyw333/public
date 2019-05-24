<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션 값 확인</title>
</head>
<body>

	로그인 세션 값 확인!!! <br>
	아이디 : <%=session.getAttribute("sessionID") %> <br>
	비밀번호 : <%=session.getAttribute("sessionPW") %> <br> 
	이름 : <%=session.getAttribute("sessionName") %> <br>
	이메일 : <%=session.getAttribute("sessionEmail") %> <br>
	
</body>
</html>