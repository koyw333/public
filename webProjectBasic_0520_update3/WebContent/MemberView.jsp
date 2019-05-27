<%@page import="org.web.memberDTO.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%	
//로그인 된 상태에서 조회
	if(session.getAttribute("sessionId")==null){
		response.sendRedirect("index.jsp");
	}	
	MemberDTO member = (MemberDTO)request.getAttribute("member");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 회원 조회 </title>
<script>

	function modifyOk(){
	
		console.log("modifyOk함수 호출");
		
		//선택
		var modifyForm=document.joinForm;//전체 form의 name;
		//userId
		//	document.joinForm.userId;// name값 userId;
		
		
		//아이디값이 없으면 회원가입 절차를 중지//form의 input의 value		
		if(modifyForm.userId.value==null || modifyForm.userId.value==""){
			alert("아이디 입력오류.. 다시 입력해주세요!");			
			modifyForm.userId.focus();			
			return false;//joinOk함수 종료
		}
		//비빌번호값이 없으면 회원가입 절차를 중지//form의 input의 value		
		if(modifyForm.userPw.value==null || modifyForm.userPw.value==""){
			alert("비빌번호 입력오류.. 다시 입력해주세요!");
			modifyForm.userPw.focus();
			return false;//joinOk함수 종료
		}
		//이름
		//비빌번호값이 없으면 회원가입 절차를 중지//form의 input의 value		
		if(modifyForm.userName.value==null || modifyForm.userName.value==""){
			alert("이름 입력오류.. 다시 입력해주세요!");
			joinForm.userName.focus();
			return false;//joinOk함수 종료
		}
		
		//나이 
		//비빌번호값이 없으면 회원가입 절차를 중지//form의 input의 value		
		if(modifyForm.userAge.value==null || modifyForm.userAge.value==""){
			alert("나이 입력오류.. 다시 입력해주세요!");
			modifyForm.userAge.focus();
			return false;//joinOk함수 종료
		}
		
		
		alert("회원 가입 실행 ")
		
		modifyForm.submit();// form의 정보를 서버에 전송...action="JOIN.do"
		
	}

</script>

</head>
<body>
<%@include file="header.jsp" %>

<div style="background:#9e9e9e;width:80%;padding:20px 0;margin:0 auto">

	<form action="MeemberModify.do" method="POST" name="joinForm" id="frm" style="background:#fff;width:400px;margin:0 auto;line-height:50px;">

		아이디: <%= member.getUserID() %> 
				<input type="text" name="userId" value="<%=member.getUserID()%>" id="userId" size="10" maxlength="10">
		비빌번호: <input type="password" name="userPw" id="userPw"  size="10" maxlength="10"><br>		
		이름: <input type="text" name="userName" id="member.getUserName"><br>
		나이: <input type="text" name="userAge" id="member.getUserAge"><br>
		
		<input type="reset" value="초기화">
		
		<input type="button" onclick="modifyOk()"  value="회원 가입">
			<!-- button클릭하면 joinOk()함수를 호출 -->
	</form>

</div>
<script>
	function idChecked(){
		
		var userId=document.joinForm.userId;// name이름  joinForm 아래 있는 userId
		
		if(userId==null || userId==""){
			alert("아이디값 오류..다시 입력하세요.")
			userId.focus();//
			return false;
		}
		
		alert("아이디체크 실행");
		
			// Controller 전송
		location.href="MemberIdChecked.do?userId="+userId.value;
		
	}

</script>	

<%@ include file="footer.jsp" %>


</body>
</html>