package kr.or.ddit.message.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.comm.handler.CommandHandler;
import kr.or.ddit.comm.service.AtchFileServiceImpl;
import kr.or.ddit.comm.service.IAtchFileService;
import kr.or.ddit.comm.vo.AtchFileVO;
import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.MemberVO;

public class ViewMessageHandler implements CommandHandler{

	private static final String VIEW_PAGE = "/WEB-INF/view/message/messageview.jsp";
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}
	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		
		return VIEW_PAGE;
	}

}
