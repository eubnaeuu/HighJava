package kr.or.ddit.post.handler;

import java.net.URLEncoder;

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

public class PostInsertHandler implements CommandHandler {
	
	private static final String VIEW_PAGE = "/WEB-INF/view/post/main_post.html";
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception, Exception {
		
		System.out.println("입장 Post insert Haldler 입장");
		
		if(req.getMethod().equals("GET")) { //GET방식인 경우 isRedirect을 하지 않는다
			return VIEW_PAGE;
		}else { //POST 방식인 경우 isRedirect를 한다 
			
			FileItem item = ((FileUploadRequestWrapper)req).getFileItem("atchFile");
			AtchFileVO atchFileVO = new AtchFileVO();
			IAtchFileService fileService = AtchFileServiceImpl.getInstance();
			String postNo = req.getParameter("postNo");
			atchFileVO = fileService.saveAtchFile(item);
			
			PostService postService = PostServiceImpl.getInstance();
			PostVO pv = new PostVO();
			pv.setMemId(req.getParameter("memId"));
			pv.setPostNo(req.getParameter("postNo"));
			pv.setPostTitle(req.getParameter("postTitle"));
			pv.setAtchFileId(atchFileVO.getAtchFileId());
			int cnt = postService.insertPost(pv);
			System.out.println("post해결 완료");
			
			
			
			
			String msg = "";
			
			if(cnt > 0) {
				msg = "성공";
			}else {
				msg = "실패";
			}
			
			String redirectUrl = req.getContextPath() + "/post/mainpost.do?msg=" 
					+ URLEncoder.encode(msg, "UTF-8");

			System.out.println("퇴장 Post insert Haldler 퇴장");

			return redirectUrl;
		}
	}
}
