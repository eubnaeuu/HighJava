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
			+ "<td><input type='checkbox' name='ChkBx' id='" 
			+ data[i].noticeNo + "'>"
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

}
function checkAll(){
	if($("[name=NoticeChkBx]").prop("checked")){
		$("[name=ChkBx]").prop("checked",true);
	}else{
		$("[name=ChkBx]").prop("checked",false);
	}
}
function deleteNotice(){
	var strNoticeNoArr = "";
	for (var i = 0; i < $("[name=ChkBx]").length; i++) {
		if($("[name=ChkBx]").eq(i).prop("checked")){
			if(strNoticeNoArr.length > 0) {
				strNoticeNoArr += ",";
			}
			strNoticeNoArr += $("[name=ChkBx]").eq(i).attr("id");
		}
	}
	
	var param = {
		noticeNoArr : strNoticeNoArr
		,flag : "D"
	};
		
	$.ajax({
		url : "/DEworld/NoticeServlet"
		,type : "post"
		,data : param
		,dataType : "json"
		,success : function(data){
			if(data.resultCnt==1){
				alert("데이터가 삭제되었습니다.");
			}else{
				alert("이게 원래 구조적으로 삭제할 수 없는데 왜 삭제가 된건지 모르겠네?");
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
