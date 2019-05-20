<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String uri = request.getRequestURI(); //요청 URI
	String path = request.getContentType(); //기본 Path
	String basicPath=uri.substring(path.length());

	out.print("요청경로 : "+basicPath);
%>
</body>
</html>