package kr.or.ddit.post.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.comm.handler.CommandHandler;
import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.MemberVO;

public class PostHandler implements CommandHandler {
	
	private static final String VIEW_PAGE = "/WEB-INF/view/post/main_post.html";
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception, Exception {
		System.out.println("입장 PostinHaldler 입장");
		// 1. 서비스 객체 생성하기
		IMemberService memberService = MemberServiceImpl.getInstance();
		if("c".equals(req.getParameter("flag"))) {
			System.out.println("회원생성중회원생성중회원생성중회원생성중회원생성중회원생성중회원생성중회원생성중");
			System.out.println("test경로 들어옴");
			
			MemberVO mv = new MemberVO();
			mv.setMemId(req.getParameter("memId"));
			mv.setMemName(req.getParameter("memName"));
			mv.setMemPass(req.getParameter("memPass"));
			
			//새로운 방식 (req.map을 가지고 와서 memberVO에 넣어줘)
//			BeanUtils.populate(mv, req.getParameterMap());
			memberService.insertMember(mv);
		} else if("s".equals(req.getParameter("flag")) ){
			System.out.println("search중search중search중search중search중search중search중");
			MemberVO mv = new MemberVO();
			mv.setMemId(req.getParameter("memId"));
			memberService.getSearchMember(mv);
		} else if("u".equals(req.getParameter("flag")) ){
			System.out.println("update중update중update중update중update중update중update중update중");
			MemberVO mv = new MemberVO();
			mv.setMemId(req.getParameter("memId"));
			mv.setMemNickname(req.getParameter("memNicname"));
			memberService.updateMember(mv);
		} else if("d".equals(req.getParameter("flag")) ){
			System.out.println("delete중delete중delete중delete중delete중delete중delete중delete중");
			String deleteId = req.getParameter("memId");
			memberService.deleteMember(deleteId);
		}
		// 2. 할것들.
		System.out.println("퇴장 PostHaldler 퇴장");
		return VIEW_PAGE;
	}

}
