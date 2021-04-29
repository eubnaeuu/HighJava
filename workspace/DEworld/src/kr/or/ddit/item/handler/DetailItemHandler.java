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
			if("L".equals(flag)) { // 상세정보 불러오기
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
			else if("GF".equals(flag)) { // 친구목록 불러오기
				String memId = req.getParameter("memId");		
				IItemService itemService =  ItemServiceImpl.getInstance();
				List<ItemVO> friendList = itemService.getFriendList(memId);
//				System.out.println(friendList.get(0).getFriendId());
				req.setAttribute("friendList", friendList);
				return "/WEB-INF/view/item/friendListResult.jsp";
			}
			else if("BUY".equals(flag)) { // 구매
				String memId = req.getParameter("memId");
				String itemId =  req.getParameter("itemId");
				IItemService itemService =  ItemServiceImpl.getInstance();
				
				ItemVO iv = new ItemVO();
				iv.setMemId(memId);
				iv.setItemId(itemId);
				
				int resultCnt = itemService.buyItem(iv);
				
				req.setAttribute("resultCnt", resultCnt);		
				return "/html/common/checkResult.jsp";
				
			}
			else if("SENDGF".equals(flag)) { // 선물보내기
				String memId = req.getParameter("memId");
				String friendId = req.getParameter("friendId");
				String itemId =  req.getParameter("itemId");
				String giftMessage =  req.getParameter("giftMessage");
				String litemGu = req.getParameter("litemGu");
				IItemService itemService =  ItemServiceImpl.getInstance();
				
				ItemVO iv = new ItemVO();
				iv.setMemId(memId);
				iv.setFriendId(friendId);
				iv.setItemId(itemId);
				iv.setGiftMessage(giftMessage);
				iv.setLitemGu(litemGu);
				
				int resultCnt = itemService.giftItem(iv);
				
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
		String litemGu = req.getParameter("litemGu");		
		
		ItemVO iv = new ItemVO();
		iv.setMemId(memId);
		iv.setItemId(itemId);
		iv.setLitemGu(litemGu);
		
		int cnt = itemService.insertWishlist(iv);
		return cnt;
	}

}
