/**
 * 
 */
$(document).ready(function(){
	startCheck();
});

function startCheck(){
	var userAuth = sessionStorage.getItem("nowLogin");
	if(userAuth == null||userAuth == "user"){
		alert("확인되지않은 세션ID 정보입니다. \n로그인 페이지로 이동합니다.");
		window.location.href = "http://localhost/DEworld/html/loginpage/login.html";
	}else if(userAuth =="admin"){
		newPage();
		
	}else{
		alert("오류입니다. 사이트담당자에게 연락 부탁드립니다.");
	}
}

function newPage(tmp){
	var param = {
			 flag : "L"
			};
	
	$.ajax({
		url : "/DEworld/AdminroomServlet"
		,type : "post"
		,data : param
		,dataType : "json"
		,success : function(data){
			makeTable(data);
			
		}
	,error : function(request,status, error){
		alert("code:" + request.status+ "\n\r" 
		+ "message: " + request.responseText +"\n\r"
		+ "error : " + error);
		}
	});
}

function makeTable(data){
	var str = "";

		for(var i=0 ; i<data.length ; i++) {
			str += "<tr>"
				+ "<td>" + data[i].memName + "(" + data[i].memId + ")" + "</td>"
				+ "<td>" + data[i].memNickname + "</td>"
				+ "<td><button type='button' class='btn btn-primary btn-lg raised btnSize'>유저정보</button></td>"
				+ "<td><button type='button' class='btn btn-primary btn-lg raised btnSize'>미니홈피보기</button></td>"
				+ "</tr>";
		}
		$("#MemberList tbody").html(str);
}
