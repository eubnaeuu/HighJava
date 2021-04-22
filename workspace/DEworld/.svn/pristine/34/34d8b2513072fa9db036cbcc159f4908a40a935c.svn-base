/**
 * 
 */

$(document).ready(function(){
	// 화면 초기화 작업들 진행
	
	// 5. '우편번호찾기 화면-시' 세팅
	initCitySelect();
	
	$("#tbZipResult").on("dblclick", "tbody tr", function(){
		
		var zipcode = $(this).children("td:eq(0)").text();
		var addr = $(this).children("td:eq(1)").text();
		
		
		// 메인화면(부모창)의 우편번호, 주소 input에 데이터 세팅
		$("#memZip").val(zipcode);
		$("#memAdd1").val(addr);
		
		// 주소창(모달창) 닫기
		$("#zipModal").modal("hide");
		
	});
		
});


function initCitySelect(){
	var param = {
			'flag' : 'Z'
			,'flag_zip' : 'SI'		
	};
	
	$.ajax({
		url : "/DEworld/member/insert.do"
		,type : "post"
		,data : param
		,dataType : "json"
		,success : function(data){
//			console.log(data);
			makeCitySelect(data);
		}
		,error : function(xhr){
			console.log(xhr);
			alert("오류");
		}
	});
}



function makeCitySelect(data){
	// 방법1)
	var strHtml = '<option value="">선택하세요</option>';
//	var strHtml = '';
	for(var i=0 ; i<data.length ; i++){
		strHtml += '<option value="' + data[i].sido +'">' + data[i].sido + '</option>';
	}
	$("#city").html(strHtml);
	
	setGu();
	
}

function setGu(){
	var param = {
			'sido' : $("#city").val()
			,'flag' : 'Z'
			,'flag_zip' : 'GU'
	};
	
	$.ajax({
		url : "/DEworld/member/insert.do"
		,type : "post"
		,data : param
		,dataType : "json"
		,success : function(data){
//			console.log(data);
			makeGugunSelect(data);
			
		}
		,error : function(xhr){
			console.log(xhr);
			alert("오류");
		}
	});
	
}

function makeGugunSelect(data){
	var strHtml = '<option value="">선택하세요</option>';
	for(var i=0 ; i<data.length ; i++){
		strHtml += '<option value="' + data[i].gugun +'">' + data[i].gugun + '</option>';
	}
	$("#gu").html(strHtml);
	$("#gu").prop("disabled", false);
	
	setDong();
}

function setDong(){
	var param = {
			'sido' : $("#city").val()
			,'gugun' : $("#gu").val()
			,'flag' : 'Z'
			,'flag_zip' : 'DONG'
	};
	
	$.ajax({
		url : "/DEworld/member/insert.do"
		,type : "post"
		,data : param
		,dataType : "json"
		,success : function(data){
//			console.log(data);
			makeDongSelect(data);
			
		}
		,error : function(xhr){
			console.log(xhr);
			alert("오류");
		}
	});
	
}
function makeDongSelect(data){
	var strHtml = '<option value="">선택하세요</option>';
	for(var i=0 ; i<data.length ; i++){
		strHtml += '<option value="' + data[i].dong +'">' + data[i].dong + '</option>';
	}
	$("#dong").html(strHtml);
	$("#dong").prop("disabled", false);
}

function searchZipCode(){
	var sido = $("#city").val();
	var gu = $("#gu").val();
	var dong= $("#dong").val();
	
	if(isEmpty(sido) || isEmpty(gu) || isEmpty(dong)) {
		alert("시, 구, 동을 선택하고 검색 버튼을 누르세요.");
		return;
	}
	
	var param = {
			'flag' : 'Z'
			,'sido' : sido
			,'gugun' : gu
			,'dong' : dong
	};
	
	$.ajax({
		url : "/DEworld/member/insert.do"
		,type : "post"
		,data : param
		,dataType : "json"
		,success : function(data){
//			console.log(data);
			makeZipTable(data);
		}
		,error : function(xhr){
			console.log(xhr);
			alert("오류");
		}
	});
	
}
function makeZipTable(data){
	$("#divZipResult").show();
	$("#tbZipResult tbody").empty();
	
	var strHtml = "";
	for(var i=0 ; i<data.length ; i++) {
		console.log(data[i]);
		strHtml += "<tr>"
				+ "<td>" + data[i].zipcode + "</td>"
				+ "<td>" + data[i].sido + " "
				+ data[i].gugun + " "
				+ data[i].dong + " " 
				+ changeEmptyVal(data[i].bunji) + "</td>"
				+ "</tr>";
	}
	
	$("#tbZipResult tbody").html(strHtml);
	
	
}

