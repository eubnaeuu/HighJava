<%@page import="kr.or.ddit.faq.vo.FaqVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="/DEworld/html/mainPage/vendor/bootstrap/css/bootstrap.min.css"	rel="stylesheet">

<!-- common -->
<script type="text/javascript" src="/DEworld/js/common/commonMainpage.js"></script>
<link href="css/commonMainpage.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<style type="text/css">
		ul{
			list-style:none;
			
		}
		
		
	</style>
</head>
<body>
<%
	FaqVO faqVO = (FaqVO) request.getAttribute("faqVO");

%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
		<div class="container">
			<img src="/DEworld/image/DEWorld-350x350.png" style="width: 32px">
			<a class="navbar-brand"
				href="http://localhost/DEworld/html/mainPage/topic.html#">&nbsp;DEWorld</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="d-flex justify-content">
				<div class="searchbar">
					<input class="search_input" type="text" name=""
						placeholder="Search..."> <a href="#" class="search_icon"><i
						class="fas fa-search"></i></a>
				</div>
			</div>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a class="nav-link" onclick="logOut()">
							<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
								fill="currentColor" class="bi bi-door-closed"
								viewBox="0 0 16 16">
			  <path
									d="M3 2a1 1 0 0 1 1-1h8a1 1 0 0 1 1 1v13h1.5a.5.5 0 0 1 0 1h-13a.5.5 0 0 1 0-1H3V2zm1 13h8V2H4v13z" />
			  <path d="M9 9a1 1 0 1 0 2 0 1 1 0 0 0-2 0z" />
		  </svg> LogOut
					</a></li>
				</ul>
			</div>
		</div>
	</nav>
		<div style="margin-top: 100px;">
		<h1>&nbsp;&nbsp;&nbsp;&nbsp;FAQ</h1>
		<hr>
			
			<ul>				
				<li><h2><%=faqVO.getFaqTitle() %></li>
				<br><br><br>
				<li><h4><%=faqVO.getFaqContent() %></li>
			</ul>
		</div>
<footer class="py-5 bg-dark">
		<div class="container">
			<p class="m-0 text-center text-white">Copyright &copy; Your
				Website 2020</p>
		</div>
		<!-- /.container -->
	</footer>
	
</body>
</html>