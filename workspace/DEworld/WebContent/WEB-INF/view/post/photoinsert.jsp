<%@page import="kr.or.ddit.post.vo.PostVO"%>
<%@page import="kr.or.ddit.comm.vo.AtchFileVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
		List <AtchFileVO> atchFileList = (List<AtchFileVO>)request.getAttribute("atchFileList");
    	List <PostVO> list = (List<PostVO>) request.getAttribute("list");
		String userId = (String)request.getSession().getAttribute("userId");
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
			<table>
				<tr>
					<td></td>
					<td><input type="hidden" name="lpostGu" value="LPO02"></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="hidden" name="postNo"></td>
				</tr>
				<tr>
					<td>내용:</td>
					<td><input type="text" name="postContent" value=""></td>
				</tr>
				<tr>
					<td>작성자:</td>
					<td><input type="text" name="memId" value="<%=userId %>" readonly="readonly"></td>
				</tr>
				<tr>
					<td>사진1</td>
					<td><input type="file" name="atchFile1" id="atch1"></td>
				</tr>
				<tr>
					<td>사진2</td>
					<td><input type="file" name="atchFile2" id="atch2"></td>
				</tr>
			</table>
			<input type="hidden" value="phoend" name="flag">
			<input type="submit" value="사진등록">
			</form>
			
			<div id="divtmp"></div>
		</div>
</body>
</html>