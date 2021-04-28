<%@page import="kr.or.ddit.adminroom.member.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
[
<%
List<MemberVO> list = (List<MemberVO>)request.getAttribute("list");

for(int i=0; i<list.size(); i++){
	MemberVO mv = list.get(i);
	if(i>0){
		%>,<%
	}
	%>
	{
		"memId"        : "<%=mv.getMemId()%>"
		,"memName"     : "<%=mv.getMemName()%>"
		,"memNickname" : "<%=mv.getMemNickname()%>"
	}
	<%
}
%>
]
