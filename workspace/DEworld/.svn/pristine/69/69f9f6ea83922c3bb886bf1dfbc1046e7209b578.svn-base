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

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글등록</title>
</head>
<script type="text/javascript">
// $(document).ready(function(){
// 	var nowLogin = sessionStorage.getItem("nowLogin");
// });
</script>
<style>
</style>
<body>
	<div>
			<form action="insert.do" method="post" enctype="multipart/form-data">
		<input type="hidden" value="<%=hompiId%>" name="hompiId">
			<table border="0" align="center" width="450" cellpadding="1"
		cellspacing="1">
				<tr>
					<td></td>
					<td><input type="hidden" name="lpostGu" value="LPO03"></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="hidden" name="postNo"></td>
				</tr>
				<tr>
					<td><font face="굴림" style="font-size: 9pt;">제목</font></td>
					<td><input size="50" type="text" name="postTitle" value=""></td>
				</tr>
				<tr>
					<td><font face="굴림" style="font-size: 9pt;">내용</font></td>
					<td>
						<textarea name="postContent" row="10" cols="30" style="margin: 0px; width: 381px; height: 193px;"></textarea>
<!-- 					<input type="text" name="postContent" value=""></td> -->
				</tr>
					<input type="hidden" name="memId" value="<%=userId %>" readonly="readonly">
				<tr>
					<td><font face="굴림" style="font-size: 9pt;">첨부파일1</font></td>
					<td><input type="file" name="atchFile1" id="atch1"></td>
				</tr>
				<tr>
					<td><font face="굴림" style="font-size: 9pt;">첨부파일2</font></td>
					<td><input type="file" name="atchFile2" id="atch2"></td>
				</tr>
			</table>
			<input type="hidden" value="posend" name="flag">
			<input type="submit" value="post등록">
			</form>
			
			<div id="divtmp"></div>
		</div>
</body>
</html>