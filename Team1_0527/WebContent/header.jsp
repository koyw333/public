<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" >

<head>
  <meta charset="UTF-8">
  <title>Home Page</title>
  
  
  <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'>
  <link rel="stylesheet" href="css/style.css">

  
</head>

<body>

  <html>
<div class="container-fluid" > 
<img class='img-responsive' src="https://upload.wikimedia.org/wikipedia/commons/3/39/Cloud_banner.jpg">  
  <nav id="grey"> 
	<%if (session.getAttribute("sessionID") == null) { 	%>
    <a class="simp btn btn-primary" href="index.jsp"> 홈 </a>
    <a class='simp btn btn-primary' href="MemberLogin.jsp"> 로그인 </a>
    <a class='simp btn btn-primary' href="MemberLogin.jsp"> 회원가입 </a>
    <a class='simp btn btn-primary' href="ConfirmLogin.jsp"> 세션 확인  </a>
			<%
		} else {
			if (session.getAttribute("sessionID").equals("root")) {
				%>
			<a class="simp btn btn-primary" href = "index_login.jsp"> |   홈   | </a>
			<a class='simp btn btn-primary' href = "MemberLogout.do"> | 로그아웃  | </a>
			<a class='simp btn btn-primary' href = "board.jsp"> |  출석조회  | </a>
			<a class='simp btn btn-primary' href = "ConfirmLogin.jsp"> | 로그인 세션값 확인 |</a>
			<a class='simp btn btn-primary' href = "ToGoUpdate.jsp"> | 회원 정보 수정 | </a>
			<a class='simp btn btn-primary' href = "MemberDelete.jsp"> | 사용자 탈퇴| </a> 
			<a class='simp btn btn-primary' href = "MemberList.do"> | 사용자 조회 | </a> <br>
			<%=session.getAttribute("sessionName") %>(관리자)님 로그인 중 <br>
				<%
			} else {
				%>
			<a class='simp btn btn-primary' href = "index_login.jsp"> |   홈   | </a>
			<a class='simp btn btn-primary' href = "MemberLogout.do"> | 로그아웃  | </a>
			<a class='simp btn btn-primary' href = "board.jsp"> |  출석조회  | </a>
			<a class='simp btn btn-primary' href = "ConfirmLogin.jsp"> | 로그인 세션값 확인 |</a>
			<a class='simp btn btn-primary' href = "ToGoUpdate.jsp"> | 회원 정보 수정 | </a>
			<a class='simp btn btn-primary' href = "MemberDelete.jsp"> | 사용자 탈퇴| </a> <br>
			<%=session.getAttribute("sessionName") %>님 로그인 중 <br>
			<%

			</nav>
			
			 <img class='img-responsive' class="image" src="http://previews.123rf.com/images/farang/farang1208/farang120800008/14837149-Book-with-a-seashell-on-the-bamboo-chair-at-the-beach-Square-composition--Stock-Photo.jpg">

		</body>
	</html>
