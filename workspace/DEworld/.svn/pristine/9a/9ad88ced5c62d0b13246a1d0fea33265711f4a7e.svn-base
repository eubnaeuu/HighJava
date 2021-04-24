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
function makeTable(data) {
	data[0].noticeContent = data[0].noticeContent.replace(/(<br>|<br\/>|<br \/>)/g, '\r\n');
	$("#noticeTitle").val(data[0].noticeTitle);
	$("#noticeContent").html(data[0].noticeContent);
}
///////////////////////////////////////////////////////////
function resize(obj) {
	obj.style.height = "5px";
	 obj.style.height = (6+obj.scrollHeight)+"px";
}

function returnNotice(){
	var strLocation ="http://localhost/DEworld/html/notice/noticeShow.html";
	strLocation +=location.search;
	window.location.href = strLocation;
}

function submitNotice(){
	var noticeTitleVal = $("#noticeTitle").val();
	var noticeContentVal = $("#noticeContent").val();
	var noticeNo = location.search.replace("?noticeTitle=", "");
	if(noticeTitleVal==null||noticeTitleVal==""){
		$("#noticeTitle").val("데이터가 없습니다.");
	}
	
	if(noticeContentVal==null||noticeContentVal==""){
		$("#noticeContent").val("데이터가 없습니다.");
	}
	
	
	noticeTitleVal = $("#noticeTitle").val();
	noticeContentVal = $("#noticeContent").val();
	//엔터관련 인코딩
	noticeContentVal = noticeContentVal.replace(/(?:\r\n|\r|\n)/g, '<br />');
	var param = {
			noticeNo : noticeNo
			,adminId : "a001" 
			,noticeContent : noticeContentVal
			,noticeTitle : noticeTitleVal
			,flag : "U"
		};
	console.log(param);
		$.ajax({
			url : "/DEworld/NoticeServlet"
			,type : "post"
			,data : param
			,dataType : "json"
			,success : function(data){
				if(data.resultCnt==1){
					alert("데이터가 수정되었습니다.");
					returnNotice();
				}
			}
		,error : function(request,status, error){
			alert("code:" + request.status+ "\n\r" 
			+ "message: " + request.responseText +"\n\r"
			+ "error : " + error);
			}
		});
}