package kr.or.ddit.guestbook.handler;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.comm.handler.CommandHandler;
import kr.or.ddit.guestbook.service.GuestBookService;
import kr.or.ddit.guestbook.service.GuestBookServiceImpl;
import kr.or.ddit.guestbook.vo.GuestBookVO;

public class InsertGuestBookHandler implements CommandHandler {
	
	private static final String VIEW_PAGE = "/WEB-INF/view/";

	@Override
	public boolean isRedirect(HttpServletRequest req) {
		if(req.getMethod().equals("GET")) { // Get방식인 경우.
			return false;
		}else { // POST 방식인 경우... 
			return true;
		}
	}
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception, Exception {
		
		System.out.println("입장 GuestBook insert Haldler 입장");
			
			GuestBookService guestbookService = GuestBookServiceImpl.getInstance();
			
			String userId = (String)req.getSession().getAttribute("userId");
			String hompiId = req.getParameter("hompiId");
			
			GuestBookVO gbv = new GuestBookVO();
			gbv.setGusetbookWriter(userId);
			gbv.setHompiId(req.getParameter("hompiId"));
			gbv.setGuestbookContent(req.getParameter("guestbookContent"));
			
			int cnt = guestbookService.insertGuestBook(gbv);
			String msg = "";
			
			if(cnt > 0) {
				msg = "성공";
			}else {
				msg = "실패";
			}
			String redirectUrl = req.getContextPath() + "/guestbook/list.do?hompiId="+hompiId;
			System.out.println("퇴장 GuestBook insert Haldler 퇴장");
			
			return redirectUrl;
			}
}
