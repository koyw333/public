<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<%
	String valUserID = "";
	String valUserPW = "";
	
	if (request.getParameter("userID") != null) {
		valUserID = request.getParameter("userID");
	}
%>

<script>

	function deleteCheck() {
		
		console.log("들어왔다");
		
		var deleteForm = document.deleteForm;
		// 텍스트 박스에 입력된 ID, PW 변수에 저장
		var NewUserID = deleteForm.userID.value;
		var NewUserPW = deleteForm.userID.value;
		// 로그인 한 ID, PW 변수에 저장
		var oldUserID = "<%=session.getAttribute("userID")%>";
		var oldUserPW = "<%=session.getAttribute("userPW")%>";
		
		console.log(NewUserID);
		
		if (NewUserID == null || NewUserID == "" || NewUserPW == null || NewUserPW == "") {
			alert("아이디와 비밀번호를 모두 입력해주세요");
			NewUserID = "";
			NewUserPW = "";
			deleteForm.userID.focus();
			return false;
		} else if (NewUserID != oldUserID
		|| NewUserPW != oldUserPW) {
			alert("아이디와 비밀번호가 일치하지 않습니다");
			NewUserID = "";
			NewUserPW = "";
			deleteForm.userID.focus();
			return false;
		} else if (NewUserID == oldUserID
		&& NewUserPW == oldUserPW) {
			alert("회원탈퇴에 성공하셨습니다");
			deleteForm.submit();
		}
		
	}

</script>

</head>
<body>

	<div style="width : 100%; height : 10%; background : #00FC86">
		<%@ include file = "header.jsp" %> <br><br><br><br>
	</div>
	
	<div style="width : 100%; height : 80%;">
	
		<form action = "MemberDelete.do" method = "post" name = "deleteForm" id = "delete">
			<%=session.getAttribute("userName") %>님 
			회원탈퇴를 원하시면 등록하신 아이디와 비밀번호를 입력해주세요.<br> 
			
			아이디 : <input type = "text" name = "userID" id = "userID"
					value = "<%=valUserID%>"> <br>	
			비밀번호 : <input type = "password" name = "userPW" id = "userPW"
					value = "<%=valUserPW%>">		
									 
			<input type = "button" onclick = "deleteCheck()" value = "회원탈퇴"> <br><br>
			
		</form>
		
	</div>
	
	<div style="width : 100%; height : 10%; background : #00FC86">
		<br><br><br><br><%@ include file = "footer.jsp" %>	
	</div>

</body>
</html>