package kr.or.ddit.friend.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.comm.handler.CommandHandler;
import kr.or.ddit.friend.service.FriendService;
import kr.or.ddit.friend.service.FriendServiceImpl;
import kr.or.ddit.friend.vo.FriendVO;
import kr.or.ddit.friendreq.service.FriendReqService;
import kr.or.ddit.friendreq.service.FriendReqServiceImpl;
import kr.or.ddit.friendreq.vo.FriendReqVO;

public class InsertFriendHandler implements CommandHandler {
	
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
		
		System.out.println("입장 Friend insert Haldler 입장");
		
		if(req.getMethod().equals("GET")) { //GET방식인 경우 isRedirect을 하지 않는다
			
			if(req.getParameter("friendId").equals("")) {
				return VIEW_PAGE;
				
			}else {
				

				FriendService FriendService = FriendServiceImpl.getInstance();
				FriendVO fv = new FriendVO();
				
				String userId = (String)req.getSession().getAttribute("userId");
				
				fv.setMemId(userId);
				fv.setFriendId(req.getParameter("friendId"));
				
				int cnt = FriendService.insertFriend(fv);
				
				String msg = "";
				
				if(cnt > 0) {
					msg = "성공";
				}else {
					msg = "실패";
				}
				

				FriendReqService friendreqService = FriendReqServiceImpl.getInstance();
				FriendReqVO frv = new FriendReqVO();
				frv.setFriendId(userId);
				frv.setMemId(req.getParameter("friendId"));
				
				friendreqService.deleteFriendReq(frv);
				
				System.out.println("퇴장 Friend insert Haldler1 퇴장");
				
				String redirectUrl = "/DEworld/friendreq/list.do";
				return redirectUrl;

				
			}
		}else { //Friend 방식인 경우 isRedirect를 한다 
		
			FriendService FriendService = FriendServiceImpl.getInstance();
			FriendVO fv = new FriendVO();
			
			String userId = (String)req.getSession().getAttribute("userId");
			
			fv.setMemId(userId);
			fv.setFriendId(req.getParameter("friendId"));
			
			int cnt = FriendService.insertFriend(fv);
			
			FriendReqService friendreqService = FriendReqServiceImpl.getInstance();
			FriendReqVO frv = new FriendReqVO();
			frv.setFriendId(userId);
			frv.setMemId(req.getParameter("friendId"));
			
			friendreqService.deleteFriendReq(frv);
			
			String msg = "";
			
			if(cnt > 0) {
				msg = "성공";
			}else {
				msg = "실패";
			}
			
			System.out.println("퇴장 Friend insert Haldler2 퇴장");

			String redirectUrl = "/DEworld/friendreq/list.do";
			
			return redirectUrl;
		}
	}
}
