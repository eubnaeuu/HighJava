package kr.or.ddit.member.handler;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;

import kr.or.ddit.comm.handler.CommandHandler;
import kr.or.ddit.comm.vo.AtchFileVO;
import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.MemberVO;
import util.FileUploadRequestWrapper;

public class UpdateMemberHandler implements CommandHandler {

	private static final String VIEW_PAGE = "/WEB-INF/view/member/listmember.html";
	
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
			
			String memId = req.getParameter("memId");
			
			// 1-1 회원정보 조회
			IMemberService service = 
					MemberServiceImpl.getInstance();
			MemberVO mv = service.getMember(memId);
			
			
			
			// 2. 모델정보 등록
			req.setAttribute("memVO", mv);
			
			return VIEW_PAGE;
			
		}else { // POST 방식인 경우
				
			MemberVO mv = new MemberVO();
			
			mv.setMemId(req.getParameter("memId"));
			mv.setMemNickname(req.getParameter("memNicname"));
			
			IMemberService memberService = MemberServiceImpl.getInstance();
			
			int cnt = memberService.updateMember(mv);
			
			String msg = "";
			if(cnt > 0) {
				msg = "성공";
			}else {
				msg = "실패";
			}
			
			// 4. 목록 조회화면으로 이동
//			String redirectUrl = req.getContextPath() + "/member/list.do?msg=" + URLEncoder.encode(msg, "UTF-8");
			
			return VIEW_PAGE;
		}
	}
}
