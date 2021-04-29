package kr.or.ddit.buy.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.buy.service.BuyServiceImpl;
import kr.or.ddit.buy.service.IBuyService;
import kr.or.ddit.buy.vo.BuyVO;
import kr.or.ddit.comm.handler.CommandHandler;
import kr.or.ddit.whishlist.service.IWhishlistService;
import kr.or.ddit.whishlist.service.WhishlistServiceImpl;
import kr.or.ddit.whishlist.vo.WhishlistVO;

public class ListBuyHandler implements CommandHandler {
	
	private static String VIEW_PAGE = "/WEB-INF/view/buy/buyList.jsp";
	
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
					IBuyService buyService =  BuyServiceImpl.getInstance();
					BuyVO wv = new BuyVO();
					wv.setMemId(memId);
					List<BuyVO> buyList = buyService.getAllBuyList(wv);
					req.setAttribute("buyList", buyList);
					return "/WEB-INF/view/buy/buyListResult.jsp";
				}
				else if("ML".equals(flag)) { // 불러오기
					String memId = req.getParameter("memId");
					IBuyService buyService =  BuyServiceImpl.getInstance();
					BuyVO wv = new BuyVO();
					wv.setMemId(memId);
					List<BuyVO> buyList = buyService.getMusicAllBuyList(wv);
					req.setAttribute("buyList", buyList);
					return "/WEB-INF/view/buy/musicbuyListResult.jsp";
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return VIEW_PAGE;
		
	}

}
