package kr.or.ddit.message.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.comm.handler.CommandHandler;
import kr.or.ddit.message.service.MessageService;
import kr.or.ddit.message.service.MessageServiceImpl;
import kr.or.ddit.message.vo.MessageVO;

public class InsertMessageHandler implements CommandHandler {
	
	private static final String VIEW_PAGE = "/WEB-INF/view/friend/insert.html";
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception, Exception {
		
		System.out.println("입장 Message insert Haldler 입장");
		
		if(req.getMethod().equals("GET")) { //GET방식인 경우 isRedirect을 하지 않는다
			return VIEW_PAGE;
		}else { //Message 방식인 경우 isRedirect를 한다 
		
			MessageService MessageService = MessageServiceImpl.getInstance();
			MessageVO mv = new MessageVO();
			
			/*
			messageNo     
			memId     
			receiveMem 
			messageContent
			messageDate 
			messageStatus
			*/
			
			mv.setMemId(req.getParameter("memId"));
			mv.setReceiveMem(req.getParameter("receiveMem"));
			mv.setMessageContent(req.getParameter("messageContent"));
			
			int cnt = MessageService.insertMessage(mv);
			
			String msg = "";
			
			if(cnt > 0) {
				msg = "성공";
			}else {
				msg = "실패";
			}
			
//			String redirectUrl = req.getContextPath() + "/Message/list.do?msg=" 
//					+ URLEncoder.encode(msg, "UTF-8");

			System.out.println("퇴장 Message insert Haldler 퇴장");

			return null;
		}
	}
}
