package kr.or.ddit.friend.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.comm.handler.CommandHandler;
import kr.or.ddit.friend.service.FriendService;
import kr.or.ddit.friend.service.FriendServiceImpl;
import kr.or.ddit.friend.vo.FriendVO;
import kr.or.ddit.friendreq.service.FriendReqService;
import kr.or.ddit.friendreq.vo.FriendReqVO;

public class ListFriendHandler implements CommandHandler {
		
	private static final String VIEW_PAGE = "/WEB-INF/view/friend/friendlist.jsp";
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception, Exception {
		
		System.out.println("입장 Friend List Haldler 입장");
		
		FriendService FriendService = FriendServiceImpl.getInstance();
			
			FriendVO fv = new FriendVO();
			
			String userId = (String)req.getSession().getAttribute("userId");
			
			fv.setMemId(userId);
			fv.setFriendId(req.getParameter("friendId"));
			fv.setFriendDate(req.getParameter("friendDate"));
			
			List<FriendVO> list = FriendService.getSearchFriend(fv);
			
			req.setAttribute("friendlist", list);
			
			System.out.println("퇴장 Friend List Haldler 퇴장");

			return VIEW_PAGE;
		}
	}
