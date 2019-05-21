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
</head>
<body>

	<h1>회원리스트</h1>
	<%
	
	for(MemberDTO dto:members){
		out.print("아이디 : " + dto.getUserId()+", ");
		out.print("비밀번호 : " + dto.getUserPw()+", ");
		out.print("이름 : " + dto.getUserName()+", ");
		out.print("나이 : " + dto.setUserEmail()+", ");
	}

	%>
	
		 <h1>회원리스트</h1>
		 <%
		 
		 for(MemberDTO dto : members){
		 
		 %>
		 
		 <div> 
		 		아이디 : <%= dto.getUserId() %>, 비밀번호 : <%= dto.getUserPw() %>,
		 	        이름 :  <%= dto.getUserName() %>, 나이 : <%= dto.setUserEmail() %>
		 </div>
		 
		 <%
		 
		 }
		 
		 %>
		 
		 <!-- 테이블 이용 -->
		 <table style = "width : 500px;">
		 	<tr>
		 		<th>아이디</th>
		 		<th>비밀번호</th>
		 		<th>이름</th>
		 		<th>나이</th>
		 	</tr>
		 	
		 	<%
		 	
		 	for(MemberDTO dto : members){
		 	
		 	%>
		 	<tr>
		 		<td><%= dto.getUserId() %></td>
		 		<td><%= dto.getUserPw() %></td>
		 		<td><%= dto.getUserName() %></td>
		 		<td><%= dto.setUserEmail() %></td>
		 	</tr>
		 	<%
			
		 	}
		 	
		 	%>
		 	<tr>
			 	<td><a href="formEx.jsp">회원가입</a></td>
			 	<td><a href="LoginView.do">로그인</a></td>
			 	<td><a href="LogOut.do">로그아웃</a></td>
			 	<td><a href="/">Home</a></td>
		 	</tr>
		 </table>
		 
		 
	
</body>
</html>