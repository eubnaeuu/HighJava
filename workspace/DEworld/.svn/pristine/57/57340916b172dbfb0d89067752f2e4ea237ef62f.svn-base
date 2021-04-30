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

<meta name="viewport" content="width=device-width, initial-scale=1; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container" style="width: 300px">
  <table class="table table-hover">
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
	</table>
	<div style="text-align: center;">
			<a href="list.do"><button>[목록]</button></a> 
			<a href="list.do"><button type="button" onclick="remove()">삭제</button></a>
	
		</div>
</div>
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