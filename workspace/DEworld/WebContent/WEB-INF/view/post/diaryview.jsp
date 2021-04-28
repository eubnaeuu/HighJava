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
	// String userId = (String)request.getSession().getAttribute("nowLogin"); // 세션의 로그인아이디값 가져오기
	// String userId ="cdwcdw34";
// if(request.getAttribute("atchFileList") != null){
// }
	List<AtchFileVO> atchFileList = (List<AtchFileVO>) request.getAttribute("atchFileList");
	PostVO pv = (PostVO)request.getAttribute("pv");
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
<title>사진글상세</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<style>
table, td {
	border: 2px solid;
	border-collapse: collapse;
}
body
	{scrollbar-face-color: #FFFFFF;
	 scrollbar-highlight-color: #DBDBDB;
	 scrollbar-3dlight-color: #FFFFFF;
	 scrollbar-shadow-color: #9C92FF;
	 scrollbar-darkshadow-color: #FFFFFF;
	 scrollbar-track-color: #FFFFFF;
	 scrollbar-arrow-color: #9C92FF}
</style>
</head>
<body>
	<input type="hidden" value="" id="memNickname" class="memNickname">
	<center><img src="images/bar.jpg" width="420" height="6" border="0" alt=""></center>
	<table border="0" bgcolor="#EBEBEB" width="420" cellpadding="1" cellspacing="1" align="center">
		<tr>
			<td>
			<font face="굴림" style="font-size:9pt;"><b><%=pv.getPostContent()%></b></font>
			</td>
		</tr>
	</table>
	<!-- 따옴 시작 -->
	<table border="0" align="center" width="420" cellpadding="1" cellspacing="1">
		<tr>
			<td width="100">  
				<font face="굴림" style="font-size:9pt;"><%=pv.getMemNickname()%></font>
			</td>
			<td align="right">  
				<font face="굴림" style="font-size:9pt;"><%=pv.getPostDate()%> 스크랩:0</font>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<%
					if (atchFileList != null) {
						for (AtchFileVO atchFileVO : atchFileList) {
				%>
				<div>
					<img width="200px"
						src="/DEworld/atchFile/<%=atchFileVO.getStreFileNm()%>.<%=atchFileVO.getFileExtsn()%>">
				</div> <%
 	}
 	} else {
 %>X<%
 	}
 %>
			</td>
		</tr>
	</table>
	<table>
		<tr>
			<td>태그</td>
			<td><input type="text" id="tags"></td>
			<td><button type="button" onclick="tagAdd()">추가</button></td>
		</tr>
	</table>
	<table>
		<tr>
			<td colspan="3"><a href="list.do">[★목록]</a></td>
			<td><a href="update.do?postNo=<%=pv.getPostNo()%>">[수정]</a></td>
			<td><a href="delete.do?postNo=<%=pv.getPostNo()%>">[삭제]</a></td>
		</tr>
	</table>
	<%
		if (commentslist != null) {
			for (CommentsVO cv : commentslist) {
	%>
	<table>
		<tr>
			<td><%=cv.getMemNickname()%></td>
			<td><%=cv.getCommentsContent()%>(<%=cv.getCommentsDate()%>)</td>
			<%
				if (userId.equals(cv.getMemId())) {
			%>
			<td><a href=""><button>수정</button></a></td>
			<td><a href=""><button>삭제</button></a></td>
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
			<td>댓글이 존재하지 않습니다</td>
		</tr>
	</table>
	<%
		}
	%>
	<form action="<%=request.getContextPath()%>/comments/insert.do"
		method="post">
		<input type="hidden" class="memIdVal" name="memId"
			value="<%=logininfo.getMemId()%>">
		<table>
			<tr>
				<td class="memNicknameText">댓글</td>
				<td><input type="text" name="commentsContent"></td>
				<td><input type="hidden" name="postNo"
					value="<%=pv.getPostNo()%>"> <a
					href="<%=request.getContextPath()%>/post/select.do?postNo=<%=pv.getPostNo()%>"><button
							type="submit">등록</button></a> </a></td>
			</tr>
		</table>
	</form>

</body>
</html>