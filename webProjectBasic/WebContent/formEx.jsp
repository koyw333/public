<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>form</title>
</head>
<body>

	<form action="JOIN.do" method="POST" id="form" enctype="">

		아이디: <input type="text" name="userId" id="userId" size="10" maxlength="10">
			  <input type="button" value="아이디체크" id="idCheckOk">  <br>
			  <input type="hidden" value="unChecked">
		비빌번호: <input type="password" name="userPw" id="userPw"  size="10" maxlength="10"><br>		
		이름: <input type="text" name="userName" id="userName"><br>
		이메일 : <input type="text" name="userEmail" id="userEmail"><br>
		
		<input type="reset" value="초기화">
		<input type="submit" value="회원 가입">
			
	</form>


</body>
</html>