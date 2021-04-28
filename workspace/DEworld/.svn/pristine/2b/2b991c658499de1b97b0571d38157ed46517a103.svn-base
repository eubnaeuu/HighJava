/**
 * 
 */



$(document).ready(function(){
	
	

	var nowLogin = sessionStorage.getItem("Nickname");
	$.ajax({
		url : "/DEworld/MemberServlet",
		type : "post",
		data : {"memId" : nowLogin, "flag" : "setMyPage"},
		dataType : "json",
		success : function(data) {
			$("#memId").val(nowLogin);
			$("#memName").val(data[0].memName);
			$("#memNickname").val(data[0].memNickname);
			if(data[0].memGender == "남자"){
				$("input:radio[id='genderMale']").prop("checked", true);
			} else {
				$("input:radio[id='genderFemale']").prop("checked", true);
			}
			$("#memNickname").val(data[0].memNickname);
			$("#memBir").val((data[0].memBir).substr(0,10));
			$("#memMail").val((data[0].memMail));
			$("#memHp").val((data[0].memHp));
			$("#memZip").val((data[0].memZip));
			$("#memAdd1").val((data[0].memAdd1));
			$("#memAdd2").val((data[0].memAdd2));
		},
		error : function(xhr) {
			alert("알수없는 에러");
		}
	});
	
	alert("아이디와 닉네임, 이메일은 수정이 불가능 합니다.")
});

function updateInfo(){
	
	var param = $("#fm").serialize() + "&flag=updateInfo";
	
	$.ajax({
		url : "/DEworld/MemberServlet"
		,type : "post"
		,data : param 
		,dataType : "json"
		,success : function(data){
			if(data[0].cnt == 1){
				alert("정보 수정이 완료되었습니다.")
				window.location.href = "http://localhost/DEworld/adminRoom/adminRoom.html";
			} else {
				alert("오류 발생");
			}
		}
	,error : function(xhr){
		console.error(xhr.responseText);
		}
	});
}

function checkEqual(){
	var memPass = $("#memPass").val();
	var memPassCon = $("#memPassConfirm").val();
	if(memPass != memPassCon){
		alert("비밀번호가 일치하지 않습니다 !!");
	} else{
		updateInfo();
	}
}