<%@page import="kr.or.ddit.paging.PagingVO"%>
<%@page import="kr.or.ddit.post.vo.PostVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// String strJson = (String)request.getAttribute("strJson");
List<PostVO> list = (List<PostVO>)request.getAttribute("list");
PagingVO pagingVO = (PagingVO)request.getAttribute("pagingVO");

// String msg = request.getParameter("msg") == null ? ""
// 		: request.getParameter("msg");
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
					<th><input class="PostChk" id="PostCheckboxAll" style="display: none;" type="checkbox" name="PostCheckboxAll" onclick="checkAll();"></th>
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
						int cnt = 1;
						String PostChkId = "PostCheckbox"+cnt;
						for (int i=0; i < size;  i++){
							%>
							<tr>
							<th><input class="PostChk PostChkArr" id="<%=list.get(i).getPostNo() %>chkbox" style="display: none;" type="checkbox" name="PostCheckbox"></th>
							<td><%= cnt%></td>
							<td><a href="select.do?postNo=<%=list.get(i).getPostNo()%>"><%= list.get(i).getPostTitle() %></a></td>
							<td><%= list.get(i).getPostContent()%></td>
							<td><%= list.get(i).getPostDate()%></td>
							<td><%= list.get(i).getPostView()%></td>
							</tr>
							<%
							cnt++;
							}
							%>
<!-- 페이징 처리 시작 -->
	      <%if(pagingVO.getTotalCount() > 0) {%>
	         <tr>
	            <td colspan="4" align="center">
	               <%if(pagingVO.getFirstPageNo() > pagingVO.getPageSize()) { %>
	               <a href="list.do?pageNo=<%=pagingVO.getFirstPageNo() - pagingVO.getPageSize() %>">[이전]</a>
	               <%} %>
	               <%for(int pNo = pagingVO.getFirstPageNo(); pNo <= pagingVO.getLastPageNo(); pNo++) { %>
	                  <a <%if(pNo == pagingVO.getCurrentPageNo()){ %> style="color:orange;"<%} %> href="list.do?pageNo=<%=pNo %>">[<%=pNo %>]</a>
	               <%} %>
	               <%if(pagingVO.getLastPageNo() < pagingVO.getTotalPageCount()) {%>
	               <a href="list.do?pageNo=<%=pagingVO.getFirstPageNo() + pagingVO.getPageSize() %>">[다음]</a>
	               <%} %>
	            </td>
	         </tr>
	      <%} %>
<!-- 페이징 처리 끝 --> 
						
					<%}else{
					%>
					<tr>
						<td colspan="5">게시글이  존재하지 않습니다.</td>
					</tr>
					<%
						}
					%>
			</tbody>
			</table>
			<a href="insert.do"><button type="button">등록</button></a>
			<select id="selectstr">
				<option value="1">제목검색</option>
				<option value="2">내용검색</option>
				<option value="3">작성자검색</option>
			</select>
		입력값<input type="text" id="inputstr"><br>
		<button type="button" onclick="search()">서치</button>
		<a href="list.do"><button type="button" onclick="select()">조회</button></a>
		<button type="button" onclick="toggleChk()">선택</button>
<!-- 		<a href="list.do"><button type="button" onclick="update()">수정</button></a> -->
		<button type="button" onclick="remove()">삭제</button>
</body>

<script type="text/javascript">

function checkAll(){
	if($("[name=PostCheckboxAll]").prop("checked")){
		$("[name=PostCheckbox]").prop("checked",true);
	}else{
		$("[name=PostCheckbox]").prop("checked",false);
	}
}

function toggleChk(){
$(".PostChk").toggle();
}

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

function chkdel(){
	var cnt=0;
	var postChkId="";
	var chkboxes = $(".PostChkArr");
	var length = $(".PostChkArr").length;
	var flag = "f";
	$.each(chkboxes,function(idx, item){
		if($(item).prop("checked")==true){
			flag ="t";			
		}
	});
	if(flag!="t"){
		return false;
	}else
		return true;
	
}

function remove(){
	
	if(!chkdel()){
		alert("삭제하실 글을 선택해주세요")
		return;
	}
	
	if(chkmsg()==true){
		alert("취소?");
		return;
	}
	alert("확인");
	
	
	var chkboxes = $(".PostChkArr");
		$.each(chkboxes, function(index, item){
		if($(item).prop("checked")==true){
			var idx  = $(item).attr("id").indexOf("chkbox");
			var id = ($(item).attr("id").substring(0,idx));
			console.log(id);
			remove2(id);
		}
	});
}
	
		
function remove2(str){
	
	inputparam = $("#inputstr").val();
	var param = {
			'postNo' : str
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
	
	flag = $("#selectstr").val();
	inputparam = $("#inputstr").val();
	var param = {
			"inputstr" : inputparam
			,"flag" : flag
			};
	$.ajax({
		url : "/MiddlePro/post/search.do"
		,type : "POST"
		,data : param
//  		,dataType : "json"
		,success : function(data){
			console.log(data)
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

function select(){
	$.ajax({
		url : "/MiddlePro/post/list.do"
		,type : "POST"
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