<%@page import="loginPage.service.MemberService"%>
<%@page import="kr.or.ddit.item.vo.ItemVO"%>
<%@page import="kr.or.ddit.hompi.service.HompiServiceImpl"%>
<%@page import="kr.or.ddit.hompi.service.HompiService"%>
<%@page import="kr.or.ddit.hompi.vo.HompiVO"%>
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
	HompiVO hv = new HompiVO();

	String hompiId = request.getParameter("hompiId");
	String userId = (String) request.getSession().getAttribute("userId");
	hv.setHompiId(hompiId);

	HompiService hompiService = HompiServiceImpl.getInstance();
	List<HompiVO> list = hompiService.getSearchHompi(hv);

	String hompiNick = list.get(0).getHompiId();

	ItemVO itemVO = new ItemVO();
	itemVO.setMemId(hompiId);

	MemberService service = new MemberService();
	List<ItemVO> minimilist = service.searchMyMinimi(itemVO); // 미니미 목록
	List<ItemVO> bglist = service.searchMyBg(itemVO); // 배경 목록
	
	
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1; text/html; charset=UTF-8">
<title>게시글 목록</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
	// $(document).ready(function(){
	// 	var userId = sessionStorage.getItem("nowLogin");
	// });
</script>
</head>
<body>
	<div class="container">
		<table id="postlisttable" class="table table-hover">
			<thead>
				<tr>보유중인 미니미 목록</tr>
			</thead>
			<tbody>
				<%
					if (minimilist != null) {
				%><tr>
					<%
					int cnt=0;
						for (ItemVO ivo : minimilist) {
							cnt++;
					%>
					<td><input name="minimiRadio" id="minimiRadio<%=cnt %>" type="radio" title="<%=ivo.getItemId()%>"><img alt=""
						src="/DEworld/image/item/<%=ivo.getItemImg()%>" width="100" height="100" value="<%=ivo.getItemId()%>"></td>
					<%
						}
					%>
				</tr>
				<%
					} else {
				%>
				<tr>
					<td>보유중인 아이템이 없습니다</td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
		<div>
		<button onclick="updateMinimi()" type="button">변경</button>
		</div>
		<table class="table table-hover">
			<thead>
				<tr>보유중인 배경아이템 목록</tr>
			</thead>
			<tbody>
				<%
					if (bglist != null) {
				%><tr>
					<%
					int cnt=0;
						for (ItemVO ivo1 : bglist) {
							cnt++;
					%>
					<td><input name="bgRadio" id="bgRadio<%=cnt %>" type="radio" title="<%=ivo1.getItemId()%>"><img alt=""
						src="/DEworld/image/hompiBackground/<%=ivo1.getItemImg()%>" width="100" height="100"></td>
					<%
						}
					%>
				</tr>
				<%
					} else {
				%>
				<tr>
					<td>보유중인 배경아이템이 없습니다</td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
		<div>
		<button onclick="updateBg()" type="button">변경</button>
		</div>
	</div>
</body>
<script type="text/javascript">

	function updateBg(){
		var size = $("input[name=bgRadio]").length;
		var select ="";
		for(i=1; i<size+1; i++){
			if(($("#input"+i).prop)){
				select = size;
			}
			
		var itemId = $("#bgRadio"+size).attr("title");
		var hompiId = '<%=hompiId%>';
		var flag = "B";
		
		var param = {
				'itemId' : itemId         
				,'memId' : hompiId      
				,'flag' : flag      
				};
		$.ajax({
			url : "/DEworld/item/update.do"
			,type : "post"
			,data : param
			,success : function(data){
				gobefore(hompiId);
			}
			,error : function(xhr){
			}
		});
	}
	}
		function updateMinimi(){
			
			
			var size = $("input[name=minimiRadio]").length;
			alert("size:"+size);
			var select ="";
			for(i=1; i<size+1; i++){
				if(($("#input"+i).prop)){
					select = size;
				}
				alert("select"+select);
			var itemId = $("#minimiRadio"+size).attr("title");
			alert("itemId"+itemId);
			var hompiId = '<%=hompiId%>';
			var flag = "M";
			
			var param = {
					'itemId' : itemId         
					,'memId' : hompiId      
					,'flag' : flag      
					};
			$.ajax({
				url : "/DEworld/item/update.do"
				,type : "post"
				,data : param
				,success : function(data){
					gobefore(hompiId);
				}
				,error : function(xhr){
				}
			});
		}
		}
	
	function gobefore(hompiId) {
		var URI = "http://localhost/DEworld/hompi/main.do?hompiId=" + hompiId;
		window.location.href = URI;
	}
</script>
</html>