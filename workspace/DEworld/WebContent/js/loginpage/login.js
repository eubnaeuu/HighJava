/**
 * 
 */

$(document).ready(function(){
	$("#userLogin").click(function(){
		$("#btnLogin").css({"background-color" : "#007bff", "border-color" : "#007bff"});
		$("#btnLogin").attr("onclick", "checkIdPw()");
	});
	
	$("#adminLogin").click(function(){
		$("#btnLogin").css({"background-color" : "black", "border-color" : "black"});
		$("#btnLogin").attr("onclick", "checkAdmin()");
	});
});


function pressEnter(){
    if(event.keyCode == 13){
    	if($("#btnLogin").attr("onclick") == "checkIdPw()"){
    		checkIdPw();
    	} else{
    		checkAdmin();
    	}
    }
}

function checkAdmin(){
		
	var memId = $("#memId").val();
	var memPass = $("#memPass").val();
	
	$.ajax({
		url : "/DEworld/MemberServlet"
		,type : "post"
		,data : {"adminId" : memId, "flag" : "adminLogin"}
		,dataType : "json"
		,success : function(data){
			if($("#memId").val() == "" && $("#memPass").val() == ""){
				alert("아이디 , 비밀번호를 입력해주세요");
			} else if($("#memId").val() == ""){
				alert("아이디를 입력해주세요.");
			} else if($("#memPass").val() == ""){
				alert("비밀번호를 입력해주세요.");
			} else {
				if(data[0] == null){
					alert("해당 사용자 정보가 존재하지 않거나 비밀번호가 일치하지 않습니다.");
				} else {
					sessionStorage.setItem("nowLogin", data[0].adminId);
					sessionStorage.setItem("adminClass", data[0].adminClass);
					window.location.href = "http://localhost/DEworld/html/adminPage/adminPage.html";
				}
			}
		}
		,error : function(xhr){
			alert("관리자 오류");
		}
	});
}

function checkIdPw(){
	
	var memId = $("#memId").val();
	var memPass = $("#memPass").val();
	
	$.ajax({
		url : "/DEworld/MemberServlet"
		,type : "post"
		,data : {"memId" : memId, "memPass" : memPass , "flag" : "login"}
		,dataType : "json"
		,success : function(data){
			if($("#memId").val() == "" && $("#memPass").val() == ""){
				alert("아이디 , 비밀번호를 입력해주세요");
			} else if($("#memId").val() == ""){
				alert("아이디를 입력해주세요.");
			} else if($("#memPass").val() == ""){
				alert("비밀번호를 입력해주세요.");
			} else {
				if(data[0] == null){
					alert("해당 사용자 정보가 존재하지 않거나 비밀번호가 일치하지 않습니다.");
				} else {
					sessionStorage.setItem("nowLogin", data[0].memId);
					window.location.href = "http://localhost/DEworld/html/mainPage/topic.html";
				}
			}
		}
		,error : function(xhr){
			alert("알수없는 오류");
		}
	});
}

function register(){
	window.location.href = "http://localhost/DEworld/member/insert.do";
}