/**
 * 
 */
$(document).ready(function(){
		var param = {
				 flag : "L"
				};
		
		$.ajax({
			url : "/DEworld/NoticeServlet"
			,type : "post"
			,data : param
			,dataType : "json"
			,success : function(data){
				console.log(data);
				makeTable(data);
				
			}
		,error : function(request,status, error){
			alert("code:" + request.status+ "\n\r" 
			+ "message: " + request.responseText +"\n\r"
			+ "error : " + error);
			}
		});
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
	
}





function goMemberNew() {
	// 페이지이동1
// 	window.location.href = "/JqueryPro/html/member/memberNew.jsp";
	
 	// 페이지이동2
//	var fm = document.getElementById("tmpFm");
//	fm.method = "post";
//	fm.action = "/JqueryPro/html/member/memberNew.jsp";
//	fm.submit();
 	
	// 페이지이동3
//	$("#targetUrl").val("/html/member/memberNew.jsp");
//	var fm = document.getElementById("tmpFm");
//	fm.method = "post";
//	fm.action = "/JqueryPro/PageServlet";
//	fm.submit();
	
	// 팝업
	window.open("/MemberPj/html/member/memberNew.jsp");
}