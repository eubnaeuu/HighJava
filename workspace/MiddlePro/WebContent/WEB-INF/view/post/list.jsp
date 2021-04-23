<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>회원 목록</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
function postlist(data){
	for ( var i in data) {
		console.log(i);
		var obj = data[i];
		
		str += i + "<br>" 
				+ "이름 : "+ obj.name + "<br>"
				+ "나이 : " + obj.age + "<br>" 
				+ "성별 : "+ obj.gender + "<br>" 
				+ "직업 : " + obj.job
				+ "<br><br><br>";
	}	
}

</script>
</head>
<body>
	<table border="1">
		<tr>
			<td>글번호</td>
			<td>제목</td>
			<td>내용</td>
			<td>작성자</td>
			<td>첨부파일ID</td>
		</tr>
		
	<%
	
	

// 		int memSize = memList.size();
		
		if(memSize > 0){
			for(int i = 0; i < memSize; i++){
	%>		
		<tr>
			<td><%=memList.get(i).getMemId() %></td>
			<td><a href="select.do?memId=<%=memList.get(i).getMemId()%>"><%= memList.get(i).getMemName() %></a></td>
			<td><%=memList.get(i).getMemTel() %></td>
			<td><%=memList.get(i).getMemAddr() %></td>
			<td><%=memList.get(i).getAtchFileId() %></td>
		</tr>
	<%
			}
		}else{
	%>
		<tr>
			<td colspan="5">회원정보가 없습니다.</td>
		</tr>
	<%
		}
	%>
	<tr align="center">
		<td colspan="5"><a href="insert.do">[회원 등록]</a></td>
	</tr>
	</table>
	
	<%
		if(msg.equals("성공")){ // 성공메시지가 전달되면...
	%>
			<script>
				alert('정상적으로 처리되었습니다.');
			</script>
	<% 		
		}
	%>

</body>
</html>