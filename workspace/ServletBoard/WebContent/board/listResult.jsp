<%@page import="kr.or.ddit.board.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
[
<%
List<BoardVO> list = (List<BoardVO>)request.getAttribute("list"); // 조회결과를 list로 담아줬음

for(int i=0; i<list.size(); i++){
	BoardVO bv = list.get(i);
	
	String boardNo = bv.getBoardNo();
	String boardTitle = bv.getBoardTitle();
	String boardWriter =bv.getBoardWriter();
	String boardContent = bv.getBoardContent(); 
	String boardDate = bv.getBoardDate(); 
	if(i>0){
		%>,<%
	}
%>
{
"boardNo" : "<%=boardNo%>"
,"boardTitle" : "<%=boardTitle%>"
,"boardWriter" : "<%=boardWriter%>"
,"boardContent" : "<%=boardContent%>"
,"boardDate" : "<%=boardDate%>"
}
<%
}
%>
]

