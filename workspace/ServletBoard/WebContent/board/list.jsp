<%@page import="kr.or.ddit.board.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
List<BoardVO> boardList = (List<BoardVO>)request.getAttribute("list");

	String msg = request.getParameter("msg") == null ? "" : request.getParameter("msg");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 목록</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>날짜</th>
			<th>내용</th>
		</tr>
		
		<%
			int boardSize = boardList.size();

			if (boardSize > 0) {
				for (int i = 0; i < boardSize; i++) {
		%>
		<tr>
			<td><%=boardList.get(i).getBoardNo()%></td>
			<td><%=boardList.get(i).getBoardTitle()%></td>
			<td><%=boardList.get(i).getBoardWriter()%></td>
			<td><%=boardList.get(i).getBoardDate()%></td>
			<td><%=boardList.get(i).getBoardContent()%></td>
		</tr>
		<%
			}
			} else {
		%>
		<tr>
			<td colspan="4">게시글넝보가 없습니다</td>
		</tr>
		<%
			}
		%>
		<tr align="center">
			<td colspan="4"><a href="register.do">[게시글 등록]</a></td>
		</tr>
	</table>
	<%
		if (msg.equals("성공")) { // 성공메시지 전달여부(된다면)
	%>
	<script type="text/javascript">
		alert("정상적으로 처리되었습니다");
	</script>
	<%
		}
	%>
</body>
</html>