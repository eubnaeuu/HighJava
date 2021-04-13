package kr.or.ddit.comm.controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import kr.or.ddit.comm.handler.CommandHandler;

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
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}
	
}
