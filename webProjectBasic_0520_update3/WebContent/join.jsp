<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%	

	String val1="";

	if(request.getParameter("userId")!=null){
		val1=request.getParameter("userId");
	}
	String val2="unChecked";
	
	if(request.getParameter("OkChecked")!=null){
		val2=request.getParameter("OkChecked");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>form정리</title>
<script>

	function joinOk(){
	
		console.log("joinOk함수 호출");
		
		//선택
		var joinForm=document.joinForm;//전체 form의 name;
		//userId
		//	document.joinForm.userId;// name값 userId;
		
		if(joinForm.idcheck.value=="unChecked"){
			
			alert("아이디 체크를 해주세요...");
			
			document.getElementById("idCheckOk").focus();
			
			return false;
		}
		
		
		//아이디값이 없으면 회원가입 절차를 중지//form의 input의 value		
		if(joinForm.userId.value==null || joinForm.userId.value==""){
			alert("아이디 입력오류.. 다시 입력해주세요!");			
			joinForm.userId.focus();			
			return false;//joinOk함수 종료
		}
		//비빌번호값이 없으면 회원가입 절차를 중지//form의 input의 value		
		if(joinForm.userPw.value==null || joinForm.userPw.value==""){
			alert("비빌번호 입력오류.. 다시 입력해주세요!");
			joinForm.userPw.focus();
			return false;//joinOk함수 종료
		}
		//이름
		//비빌번호값이 없으면 회원가입 절차를 중지//form의 input의 value		
		if(joinForm.userName.value==null || joinForm.userName.value==""){
			alert("이름 입력오류.. 다시 입력해주세요!");
			joinForm.userName.focus();
			return false;//joinOk함수 종료
		}
		
		//나이 
		//비빌번호값이 없으면 회원가입 절차를 중지//form의 input의 value		
		if(joinForm.userAge.value==null || joinForm.userAge.value==""){
			alert("나이 입력오류.. 다시 입력해주세요!");
			joinForm.userAge.focus();
			return false;//joinOk함수 종료
		}
		
		
		alert("회원 가입 실행 ")
		
		joinForm.submit();// form의 정보를 서버에 전송...action="JOIN.do"
		
	}

</script>

</head>
<body>
<%@include file="header.jsp" %>

<div style="background:#9e9e9e;width:80%;padding:20px 0;margin:0 auto">

	<form action="JOIN.do" method="POST" name="joinForm" id="frm" style="background:#fff;width:400px;margin:0 auto;line-height:50px;">

		아이디: <input type="text" name="userId" value="<%=val1 %>" id="userId" size="10" maxlength="10">
			  <input type="button" value="아이디체크" onclick="idChecked()" id="idCheckOk">  <br>	  			  
			  <input type="hidden" name="idcheck" value="<%=val2 %>">
		
		비빌번호: <input type="password" name="userPw" id="userPw"  size="10" maxlength="10"><br>		
		이름: <input type="text" name="userName" id="userName"><br>
		나이: <input type="text" name="userAge" id="userAge"><br>
		
		<input type="reset" value="초기화">
		
		<input type="button" onclick="joinOk()"  value="회원 가입">
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