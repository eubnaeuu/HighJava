<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.buy.vo.BuyVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
[
<%
List<BuyVO> list = (List<BuyVO>)request.getAttribute("buyList");

for(int i=0; i<list.size(); i++){
	BuyVO iv = list.get(i);
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
    