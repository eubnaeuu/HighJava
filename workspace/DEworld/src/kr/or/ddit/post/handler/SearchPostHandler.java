package kr.or.ddit.post.handler;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.comm.handler.CommandHandler;
import kr.or.ddit.comm.service.AtchFileServiceImpl;
import kr.or.ddit.comm.service.IAtchFileService;
import kr.or.ddit.paging.PagingVO;
import kr.or.ddit.post.service.PostService;
import kr.or.ddit.post.service.PostServiceImpl;
import kr.or.ddit.post.vo.PostVO;

public class SearchPostHandler implements CommandHandler {
		
	private static final String VIEW_PAGE = "/WEB-INF/view/post/postsearchlist.jsp";
	
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
			
//			req.setCharacterEncoding("utf-8"); 
//			if(req.getParameter("postTitle")!= null) {
//				String postTitle = req.getParameter("postTitle");
//				postTitle = URLDecoder.decode(postTitle,"UTF-8");
//				pv.setPostTitle(postTitle);
//				System.out.println("제발 : "+postTitle);
//			}else if(req.getParameter("postContent")!= null) {
//				String postContent = req.getParameter("postContent");
//				pv.setPostTitle(postContent);
//			}else if(req.getParameter("memId")!= null) {
//				String memId = req.getParameter("memId");
//				pv.setPostTitle(memId);
//			}
			
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
//			String input = new String(req.getParameter("inputstr").getBytes("8859_1"),"KSC5601");  
//			System.out.println("inputstr :"+req.getParameter("inputstr"));
//			System.out.println(input);
			   if("1".equals(flag)) {
					String postTitle = req.getParameter("inputstr");
					pv.setPostTitle(postTitle);
				}else if("2".equals(flag)) {
					String postContent = req.getParameter("inputstr");
					pv.setPostContent(postContent);
				}else if("3".equals(flag)) {
					String memId = req.getParameter("inputstr");
					pv.setMemId(memId);
				}
		
			  List<PostVO> list = postService.getSearchPost(pv);
			   req.setAttribute("postlist", list);
			   req.setAttribute("pagingVO", pagingVO);
			   
			
			   RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/post/postlist.jsp");
				dispatcher.forward(req, resp);

			   
			return VIEW_PAGE;
		}else { 
//		System.out.println("입장 Post Main Haldler 입장");
			System.out.println("inputstr :"+req.getParameter("inputstr"));
		
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
			}else if("2".equals(flag)) {
				String postContent = req.getParameter("inputstr");
				pv.setPostContent(postContent);
			}else if("3".equals(flag)) {
				String memId = req.getParameter("inputstr");
				pv.setMemId(memId);
			}
		   
		   List<PostVO> list = postService.getSearchPost(pv);
		   
		   req.setAttribute("postlist", list);
		   req.setAttribute("pagingVO", pagingVO);
		   
		   System.out.println("퇴장 Post SEARCH Haldler 퇴장");
		   
//		   RequestDispatcher view=req.getRequestDispatcher("index.jsp");
//		    view.forward(req,resp);
		   
		   return VIEW_PAGE;
		}
	}
}
