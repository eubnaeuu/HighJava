<%@page import="kr.or.ddit.member.service.MemberServiceImpl"%>
<%@page import="kr.or.ddit.member.service.IMemberService"%>
<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@page import="kr.or.ddit.comments.vo.CommentsVO"%>
<%@page import="kr.or.ddit.paging.PagingVO"%>
<%@page import="kr.or.ddit.guestbook.vo.GuestBookVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// String strJson = (String)request.getAttribute("strJson");
List<GuestBookVO> guestbooklist = (List<GuestBookVO>)request.getAttribute("guestbooklist");
PagingVO pagingVO = (PagingVO)request.getAttribute("pagingVO");
String msg = request.getParameter("msg") == null ? ""
		: request.getParameter("msg");

String userId = (String)request.getSession().getAttribute("userId");
IMemberService memberService = MemberServiceImpl.getInstance();
MemberVO logininfo = memberService.getMember(userId);

String hompiId	= request.getParameter("hompiId");

%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<htmL>
 <head>
  <title> 방명록 </title>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <meta http-equiv="content-type" content="text/html; charset=utf-8">
 </head>

<script language="javascript">

	function comment_ok()
	{
		
		$.ajax({
			url : "/DEworld/guestbook/insert.do",
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
		
		
		
		
		
		if (text != "")
		{
			text = text + '\n\n\n' + '댓글이 추가되었습니다. ^_^';
			alert(text);

		}
		else
		{
			alert('댓글을 입력해 주세요 ^^');
		}
	}

// 	function write_guest_ok()
// 	{
// 		//alert("쓰기 방명록");
// 		var text = document.guest.guest_edit.value;
// 		if (text != "")
// 		{
// 			document.write('<br/><br/>');
// 			document.write('<table width="410" border="0" cellpadding="3" cellspacing="1" bgcolor="#DBDBDB" align="center">');
// 			document.write('<tr bgcolor="#FFFFFF">');
// 			document.write('<td align="center">'); 
// 			document.write('<font face="굴림" style="font-size:9pt;">');
// 			document.write(text);
// 			document.write('</font>');
// 			document.write('</td>');
// 			document.write('</tr>');
// 			document.write('</table>');
// 			document.write('<br/><br/>');

// 			document.write('<center><font face="굴림" style="font-size:9pt;">');
// 			document.write('<b>방명록 글이 추가 되었습니다.</b><br/><br/>');
// 			document.write('<a href="./r_guest.html">돌아가기</a>');
// 			document.write('</font></center>');
// 		}
// 		else
// 		{
// 			alert("글을 입력해 주세요!!!");
// 		}

		
// 	}

</script>

 <body>

<form name="guest">

	<!-- 탑, 글쓰기 -------------------------------------------------------------------------------- -->
 	<table width="410" border="0" cellpadding="3" cellspacing="1" bgcolor="#DBDBDB" align="center">
		<tr bgcolor="#FFFFFF">
			<td align="center"> 
				<font face="굴림" style="font-size:9pt;">
					오늘도 사이좋은 사람들과 행복한 하루를...
				</font>
			</td>
		</tr>
	</table>
	<br/>
	<table width="430" border="0" align="center">
		<tr>
			<td align="right"> 
				<input type="button" name="font" value="글꼴설정" onclick="javascript:alert('미완성입니다. ^^;')"/>
				<input type="button" name="edit" value="수정" onclick="javascript:alert('미완성입니다. ^^;')"/>
			</td>
		</tr>
	</table>

	<center><img src="images/bar.jpg" width="430" height="6" border="0" alt=""></center>
	<table width="410" border="0" cellpadding="0" cellspacing="0" align="center">
		<tr>
			<td>  
				<img src="images/minimi.gif" width="98" height="98" border="0" alt="">
			</td>
			<td align="center">  
				<textarea name="guest_edit" rows="7" cols="40"></textarea>
			</td>
		</tr>
	</table>
	<table border="0" width="410" cellpadding="0" cellspacing="0" align="center">
		<tr>
			<td width="230">  
				<font face="굴림" style="font-size:9pt;">
				<input type="radio" name="minami_or_card" value="mimami" checked>미나미
				<input type="radio" name="minami_or_card" value="card">카드
				</font>
			</td>
			<td width="200" align="right">  
				<input type="button" name="write_guest" value="확인" onclick="write_guest_ok()">
			</td>
		</tr>
	</table>
	<center><img src="../images/bar.jpg" width="430" height="6" border="0" alt=""></center>
	<!-------- -------------------------------------------------------------------------------- -->



	<br/><br/><br/><br/>



	<!-- 방명록 글 시작 ------------------------------------------------------------ -->
	<center><img src="images/bar.jpg" width="430" height="6" border="0" alt=""></center>
<%
					int size = guestbooklist.size();
					if(size > 0){
						int cnt = 1;
						String GuestBookChkId = "GuestBookCheckbox"+cnt;
						for (int i=0; i < size;  i++){
							%>
	<table border="0" bgcolor="#EBEBEB" width="430" cellpadding="1" cellspacing="1" align="center">
		<tr>
			<td><font face="굴림" style="font-size:8pt;">NO. <%=cnt %></font></td>
			<td><font face="굴림" style="font-size:9pt;"><%=guestbooklist.get(i).getGusetbookWriter() %></font></td>
			<td><font face="굴림" style="font-size:8pt;"><%=guestbooklist.get(i).getGuestbookDate() %></font></td>
			<td align="right"><font face="굴림" style="font-size:9pt;">보관 | 비밀로 하기 | 삭제 | 신고</font></td>
		</tr>
	</table>
	<table border="0" width="410" align="center">
		<tr>
			<td width="100">  
				<img src="images/minimi.gif" width="98" height="98" border="0" alt="">
			</td>
			<td width="330">  
				<font face="굴림" style="font-size:9pt;">
					<%=guestbooklist.get(i).getGuestbookContent() %>
				</font>
			</td>
		</tr>
	<%
						if(hompiId.equals(userId)){
			%>
		<tr>
			<td colspan="2" align="center">
				<input id="gbUserId" type="hidden" value="<%=userId%>" name="guestbookWriter">
				<input id="gbHompiId" type="hidden" value="<%=hompiId%>" name="hompiId">
				<textarea id="gbContent" name="guestbookContent" rows="2" cols="47"></textarea>
				<input type="button" name="comment_save" value="확인" onclick="comment_ok()">
			</td>
		</tr>
		</table><br><br>		
		
		<%
						}else{
							%>
		</table><br><br>					
							<%
						}
	
						}	
						%>
<!-- 페이징 처리 시작 -->
	      <%if(pagingVO.getTotalCount() > 0) {%>
	         <tr>
	            <td colspan="6" align="center">
	               <%if(pagingVO.getFirstPageNo() > pagingVO.getPageSize()) { %>
	               <a href="list.do?pageNo=<%=pagingVO.getFirstPageNo() - pagingVO.getPageSize() %>">[이전]</a>
	               <%} %>
	               <%for(int pNo = pagingVO.getFirstPageNo(); pNo <= pagingVO.getLastPageNo(); pNo++) { %>
	                  <a <%if(pNo == pagingVO.getCurrentPageNo()){ %> style="color:orange;"<%} %> href="list.do?pageNo=<%=pNo %>">[<%=pNo %>]</a>
	               <%} %>
	               <%if(pagingVO.getLastPageNo() < pagingVO.getTotalPageCount()) {%>
	               <a href="list.do?pageNo=<%=pagingVO.getFirstPageNo() + pagingVO.getPageSize() %>">[다음]</a>
	               <%} %>
	            </td>
	         </tr>
	      <%} %>
<!-- 페이징 처리 끝 --> 							
						<%
					}else{
						%>
						
						<% 
					}
						%>

	<!-- 방명록 아랫부분 글 검색 부분 ------------------------------------------------------------ -->
<!-- 	<table align="center" border="0" cellpadding="1" cellspacing="1"> -->
<!-- 		<tr height="30"> -->
<!-- 			<td align="center" > -->
<!-- 				<font face="굴림" style="font-size:9pt;"> -->
<!-- 					<img src="../images/left_arr.gif" width="12" height="13" border="0" alt="이전 페이지로"> -->
<!-- 					page 2 1 -->
<!-- 					<img src="../images/right_arr.gif" width="12" height="13" border="0" alt="다음 페이지로"> -->
<!-- 					</font>	 -->
<!-- 			</td> -->
<!-- 		</tr> -->
<!-- 		<tr> -->
<!-- 			<td align="center">   -->
<!-- 				<select name="find"> -->
<!-- 					<option value="find_name">이름으로 검색</option> -->
<!-- 					<option value="find_name">내용으로 검색</option> -->
<!-- 				</select> -->
<!-- 				<input type="text" name="fils_words" size="15"/> -->
<!-- 				<input type="submit" value="확인"/> -->
<!-- 			</td> -->
<!-- 		</tr> -->
<!-- 	</table> -->
		<!-- ---------- ------------------------------------------------------------ -->
	<br/>
	
</form>

 </body>

</html>
