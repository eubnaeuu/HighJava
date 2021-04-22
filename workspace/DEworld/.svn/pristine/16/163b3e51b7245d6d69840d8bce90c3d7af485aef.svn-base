<%@page import="kr.or.ddit.notice.vo.NoticeVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
[
<%
List<NoticeVO> list = (List<NoticeVO>)request.getAttribute("list");

for(int i=0; i<list.size(); i++){
	NoticeVO nv = list.get(i);
	if(i>0){
		%>,<%
	}
	%>
	{
		"noticeNo" : "<%=nv.getNoticeNo() %>"
		,"adminId" : "<%=nv.getAdminId() %>"
		,"noticeTitle" : "<%=nv.getNoticeTitle() %>"
		,"noticeDate" : "<%=nv.getNoticeDate() %>"
	}
	<%
}
%>
]
