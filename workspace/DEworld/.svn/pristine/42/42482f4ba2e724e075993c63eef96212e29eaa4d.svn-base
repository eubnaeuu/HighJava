package kr.or.ddit.message.handler;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.comm.handler.CommandHandler;
import kr.or.ddit.message.service.MessageService;
import kr.or.ddit.message.service.MessageServiceImpl;
import kr.or.ddit.message.vo.MessageVO;
import kr.or.ddit.paging.PagingVO;

public class ListMessageHandler implements CommandHandler {
		
	private static final String VIEW_PAGE = "/WEB-INF/view/message/list.jsp";
	
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
		
		System.out.println("입장 Messages Main Haldler 입장");

		
		MessageService messageService = MessageServiceImpl.getInstance();

		 int pageNo = 
			       req.getParameter("pageNo") == null ? 
			       1 : Integer.parseInt(req.getParameter("pageNo"));
			    
			    PagingVO pagingVO = new PagingVO();
			    
			    int totalCount = messageService.getAllMessageListCount();
			    
			    pagingVO.setTotalCount(totalCount);
			    pagingVO.setCurrentPageNo(pageNo);
			    pagingVO.setCountPerPage(5);
			    pagingVO.setPageSize(5);
				
			List<MessageVO> list = messageService.getAllMessageList();
//			Gson gson = new Gson();
//			String strJson =  gson.toJson(list);
//			
//			resp.setContentType("application/json");
//			resp.setCharacterEncoding("UTF-8");
//			
//			System.out.println(strJson);
//			
//			PrintWriter out = resp.getWriter();
//			out.print(strJson);
			
			req.setAttribute("list", list);
			req.setAttribute("pagingVO", pagingVO);
//			req.setAttribute("strJson", strJson);
			
			System.out.println("퇴장 Messages Main Haldler 퇴장");
			return VIEW_PAGE;
	}
}
