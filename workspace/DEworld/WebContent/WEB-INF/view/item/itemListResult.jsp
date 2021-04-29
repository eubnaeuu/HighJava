<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.item.vo.ItemCollectionVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
[
<%
	List<ItemCollectionVO> list = (List<ItemCollectionVO>)request.getAttribute("itemList");

for(int i=0; i<list.size(); i++){
	ItemCollectionVO iv = list.get(i);
	if(i>0){
%>,<%
	}
	%>
	{
		"itemId" : "<%=iv.getItemId()%>",
		"itemName" : "<%=iv.getItemName()%>",
		"itemPrice" : "<%=iv.getItemPrice()%>",
		"itemImg" : "<%=iv.getItemImg()%>",
		"itemDesc" : "<%=iv.getItemDesc()%>",
		"litemGu"  : "<%=iv.getLitemGu()%>"
	}
	<%
}
%>
]
    