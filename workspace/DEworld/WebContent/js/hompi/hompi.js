/**
 * 
 */

$(document).ready(function() {

	var memId = location.search.replace("?hompiId=", "");

	$.ajax({
		url : "/DEworld/MemberServlet",
		type : "post",
		data : {
			"memId" : memId,
			"flag" : "setHompi"
		},
		dataType : "json",
		success : function(data) {
			$("#backgroundTable").attr("background", "/DEworld/image/hompiBackground/" + data[0].hompiBackground)
		},
		error : function(xhr) {
			alert("홈피 에러");
			console.error(xhr);
		}
	});

});


function iframeChange(obj){
	$("#rightIframe").attr("src", obj)
	$("#rightIframe").src = $("#rightIframe").src.substr(0,36) + "r_home.html";
}
function iframeChangelink(str){
	$("#rightIframe").attr("src", "/DEworld"+str);
}
function iframeChangelinkdiary(str){
	$("#rightIframe").attr("src", "/DEworld"+str);
	$("#leftframe").attr("src","/DEworld/html/hompi/left_2.jsp");
}
function iframeProfile(){
	$("#rightIframe").src = $("#rightIframe").src.substr(0,36) + "r_profile.html";
}
function iframePictures(){
	$("#rightIframe").src = $("#rightIframe").src.substr(0,36) + "r_pictures.html";
}
function iframeGuest(){
	$("#rightIframe").src = $("#rightIframe").src.substr(0,36) + "r_guest.html";
}
function iframeDiary(){
	$("#rightIframe").src = $("#rightIframe").src.substr(0,36) + "r_diary.html";
}