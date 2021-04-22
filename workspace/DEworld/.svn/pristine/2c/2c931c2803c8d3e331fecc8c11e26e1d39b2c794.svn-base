package kr.or.ddit.item.handler;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.comm.handler.CommandHandler;
import kr.or.ddit.item.service.IItemService;
import kr.or.ddit.item.service.ItemServiceImpl;
import kr.or.ddit.item.vo.ItemVO;

public class ListItemHandler implements CommandHandler {
	
	private static final String VIEW_PAGE = "/WEB-INF/view/item/itemList.jsp";
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) {
		
		// 1. 서비스 객체 생성하기
		IItemService itemService =  ItemServiceImpl.getInstance();
		
		// 2. 아이템정보 조회
		List<ItemVO> itemList = itemService.getAllItemList();

		
		req.setAttribute("itemList", itemList);
		
		return VIEW_PAGE;
	}

}
