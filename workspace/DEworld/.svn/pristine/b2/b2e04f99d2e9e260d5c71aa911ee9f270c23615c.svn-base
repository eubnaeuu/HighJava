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
	
	//투멤남 투멤녀 불러오기
	var gender = new Array();
	gender[0] = '남자';
	gender[1] = '여자';
	
	var str = "";
	//투멤남
	$.ajax({
		url : "/DEworld/MemberServlet",
		type : "post",
		data : {"memGender" : gender[0], "flag" : "highVisitCnt"},
		dataType : "json",
		success : function(data) {
			
			console.log(data);
			var memId = data[0].memId;
			var nickName = data[0].memNickname;
			var profileImg = data[0].hompiProfileImg;
			var visitCount = data[0].visitCountToday;
			var hompiInfo = data[0].hompiInfo;
			
			str = "<div class='col-md-6 mb-5'>" +
					  "<div class='card h-100'>" +
					  	"<img class='card-img-top' src='/DEworld/image/profileImg/" + profileImg + "' alt='' id='topImage'>" +
					  	"<div class='card-body'>" +
					  	"<h4 class='card-title'>" + nickName + "</h4>" +
					  	"<p class='card-text'>" + hompiInfo + "</p>" +
					  "</div>" +
				      "<div class='card-footer'>" +
				      "<a class='btn btn-primary' onclick=" + "goHompi('"+ memId +"')>미니홈피로 가기</a>" +
					  "</div>" +
				  "</div>" + "</div>";
		},
		error : function(xhr) {
			
		}
	});
	
	//투멤녀
	$.ajax({
		url : "/DEworld/MemberServlet",
		type : "post",
		data : {"memGender" : gender[1], "flag" : "highVisitCnt"},
		dataType : "json",
		success : function(data) {
			
			console.log(data);
			var memId = data[0].memId;
			var nickName = data[0].memNickname;
			var profileImg = data[0].hompiProfileImg;
			var visitCount = data[0].visitCountToday;
			var hompiInfo = data[0].hompiInfo;
			
			str += "<div class='col-md-6 mb-5'>" +
					  "<div class='card h-100'>" +
						  "<img class='card-img-top' src='/DEworld/image/profileImg/" + profileImg + "' alt='' id='topImage'>" +
			              "<div class='card-body'>" +
						  	"<h4 class='card-title'>" + nickName + "</h4>" +
						  	"<p class='card-text'>" + hompiInfo + "</p>" +
						  "</div>" +
					      "<div class='card-footer'>" +
					      "<a class='btn btn-primary' onclick=" + "goHompi('"+ memId +"')>미니홈피로 가기</a>" +
					      "</div>" +
				  "</div>" +
				  "</div>";
			$("#toMem").html(str);
			console.log(str);
		},
		error : function(xhr) {
			
		}
	});
		
	

});

//메인 영역 버튼 함수
function mainAreaClick(){
/*	$("#btnTopic").
	$("#btnShop").
	$("#btnMypage").*/
	
	$("#btnTopic").click(function(){
		
		$("#shopDetail").fadeOut();
		
		$("#sectionMypage").hide();
		$("#sectionShop").hide();
		$("#sectionTopic").fadeIn();
		
		$("#btnTopic").attr('class','nav-link active');

		$("#btnShop").attr('class','nav-link');
		$("#btnMypage").attr('class','nav-link');
	});
	
	$("#btnShop").click(function(){
		
		$("#shopDetail").fadeIn();
		
		$("#sectionMypage").hide();
		$("#sectionTopic").hide();
		$("#sectionShop").fadeIn();
		
		$("#btnShop").attr('class','nav-link active');

		$("#btnTopic").attr('class','nav-link');
		$("#btnMypage").attr('class','nav-link');
	});
	
	$("#btnMypage").click(function(){
		
		$("#shopDetail").fadeOut();
		
		$("#sectionShop").hide();
		$("#sectionTopic").hide();
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
			
			$("#innerTheme").hide();
			$("#innerMinimi").hide();
			
			$("#innerMusic").fadeIn();
			
			$("#btnMusic").attr('class','nav-link active');
			
			$("#btnTheme").attr('class','nav-link');
			$("#btnMinimi").attr('class','nav-link');
		});
		
		$("#btnTheme").click(function(){
			
			$("#innerMinimi").hide();
			$("#innerMusic").hide();
			
			$("#innerTheme").fadeIn();
			
			$("#btnTheme").attr('class','nav-link active');
			
			$("#btnMusic").attr('class','nav-link');
			$("#btnMinimi").attr('class','nav-link');
		});
		
		$("#btnMinimi").click(function(){
			
			$("#innerTheme").hide();
			$("#innerMusic").hide();
			
			$("#innerMinimi").fadeIn();
			
			$("#btnMinimi").attr('class','nav-link active');
			
			$("#btnMusic").attr('class','nav-link');
			$("#btnTheme").attr('class','nav-link');
		});
	}

function openWindowPop(url, name){
    var options = 'top=10, left=10, width=1085, height=551, status=no, menubar=no, toolbar=no, resizable=no';
    window.open(url, name, options);
}
function goMyHompi(){
	openWindowPop("http://localhost/DEworld/html/hompi/hompi.html", "name");
	//openWindowPop("http://localhost/DEworld/hompi/main.do?flag=", "name");
}
function goHompi(str){
	openWindowPop("http://localhost/DEworld/hompi/main.do?hompiId="+str,"name");
}
function goMyMessage(){
	window.open("http://localhost/DEworld/message/list.do");
}
function goMyFriend(){
	window.open("http://localhost/DEworld/friend/list.do");
}

function openWindowPopSendMessage(hompiId){
    var options = 'top=10, left=10, width=270, height=386, status=no, menubar=no, toolbar=no, resizable=no';
    window.open("http://localhost/DEworld/message/insert.do?hompiId="+hompiId);
}


