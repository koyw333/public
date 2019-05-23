<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
						<% System.out.println("Login.jsp");%>
		<form action = "MemberLogin.do" method = "post" id = "login">
			아이디 : <input type = "text" name = "userId" id = "userId"> <br>
			비밀번호 : <input type = "password" name = "userPw" id = "userPw"> <br>
			<input type = "submit" value = "로그인">
		</form>

</body>
</html>