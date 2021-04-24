package kr.or.ddit.message.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.comm.handler.CommandHandler;
import kr.or.ddit.message.service.MessageService;
import kr.or.ddit.message.service.MessageServiceImpl;
import kr.or.ddit.message.vo.MessageVO;



public class ViewMessageHandler implements CommandHandler{

	private static final String VIEW_PAGE = "/WEB-INF/view/message/select.jsp";
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		String messageNo = req.getParameter("messageNo");
		// 회원정보 조회
		MessageService messageService = MessageServiceImpl.getInstance();
		MessageVO messageVo = new MessageVO(); 
		messageVo.setMessageNo(Long.valueOf(messageNo));
		List<MessageVO> list = messageService.getSearchMessage(messageVo);
		
	
		req.setAttribute("list", list);
		
		return VIEW_PAGE;
	}

}
