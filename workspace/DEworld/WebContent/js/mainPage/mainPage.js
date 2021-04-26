/**
 * 
 */

//var idArea = $("#idArea").val();
$(document).ready(function(){
	
	//메인 섹션 숨기기 
	$("#sectionTopic").show();
	$("#sectionShop").hide();
	$("#sectionMypage").hide();
	
	//서브 섹션 숨기기
	$("#innerMusic").show();
	$("#innerTheme").hide();
	$("#innerMinimi").hide();
	
	//샵 내부 버튼 숨기기
	$("#shopDetail").hide();
	
	var user = sessionStorage.getItem("nowLogin");
	
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

//메인 영역 버튼 함수
function mainAreaClick(){
/*	$("#btnTopic").
	$("#btnShop").
	$("#btnMypage").*/
	
	$("#btnTopic").click(function(){
		
		$("#shopDetail").fadeOut();
		
		$("#sectionMypage").fadeOut();
		$("#sectionShop").fadeOut();
		$("#sectionTopic").fadeIn();
		
		$("#btnTopic").attr('class','nav-link active');

		$("#btnShop").attr('class','nav-link');
		$("#btnMypage").attr('class','nav-link');
	});
	
	$("#btnShop").click(function(){
		
		$("#shopDetail").fadeIn();
		
		$("#sectionMypage").fadeOut();
		$("#sectionTopic").fadeOut();
		$("#sectionShop").fadeIn();
		
		$("#btnShop").attr('class','nav-link active');

		$("#btnTopic").attr('class','nav-link');
		$("#btnMypage").attr('class','nav-link');
	});
	
	$("#btnMypage").click(function(){
		
		$("#shopDetail").fadeOut();
		
		$("#sectionShop").fadeOut();
		$("#sectionTopic").fadeOut();
		$("#sectionMypage").fadeIn();
		
		$("#btnMypage").attr('class','nav-link active');

		$("#btnShop").attr('class','nav-link');
		$("#btnTopic").attr('class','nav-link');
	});
}

//샵 내부 영역 버튼 함수
function subAreaClick(){
	/*	$("#btnTopic").
		$("#btnShop").
		$("#btnMypage").*/
		
		$("#btnMusic").click(function(){
			
			$("#innerTheme").fadeOut();
			$("#innerMinimi").fadeOut();
			
			$("#innerMusic").fadeIn();
			
			$("#btnMusic").attr('class','nav-link active');
			
			$("#btnTheme").attr('class','nav-link');
			$("#btnMinimi").attr('class','nav-link');
		});
		
		$("#btnTheme").click(function(){
			
			$("#innerMinimi").fadeOut();
			$("#innerMusic").fadeOut();
			
			$("#innerTheme").fadeIn();
			
			$("#btnTheme").attr('class','nav-link active');
			
			$("#btnMusic").attr('class','nav-link');
			$("#btnMinimi").attr('class','nav-link');
		});
		
		$("#btnMinimi").click(function(){
			
			$("#innerTheme").fadeOut();
			$("#innerMusic").fadeOut();
			
			$("#innerMinimi").fadeIn();
			
			$("#btnMinimi").attr('class','nav-link active');
			
			$("#btnMusic").attr('class','nav-link');
			$("#btnTheme").attr('class','nav-link');
		});
	}



