<%@page import="kr.or.ddit.message.vo.MessageVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	MessageVO mv = (MessageVO) request.getAttribute("messageview");
	
	String msg = request.getParameter("msg") == null ? ""
			: request.getParameter("msg");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글상세</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<table>
		<tr>
			<td>FROM:</td>
			<td><%=mv.getMemId()%></td>
		</tr>
		<tr>
			<td>TO:</td>
			<td><%=mv.getReceiveMem()%></td>
		</tr>
		<tr>
			<td>일 자:</td>
			<td><%=mv.getMessageDate()%></td>
		</tr>
		<tr>
			<td>내 용:</td>
			<td><textarea readonly="readonly" style="margin: 0px; height: 142px; width: 154px;"><%=mv.getMessageContent()%></textarea></td>
		</tr>
<!-- 		<tr> -->
<!-- 			<td>상 태:</td> -->
<%-- 			<td><%=mv.getMessageStatus()%></td> --%>
<!-- 		</tr> -->
		<!-- 		<tr> -->
		<!-- 			<td colspan="3"> -->
		<!-- 				<a href="list.do">[목록]</a> -->
		<%-- 				<a href="update.do?postNo=<%=mv.getMessageNo() %>">[수정]</a> --%>
		<%-- 				<a href="delete.do?postNo=<%=mv.getMessageNo() %>">[삭제]</a> --%>
		<!-- 			</td> -->
		<!-- 		</tr> -->
	</table>
		<tr>
			<td colspan="3"><a href="list.do">[목록]</a> 
			<a href="list.do"><button type="button" onclick="remove()">삭제</button></a>
		</tr>
	</table>
</body>
<script type="text/javascript">

function remove(){

	if(!chkmsg()){
		return;
	}
	
	messageNo = <%=mv.getMessageNo()%>
	
	var param = {
			'messageNo' : messageNo
			};
	$.ajax({
		url : "/DEworld/message/delete.do"
		,type : "post"
		,data : param
// 		,dataType : "json"
		,success : function(data){
			console.log(data);
		}
		,error : function(xhr){
			console.error(xhr);
		}
	});
}

function chkmsg() {
	return confirm("정말 삭제하시겠습니까?");
}

function select() {
	$.ajax({
		url : "/DEworld/message/list.do",
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