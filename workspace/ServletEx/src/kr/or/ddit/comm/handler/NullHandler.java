package kr.or.ddit.comm.handler;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 해당 요청을 처리할 핸들러를 발견하지 못한 경우 호출
 */
public class NullHandler implements CommandHandler{

	@Override
	public boolean isRedirect(HttpServletRequest req) throws IOException, Exception {
		return false;
	}

	
	// 
	//정하지 않은 URI로 요청을 하는 경우
	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws IOException, Exception {
		resp.sendError(HttpServletResponse.SC_NOT_FOUND); //SC_NOT_FOUND : 404
		
		return null;
	}

}
