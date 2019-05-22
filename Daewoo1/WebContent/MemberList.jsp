<%@page import="org.web.MemberDTO.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--  JSP 내장객체 -->    
<%
	ArrayList<MemberDTO> members= (ArrayList<MemberDTO>)request.getAttribute("members");
%>
    
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file = "header.jsp" %>
</head>

<body>
	
		 <!-- 테이블 이용 -->
		 	<h1>회원리스트</h1>
		 <table style = "width: 600px; text-align: center; border: 5px solid #ccc; margin: 20px;">
		 	<tr>
		 		<th>아이디</th>
		 		<th>비밀번호</th>
		 		<th>이름</th>
		 		<th>이메일</th>
		 	</tr>
		 	
		 	<%
		 	
		 	for(MemberDTO dto : members){
		 	
		 	%>
		 	<tr>
		 		<td><%= dto.getUserId() %></td>
		 		<td><%= dto.getUserPw() %></td>
		 		<td><%= dto.getUserName() %></td>
		 		<td><%= dto.getuserEmail() %></td>
		 	</tr>
		 	<%
			
		 	}
		 	
		 	%>
		 	<tr>
			 	<td><a href="formEx.jsp">회원가입</a></td>
			 	<td><a href="LoginView.do">로그인</a></td>
			 	<td><a href="LogOut.do">로그아웃</a></td>
			 	<td><a href="Index.jsp">Home</a></td>
		 	</tr>
		 </table>
	
</body>
</html>