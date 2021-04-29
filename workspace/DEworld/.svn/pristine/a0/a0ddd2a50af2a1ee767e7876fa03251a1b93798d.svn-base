$(document).ready(function(){
	readMusicList();
});
var memId = sessionStorage.getItem("Nickname");
console.log(memId)
var count = 0;
var m = true;
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
				+  '<td><img src="/DEworld/image/musicAlbumImage/' + data[i].musicAlbum + '" style="width:50px; height:50px;"></td>'
				+  '<td>' + data[i].musicTitle + '</td>'
				+  '<td>' + data[i].musicArtist + '</td>'
				+  '<td>' + data[i].musicTime + '</td>'
				+  '<td>' + data[i].lmusicGenre + '</td>'
				+  '<td>' + data[i].musicCost + '땅콩</td>'
				+  '<td><button type="button" class="itemBtn btn btn-primary" onclick="addWishList(\'' + data[i].musicId + '\')">위시리스트에 담기</button></td>'
				+  '<td><button type="button" class="itemBtn btn btn-primary" onclick="buyMusic(\'' + data[i].musicCost + '\',\''+ data[i].musicId+'\')">구매하기</button></td>'
				+  '<td><button type="button" class="itemBtn btn btn-primary" '
				+  'onclick="GiftBoxCreate(\'' + data[i].musicId + '\',\'' + data[i].musicTitle + '\',\'' + data[i].musicCost + '\',\'' + data[i].musicAlbum + '\')">선물하기</button></td>'
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
	var param = {
		flag : "C",
		memId : memId,
		musicId : musicId,
		litemGu : "03"
	};
	$.ajax({
		url : "/DEworld/music/musicList.do"
		,type : "post"
		,data : param
		,dataType : "json"
		,success : function(data){
			
			if(data.resultCnt == 0){
				alert("이미 위시리스트에 존재하는 상품입니다.");
			}else{
				alert("위시리스트에 추가되었습니다.");
			}
		}
		,error : function(xhr){
			alert("실패하였습니다.\n관리자에게 문의하세요.");
			console.log(xhr);
		}
	});
}

function money(musicCost){ // 보유 금액 확인
	$.ajax({
		url : "/DEworld/MemberServlet",
		type : "post",
		data : {"memId" : memId, "flag" : "setMyPage"},
		dataType : "json",
		async: false,
		success : function(data) {
			var memCybermoney = data[0].memCybermoney;
			var result = memCybermoney - musicCost;
			if(result < 0){
				alert("보유한 땅콩이 부족합니다!");
				m = false;
			}else{
				m = true;
			}
		},
		error : function(xhr) {
			alert("알수없는 에러");
		}
	});
	
}

function buyMusic(musicCost, musicId){
	var result = confirm("구매하시겠습니까? " + musicCost + "땅콩이 차감됩니다.");
	if(result != true){
		return;
	}
	money(musicCost);
	if(m == false){ // 머니가 부족하면
		return;
	}else{
		var param = {
			flag : "BUY",
			memId : memId,
			musicId : musicId
		};
		
		$.ajax({
			url : "/DEworld/music/musicList.do"
			,type : "post"
			,data : param
			,dataType : "json"
			,success : function(data){
				console.log(data);
				if(data.resultCnt == 0){
					alert("이미 보유한 상품입니다.");
				}else{
					alert("상품을 구매하셨습니다.");	
				}
			}
			,error : function(xhr){
				alert("실패하였습니다.\n관리자에게 문의하세요.");
				console.log(xhr);
			}
		});
	}
	
}

function GiftBoxCreate(musicId, musicName, musicCost, musicImg){

	document.getElementById("giftItemName").innerHTML +=  '[' + musicName +']';
	document.getElementById("giftItemImg").src = '/DEworld/image/musicAlbumImage/' + musicImg;
	document.getElementById("musicCostV").innerHTML = musicCost;
	
	var strHtml = '';
	strHtml += '<button type="button" class="btn btn-default" onclick="sendGift(\''+ musicId +'\',\'' + musicCost + '\')">선물하기</button>'
			+  '<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>';
	$(".modal-footer").html(strHtml);
	
	showGiftBox(musicId);
}

function showGiftBox(musicId){
	$("#giftModal").modal();
	
	var param = {
		flag : "GF",
		memId : memId
	};
	
	$.ajax({
		url : "/DEworld/music/musicList.do"
		,type : "post"
		,data : param
		,dataType : "json"
		,success : function(data){
			console.log(data);
			setFriendList(data);
		}
		,error : function(request,status, error){
		alert("code:" + request.status+ "\n\r" 
		+ "message: " + request.responseText +"\n\r"
		+ "error : " + error);
		}
	});
}

function setFriendList(data){
	if(count != 0){
		return;
	}else{
		var strHtml = '<option value="">선택하세요</option>';
		for(var i=0 ; i<data.length; i++){
			strHtml += '<option value="' + data[i].friendId +'">' + data[i].friendNickname + '</option>';
		}
		$("#friendList").html(strHtml);
		count++;
	}
}


function sendGift(musicId, musicCost){
	var result = confirm("선물하시겠습니까? " + musicCost + " 땅콩이 차감됩니다.");
	if(result != true){
		return;
	}
	 
	money(musicCost); 
	if(m == false){ // 머니가 부족하면
		return;
	}else{
		var friendList = document.getElementById("friendList");
		var friendId = friendList.options[friendList.selectedIndex].value;
		var giftMessage = document.getElementById("giftMessage").value;
		
		var param = {
			flag : "SENDGF",
			musicId : musicId,
			friendId : friendId,
			giftMessage : giftMessage,
			memId : memId,
			litemGu : "03"
		};
		
		$.ajax({
			url : "/DEworld/music/musicList.do"
			,type : "post"
			,data : param
			,dataType : "json"
			,success : function(data){
				console.log(data);
				alert("선물을 전송했습니다!");
				friendList.selectedIndex = 0;
				giftMessage = '';
			}
			,error : function(xhr){
				alert("실패하였습니다.\n관리자에게 문의하세요.");
				console.log(xhr);
			}
		});
	}
	
}