/**
 * 
 */

function resize(obj) {
	obj.style.height = "5px";
	 obj.style.height = (6+obj.scrollHeight)+"px";
}

function returnNotice(){
	window.location.href = "http://localhost/DEworld/html/notice/noticeList.html";
}

function submitNotice(){
	var noticeTitleVal = $("#noticeTitle").val();
	var noticeContentVal = $("#noticeContent").val();
	
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
	console.log(noticeContentVal);
	var param = {
			adminId : "a001" 
			,noticeContent : noticeContentVal
			,noticeTitle : noticeTitleVal
			,flag : "C"
		};
			
		$.ajax({
			url : "/DEworld/NoticeServlet"
			,type : "post"
			,data : param
			,dataType : "json"
			,success : function(data){
				if(data.resultCnt==1){
					alert("데이터가 생성되었습니다.");
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