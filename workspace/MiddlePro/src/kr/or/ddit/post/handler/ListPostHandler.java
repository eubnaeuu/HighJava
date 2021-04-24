package kr.or.ddit.post.handler;

import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.comm.handler.CommandHandler;
import kr.or.ddit.comm.service.AtchFileServiceImpl;
import kr.or.ddit.comm.service.IAtchFileService;
import kr.or.ddit.post.service.PostService;
import kr.or.ddit.post.service.PostServiceImpl;
import kr.or.ddit.post.vo.PostVO;

public class ListPostHandler implements CommandHandler {
		
	private static final String VIEW_PAGE = "/WEB-INF/view/post/list.jsp";
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception, Exception {
		System.out.println("입장 Post List Haldler 입장");

		PostService postService = PostServiceImpl.getInstance();
		IAtchFileService fileService = AtchFileServiceImpl.getInstance();
			
			List<PostVO> list = postService.getAllPostList();
			
//			Gson gson = new Gson();
//			String strJson =  gson.toJson(list);
//			
//			resp.setContentType("application/json");
//			resp.setCharacterEncoding("UTF-8");
//			
//			PrintWriter out = resp.getWriter();
//			out.print(strJson);
			
//			req.setAttribute("strJson", strJson);
			req.setAttribute("list", list);

			System.out.println("퇴장 Post List Haldler 퇴장");
			
			return VIEW_PAGE;
	}
}
