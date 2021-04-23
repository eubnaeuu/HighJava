/**
 * 
 */
$(document).ready(function(){
	newPage();
		
});
// 공지 리스트 조회
function makeTable(data){
	var str = "";
	
	for(var i=data.length-1 ; i>=0 ; i--) {
		str += "<tr>"
//			+ "<td><input type='checkbox' name='chkBx' id='chk" + data[i].noticeNo + "' value='" + data[i].noticeNo + "'>"
			+ "<td><input type='checkbox' name='noticeNoArr' id='chk" + data[i].noticeNo + "' value='" + data[i].noticeNo + "'>"
			+ "<td>" + data[i].noticeNo + "</td>"
			+ "<td>" + data[i].noticeTitle + "</td>"
			+ "<td>";
		if(data[i].adminId=="a001"){
			str +="관리자";
		}
		str += "</td>"
			+ "<td>" + data[i].noticeDate.substr(0,10) + "</td>"
			+ "</tr>";
	}
	$("#NoticeList tbody").html(str);
	

	$("input[type='checkbox']").on("click", function(){
		var BooleanChk = false;
		for(var i = 0; i < $("[name=noticeNoArr]").length; i++){
			if($("[name=noticeNoArr]").eq(i).prop("checked")){
				BooleanChk = true;
			}
		}
		
		if(BooleanChk==true){
			$("#deleteNotice").attr("disabled",false);
		}else{
			$("#deleteNotice").attr("disabled",true);
		}
		
	});
	
}
function checkAll(){
	if($("[name=NoticeChkBx]").prop("checked")){
		$("[name=noticeNoArr]").prop("checked",true);
	}else{
		$("[name=noticeNoArr]").prop("checked",false);
	}
}
function deleteNotice(){
//	var strNoticeNoArr = "";
//	for (var i = 0; i < $("[name=chkBx]").length; i++) {
//		if($("[name=chkBx]").eq(i).prop("checked")){
//			if(strNoticeNoArr.length > 0) {
//				strNoticeNoArr += ",";
//			}
//			strNoticeNoArr += $("[name=chkBx]").eq(i).val();
//		}
//	}
//	
//	var param = {
//		noticeNoArr : strNoticeNoArr
//		,flag : "D"
//	};
	
	$("#flag").val("D");
	
	$.ajax({
		url : "/DEworld/NoticeServlet"
		,type : "post"
//		,data : param
		,data : $("#fm").serialize()
		,dataType : "json"
		,success : function(data){
			if(data.resultCnt==1){
				alert("데이터가 삭제되었습니다.");
			}
			newPage();
		}
	,error : function(request,status, error){
		alert("code:" + request.status+ "\n\r" 
		+ "message: " + request.responseText +"\n\r"
		+ "error : " + error);
		}
	});
}
function newPage(){
	var param = {
			 flag : "L"
			};
	
	$.ajax({
		url : "/DEworld/NoticeServlet"
		,type : "post"
		,data : param
		,dataType : "json"
		,success : function(data){
			makeTable(data);
			
		}
	,error : function(request,status, error){
		alert("code:" + request.status+ "\n\r" 
		+ "message: " + request.responseText +"\n\r"
		+ "error : " + error);
		}
	});
}
function insertNewNotice(){
	window.location.href = "http://localhost/DEworld/html/notice/noticeNew.html";
}