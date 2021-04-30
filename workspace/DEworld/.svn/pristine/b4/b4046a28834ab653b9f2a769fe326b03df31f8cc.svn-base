/**
 * 
 */
$(document).ready(function(){
	startCheck();
});
function searchUser(){
	var memNickname = $("#WriteUser").val();
	var param = {
			memNickname : memNickname
			 ,flag : "NI"
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

function startCheck(){
	var userAuth = sessionStorage.getItem("nowLogin");
	if(userAuth == null){
		alert("확인되지않은 세션 정보입니다. \n로그인 페이지로 이동합니다.");
		window.location.href = "http://localhost/DEworld/html/loginpage/login.html";
	}else if(userAuth=="user"){
		ShowNicknameUser(userAuth);
	}else if(userAuth=="admin"){
		ShowNicknameUser(userAuth);
	}else{
		
	}
}

function ShowNicknameUser(tmp){
	var memNickname = decodeURI(location.search.replace("?search=", ""));
	var param = {
			memNickname : memNickname
			 ,flag : "NI"
			};
	
	$.ajax({
		url : "/DEworld/AdminroomServlet"
		,type : "post"
		,data : param
		,dataType : "json"
		,success : function(data){
			makeTable(data, tmp);

			
		}
	,error : function(request,status, error){
		alert("code:" + request.status+ "\n\r" 
		+ "message: " + request.responseText +"\n\r"
		+ "error : " + error);
		}
	});
}



function makeTable(data, tmp){
	$("#MemberList tbody").empty();
	
	var str = "";
	
	if(data.length== 0){
		str += "<tr><td colspan='4' style='text-align: center;'>데이터가없습니다</td></tr>";
	}
	if(tmp=="user"){
		for(var i=0 ; i<data.length ; i++) {
			str += "<tr>"
				+ "<td>" + (i+1) + "</td>"
				+ "<td>" + data[i].memName + "</td>"
				+ "<td>" + data[i].memNickname + "</td>"
				+ "<td><button type='button' value='"+ data[i].memId  +"' class='btn btn-primary btn-lg raised btnSize' onclick='goMiniHompi(this)'>미니홈피보기</button></td>"
				+ "<td class='userHide'><button type='button' value='"+ data[i].memId  +"' class='btn btn-primary btn-lg raised btnSize' onclick='goilchon(this)'>일촌신청</button></td>"
				+ "</tr>";
		}
	}else if(tmp=="admin"){
		for(var i=0 ; i<data.length ; i++) {
			str += "<tr>"
				+ "<td>" + (i+1) + "</td>"
				+ "<td>" + data[i].memName + "</td>"
				+ "<td>" + data[i].memNickname + "</td>"
				+ "<td><button type='button' value='"+ data[i].memId  +"' class='btn btn-primary btn-lg raised btnSize' onclick='goMiniHompi(this)'>미니홈피보기</button></td>"
				+ "</tr>";
		}
		$(".userHide").hide();
	}	
		
		$("#MemberList tbody").html(str);
}



function goMiniHompi(data){
	var link = data.value;
	openWindowPop("http://localhost/DEworld/hompi/main.do?hompiId="+link);
}	
	
function openWindowPop(url, name){
    var options = 'top=10, left=10, width=1085, height=551, status=no, menubar=no, toolbar=no, resizable=no';
    window.open(url, name, options);
}

function goilchon(data){
	var link = data.value;
	window.location.href = "http://localhost/DEworld/friendreq/insert.do?friendId="+link;
}