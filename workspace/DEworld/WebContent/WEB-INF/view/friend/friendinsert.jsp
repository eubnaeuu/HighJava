<%@page import="kr.or.ddit.member.service.MemberServiceImpl"%>
<%@page import="kr.or.ddit.member.service.IMemberService"%>
<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.member.service.IMemberService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String userId = (String) request.getSession().getAttribute("userId");
	IMemberService memberService = MemberServiceImpl.getInstance();
	MemberVO logininfo = memberService.getMember(userId);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>일촌신청</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<div>
		<form action="insert.do" method="post" enctype="multipart/form-data">
			<table>
			<input type="hidden" value="<%=userId %>" name="memId">
				<tr>
					<td>FROM</td>
					<td><input type="text" id="inputMemId"
						value="<%=logininfo.getMemNickname()%>" readonly="readonly"></td>
				</tr>
				<tr>
					<td>TO</td>
					<td><input type="text" name="friendId" id="inputFriendId"
						value=""></td>
				</tr>
				<tr>
					<td>보낼메시지</td>
					<td><textarea rows="10" cols="23"></textarea>
				</tr>
			</table>
			<input type="submit" value="신청" onclick="submit()"> 
			<a href="javascript:WinClose();"><input type="button" value="취소" onclick="close()"></a>
		</form>
	</div>
</body>
<script type="text/javascript">
	function close(){
		window.close();
	}
	
	function submit(){
		alert("일촌신청이 완료");
	}
</script>
</html>