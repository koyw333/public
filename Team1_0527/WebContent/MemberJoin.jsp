<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>

<script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>

<meta charset="UTF-8">
<title>회원가입</title>

<%

	String valUserID = "";
	String valIfCheck = "unChecked";
	String valUserPW = "";
	String valUserName = "";
	String valUserEmail = "";
	
	
	if (request.getParameter("userID") != null) {
		valUserID = request.getParameter("userID");
		System.out.println("회원가입창 아이디 : " + valUserID);
	}
	
	if (request.getParameter("Checked") != null) {
		valIfCheck = request.getParameter("Checked");
	}
	
	if (request.getParameter("userName") != null) {
		valUserName = request.getParameter("userName");
	}
	
	if (request.getParameter("userEmail") != null) {
		valUserEmail = request.getParameter("userEmail");
	}
	
%>

<script>

	function idCheck() {
		
		var userID = document.joinForm.userID.value; // 전체 form의 name
		var userName = document.joinForm.userName.value;
		var userEmail = document.joinForm.userEmail.value;
		
		if (userID == null || userID == "") {
			alert("아이디값 오류");
			document.joinForm.userID.focus();
			return false;
		}
		//////////////////// 아이디에 한글 입력하지 못하게 ////////////////////////////////////
		for (var i = 0; i < document.joinForm.userID.value.length; i++) {
            ch = document.joinForm.userID.value.charAt(i)
            if (!(ch >= '0' && ch <= '9') && !(ch >= 'a' && ch <= 'z')&&!(ch >= 'A' && ch <= 'Z')) {
                alert("아이디는 영문 대소문자, 숫자만 입력가능합니다.")
                document.joinForm.userID.focus();
                return false;
            }
        }
   		/////////////////////////////////////////////////////////////////////////////
   		//////////////////////////////// 아이디 글자 수 검사 //////////////////////////////
   		if (document.joinForm.userID.value.length<4 || document.joinForm.userID.value.length>12) {
            alert("아이디를 4~12자까지 입력해주세요.")
            document.joinForm.userID.focus();
            return false;
        }
   		/////////////////////////////////////////////////////////////////////////////
		
		console.log("아이디체크 실행");
		
		// Controller 전송
		location.href = "MemberCheckedID.do?userID=" + userID
				+ "&userName=" + userName + "&userEmail=" + userEmail;
		
	}

</script>

<script>

	function joinOK() {
		
		//console.log(joinForm.userID.value);
		//console.log(joinForm.userPW.value);
		//console.log(joinForm.userName.value);
		//console.log(joinForm.userEmail.value);
		
		
		// 선택
		var joinForm = document.joinForm; // 전체 form의 name
		
		// userID 선택 : joinForm.userID
		// 아이디 값이 없으면 회원가입 절차를 중지
		if (joinForm.userID.value == null || joinForm.userID.value == "") {
			alert("아이디 입력 오류");
			joinForm.userID.focus();
			return false;
		}
		
		if (joinForm.userPW.value == null || joinForm.userPW.value == "") {
			alert("비밀번호 입력 오류");
			joinForm.userPW.focus();
			return false;
		}
		
		if (joinForm.userName.value == null || joinForm.userName.value == "") {
			alert("이름 입력 오류");
			joinForm.userName.focus();
			return false;
		}
		
		if (joinForm.userEmail.value == null || joinForm.userEmail.value == "") {
			alert("이메일 입력 오류");
			joinForm.userEmail.focus();
			return false;
		}
		
		/*
		var userName = joinForm.userName.value;
		
		location.href = "MemberCheckedName.do?userName=" + userName;
		*/
		
		if (joinForm.ifCheck.value == "unChecked") {
			alert("아이디를 체크해주세요");
			joinForm.userID.focus();
			return false;
		} else {
			//alert("회원 가입 성공");
			joinForm.submit();
		}
		
	}	
	
</script>

</head>
<body>"
	<div style="width : 100%; height : 10%; background : #00FC86">
		<%@ include file = "header.jsp" %> <br><br><br><br>
	</div>
	
	<div style="width : 100%; height : 80%">
		회원가입!! <br>
		<form action = "MemberJoin.do" method = "post" name = "joinForm" id = "join">
			아이디 : <input type = "text" name = "userID" id = "userID" value = "<%=valUserID %>">
				   <input type = "button" onclick = "idCheck()" value = "아이디 중복 확인" id = "idCheckOK"> <br>
				   <input type = "hidden" name = "ifCheck" value = "<%=valIfCheck %>">
			비밀번호 : <input type = "password" name = "userPW" id = "userPW"> <br>
			이름 : <input type = "text" id = "userName" name = "userName" value = "<%=valUserName %>"> <br>
			이메일 : <input type = "text" name = "userEmail" value = "<%=valUserEmail %>"> <br>		
			<input type = "button" onclick = "joinOK()" value = "회원가입"> <br><br>
		</form>
	</div>
	
	<div style="width : 100%; height : 10%; background : #00FC86">
		<br><br><br><br><%@ include file = "footer.jsp" %>	
	</div>

</body>
</html>