$(document).ready(function(){
	readFaqList();
});

function readFaqList(){
	var param = {
		flag : "L"
	};
	$.ajax({
		url : "/DEworld/faq/faqList.do"
		,type : "post"
		,data : param
		,dataType : "json"
		,success : function(data){
			console.log(data);
			alert("성공");
			makeFaqList(data);
		}
		,error : function(data){
			alert("실패");
			console.log(data);
		}
	});
	
}

function makeFaqList(data){
	$("table tbody").empty();
	
	var strHtml = "";
	for(var i=0 ; i<data.length ; i++) {
		console.log(data[i].faqTitle);
		strHtml += "<tr>"
				+ "<td><a href='/DEworld/faq/faqDetail.do?faqId=" + data[i].faqId + "'>" + data[i].faqTitle + "</a></td>"
				+ "</tr>";
	}
	
	$("table tbody").html(strHtml);
	
	
}