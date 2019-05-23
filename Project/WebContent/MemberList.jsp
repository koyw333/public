<%@page import="org.web.MemberDTO.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 리스트</title>

	<!-- 테이블 리스트 저장한거  페이지에 출력하기 위해 ArrayList 변수에 담아주기 -->
	<%
	ArrayList<MemberDTO> memberLists = (ArrayList<MemberDTO>) request.getAttribute("memberLists");
	%>

</head>

<body>

	<div style="width : 100%; height : 10%; background : #00FC86">
		<%@ include file = "header.jsp" %> <br><br><br><br>
	</div>
	
	<div style="width : 100%; height : 80%; background : #313F35">
		<h1> 회원리스트 </h1>
		<table style = "width:500px; border:1px solid black; border-collapse:collapse;">
			<tr>
				<th> 아이디 </th>
				<th> 비밀번호 </th>
				<th> 이름 </th>
				<th> 이메일 </th>
			</tr>
				
		<%
			for (MemberDTO dto : memberLists) {
		%>
		
			<tr>
				<td> <%=dto.getUserId() %> </td>
				<td> <%=dto.getUserPw() %> </td>
				<td> <%=dto.getUserName() %> </td>
				<td> <%=dto.getUserEmail() %> </td>
			</tr>
			
		<%
			}
		%>
		
		</table>
	</div>
	
	<div style="width : 100%; height : 10%; background : #00FC86">
		<br><br><br><br><%@ include file = "footer.jsp" %>	
	</div>

</body>
</html>