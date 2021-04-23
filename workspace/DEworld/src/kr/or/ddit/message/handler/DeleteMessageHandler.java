package kr.or.ddit.message.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.comm.handler.CommandHandler;
import kr.or.ddit.message.service.MessageService;
import kr.or.ddit.message.service.MessageServiceImpl;

public class DeleteMessageHandler implements CommandHandler {
		
	private static final String VIEW_PAGE = "/WEB-INF/view/message/messageview.jsp";
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception, Exception {
		
		System.out.println("입장 Delete Message Haldler 입장");

		
		MessageService MessageService = MessageServiceImpl.getInstance();
		

			String messageNo = req.getParameter("messageNo");
			
			int cnt = MessageService.deleteMessage(messageNo); // Message 삭제
			
	

		String msg = "";
		
		if(cnt > 0) {
			msg = "성공";
		}else {
			msg = "실패";
		}
		
//		String redirectUrl = req.getContextPath() + "/Message/mainMessage.do?msg=" 
//				+ URLEncoder.encode(msg, "UTF-8");
//		
		System.out.println("퇴장 Delete Message Haldler 퇴장");

		return VIEW_PAGE;
		}
	}