function chkRegExp(val, type){
	if(isEmpty(val)) return false;
	var tmp = val;
	var regExp = "";
	if(type == "MEMBERID") {
		//영어소문자와 숫자로 구성. 4글자 이상 12글자 이하 
		regExp = /^(?=.*[a-z])([a-z0-9]).{4,12}$/;
		if(regExp.test(tmp)) {
			return true;
		} else {
			return false;
		}
	} else if(type == "MEMBERNAME") {
		// 한글. 2글자 이상 5글자 이하
		regExp = /^[가-힣]{2,5}$/;
		if(regExp.test(tmp)) {
			return true;
		} else {
			return false;
		}
	} else if(type == "MEMBERPASSWORD") {
		//영어소문자 또는 대문자를 1개 이상 포함. 숫자 1개이상 포함. 8~12자리 
		regExp = /(?=.*\d)(?=.*[a-zA-Z]).{8,12}/;
		if(regExp.test(tmp)) {
			return true;
		} else {
			return false;
		}
	} else if(type == "EMAIL") {
		regExp = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/;
		if(regExp.test(tmp)) {
			return true;
		} else {
			return false;
		}
	} else if(type == "HP") {
		regExp = /^\d{3}-\d{3,4}-\d{4}$/;
		if(regExp.test(tmp)) {
			return true;
		} else {
			return false;
		}
	}
	
}

function chkId1() {
	var memId = $("#memId").val();
	if(isEmpty(memId)) {
		alert("ID를 입력하세요");
		$("#memId").focus();
		return;
	}
	
	$("#checkedMemId").val("");
	$("#spMemId").text("");
	
	//중복되 데이터 인지 확인 후 checkedMemId 에 저장
	var data = {"flag" : "CHKID", "memId" : memId};
	
	$.ajax({
		url: "/DEworld/member/insert.do"
		,type: "post"
		,data: data
		,dataType: "json"
		,success: function(data) {
			console.log(data);
			if(data.resultCnt == 0) {
				$("#checkedMemId").val(memId);
				$("#spMemId").text("'"+memId+"' 사용가능");
				$("#spMemId").show();
			} else {
				$("#spMemId").text("중복된 ID가 존재합니다.");
				$("#spMemId").show();
			}
		}
		,error: function(xhr) {
			console.log(xhr);
			$("#spMemId").text("서버오류");
		}
	});
}

function Nick() {
	   var memNickname = $("#memNickname").val();
	   if(isEmpty(memNickname)) {
	      alert("닉네임을 입력하세요");
	      $("#memNickname").focus();
	      return;
	   }
	   
	   $("#checkedMemNickName").val("");
	   $("#spMemNickName").text("");
	   
	   //중복되 데이터 인지 확인 후 checkedMemNickName 에 저장
	   var data = {"flag" : "CHKNickname", "memNickname" : memNickname};
	   
	   $.ajax({
	      url: "/DEworld/member/insert.do"
	      ,type: "post"
	      ,data: data
	      ,dataType: "json"
	      ,success: function(data) {
	         console.log(data);
	         if(data.resultCnt == 0) {
	            $("#checkedMemNickName").val(memNickname);
	            $("#spMemNickName").text("'"+memNickname+"' 사용가능");
	            $("#spMemNickName").show();
	         } else {
	            $("#spMemNickName").text("중복된 닉네임이 존재합니다.");
	            $("#spMemNickName").show();
	         }
	      }
	      ,error: function(xhr) {
	         console.log(xhr);
	         $("#spMemNickName").text("서버오류");
	      }
	   });
	}

function openZip(){
	// 시 셀렉트박스 조회하고 초기화
	initCitySelect();
	// 테이블 초기화
	$("#tbZipResult tbody").empty();
	
	// 주소창(모달창) 열기 - 부트스트랩의 modal 메소드 호출
	$("#zipModal").modal();
}

