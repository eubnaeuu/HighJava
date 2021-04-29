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

function newPage(){
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
	$("#MemberList tbody").empty();
	
	var str = "";
	
	if(data.length== 0){
		str += "<tr><td colspan='4' style='text-align: center;'>데이터가없습니다</td></tr>";
	}
	
		for(var i=0 ; i<data.length ; i++) {
			str += "<tr>"
				+ "<td>" + data[i].memName + "(" + data[i].memId + ")" + "</td>"
				+ "<td>" + data[i].memNickname + "</td>"
				+ "<td><button type='button' value='"+ data[i].memId  +"' class='btn btn-primary btn-lg raised btnSize' onclick='showUserData(this)';>유저정보</button></td>"
				+ "<td><button type='button' value='"+ data[i].memId  +"' class='btn btn-primary btn-lg raised btnSize' onclick='goMiniHompi(this)'>미니홈피보기</button></td>"
				+ "</tr>";
		}
		$("#MemberList tbody").html(str);
}
function searchUser(){
	if($("#searchUser").val()=="모두보기"){
		ShowAllUser();
	}else if($("#searchUser").val()=="이름"){
		ShowNameUser();
	}else if($("#searchUser").val()=="닉네임"){
		ShowNicknameUser();
	}else if($("#searchUser").val()=="아이디"){
		ShowIdUser();
	}
}


//아이디검색
function ShowIdUser(){
	var memId = $("#WriteUser").val();
	
	var param = {
			memId : memId
			 ,flag : "I"
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

//닉네임검색
function ShowNicknameUser(){
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

//이름검색
function ShowNameUser(){
	var memName = $("#WriteUser").val();
	
	var param = {
			memName : memName
			 ,flag : "N"
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

function ShowAllUser(){
	newPage();
}

function showUserData(data){
	var link = data.value;
	window.location.href = "http://localhost/DEworld/html/adminRoom/adminchange.html?memId="+link;
}

function goMiniHompi(data){
	var link = data.value;
	openWindowPop("http://localhost/DEworld/hompi/main.do?hompiId="+link);
}	
	
function openWindowPop(url, name){
    var options = 'top=10, left=10, width=1085, height=551, status=no, menubar=no, toolbar=no, resizable=no';
    window.open(url, name, options);
}
