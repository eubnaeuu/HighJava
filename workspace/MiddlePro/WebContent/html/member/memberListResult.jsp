<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

[
<%
//json형태로 만들어주는 곳

// 서블릿에서 조회한 결과를 "list"라는 key를 request에 담아줬음
List<MemberVO> list = (List<MemberVO>)request.getAttribute("list"); // 조회결과를 list로 담아줬음

for(int i=0; i<list.size(); i++){
	MemberVO vo = list.get(i);
	String memId = vo.getMemId(); 
	String memPass = vo.getMemPass(); 
	String memName = vo.getMemName();
	String memNickname = vo.getMemNickname();
	String memGender = vo.getMemGender(); 
	String memBir = vo.getMemBir(); 
	String memZip=vo.getMemZip(); 
	String memAdd1= vo.getMemAdd1() ;
	String memAdd2 =vo.getMemAdd2(); 
	String memHp =vo.getMemHp(); 
	String memMail= vo.getMemMail(); 
	int memCyberMoney= vo.getMemCyberMoney();
	if(i>0){
		%>,<%
	}
	
// json타입으로 만들어야 하는 부분 을
// {name : "", id : ""},{name : "", id : ""},...
%>
{
"memId" : "<%=memId%>"
, "memPass" : "<%=memPass%>"
,"memName" : "<%=memName%>"
, "memNickname" : "<%=memNickname%>"
, "memGender" : "<%=memGender%>"
, "memBir" : "<%=memBir%>"
, "memZip" : "<%=memZip%>"
, "memAdd1" : "<%=memAdd1%>"
, "memAdd2" : "<%=memAdd2%>"
, "memHp" : "<%=memHp%>"
, "memMail" : "<%=memMail%>"
, "memCyberMoney" : "<%=memCyberMoney%>"
}
<%
} // 자바의 대괄호를 의미 
%>
]
<%

// ★ json 파일로 출력하기
// 기본 형태 : [{"key","value"},{"key","value"},{"key","value"}]

%>
