<%@page import="kr.or.ddit.post.vo.PostVO"%>
<%@page import="kr.or.ddit.comm.vo.AtchFileVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
List <AtchFileVO> atchFileList = (List<AtchFileVO>)request.getAttribute("atchFileList");
List <PostVO> list = (List<PostVO>) request.getAttribute("list");
String sysdate = (String)request.getAttribute("sysdate");

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글 수정</title>
</head>
<body>
	<form action="update.do" method="post" enctype="multipart/form-data">
		<input type="hidden" name="atchFileId" value="<%=list.get(0).getAtchFileId()%>">
		<input type="hidden" name="postNo" value="<%=list.get(0).getPostNo()%>">
<table>
		<tr>
			<td>제목:</td>
			<td><input type="text" name="postTitle" value="<%=list.get(0).getPostTitle()%>"></td>
		</tr>
		<tr>
			<td>내용:</td>
			<td><input type="text" name="postContent" value="<%=list.get(0).getPostContent()%>"></td>
		</tr>
		<tr>
			<td>현재시각</td>
			<td><input type="text" name="postDate" value="<%=sysdate%>" readonly="readonly"></td>
		</tr>
		<tr>
			<td>작성자:</td>
			<td><input type="text" name="memId" value="<%=list.get(0).getMemId()%>" readonly="readonly"></td>
		</tr>
		<tr>
			<td>조회수:</td>
			<td><input type="text" name="postView" value="<%=list.get(0).getPostView()%>" readonly="readonly"></td>
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
			<td>새로운 첨부파일</td>
			<td><input type="file" name="atchFile"></td>
		</tr>
	</table>
		<input type="submit" value="게시글 수정">
	</form>
</body>
</html>