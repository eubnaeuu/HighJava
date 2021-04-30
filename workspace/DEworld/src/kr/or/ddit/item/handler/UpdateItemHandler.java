package kr.or.ddit.item.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.comm.handler.CommandHandler;
import kr.or.ddit.item.vo.ItemVO;
import loginPage.service.MemberService;

public class UpdateItemHandler implements CommandHandler {
	
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
					String memId = req.getParameter("memId");
					String itemId = req.getParameter("itemId");
					
					System.out.println("updatehandelr ㄷㄹ어옴?");
					MemberService memberService = new MemberService();
					
					ItemVO iv = new ItemVO();
					iv.setMemId(memId);
					iv.setItemId(itemId);
					
					if("M".equals(flag)) {
						memberService.updateMinimi(iv);
					}else if("B".equals(flag)) {
						memberService.updateBg(iv);
					}
					
					return null;
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
		
	}

}
