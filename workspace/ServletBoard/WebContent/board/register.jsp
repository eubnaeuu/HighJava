<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../css/mycss.css">
<title>게시글 작성</title>
</head>
<body id="registerbody">
		<form action="register.do" method="post">
		<fieldset>
			<legend>게시글 등록</legend>
			<div class="row">
				<label for="no">글번호</label>	
				<input class="input" type="text" name="no" id="no" size="30" title="글번호" value="30" required><br>
			</div>
			<div class="row">
				<label for="date">일자</label>	
				<input class="input" type="text" name="date" id="date" size="30" title="일자" value="2021-04-10 13:08:35" required><br>
			</div>
			<div class="row">
				<label for="writer">작 성 자</label>	
				<input class="input" type="text" name="writer" id="writer" size="30" title="작성자" required><br>
			</div>
			<div class="row">
				<label for="title">제    목</label>
				<input class="input" type="text" name="title" id="title" size="30" maxlength="16" title="제목" required><br>
			</div>
			<div class="row">
				<label for="content" style="vertical-align: top" >내    용</label>
				<textarea rows="10" cols="50" name="content" id="content" title="내용" required></textarea>
			</div>
			
		</fieldset>
		<div id="divbottom">
			<input type="submit" value="등  록" id="submittbuton">
			<input type="reset" value="초기화" id="resetbutton">
		</div>
		</form>
	</body>
</html>