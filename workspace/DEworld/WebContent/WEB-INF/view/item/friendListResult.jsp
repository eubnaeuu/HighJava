<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.item.vo.ItemVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
[
<%
List<ItemVO> friendList = (List<ItemVO>)request.getAttribute("friendList");

for(int i=0; i<friendList.size(); i++){
	ItemVO iv = friendList.get(i);
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
    