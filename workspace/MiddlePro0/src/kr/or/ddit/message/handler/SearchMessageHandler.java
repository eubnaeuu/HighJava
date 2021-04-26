package kr.or.ddit.message.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.comm.handler.CommandHandler;
import kr.or.ddit.message.service.MessageService;
import kr.or.ddit.message.service.MessageServiceImpl;
import kr.or.ddit.message.vo.MessageVO;

public class SearchMessageHandler implements CommandHandler {
		
	private static final String VIEW_PAGE = "/comm/common.jsp";
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception, Exception {
		
		System.out.println("입장 Message Search Haldler 입장");
		
		MessageService MessageService = MessageServiceImpl.getInstance();
	
			MessageVO mv = new MessageVO();
			
			mv.setMessageStatus(req.getParameter("messageStatus"));
			mv.setMessageDate(req.getParameter("messageDate"));
			mv.setMessageNo(Long.valueOf(req.getParameter("messageNo")));
			
			List<MessageVO> list = MessageService.getSearchMessage(mv);
			
			System.out.println("퇴장 Message Search Haldler 퇴장");
			
			
			return VIEW_PAGE;
		}
	}
