<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 수정 창</title>
</head>
<body>

	<div style="width : 100%; height : 10%; background : #00FC86">
		<%@ include file = "header.jsp" %> <br><br><br><br>
	</div>
	
	<div style="width : 100%; height : 80"%>
		수정창 <br>
		<form action = "MemberUpdate.do" method = "post" id = "join">
			아이디 : <%=session.getAttribute("userID") %> <br>
			비밀번호 : <input type = "password" name = "userPW" id = "userPW"
				value = <%=session.getAttribute("userPW") %>> <br>
			이름 : <input type = "text" name = "userName"
				value = <%=session.getAttribute("userName") %>> <br>
			이메일 : <input type = "text" name = "userEmail"
				value = <%=session.getAttribute("userEmail") %>> <br>		
			<input type = "submit" value = "회원수정"> <br><br>
		</form>
	</div>
	
	<div style="width : 100%; height : 10%; background : #00FC86">
		<br><br><br><br><%@ include file = "footer.jsp" %>	
	</div>

</body>
</html>