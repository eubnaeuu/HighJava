<%@page import="kr.or.ddit.post.vo.PostVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// String strJson = (String)request.getAttribute("strJson");
List<PostVO> list = (List<PostVO>)request.getAttribute("list");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>게시글 목록</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
</script>
</head>
<body>
<table border='2px solid' id="postlisttable">
			<thead>
				<tr>
					<th>글번호</th>
					<th>제  목</th>
					<th>내 용</th>
					<th>일 자</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody>
					<%
					int size = list.size();
					if(size > 0){
						int cnt = 0;
						for (int i=0; i < size;  i++){
							%>
							<tr>
							<td><%= cnt%></td>
							<td><%= list.get(i).getPostTitle()%></td>
							<td><%= list.get(i).getPostContent()%></td>
							<td><%= list.get(i).getPostDate()%></td>
							<td><%= list.get(i).getPostView()%></td>
							</tr>
							<%
							cnt++;
						}
					}else{
					%>
					<tr>
						<td colspan="5">게시글이  존재하지 않습니다.</td>
					</tr>
					<%
						}
					%>
			</tbody>
			</table>
			<a href="insert.do"><button type="button" onclick="create()">등록</button></a>
		입력값<input type="text" id="inputstr"><br>
		<a href="search.do"><button type="button" onclick="search()">서치</button></a>
		<a href="list.do"><button type="button" onclick="select()">조회</button></a>
		<a href="list.do"><button type="button" onclick="select()">선택</button></a>
<!-- 		<a href="list.do"><button type="button" onclick="update()">수정</button></a> -->
		<a href="delete.do"><button type="button" onclick="remove()">삭제</button></a>
			<%
			%>
</body>

<script type="text/javascript">

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
// 		,dataType : "json"
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
</script>
</html>