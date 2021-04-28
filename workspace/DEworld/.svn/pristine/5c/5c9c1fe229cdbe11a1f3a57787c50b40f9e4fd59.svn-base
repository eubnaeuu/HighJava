package kr.or.ddit.friendreq.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.comm.handler.CommandHandler;
import kr.or.ddit.friendreq.service.FriendReqService;
import kr.or.ddit.friendreq.service.FriendReqServiceImpl;
import kr.or.ddit.friendreq.vo.FriendReqVO;

public class DeleteFriendReqHandler implements CommandHandler {
		
	private static final String VIEW_PAGE = "/WEB-INF/view/friendreq/friendreqlist.html";
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception, Exception {
		
		System.out.println("입장 Delete FriendReq Haldler 입장");

		
		FriendReqService FriendReqService = FriendReqServiceImpl.getInstance();
		FriendReqVO fv = new FriendReqVO();
			System.out.println("delete중delete중delete중delete중delete중delete중delete중delete중");

			String userId = (String)req.getSession().getAttribute("userId");
		
			String memId = req.getParameter("memId");
			
			fv.setFriendId(memId);
			fv.setMemId(userId);
			
			int cnt = FriendReqService.deleteFriendReq(fv); // FriendReq 삭제
			
	
		System.out.println("퇴장 Delete FriendReq Haldler 퇴장");

		String msg = "";
		
		if(cnt > 0) {
			msg = "성공";
		}else {
			msg = "실패";
		}
		
//		String redirectUrl = req.getContextPath() + "/FriendReq/mainFriendReq.do?msg=" 
//				+ URLEncoder.encode(msg, "UTF-8");
//		
		System.out.println("퇴장 FriendReq insert Haldler 퇴장");

		return VIEW_PAGE;
		}
	}
