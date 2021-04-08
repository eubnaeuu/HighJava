package kr.or.ddit.basic;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 서블릿의 라이프사이클을 확인하기 위한 예제
 *  (서블릿이란? 컨테이너(서블릿엔진)에 의해 관리되는 자바기반 웹컴포넌트로서, 동적인 웹컨텐츠
 * 생성을 가능하게 해준다)
 */

public class T01_ServletLifeCycle extends HttpServlet {  //extends 는 기본임
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		//초기화 코드 작성...
		System.out.println("init() 호출됨.");
		super.init(config);
	}
	
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		
		// 실제적인 작업 수행이 시작되는 지점
		// (자바의 main메서드 역할)
		super.service(arg0, arg1);
		System.out.println("service() 호출됨.");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 메서드 방식이 get인 경우 호출됨
		System.out.println("doGet() 호출됨");
//		throw new ServletException("서블릿 예외 발생 됨"); // web.xml 55행 error 실행하기 위한 에러 고의 발생(T04내용)
//		super.doGet(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//메서드 방식이 post 인 경우에 호출됨
		System.out.println("doPost() 호출됨");
		
//		doGest(req, resp);
	}
	
	
	@Override
	public void destroy() {
		// 객체 소멸시 (컨테이너로부터 서블릿 객체 제거시)
		// 필요한 코드 작성...
		System.out.println("destroy() 호출됨.");
	}
	

}
