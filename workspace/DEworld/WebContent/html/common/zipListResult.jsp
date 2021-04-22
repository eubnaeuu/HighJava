<%@page import="kr.or.ddit.member.vo.ZipVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

[
<%
List<ZipVO> list = (List<ZipVO>)request.getAttribute("list");

for(int i=0 ; i<list.size() ; i++) {
	if(i>0){
		%>,<%
	}
	
	ZipVO vo = list.get(i);
	String sido = vo.getSido();
	String gugun = vo.getGugun();
	String dong = vo.getDong();
	String bunji = vo.getBunji();
	String zipcode = vo.getZipcode();
	
	%>
	{
		"sido" : "<%=sido %>"
		,"gugun" : "<%=gugun %>"
		,"dong" : "<%=dong %>"
		,"bunji" : "<%=bunji %>"
		,"zipcode" : "<%=zipcode %>"
	}
	<%
}
%>
]