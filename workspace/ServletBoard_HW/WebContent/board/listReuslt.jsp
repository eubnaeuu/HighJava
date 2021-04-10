<%@page import="kr.or.ddit.board.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
[
<%
//json형태로 만들어주는 곳인가?
// 서블릿에서 조회한 결과를 "list"라는 key를 request에 담아줬음
List<BoardVO> list = (List<BoardVO>)request.getAttribute("boardList"); // 조회결과를 list로 담아줬음

for(int i=0; i<list.size(); i++){
	BoardVO vo = list.get(i);
	String boardNo = vo.getBoardNo();
	String boardTitle = vo.getBoardTitle();
	String boardWriter =vo.getBoardWriter();
	String boardContent = vo.getBoardContent(); 
	String boardDate = vo.getBoardDate(); 
	if(i>0){
		%>,<%
	}
	
// json타입으로 만들어야 하는 부분 을
// {name : "", id : ""},{name : "", id : ""},...


// ☆  아래에 오른쪽 변수이름들은 위에서 만든 변수와 연결되는 거맞제?
// class 초반에 데이터 왜 저장해둔거지? 다 null값이던데,
%>
{
"boardNo" : "<%=boardNo%>"
, "boardTitle" : "<%=boardTitle%>"
,"boardWriter" : "<%=boardWriter%>"
, "boardContent" : "<%=boardContent%>"
, "boardDate" : "<%=boardDate%>"
}
<%
} // 자바의 대괄호를 의미 
%>
]
<%

// ★ json 파일로 출력하기
// 기본 형태 : [{"key","value"},{"key","value"},{"key","value"}]

%>
