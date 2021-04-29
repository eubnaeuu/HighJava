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
import kr.or.ddit.post.vo.AllPostVO;
import kr.or.ddit.post.vo.PostVO;

public class ViewPostHandler implements CommandHandler{

	private static final String VIEW_PAGE = "/WEB-INF/view";
	
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
		System.out.println("들어옴 view post handler 들어옴");
		String postNo = req.getParameter("postNo");
		String hompiId = req.getParameter("hompiId");
		
		// 회원정보 조회
		PostService postService = PostServiceImpl.getInstance();
		AllPostVO apv = new AllPostVO(); 
		PostVO pv = new PostVO(); 
		apv.setPostNo(postNo);
		pv.setPostNo(postNo);
		PostVO postpv = postService.getPostView(pv);
		int cnt = postService.updatePostView(pv); // View ++
		
		if(postpv.getAtchFileId() != -1) { // 첨부파일이 존재한다면... 
			System.out.println("atchfile는 null이 아님");
			// 첨부파일 정보 조회
			AtchFileVO fileVO = new AtchFileVO();
			
			fileVO.setAtchFileId(postpv.getAtchFileId());
			
			IAtchFileService atchFileService = AtchFileServiceImpl.getInstance();
			List <AtchFileVO> atchFileList = atchFileService.getAtchFileList(fileVO);
			System.out.println(atchFileList.get(0).getAtchFileId());
			req.setAttribute("atchFileList",atchFileList);
		}
		
		CommentsService commentsService = CommentsServiceImpl.getInstance();
		CommentsVO cv = new CommentsVO();
		cv.setPostNo(req.getParameter("postNo"));
		List<CommentsVO> commentslist = commentsService.getSearchComments(cv);
		
		String flag = req.getParameter("flag");
		
		req.setAttribute("pv", postpv);
		req.setAttribute("commentslist", commentslist);
		req.setAttribute("hompiId", hompiId);
		
		System.out.println("나감 view post handler 나감");
		
		if("pho".equals(flag)) {
			return VIEW_PAGE+"/post/photoview.jsp?hompiId="+hompiId;
		}else if("dia".equals(flag)) {
			return VIEW_PAGE+"/post/diaryview.jsp?hompiId="+hompiId;
		} else if("pos".equals(flag)) {
			return VIEW_PAGE+"/post/postview.jsp?hompiId="+hompiId;
		} else {
			return VIEW_PAGE+"/post/postview.jsp?hompiId="+hompiId;
		}
	}

}
