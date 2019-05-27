<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>

		<%@ include file = "header.jsp" %>
<div class="lowin">

		<div class="lowin-wrapper">
			<div class="lowin-box lowin-login">
				<div class="lowin-box-inner">
					<form action = "MemberJoin.do" method = "post" id = "login">
						<p>회원가입</p>
						<div class="lowin-group">
							<label>아이디</label>
							<input type="text" autocomplete="email" name="userID" class="lowin-input">
						</div>
						<div class="lowin-group password-group">
							<label>비밀번호 </label>
							<input type="password" name="userPW" autocomplete="current-password" class="lowin-input">
						</div>
						<div class="lowin-group">
							<label>이름</a></label>
							<input type="text" autocomplete="email" name="userName" class="lowin-input">
						</div>
						<div class="lowin-group">
							<label>이메일</label>
							<input type="text" autocomplete="email" name="userEmail" class="lowin-input">
						</div>
						<button class="lowin-btn login-btn">
							가입하기
						</button>

					</form>
				</div>
			</div>
		</div>
	</div>
	
</body>
</html>