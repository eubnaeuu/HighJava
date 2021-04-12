package kr.or.ddit.comm.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CommandHandler {

	
	/**
	 * 리다이렉트 필요여부 ( true -> redirect / false -> forward) 
	 * @param req
	 * @return
	 */
public boolean isRedirect (HttpServletRequest req);
	

/**
 * 
 * @param req
 * @param resp
 * @return
 * @throws Exception
 */
public String process (HttpServletRequest req, HttpServletResponse resp) throws Exception;
}
