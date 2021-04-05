package kr.or.ddit.basic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class T03_ServletParameterTest extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/**
		 	요청 객체로부터 파라미터 데이터 가져오는 
		 	
		 	- getParameter(파라미터명) : 파라미터값이 한개인 경우에 가져올 때 사용함(반환값 String) 
		 	 	-> url에 ?name="홍길동" 이 있다면 파라미터명은 name으로 가져올 수 있다( "홍길동" 반환)
		 	
		 	- getParameterValues(파라미터명) : 파라미터 값이 여러개인 경우, ex) checkbox (반환값 Arry)
		 	
		 	- getParameterNames() : request에 존재하는 모든 파라미터 정보를 가져올 때 사용함
		 	
		 */
		
		req.setCharacterEncoding("UTF-8");
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String gender = req.getParameter("gender");
		String hobby = req.getParameter("hobby");
		String rlgn = req.getParameter("rlgn");
		String[] food = req.getParameterValues("food");
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		
		PrintWriter out = resp.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("<p>username : "+ username + "</p>");
		out.print("<p>password : "+ password + "</p>");
		out.print("<p>gender : "+ gender + "</p>");
		out.print("<p>hobby : "+ hobby + "</p>");
		
		out.print("<p>rlgn : "+ rlgn + "</p>");
		
		if(food != null) {
			for(String s : food) {
				out.print("<p>food : " + s + "</p>");
			}
		}
		
		Enumeration<String> params = req.getParameterNames(); // Iterator 같은 거 
		while(params.hasMoreElements()) {
			String param = params.nextElement();
			out.println("<p>파라미터 이름 : " + param + "</p>");
		}
		
		out.println("</body>");
		out.println("</html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);
	}
	
	
}
