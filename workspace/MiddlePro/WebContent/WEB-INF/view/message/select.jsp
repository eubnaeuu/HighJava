<%@page import="kr.or.ddit.message.vo.MessageVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
List<MessageVO> list = (List<MessageVO>)request.getAttribute("list");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td>FROM:</td>
			<td><%= list.get(0).getMemId()%></td>
		</tr>
		<tr>
			<td>TO:</td>
			<td><%= list.get(0).getReceiveMem()%></td>
		</tr>
		<tr>
			<td>내용:</td>
			<td><%=list.get(0).getMessageContent() %></td>
		</tr>
		<tr>
			<td>일자:</td>
			<td><%= list.get(0).getMessageDate()%></td>
		</tr>
		<tr>
			<td>상태:</td>
			<td><%= list.get(0).getMessageStatus()%></td>
		</tr>
		<tr>
			<td colspan="3">
				<a href="list.do">[목록]</a>
				<a href="update.do?postNo=<%=list.get(0).getMessageNo() %>">[수정]</a>
				<a href="delete.do?postNo=<%=list.get(0).getMessageNo() %>">[삭제]</a>
			</td>
		</tr>
	</table>
</body>
</html>