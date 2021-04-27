<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@page import="kr.or.ddit.member.service.MemberServiceImpl"%>
<%@page import="kr.or.ddit.member.service.IMemberService"%>
<%@page import="kr.or.ddit.comments.vo.CommentsVO"%>
<%@page import="kr.or.ddit.post.vo.PostVO"%>
<%@page import="kr.or.ddit.comm.vo.AtchFileVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
// String userId = (String)request.getSession().getAttribute("nowLogin"); // 세션의 로그인아이디값 가져오기

// String userId ="cdwcdw34";
	
	List<AtchFileVO> atchFileList = (List<AtchFileVO>) request.getAttribute("atchFileList");
	List<PostVO> postlist = (List<PostVO>) request.getAttribute("postlist");
	List<CommentsVO> commentslist = (List<CommentsVO>) request.getAttribute("commentslist");
	
	String msg = request.getParameter("msg") == null ? ""
			: request.getParameter("msg");
	
	String userId = (String)request.getSession().getAttribute("userId");
	IMemberService memberService = MemberServiceImpl.getInstance();
	
	MemberVO logininfo = memberService.getMember(userId);
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글상세</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
// var nowLogin = sessionStorage.getItem("nowLogin");
<%-- alert('<%=userId%>'); --%>
// $.ajax({
// 	url : "/DEworld/MemberServlet",
// 	type : "post",
// 	data : {"memId" : nowLogin, "flag" : "setMyPage"},
// 	dataType : "json",
// 	success : function(data) {
// 		var memNickname = data[0].memNickname;
// 		var memId = data[0].memId;
// 		$(".memNicknameText").html("<a href='해당미니홈피로'>"+memNickname+"</a>");
// 		$(".memNicknameVal").val(memNickname);
// 		$("#memId").val(memId);
// 		$(".memIdVal").val(memId);
// 		$(".memIdText").html(memId);
// 	},
// 	error : function(xhr) {
// 		alert("알수없는 에러");
// 	}
// });
});
</script>
<style>
	table, td {
		border: 2px solid;
		border-collapse: collapse;
	}

</style>
</head>
<body>
<input type="hidden" value="" id="memNickname" class="memNickname">
	<table style="border: 2px solid">
		<tr>
			<td>글ID:</td>
			<td><%=postlist.get(0).getPostNo()%></td>
		</tr>
		<tr>
			<td>제목:</td>
			<td><%=postlist.get(0).getPostTitle()%></td>
		</tr>
		<tr>
			<td>내용:</td>
			<td><%=postlist.get(0).getPostContent()%></td>
		</tr>
		<tr>
			<td>조회수:</td>
			<td><%=postlist.get(0).getPostView()%></td>
		</tr>
		<tr>
			<td>작성자:</td>
			<td class="memNicknameText"><a href="해당홈피페이지로"><%=postlist.get(0).getMemNickname() %></a></td>
		</tr>
		<tr>
			<td>첨부파일:</td>
			<td>
				<%
					if (atchFileList != null) {
						for (AtchFileVO atchFileVO : atchFileList) {
				%>
				<div>
					<a
						href="<%=request.getContextPath()%>/filedownLoad.do?fileId=<%=atchFileVO.getAtchFileId()%>
																			&fileSn=<%=atchFileVO.getFileSn()%>">
						<%=atchFileVO.getOrignlFileNm()%>
					</a>
			<img width="200px" src="/DEworld/atchFile/<%=atchFileVO.getStreFileNm()%>.<%=atchFileVO.getFileExtsn()%>">
				</div> <%
 	}
 	} else {
 %>X<%
 	}
 %>
			</td>
		</tr>
		<tr>
		</tr>
		<!-- 		<tr> -->
		<!-- 			<td colspan="3"> -->
		<!-- 				<a href="list.do">[목록]</a> -->
		<%-- 				<a href="update.do?postNo=<%=postlist.get(0).getPostNo() %>">[수정]</a> --%>
		<%-- 				<a href="delete.do?postNo=<%=postlist.get(0).getPostNo() %>">[삭제]</a> --%>
		<!-- 			</td> -->
		<!-- 		</tr> -->
	</table>
	<%
		if (commentslist != null) {
			for (CommentsVO cv : commentslist) {
	%>
	<table>
		<tr>
			<td><%=cv.getMemNickname()%></td>
			<td><%=cv.getCommentsContent()%>(<%=cv.getCommentsDate()%>)</td>
<%-- 			<%if(cv.getMemId().equals()){ --%>
<!-- 			} -->
<!-- 			%> -->
			<td><a href=""><button>수정미완</button></a></td>
			<td><a href=""><button>삭제미완</button></a></td>
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
		<input type="hidden" value="" class="memIdVal" name="memId">
		<table>
			<tr>
				<td class="memNicknameText"><input type="hidden" readonly="readonly" name="memNickname" class="memNicknameVal">
				<%=logininfo.getMemNickname() %>
				</td>
				<td><input type="text" name="commentsContent"></td>
				<td>
					
						<input type="hidden" name="postNo" value="<%=postlist.get(0).getPostNo()%>">
						<a href="<%=request.getContextPath()%>/post/select.do?postNo=<%=postlist.get(0).getPostNo() %>"><button type="submit">등록</button></a>
					</a>
				</td>
			</tr>
		</table>
	</form>
	<table>
		<tr>
			<td colspan="3"><a href="list.do">[목록]</a></td> 
			<td><a href="update.do?postNo=<%=postlist.get(0).getPostNo()%>">[수정]</a></td>
			<td> <a href="delete.do?postNo=<%=postlist.get(0).getPostNo()%>">[삭제]</a></td>
		</tr>
	</table>
</body>
</html>