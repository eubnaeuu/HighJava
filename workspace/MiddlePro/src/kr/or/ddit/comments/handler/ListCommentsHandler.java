package kr.or.ddit.comments.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.comm.handler.CommandHandler;
import kr.or.ddit.comments.service.CommentsService;
import kr.or.ddit.comments.service.CommentsServiceImpl;
import kr.or.ddit.comments.vo.CommentsVO;

public class ListCommentsHandler implements CommandHandler {
		
	private static final String VIEW_PAGE = "/WEB-INF/view/comments/list.html";
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception, Exception {
		
//		System.out.println("입장 comments Main Haldler 입장");

		
		CommentsService commentsService = CommentsServiceImpl.getInstance();
	
			System.out.println("조회중 조회중 조회중 조회중 조회중 조회중 조회중 조회중 조회중 조회중 ");
			List<CommentsVO> list = commentsService.getAllCommentsList();

			//printwriter사용
			
//			resp.setContentType("application/json");
//			resp.setCharacterEncoding("UTF-8");
//			PrintWriter out = resp.getWriter();
//			out.print(strJson);
////			out.flush();

//		System.out.println("퇴장 comments Main Haldler 퇴장");

			return VIEW_PAGE;
		}
	}
