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

	// hompiId 어떻게?
	String hompiId = "cdwcdw34";

	PagingVO pagingVO = (PagingVO) request.getAttribute("pagingVO");
	String msg = request.getParameter("msg") == null ? "" : request.getParameter("msg");

	String userId = (String) request.getSession().getAttribute("userId");
	IMemberService memberService = MemberServiceImpl.getInstance();
	MemberVO logininfo = memberService.getMember(userId);

	PostVO postVo = new PostVO();
	postVo.setHompiId(hompiId);
	List<PostVO> photolist = (List<PostVO>) request.getAttribute("photolist");
	// List<PostVO> photolist = postService.getSearchPhoto(postVo);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>게시글 목록</title>

	<!-- Bootstrap core CSS -->
	<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	
	<!-- Custom styles for this template -->
	<link href="css/business-frontpage.css" rel="stylesheet">
	
	<!-- favicon -->
	<link rel="icon" type="image/png" sizes="32x32" href="/DEworld/image/DEWorld-favicion.png" />
	
	<!-- js -->
	<script src="/DEworld/js/jquery-3.6.0.js"></script>
	<script src="/DEworld/js/mainPage/mainPage.js"></script>
	
	<!-- 공지사항  -->
	<link rel="stylesheet" href="css/notice/topic_notice.css">
	<script type="text/javascript" src="/DEworld/js/mainPage/main_Notice.js"></script>
	
	<!-- bootstrap -->
	<link
		href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
		rel="stylesheet" id="bootstrap-css">
	<script
		src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
	<script
		src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<link rel="stylesheet"
		href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
		integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
		crossorigin="anonymous">
	<link rel="stylesheet"
		href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
		integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU"
		crossorigin="anonymous">
		
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
<!--
	function comment_ok() {
		var text = document.poto.commenti.value;
		if (text != "") {
			text = text + '\n\n\n' + '댓글이 추가되었습니다. ^_^';
			alert(text);

		} else {
			alert('댓글을 입력해 주세요 ^^');
		}
	}
