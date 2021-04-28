package kr.or.ddit.message.handler;

import java.net.URLDecoder;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.comm.handler.CommandHandler;
import kr.or.ddit.comm.service.AtchFileServiceImpl;
import kr.or.ddit.comm.service.IAtchFileService;
import kr.or.ddit.message.service.MessageService;
import kr.or.ddit.message.service.MessageServiceImpl;
import kr.or.ddit.message.vo.MessageVO;
import kr.or.ddit.paging.PagingVO;
import kr.or.ddit.post.service.PostService;
import kr.or.ddit.post.service.PostServiceImpl;
import kr.or.ddit.post.vo.PostVO;

public class SearchMessageHandler implements CommandHandler {
		
	private static final String VIEW_PAGE = "/WEB-INF/view/message/messagelist.jsp";
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		if(req.getMethod().equals("GET")) { // Get방식인 경우.
			return false;
		}else { // POST 방식인 경우... 
			return true;
		}
	}


	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception, Exception {
		if(req.getMethod().equals("GET")) { //GET방식인 경우 isRedirect을 하지 않는다
			System.out.println("입장 Message Search Haldler 입장GET");
			
			String userId = (String)req.getSession().getAttribute("userId");
			MessageVO mv = new MessageVO();
			MessageService messageService = MessageServiceImpl.getInstance();
			
			mv.setReceiveMem(userId);
			
			if(req.getParameter("memId")!= null) {
				String memId = req.getParameter("memId");
				mv.setMemId(memId);
			}else if(req.getParameter("messageContent")!= null) {
				String messageContent = req.getParameter("messageContent");
				mv.setMessageContent(messageContent);
			}
			
			 int pageNo = 
				       req.getParameter("pageNo") == null ? 
				       1 : Integer.parseInt(req.getParameter("pageNo"));
				    
				    PagingVO pagingVO = new PagingVO();
			
			
			  int totalCount = messageService.getAllMessageListCount(mv);
			    pagingVO.setTotalCount(totalCount);
			    pagingVO.setCurrentPageNo(pageNo);
			    pagingVO.setCountPerPage(10);
			    pagingVO.setPageSize(10);
				
			
			String flag = req.getParameter("flag");

			  List<MessageVO> messagelist = messageService.getSearchMessage(mv);
			  
			   req.setAttribute("messagelist", messagelist);
			   req.setAttribute("pagingVO", pagingVO);
			   
			return VIEW_PAGE;
			
			
		}else {
		System.out.println("입장 Message Search Haldler 입장POST");
		
		MessageService messageService = MessageServiceImpl.getInstance();
	
			MessageVO mv = new MessageVO();
			
			mv.setMessageStatus(req.getParameter("messageStatus"));
			mv.setMessageDate(req.getParameter("messageDate"));
			mv.setMessageNo(Long.valueOf(req.getParameter("messageNo")));
			
			List<MessageVO> list = messageService.getSearchMessage(mv);
			
			System.out.println("퇴장 Message Search Haldler 퇴장");
			
			
			return VIEW_PAGE;
		}
	}
}
