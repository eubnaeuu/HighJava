package kr.or.ddit.friendreq.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.comm.handler.CommandHandler;
import kr.or.ddit.friendreq.service.FriendReqService;
import kr.or.ddit.friendreq.service.FriendReqServiceImpl;
import kr.or.ddit.friendreq.vo.FriendReqVO;

public class InsertFriendReqHandler implements CommandHandler {
	
	private static final String VIEW_PAGE = "/WEB-INF/view/friendreq/friendreqinsert.jsp";
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		if(req.getMethod().equals("GET")) {
			return false;
		}else {
			return true;
		}
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception, Exception {
		
		System.out.println("입장 FriendReq insert Haldler 입장");
		
		if(req.getMethod().equals("GET")) { //GET방식인 경우 isRedirect을 하지 않는다
			
			return VIEW_PAGE;
		}else { //Friend 방식인 경우 isRedirect를 한다 
		
			FriendReqService FriendreqService = FriendReqServiceImpl.getInstance();
			FriendReqVO frv = new FriendReqVO();
			frv.setFriendId(req.getParameter("friendId"));
			frv.setMemId(req.getParameter("memId"));
			
			int cnt = FriendreqService.insertFriendReq(frv);

			
			String msg = "";
			
			if(cnt > 0) {
				msg = "성공";
			}else {
				msg = "실패";
			}
			
			System.out.println("퇴장 FriendReq insert Haldler 퇴장");

			String redirectUrl = "/DEworld/friend/list.do";
			
			return redirectUrl;
		}
	}
}
