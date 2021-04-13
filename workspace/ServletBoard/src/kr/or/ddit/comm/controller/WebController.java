package kr.or.ddit.comm.controller;

import java.io.FileNotFoundException;
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

import kr.or.ddit.comm.handler.CommandHandler;
import kr.or.ddit.comm.handler.NullHandler;

public class WebController extends HttpServlet{

	private Map<String, CommandHandler> cmmHandlerMap = new HashMap<>();
	
	
	public void init(ServletConfig config) throws ServletException {
		
		//뿌리루트
		String configFilePath = config.getInitParameter("handler-config");
		
		//절대루트
		String configFileRealPath = config.getServletContext().getRealPath(configFilePath);
		
		FileReader fr;
		
		Properties handlerProp = new Properties();
		
		try {
				fr = new FileReader(configFileRealPath);
				handlerProp.load(fr);
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		for(Object key : handlerProp.keySet()) {
			String command = (String) key;
			
			try {
				Class<?> klass = Class.forName(handlerProp.getProperty(command));
				CommandHandler handler = (CommandHandler) klass.newInstance();
				cmmHandlerMap.put(command, handler);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new ServletException(); //☆ 
			}
		}
		Set<Map.Entry<String, CommandHandler>> entrySet = cmmHandlerMap.entrySet(); // Map객체가 Set형식으로 포함되는 건가?
		
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}

	private void process(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String reqURI = req.getRequestURI();
		if(reqURI.indexOf(req.getContextPath()) == 0) { // ☆  왜 0 이면 하는거지? 
			reqURI = reqURI.substring(req.getContextPath().length());
		}
		
		CommandHandler handler = cmmHandlerMap.get(reqURI);
		
		if(handler == null) {
			handler = new NullHandler();
		}
		String viewPage = "";
		
		try {
			viewPage = handler.process(req, resp); // 반환값 String
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		if(viewPage != null) {
			if(handler.isRedirect(req)) {
				resp.sendRedirect(viewPage);
			} else {
				RequestDispatcher dispatcher = req.getRequestDispatcher(viewPage);
				dispatcher.forward(req, resp);
			}
		}
				
		
	}
	
	
	
	
}
