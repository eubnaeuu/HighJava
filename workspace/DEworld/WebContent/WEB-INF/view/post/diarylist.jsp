<%@page import="kr.or.ddit.member.service.MemberServiceImpl"%>
<%@page import="kr.or.ddit.member.service.IMemberService"%>
<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@page import="kr.or.ddit.comments.vo.CommentsVO"%>
<%@page import="kr.or.ddit.paging.PagingVO"%>
<%@page import="kr.or.ddit.post.vo.PostVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%





  
  
  
// String strJson = (String)request.getAttribute("strJson");
List<PostVO> diarylist = (List<PostVO>)request.getAttribute("diarylist");
PagingVO pagingVO = (PagingVO)request.getAttribute("pagingVO");
String msg = request.getParameter("msg") == null ? ""
		: request.getParameter("msg");

String userId = (String)request.getSession().getAttribute("userId");
IMemberService memberService = MemberServiceImpl.getInstance();
MemberVO logininfo = memberService.getMember(userId);

String hompiId = request.getParameter("hompiId");

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1; text/html; charset=UTF-8">
<title>게시글 목록</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
// $(document).ready(function(){
// 	var userId = sessionStorage.getItem("nowLogin");
// });
</script>
</head>
<body>
<div class="container">
<table id="postlisttable"  class="table table-hover">
			<thead>
				<tr>
					<th width="5" style="text-align: center;"><input class="PostChk" id="PostCheckboxAll" style="display: none;" type="checkbox" name="PostCheckboxAll" onclick="checkAll();"></th>
					<th width="50" style="text-align: center;">구   분</th>
					<th width="200" style="text-align: center;">제   목</th>
					<th width="70" style="text-align: center;">작성일</th>
					<th width="50" style="text-align: center;">조   회</th>
				</tr>
			</thead>
			<tbody>
					<%
					int size = diarylist.size();
					if(size > 0){
						int cnt = 1;
						String PostChkId = "PostCheckbox"+cnt;
						for (int i=0; i < size;  i++){
							%>
							<tr>
							<th width="5"><input class="PostChk PostChkArr" id="<%=diarylist.get(i).getPostNo() %>chkbox" style="display: none;" type="checkbox" name="PostCheckbox"></th>
							<td width="50"><%= cnt%></td>
							<td width="200"><a href="select.do?hompiId=<%=hompiId %>&flag=dia&postNo=<%=diarylist.get(i).getPostNo()%>"><%= diarylist.get(i).getPostTitle() %></a></td>
<%-- 							<td><%= diarylist.get(i).getPostContent()%></td> --%>
							<td width="70"><%= diarylist.get(i).getPostDate().substring(2, 10)%></td>
							<td width="50"><%= diarylist.get(i).getPostView()%></td>
							</tr>
							<%
							cnt++;
							}
							%>
<!-- 페이징 처리 시작 -->
	      <%if(pagingVO.getTotalCount() > 0) {%>
	         <tr>
	            <td colspan="6" align="center">
	               <%if(pagingVO.getFirstPageNo() > pagingVO.getPageSize()) { %>
	               <a href="list.do?flag=dia&pageNo=<%=pagingVO.getFirstPageNo() - pagingVO.getPageSize() %>">[이전]</a>
	               <%} %>
	               <%for(int pNo = pagingVO.getFirstPageNo(); pNo <= pagingVO.getLastPageNo(); pNo++) { %>
	                  <a <%if(pNo == pagingVO.getCurrentPageNo()){ %> style="color:orange;"<%} %> href="list.do?pageNo=<%=pNo %>">[<%=pNo %>]</a>
	               <%} %>
	               <%if(pagingVO.getLastPageNo() < pagingVO.getTotalPageCount()) {%>
	               <a href="list.do?flag=dia&pageNo=<%=pagingVO.getFirstPageNo() + pagingVO.getPageSize() %>">[다음]</a>
	               <%} %>
	            </td>
	         </tr>
	      <%} %>
<!-- 페이징 처리 끝 --> 
						
					<%}else{
					%>
					<tr>
						<td colspan="5">다이어리가  존재하지 않습니다.</td>
					</tr>
					<%
						}
					%>
			</tbody>
			</table>
			<%if((userId.trim()).equals(hompiId)){
				%>
			<a href="insert.do?hompiId=<%=hompiId %>&flag=dia"><button type="button">등록</button></a>
			<%
			}
			%>
			<select id="selectstr">
				<option value="1">제목</option>
				<option value="2">내용</option>
				<option value="3">작성자</option>
			</select>
		<input type="text" id="inputstr">
		<button type="button" onclick="search()">검색</button>
