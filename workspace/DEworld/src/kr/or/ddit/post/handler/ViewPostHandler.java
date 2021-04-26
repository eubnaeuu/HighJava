package kr.or.ddit.post.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.comm.handler.CommandHandler;
import kr.or.ddit.comm.service.AtchFileServiceImpl;
import kr.or.ddit.comm.service.IAtchFileService;
import kr.or.ddit.comm.vo.AtchFileVO;
import kr.or.ddit.comments.service.CommentsService;
import kr.or.ddit.comments.service.CommentsServiceImpl;
import kr.or.ddit.comments.vo.CommentsVO;
import kr.or.ddit.post.service.PostService;
import kr.or.ddit.post.service.PostServiceImpl;
import kr.or.ddit.post.vo.PostVO;

public class ViewPostHandler implements CommandHandler{

	private static final String VIEW_PAGE = "/WEB-INF/view/post/postview.jsp";
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		if(req.getMethod().equals("GET")) {
			return false;
		}else { 
			return true;
		}
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		String postNo = req.getParameter("postNo");
		System.out.println(postNo);
		// 회원정보 조회
		PostService postService = PostServiceImpl.getInstance();
		PostVO postVo = new PostVO(); 
		postVo.setPostNo(postNo);
		List<PostVO> postlist = postService.getSearchPost(postVo);
		int cnt = postService.updatePostView(postVo); // View ++
		System.out.println("update 됐음? :"  + cnt);
		
		if(postlist.get(0).getAtchFileId() > 0) { // 첨부파일이 존재한다면... 
			
			// 첨부파일 정보 조회
			AtchFileVO fileVO = new AtchFileVO();
			
			fileVO.setAtchFileId(postlist.get(0).getAtchFileId());
			
			IAtchFileService atchFileService = AtchFileServiceImpl.getInstance();
			List <AtchFileVO> atchFileList = atchFileService.getAtchFileList(fileVO);
			System.out.println(atchFileList.get(0).getAtchFileId());
			req.setAttribute("atchFileList",atchFileList);
		}
		
		CommentsService commentsService = CommentsServiceImpl.getInstance();
		CommentsVO cv = new CommentsVO();
		cv.setPostNo(req.getParameter("postNo"));
		List<CommentsVO> commentslist = commentsService.getSearchComments(cv);
		
		
		
		
		req.setAttribute("postlist", postlist);
		req.setAttribute("commentslist", commentslist);
		
		return VIEW_PAGE;
	}

}
