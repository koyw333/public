<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="MemberJoin.do" method = "POST" id = "join">
	
		아이디 : <input type="text" name ="userId" id ="userId"><br>
		비밀번호 : <input type="password" name ="userPw" id ="userPw"><br>
		이름 : <input type="text" name ="userName" id ="userName"><br>
		나이 : <input type="text" name ="userAge" id ="userAge"><br>
		
		성별 : <input type="radio" name ="userGender" id ="userGender">남자
			 <input type="radio" name ="userGender" id ="userGender">여자
			 <input type="reset" value="초기화">
			 <input type="submit" value="서버에 전송">
			 
	</form>
</body>
</html>