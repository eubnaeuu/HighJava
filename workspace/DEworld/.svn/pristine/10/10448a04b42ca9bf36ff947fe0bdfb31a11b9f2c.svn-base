$(document).ready(function(){
	readGiftboxList();
});
var memId = sessionStorage.getItem("Nickname");

function readGiftboxList(){
	var param = {
		flag : "L"
	};
	$.ajax({
		url : "/DEworld/giftbox/giftboxList.do"
		,type : "post"
		,data : param
		,dataType : "json"
		,success : function(data){
			console.log(data);
			makeGiftboxList(data);
		}
	,error : function(request,status, error){
		alert("code:" + request.status+ "\n\r" 
		+ "message: " + request.responseText +"\n\r"
		+ "error : " + error);
		}
	});
	
}


function makeGiftboxList(data){
//	$("#giftboxListTable tbody").empty();
	
	var strHtml = "";
	for(var i=0 ; i<data.length ; i++) {
		strHtml += '<tr>'
				
				+  '<td>' + data[i].sendId + '</td>'
				+  '<td>' + data[i].giftMessage + '</td>'
				+  '<td>' + data[i].litemGu + '</td>'
				+  '<td><img src="/DEworld/image/item/' + data[i].itemImg + '" style="width:50px; height:50px;"></td>'
				+  '<td>' + data[i].itemName + '</td>'
				+  '<td>' + data[i].sendDate + '</td>'
				
				+ 	'</tr>';
	}
	
	$("#giftboxListTable tbody").html(strHtml);
}

