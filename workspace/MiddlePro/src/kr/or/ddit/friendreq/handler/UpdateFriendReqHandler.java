package kr.or.ddit.friendreq.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.comm.handler.CommandHandler;
import kr.or.ddit.friend.service.FriendService;
import kr.or.ddit.friend.service.FriendServiceImpl;
import kr.or.ddit.friend.vo.FriendVO;
import kr.or.ddit.friendreq.service.FriendReqService;
import kr.or.ddit.friendreq.service.FriendReqServiceImpl;
import kr.or.ddit.friendreq.vo.FriendReqVO;

public class UpdateFriendReqHandler implements CommandHandler {
		
	private static final String VIEW_PAGE = "/WEB-INF/view/friendreq/list.html";
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception, Exception {
		
//		System.out.println("입장 FriendReq Main Haldler 입장");
		
		FriendReqService friendReqService = FriendReqServiceImpl.getInstance();
		
			System.out.println("update중update중update중update중update중update중update중");
			
			FriendReqVO frv = new FriendReqVO();
			frv.setFriendId(req.getParameter("friendId"));
			frv.setMemId(req.getParameter("memId"));
			frv.setReqYn(req.getParameter("reqYn"));
			
			
			// 일촌목록 추가
			FriendVO fv = new FriendVO();
			FriendService friendService = FriendServiceImpl.getInstance();
			
			fv.setFriendId(req.getParameter("friendId"));
			fv.setMemId(req.getParameter("memId"));
			
			int cnt = friendReqService.updateFriendReq(frv);
			int cnt2 = friendService.insertFriend(fv);
			
			String msg = "";
			
			if(cnt > 0 && cnt2 > 0) {
				msg = "성공";
			}else {
				msg = "실패";
			}
			
//			String redirectUrl = req.getContextPath() + "/FriendReq/list.do?msg=" 
//					+ URLEncoder.encode(msg, "UTF-8");

//			System.out.println("퇴장 FriendReq insert Haldler 퇴장");

			return VIEW_PAGE;
		}
	}
