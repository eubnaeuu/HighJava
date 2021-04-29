package kr.or.ddit.itemcollection.handler;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.comm.handler.CommandHandler;
import kr.or.ddit.item.service.IItemCollectionService;
import kr.or.ddit.item.service.ItemCollectionServiceImpl;
import kr.or.ddit.item.vo.ItemCollectionVO;
import kr.or.ddit.member.service.ZipService;
import kr.or.ddit.member.vo.ZipVO;

public class ListItemHandler implements CommandHandler {
	
	private static final String VIEW_PAGE = "/WEB-INF/view/item/itemList.jsp";
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) {

		if(req.getMethod().equals("GET")) { //GET방식인 경우 isRedirect을 하지 않는다
			return VIEW_PAGE;
		}else {
		// 브라우저로 부터 받은 값을 사용하기 위해 request에서 parameter를 get.
			String flag = req.getParameter("flag");
			
			try {
				if("L".equals(flag)) { // 등록
					IItemCollectionService itemService =  ItemCollectionServiceImpl.getInstance();
					List<ItemCollectionVO> itemList = itemService.getAllItemList();
					req.setAttribute("itemList", itemList);
					return "/WEB-INF/view/item/itemListResult.jsp";
				}else if("S".equals(flag)) { // 검색
					String searchItemName = req.getParameter("searchItemName");
					IItemCollectionService itemService =  ItemCollectionServiceImpl.getInstance();
					List<ItemCollectionVO> itemList = itemService.getSearchItem(searchItemName);
					req.setAttribute("itemList", itemList);
					return "/WEB-INF/view/item/itemListResult.jsp";
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
		
	}

}
