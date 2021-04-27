<%@page import="kr.or.ddit.message.vo.MessageVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	List<MessageVO> messagelist = (List<MessageVO>) request.getAttribute("messagelist");
	
	String msg = request.getParameter("msg") == null ? ""
			: request.getParameter("msg");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글상세</title>
</head>
<body>
	<table>
		<tr>
			<td>FROM:</td>
			<td><%=messagelist.get(0).getMemId()%></td>
		</tr>
		<tr>
			<td>TO:</td>
			<td><%=messagelist.get(0).getReceiveMem()%></td>
		</tr>
		<tr>
			<td>일 자:</td>
			<td><%=messagelist.get(0).getMessageDate()%></td>
		</tr>
		<tr>
			<td>내 용:</td>
			<td><textarea readonly="readonly"><%=messagelist.get(0).getMessageContent()%></textarea></td>
		</tr>
<!-- 		<tr> -->
<!-- 			<td>상 태:</td> -->
<%-- 			<td><%=messagelist.get(0).getMessageStatus()%></td> --%>
<!-- 		</tr> -->
		<!-- 		<tr> -->
		<!-- 			<td colspan="3"> -->
		<!-- 				<a href="list.do">[목록]</a> -->
		<%-- 				<a href="update.do?postNo=<%=messagelist.get(0).getMessageNo() %>">[수정]</a> --%>
		<%-- 				<a href="delete.do?postNo=<%=messagelist.get(0).getMessageNo() %>">[삭제]</a> --%>
		<!-- 			</td> -->
		<!-- 		</tr> -->
	</table>
		<tr>
			<td colspan="3"><a href="list.do">[목록]</a> <a
				href="delete.do?messageNo=<%=messagelist.get(0).getMessageNo()%>">[삭제]</a></td>
		</tr>
	</table>
</body>
<script type="text/javascript">

function remove(){
	
	if(!chkdel()){
		alert("삭제하실 글을 선택해주세요")
		return;
	}
	
	if(!chkmsg()){
		return;
	}
	
}

function chkmsg() {
	return confirm("정말 삭제하시겠습니까?");
}

function select() {
	$.ajax({
		url : "/DEworld/post/list.do",
		type : "POST"
		// 		,dataType : "json"
		// 		,data : param
		,
		success : function(data) {
			console.log(data)
			// 			makeTable(data);
		},
		error : function(xhr) {
			console.error(xhr);
		}
	});
}

</script>
</html>