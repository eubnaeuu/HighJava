package kr.or.ddit.comments.handler;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.comm.handler.CommandHandler;
import kr.or.ddit.comments.service.CommentsService;
import kr.or.ddit.comments.service.CommentsServiceImpl;

public class DeleteCommentsHandler implements CommandHandler {
		
	private static final String VIEW_PAGE = "/WEB-INF/view/comments/delete.html";
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception, Exception {
		
		System.out.println("입장 Delete Comments Haldler 입장");

		
		CommentsService commentsService = CommentsServiceImpl.getInstance();
		
			System.out.println("delete중delete중delete중delete중delete중delete중delete중delete중");

			String commentsId = req.getParameter("commentsId");
			System.out.println(commentsId);
			
			int cnt = commentsService.deleteComments(req.getParameter("commentsId")); // comments 삭제
			
	
		System.out.println("퇴장 Delete Comments Haldler 퇴장");

		String msg = "";
		
		if(cnt > 0) {
			msg = "성공";
		}else {
			msg = "실패";
		}
		
		String redirectUrl = req.getContextPath() + "/comments/maincomments.do?msg=" 
				+ URLEncoder.encode(msg, "UTF-8");
		
		System.out.println("퇴장 comments insert Haldler 퇴장");

		return redirectUrl;
		}
	}
