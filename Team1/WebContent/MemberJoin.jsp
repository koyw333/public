<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>

	<div style="width : 100%; height : 10%; background : #00FC86">
		<%@ include file = "header.jsp" %> <br><br><br><br>
	</div>
	
	<div style="width : 100%; height : 80%; background : #313F35">
		회원가입!! <br>
		<form action = "MemberJoin.do" method = "post" id = "join">
			아이디 : <input type = "text" name = "userID" id = "userID"> <br>
			비밀번호 : <input type = "password" name = "userPW" id = "userPW"> <br>
			이름 : <input type = "text" name = "userName"> <br>
			이메일 : <input type = "text" name = "userEmail"> <br>		
			<input type = "submit" value = "회원가입"> <br><br>
		</form>
	</div>
	
	<div style="width : 100%; height : 10%; background : #00FC86">
		<br><br><br><br><%@ include file = "footer.jsp" %>	
	</div>

</body>
</html>