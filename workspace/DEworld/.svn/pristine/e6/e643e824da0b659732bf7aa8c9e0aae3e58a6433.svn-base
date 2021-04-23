function readItemList(){
	$.ajax({
		url : "/DEworld/item/itemList.do"
		,type : "post"
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
	$("#ul").empty();
	
	var strHtml = "";
	for(var i=0 ; i<data.length ; i++) {
		console.log(data[i]);
		strHtml += "<li>"
				+ "<img src="+ data[i].itemImg +"><br>"
				+ "<p>" + data[i].itemName + "</p>"
				+ "<p>" + data[i].itemPrice + "</p>"
				+ "</li>";
	}
	
	$("ul").html(strHtml);
	
	
}