<%@page import="kr.or.ddit.friend.vo.FriendVO"%>
<%@page import="kr.or.ddit.member.service.MemberServiceImpl"%>
<%@page import="kr.or.ddit.member.service.IMemberService"%>
<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@page import="kr.or.ddit.comments.vo.CommentsVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	// String strJson = (String)request.getAttribute("strJson");

	List<FriendVO> friendlist = (List<FriendVO>) request.getAttribute("friendlist");
	
	String msg = request.getParameter("msg") == null ? "" : request.getParameter("msg");

	String userId = (String) request.getSession().getAttribute("userId");
	userId = userId.trim();
	
	IMemberService memberService = MemberServiceImpl.getInstance();
	MemberVO logininfo = memberService.getMember(userId);
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>일촌목록</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<h1>일촌목록</h1>
	<table border='2px solid' id="friendlisttable">
		<thead>
			<tr>
				<th><input class="FriendChk" id="FriendCheckboxAll"
					style="display: none;" type="checkbox" name="FriendCheckboxAll"
					onclick="checkAll();"></th>
				<th>구분</th>
				<th>친구</th>
				<th>일자</th>
			</tr>
		</thead>
		<tbody>
			<%
				int size = friendlist.size();
				if (size > 0) {
					int cnt = 1;
					String FriendChkId = "FriendCheckbox" + cnt;
					for (int i = 0; i < size; i++) {
			%>
			<tr>
				<td><input class="FriendChk FriendChkArr"
					id="<%=cnt%>chkbox" style="display: none;" type="checkbox"
					name="FriendCheckbox"></td>
				<td><%=cnt%></td>
				<td id="<%=cnt%>friendId"><%=friendlist.get(i).getFriendId()%></td>
				<td><%=friendlist.get(i).getFriendDate()%></td>
			</tr>
			<%
				cnt++;
					}
			%>

			<%
				} else {
			%>
			<tr>
				<td colspan="5">지금바로 일촌을 맺어보세요!</td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
	<a href="/DEworld/friendreq/insert.do"><button type="button">등록</button></a>
	<a href="/DEworld/friendreq/list.do"><button type="button">신청목록</button></a>
<!-- 	<select id="selectstr"> -->
<!-- 		<option value="1">FROM</option> -->
<!-- 		<option value="2">TO</option> -->
<!-- 		<option value="3">상태</option> -->
<!-- 	</select> -->
<!-- 	<input type="text" id="inputstr"> -->
<!-- 	<button type="button" onclick="search()">검색</button> -->
	<button type="button" onclick="toggleChk()">선택</button>
	<a href="list.do"><button type="button" onclick="remove()">삭제</button></a>
</body>
<script type="text/javascript">
	function checkAll() {
		if ($("[name=FriendCheckboxAll]").prop("checked")) {
			$("[name=FriendCheckbox]").prop("checked", true);
		} else {
			$("[name=FriendCheckbox]").prop("checked", false);
		}
	}

	function toggleChk() {
		$(".FriendChk").toggle();
	}

	function update() {
		inputparam = $("#inputstr").val();
		updateparam = $("#updatestr").val();
		var param = {
			'No' : inputparam,
			'Title' : updateparam
		};
		$.ajax({
			url : "/DEworld/friend/update.do",
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
		var friendChkId = "";
		var chkboxes = $(".FriendChkArr");
		var length = $(".FriendChkArr").length;
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
			url : "/DEworld/friend/list.do"
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
			alert("삭제하실 목록을 선택해주세요")
			return;
		}

		if (!chkmsg()) {
			return;
		}
		var chkboxes = $(".FriendChkArr");
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

		var friendId = $("#" + str + "friendId").text();
		var param = {
			'friendId' : friendId
		};
		$.ajax({
			url : "/DEworld/friend/delete.do",
			type : "post",
			data : param,
			success : function(data) {
				console.log(param);

			},
			error : function(xhr) {
				console.error(xhr);
			}
		});
	}

	function confirmFriend() {
		confirm("일촌 신청을 받으시겠습니까?");
	}

// 	function search() {

// 		var flag = $("#selectstr").val();
// 		var inputparam = $("#inputstr").val();

// 		if ("1" == flag) {
// 			var URI = "http://localhost/DEworld/friend/search.do?memId="
// 					+ inputparam;
// 			window.location.href = URI;
// 		} else if ("2" == flag) {
// 			var URI = "http://localhost/DEworld/friend/search.do?friendId="
// 					+ inputparam;
// 			window.location.href = URI;
// 		} else if ("3" == flag) {
// 			var URI = "http://localhost/DEworld/friend/search.do?reqYn="
// 					+ inputparam;
// 			window.location.href = URI;
// 		}
// 	}

	function chkmsg() {
		return confirm("정말 삭제하시겠습니까?");
	}

	function select() {
		$.ajax({
			url : "/DEworld/friend/list.do",
			type : "POST",
			success : function(data) {
				console.log(data)
			},
			error : function(xhr) {
				console.error(xhr);
			}
		});
	}
</script>
</html>