//-->
</script>
</head>
<body>
	<div class="container" id="mainContents">
		<div id="sections">
			<div class="nav nav-pills">

				<%
					int size = photolist.size();
					if (size > 0) {
						int cnt = 0;
						String PostChkId = "PostCheckbox" + cnt;
						for (int i = 0; i < size; i++) {
				%>
				<div class="col-md-4 mb-5">
					<div class="card h-100">
						<input class="PostChk PostChkArr"
							id="<%=photolist.get(i).getPostNo()%>chkbox"
							style="display: none;" type="checkbox" name="PostCheckbox">
<!-- 						<a -->
<%-- 							href="select.do?postNo=<%=photolist.get(i).getPostNo()%>&flag=pho"><%=photolist.get(i).getAtchFileId()%></a> --%>
							<a href="select.do?postNo=<%=photolist.get(i).getPostNo()%>&flag=pho">
								<img class="card-img-top"
								src="/DEworld/atchFile/<%=photolist.get(i).getStreFileNm()%>.<%=photolist.get(0).getFileExtsn()%>"
								alt="" width="100px">
							</a>
						<div class="card-body">
							<p class="card-text"><%=photolist.get(i).getPostContent()%></p>
						</div>
					</div>
				</div>
				<%
					cnt++;
							if (cnt == 3) {
				%>
			</div>
		</div>
	</div>
	<%
		}
			}
	%>
	<!-- 페이징 처리 시작 -->
	<%
		if (pagingVO.getTotalCount() > 0) {
	%>
	<div>
		<div colspan="4" align="center">
			<%
				if (pagingVO.getFirstPageNo() > pagingVO.getPageSize()) {
			%>
			<a
				href="list.do?pageNo=<%=pagingVO.getFirstPageNo() - pagingVO.getPageSize()%>">[이전]</a>
			<%
				}
			%>
			<%
				for (int pNo = pagingVO.getFirstPageNo(); pNo <= pagingVO.getLastPageNo(); pNo++) {
			%>
			<a <%if (pNo == pagingVO.getCurrentPageNo()) {%>
				style="color: orange;" <%}%> href="list.do?flag=pho&pageNo=<%=pNo%>">[<%=pNo%>]
			</a>
			<%
				}
			%>
			<%
				if (pagingVO.getLastPageNo() < pagingVO.getTotalPageCount()) {
			%>
			<a
				href="list.do?flag=pho&pageNo=<%=pagingVO.getFirstPageNo() + pagingVO.getPageSize()%>">[다음]</a>
			<%
				}
			%>
		</div>
	</div>
	<%
		}
	%>
	<!-- 페이징 처리 끝 -->
	<%
		} else {
	%>
	<div>
		<div colspan="5">게시글이 존재하지 않습니다.</div>
		<%
			}
		%>
	</div>

	<%
		if ((userId.trim()).equals("cdwcdw34")) {
	%>
	<a href="insert.do?flag=pho"><button type="button">등록</button></a>
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
	<%
		if ((userId.trim()).equals("cdwcdw34")) {
	%>
	<button type="button" onclick="toggleChk()">선택</button>
	<a href="list.do"><button type="button" onclick="remove()">삭제</button></a>
	<%
		}
	%>

</body>

<script type="text/javascript">
	function checkAll() {
		if ($("[name=PostCheckboxAll]").prop("checked")) {
			$("[name=PostCheckbox]").prop("checked", true);
		} else {
			$("[name=PostCheckbox]").prop("checked", false);
		}
	}

	function toggleChk() {
		$(".PostChk").toggle();
	}

	function update() {
		inputparam = $("#inputstr").val();
		updateparam = $("#updatestr").val();
		var param = {
			'postNo' : inputparam,
			'postTitle' : updateparam
		};
		$.ajax({
			url : "/DEworld/post/update.do",
			type : "post",
			data : param
			// 		,dataType : "json"
			,
			success : function(data) {
				console.log(data)
				alert("성공");
			},
			error : function(xhr) {
				console.error(xhr);
			}

		});
	}

	function chkdel() {
		var cnt = 0;
		var postChkId = "";
		var chkboxes = $(".PostChkArr");
		var length = $(".PostChkArr").length;
		var flag = "f";
		$.each(chkboxes, function(idx, item) {
			if ($(item).prop("checked") == true) {
				flag = "t";
			}
		});
		if (flag != "t") {
			return false;
		} else
			return true;

	}

	function reload() {
		$.ajax({
			url : "/DEworld/post/list.do"
			// 		,dataType : "json"
			,
			success : function(data) {
				console.log(data)
			},
			error : function(xhr) {
				console.error(xhr);
			}
		});
	}

	function remove() {

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
				remove2(id);
			}
		});
	}

	function remove2(str) {

		inputparam = $("#inputstr").val();
		var param = {
			'postNo' : str
		};
		$.ajax({
			url : "/DEworld/post/delete.do",
			type : "post",
			data : param
			// 		,dataType : "json"
			,
			success : function(data) {
				console.log(data);
			},
			error : function(xhr) {
				console.error(xhr);
			}
		});
	}

	function create() {
		inputparam = $("#inputstr").val();
		var param = {
			'postNo' : inputparam,
			'postTitle' : inputparam2
		};
		$.ajax({
			url : "/DEworld/post/insert.do",
			type : "post",
			data : param
			// 		,dataType : "json"
			,
			success : function(data) {
				console.log(data)
				alert("성공");
			},
			error : function(xhr) {
				console.error(xhr);
			}

		});
	}
	function search() {

		var flag = $("#selectstr").val();
		var inputparam = $("#inputstr").val();

		if ("1" == flag) {
			var URI = "http://localhost/DEworld/post/search.do?postTitle="
					+ inputparam;
			window.location.href = URI;
		} else if ("2" == flag) {
			var URI = "http://localhost/DEworld/post/search.do?postContent="
					+ inputparam;
			window.location.href = URI;
		} else if ("3" == flag) {
			var URI = "http://localhost/DEworld/post/search.do?memId="
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