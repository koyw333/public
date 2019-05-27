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
							<label>아이디<a href="#" class="login-back-link">Sign in?</a></label>
							<input type="text" autocomplete="email" name="userID" class="lowin-input">
						</div>
						<div class="lowin-group password-group">
							<label>비밀번호 </label>
							<input type="password" name="userPW" autocomplete="current-password" class="lowin-input">
						</div>
						<div class="lowin-group">
							<label>이름<a href="#" class="login-back-link">Sign in?</a></label>
							<input type="text" autocomplete="email" name="userName" class="lowin-input">
						</div>
						<div class="lowin-group">
							<label>이메일<a href="#" class="login-back-link">Sign in?</a></label>
							<input type="text" autocomplete="email" name="userEmail" class="lowin-input">
						</div>
						<button class="lowin-btn login-btn">
							rkdlq
						</button>

					</form>
				</div>
			</div>
		</div>
	</div>
	
	
	
	<div style="width : 100%; height : 80%; background : #313F35">
		회원가입!! <br>
		<form action = "MemberJoin.do" method = "post" id = "join">
			아이디 : <input type = "text" name = "userID" id = "userID"> <br>
			비밀번호 : <input type = "password" name = "userPW" id = "userPW"> <br>
			이름 : <input type = "text" name = "userName"> <br>
			이메일 : <input type = "text" name = "userEmail"> <br>		
			<input type = "submit" value = "회원가입"> <br><br>
		</form>
	</div>
	
	<div style="width : 100%; height : 10%; background : #00FC86">
		<br><br><br><br><%@ include file = "footer.jsp" %>	
	</div>

</body>
</html>