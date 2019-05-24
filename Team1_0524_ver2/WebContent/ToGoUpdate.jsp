<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div style="width : 100%; height : 10%; background : #00FC86">
		<a href = "index_login.jsp"> |   홈   | </a>
	</div>
	
	<div style="width : 100%; height : 80%">
		비밀번호 입력 <br>
		<form action = "CheckPW.do" method = "post" id = "join">
			아이디 : <%=session.getAttribute("sessionID") %> <br>
			비밀번호 : <input type = "password" name = "userPW" id = "userPW"> <br>
			<input type = "submit" value = "수정"> <br><br>
		</form>
	</div>
	
	<div style="width : 100%; height : 10%; background : #00FC86">
		<br><br><br><br><%@ include file = "footer.jsp" %>	
	</div>


</body>
</html>