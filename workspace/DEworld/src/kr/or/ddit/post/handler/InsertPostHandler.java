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
	
	private static final String VIEW_PAGE = "/WEB-INF/view/";
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
			
//			FileItem item = ((FileUploadRequestWrapper)req).getFileItem("atchFile");
//			AtchFileVO atchFileVO = new AtchFileVO();
//			IAtchFileService fileService = AtchFileServiceImpl.getInstance();
//			String postNo = req.getParameter("postNo");
//			atchFileVO = fileService.saveAtchFile(item);
			
		if("pho".equals(req.getParameter("flag"))) { //GET방식인 경우 isRedirect을 하지 않는다
			return VIEW_PAGE+"post/photoinsert.jsp";
		}else if("dia".equals(req.getParameter("flag"))) {
			return VIEW_PAGE+"post/diaryinsert.jsp";
		}else if("pos".equals(req.getParameter("flag"))) {
			return VIEW_PAGE+"post/postinsert.jsp";
		}else {			
			
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
			
			
			// 왜 못불러옴?
			String userId = (String)req.getSession().getAttribute("userId");
			System.out.println("세션따오기 : "+userId);
			
			PostVO pv = new PostVO();
			pv.setMemId(userId);
			pv.setHompiId(req.getParameter("HompiId"));
			pv.setLpostGu(req.getParameter("lpostGu"));
			pv.setPostNo(req.getParameter("postNo"));
			pv.setPostTitle(req.getParameter("postTitle"));
			pv.setPostContent(req.getParameter("postContent"));
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
			
			if("phoend".equals(req.getParameter("flag"))) { //GET방식인 경우 isRedirect을 하지 않는다
				return redirectUrl+"?flag=pho";
			}else if("diaend".equals(req.getParameter("flag"))) {
				return redirectUrl+"?flag=dia";
			}else if("posend".equals(req.getParameter("flag"))) {
				return redirectUrl+"?flag=pos";
			}else {			

			System.out.println("퇴장 Post insert Haldler 퇴장");
			
			return redirectUrl;
			}
		}
	}
}
