package kr.or.ddit.friendreq.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.comm.handler.CommandHandler;
import kr.or.ddit.friendreq.service.FriendReqService;
import kr.or.ddit.friendreq.service.FriendReqServiceImpl;
import kr.or.ddit.friendreq.vo.FriendReqVO;

public class ListFriendReqHandler implements CommandHandler {
		
	private static final String VIEW_PAGE = "/WEB-INF/view/friendreq/friendreqlist.jsp";
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception, Exception {
		
//		System.out.println("입장 FriendReqs Main Haldler 입장");

		FriendReqService FriendReqsService = FriendReqServiceImpl.getInstance();
	
			System.out.println("조회중 조회중 조회중 조회중 조회중 조회중 조회중 조회중 조회중 조회중 ");
			
			FriendReqVO fv = new FriendReqVO();
			
			
			String userId = (String)req.getSession().getAttribute("userId");
			
			fv.setFriendId(req.getParameter("friendReqId"));
			fv.setFriendId(userId);
			fv.setReqYn(req.getParameter("reqYn"));
			
			List<FriendReqVO> list = FriendReqsService.getSearchFriendReq(fv);
			
			req.setAttribute("friendreqlist", list);

			return VIEW_PAGE;
	}
}
