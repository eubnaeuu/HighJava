package kr.or.ddit.board.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.comm.handler.CommandHandler;

public class InsertBoardHandler implements CommandHandler{

	private static final String VIEW_PAGE
					= "/WEB-INF/view/board/"
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		if(req.getMethod().equals("GET")) {
			return false;
		}else {
			return true;
		}
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		if(req.getMethod().equals("GET")) {
			return VIEW_PAGE;
		} else {
			// POST 방식인 경우
			
			
			
		}
		
		return VIEW_PAGE;
	}

}
