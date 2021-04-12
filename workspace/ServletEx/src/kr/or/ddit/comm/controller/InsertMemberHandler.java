package kr.or.ddit.comm.controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.comm.handler.CommandHandler;
import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.MemberVO;

public class InsertMemberHandler implements CommandHandler{
	
	
	private static final String PAGE_VIEW = "/member/insertmember.jsp";
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		if(req.getMethod().equals("GET")) { // GET방식 인경우...
			return false;
		} else { // POST방식인 경우...
			return true;
		}
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		if(req.getMethod().equals("GET")) {
			// 1. 요청파라미터 정보 가져오기
			String memId = req.getParameter("memId");
			String memName = req.getParameter("memName");
			String memTel = req.getParameter("memTel");
			String memAddr = req.getParameter("memAddr");
			
			System.out.println(memId);
			System.out.println(memName);
			System.out.println(memTel);
			System.out.println(memAddr);
			
			//2. 서비스 객체 생성하기
			IMemberService memberService = MemberServiceImpl.getInstance();
			
			//3. 회원정보 등록하기
			MemberVO mv = new MemberVO();
			mv.setMemId(memId);
			mv.setMemName(memName);
			mv.setMemAddr(memAddr);
			mv.setMemTel(memTel);
			
			int cnt = memberService.insertMember(mv);
			
			String msg = "";
			if(cnt > 0) {
				msg = "성공";
				
			}else {
				msg = "실패";
			}
			// 4. 목록 조회하면으로 이동
			//4-1 redirect => 목록조회list.do를 조회함
			String redirectUrl = req.getContextPath() + "/member/list.do?msg="+ URLEncoder.encode(msg, "UTF-8");
			return redirectUrl;
		}else{
			return null;
		}
	}

}
