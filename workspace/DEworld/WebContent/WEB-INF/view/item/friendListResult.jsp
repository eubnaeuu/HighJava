<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.item.vo.ItemCollectionVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
[
<%
	List<ItemCollectionVO> friendList = (List<ItemCollectionVO>)request.getAttribute("friendList");

for(int i=0; i<friendList.size(); i++){
	ItemCollectionVO iv = friendList.get(i);
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
    