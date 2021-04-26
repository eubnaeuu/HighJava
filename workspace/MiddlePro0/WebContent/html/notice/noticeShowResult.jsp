<%@page import="kr.or.ddit.notice.vo.NoticeVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
[
<%
NoticeVO nv = (NoticeVO)request.getAttribute("NoticeVO");
%>

	{ 
		"noticeNo" : "<%=nv.getNoticeNo() %>"
		,"adminId" : "<%=nv.getAdminId() %>"
		,"noticeTitle" : "<%=nv.getNoticeTitle() %>"
		,"noticeContent" : "<%=nv.getNoticeContent() %>"
		,"noticeDate" : "<%=nv.getNoticeDate() %>"
		
	}

]
