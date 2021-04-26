<%@page import="loginPage.vo.AdminVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

[   
<%
List<AdminVO> adminVO = (List<AdminVO>)request.getAttribute("adminConfirm");

for(int i=0; i<adminVO.size(); i++){
	AdminVO vo = adminVO.get(i);
	String adminId = vo.getAdminId();
	String adminClass = vo.getAdminClass();
	String adminPass = vo.getAdminPass();
	String adminNickname = vo.getAdminNickname();

	%>
		{"adminId" : "<%=adminId %>"
		,"adminClass" : "<%=adminClass %>"
		,"adminPass" : "<%=adminPass %>"
		,"adminNickname" : "<%=adminNickname %>"
		}
		<% 
	}
%>
]