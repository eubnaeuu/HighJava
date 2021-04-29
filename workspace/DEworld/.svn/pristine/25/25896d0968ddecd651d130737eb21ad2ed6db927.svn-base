package kr.or.ddit.giftbox.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.comm.handler.CommandHandler;
import kr.or.ddit.giftbox.service.GiftboxServiceImpl;
import kr.or.ddit.giftbox.service.IGiftboxService;
import kr.or.ddit.giftbox.vo.GiftboxVO;
import kr.or.ddit.whishlist.service.IWhishlistService;
import kr.or.ddit.whishlist.service.WhishlistServiceImpl;
import kr.or.ddit.whishlist.vo.WhishlistVO;

public class ListGiftboxHandler implements CommandHandler {
	
	private static final String VIEW_PAGE = "/WEB-INF/view/giftbox/giftboxList.jsp";
	
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
					String memId = req.getParameter("memId");
					GiftboxVO gv = new GiftboxVO();
					gv.setMemId(memId);
					IGiftboxService giftboxService =  GiftboxServiceImpl.getInstance();
					List<GiftboxVO> giftboxList = giftboxService.getAllGiftboxList(gv);
					req.setAttribute("giftboxList", giftboxList);
					return "/WEB-INF/view/giftbox/giftboxListResult.jsp";
				}
				else if("ML".equals(flag)) { // 등록
					String memId = req.getParameter("memId");
					GiftboxVO gv = new GiftboxVO();
					gv.setMemId(memId);
					IGiftboxService giftboxService =  GiftboxServiceImpl.getInstance();
					List<GiftboxVO> giftboxList = giftboxService.getMusicAllGiftboxList(gv);
					req.setAttribute("giftboxList", giftboxList);
					return "/WEB-INF/view/giftbox/musicgiftboxListResult.jsp";
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return VIEW_PAGE;
		
	}

}
