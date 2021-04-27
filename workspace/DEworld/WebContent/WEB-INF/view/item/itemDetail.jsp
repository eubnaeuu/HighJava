<%@page import="kr.or.ddit.item.vo.ItemVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ItemVO itemVO = (ItemVO) request.getAttribute("itemVO");
%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style>
	.modal-body{
		margin: 0 auto;
		width: 70%;
	}
	#giftInfo{
	    display: flex;
	    flex-direction: column;
	    align-items: center;
	}
	textarea{
		display:block;
		width:100%;
		padding:10px;
	}
	.modal-footer{
		display: flex;
    	justify-content: center;
	}
</style>
<script src="/DEworld/js/jquery-3.6.0.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script>
var memId = sessionStorage.getItem("Nickname");
// var memId = 'asd1111';
var count = 0;
var m = true;

function openWindowPop(url, name){
    var options = 'top=10, left=10, width=500, height=410, status=no, menubar=no, toolbar=no, resizable=no';
    window.open(url, name, options);
}

function addWishList(itemId){
	// 위시리스트 추가
	var param = {
		flag : "C",
		memId : memId,
		itemId : itemId
	};
	$.ajax({
		url : "/DEworld/item/itemDetail.do"
		,type : "post"
		,data : param
		,dataType : "json"
		,success : function(data){
			
			if(data.resultCnt == 0){
				alert("이미 위시리스트에 존재하는 상품입니다.");
			}else{
				alert("위시리스트에 추가되었습니다.");
			}
		}
		,error : function(xhr){
			alert("실패하였습니다.\n관리자에게 문의하세요.");
			console.log(xhr);
		}
	});
}

function money(){ // 보유 금액 확인
	$.ajax({
		url : "/DEworld/MemberServlet",
		type : "post",
		data : {"memId" : memId, "flag" : "setMyPage"},
		dataType : "json",
		async: false,
		success : function(data) {
			var memCybermoney = data[0].memCybermoney;
			var itemPrice = <%=itemVO.getItemPrice() %>;
			var result = memCybermoney - itemPrice;
			if(result < 0){
				alert("보유한 땅콩이 부족합니다!");
				m = false;
			}else{
				m = true;
			}
		},
		error : function(xhr) {
			alert("알수없는 에러");
		}
	});
	
}

function buyItem(){
	var result = confirm("구매하시겠습니까? <%=itemVO.getItemPrice() %> 땅콩이 차감됩니다.");
	if(result != true){
		return;
	}
	
	money();
	if(m == false){ // 머니가 부족하면
		return;
	}else{
		var itemId = "<%=itemVO.getItemId() %>";
		
		var param = {
			flag : "BUY",
			memId : memId,
			itemId : itemId
		};
		
		$.ajax({
			url : "/DEworld/item/itemDetail.do"
			,type : "post"
			,data : param
			,dataType : "json"
			,success : function(data){
				console.log(data);
				if(data.resultCnt == 0){
					alert("이미 보유한 상품입니다.");
				}else{
					alert("상품을 구매하셨습니다.");	
				}
			}
			,error : function(xhr){
				alert("실패하였습니다.\n관리자에게 문의하세요.");
				console.log(xhr);
			}
		});
	}
}

function showGiftBox(itemId){
	$("#giftModal").modal();
	
	var param = {
		flag : "GF",
		memId : memId
	};
	
	$.ajax({
		url : "/DEworld/item/itemDetail.do"
		,type : "post"
		,data : param
		,dataType : "json"
		,success : function(data){
			console.log(data);
			setFriendList(data);
		}
		,error : function(xhr){
			alert("실패하였습니다.\n관리자에게 문의하세요.");
			console.log(xhr);
		}
	});
}

function setFriendList(data){
	if(count != 0){
		return;
	}else{
		var strHtml = '<option value="">선택하세요</option>';
		for(var i=0 ; i<data.length; i++){
			strHtml += '<option value="' + data[i].friendId +'">' + data[i].friendNickname + '</option>';
		}
		$("#friendList").html(strHtml);
		count++;
	}
	
}


function sendGift(){
	var result = confirm("선물하시겠습니까? <%=itemVO.getItemPrice() %> 땅콩이 차감됩니다.");
	if(result != true){
		return;
	}
	 
	money(); 
	if(m == false){ // 머니가 부족하면
		return;
	}else{
		var itemId = "<%=itemVO.getItemId() %>";
		var friendList = document.getElementById("friendList");
		var friendId = friendList.options[friendList.selectedIndex].value;
		var giftMessage = document.getElementById("giftMessage").value;
		
		var param = {
			flag : "SENDGF",
			itemId : itemId,
			friendId : friendId,
			giftMessage : giftMessage,
			memId : memId
		};
		
		$.ajax({
			url : "/DEworld/item/itemDetail.do"
			,type : "post"
			,data : param
			,dataType : "json"
			,success : function(data){
				console.log(data);
				alert("선물을 전송했습니다!");
				friendList.selectedIndex = 0;
				giftMessage = '';
			}
			,error : function(xhr){
				alert("실패하였습니다.\n관리자에게 문의하세요.");
				console.log(xhr);
			}
		});
	}
}
</script>
</head>
<body>


	<div>
		<div>
			<img>
		</div>
		<div>
			<ul>
				<li><img src="/DEworld/image/item/<%=itemVO.getItemImg() %>"></li>
				<li>상품명 : <%=itemVO.getItemName() %></li>
				<li>상품 설명 : <%=itemVO.getItemDesc() %></li>
				<li>상품 가격 : <%=itemVO.getItemPrice() %></li>
			</ul>
		</div>
	</div>
	<div>
		<button type="button" class="itemBtn" onclick="addWishList(<%=itemVO.getItemId() %>)">위시리스트에 담기</button>
		<button type="button" class="itemBtn" onclick="buyItem()">구매하기</button>
		<button type="button" class="itemBtn" onclick="showGiftBox(<%=itemVO.getItemId() %>)">선물하기</button>
	</div>
	
	<div class="modal fade" id="giftModal" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h5 class="modal-title">선물하기</h5>
				</div>
				<div class="modal-body">
					<div id="giftInfo">
						<span>[<%=itemVO.getItemName() %>]</span><br>
						<img src="/DEworld/image/item/<%=itemVO.getItemImg() %>">
<%-- 						<% 
// 						String str = itemVO.getLitemGu();--%>
<%-- 						if(str.indexOf("01") != -1){ %> --%>
<%-- 							<img src="/DEworld/image/item/hompiBackground/<%=itemVO.getItemImg() %>"> --%>
<%-- 						<%}else{ %> --%>
<%-- 							<img src="/DEworld/image/item/<%=itemVO.getItemImg() %>"> --%>
<%-- 						<%}%> --%>
					</div>
					<div>
						선물 받는 사람: <select id="friendList" onchange="setFriendList()"></select>
					</div><br>
					<textarea rows="5" cols="20" placeholder="선물메시지를 작성해주세요." id="giftMessage"></textarea><br>
					<div>총 결제 땅콩 : <%=itemVO.getItemPrice() %>개</div>
					<hr>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" onclick="sendGift()">선물하기</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>