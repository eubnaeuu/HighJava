<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

[   
<%
List<MemberVO> list = (List<MemberVO>)request.getAttribute("list"); // 조회결과를 list로 담아줬었음. = MemberServlet.java 48Line

for(int i=0; i<list.size(); i++){
	MemberVO vo = list.get(i);
	String memId = vo.getMemId();
	String memPass = vo.getMemPass();
	String memMail = vo.getMemMail();
	String memName = vo.getMemName();
	String memNickname = vo.getMemNickname();
	String memGender   = vo.getMemGender();
	String memBir      = vo.getMemBir();
	String memZip      = vo.getMemZip();
	String memAdd1     = vo.getMemAdd1();
	String memAdd2     = vo.getMemAdd2();
	String memHp       = vo.getMemHp();
	int memCybermoney = vo.getMemCyberMoney();
	//json 타입을 만들어야 하는 부분 ==> {name : "~", id : "~"}
	//번호, id, 이름, 비밀번호, 생년월일, 전화번호, 메일, 직업
	%>
		{"memId" : "<%=memId %>"
		, "memPass" : "<%=memPass%>"
		, "memMail" : "<%=memMail%>"
		, "memName" : "<%=memName%>"
		, "memNickname" : "<%=memNickname%>"
		, "memGender" : "<%=memGender%>"
		, "memBir" : "<%=memBir%>"
		, "memZip" : "<%=memZip%>"
		, "memAdd1" : "<%=memAdd1%>"
		, "memAdd2" : "<%=memAdd2%>"
		, "memHp" : "<%=memHp%>"
		, "memCybermoney" : "<%=memCybermoney%>"
		}
	<%
}
%>
]