// 회원정보 저장하기
function save(){
	// 회원정보 유효성 체크
	var result = validate();
	if(!result) {
		return;
	}
	
	// 사용자 컨펌
	if(!confirm("저장하시겠습니까?")) {
		return;
	}
	
	// DB에 저장하는 ajax 호출
	$("#formFlag").val("C");
	$.ajax({
		url : "/DEworld/member/insert.do"
		,type : "post"
		,data : $("#fm").serialize()
		,dataType : "json"
		,success : function(data){
			alert("저장되었습니다.");
			resetField();
		}
		,error : function(xhr){
			alert("실패하였습니다.\n관리자에게 문의하세요.");
			console.log(xhr);
		}
	});
	
}

function validate(){
	//ID검사
	var memId = $("#memId").val();
	if(isEmpty(memId)) {
		alert("ID는 필수 입력 입니다.");
		$("#spMemId").show();
		$("#memId").focus();
		return false;
	}
	
	if( !chkRegExp(memId, "MEMBERID") ) {
		$("#spMemId").show();
		$("#memId").focus();
		return false;
	} else {
		$("#spMemId").hide();
	}
	
	var checkedMemId = $("#checkedMemId").val();
	if(isEmpty(checkedMemId)) {
		alert("ID 중복 체크 하세요.");
		$("#memId").focus();
		return false;
	}
	if(checkedMemId != memId) {
		alert("ID가 변경되었습니다. ID 중복 체크 하세요.");
		$("#memId").focus();
		return false;
	}
	
	//이름검사
	var memName = $("#memName").val();
	if(isEmpty(memName)) {
		alert("이름은 필수 입력 입니다.");
		$("#spMemName").show();
		$("#memName").focus();
		return false;
	}
	
	if( !chkRegExp(memName, "MEMBERNAME") ) {
		$("#spMemName").show();
		$("#memName").focus();
		return false;
	} else {
		$("#spMemName").hide();
	}
	
	//비밀번호검사
	var memPass = $("#memPass").val();
	if(isEmpty(memPass)) {
		alert("비밀번호는 필수 입력 입니다.");
		$("#spMemPass").show();
		$("#memPass").focus();
		return false;
	}
	
	if( !chkRegExp(memPass, "MEMBERPASSWORD") ) {
		$("#spMemPass").show();
		$("#memPass").focus();
		return false;
	} else {
		$("#spMemPass").hide();
	}
	
	//이메일검사
	var memMail = $("#memMail").val();
	if(isEmpty(memMail)) {
		alert("이메일은 필수 입력 입니다.");
		$("#spMemMail").show();
		$("#memMail").focus();
		return false;
	}
	
	if( !chkRegExp(memMail, "EMAIL") ) {
		$("#spMemMail").show();
		$("#memMail").focus();
		return false;
	} else {
		$("#spMemPass").hide();
	}
	
	//우편번호검사
	var memZip = $("#memZip").val();
	if(isEmpty(memZip)) {
		alert("우편번호는 필수 입력 입니다.");
		$("#btnAddr").focus();
		return false;
	}
	
	//memAdd1
	if(isEmpty($("#memAdd1").val())) {
		alert("주소는 필수 입력 입니다.");
		$("#btnAddr").focus();
		return false;
	}
	//memAdd2
	if(isEmpty($("#memAdd2").val())) {
		alert("상세 주소는 필수 입력 입니다.");
		$("#memAdd2").focus();
		return false;
	}
	
	//생년월일검사
	var memBir = $("#memBir").val();
	if(isEmpty(memBir)) {
		alert("생년월일은 필수 입력 입니다.");
		$("#memBir").focus();
		return false;
	}
	var age = parseInt((new Date()).getFullYear())
			 - parseInt(memBir.substr(0,4)) + 1;
	if(age < 10) {
		alert("10살 미만은 가입하실 수 없습니다.");
		$("#memBir").focus();
		return false;
	}
	
	//핸드폰번호검사
	var memHp = $("#memHp").val();
	if(isEmpty(memHp)) {
		alert("핸드폰번호는 필수 입력 입니다.");
		$("#memHp").focus();
		return false;
	}
	if( !chkRegExp(memHp, "HP") ) {
		alert("핸드폰번호 형식이 바르지 않습니다.");
		$("#memHp").focus();
		return false;
	}
	
	return true;
}

function resetField(){
	document.getElementById('fm').reset();
	$("span").hide();
	$("#spMemId").html("영어 소문자 반드시 포함, 영어 소문자와 숫자 사용 가능. 4~12글자");
}

