$(document).ready(function(){
	readWhishlistList();
});
var memId = sessionStorage.getItem("Nickname");

function readWhishlistList(){
	var param = {
		flag : "L"
	};
	$.ajax({
		url : "/DEworld/whishlist/whishlistList.do"
		,type : "post"
		,data : param
		,dataType : "json"
		,success : function(data){
			console.log(data);
			makeWhishlistList(data);
		}
	,error : function(request,status, error){
		alert("code:" + request.status+ "\n\r" 
		+ "message: " + request.responseText +"\n\r"
		+ "error : " + error);
		}
	});
	
}


function makewhishlistList(data){
//	$("#whishlistListTable tbody").empty();
	
	var strHtml = "";
	for(var i=0 ; i<data.length ; i++) {
		strHtml += '<tr>'
				
				+  '<td>' + data[i].litemGu + '</td>'
				+  '<td><img src="/DEworld/image/item/' + data[i].itemImg + '" style="width:50px; height:50px;"></td>'
				+  '<td>' + data[i].itemName + '</td>'
				
				+ 	'</tr>';
	}
	
	$("#whishlistListTable tbody").html(strHtml);
}

