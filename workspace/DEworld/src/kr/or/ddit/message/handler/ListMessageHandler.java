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

public class ListMessageHandler implements CommandHandler {
		
	private static final String VIEW_PAGE = "/comm/common.jsp";
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception, Exception {
		
		System.out.println("입장 Messages Main Haldler 입장");

		MessageService MessagesService = MessageServiceImpl.getInstance();
	
			List<MessageVO> list = MessagesService.getAllMessageList();

			
			Gson gson = new Gson();
			String strJson =  gson.toJson(list);
			
			resp.setContentType("application/json");
			resp.setCharacterEncoding("UTF-8");
			
			System.out.println(strJson);
			
			PrintWriter out = resp.getWriter();
			out.print(strJson);
			
			req.setAttribute("strJson", strJson);
			
			System.out.println("퇴장 Messages Main Haldler 퇴장");
			return VIEW_PAGE;
	}
}
