<%@page import="kr.or.ddit.post.vo.PostVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// String strJson = (String)request.getAttribute("strJson");

List<PostVO> list = (List<PostVO>)request.getAttribute("list");

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>게시글 목록</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">


</script>
</head>
<body>
<table border='2px solid'>"
	<thead>
			<tr>
			<th>글번호</th>
			<th>제  목</th>
			<th>내 용</th>
			<th>일 자</th
			<th>조회수</th>
			</tr>
			</thead>
</body>
</html>