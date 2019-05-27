<%@page import="org.web.memberDTO.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%

	if(session.getAttribute("sessionId")==null){
		
		out.print("<script>");

		out.print("alert('로그인후에 이용해세요..');");

		out.print("location.href='login.jsp';");
		
		out.print("</script>");	
		
	}

%>
	
	
<!-- JSP 내장객체 -->
<%
	ArrayList<MemberDTO> members = (ArrayList<MemberDTO>) request.getAttribute("members");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 리스트</title>
</head>
<body>

<%@include file="header.jsp" %>

	<div id="bord" style="text-align:center;background:#eee;width:80%;padding:20px 0;margin:0 auto">
		<h1 style="">테이블 태그를 이용한 회원 리스트</h1>
		<table style="width: 100%" border="1">
			<tr>
				<th>아이디</th>
				<th>비밀번호</th>
				<th>이름</th>
				<th>나이</th>
			</tr>
			<%
				for (MemberDTO dto : members) {
			%>
	
			<tr>
				<td><%=dto.getUserID()%></td>
				<td><%=dto.getUserPW()%></td>
				<td><%=dto.getUserNAME()%></td>
				<td><%=dto.getUserAGE()%></td>
	
			</tr>
			<%
				}
			%>
		</table>
	
	</div>
	
<%@ include file="footer.jsp" %>


</body>
</html>