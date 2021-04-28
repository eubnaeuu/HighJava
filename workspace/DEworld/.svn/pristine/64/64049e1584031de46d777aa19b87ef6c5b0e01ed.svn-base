package kr.or.ddit.message.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.comm.handler.CommandHandler;
import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.message.service.MessageService;
import kr.or.ddit.message.service.MessageServiceImpl;
import kr.or.ddit.message.vo.MessageVO;



public class ViewMessageHandler implements CommandHandler{

	private static final String VIEW_PAGE = "/WEB-INF/view/message/messageview.jsp";
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		String messageNo = req.getParameter("messageNo");
		
		MessageService messageService = MessageServiceImpl.getInstance();
		MessageVO messageVo = new MessageVO(); 
		messageVo.setMessageNo(Long.valueOf(messageNo));
		MessageVO mv = messageService.getViewMessage(messageVo);
		
		String userId = (String)req.getSession().getAttribute("userId");
		userId = userId.trim();
		IMemberService memberService = MemberServiceImpl.getInstance();
		
		if("N".equals(mv.getMessageStatus().trim())){
			System.out.println("여기로 왜안들어옴?"+userId);
			System.out.println("여기로 왜안들어옴?"+mv.getReceiveMem());
			if(userId.equals(mv.getReceiveMem())){
				System.out.println("여기로 왜안들어옴2?");
				messageService.updateMessage(messageVo);
			}
		}
		req.setAttribute("messageview", mv);
		
		return VIEW_PAGE;
	}

}
