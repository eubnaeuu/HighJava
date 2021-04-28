package kr.or.ddit.guestbook.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.comm.handler.CommandHandler;
import kr.or.ddit.guestbook.service.GuestBookService;
import kr.or.ddit.guestbook.service.GuestBookServiceImpl;
import kr.or.ddit.guestbook.vo.GuestBookVO;
import kr.or.ddit.paging.PagingVO;

public class ListGuestBookHandler implements CommandHandler {

	private static final String VIEW_PAGE = "/WEB-INF/view/guestbook/guestbooklist.jsp";

	@Override
	public boolean isRedirect(HttpServletRequest req) {
		if (req.getMethod().equals("GET")) { // Get방식인 경우.
			return false;
		} else { // POST 방식인 경우...
			return true;
		}
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception, Exception {

		System.out.println("입장 GuestBook List Haldler 입장");

		int pageNo = req.getParameter("pageNo") == null ? 1 : Integer.parseInt(req.getParameter("pageNo"));

		PagingVO pagingVO = new PagingVO();

		GuestBookService guestbookService = GuestBookServiceImpl.getInstance();

		String hompiId = req.getParameter("hompiId");

		GuestBookVO gbv = new GuestBookVO();

		int totalCount = 0;

		gbv.setHompiId(hompiId);

		totalCount = guestbookService.getAllGuestBookListCount(gbv);

		gbv.setTotalCount(totalCount);
		gbv.setCurrentPageNo(pageNo);
		gbv.setCountPerPage(5);
		gbv.setPageSize(5);

		pagingVO.setTotalCount(totalCount);
		pagingVO.setCurrentPageNo(pageNo);
		pagingVO.setCountPerPage(5);
		pagingVO.setPageSize(5);

		List<GuestBookVO> list = guestbookService.getSearchGuestBook(gbv);

		req.setAttribute("guestbooklist", list);
		req.setAttribute("pagingVO", pagingVO);
		req.setAttribute("hompiId", hompiId);

		return VIEW_PAGE;

	}
}
