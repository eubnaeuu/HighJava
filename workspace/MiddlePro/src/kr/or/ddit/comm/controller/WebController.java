package kr.or.ddit.comm.controller;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import kr.or.ddit.comm.handler.CommandHandler;
import kr.or.ddit.comm.handler.NullHandler;

/**
 *  사용자 요청을 받아서 처리하는 컨트롤러 구현하기
 */
	
//새로운 방식 (req.map을 가지고 와서 memberVO에 넣어줘)
//		MemberVO memberVo = new MemberVO();
//		BeanUtils.populate(memberVo, req.getParameterMap());

public class WebController extends HttpServlet {
	
	private static Logger LOGGER = Logger.getLogger(WebController.class); 
	
	// 매핑정보 저장 (핸들러 객체 저장용 맵)
	private Map<String, CommandHandler> cmmHandlerMap = new HashMap<>();
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		String configFilePath = config.getInitParameter("handler-config");
		Properties handlerProp = new Properties();
		
		String configFileRealPath = config.getServletContext().getRealPath(configFilePath); // config 파일 경로 추출
		
		FileReader fr;
		
		try {
			fr = new FileReader(configFileRealPath);
			handlerProp.load(fr);
		}catch(IOException ex) {
			ex.printStackTrace();
		}
		
		for(Object key : handlerProp.keySet()) { 
			String command = (String) key;
			try {
				Class<?> klass = Class.forName(handlerProp.getProperty(command)); // ☆☆☆   
				CommandHandler handler = (CommandHandler) klass.newInstance(); // ☆☆☆

				// 핸들러 객체 등록
				cmmHandlerMap.put(command, handler); 
			}catch(Exception ex) {
				ex.printStackTrace();
				throw new ServletException();
			}
		}
		Set<Map.Entry<String, CommandHandler>> entrySet = cmmHandlerMap.entrySet();
		for(Map.Entry<String, CommandHandler> entry : entrySet) {
			LOGGER.info(entry.getKey() + " => " + entry.getValue()); 
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}
	/**
	 * 요청 처리 메서드
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void process(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String reqURI = req.getRequestURI(); 
		
		if(reqURI.indexOf(req.getContextPath()) == 0) {
			reqURI = reqURI.substring(req.getContextPath().length());
		}
		
		if(reqURI.equals("/member/list.do")) { // 회원목록 조회
			
		}else if(reqURI.equals("/member/insert.do")) {// 회원등록
			if(req.getMethod().equals("GET")) {
			
			}else if(req.getMethod().equals("POST")) {
			}
		}
		
		if(LOGGER.isInfoEnabled()) {
			LOGGER.info("command : " + reqURI); 
			LOGGER.info("cmmHandlerMap : " + cmmHandlerMap); 
		}
		
		CommandHandler handler = cmmHandlerMap.get(reqURI);
		
		if(handler == null) {
			handler = new NullHandler();
		}
		
		String viewPage = "";
		try {

			// 핸들러 처리부분
			viewPage = handler.process(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		LOGGER.info("viewPage : " + viewPage);
		
		// VIEW 화면 처리
		if(viewPage != null) {
			// 리다이렉트 처리가 필요한 경우
			if(handler.isRedirect(req)) { 
				resp.sendRedirect(viewPage);
			}else {
				RequestDispatcher dispatcher = req.getRequestDispatcher(viewPage);
				dispatcher.forward(req, resp);
			}
		}
	}
}
