<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
		<form action = "MemberJoin.do" method = "post" id = "join">
			아이디 : <input type = "text" name = "userId" id = "userId"> <br>
			비밀번호 : <input type = "password" name = "userPw" id = "userPw"> <br>
			이름 : <input type = "text" name = "userName"> <br>
			이메일 : <input type = "text" name = "userEmail"> <br>		
			<input type = "submit" value = "회원가입"> <br><br>
		</form>
	
</body>
</html>