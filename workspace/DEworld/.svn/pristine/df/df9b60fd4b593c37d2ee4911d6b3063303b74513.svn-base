<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="kr">
<head>
<title>댓글</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- <script type="text/javascript" src="/JqueryPro/js/member/zippopup.html"></script> -->
<!-- ☆   ?v=1 의미 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<style>
 table, td, th {
 	border: 1px solid;
 	text-align: center;
 }
 table thead, button {
 	background-color: #C8D8E5;
 }
</style>
<body>
	<div class="container">
		<h1>friendreq</h1>
		<div id="div1">
		
		메시지NO 입력값 : <input type="text" id="inputMessageNo"><br>
		멤버ID 입력값 : <input type="text" id="inputMemId"><br>
		친구ID 입력값 : <input type="text" id="inputFriendId"><br>
		내용 입력값 : <input type="text" id="inputReqYn"><br>
		상태 입력값 : <input type="text" id="inputStatus"><br>
		
		<br><br><br><br>
		<button type="button" onclick="search()">서치</button>
		<button type="button" onclick="select()">조회</button>
		<button type="button" onclick="update()">수정</button>
		<button type="button" onclick="remove()">삭제</button>
		</div>
		<br><br><br><br>
		
		<div>
			<form action="insert.do" method="post" enctype="multipart/form-data">
			<table>
				<tr>
					<td>memId:</td>
					<td><input type="text" name="memId" id="inputMemId" value=""></td>
				</tr>
				<tr>
					<td>friendId:</td>
					<td><input type="text" name="receiveMem" id="inputFriendId" value=""></td>
				</tr>
				<tr>
					<td>내용:</td>
					<td><input type="text" name="messageContent" id="inputReqYn" value=""></td>
				</tr>
				<tr>
					<td>상태:</td>
					<td><input type="text" name="messageStatus" id="inputStatus" value=""></td>
				</tr>
			</table>
			<input type="submit" value="쪽지보내기">
			</form>
		</div>
	</div>
</body>
<script type="text/javascript">

var inputMemId="";
var inputFriendId="";
var inputReqYn="";

function update(){
	inputMessageNo = $("#inputMessageNo").val();
	inputStatus = $("#inputStatus").val();
	
	var param = {
			'memId' : inputMemId         
			,'messageNo' : inputMessageNo    
			,'messageStatus' : inputStatus    
			};
	$.ajax({
		url : "/DEworld/message/update.do"
		,type : "post"
		,data : param
// 		,dataType : "json"
		,success : function(data){
			console.log(data)
			alert("성공");
		}
		,error : function(xhr){
			console.error(xhr);
			alert("실패");
		}
		
	});
}

function remove(){
	if(chkmsg()){
		return;
	}
	inputMessageNo = $("#inputMessageNo").val();
	var param = {
			'messageNo' : inputMessageNo
			};
	$.ajax({
		url : "/DEworld/message/delete.do"
		,type : "post"
		,data : param
// 		,dataType : "json"
		,success : function(data){
			console.log(data)
			alert("성공");
		}
		,error : function(xhr){
			console.error(xhr);
			alert("실패");
		}
	});
}

function search(){
	inputMemId = $("#inputMemId").val();
	inputFriendId = $("#inputFriendId").val();
	inputStatus = $("#inputStatus").val();
	
	var param = {
			"memId" : inputMemId
			,"receiveMem" : inputFriendId
			,"messageStatus" : inputStatus
			};
	
	$.ajax({
		url : "/DEworld/message/search.do"
		,type : "post"
		,data : param
// 		,dataType : "json"
		,success : function(data){
			console.log(data)
			alert("성공");
		}
		,error : function(xhr){
			console.error(xhr);
			alert("실패");
		}
	});
}

function select(){
	$.ajax({
		url : "/DEworld/message/list.do"
		,type : "post"
		,dataType : "json"
		,success : function(data){
			console.log(data)
			alert("성공");
		}
		,error : function(xhr){
			console.error(xhr);
			alert("실패");
		}
	});
}


function chkmsg(){
		confirm("정말 삭제하시겠습니까?");
	}


</script>
</html>
