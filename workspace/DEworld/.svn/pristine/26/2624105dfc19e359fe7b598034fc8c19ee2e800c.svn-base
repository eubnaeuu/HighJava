package kr.or.ddit.faq.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.comm.handler.CommandHandler;
import kr.or.ddit.faq.service.FaqServiceImpl;
import kr.or.ddit.faq.service.IFaqService;
import kr.or.ddit.faq.vo.FaqVO;

public class ListFaqHandler implements CommandHandler {
	
	private static final String VIEW_PAGE = "/WEB-INF/view/faq/faqList.jsp";
	
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
						IFaqService faqService =  FaqServiceImpl.getInstance();
						List<FaqVO> faqList = faqService.getAllFaqList();
						req.setAttribute("faqList", faqList);
						return "/WEB-INF/view/faq/faqListResult.jsp";
					}
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return null;
		
	}

}
