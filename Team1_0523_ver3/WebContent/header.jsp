<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div>
<%
	if(session.getAttribute("userID")==null){

%>
	<a href = "index.jsp"> |   홈   | </a>
	<a href = "MemberLogin.jsp"> | 로그인  | </a>
	<a href = "MemberJoin.jsp"> | 회원가입 | </a>
	<a href = "MemberList.do"> | 사용자 조회 | </a>
<%

}else{

%>
		<a href = "index_login.jsp"> |   홈   | </a>
		<a href = "MemberLogin.jsp"> | 로그아웃  | </a>
		<a href = "ConfirmLogin.jsp"> | 로그인 세션값 확인 |</a>
		<a href = "ToGoUpdate.jsp"> | 회원 정보 수정 | </a>
		<a href = "MemberList.do"> | 사용자 조회 | </a> <br>
<%	
	session.getAttribute("userName"); 
%> 
님 로그인 중 <br>
<%
}
%>
</div>