<%@page import="kr.or.ddit.member.service.MemberServiceImpl"%>
<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@page import="kr.or.ddit.member.service.IMemberService"%>
<%@page import="kr.or.ddit.message.vo.MessageVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	List<MessageVO> list = (List<MessageVO>) request.getAttribute("messagelist");
	String userId = (String) request.getSession().getAttribute("userId");
	IMemberService memberService = MemberServiceImpl.getInstance();
	MemberVO logininfo = memberService.getMember(userId);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
</head>
<body>

	<div class="container" style="width: 300px">
	<h3>쪽지보내기</h3>
		<table class="table table-hover">
			<form action="insert.do" method="post" enctype="multipart/form-data">
				<input type="hidden" value="<%=userId%>" name="memId">
					<tr>
						<td width="50px">FROM</td>
						<td><input type="text" name="memNickname"
							value="<%=logininfo.getMemNickname()%>" readonly="readonly"></td>
					</tr>
					<tr>
						<td width="50px">TO</td>
						<td><input type="text" name="receiveMem"></td>
					</tr>
					<tr>
						<td width="50px">내용</td>
						<td>
						<textarea style="margin: 0px; height: 181px; width: 176px;" name="messageContent"></textarea>
					</tr>
				</table>
				<input type="submit" value="확인">
				<input type="submit" value="취소">
			</form>
		</table>
		<div id="divtmp"></div>
	</div>
</body>
</html>