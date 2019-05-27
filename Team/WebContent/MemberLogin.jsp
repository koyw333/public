<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="auth.css">
</head>
<body>
<%@ include file = "header.jsp" %>
<div class="lowin">

		<div class="lowin-wrapper">
			<div class="lowin-box lowin-login">
				<div class="lowin-box-inner">
					<form action = "MemberLogin.do" method = "post" id = "login">
						<p>로그인 하세요</p>
						<div class="lowin-group">
							<label>ID<a href="#" class="login-back-link">Sign in?</a></label>
							<input type="text" autocomplete="email" name="userID" class="lowin-input">
						</div>
						<div class="lowin-group password-group">
							<label>비밀번호 </label>
							<input type="password" name="userPW" autocomplete="current-password" class="lowin-input">
						</div>
						<button class="lowin-btn login-btn">
							Sign In
						</button>

					</form>
				</div>
			</div>
		</div>
</div>

</body>
</html>