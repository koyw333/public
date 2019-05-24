<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 수정 창</title>

<script>

	function update() {
		
		var updateForm = document.updateForm;
		var userPW = updateForm.userPW.value;
		var userName = updateForm.userName.value;
		var userEmail = updateForm.userEmail.value;
		
		if (userPW == null || userPW == "") {
			alert("비밀번호를 입력해주세요");
			updateForm.userPW.focus();
			return false
		}
		
		if (userName == null || userName == "") {
			alert("이름을 입력해주세요");
			updateForm.userName.focus();
			return false
		}
		
		if (userEmail == null || userEmail == "") {
			alert("이메일을 입력해주세요");
			updateForm.userEmail.focus();
			return false
		}
		
	}

</script>

</head>
<body>

	<div style="width : 100%; height : 10%; background : #00FC86">
		<%@ include file = "header.jsp" %> <br><br><br><br>
	</div>
	
	<div style="width : 100%; height : 80%">
		수정창 <br>
		<form action = "MemberUpdate.do" method = "post" name = "updateForm" id = "update">
			아이디 : <%=session.getAttribute("sessionID") %> <br>
			비밀번호 : <input type = "password" name = "userPW" id = "userPW"
				value = ""> <br>
			이름 : <input type = "text" name = "userName"
				value = <%=session.getAttribute("sessionName") %>> <br>
			이메일 : <input type = "text" name = "userEmail"
				value = <%=session.getAttribute("sessionEmail") %>> <br>		
			<input type = "button" onclick = "update()" value = "회원수정"> <br><br>
		</form>
	</div>
	
	<div style="width : 100%; height : 10%; background : #00FC86">
		<br><br><br><br><%@ include file = "footer.jsp" %>	
	</div>

</body>
</html>