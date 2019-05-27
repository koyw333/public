<%@page import="MemberDTO.MemberDTO_forAttendance"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>출석조회</title>

<%
	ArrayList<MemberDTO_forAttendance> attendanceLists = 
		(ArrayList<MemberDTO_forAttendance>) request.getAttribute("attendanceLists");
	
	String wholeAttendance = (String) request.getAttribute("wholeAttendance");
	String attendanceCount = (String) request.getAttribute("attendanceCount");
	String otherCount2 = (String) request.getAttribute("otherCount2");
	String absenceCount = (String) request.getAttribute("absenceCount");
	System.out.println(wholeAttendance);
	
	String attendanceRate = (String) request.getAttribute("attendanceRate");
	System.out.println(attendanceRate);
%>

<script>

	function find() {
		
		var form = document.attendanceForm;
		
		if (form.findName.value == null || form.findName.value == "") {
			alert("아이디 및 이름을 입력해주세요");
			form.findName.focus();
			return false;
		} else {
			form.submit();
		}
		
	}

</script>

</head>
<body>

	<div style="text-align:center; width : 100%;  height : 10%; background : #00FC86">
        <%@ include file = "header.jsp" %>
    </div>
    
    <div style = "width : 100%; height : 10%">
    
    	<form action = "MemberAttendance.do" method = "POST" name = "attendanceForm">

			<select name = "selectType">
				<option value = "userName">이름</option>
				<option value = "userID">아이디</option>
			</select>
			
			<select name = "selectMonth">
				<option value = "wholeSelect">전체조회</option>
				<option value = "month2">2월19일 ~ 3월 18일</option>
				<option value = "month3">3월19일 ~ 4월 18일</option>
				<option value = "month4">4월19일 ~ 5월 18일</option>
			</select>    
			
			<input type = "text" name = "findName">
			<input type = "button" onclick = "find()" value = "검색">				
    	
    	</form>
    
    </div>
    
    <div style = "width : 100%; height : 40%">
    	<!-- 출석부 목록 -->
    	
    	<h1>출석부 조회</h1>
    	<table style = "width:100%; border:1px solid black; border-collapse:collapse">
    		<tr>
    			<th> 수업날짜 </th>
    			<th> 출결여부 </th>
    			<th> 입실시간 </th>
    			<th> 퇴실시간 </th>
    		</tr>
    		
    		<%
    			if (attendanceLists != null) {
    				for (MemberDTO_forAttendance dto : attendanceLists) {
    		%>
    		
    		<tr>
    			<td> <%=dto.getDate() %> </td>
    			<td> <%=dto.getChk() %> </td>
    			<td> <%=dto.getStartTime() %> </td>
    			<td> <%=dto.getEndTime() %> </td>
    		</tr>
    		
    		<%
    				}
    					}
    		%>
    	</table>
    	
    </div>
    
    <!-- 출석률 적을 자리 -->
    <div style = "width : 100%; height : 30%; border:1px solid black">
    	
		<div style = "display : inline-block; width : 100%; height : 100%; border:1px solid black">

			<%
				if (attendanceRate != null) {
					if (wholeAttendance != null) {
					%>
					총 수업일 수 : <%=wholeAttendance %> 일 <br>
					출석일 수 : <%=attendanceCount %> 일 <br>
					조퇴, 외출 등등 : <%=otherCount2 %> 일<br>
					결석일 수 : <%=absenceCount %> 일<br>
					출석률 : <%=attendanceRate %> <br>
					<%
				} else if (wholeAttendance == null || wholeAttendance == ""){
					%>					
				
					<%=attendanceRate %> <br>
					<%
					}
				}
			%>

		</div>

		<div style = "display : inline-block; width : 100%; height : 100%; border:1px solid black">
			여기는 메세지 띄울자리!!!!
		</div>
		
    </div>
    
    <div style="width : 100%; height : 10%;  background : #00FC86">
    	<%@ include file =  "footer.jsp" %>
    </div>

</body>
</html>