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

			// 브라우저로 부터 받은 값을 사용하기 위해 request에서 parameter를 get.
			String itemId = req.getParameter("itemId");		
			// 회원정보 조회
			IItemService itemService =  ItemServiceImpl.getInstance();
			ItemVO iv = itemService.getItem(itemId);
			req.setAttribute("itemVO", iv);
			return VIEW_PAGE;
		
	}

}