<!-- 		<a href="list.do"><button type="button" onclick="select()">조회</button></a> -->
			<%if((userId.trim()).equals(hompiId)){
				%>
		<button type="button" onclick="toggleChk()">선택</button>
		<button type="button" onclick="remove()">삭제</button>
			<%
			}
			%>
			</div>
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
		url : "/DEworld/post/update.do"
		,type : "post"
		,data : param
// 		,dataType : "json"
		,success : function(data){
			console.log(data)
			alert("성공");
		}
		,error : function(xhr){
			console.error(xhr);
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

function reload(){
	$.ajax({
		url : "/DEworld/post/list.do"
// 		,dataType : "json"
		,success : function(data){
			console.log(data)
		}
		,error : function(xhr){
			console.error(xhr);
		}
	});
}

function remove() {
	var hompiId = '<%=hompiId%>';
	var flag = 'dia';
	
	if (!chkdel()) {
		alert("삭제하실 글을 선택해주세요")
		return;
	}

	if (!chkmsg()) {
		return;
	}
	var chkboxes = $(".PostChkArr");
	$.each(chkboxes, function(index, item) {
		if ($(item).prop("checked") == true) {
			var idx = $(item).attr("id").indexOf("chkbox");
			var id = ($(item).attr("id").substring(0, idx));
			console.log(id);
			removelist(id);
			gobeforelist(hompiId,flag);
		}
	});
}

function removelist(str) {
	var postNo = str;
	inputparam = $("#inputstr").val();
	var hompiId = '<%=hompiId%>';
	var flag = 'dia';
	var param = {
			'postNo' : postNo
			,'hompiId' : hompiId 
			,'flag' : flag 
	};
	$.ajax({
		url : "/DEworld/post/delete.do",
		type : "post",
		data : param
		,
		success : function(data) {
			console.log(data);
		},
		error : function(xhr) {
			console.error(xhr);
		}
	});
}		

function remove2(str){
	var postNo = str;
	inputparam = $("#inputstr").val();
	var hompiId = '<%=hompiId%>';
	var flag = 'dia';
	alert(hompiId);
	var param = {
			'postNo' : postNo
			,'hompiId' : hompiId 
			,'flag' : flag 
			};
	$.ajax({
		url : "/DEworld/post/delete.do"
		,type : "post"
		,data : param
		,success : function(data){
			console.log(data);
			gobefore(hompiId,postNo,flag);
		}
		,error : function(xhr){
			console.error(xhr);
		}
	});
}

function gobeforelist(hompiId,flag){
	var URI="http://localhost/DEworld/post/list.do?hompiId="
			+hompiId+"&flag="+flag
	window.location.href = URI;
}
function gobeforeview(hompiId,flag,postNo){
	var URI="http://localhost/DEworld/post/list.do?hompiId="
			+hompiId+"&flag="+flag+"&postNo="+postNo
	window.location.href = URI;
}
function create(){
	inputparam = $("#inputstr").val();
	var param = {
			'postNo' : inputparam         
			,'postTitle' : inputparam2         
			};
	$.ajax({
		url : "/DEworld/post/insert.do"
		,type : "post"
		,data : param
// 		,dataType : "json"
		,success : function(data){
			console.log(data)
			alert("성공");
		}
		,error : function(xhr){
			console.error(xhr);
		}
		
	});
}
function search(){

		var flag = $("#selectstr").val();
		var inputparam = $("#inputstr").val();

		if ("1" == flag) {
			var URI="http://localhost/DEworld/post/search.do?postTitle="+inputparam;
			window.location.href = URI;
		} else if ("2" == flag) {
			var URI="http://localhost/DEworld/post/search.do?postContent="
					+ inputparam;
			window.location.href = URI;
		} else if ("3" == flag) {
			var URI="http://localhost/DEworld/post/search.do?memId="
					+ inputparam;
			window.location.href = URI;
		}
	}
	
	function search1() {
		flag = $("#selectstr").val();
		inputparam = $("#inputstr").val();
		alert(inputparam);

		var param = {
			"inputstr" : inputparam,
			"flag" : flag
		};
		$.ajax({
			url : "/DEworld/post/search.do",
// 			type : "POST",
			data : param
			//  		,dataType : "json"
			,
			success : function(data) {
				console.log(data)
			},
			error : function(xhr) {
				console.error(xhr);
			}

		});
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