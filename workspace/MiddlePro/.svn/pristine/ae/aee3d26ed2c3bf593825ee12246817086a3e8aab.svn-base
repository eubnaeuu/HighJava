<%@page import="kr.or.ddit.post.vo.PostVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
	List<PostVO> list = (List<PostVO>)request.getAttribute("postList");
	
	String msg = request.getParameter("msg") == null ? ""
	: request.getParameter("msg");
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>post 메인</title>
</head>
<body>
<table border="1">
		<tr>
			<td>postNo</td>
			<td>Title</td>
			<td>작성자</td>
			<td>에에에</td>
			<td>첨부파일ID</td>
		</tr>
		
	<%
		int postSize = list.size();
		
		if(postSize > 0){
			for(int i = 0; i < postSize; i++){
	%>		
		<tr>
			<td><%=list.get(i).getPostNo() %></td>
			<td><%=list.get(i).getPostTitle() %></td>
			<td><%=list.get(i).getMemId() %></td>
			<td>에에에</td>
			<td><%=list.get(i).getAtchFileId() %></td>
		</tr>
	<%
			}
		}else{
	%>
		<tr>
			<td colspan="5">게시글정보가 없습니다.</td>
		</tr>
	<%
		}
	%>
	<tr align="center">
		<td colspan="5"><a href="insertpost.do">[게시글 등록]</a></td>
	</tr>
	</table>
	
	<%
		if(msg.equals("성공")){ // 성공메시지가 전달되면...
	%>
			<script>
				alert('정상적으로 처리되었습니다.');
			</script>
	<% 		
		}
	%>

</body>
</html>