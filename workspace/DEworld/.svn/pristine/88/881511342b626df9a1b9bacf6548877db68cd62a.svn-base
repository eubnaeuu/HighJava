/**
 * 
 */
$(document).ready(function() {
	viewPage();
});

function viewPage() {
	var noticeNo = location.search.replace("?noticeTitle=", "");
	var param = {
		noticeNo : noticeNo,
		flag : "R"
	}
	$.ajax({
		url : "/DEworld/NoticeServlet",
		type : "post",
		data : param,
		dataType : "json",
		success : function(data) {
			makeTable(data);
		},
		error : function(request, status, error) {
			alert("code:" + request.status + "\n\r" + "message: "
					+ request.responseText + "\n\r" + "error : " + error);
		}
	});
}

function resize(obj) {
	obj.style.height = "5px";
	 obj.style.height = (6+obj.scrollHeight)+"px";
}

function makeTable(data) {
	if (data[0].adminId == "a001") {
		data[0].adminId = "관리자";
	}
	data[0].noticeDate = data[0].noticeDate.replace("-", ".");
	data[0].noticeDate = data[0].noticeDate.replace("-", ".");
	
	$("#ShowNoticeTitle").html(data[0].noticeTitle);
	$("#ShowNoticeAdminId").html(data[0].adminId);
	$("#ShowNoticeDate").html(data[0].noticeDate);
	$("#ShowNoticeContent").html(data[0].noticeContent);
	
	var userAuth = sessionStorage.getItem("nowLogin");

	if(userAuth == "user"){
	$("#updateNotice").hide();
	$("#deleteNotice").hide();

	}
}

function updateNotice(){
	var strLocation ="http://localhost/DEworld/html/notice/noticeUpdate.html";
	strLocation +=location.search;
	window.location.href = strLocation;
}


function deleteNotice(){
	var noticeNo = location.search.replace("?noticeTitle=", "");
	var param = {
		noticeNo : noticeNo
		,flag : "D1"
	}
	$.ajax({
		url : "/DEworld/NoticeServlet",
		type : "post",
		data : param,
		dataType : "json",
		success : function(data) {
			goNoticeList();
		},
		error : function(request, status, error) {
			alert("code:" + request.status + "\n\r" + "message: "
					+ request.responseText + "\n\r" + "error : " + error);
		}
	});
}


function goNoticeList(){
	window.location.href = "http://localhost/DEworld/html/notice/noticeList.html";
}


function goback(){
	goNoticeList();
}


