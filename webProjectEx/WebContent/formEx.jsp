<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String val1 ="";
	if(request.getParameter("userId")!=null){
		val1 = request.getParameter("userId");
	}
	String val2 ="unChecked";
	if(request.getParameter("OkChecked")!=null){
		val2 = request.getParameter("OkChecked");
	}
		
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>form정리</title>
<script>
	function joinOK(){
		console.log("joinOK 함수 호출")
		
		//선택
		var joinForm=document.joinForm;//전체 form의 name;
		//userID
		//document.joinFrom.userId; // name값 userId;
		

		//아이디 값이없으면 회원가입 절차를 중지
		if(joinForm.userId.value==null || joinForm.userId.value==""){//form의 input의 value
			alert("아이디 입력 오류.. 다시 입력해 주세요!")
		return false;
		}
	} 
</script>
</head>
<body>

	<form action="JOIN.do" method="POST" name="joinFrom" id="frm" enctype="">

		아이디: <input type="text" name="userId" value="<%=val1%>" id="userId" size="10" maxlength="10">
			  <input type="button" value="아이디체크" id="idCheckOk">  <br>
			  <input type="hidden" name="idcheck" value="<%=val2%>">
		비빌번호: <input type="password" name="userPw" id="userPw"  size="10" maxlength="10"><br>		
		이름: <input type="text" name="userName" id="userName"><br>
		나이: <input type="text" name="userAge" id="userAge"><br>	
		
		<input type="reset" value="초기화">
		<input type="button" onclick="joinOK()" value="회원 가입">
				<!--  button 클릭하면 joinOK() 함수 호출 -->
			
	</form>

<script>
	function idChecked(){
		var userId= document.formEx.userId; //name 이름 fromEx 아래의 userID
		
		if(userId==null || userId===""){
			alert("아이디값 오류.. 다시 입력하세요")
			userId.focus();//
			return false;
		}
		//contrroller전송
		location.href="MemberIdChecked.do?userId="+userId.value;
		
			
		}
	}
}


</script>

</body>
</html>