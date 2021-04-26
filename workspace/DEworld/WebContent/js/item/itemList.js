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
			makeItemList(data);
		}
		,error : function(xhr){
			alert("실패하였습니다.\n관리자에게 문의하세요.");
			console.log(xhr);
		}
	});
	
}

function makeItemList(data){
	$("ul").empty();
	
	var strHtml = "";
	for(var i=0 ; i<data.length ; i++) {
		strHtml += "<a href='/DEworld/item/itemDetail.do?flag=L&itemId=" + data[i].itemId + "'><li>"
				+ "<img src=" + "/DEworld/image/item/" + data[i].itemImg +"><br>"
				+ "<p>" + data[i].itemName + "</p>"
				+ "<p>" + data[i].itemPrice + " 땅콩</p>"
				+ "</li></a>";
	}
	
	$("ul").html(strHtml);
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

