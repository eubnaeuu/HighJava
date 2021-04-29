<%@page import="kr.or.ddit.member.service.IMemberService"%>
<%@page import="kr.or.ddit.member.service.MemberServiceImpl"%>
<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@page import="kr.or.ddit.post.vo.PostVO"%>
<%@page import="kr.or.ddit.comm.vo.AtchFileVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
		List <AtchFileVO> atchFileList = (List<AtchFileVO>)request.getAttribute("atchFileList");
    	List <PostVO> list = (List<PostVO>) request.getAttribute("list");
    	
		String userId = (String)request.getSession().getAttribute("userId");
		String hompiId = request.getParameter("hompiId");
		
		IMemberService memberService = MemberServiceImpl.getInstance();
		MemberVO logininfo = memberService.getMember(userId);
		
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>사진첩등록</title>
</head>
<script type="text/javascript">
// $(document).ready(function(){
// 	var nowLogin = sessionStorage.getItem("nowLogin");
// });
</script>
<body>
	<div>
			<form action="insert.do" method="post" enctype="multipart/form-data">
			<input type="hidden" value="<%=hompiId%>" name="hompiId">
				<table border="0" align="center" width="450" cellpadding="1"
		cellspacing="1">
				<tr>
					<td></td>
					<td><input type="hidden" name="lpostGu" value="LPO02"></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="hidden" name="postNo"></td>
				</tr>
				<tr>
					<td><font face="굴림" style="font-size: 9pt;"><b>작성자</b></font></td>
					<td><span name="memNickname"><font face="굴림" style="font-size: 9pt;"><%=logininfo.getMemNickname() %></font></span></td>
					<td><input type="hidden" name="memId" value="<%=userId %>" readonly="readonly"></td>
				</tr>
				<tr>
					<td><font face="굴림" style="font-size: 9pt;"><b>설명</b></font></td>
					<td>
						<textarea style="margin: 0px; width: 339px; height: 35px;" name="postContent">
						</textarea>
				</tr>
				<tr>
					<td><font face="굴림" style="font-size: 9pt;"><b>사진1</b></font></td>
					<td><input type="file" name="atchFile1" id="atch1"></td>
				</tr>
				<tr>
					<td><font face="굴림" style="font-size: 9pt;"><b>사진2</b></font></td>
					<td><input type="file" name="atchFile2" id="atch2"></td>
				</tr>
				<tr>
					<td><font face="굴림" style="font-size: 9pt;"><b>사진3</b></font></td>
					<td><input type="file" name="atchFile3" id="atch3"></td>
				</tr>
				<tr>
					<td><font face="굴림" style="font-size: 9pt;"><b>사진4</b></font></td>
					<td><input type="file" name="atchFile4" id="atch4"></td>
				</tr>
				<tr>
					<td><font face="굴림" style="font-size: 9pt;"><b>사진5</b></font></td>
					<td><input type="file" name="atchFile5" id="atch5"></td>
				</tr>
				
			</table>
			<input type="hidden" value="phoend" name="flag">
			<input type="submit" value="사진등록">
			</form>
			
			<div id="divtmp"></div>
		</div>
</body>
</html>