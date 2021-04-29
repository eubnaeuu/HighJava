<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@page import="kr.or.ddit.hompi.vo.HompiVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

[   
<%
List<HompiVO> list = (List<HompiVO>)request.getAttribute("setHompi"); // 조회결과를 list로 담아줬었음. = MemberServlet.java 48Line

for(int i=0; i<list.size(); i++){
	HompiVO vo = list.get(i);
    String hompiId = vo.getHompiId();
	String memId = vo.getMemId();
	String hompiInfo = vo.getHompiInfo();
	String hompiProfileImg = vo.getHompiProfileImg();
	String hompiMiniroom = vo.getHompiMiniroom();
	String hompiBackground = vo.getHompiBackground();
	String hompiTextcolor = vo.getHompiTextcolor();
	long visitCountToday = vo.getVisitCountToday();
	long visitCountTotal = vo.getVisitCountTotal();
	long scrapCount = vo.getScrapCount();
	
	//json 타입을 만들어야 하는 부분 ==> {name : "~", id : "~"}
	//번호, id, 이름, 비밀번호, 생년월일, 전화번호, 메일, 직업
	%>
		{"hompiId" : "<%=hompiId %>"
		, "memId" : "<%=memId%>"
		, "hompiInfo" : "<%=hompiInfo%>"
		, "hompiProfileImg" : "<%=hompiProfileImg%>"
		, "hompiMiniroom" : "<%=hompiMiniroom%>"
		, "hompiBackground" : "<%=hompiBackground%>"
		, "hompiTextcolor" : "<%=hompiTextcolor%>"
		, "visitCountToday" : "<%=visitCountToday%>"
		, "visitCountTotal" : "<%=visitCountTotal%>"
		, "scrapCount" : "<%=scrapCount%>"
		}
	<%
}
%>
]
