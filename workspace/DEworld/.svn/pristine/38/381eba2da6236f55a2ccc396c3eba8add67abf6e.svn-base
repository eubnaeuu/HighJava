package kr.or.ddit.post.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.comm.handler.CommandHandler;
import kr.or.ddit.comm.service.AtchFileServiceImpl;
import kr.or.ddit.comm.service.IAtchFileService;
import kr.or.ddit.paging.PagingVO;
import kr.or.ddit.post.service.PostService;
import kr.or.ddit.post.service.PostServiceImpl;
import kr.or.ddit.post.vo.AllPostVO;
import kr.or.ddit.post.vo.PostVO;

public class ListPostHandler implements CommandHandler {
		
	private static final String VIEW_PAGE = "/WEB-INF/view/post/";
	
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
		
		System.out.println("입장 Post List Haldler 입장");
		
		 int pageNo = 
			       req.getParameter("pageNo") == null ? 
			       1 : Integer.parseInt(req.getParameter("pageNo"));
			    
			    PagingVO pagingVO = new PagingVO();
			    

		PostService postService = PostServiceImpl.getInstance();
		IAtchFileService fileService = AtchFileServiceImpl.getInstance();
			
		String flag = req.getParameter("flag");
		
		PostVO pv = new PostVO();
		AllPostVO apv = new AllPostVO();
		
		
		int totalCount=0;
			if("pho".equals(flag)) { // 사진첩
				pv.setHompiId("cdwcdw34");
				pv.setLpostGu("LPO02");
				
				apv.setHompiId("cdwcdw34");
				apv.setLpostGu("LPO02");
				totalCount = postService.getAllPostListCount(pv);
			}else if("dia".equals(flag)) { // 다이어리
				pv.setHompiId("cdwcdw34");
				pv.setLpostGu("LPO01");
				
				apv.setHompiId("cdwcdw34");
				apv.setLpostGu("LPO01");
				totalCount = postService.getAllPostListCount(pv);
			} else {		 // 게시판
				pv.setHompiId("cdwcdw34");
				pv.setLpostGu("LPO03");
				
				apv.setHompiId("cdwcdw34");
				apv.setLpostGu("LPO03");
				totalCount = postService.getAllPostListCount(pv);
			}
			
		    apv.setTotalCount(totalCount);
		    apv.setCurrentPageNo(pageNo);
		    apv.setCountPerPage(5);
		    apv.setPageSize(5);
		    
		    
		    pagingVO.setTotalCount(totalCount);
		    pagingVO.setCurrentPageNo(pageNo);
		    pagingVO.setCountPerPage(5);
		    pagingVO.setPageSize(5);
		
				List<PostVO> list;
				
				if("pho".equals(flag)) {
					list = postService.getSearchPhoto(apv);
					System.out.println("pho if문 탐");
					req.setAttribute("photolist", list);
					req.setAttribute("pagingVO", pagingVO);
					System.out.println("pho if문 끝");
					return VIEW_PAGE+"/photolist.jsp";
				}else if("dia".equals(flag)) {
					System.out.println("dia if문 아래 탐");
					list = postService.getSearchPost(apv);
					req.setAttribute("diarylist", list);
					req.setAttribute("pagingVO", pagingVO);
					System.out.println("dia if문 아래 끝");
					return VIEW_PAGE+"/diarylist.jsp";
				} else {
					System.out.println("post if문 아래 탐");
					list = postService.getSearchPost(apv);
					req.setAttribute("postlist", list);
					req.setAttribute("pagingVO", pagingVO);
					System.out.println("post if문 아래 끝");
					return VIEW_PAGE+"/postlist.jsp";
				}
	}
}
