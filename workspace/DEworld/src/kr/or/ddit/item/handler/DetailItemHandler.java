package kr.or.ddit.item.handler;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.comm.handler.CommandHandler;
import kr.or.ddit.item.service.IItemService;
import kr.or.ddit.item.service.ItemServiceImpl;
import kr.or.ddit.item.vo.ItemVO;

public class DetailItemHandler implements CommandHandler{
private static final String VIEW_PAGE = "/WEB-INF/view/item/itemDetail.jsp";
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) {	
		String flag = req.getParameter("flag");
		
		try {
			if("L".equals(flag)) { // 등록
				String itemId = req.getParameter("itemId");		
				IItemService itemService =  ItemServiceImpl.getInstance();
				ItemVO iv = itemService.getItem(itemId);
				req.setAttribute("itemVO", iv);
				return VIEW_PAGE;
			}
			else if("C".equals(flag)) { // 위시리스트 추가
				int resultCnt = insertWishlist(req);
				req.setAttribute("resultCnt", resultCnt);		
				return "/html/common/checkResult.jsp";
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return VIEW_PAGE;
	}

	private int insertWishlist(HttpServletRequest req) {
		IItemService itemService =  ItemServiceImpl.getInstance();
		String itemId = req.getParameter("itemId");		
		String memId = req.getParameter("memId");		
		
		ItemVO iv = new ItemVO();
		iv.setMemId(memId);
		iv.setItemId(itemId);
		
		int cnt = itemService.insertWishlist(iv);
		return cnt;
	}

}
