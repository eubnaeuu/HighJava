<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.music.vo.MusicVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
[
<%
List<MusicVO> friendList = (List<MusicVO>)request.getAttribute("friendList");

for(int i=0; i<friendList.size(); i++){
	MusicVO iv = friendList.get(i);
	if(i>0){
		%>,<%
	}
	%>
	{
		"friendId" : "<%=iv.getFriendId()%>",
		"friendNickname" : "<%=iv.getFriendNickname()%>"
	}
	<%
}
%>
]
    