package kr.or.ddit.post.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;

import kr.or.ddit.comm.handler.CommandHandler;
import kr.or.ddit.comm.service.AtchFileServiceImpl;
import kr.or.ddit.comm.service.IAtchFileService;
import kr.or.ddit.post.service.PostService;
import kr.or.ddit.post.service.PostServiceImpl;
import kr.or.ddit.post.vo.AtchFileVO;
import kr.or.ddit.post.vo.PostVO;
import util.FileUploadRequestWrapper;
import kr.or.ddit.post.vo.PostVO;

public class PostMainHandler implements CommandHandler {
		
	private static final String VIEW_PAGE = "/WEB-INF/view/post/main_post.html";
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception, Exception {
		
		System.out.println("입장 Post Main Haldler 입장");

		
		PostService postService = PostServiceImpl.getInstance();
		IAtchFileService fileService = AtchFileServiceImpl.getInstance();
		FileItem item = ((FileUploadRequestWrapper)req).getFileItem("atchFile");
		
		
		if("d".equals(req.getParameter("flag")) ){
			System.out.println("delete중delete중delete중delete중delete중delete중delete중delete중");

			AtchFileVO av = new AtchFileVO();
			System.out.println(req.getParameter("postNo"));
			
			fileService.deleteAtchFile(req.getParameter("postNo"));
			postService.deletePost(req.getParameter("postNo"));
			
			
		} else if("u".equals(req.getParameter("flag")) ){
			System.out.println("update중update중update중update중update중update중update중");
			PostVO pv = new PostVO();
			
			pv.setPostNo(req.getParameter("postNo"));
			pv.setPostTitle(req.getParameter("postTitle"));
			postService.updatePost(pv);
		}
		System.out.println("퇴장 Post Main Haldler 퇴장");

			return VIEW_PAGE;
		}
	}
