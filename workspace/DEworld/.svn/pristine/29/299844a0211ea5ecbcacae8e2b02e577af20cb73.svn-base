<%@page import="java.util.Calendar"%>
<%@page import="kr.or.ddit.hompi.vo.HompiVO"%>
<%@page import="kr.or.ddit.friend.service.FriendServiceImpl"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.friend.service.FriendService"%>
<%@page import="kr.or.ddit.friend.vo.FriendVO"%>
<%@page import="kr.or.ddit.friendreq.handler.SearchFriendReqHandler"%>
<%@page import="kr.or.ddit.member.service.MemberServiceImpl"%>
<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@page import="kr.or.ddit.member.service.IMemberService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String userId = (String)request.getSession().getAttribute("userId");
    IMemberService memberService = MemberServiceImpl.getInstance();
    MemberVO logininfo = memberService.getMember(userId);
    
    String hompiId = request.getParameter("hompiId");
    
    FriendVO fv = new FriendVO();
	HompiVO hv = new HompiVO();
	
	fv.setMemId(hompiId);
	
	fv.setFriendId(request.getParameter("friendId"));
	fv.setFriendDate(request.getParameter("friendDate"));
	
	FriendService FriendService = FriendServiceImpl.getInstance();
	
	List<FriendVO> friendlist = FriendService.getSearchFriend(fv);
	
	
	
	 request.setCharacterEncoding("utf-8");
	    
	    Calendar now = Calendar.getInstance();
	    int year = now.get(Calendar.YEAR);
	    int month = now.get(Calendar.MONTH)+1;
	   
	    String _year = request.getParameter("year");
	    String _month = request.getParameter("month");
	   
	    if(_year != null)
	        year = Integer.parseInt(_year);
	   
	    if(_month != null)
	        month = Integer.parseInt(_month);
	   
	    now.set(year, month-1, 1);    //출력할 년도, 월로 설정
	   
	    year = now.get(Calendar.YEAR);    //변화된 년, 월
	    month = now.get(Calendar.MONTH) + 1;
	   
	    int end = now.getActualMaximum(Calendar.DAY_OF_MONTH);    //해당월의 마지막 날짜
	    int w = now.get(Calendar.DAY_OF_WEEK);    //1~7(일~토)
    %>
    
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<htmL>
<head>
<title>오늘의 나의 기분</title>
<meta charset="utf-8">
<style type="text/css">
            *{padding: 0px; margin: 0px;}  /* 브라우저별 기본 여백 차이가 있기에 작성한다. */
            body{font-size: 9pt;}
            td{font-size: 9pt;}
            a{cusor: pointer; color: #000000; text-decoration: none; font-size: 9pt; line-height: 150%;}
            a:HOVER, a:ACTIVE{font-size: 9pt; color: #F28011; text-decoration: underline;}
        </style>
</head>

<body>
	<table border="0" width="130">
		<tr>
			<td bgcolor="#DBDBDB" align="center"><font face="굴림"
				style="font-size: 8pt;">today is... 피곤!</font></td>
		</tr>
		<tr>
			<td>
				<table bgcolor="#DBDBDB" width="130" cellpadding="1" cellspacing="1">
					<tr bgcolor="#FFFFFF">
<!-- 						<td bg><img src="/DEworld/image/hompiProfile/"+mem1.png" width="128" height="110" -->
						<td bg>
       <center>
            <table width="210" border="0" cellpadding="1" cellspacing="2">
                <tr height="30">
                    <td align="center">
                        <form action ="calendar2.jsp" method="post">
                            <select name="year" onchange="sendIt()">
                                    <%for(int i=year-5; i<year; i++) { %>
                                        <option value="<%=i%>" > <%=i%>년</option>
                                    <%} %>
                                    <option value="<%=year%>" selected="selected"><%=year%>년</option>
                                    <%for(int i=year+1; i<year+5; i++) { %>
                                        <option value="<%=i%>" > <%=i%>년</option>
                                    <%} %>
       
                            </select>
                           
                            <select name="month" onchange="sendIt()">
                                <% for(int i=1; i<=12; i++) {%>
                                    <option value="<%=i%>" <%=month==i?"selected='selected'":"" %>> <%=i%>월 </option>
                                <%} %>
                            </select>
                               
                        </form>
                    </td>
                </tr>
            </table>
           
            <table width="210" border="0" cellpadding="2" cellspacing="1" bgcolor="#cccccc">
                <tr height="25">
                    <td align="center" bgcolor="#e6e4e6"><font color="red">일</font></td>
                    <td align="center" bgcolor="#e6e4e6">월</td>
                    <td align="center" bgcolor="#e6e4e6">화</td>
                    <td align="center" bgcolor="#e6e4e6">수</td>
                    <td align="center" bgcolor="#e6e4e6">목</td>
                    <td align="center" bgcolor="#e6e4e6">금</td>
                    <td align="center" bgcolor="#e6e4e6"><font color="blue">토</font></td>
                </tr>
                <%
                    int newLine = 0;
                    //1일이 어느 요일에서 시작하느냐에 따른 빈칸 삽입
                    out.println("<tr height='25'>");
                    for(int i=1; i<w; i++)
                    {
                        out.println("<td bgcolor='#ffffff'>&nbsp;</td>");
                        newLine++;
                    }
                   
                    String fc, bg;
                    for(int i=1; i<=end; i++)
                    {
                       
                        fc = (newLine == 0)?"red":(newLine==6?"blue":"#000000");
                        bg = "#ffffff";
                        out.println("<td align='center' bgcolor=" + bg + "><font color=" + fc + ">"
                                + i + "</font></td>");
                        newLine++;
                        if(newLine == 7 && i != end)
                        {
                            out.println("</tr>");
                            out.println("<tr height='25'>");
                            newLine = 0;
                        }
                    }
                   
                    while(newLine>0 && newLine<7)
                    {
                        out.println("<td bgcolor='ffffff'>&nbsp;</td>");
                        newLine++;   
                    }
                    out.println("</tr>");
                %>
            </table>
        </center>							
						


						</td>
					</tr>
				</table>
			</td>

		</tr>
		<tr>
			<td id="leftBarInfo"><font face="굴림" style="font-size: 9pt;">
					<button>수정</button>
			</font></td>
		</tr>
	</table>

	<br />
	<br />
	<br />
	<table bgcolor="#DBDBDB" width="130" cellpadding="1" cellspacing="1">
		<tr align="center">
			<td bgcolor="#FFFFFF"><font face="굴림" style="font-size: 9pt;">
					<b>DEWorld</b><br>
				<a href="http://localhost/DEworld/html/mainPage/topic.jsp"
					target="_blank"><font color="#000099">DEWorld.com</font></a>
					<select id="friendSelect">
						<%if(friendlist!=null){
							int cnt=0;
							%>
								<option>파도타기</option>
							<%
							for(FriendVO friendVO : friendlist){
							cnt++;
								%>
								<option value=<%=cnt %>><%=friendVO.getFriendId()%></option>
								<%
							}
							%>
							</select>
							<%
						}else {
							%>
							<option value=0>파도타기</option>
							<%
						}
							%>
					</select>
			</font></td>
		</tr>
	</table>
  <script type="text/javascript">
            function sendIt()
            {
                var f = document.forms[0];
                f.submit();
            }
        </script>
</body>
</html>
