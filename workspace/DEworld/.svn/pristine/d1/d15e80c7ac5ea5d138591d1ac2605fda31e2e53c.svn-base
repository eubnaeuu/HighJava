/**
 * 
 */
function checkIdPw(){
	
	var param = jQuery("#loginArea").serialize();
	var memId = null;
	
	$.ajax({
		url : "/DEworld/MemberServlet"
		,type : "post"
		,data : param
		,dataType : "json"
		,success : function(data){
			console.log(data);
			if(data[0] == null){
				alert("해당 사용자 정보가 존재하지 않거나 비밀번호가 일치하지 않습니다.");
			} else {
				sessionStorage.setItem("nowLogin", data[0].memId);
			}
		}
		,error : function(xhr){
			console.error(xhr);
			alert("알수없는 오류");
		}
	});
	
}

function register(){
	window.location.href = "http://localhost/DEworld/member/insert.do";
}