<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.whishlist.vo.WhishlistVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
[
<%
List<WhishlistVO> list = (List<WhishlistVO>)request.getAttribute("whishlistList");

for(int i=0; i<list.size(); i++){
	WhishlistVO iv = list.get(i);
	if(i>0){
		%>,<%
	}
	%>
	{
		"itemId" : "<%=iv.getItemId()%>",
		"litemGu" : "<%=iv.getLitemGu()%>",
		"itemImg" : "<%=iv.getItemImg()%>",
		"itemName" : "<%=iv.getItemName()%>",
		"itemPrice" : "<%=iv.getItemPrice() %>"
	}
	<%
}
%>
]
    