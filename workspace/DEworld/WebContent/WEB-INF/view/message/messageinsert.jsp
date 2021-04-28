<%@page import="kr.or.ddit.member.service.MemberServiceImpl"%>
<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@page import="kr.or.ddit.member.service.IMemberService"%>
<%@page import="kr.or.ddit.message.vo.MessageVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
		List <MessageVO> list = (List<MessageVO>) request.getAttribute("messagelist");
		String userId = (String)request.getSession().getAttribute("userId");
		IMemberService memberService = MemberServiceImpl.getInstance();
		MemberVO logininfo = memberService.getMember(userId);

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
			<input type="hidden" value="<%=userId %>" name="memId">
			<table>
				<tr>
					<td>FROM</td>
					<td><input type="text" name="memNickname" value="<%=logininfo.getMemNickname()%>" readonly="readonly"></td>
				</tr>
				<tr>
					<td>TO</td>
					<td><input type="text" name="receiveMem"></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><input type="text" name="messageContent" value=""></td>
				</tr>
			</table>
			<input type="submit" value="sendMessage">
			</form>
			
			<div id="divtmp"></div>
		</div>
</body>
</html>