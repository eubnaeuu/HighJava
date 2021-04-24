<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
 <html lang="kr">
<head>
<title>메인 화면</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- <script src="./list.jsp"></script> -->
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
		<h1>POST</h1>
		<div id="div1">
		POSTNO 입력값 : <input type="text" id="inputstr"><br>
		POSTTITLE 입력값 : <input type="text" id="inputstr2"><br>
		POSTTITLE 변경값 : <input type="text" id="updatestr"><br>
		<input type="file" name="atchFile" multiple="multiple">
		
		<br><br><br><br>
		
		<button type="button" onclick="create()">등록</button>
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
					<td>POSTNO:</td>
					<td><input type="text" name="postNo" value="p001"></td>
				</tr>
				<tr>
					<td>POSTTITLE:</td>
					<td><input type="text" name="postTitle" value="게시글제목"></td>
				</tr>
				<tr>
					<td>MEMID:</td>
					<td><input type="text" name="memId" value=""></td>
				</tr>
				<tr>
					<td>첨부파일1</td>
					<td><input type="file" name="atchFile1" id="atch1"></td>
				</tr>
				<tr>
					<td>첨부파일2</td>
					<td><input type="file" name="atchFile2" id="atch2"></td>
				</tr>
			</table>
			<input type="submit" value="post등록">
			</form>
			
			<div id="divtmp"></div>
		</div>
	</div>
</body>
<script type="text/javascript">

var inputparam="";
var inputparam2="";
var updateparam="";

function update(){
	inputparam = $("#inputstr").val();
	updateparam = $("#updatestr").val();
	var param = {
			'postNo' : inputparam         
			,'postTitle' : updateparam    
			};
	$.ajax({
		url : "/MiddlePro/post/update.do"
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
	inputparam = $("#inputstr").val();
	var param = {
			'postNo' : inputparam
			};
	$.ajax({
		url : "/MiddlePro/post/delete.do"
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

 
function create(){
	inputparam = $("#inputstr").val();
	var param = {
			'postNo' : inputparam         
			,'postTitle' : inputparam2         
			};
	$.ajax({
		url : "/MiddlePro/post/insert.do"
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
	inputparam = $("#inputstr").val();
	var param = {
			"postNo" : inputparam
			,"postTitle" : inputparam2
			};
	
	$.ajax({
		url : "/MiddlePro/post/search.do"
		,type : "post"
		,data : param
 		,dataType : "json"
		,success : function(data){
			console.log(data)
			
		}
		,error : function(xhr){
			console.error(xhr);
			alert("실패");
		}
	});
}
function select(){
	$.ajax({
		url : "/MiddlePro/post/list.do"
		,type : "post"
		,dataType : "json"
// 		,data : param
		,success : function(data){
			console.log(data)
// 			makeTable(data);
		}
		,error : function(xhr){
			console.error(xhr);
			alert("실패");
		}
	});
}


function makeTable(data){
	// table , tr ,td

	var thead = "<table border='2px solid'>";
	thead += "<thead>"
			+ "<tr>"
			+ "<th>글번호</th>"
			+ "<th>제  목</th>"
			+ "<th>내 용</th>"
			+ "<th>일 자</th>"
			+ "<th>조회수</th>"
			+ "</tr>"
			+ "</thead>";
	
	var size = Object.keys(data).length;
	var tbody = "<tbody>";
	for (var i=0; i < size;  i++){
	tbody +=  "<tr>"
			+ "<td>"+1+"</td>"
			+ "<td><a href='select.do?postNo="+data[i].postNo+"'>"+data[i].postTitle+"</a></td>"
			+ "<td>"+data[i].postContent+"</td>"
			+ "<td>"+data[i].postDate+"</td>"
			+ "<td>"+data[i].postView+"</td>"
			+ "</tr>"
	}
			+ "</tbody>"
			+ "</table>"
			
	$("#divtmp").html(thead+tbody);
}

</script>
</html>
