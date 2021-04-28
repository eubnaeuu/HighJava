package kr.or.ddit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.comm.handler.CommandHandler;
import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;

public class MainHandler implements CommandHandler {
	
	private static final String VIEW_PAGE = "/WEB-INF/mainPage/topic.jsp";
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception, Exception {
		System.out.println("입장 MainHaldler 입장");
		// 1. 서비스 객체 생성하기
		IMemberService memberService = MemberServiceImpl.getInstance();

		// 2. 할것들.
		System.out.println("퇴장 MainHaldler 퇴장");
		return VIEW_PAGE;
	}

}
