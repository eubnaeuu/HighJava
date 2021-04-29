<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Insert title here</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<link rel="stylesheet" href="/DEworld/css/newcss.css">
	<!-- JS -->
	<script src="/DEworld/js/jquery-3.6.0.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="/DEworld/js/common/myutils.js?v=1"></script>
	<script type="text/javascript" src="/DEworld/js/member/memberNew.js?v=1"></script>
</head>
<body>
	<!-- 본문영역 시작 -->
	<div class="container">
		<h2>회원가입</h2>
		<form class="form-horizontal" id="fm" >
			<div class="form-group">
				<label class="control-label col-sm-2 required" for="memId">아이디</label>
				<div class="col-sm-10 form-inline">
					<input type="text" class="form-control" id="memId" placeholder="아이디를 입력하세요" name="memId" required>
					<button type="button" class="btn btn-default btn-sm" id="btnMemId" onclick="chkId1()">중복검사</button>
					<span id="spMemId" style="display: none;">영어 소문자 반드시 포함, 영어 소문자와 숫자 사용 가능. 4~12글자</span>
					<input type="hidden" id="checkedMemId" >
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2 required" for="memName">이름</label>
				<div class="col-sm-10">
					<input type="text" class="form-control form-control1" id="memName" placeholder="이름을 입력하세요" name="memName" required>
					<span id="spMemName" style="display: none;">이름은 한글 2~5 글자의 형식으로 작성해주셔야 됩니다.</span>
				</div>
			</div>
			<div class="form-group">
	            <label class="control-label col-sm-2 required" for="memNickname">닉네임</label>
	            <div class="col-sm-10 form-inline">
	               <input type="text" class="form-control" id="memNickname" placeholder="닉네임을 입력하세요" name="memNickname" required>
	               <button type="button" class="btn btn-default btn-sm" id="btnMemNick" onclick="Nick()">중복검사</button>
	               <span id="spMemNickName" style="display: none;">10글자 미만으로 입력해주세요.</span>
	               <input type="hidden" id="checkedMemNickName" >
	            </div>
         	</div>
			<div class="form-group row">
				<label class="control-label col-sm-2 required" for="memBir">생년월일</label>
				<div class="col-sm-10">
					<input type="text" class="form-control form-control1 singleDate" id="memBir" name="memBir" placeholder="1999 04 15" required>
					<span id="spMemBir" style="display: none;">생년월일 형식이 바르지 않습니다.</span>
				</div>
			</div>
			<div class="form-group">
	            <label class="control-label col-sm-2 required" for="memGender">성별</label>
	            <div class="col-sm-10">
	               <input type="radio" value="남자" name="memGender" id="genderMale"> 
	               <label for="genderMale">남자</label>
	               <input type="radio" value="여자" name="memGender" id="genderFemale"> 
	               <label for="genderFemale">여자</label>
	            </div>
         	</div>  
			<div class="form-group">
				<label class="control-label col-sm-2 required" for="memPass">비밀번호</label>
				<div class="col-sm-10">
					<input type="password" class="form-control form-control1" id="memPass" placeholder="비밀번호를 입력하세요" name="memPass" required>
					<span id="spMemPass" style="display: none;">비밀번호는 영어와 숫자를 포함한 8~12글자의 형식으로 작성해주셔야 됩니다.</span>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2 required" for="memPassConfirm">비밀번호 확인</label>
				<div class="col-sm-10">
					<input type="password" class="form-control form-control1" id="memPassConfirm" placeholder="비밀번호를 입력하세요" name="memPassConfirm" required>
				</div>
			</div>
			<div class="form-group row">
				<label class="control-label col-sm-2 required" for="memHp">핸드폰번호</label>
				<div class="col-sm-10">
					<input type="text" class="form-control form-control1" id="memHp" name="memHp" placeholder="010-1234-5678" required>
					<span id="spMemHp" style="display: none;">핸드폰번호 형식이 바르지 않습니다.</span>
				</div>
			</div>
			<div class="form-group row">
				<label class="control-label col-sm-2 required" for="memMail">이메일</label>
				<div class="col-sm-10">
					<input type="email" class="form-control form-control1" id="memMail" name="memMail" placeholder="abcd123@gmail.com" required>
					<span id="spMemMail" style="display: none;">이메일 형식이 바르지 않습니다.</span>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2 required" for="memId">주소</label>
				<div class="col-sm-10 form-inline">
					<input type="text" class="form-control form-inline-zip1" id="memZip" name="memZip" placeholder="우편주소"  required>
					
<!-- 					<button type="button" class="btn btn-info btn-sm"
					 data-toggle="modal" data-target="#zipModal">검색</button> -->
					<button type="button" class="btn btn-info btn-sm" onclick="openZip()">검색</button><br><br>
					<input type="text" class="form-control form-inline-zip2" id="memAdd1" name="memAdd1" placeholder="기본주소를 입력하세요"  required>
					<br><br>
					<div class="form-group-inner-down">
					<input type="text" class="form-control" id="memAdd2" name="memAdd2" placeholder="상세주소를 입력하세요" required>
					</div>
				</div>
			</div>
			<input type="hidden" name="hompiId" value="">
<!-- 			<input type="hidden" name="action" id="actionFm"> -->
			<input type="hidden" name="flag" id="formFlag">
		</form>
		
		<div class="form-button text-center">
			<button type="button" class="btn btn-primary" onclick="checkEqual()">제출</button>
			<button type="button" class="btn btn-default" onclick="resetField()">초기화</button>
		</div>
	</div>
	
	<!-- 우편번호 검색 Modal Start -->
	<div class="modal fade" id="zipModal" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h5 class="modal-title">주소 검색</h5>
				</div>
				<div class="modal-body">
					시: <select id="city" onchange="setGu()">
					</select>
					구: <select id="gu" onchange="setDong()" disabled="disabled">
						<option value="">선택하세요</option>
					</select>
					동: <select id="dong" disabled="disabled">
						<option value="">선택하세요</option>
					</select>
					<button type="button" onclick="searchZipCode()" id="btnZip">검색</button>
					<hr>
					<div id="divZipResult" style="display: none;">
						<table class="table table-striped" id="tbZipResult">
						  <thead>
						    <tr onclick="">
						      <th>우편번호</th>
						      <th>주소</th>
						    </tr>
						  </thead>
						  <tbody>
						  </tbody>
						</table>
					</div>
					
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal" id="btnCloseZipModal">닫기</button>
				</div>
			</div>
		</div>
	</div>
	<!-- 우편번호 검색 Modal End -->
	
	<form id="tmpFm">
		<input type="hidden" name="action" id="actionTmlFm">
		<input type="hidden" name="memId" id="selectedMemId">
		<input type="hidden" name="targetUrl" id="targetUrl">
	</form>
	<!-- 본문영역 끝 -->

</body>
</html>