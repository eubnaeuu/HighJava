package kr.or.ddit.member.controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.MemberVO;

public class InsertMemberServlet extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	RequestDispatcher dispatcher = req.getRequestDispatcher("/member/insertForm.jsp");
	dispatcher.forward(req, resp);
	
	
}

@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. 요청파라미터 정보 가져오기
		String memId = req.getParameter("memId");
		String memName = req.getParameter("memName");
		String memTel = req.getParameter("memTel");
		String memAddr = req.getParameter("memAddr");
		
		
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
		resp.sendRedirect(redirectUrl);
		
		//4-2 회원가입하고 나면 insert.do로 리스트가 불러진다(view이용)
//		req.getRequestDispatcher("/member/list.do?msg="+ URLEncoder.encode(msg, "UTF-8")).forward(req, resp);
	}
}
