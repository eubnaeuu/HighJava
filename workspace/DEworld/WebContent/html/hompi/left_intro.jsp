<%@page import="kr.or.ddit.friend.service.FriendServiceImpl"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.friend.service.FriendService"%>
<%@page import="kr.or.ddit.friend.vo.FriendVO"%>
<%@page import="kr.or.ddit.friendreq.handler.SearchFriendReqHandler"%>
<%@page import="kr.or.ddit.member.service.MemberServiceImpl"%>
<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@page import="kr.or.ddit.member.service.IMemberService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String userId = (String)request.getSession().getAttribute("userId");
    IMemberService memberService = MemberServiceImpl.getInstance();
    MemberVO logininfo = memberService.getMember(userId);
    
    String hompiId = request.getParameter("hompiId");
    
    FriendVO fv = new FriendVO();
	
	fv.setMemId(hompiId);
	fv.setFriendId(request.getParameter("friendId"));
	fv.setFriendDate(request.getParameter("friendDate"));
	
	FriendService FriendService = FriendServiceImpl.getInstance();
	
	List<FriendVO> friendlist = FriendService.getSearchFriend(fv);
    %>
    
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<htmL>
<head>
<title>오늘의 나의 기분</title>
<meta charset="utf-8">
</head>

<body>



	<table border="0" width="130">
		<tr>
			<td bgcolor="#DBDBDB" align="center"><font face="굴림"
				style="font-size: 8pt;">today is... 피곤!</font></td>
		</tr>
		<tr>
			<td>
				<table bgcolor="#DBDBDB" width="130" cellpadding="1" cellspacing="1">
					<tr bgcolor="#FFFFFF">
						<td bg><img src="images/left_my.jpg" width="128" height="110"
							border="0" alt="오늘의 나의 사진" /></td>
					</tr>
				</table>
			</td>

		</tr>
		<tr>
			<td id="leftBarInfo"><font face="굴림" style="font-size: 9pt;">
					<button>수정</button>
			</font></td>
		</tr>
	</table>

	<br />
	<br />
	<br />
	<table bgcolor="#DBDBDB" width="130" cellpadding="1" cellspacing="1">
		<tr align="center">
			<td bgcolor="#FFFFFF"><font face="굴림" style="font-size: 9pt;">
					<b>DEWorld</b><br>
				<a href="http://localhost/DEworld/html/mainPage/topic.jsp"
					target="_blank"><font color="#000099">DEWorld.com</font></a>
					<select id="friendSelect">
						<%if(friendlist!=null){
							int cnt=0;
							%>
								<option>파도타기</option>
							<%
							for(FriendVO friendVO : friendlist){
							cnt++;
								%>
								<option value=<%=cnt %>><%=friendVO.getFriendId()%></option>
								<%
							}
							%>
							</select>
							<%
						}else {
							%>
							<option value=0>파도타기</option>
							<%
						}
							%>
					</select>
			</font></td>
		</tr>
	</table>

</body>
</html>
