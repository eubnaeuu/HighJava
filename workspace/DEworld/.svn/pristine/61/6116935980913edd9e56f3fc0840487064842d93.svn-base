<%@page import="kr.or.ddit.item.vo.ItemVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	ItemVO itemVO = (ItemVO) request.getAttribute("itemVO");

%>

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
		<button type="button" class="itemBtn">위시리스트에 담기</button>
		<button type="button" class="itemBtn">구매하기</button>
		<button type="button" class="itemBtn">선물하기</button>
	</div>
</body>
</html>