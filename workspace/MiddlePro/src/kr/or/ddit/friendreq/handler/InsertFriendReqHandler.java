package kr.or.ddit.friendreq.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.comm.handler.CommandHandler;
import kr.or.ddit.friendreq.service.FriendReqService;
import kr.or.ddit.friendreq.service.FriendReqServiceImpl;
import kr.or.ddit.friendreq.vo.FriendReqVO;

public class InsertFriendReqHandler implements CommandHandler {
	
	private static final String VIEW_PAGE = "/WEB-INF/view/friendreq/list.html";
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception, Exception {
		
		System.out.println("입장 FriendReq insert Haldler 입장");
		
		if(req.getMethod().equals("GET")) { //GET방식인 경우 isRedirect을 하지 않는다
			return VIEW_PAGE;
		}else { //FriendReq 방식인 경우 isRedirect를 한다 
		
			FriendReqService FriendReqService = FriendReqServiceImpl.getInstance();
			FriendReqVO fv = new FriendReqVO();
			fv.setFriendId(req.getParameter("friendId"));
			fv.setMemId(req.getParameter("memId"));
			fv.setReqYn(req.getParameter("reqYn"));
			
			int cnt = FriendReqService.insertFriendReq(fv);
			
			String msg = "";
			
			if(cnt > 0) {
				msg = "성공";
			}else {
				msg = "실패";
			}
			
//			String redirectUrl = req.getContextPath() + "/FriendReq/list.do?msg=" 
//					+ URLEncoder.encode(msg, "UTF-8");

			System.out.println("퇴장 FriendReq insert Haldler 퇴장");

			return VIEW_PAGE;
		}
	}
}
