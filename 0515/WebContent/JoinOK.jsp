<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
//자바코드
String userId = request.getParameter("userId");
String userPw = request.getParameter("userPw");
String useruserPWchecked = request.getParameter("useruserPWchecked");
String userGender = request.getParameter("userGender");
String guest = request.getParameter("guest");

String[] hobbyArr = request.getParameterValues("hobby");
String[] phoneArr = request.getParameterValues("phone");

%>

<!-- 표현식 -->
아이디 : <%=userId %>
비밀번호 : <%=request.getParameter("userPw") %>
성별 : <%=userGender %>
방명록 : <%=guest%>

<%
String hobbyStr ="";
for(String str:hobbyArr){
	
}




z



%>
</body>
</html>