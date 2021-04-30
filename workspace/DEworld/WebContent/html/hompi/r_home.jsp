<%@page import="kr.or.ddit.collection.vo.CollectionVO"%>
<%@page import="kr.or.ddit.collection.service.CollectionService"%>
<%@page import="kr.or.ddit.collection.service.CollectionServiceImpl"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.hompi.vo.HompiVO"%>
<%@page import="kr.or.ddit.hompi.service.HompiServiceImpl"%>
<%@page import="kr.or.ddit.hompi.service.HompiService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
 // 로그인유저 정보
    String userId = (String)request.getSession().getAttribute("userId");
    
 // 홈피 유저 정보
    HompiVO hv = new HompiVO();
    HompiService hompiService = HompiServiceImpl.getInstance();
    
    String hompiId = request.getParameter("hompiId");
    hv.setHompiId(hompiId);
    List<HompiVO> list = hompiService.getSearchHompi(hv);
    
    String hompiminiroom = list.get(0).getHompiMiniroom();
    String hompibackground = list.get(0).getHompiBackground();
    
// 음악,아이템 보관함
	CollectionService collectionService = CollectionServiceImpl.getInstance();
	CollectionVO cv = new CollectionVO();
	cv.setMemId(userId);
	cv.setLitemGu("01");
	
	// 미니미리스트
	List<CollectionVO> MinimiCollectionList = collectionService.getSearchItemCollection(cv);
	cv.setLitemGu("02");
	// 배경리스트
	List<CollectionVO> BgCollectionList = collectionService.getSearchItemCollection(cv);
	// 음악리스트
	List<CollectionVO> musicCollectionList = collectionService.getSearchMusicCollection(hompiId);
    
    
    %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<htmL>
<head>
<title>New Document</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
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

#minimi {
	position: absolute;
	bottom: 150px;
	left: 150px;
}

#bg {
	position: absolute;
	right: 30px;
	left: 0px;
}
</style>
</head>

</head>

<body leftmargin="5" topmargin="0">

	<table bgcolor="#DBDBDB" width="440" cellpadding="1" cellspacing="1">
		<tr bgcolor="#FFFFFF">
			<td colspan="2"><font face="굴림" style="font-size: 9pt;"><b>Update
						Board...</b></font></td>
		</tr>
		<tr bgcolor="#FFFFFF">
			<td width="240"><font face="굴림" style="font-size: 9pt;"><a
					href="./pics/r_pic_page2.html#n8">사진</a></font><br /></td>
			<td valign="top">

				<table bgcolor="#DBDBDB" width="200" align="center" cellpadding="1"
					cellspacing="1">
					<tr bgcolor="#FFFFFF" align="center">
						<td><font face="굴림" style="font-size: 9pt;"><a
								href="./r_home.html">홈</a></a></font></td>
						<td><font face="굴림" style="font-size: 9pt;"><a
								href="./r_profile.html">프로필</a></td>
					</tr>
					<tr bgcolor="#FFFFFF" align="center">
						<td><font face="굴림" style="font-size: 9pt;"><a
								href="./pics/r_pic_page2.html">사진첩</a></font></td>
						<td><font face="굴림" style="font-size: 9pt;"><a
								href="./guest/r_guest2.html">방명록</a></font></td>
					</tr>
				</table>

			</td>
		</tr>
	</table>

	<br />

	<img src="images/bar.jpg" width="440" height="6" border="0" alt="라인">
	<!-- 	<table bgcolor="#DBDBDB" width="440" cellpadding="1" cellspacing="1"> -->
	<!-- 		<tr bgcolor="#FFFFFF" > -->
	<!-- 			<td align="center">   -->
	<!-- 				<font face="굴림" style="font-size:9pt;"><b>Mini Room </b></font>	 -->
	<!-- 			</td> -->
	<!-- 			<td width="300" align="center">   -->
	<!-- 				<font face="굴림" style="font-size:9pt;">home</font>	 -->
	<!-- 			</td> -->
	<!-- 		</tr> -->

	<tr bgcolor="#FFFFFF">
		<td align="center" colspan="2"><img id="bg"
			src="/DEworld/image/miniRoom/<%=hompiminiroom %>" width="450"
			height="250" border="0" alt="아바타 집 그림"> <img id="minimi"
			src="/DEworld/image/item/default_boy.png" width="50" height="100"
			border="0" alt="미니미"></td>
	</tr>
	</table>



</body>
</html>
