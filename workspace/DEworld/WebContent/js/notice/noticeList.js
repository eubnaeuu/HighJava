/**
 * 
 */
$(document).ready(function(){
	newPage();
	
	var user = sessionStorage.getItem("nowLogin");
	
	if(user == null){
		alert("세션ID 정보가 존재하지 않습니다.\n로그인 페이지로 이동합니다.");
		window.location.href = "http://localhost/DEworld/html/loginpage/login.html";
	}
	
	var memId = sessionStorage.getItem("nowLogin");

	$.ajax({
		url : "/DEworld/MemberServlet"
		,type : "post"
		,data : {"memId" : memId, "flag" : "setMyPage"}
		,dataType : "json"
		,success : function(data){
			var memName = data[0].memName;
			var memMail = data[0].memMail;
			var memNickname = data[0].memNickname;
			
			$("#memName").html(memName);
			$("#memMail").html(memMail);
			$("#idArea").html(memNickname);
		}
		,error : function(xhr){
			alert("알수없는 오류");
		}
	});
	
	
});
// 공지 리스트 조회
function makeTable(data){
	var str = "";
	
	for(var i=0 ; i<data.length ; i++) {
		str += "<tr>"
			+ "<td><input type='checkbox' name='noticeNoArr' id='chk" + data[i].noticeNo + "' value='" + data[i].noticeNo + "'>"
			+ "<td>" + data[i].noticeNo + "</td>"
			+ "<td class='noticeTitle'><a href='http://localhost/DEworld/html/notice/noticeShow.html?noticeTitle="+data[i].noticeNo+"'>" + data[i].noticeTitle + "</a></td>"
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