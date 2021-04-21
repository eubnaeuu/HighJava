package kr.or.ddit.post.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.comm.handler.CommandHandler;

public class PostMainHandler implements CommandHandler {
	
	private static final String VIEW_PAGE = "/WEB-INF/view/post/main_post.html";
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception, Exception {
		
		System.out.println("입장 Post Main Haldler 입장");

		System.out.println("퇴장 Post Main Haldler 퇴장");

			return VIEW_PAGE;
		}
	}
