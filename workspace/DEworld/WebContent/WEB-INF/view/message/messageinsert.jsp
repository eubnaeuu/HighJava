<%@page import="kr.or.ddit.message.vo.MessageVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
		List <MessageVO> list = (List<MessageVO>) request.getAttribute("messagelist");
    	String memId = (String)session.getAttribute("nowLogin");
//     	String memId = session.getId();

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>댓글등록</title>
</head>
<script type="text/javascript">
// $(document).ready(function(){
// 	var nowLogin = sessionStorage.getItem("nowLogin");
// });
</script>
<body>
	<div>
			<form action="insert.do" method="post" enctype="multipart/form-data">
			<table>
				<tr>
					<td>보낸이</td>
					<td><input type="text" name="memId" value="cdwcdw34"></td>
				</tr>
				<tr>
					<td>받는이</td>
					<td><input type="text" name="receiveMem"></td>
				</tr>
				<tr>
					<td>내용:</td>
					<td><input type="text" name="messageContent" value="쪽지내용"></td>
				</tr>
			</table>
			<input type="submit" value="sendMessage">
			</form>
			
			<div id="divtmp"></div>
		</div>
</body>
</html>