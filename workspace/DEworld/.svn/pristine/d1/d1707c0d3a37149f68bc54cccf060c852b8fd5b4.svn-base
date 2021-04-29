<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@page import="kr.or.ddit.member.service.MemberServiceImpl"%>
<%@page import="kr.or.ddit.member.service.IMemberService"%>
<%@page import="kr.or.ddit.comments.vo.CommentsVO"%>
<%@page import="kr.or.ddit.post.vo.PostVO"%>
<%@page import="kr.or.ddit.comm.vo.AtchFileVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	List<AtchFileVO> atchFileList = (List<AtchFileVO>) request.getAttribute("atchFileList");
	PostVO pv = (PostVO) request.getAttribute("pv");
	List<CommentsVO> commentslist = (List<CommentsVO>) request.getAttribute("commentslist");

	String msg = request.getParameter("msg") == null ? "" : request.getParameter("msg");

	String userId = (String) request.getSession().getAttribute("userId");
	IMemberService memberService = MemberServiceImpl.getInstance();
	MemberVO logininfo = memberService.getMember(userId);
	
	
	
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글상세</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<style>
body .fonts {
	
}

a {
	text-decoration: none;
}
</style>
</head>
<body>
	<%-- 				<font face="굴림" style="font-size:9pt;"><%=pv.getMemNickname()%></font> --%>
	<!-- 			<td align="right">   -->
	<table border="0" bgcolor="#EBEBEB" width="450" cellpadding="1"
		cellspacing="1" align="center">
		<tr>
			<td><font face="굴림" style="font-size: 9pt;"><b><%=pv.getPostTitle()%></b></font>
			</td>
		</tr>
	</table>
	<table border="0" align="center" width="450" cellpadding="1"
		cellspacing="1">
		<tr>
			<font face="굴림" style="font-size: 9pt;"><td width="100"
				colspan="3"></td></font>
		</tr>
		<tr>
			<td width="100" colspan="2"><font face="굴림"
				style="font-size: 9pt;"><%=pv.getMemNickname()%></font></td>
			<td width="100"><font face="굴림" style="font-size: 9pt;"><%=pv.getPostDate().substring(2,16)%></font></td>
		</tr>
		<tr>
			<td colspan="3"><font face="굴림" style="font-size: 9pt;"><%=pv.getPostContent()%></font></td>
		</tr>
	</table>
					<%
						int cnt = 0;
						if (atchFileList != null) {
							%>
			<font face="굴림" style="font-size: 9pt;">첨부파일</font><br>
							<%
							for (AtchFileVO atchFileVO : atchFileList) {
								cnt++;
					%>
						<font face="굴림" style="font-size: 9pt;"> <a
							href="<%=request.getContextPath()%>/filedownLoad.do?fileId=<%=atchFileVO.getAtchFileId()%>
																			&fileSn=<%=atchFileVO.getFileSn()%>">
								<%=atchFileVO.getOrignlFileNm()%>
						</a>
						</font>
						<img width="50px" height="50px"
							src="/DEworld/atchFile/<%=atchFileVO.getStreFileNm()%>.<%=atchFileVO.getFileExtsn()%>">
			 <%
 	}
%>
<%							
 	} else {
 %>
				<%
					}
				%>
	<div style="text-align: right;">
		<a href="list.do"><font face="굴림"
			style="font-size: 9pt; color: #FDA500">[목록]</font></a> <a
			href="update.do?postNo=<%=pv.getPostNo()%>"><font face="굴림"
			style="font-size: 9pt; color: #FDA500"> [수정]</font></a> <a
			href="delete.do?postNo=<%=pv.getPostNo()%>"><font face="굴림"
			style="font-size: 9pt; color: #FDA500"> [삭제]</font></a>
	</div>
	<%
		if (commentslist != null) {
			for (CommentsVO cv : commentslist) {
	%>
	<table bgcolor="#F6F6F6" width="450">
		<tr>
			<td width="30"><a href=""><font face="굴림"
					style="font-size: 9pt;"><%=cv.getMemNickname()%></font></a></td>
			<td width="200"><font face="굴림" style="font-size: 9pt;"><%=cv.getCommentsContent()%>(<%=cv.getCommentsDate()%>)</font></td>
			<%
				if (userId.equals(cv.getMemId())) {
			%>
			<td width="8"><a href=""><button>수정</button></a></td>
			<td width="8"><a href=""><button>삭제</button></a></td>
			<%
				}
			%>
		</tr>
	</table>
	<%
		}
		} else {
	%>
	<table>
		<tr>
			<td></td>
		</tr>
	</table>
	<%
		}
	%>
	<form action="<%=request.getContextPath()%>/comments/insert.do"
		method="post">
		<input type="hidden" class="memIdVal" name="memId"
			value="<%=logininfo.getMemId()%>">
		<table bgcolor="#F6F6F6" width="450">
			<tr>
				<td width="30" class="memNicknameText"><font face="굴림"
					style="font-size: 9pt;">댓글</font></td>
				<td width="100"><font face="굴림" style="font-size: 9pt;">
						<input size="30" type="text" name="commentsContent">
				</font></td>
				<td width="30"><input type="hidden" name="postNo"
					value="<%=pv.getPostNo()%>"> <a
					href="<%=request.getContextPath()%>/post/select.do?postNo=<%=pv.getPostNo()%>">
						<button type="submit">등록</button>
				</a></td>
			</tr>
		</table>
	</form>

</body>
</html>