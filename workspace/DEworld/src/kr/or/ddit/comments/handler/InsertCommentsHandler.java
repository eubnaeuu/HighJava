package kr.or.ddit.comments.handler;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import kr.or.ddit.comm.handler.CommandHandler;
import kr.or.ddit.comments.service.CommentsService;
import kr.or.ddit.comments.service.CommentsServiceImpl;
import kr.or.ddit.comments.vo.CommentsVO;
import util.FileUploadRequestWrapper;

public class InsertCommentsHandler implements CommandHandler {
									// 뷰페이지 임의설정
	private static final String VIEW_PAGE = "/WEB-INF/view/post/postview.jsp";
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception, Exception {
		
		System.out.println("입장 Comments insert Haldler 입장");
		
		if(req.getMethod().equals("GET")) { //GET방식인 경우 isRedirect을 하지 않는다
			return VIEW_PAGE;
		}else { //Post 방식인 경우 isRedirect를 한다 
		
			CommentsService CommentsService = CommentsServiceImpl.getInstance();
			CommentsVO cv = new CommentsVO();
//			cv.setCommentsId(req.getParameter("commentsId"));
			cv.setPostNo(req.getParameter("postNo"));
			cv.setMemId(req.getParameter("memId"));
			cv.setCommentsContent(req.getParameter("commentsContent"));
			int cnt = CommentsService.insertComments(cv);
			
//			String msg = "";
//			
//			if(cnt > 0) {
//				msg = "성공";
//			}else {
//				msg = "실패";
//			}
		
			String redirectUrl =
//					+ req.getContextPath() 
					 "/post/select.do?postNo=" 
					+ req.getParameter("postNo");
//			+URLEncoder.encode(msg, "UTF-8");
			
			System.out.println(redirectUrl);
			return null;
	}
}
}
