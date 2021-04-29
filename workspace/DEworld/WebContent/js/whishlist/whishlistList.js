$(document).ready(function(){
	readWhishlistList();
});
var memId = sessionStorage.getItem("Nickname");

function readWhishlistList(){
	var param = {
		flag : "L",
		memId : memId
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


function makeWhishlistList(data){
//	$("#whishlistListTable tbody").empty();
	
	var strHtml = "";
	for(var i=0 ; i<data.length ; i++) {
		strHtml += '<tr>'
				+  '<td>' + data[i].litemGu + '</td>'
				+  '<td><img src="/DEworld/image/item/' + data[i].itemImg + '" style="width:auto; height:50px;"></td>'
				+  '<td>' + data[i].itemName + '</td>'
				+  '<td>' + data[i].itemPrice + '</td>'
				+ 	'</tr>';
	}
	
	$("#whishlistListTable tbody").html(strHtml);
}

