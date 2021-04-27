$(document).ready(function(){
	readItemList();
});

function readItemList(){
	var param = {
		flag : "L"
	};
	$.ajax({
		url : "/DEworld/item/itemList.do"
		,type : "post"
		,data : param
		,dataType : "json"
		,success : function(data){
			console.log(data);
			makeItemList(data);
		}
		,error : function(xhr){
			alert("실패하였습니다.\n관리자에게 문의하세요.");
			console.log(xhr);
		}
	});
	
}

//function makeItemList(data){
//	$("ul").empty();
//	
//	var strHtml = "";
//	for(var i=0 ; i<data.length ; i++) {
//		strHtml += "<a href='/DEworld/item/itemDetail.do?flag=L&itemId=" + data[i].itemId + "'><li>"
//				+ "<img src=" + "/DEworld/image/item/" + data[i].itemImg +"><br>"
//				+ "<p>" + data[i].itemName + "</p>"
//				+ "<p>" + data[i].itemPrice + " 땅콩</p>"
//				+ "</li></a>";
//	}
//	
//	$("ul").html(strHtml);
//}

function makeItemList(data){
	
	$("#innerMinimi .nav").empty();
	$("#innerTheme .nav").empty();
	
	var strHtml = "";
	var strHtml2 = "";
	for(var i=0 ; i<data.length ; i++) {
		if(data[i].litemGu.indexOf('01') != -1){
			strHtml += '<div class="col-md-4 mb-5">'			
				+  '<div class="card h-100">'
				+  '<img class="card-img-top" src="/DEworld/image/item/' + data[i].itemImg 
				+  '" alt="" style="margin: 0 auto;    width: auto;    height: 100px;">'
				+  '<div class="card-body"><h4 class="card-title">'+ data[i].itemName 
				+  '</h4><p class="card-text">' + data[i].itemDesc + '</p></div>'
				+  '<div class="card-footer"><a href="/DEworld/item/itemDetail.do?flag=L&gu=1&itemId=' + data[i].itemId +'" class="btn btn-primary">상세페이지로 가기</a></div></div></div>';
		}else{
			strHtml2 += '<div class="col-md-4 mb-5">'			
				+  '<div class="card h-100">'
				+  '<img class="card-img-top" src="/DEworld/image/hompiBackground/' + data[i].itemImg 
				+  '" alt="" style="margin: 0 auto;    width: auto;    height: 100px;">'
				+  '<div class="card-body"><h4 class="card-title">'+ data[i].itemName 
				+  '</h4><p class="card-text">' + data[i].itemDesc + '</p></div>'
				+  '<div class="card-footer"><a href="/DEworld/item/itemDetail.do?flag=L&gu=2&itemId=' + data[i].itemId +'" class="btn btn-primary">상세페이지로 가기</a></div></div></div>';
		}
	}
	
	$("#innerMinimi .nav").html(strHtml);
	$("#innerTheme .nav").html(strHtml2);
}

function searchItem(){
	var searchItemName = document.getElementById("searchItemName").value;
	var param = {
		flag : "S",
		searchItemName : searchItemName
	};
	$.ajax({
		url : "/DEworld/item/itemList.do"
		,type : "post"
		,data : param
		,dataType : "json"
		,success : function(data){
			makeItemList(data);
		}
		,error : function(xhr){
			alert("실패하였습니다.\n관리자에게 문의하세요.");
			console.log(xhr);
		}
	});
}

