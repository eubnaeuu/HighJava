package kr.or.ddit.post.handler;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;

import kr.or.ddit.comm.handler.CommandHandler;
import kr.or.ddit.comm.service.AtchFileServiceImpl;
import kr.or.ddit.comm.service.IAtchFileService;
import kr.or.ddit.comm.vo.AtchFileVO;
import kr.or.ddit.post.service.PostService;
import kr.or.ddit.post.service.PostServiceImpl;
import kr.or.ddit.post.vo.PostVO;
import util.FileUploadRequestWrapper;

public class InsertPostHandler implements CommandHandler {
	
	private static final String VIEW_PAGE = "/WEB-INF/view/post/postinsert.jsp";
	private Map<String, Object> fileItemMap;

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
		
		System.out.println("입장 Post insert Haldler 입장");
		
		if(req.getMethod().equals("GET")) { //GET방식인 경우 isRedirect을 하지 않는다
			return VIEW_PAGE;
		}else { //POST 방식인 경우 isRedirect를 한다 
			
//			FileItem item = ((FileUploadRequestWrapper)req).getFileItem("atchFile");
//			AtchFileVO atchFileVO = new AtchFileVO();
//			IAtchFileService fileService = AtchFileServiceImpl.getInstance();
//			String postNo = req.getParameter("postNo");
//			atchFileVO = fileService.saveAtchFile(item);
			
			fileItemMap = ((FileUploadRequestWrapper)req).getFileItemMap();
			
			int filecnt = fileItemMap.size();
			AtchFileVO atchFileVO = new AtchFileVO();
			
			if(filecnt > 0) {
				
				atchFileVO = new AtchFileVO();
				IAtchFileService fileService = AtchFileServiceImpl.getInstance();
				String postNo = req.getParameter("postNo");
				atchFileVO = fileService.saveAtchFileList(fileItemMap);

			}
			
			PostService postService = PostServiceImpl.getInstance();
			
			PostVO pv = new PostVO();
			pv.setMemId(req.getParameter("memId"));
			pv.setHompiId(req.getParameter("memId"));
			pv.setLpostGu(req.getParameter("lpostGu"));
			pv.setPostNo(req.getParameter("postNo"));
			pv.setPostTitle(req.getParameter("postTitle"));
			if(filecnt > 0) {
			pv.setAtchFileId(atchFileVO.getAtchFileId());
			}
			int cnt = postService.insertPost(pv);
			
			String msg = "";
			
			if(cnt > 0) {
				msg = "성공";
			}else {
				msg = "실패";
			}
			
			String redirectUrl = req.getContextPath() + "/post/list.do";

			System.out.println("퇴장 Post insert Haldler 퇴장");
			
			return redirectUrl;
		}
	}
}

