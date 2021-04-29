$(document).ready(function(){
	readWhishlistList();
	readMusicWhishlistList();
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
				+  '<td>' + data[i].itemPrice + '땅콩</td>'
				+ 	'</tr>';
	}
	
	$("#whishlistListTable tbody").html(strHtml);
}

function readMusicWhishlistList(){ // 음악 위시리스트 불러오기
	var param = {
		flag : "ML",
		memId : memId
	};
	$.ajax({
		url : "/DEworld/whishlist/whishlistList.do"
		,type : "post"
		,data : param
		,dataType : "json"
		,success : function(data){
			console.log(data);
			makeMusicWhishlistList(data);
		}
	,error : function(request,status, error){
		alert("code:" + request.status+ "\n\r" 
		+ "message: " + request.responseText +"\n\r"
		+ "error : " + error);
		}
	});
	
}


function makeMusicWhishlistList(data){
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
	
	$("#musicListTable tbody").html(strHtml);
}

