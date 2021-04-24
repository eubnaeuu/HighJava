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
import kr.or.ddit.paging.PagingVO;
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
		
		 int pageNo = 
			       req.getParameter("pageNo") == null ? 
			       1 : Integer.parseInt(req.getParameter("pageNo"));
			    
			    PagingVO pagingVO = new PagingVO();
			    

		PostService postService = PostServiceImpl.getInstance();
		IAtchFileService fileService = AtchFileServiceImpl.getInstance();
			
		  int totalCount = postService.getAllPostListCount();
		    pagingVO.setTotalCount(totalCount);
		    pagingVO.setCurrentPageNo(pageNo);
		    pagingVO.setCountPerPage(5);
		    pagingVO.setPageSize(5);
			
		    String flag = req.getParameter("flag");
			PostVO pv = new PostVO();
			
		    if("1".equals(flag)) {
				String postTitle = req.getParameter("inputstr");
				pv.setPostTitle(postTitle);
				List<PostVO> list = postService.getSearchPost(pv);
				System.out.println("퇴장 Post List Haldler 퇴장");
				return VIEW_PAGE;
			}else if("2".equals(flag)) {
				String postContent = req.getParameter("inputstr");
				pv.setPostContent(postContent);
				List<PostVO> list = postService.getSearchPost(pv);
				System.out.println("퇴장 Post List Haldler 퇴장");
				return VIEW_PAGE;
			}else if("3".equals(flag)) {
				String memId = req.getParameter("inputstr");
				pv.setMemId(memId);
				List<PostVO> list = postService.getSearchPost(pv);
				System.out.println("퇴장 Post List Haldler 퇴장");
				return VIEW_PAGE;
			} else {
				List<PostVO> list = postService.getAllPostList(pagingVO);
				req.setAttribute("list", list);
				req.setAttribute("pagingVO", pagingVO);
				System.out.println("퇴장 Post List Haldler 퇴장");
				return VIEW_PAGE;
				
				
			}
		    
			
//			Gson gson = new Gson();
//			String strJson =  gson.toJson(list);
//			
//			resp.setContentType("application/json");
//			resp.setCharacterEncoding("UTF-8");
//			
//			PrintWriter out = resp.getWriter();
//			out.print(strJson);
			
//			req.setAttribute("strJson", strJson);

//			System.out.println("퇴장 Post List Haldler 퇴장");
//			return VIEW_PAGE;
			
			
	}
}
