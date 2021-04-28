package kr.or.ddit.hompi.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.comm.handler.CommandHandler;
import kr.or.ddit.hompi.vo.HompiVO;

public class HompiHandler implements CommandHandler {
	
	private static final String VIEW_PAGE = "/html/hompi/hompi.jsp";
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception, Exception {
		System.out.println("입장 HompiHandler 입장");
		
		
		HompiVO hv = new HompiVO();
		
		String hompiId = req.getParameter("hompiId");
		String userId = (String)req.getSession().getAttribute("userId");
		hv.setHOMPI_ID(hompiId);
		
		req.setAttribute("hompiVO", hv);
		
		// 2. 할것들.
		System.out.println("퇴장 HompiHandler 퇴장");
		return VIEW_PAGE;
	}

}
