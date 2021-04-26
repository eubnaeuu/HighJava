<%@page import="kr.or.ddit.comments.vo.CommentsVO"%>
<%@page import="kr.or.ddit.post.vo.PostVO"%>
<%@page import="kr.or.ddit.comm.vo.AtchFileVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
		List <AtchFileVO> atchFileList = (List<AtchFileVO>)request.getAttribute("atchFileList");
    	List <PostVO> postlist = (List<PostVO>) request.getAttribute("list");
    	List<CommentsVO> commentslist = (List<CommentsVO>)request.getAttribute("commentslist");
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
			<td><%=postlist.get(0).getPostNo() %></td>
		</tr>
		<tr>
			<td>제목:</td>
			<td><%=postlist.get(0).getPostTitle() %></td>
		</tr>
		<tr>
			<td>내용:</td>
			<td><%=postlist.get(0).getPostContent() %></td>
		</tr>
		<tr>
			<td>조회수:</td>
			<td><%=postlist.get(0).getPostView() %></td>
		</tr>
		<tr>
			<td>작성자:</td>
			<td><%=postlist.get(0).getMemId() %></td>
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
				<a href="list.do">[목록]</a>
				<a href="update.do?postNo=<%=postlist.get(0).getPostNo() %>">[수정]</a>
				<a href="delete.do?postNo=<%=postlist.get(0).getPostNo() %>">[삭제]</a>
			</td>
		</tr>
	</table>
	<%if(commentslist != null){
				for(CommentsVO cv : commentslist){
				%>
		<table>
		<tr>
			<td><%=cv.getMemId()%></td>
		</tr>
		<tr>
			<td><%=cv.getCommentsContent()%> (<%=cv.getCommentsDate() %>)</td>
		</tr>
		<tr>
			<td></td>
		</tr>
		<%}
		} else {
			%>
			<table>
			<tr>
				<td>
					댓글이 존재하지 않습니다
				</td>
			</tr>
			
			</table>
			<%
			}
			%>
		<form action="<%=request.getContextPath() %>/insert.do" method="post">
				<table>
					<tr>
						<td><input type="text" readonly="readonly" value="<%=postlist.get(0).getMemId() %>" name="memId"></td>
					</tr>
					<tr>
						<td><input type="text" name="commentsContent"></td>
					</tr>
					<tr>
						<td><button type="submit">등록</button></td>
					</tr>
				</table>
		</form>
		<tr>
			<td colspan="3">
				<a href="list.do">[목록]</a>
				<a href="update.do?postNo=<%=postlist.get(0).getPostNo() %>">[수정]</a>
				<a href="delete.do?postNo=<%=postlist.get(0).getPostNo() %>">[삭제]</a>
			</td>
		</tr>
	</table>
	

</body>
</html>