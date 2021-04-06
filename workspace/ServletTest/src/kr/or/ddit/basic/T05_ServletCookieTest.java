package kr.or.ddit.basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class T05_ServletCookieTest  extends HttpServlet{
/**
  	쿠키 정보를 다루기 위한 예제
  	(웹서버와 브라우저는 애플리케이션을 사용하는 동안 필요한 값을 쿠키를 통해 공유하여 상태를 유지)
  	 (http의 특징이 비연결 지향형이기에 상대방 구분 매우 힘듦)
  	
  	1. 구성 요소
  	- 이름
  	- 값
  	유효시간(초)
  	도메인 : ex) www.somehost.com, .somehost.com
  	  => 쿠키의 도메인이 쿠키를 생성한 서버의 도메인을 벗어나면 브라우저는 쿠키를 저장(생성)하지 않는다 (보안문제 때문)
  	  
   2. 동작방식
   
   - 쿠키 생성단계 : 생성한 쿠키를 응답데이터의 헤더에 저장하여 웹브라우저에 전송
   
   - 쿠키 저장단계 : 브라우저는 응답데이터에 포함된 쿠키를 쿠키저장소에 보관
   									(쿠키종류에 따라 메모리나 파일에 저장) 
   									
  	- 쿠키 전송단계 : 웹브라우저는 저장한 쿠키를 요청이 있을때마다 웹서버에 전송( 삭제 전까지)
  									웹서버는 브라우저가 전송한 쿠키를 사용해서 필요한 작업을 수행
  	
 */
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		setCookieExam(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		super.doPost(req, resp);
	}
	
	
	private void setCookieExam(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/**
		 	쿠키 정보를 설정하는 방법...
		 	
		 	1. 쿠키객체를 생성 사용불가 문자(공백, [],()=,"/?@:;)
		 		Cookie cookie = new Cookie("키값", "value값");
		 		=> 이외의 값(예를 들면 한글)을 사용시에는 URLEncoder.encode()사용하여 인코딩 처리를 해준다
		 		
		 	2. 쿠키 최대 지속시간을 설정(초단위)
		 		=> 지정하지 않으면 웹브라우저를 종료할때 쿠키를 함께 삭제
		 		cookie.setMaxAge(60 * 60 * 24); // 24시간
		 		
	 		3. 응답헤더에 쿠키 객체를 추가한다
	 		response.addCokie(cookie);
	 		
	 		=> 출력버퍼가 플러시된 이후에는 쿠키를 추가할 수 없다
	 		(응답헤더를 통해서 웹브라우저에 전달하기 때문)
		 */
		
		// 쿠키 생성하기
		Cookie userId = new Cookie("userId", req.getParameter("userId"));
		// 쿠키값에 한글을 사용시 인코딩 처리를 해준다.
		Cookie name = new Cookie("name", URLEncoder.encode(req.getParameter("name"),"utf-8"));
		
		// 쿠키 소멸시간 설정(초단위) => 지정하지 않으면 웹브라우저를 종료할때 쿠키를 함께 삭제 
		userId.setMaxAge(60*60*24); //1일
		name.setMaxAge(60*60*48); //2일
		
		// 쿠키 추가하기
		resp.addCookie(userId);
		resp.addCookie(name);
		
		
		// 응답헤더에 인코딩 및 content-type설정
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String title = "쿠키설정 예제";
		out.println("<html><head><title>" + title + "</title></head>");
		out.println("<body>"
								+ "<h1 align=\"center\">" + title + "</h1>"
								+"<ul>"
								+"<li><b>ID</b>: "
								+req.getParameter("userId")
								+"</li>"
								+ "<li><b>이름</b>: "
								+req.getParameter("name")
								+"</li>"
								+"</ul></body></html>"
								);
				
	}
	

}
