package kr.or.ddit.basic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class T05_ServletCookieTest  extends HttpServlet{
/**
  	쿠키 정보를 다루기 위한 예제
  	(웹서버와 브라우저는 애플리케이션을 사용하는 동안 필요한 값을 쿠키를 통해 공유하여 상태를 유지)
  	 (http의 특징이 비연결 지향형이기에 상대방 구분 매우 힘ㄷ름)
  	
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
		
		super.doGet(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		super.doGet(req, resp);
	}
	
	@Override
	public void destroy() {
	
		super.destroy();
	}
}
