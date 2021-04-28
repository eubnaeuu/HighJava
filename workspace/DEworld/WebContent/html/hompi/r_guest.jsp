<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<htmL>
 <head>
  <title> 방명록 </title>
  <meta http-equiv="content-type" content="text/html; charset=utf-8">
 </head>

<script language="javascript">
<!--
	function comment_ok()
	{
		var text = document.guest.commenti.value;
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

	function write_guest_ok()
	{
		//alert("쓰기 방명록");
		var text = document.guest.guest_edit.value;
		if (text != "")
		{
			document.write('<br/><br/>');
			document.write('<table width="410" border="0" cellpadding="3" cellspacing="1" bgcolor="#DBDBDB" align="center">');
			document.write('<tr bgcolor="#FFFFFF">');
			document.write('<td align="center">'); 
			document.write('<font face="굴림" style="font-size:9pt;">');
			document.write(text);
			document.write('</font>');
			document.write('</td>');
			document.write('</tr>');
			document.write('</table>');
			document.write('<br/><br/>');

			document.write('<center><font face="굴림" style="font-size:9pt;">');
			document.write('<b>방명록 글이 추가 되었습니다.</b><br/><br/>');
			document.write('<a href="./r_guest.html">돌아가기</a>');
			document.write('</font></center>');
		}
		else
		{
			alert("글을 입력해 주세요!!!");
		}

		
	}
//-->
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
	<table border="0" bgcolor="#EBEBEB" width="430" cellpadding="1" cellspacing="1" align="center">
		<tr>
			<td><font face="굴림" style="font-size:8pt;">NO. 006</font></td>
			<td><font face="굴림" style="font-size:9pt;">장인수</font></td>
			<td><font face="굴림" style="font-size:8pt;">(2008.02.12 10:13)</font></td>
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
					미니 홈피를 개설 했습니다<br/>
					앞으로 많이 놀러 오시고 글 많이 남겨 주세요<br/>
					비록 짝퉁 홈피라 게시판등 모든 것이 제대로 작동하지는 않지만<br/>
					공부를 더 하다보면 언젠간 다 작동하는 멋진 홈페이지를 만들겠죠<br/>
					앞으로 힘찬 응 원 바랍니다<br/><br/>
					2008년 한해 건강하시고 복 많이 받으시기 바랍니다.<br/>
				</font>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<textarea name="commenti" rows="2" cols="47"></textarea>
				<input type="button" name="comment_save" value="확인" onclick="comment_ok()">
			</td>
		</tr>
	</table>
	<!-- ---------- ------------------------------------------------------------ -->

	<br/><br/>

	<!-- 방명록 글 시작 ------------------------------------------------------------ -->
	<center><img src="images/bar.jpg" width="430" height="6" border="0" alt=""></center>
	<table border="0" bgcolor="#EBEBEB" width="430" cellpadding="1" cellspacing="1" align="center">
		<tr>
			<td><font face="굴림" style="font-size:8pt;">NO. 005</font></td>
			<td><font face="굴림" style="font-size:9pt;">홍길동</font></td>
			<td><font face="굴림" style="font-size:8pt;">(2008.02.25 11:20)</font></td>
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
					안녕하세요. 홍길동입니다.<br>
					2008년 새해 복 많이  받으시고 대전에서 공부도 열심히<br/>
					하시길 바랍니다.<br/>
				</font>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<textarea name="comment" rows="2" cols="47"></textarea>
				<input type="button" name="comment_save" value="확인" onclick="comment_ok()">
			</td>
		</tr>
	</table>
	<!-- ---------- ------------------------------------------------------------ -->

	<br/><br/>

	<!-- 방명록 글 시작 ------------------------------------------------------------ -->
	<center><img src="images/bar.jpg" width="430" height="6" border="0" alt=""></center>
	<table border="0" bgcolor="#EBEBEB" width="430" cellpadding="1" cellspacing="1" align="center">
		<tr>
			<td><font face="굴림" style="font-size:8pt;">NO. 004</font></td>
			<td><font face="굴림" style="font-size:9pt;">나그네..</font></td>
			<td><font face="굴림" style="font-size:8pt;">(2008.02.23 6:37)</font></td>
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
					지나가다가 들립니다.. 미니 홈피가 멋지군요<br>
					더욱 열심히 하셔서 멋진 홈피 보여주시길 바랍니다.<br/>
					다음에 또 놀러 오겠습니다.<br/>
					그동안 건강하시고 즐겁게 지내시길 바랍니다.<br/>
				</font>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<textarea name="comment" rows="2" cols="47"></textarea>
				<input type="button" name="comment_save" value="확인" onclick="comment_ok()">
			</td>
		</tr>
	</table>
	<!-- ---------- ------------------------------------------------------------ -->

	<br/><br/>

	<!-- 방명록 아랫부분 글 검색 부분 ------------------------------------------------------------ -->
	<table align="center" border="0" cellpadding="1" cellspacing="1">
		<tr height="30">
			<td align="center" >
				<font face="굴림" style="font-size:9pt;">
					<img src="../images/left_arr.gif" width="12" height="13" border="0" alt="이전 페이지로">
					page 2 1
					<img src="../images/right_arr.gif" width="12" height="13" border="0" alt="다음 페이지로">
					</font>	
			</td>
		</tr>
		<tr>
			<td align="center">  
				<select name="find">
					<option value="find_name">이름으로 검색</option>
					<option value="find_name">내용으로 검색</option>
				</select>
				<input type="text" name="fils_words" size="15"/>
				<input type="submit" value="확인"/>
			</td>
		</tr>
	</table>
		<!-- ---------- ------------------------------------------------------------ -->
	<br/>
	
</form>

 </body>

</html>
