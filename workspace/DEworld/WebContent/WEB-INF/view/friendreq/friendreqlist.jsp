<%@page import="kr.or.ddit.friendreq.vo.FriendReqVO"%>
<%@page import="kr.or.ddit.member.service.MemberServiceImpl"%>
<%@page import="kr.or.ddit.member.service.IMemberService"%>
<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@page import="kr.or.ddit.comments.vo.CommentsVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	// String strJson = (String)request.getAttribute("strJson");

	List<FriendReqVO> friendreqlist = (List<FriendReqVO>) request.getAttribute("friendreqlist");
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

<title>일촌신청</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<h1>일촌신청</h1>
	<table border='2px solid' id="friendreqlisttable">
		<thead>
			<tr>
				<th><input class="FriendreqChk" id="FriendreqCheckboxAll"
					style="display: none;" type="checkbox" name="FriendreqCheckboxAll"
					onclick="checkAll();"></th>
				<th>구 분</th>
				<th>FROM</th>
				<th>TO</th>
				<th>일자</th>
				<th>상태</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<%
				int size = friendreqlist.size();
				if (size > 0) {
					int cnt = 1;
					String FriendreqChkId = "FriendreqCheckbox" + cnt;
					for (int i = 0; i < size; i++) {
			%>
			<tr>
				<td><input class="FriendreqChk FriendreqChkArr"
					id="<%=cnt%>chkbox" style="display: none;" type="checkbox"
					name="FriendreqCheckbox"></td>
				<td><%=cnt%></td>
				<td id="<%=cnt%>memId"><%=friendreqlist.get(i).getMemId()%></td>
				<td id="<%=cnt%>friendId"><%=friendreqlist.get(i).getFriendId()%></td>
				<td><%=friendreqlist.get(i).getReqDate()%></td>
				<td>
					<%
						String friendId = (friendreqlist.get(i).getFriendId()).trim();				
						if ((userId).equals(friendId)) {
					%>
					<a href="야" onclick="confirmFriendreq()"><%=friendreqlist.get(i).getReqYn()%></a>
					<%
						} else {
					%>
					<%=friendreqlist.get(i).getReqYn()%> 
					<%
						}
					%>
				</td>
				<td>
				<a href="/DEworld/friend/insert.do?friendId=<%=friendreqlist.get(i).getMemId() %>"><button>수락</button></a>
				<a href="/delete.do?friendId=<%=friendId%>"><button>거절</button></a>
				</td>
			</tr>
			<%
				cnt++;
					}
			%>

			<%
				} else {
			%>
			<tr>
				<td colspan="5">신청목록이 존재하지 않습니다.</td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
	<a href="insert.do"><button type="button">등록</button></a>
	<select id="selectstr">
		<option value="1">FROM</option>
		<option value="2">TO</option>
		<option value="3">상태</option>
	</select>
	<input type="text" id="inputstr">
	<button type="button" onclick="search()">검색</button>
	<button type="button" onclick="toggleChk()">선택</button>
	<a href="list.do"><button type="button" onclick="remove()">삭제</button></a>
</body>
<script type="text/javascript">
	function checkAll() {
		if ($("[name=FriendreqCheckboxAll]").prop("checked")) {
			$("[name=FriendreqCheckbox]").prop("checked", true);
		} else {
			$("[name=FriendreqCheckbox]").prop("checked", false);
		}
	}

	function toggleChk() {
		$(".FriendreqChk").toggle();
	}

	function update() {
		inputparam = $("#inputstr").val();
		updateparam = $("#updatestr").val();
		var param = {
			'No' : inputparam,
			'Title' : updateparam
		};
		$.ajax({
			url : "/DEworld/friendreq/update.do",
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
		var friendreqChkId = "";
		var chkboxes = $(".FriendreqChkArr");
		var length = $(".FriendreqChkArr").length;
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
			url : "/DEworld/friendreq/list.do"
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
		var chkboxes = $(".FriendreqChkArr");
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

		var memId = $("#" + str + "memId").text();
		var friendId = $("#" + str + "friendId").text();
		var param = {
			'memId' : memId,
			'friendId' : friendId
		};
		$.ajax({
			url : "/DEworld/friendreq/delete.do",
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

	function create() {
		inputparam = $("#inputstr").val();
		var param = {
			'friendreqNo' : inputparam,
			'friendreqTitle' : inputparam2
		};
		$.ajax({
			url : "/DEworld/friendreq/insert.do",
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

	function confirmFriendreq() {
		confirm("일촌 신청을 받으시겠습니까?");
	}

	function search() {

		var flag = $("#selectstr").val();
		var inputparam = $("#inputstr").val();

		if ("1" == flag) {
			var URI = "http://localhost/DEworld/friendreq/search.do?memId="
					+ inputparam;
			window.location.href = URI;
		} else if ("2" == flag) {
			var URI = "http://localhost/DEworld/friendreq/search.do?friendId="
					+ inputparam;
			window.location.href = URI;
		} else if ("3" == flag) {
			var URI = "http://localhost/DEworld/friendreq/search.do?reqYn="
					+ inputparam;
			window.location.href = URI;
		}
	}

	function chkmsg() {
		return confirm("정말 삭제하시겠습니까?");
	}

	function select() {
		$.ajax({
			url : "/DEworld/friendreq/list.do",
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