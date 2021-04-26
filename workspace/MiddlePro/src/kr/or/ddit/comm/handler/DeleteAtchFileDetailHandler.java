package kr.or.ddit.comm.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.comm.service.AtchFileServiceImpl;
import kr.or.ddit.comm.service.IAtchFileService;
import kr.or.ddit.comm.vo.AtchFileVO;

public class DeleteAtchFileDetailHandler implements CommandHandler {
		
	private static final String VIEW_PAGE = "/WEB-INF/view/post/mainpost.html";
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		if(req.getMethod().equals("GET")) { // GET 방식인 경우 redirect를 하지 않는다.
			return false;
		}else { // POST 방식인 경우
			return true;
		}
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception, Exception {
		if(req.getMethod().equals("GET")) {
		System.out.println("입장 atchFileDetail Haldler 입장");

		PostService postService = PostServiceImpl.getInstance();
		IAtchFileService fileService = AtchFileServiceImpl.getInstance();
		AtchFileVO av = new AtchFileVO();
		
		av.setAtchFileId(Long.valueOf(req.getParameter("fileId")));
		av.setFileSn(Long.valueOf(req.getParameter("fileSn")));
		
		fileService.deleteAtchFileDetail(av);
//		
//			long atchFileId = Long.valueOf(req.getParameter("fileId"));
//			long fileSn = Long.valueOf(req.getParameter("fileSn"));
//			
//			av.setAtchFileId(atchFileId);
//			av.setFileSn(fileSn);
//			fileService.deleteAtchFileDetail(av); // atchfiledetail
		
		System.out.println("퇴장 atchFileDetail Haldler 퇴장");
		
		}
		
		String redirectUrl = req.getContextPath() + "/post/update.do?postNo="+ req.getParameter("postNo");
		return redirectUrl;
		}
	}
