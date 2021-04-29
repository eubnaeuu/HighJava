<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@page import="kr.or.ddit.hompi.vo.HompiVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

[   
<%
 List<HompiVO> list = (List<HompiVO>)request.getAttribute("list2"); // 조회결과를 list로 담아줬었음. = MemberServlet.java 48Line

for(int i=0; i<list.size(); i++){
	HompiVO vo = list.get(i);
	String memId = vo.getMemId();
	String memNickname = vo.getMemNickname();
	String hompiProfileImg = vo.getHompiProfileImg();
	long visitCountToday = vo.getVisitCountToday();
	String hompiInfo = vo.getHompiInfo();
	%>
	{"memId" : "<%=memId %>"
	,"memNickname" : "<%=memNickname %>"
	,"hompiProfileImg" : "<%=hompiProfileImg %>"
	,"visitCountToday" : "<%=visitCountToday %>"
	,"hompiInfo" : "<%=hompiInfo %>"
	}
<%
}
%>
]
