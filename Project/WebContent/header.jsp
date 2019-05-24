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
	if(session.getAttribute("sessionid")==null){
%>
<a href = "Index.jsp">메인화면</a>
<a href = "MemberLogin.jsp"> 로그인 </a>
<a href = "MemberJoin.jsp"> 회원가입 </a>
<a href = "MemberList.do"> 조 회</a><br><br>
<%
	}else{
%>
<a href = "Index.jsp">메인화면</a>
<a href = "Logout.jsp">로그아웃</a>

<%

	}
%>
</body>
</html>