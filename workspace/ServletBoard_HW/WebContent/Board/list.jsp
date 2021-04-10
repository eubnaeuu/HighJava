<%@page import="kr.or.ddit.board.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	List<BoardVO> boardList = (List<BoardVO>)request.getAttribute("boardList");
    
    // ★  msg 무슨 의미인지
    String msg = request.getParameter("msg") == null ? "" : request.getParameter("msg");
    %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 목록</title>
<style type="text/css">
		
		body{
		background-color: #E8F2FE;
			color: #8A9097;
		}
		
		table {
		background-color: white;
		}
		
		table, table tr {
		border: 1px solid #B9C1CB;
		
</style>
<script type="text/javascript">
	
</script>
</head>
<body>
	<!-- 검색결과 영역 -->
		<div id="divtmp">
		
	<%
	System.out.println(" 글번호\t제목\t작성자\t일자\t내용");
	for(BoardVO bv : boardList){
		System.out.println(bv.getBoardNo()+"\t"+bv.getBoardTitle()+"\t"+bv.getBoardWriter()+"\t"+bv.getBoardDate()+"\t"+bv.getBoardContent());
	}
	
	%>
	</div>
	<div>
			<button type="button" id="boardSelect">조회</button>
			<button type="button" id="boardRegister">작성</button>
			<button type="button" id="boardModify">수정</button>
			<button type="button" id="boardDelete">삭제</button>
			<button type="button" id="boardSearch">검색</button>
			<button type="button" id="boardExit">종료</button>
	</div>
</body>
</html>