package kr.or.ddit.member.handler;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.comm.handler.CommandHandler;
import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.MemberVO;

public class ListMemberHandler implements CommandHandler {
	
	private static final String VIEW_PAGE = "/member/list.jsp";
	
	@Override
	// redirect 방식이냐?
	public boolean isRedirect(HttpServletRequest req) {

		return false;
	}
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) {
// 1. 서비스 객체 생성하기
		IMemberService memberService = MemberServiceImpl.getInstance();
		List<MemberVO> memList = memberService.getAllMemberList();
		return null;
	}

}
