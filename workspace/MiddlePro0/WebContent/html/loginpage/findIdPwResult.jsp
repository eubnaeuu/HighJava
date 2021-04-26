<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

[   
<%
String auth = (String)request.getSession().getAttribute("AuthenticationKey");
int resultCnt = (Integer)request.getAttribute("resultCnt");

	//json 타입을 만들어야 하는 부분 ==> {name : "~", id : "~"}
	//번호, id, 이름, 비밀번호, 생년월일, 전화번호, 메일, 직업
	%>
		{"auth" : "<%=auth %>"
		,"resultCnt" : "<%=resultCnt %>"}
		<% 
		%>
	<%
	
%>
]