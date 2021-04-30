/**
 * 
 */
var auth = null;
	
	function sendMail(){
	
		var memMail = $("#memMail").val();
		
		$.ajax({
			url : "/DEworld/MailServlet"
			,type : "post"
			,data : {"memMail" : memMail, "flag" : "findId"}
			,dataType : "json"
			,success : function(data){
				if(data[0].resultCnt == 1){
					alert("매칭되는 이메일이 없습니다.");
				} else{
					alert("인증번호가 전송되었습니다.");
				}
				auth = data[0].auth;
			}
			,error : function(xhr){
				
			}
		});
	}
	
	function confirm(data){
		var authInput = $("#auth").val();
		var memMail = $("#memMail").val();
		
		if(authInput != auth){
			alert("인증번호가 틀립니다.");
		} else {
			alert("인증성공");
			$.ajax({
				url : "/DEworld/MemberServlet"
				,type : "post"
				,data : {"memMail" : memMail, "flag" : "findId"}
				,dataType : "json"
				,success : function(data){
					alert("<" + memMail + ">" + "의 아이디는" + "<" + data[0].memId + ">" + "입니다.");
				}
				,error : function(xhr){
									}
			})
		}
	}
	
	function goLogin(){
		window.location.href = "http://localhost/DEworld/html/loginpage/login.html";
	}