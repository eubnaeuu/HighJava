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
			<td>첨부파일</td>
			<td>첨부파일</td>
		</tr>
		<tr>
			<td>
			<%if(atchFileList != null){
				int cnt = 0;
				String str = "atchFile";
				String oldfile = "oldf";
				String ans = str+cnt;
				String ans2 = oldfile + cnt;
				for(AtchFileVO atchFileVO : atchFileList){
				%>
				<div>
					<a id="<%= ans2%>" href="<%=request.getContextPath() %>/filedownLoad.do?fileId=<%=atchFileVO.getAtchFileId()%>
																			&fileSn=<%=atchFileVO.getFileSn()%>">
																					<%=atchFileVO.getOrignlFileNm() %>
					</a>
					<input type="file" name=<%=ans %> id="atch1">							
				</div>
<!-- 				<button onclick="hello()">삭제1</button> -->
				<span onclick="hidee(<%= ans2%>)">삭제</span>
<%-- 				<a href="<%=request.getContextPath() %>/atchfiledetail/delete.do?fileId=<%=atchFileVO.getAtchFileId()%> --%>
<%-- 																			&fileSn=<%=atchFileVO.getFileSn()%>&postNo=<%=list.get(0).getPostNo()%>">삭제</a> --%>
				 <%
				 cnt++;
				 	}
				 	} else {
				 		%>X<%
				 	}
				 %>
			</td>
			<td>
			</td>
		</tr>
			<tr>
			<td></td>
			
		</tr>
	</table>
		<input type="submit" value="게시글 수정">
		
	</form>
</body>
<script type="text/javascript">
	function hidee(ans2){
		$("'#"+ans2+"'")
	}
</script>
</html> 