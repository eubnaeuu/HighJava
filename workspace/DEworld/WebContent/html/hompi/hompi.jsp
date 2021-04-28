<%@page import="kr.or.ddit.hompi.vo.HompiVO"%>
<%@page import="kr.or.ddit.member.service.MemberServiceImpl"%>
<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@page import="kr.or.ddit.member.service.IMemberService"%>
<%@page import="kr.or.ddit.comments.vo.CommentsVO"%>
<%@page import="kr.or.ddit.paging.PagingVO"%>
<%@page import="kr.or.ddit.message.vo.MessageVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
HompiVO hv = (HompiVO)request.getAttribute("hompiVO");

String hompiId = hv.getHOMPI_ID();
String userId = (String)request.getSession().getAttribute("userId");

IMemberService memberService = MemberServiceImpl.getInstance();
MemberVO logininfo = memberService.getMember(userId);
    
    %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<htmL>
<head>
<meta charset="UTF-8">
<title>홈</title>
<script src="/DEworld/js/jquery-3.6.0.js"></script>
<script src="/DEworld/js/hompi/hompi.js"></script>
<style type="text/css">
body {
	scrollbar-face-color: #FFFFFF;
	scrollbar-highlight-color: #DBDBDB;
	scrollbar-3dlight-color: #FFFFFF;
	scrollbar-shadow-color: #9C92FF;
	scrollbar-darkshadow-color: #FFFFFF;
	scrollbar-track-color: #FFFFFF;
	scrollbar-arrow-color: #9C92FF
}

.btm_image {
	cursor: pointer;
	background-color: pink;
	width: 82;
	height: 30;
	transition: all 0.9s;
}

.btm_image:hover {
	box-shadow: 0 80px 0 0 rgba(0, 0, 0, 0.25) inset, 0 -80px 0 0
		rgba(0, 0, 0, 0.25) inset;
}
</style>

</head>



<body bgcolor="#F3F3F3" topmargin="0" leftmargin="0">
	<form name="main">
		<!-- 미니 홈페이지 외각 테이블 -->
		<table border="0" align="left" width="950" height="550" cellspacing="0" cellpadding="0" 
		background="/DEworld/image/hompiBackground/minion.jpg">
			<tr>
				<td><script
						language="javascript">
						var now = new Date()
						document.write('<span style="font-size:9pt;font-weight:bold">&nbsp;&nbsp;&nbsp; 지금은.. ')
						document.write(now.getFullYear() + '년 '
								+ (now.getMonth() + 1) + '월 ' + now.getDate() + '일'
								+ ' ' + now.getHours() + ':' + now.getMinutes())
						document.write('</span>')
					</script>

					<table border="0" align="left" width="800" height="510"
						background="/DEworld/html/hompi/theme/bg_big.gif">
						<tr>
							<td colspan="2" align="center"><br> <font face="굴림"><span
									style="font-size: 8pt;">today 9999 total 9999</span></font></td>
							<td height="40"><br> <font face="굴림"><span
									style="font-size: 13pt; font-weight: bold">
										<center>
											<font color="#4B9687">"ID"의 미니 홈페이지</font>
										</center>
								</span></font></td>
							<td></td>
						</tr>
						<tr>
							<td width="10"></td>
							<td width="178" height="450"
								background="./images/bg_left_rect.jpg">
								<!-- 왼쪽 내용 부분 ----------------------------------------------------------- -->
								<center>
									<iframe frameborder="0" width="160" height="440"
										src="/DEworld/html/hompi/left_intro.jsp?hompiId="<%=hompiId %>></iframe>
								</center>
							</td>
							<td width="480" height="450"
								background="./images/bg_center_rect.jpg">
								<center>
									<!-- 오른쪽 내용 부분 ----------------------------------------------------------- -->
									<iframe frameborder="0" width="470" height="430"
										src="/DEworld/html/hompi/r_home.jsp" id="rightIframe"></iframe>
									<!-- ---------------------------------------------------------------------------- -->
								</center>
							</td>
							<!-- 오른쪽 메뉴 부분 ----------------------------------------------------------- -->
							<td>
								<button type="button" class="btm_image" id="img_btn"
									onclick="iframeChange('/DEworld/html/hompi/r_home.jsp')">홈</button> <br />
								<br />
								<button type="button" class="btm_image" id="img_btn"
									onclick="iframeChange('/DEworld/html/hompi/r_profile.jsp')">프로필</button> <br />
								<br />
								<button type="button" class="btm_image" id="img_btn"
									onclick="iframeChangelink('/post/list.do?hompiId=<%=hompiId%>')">게시판</button> <br />
								<br />
								<button type="button" class="btm_image" id="img_btn"
									onclick="iframeChangelink('/post/list.do?flag=pho')">사진첩</button> <br />
								<br />
								<button type="button" class="btm_image" id="img_btn"
									onclick="iframeChange('/DEworld/html/hompi/r_guest.jsp')">방명록</button> <br />
								<br />
								<button type="button" class="btm_image" id="img_btn"
									onclick="iframeChangelink('/post/list.do?flag=dia')">다이어리</button> <br />
								<br /> <br /> <br /> <br /> <br /> <br /> <br /> <br />
								<br />
							</td>
							<!-- 오른쪽 메뉴 부분 ----------------------------------------------------------- -->
						</tr>
					</table>
				<td style="position: relative; top: 0px; left: 0px;">
					<iframe frameborder="0" width="250" height="480" src="/DEworld/html/hompi/music/musicOn.html" style="padding-top: 10px; padding-right: 35px;" scrolling="no""></iframe>
				</td>
			</tr>
		</table>
		<!-- ------------------------ -->
	</form>
</body>


</html>