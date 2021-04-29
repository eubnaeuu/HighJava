$(document).ready(function(){
	readBuyList();
	readMusicBuyList();
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

function readMusicBuyList(){ // 음악 구매 불러오기
	var param = {
		flag : "ML",
		memId : memId
	};
	$.ajax({
		url : "/DEworld/buy/buyList.do"
		,type : "post"
		,data : param
		,dataType : "json"
		,success : function(data){
			console.log(data);
			makeMusicBuyList(data);
		}
	,error : function(request,status, error){
		alert("code:" + request.status+ "\n\r" 
		+ "message: " + request.responseText +"\n\r"
		+ "error : " + error);
		}
	});
	
}


function makeMusicBuyList(data){
	var strHtml = "";
	for(var i=0 ; i<data.length ; i++) {
		strHtml += '<tr>'
				+  '<td><img src="/DEworld/image/musicAlbumImage/' + data[i].musicAlbum + '" style="width:50px; height:50px;"></td>'
				+  '<td>' + data[i].musicTitle + '</td>'
				+  '<td>' + data[i].musicArtist + '</td>'
				+  '<td>' + data[i].musicTime + '</td>'
				+  '<td>' + data[i].lmusicGenre + '</td>'
				+  '<td>' + data[i].musicCost + '땅콩</td>'
				+ 	'</tr>';
	}
	
	$("#musicBuyListTable tbody").html(strHtml);
}