<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.giftbox.vo.GiftboxVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
[
<%
List<GiftboxVO> list = (List<GiftboxVO>)request.getAttribute("giftboxList");

for(int i=0; i<list.size(); i++){
	GiftboxVO iv = list.get(i);
	if(i>0){
		%>,<%
	}
	%>
	{
		"sendId" : "<%=iv.getSendId()%>",
		"itemId" : "<%=iv.getItemId()%>",
		"sendDate" : "<%=iv.getSendDate()%>",
		"giftMessage" : "<%=iv.getGiftMessage()%>",
		"litemGu" : "<%=iv.getLitemGu()%>",
		"senitemNamedId" : "<%=iv.getSenitemNamedId()%>",
		"itemImg" : "<%=iv.getItemImg()%>",
		"itemName" : "<%=iv.getItemName()%>"
	}
	<%
}
%>
]
    