<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="#" method ="POST" id ="frm"></form>
		아이디    : <input type ="text" name= "userId" id = "userId"><br>
			     <input type ="button" value ="아이디체크"><br>
		비밀번호 : <input type ="password" name= "userPw" id = "user:Pw"><br>
		성별       : <input type ="radio" name = "userGender" value ="남자">남자<br>
				 <input type ="radio" name = "userGender" value ="남자">남자<br>
		방병록 작성<br>
		<textarea rows ="10" cols ="30" name = "guest"></textarea><br>
		취미<br>
		<input type="checkbox" name ="hobbys" value ="등산" class ="hobbys">등산
		<input type="checkbox" name ="game" value ="게임" class = "game">게임
		<input type="checkbox" name ="travle" value ="여행" class = "travle">여행
		<input type="checkbox" name ="movie" value ="영화" class = "movie" >영화
		전화번호:<select name ="phone">
					<option value="010"> 010 </option>
					<option value="011"> 011 </option>
					<option value="015"> 015 </option>
					<option value="016"> 016 </option>
				</select>
				<td id = "title"> 초기화</td><br>
		        <input type ="reset" value ="초기화">
		        <input type ="submit" value ="회원가입">
</body>
</html>