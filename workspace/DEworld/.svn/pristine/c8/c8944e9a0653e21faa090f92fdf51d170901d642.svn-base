<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.faq.vo.FaqVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
[
<%
List<FaqVO> list = (List<FaqVO>)request.getAttribute("faqList");

for(int i=0; i<list.size(); i++){
	FaqVO iv = list.get(i);
	if(i>0){
		%>,<%
	}
	%>
	{
		"faqId" : "<%=iv.getFaqId()%>",
		"faqTitle" : "<%=iv.getFaqTitle()%>",
		"faqContent" : "<%=iv.getFaqContent()%>",
		"lfaqNm" : "<%=iv.getLfaqNm()%>"
	}
	<%
}
%>
]
    