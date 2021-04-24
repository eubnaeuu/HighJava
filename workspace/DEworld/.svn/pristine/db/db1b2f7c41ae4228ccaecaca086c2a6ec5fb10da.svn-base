package kr.or.ddit.faq.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.comm.handler.CommandHandler;
import kr.or.ddit.faq.service.FaqServiceImpl;
import kr.or.ddit.faq.service.IFaqService;
import kr.or.ddit.faq.vo.FaqVO;

public class DetailFaqHandler implements CommandHandler{
private static final String VIEW_PAGE = "/WEB-INF/view/faq/faqDetail.jsp";
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) {

			// 브라우저로 부터 받은 값을 사용하기 위해 request에서 parameter를 get.
			String faqId = req.getParameter("faqId");		
			// 회원정보 조회
			IFaqService faqService =  FaqServiceImpl.getInstance();
			FaqVO iv = faqService.getFaq(faqId);
			req.setAttribute("faqVO", iv);
			return VIEW_PAGE;
		
	}

}
