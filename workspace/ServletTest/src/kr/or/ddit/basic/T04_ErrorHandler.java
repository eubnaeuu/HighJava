package kr.or.ddit.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 	에러(예외) 처리를 위한 서블릿 예제
 */
public class T04_ErrorHandler extends HttpServlet{
	
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// 예외 객체 (exception 발생하면 req의 attribute를 세팅) -> abc라는 Key에는 cdf값을 가지게끔 해놨음. 
	// 그래서 나중에 getAttribute(key) 메서드를 통해 가져올 수 있음 
	Throwable throwable = (Throwable) req.getAttribute("javax.servlet.error.exception"); // 해당 attribute의 value 반환ㄴ
	req.setAttribute("abc", "cdf"); // 다른 곳에서 abc속성(key값)에 cdf 값 저장
	System.out.println(req.getAttribute("abc")); // cdf 반환

	/*
	 * 에러상태, 에러발생 서블릿 이름, 에러발생 url 정보 가져오기  
	 */
	
	// 에러 상태 코드
	Integer statusCode = (Integer) req.getAttribute("javax.servlet.error.status_code");

	// 에러 발생한 서블릿 이름
	String servletName = (String) req.getAttribute("javax.servlet.error.servlet_name");
	if(servletName == null) {
		servletName = "알수 없는 서블릿";
	}
	
	// 에러발생 uri 정보
	String requestUri = (String) req.getAttribute("javax.servlet.error.request_uri");
	if(requestUri == null ) {
		requestUri = "알수없는 URI";
	}
	
	resp.setCharacterEncoding("UTF-8");
	resp.setContentType("text/html");
	
	PrintWriter out = resp.getWriter();
	String title = "Error/Exception 정보";
	
	out.println("<html>\n"
			+ "<html>\n"
			+ "<head><title>" + title + "</title></head>\n"
			+ "<body>\n");
	
	if(throwable == null && statusCode == null) {
		out.println("<h2>에러정보 없음</h2>");
		out.println("홈페이지로 돌아가기 : <a href=\""
				+ "http://localhost/ServletTest/"
				+ "\">홈페이지</a>");
	} else if(statusCode != null) {
		out.println("상태코드 : " + statusCode);
	} else {
		out.println("<h2>예외/에러 정보</h2>");
		out.println("서블릿 이름 : " + servletName + "<br><br>");
		out.println("예외 타입 ㅣ "  + throwable.getClass().getName()+"<br><br>");
		out.println("요청 URI : " + requestUri + "<br><br>" );
		out.println("예외 메시지 : " + throwable.getMessage());
	}
	out.println("</body>");
	out.println("</html>");
}

@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	doGet(req,resp);
	}
}
