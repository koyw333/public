<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

String rs=(String)request.getAttribute("rs");
String userId=(String)request.getAttribute("userId");
String OkChecked=(String)request.getAttribute("OkChecked");


%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<% 
	if(rs.equals("1")){
%>
	<script>
	alert("중복아이디 입니다.")
	location.href="formEx.jsp";
	</script>
<%
	}else if(rs.equals("0")){
%>
	<script>
	alert("사용가능한 아이디입니다.")
	location.href="join.jsp?userId="+<%=userId%>+"&OkChecked="+<%=OkChecked%>;
	</script>
<%	
	}
%>








</body>
</html>