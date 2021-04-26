/**
 * 
 */
$(document).ready(function(){
	newPage();
		
});
// 공지 리스트 조회
function makeTable(data){
	var str = "";
	if(data.length >=5){
		for(var i=0 ; i<=4 ; i++) {
			str += "<tr>"
				+ "<td>" + data[i].noticeNo + "</td>"
				+ "<td class='noticeTitle'><a href='http://localhost/DEworld/html/notice/noticeShow.html?noticeTitle="+data[i].noticeNo+"'>"; 
			if(data[i].noticeTitle.length >15){
				data[i].noticeTitle = data[i].noticeTitle.substr(0,12) + "...";
			}		
			
			str	+= data[i].noticeTitle + "</a></td>"
			+ "<td>";
			if(data[i].adminId=="a001"){
				str +="관리자";
			}
			str += "</td>"
				+ "<td>" + data[i].noticeDate.substr(0,10) + "</td>"
				+ "</tr>";
		}
		
	}else if(data.length==0){
		for(var i=data.length-1 ; i>=0 ; i--) 
			str += "<tr>"
				+ "<td>" + "데이터가없습니다"+ "</td>";	
				+ "</tr>";
	}
	
	else{
		for(var i=0 ; i<data.length ; i++) {
			str += "<tr>"
				+ "<td>" + data[i].noticeNo + "</td>"
				+ "<td class='noticeTitle'><a href='http://localhost/DEworld/html/notice/noticeShow.html?noticeTitle="+data[i].noticeNo+"'>"; 
			if(data[i].noticeTitle.length >15){
				data[i].noticeTitle = data[i].noticeTitle.substr(0,12) + "...";
			}		
			
			str	+= data[i].noticeTitle + "</a></td>"
			+ "<td>";
			if(data[i].adminId=="a001"){
				str +="관리자";
			}
			str += "</td>"
				+ "<td>" + data[i].noticeDate.substr(0,10) + "</td>"
				+ "</tr>";
		}

	}
	$("#NoticeList tbody").html(str);
	
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


