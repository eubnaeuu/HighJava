package kr.or.ddit.friend.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.comm.handler.CommandHandler;
import kr.or.ddit.friend.service.FriendService;
import kr.or.ddit.friend.service.FriendServiceImpl;
import kr.or.ddit.friend.vo.FriendVO;

public class UpdateFriendHandler implements CommandHandler {
		
	private static final String VIEW_PAGE = "/WEB-INF/view/friendreq/friendreqlist.html";
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception, Exception {
		
		System.out.println("입장 Friend Update Haldler 입장");
		
		FriendService FriendService = FriendServiceImpl.getInstance();
		
			System.out.println("update중update중update중update중update중update중update중");
			
			String userId = (String)req.getSession().getAttribute("userId");
			
			FriendVO fv = new FriendVO();
			fv.setFriendId(req.getParameter("friendId"));
			fv.setMemId(req.getParameter("memId"));
//			fv.setReqYn(req.getParameter("reqYn"));
			
			int cnt = FriendService.updateFriend(fv);
			
			String msg = "";
			
			if(cnt > 0) {
				msg = "성공";
			}else {
				msg = "실패";
			}
			

			return VIEW_PAGE;
		}
	}
