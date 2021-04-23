<%@page import="kr.or.ddit.post.vo.PostVO"%>
<%@page import="kr.or.ddit.comm.vo.AtchFileVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
		List <AtchFileVO> atchFileList = (List<AtchFileVO>)request.getAttribute("atchFileList");
    	List <PostVO> list = (List<PostVO>) request.getAttribute("list");
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
			<td>글ID:</td>
			<td><%=list.get(0).getPostNo() %></td>
		</tr>
		<tr>
			<td>제목:</td>
			<td><%=list.get(0).getPostTitle() %></td>
		</tr>
		<tr>
			<td>내용:</td>
			<td><%=list.get(0).getPostContent() %></td>
		</tr>
		<tr>
			<td>조회수:</td>
			<td><%=list.get(0).getPostView() %></td>
		</tr>
		<tr>
			<td>작성자:</td>
			<td><%=list.get(0).getMemId() %></td>
		</tr>
		<tr>
			<td>첨부파일:</td>
			<td>
			<%if(atchFileList != null){
				for(AtchFileVO atchFileVO : atchFileList){
				%>
				<div>
					<a href="<%=request.getContextPath() %>/filedownLoad.do?fileId=<%=atchFileVO.getAtchFileId()%>
																			&fileSn=<%=atchFileVO.getFileSn()%>">
																					<%=atchFileVO.getOrignlFileNm() %>
					</a>
				</div>
				 <%
				 	}
				 	} else {
				 		%>X<%
				 	}
				 %>
			</td>
		</tr>
		<tr>
			<td colspan="3">
				<a href="main.do">[목록]</a>
				<a href="update.do?postNo=<%=list.get(0).getPostNo() %>">[수정]</a>
				<a href="delete.do?postNo=<%=list.get(0).getPostNo() %>">[삭제]</a>
			</td>
		</tr>
	</table>
</body>
</html>