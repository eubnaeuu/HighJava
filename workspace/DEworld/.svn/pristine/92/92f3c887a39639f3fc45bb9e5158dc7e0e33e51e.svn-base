/**
 * 
 */
var auth = null;
	
	function sendInfo(){
		
		var memMail = $("#memMail").val();
		var memId = $("#memId").val();
		
		$.ajax({
			url : "/DEworld/MailServlet"
			,type : "post"
			,data : {"memMail" : memMail, "memId" : memId , "flag" : "findPw"}
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
				alert("알수없는 오류");
			}
		});
	}
	
	function confirm(data){
		
		var memMail = $("#memMail").val();
		var memId = $("#memId").val();
		var authInput = $("#auth").val();
		
		if(authInput != auth){
			alert("인증번호가 틀립니다.");
		} else {
			alert("인증성공");
			$.ajax({
				url : "/DEworld/MemberServlet"
				,type : "post"
				,data : {"memMail" : memMail,
						"memId" : memId,
						"flag" : "findPw"}
				,dataType : "json"
				,success : function(data){
					alert("<" + memId + ">" + "의 비밀번호는" + "<" + data[0].memPass + ">" + "입니다.");
				}
				,error : function(xhr){
					alert("에러");
				}
			})
		}
	}
	
	function goLogin(){
		window.location.href = "http://localhost/DEworld/html/loginpage/login.html";
	}