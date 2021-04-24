/**
 * 
 */

//var idArea = $("#idArea").val();
$(document).ready(function(){
	var user = sessionStorage.getItem("nowLogin");
	//$("#idArea").html(user);
	
	if(user == null){
		alert("세션ID 정보가 존재하지 않습니다.\n로그인 페이지로 이동합니다.");
		window.location.href = "http://localhost/DEworld/html/loginpage/login.html";
	}
	
	var memId = sessionStorage.getItem("nowLogin");

	$.ajax({
		url : "/DEworld/MemberServlet"
		,type : "post"
		,data : {"memId" : memId, "flag" : "setMyPage"}
		,dataType : "json"
		,success : function(data){
			var memName = data[0].memName;
			var memMail = data[0].memMail;
			var memNickname = data[0].memNickname;
			
			$("#memName").html(memName);
			$("#memMail").html(memMail);
			$("#idArea").html(memNickname);
		}
		,error : function(xhr){
			alert("알수없는 오류");
		}
	});
	
});

function logOut(){
	window.location.href = "http://localhost/DEworld/html/loginpage/login.html";
	
	sessionStorage.clear();
}



