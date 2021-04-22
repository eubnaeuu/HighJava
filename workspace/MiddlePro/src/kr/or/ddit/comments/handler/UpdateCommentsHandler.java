package kr.or.ddit.comments.handler;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.comm.handler.CommandHandler;
import kr.or.ddit.comments.service.CommentsService;
import kr.or.ddit.comments.service.CommentsServiceImpl;
import kr.or.ddit.comments.vo.CommentsVO;

public class UpdateCommentsHandler implements CommandHandler {
		
	private static final String VIEW_PAGE = "/WEB-INF/view/comments/update.html";
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception, Exception {
		
//		System.out.println("입장 comments Main Haldler 입장");

		CommentsService commentsService = CommentsServiceImpl.getInstance();
		
			System.out.println("update중update중update중update중update중update중update중");
			CommentsVO cv = new CommentsVO();
			cv.setCommentsId(req.getParameter("commsentsId"));
			cv.setCommentsContent(req.getParameter("commsentsContent"));
			
			int cnt = commentsService.updateComments(cv);
			
			String msg = "";
			
			if(cnt > 0) {
				msg = "성공";
			}else {
				msg = "실패";
			}
			
			String redirectUrl = req.getContextPath() + "/comments/list.do?msg=" 
					+ URLEncoder.encode(msg, "UTF-8");

//			System.out.println("퇴장 comments insert Haldler 퇴장");

			return redirectUrl;
		}
	}
