<%@page import="kr.or.ddit.item.vo.ItemVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@page import="kr.or.ddit.hompi.vo.HompiVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

[   
<%
List<ItemVO> list = (List<ItemVO>)request.getAttribute("setItem"); // 조회결과를 list로 담아줬었음. = MemberServlet.java 48Line

for(int i=0; i<list.size(); i++){
	ItemVO vo = list.get(i);
	String 	memId = vo.getMemId();
	String 	itemId = vo.getItemId();
	String 	litemGu = vo.getLitemGu();
	String 	itemName = vo.getItemName();
	String 	itemDesc = vo.getItemDesc();
	String 	itemImg = vo.getItemImg(); // 아이템 이미지
	
	//json 타입을 만들어야 하는 부분 ==> {name : "~", id : "~"}
	//번호, id, 이름, 비밀번호, 생년월일, 전화번호, 메일, 직업
	%>
		{"memId" : "<%=memId%>"
		, "itemId" : "<%=itemId%>"
		, "litemGu" : "<%=litemGu%>"
		, "itemName" : "<%=itemName%>"
		, "itemDesc" : "<%=itemDesc%>"
		, "itemImg" : "<%=itemImg%>"
		}
		<% if(list.size() -1 != i){
			%>
				,
			<%
		}
		%>
		
	<%
}
%>
]
