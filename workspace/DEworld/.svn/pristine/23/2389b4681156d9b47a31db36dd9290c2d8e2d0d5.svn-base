$(document).ready(function(){
	readMusicList();
});

function readMusicList(){
	var param = {
		flag : "L"
	};
	$.ajax({
		url : "/DEworld/music/musicList.do"
		,type : "post"
		,data : param
		,dataType : "json"
		,success : function(data){
			console.log(data);
			makeMusicList(data);
		}
	,error : function(request,status, error){
		alert("code:" + request.status+ "\n\r" 
		+ "message: " + request.responseText +"\n\r"
		+ "error : " + error);
		}
	});
	
}


function makeMusicList(data){
//	$("#musicListTable tbody").empty();
	
	var strHtml = "";
	for(var i=0 ; i<data.length ; i++) {
		strHtml += '<tr>'
				+  '<td>' + data[i].musicTitle + '</td>'
				+  '<td>' + data[i].musicArtist + '</td>'
				+  '<td>' + data[i].musicTime + '</td>'
				+  '<td>' + data[i].lmusicGenre + '</td>'
				+  '<td>' + data[i].musicCost + '땅콩</td>'
				+  '<td><button type="button" class="itemBtn btn btn-primary" onclick="addWishList(' + data[i].musicId + ')">위시리스트에 담기</button></td>'
				+  '<td><button type="button" class="itemBtn btn btn-primary" onclick="buyItem()">구매하기</button></td>'
				+  '<td><button type="button" class="itemBtn btn btn-primary" onclick="showGiftBox(' + data[i].musicId + ')">선물하기</button></td>'
				+ 	'</tr>';
	}
	
	$("#musicListTable tbody").html(strHtml);
}

function searchMusic(){
	var searchMusicName = document.getElementById("searchMusicName").value;
	var param = {
		flag : "S",
		searchMusicName : searchMusicName
	};
	$.ajax({
		url : "/DEworld/music/musicList.do"
		,type : "post"
		,data : param
		,dataType : "json"
		,success : function(data){
			makeMusicList(data);
		}
		,error : function(xhr){
			alert("실패하였습니다.\n관리자에게 문의하세요.");
			console.log(xhr);
		}
	});
}


function addWishList(musicId){
	// 위시리스트 추가

}

function money(){ // 보유 금액 확인

	
}

function buyItem(){

}

function showGiftBox(itemId){

}

function setFriendList(data){

	
}


function sendGift(){
	
}