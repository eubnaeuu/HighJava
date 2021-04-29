$(document).ready(function(){
	readBuyList();
});
var memId = sessionStorage.getItem("Nickname");

function readBuyList(){
	var param = {
		flag : "L",
		memId : memId
	};
	$.ajax({
		url : "/DEworld/buy/buyList.do"
		,type : "post"
		,data : param
		,dataType : "json"
		,success : function(data){
			console.log(data);
			makeBuyList(data);
		}
	,error : function(request,status, error){
		alert("code:" + request.status+ "\n\r" 
		+ "message: " + request.responseText +"\n\r"
		+ "error : " + error);
		}
	});
	
}


function makeBuyList(data){
//	$("#BuyListTable tbody").empty();
	
	var strHtml = "";
	for(var i=0 ; i<data.length ; i++) {
		if(data[i].litemGu.indexOf("02") != -1){
			data[i].litemGu = "테마";
			imgSrc = '/DEworld/image/hompiBackground/';
		}else{
			data[i].litemGu = "미니미";	
			imgSrc = '/DEworld/image/item/';
		}
		strHtml += '<tr>'
				+  '<td>' + data[i].litemGu + '</td>'
				+  '<td><img src="' + imgSrc + data[i].itemImg + '" style="width:auto; height:50px;"></td>'
				+  '<td>' + data[i].itemName + '</td>'
				+  '<td>' + data[i].itemPrice + '</td>'
				+ 	'</tr>';
	}
	
	$("#BuyListTable tbody").html(strHtml);
}

