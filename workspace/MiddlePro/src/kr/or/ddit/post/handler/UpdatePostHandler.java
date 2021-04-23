package kr.or.ddit.post.handler;

import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

public class UpdatePostHandler implements CommandHandler {
		
	private static final String VIEW_PAGE = "/WEB-INF/view/post/update.jsp";
	
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
		System.out.println("입장 Post update Haldler 입장");
		if(req.getMethod().equals("GET")) {
			String postNo = req.getParameter("postNo");
			// 회원정보 조회
			SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
			Date time = new Date();
			String sysdate = format1.format(time);

			
			PostService postService = PostServiceImpl.getInstance();
			PostVO postVo = new PostVO();
			postVo.setPostNo(postNo);
			List<PostVO> list = postService.getSearchPost(postVo);
			
			if(list.get(0).getAtchFileId() > 0) { // 첨부파일이 존재한다면... 
				
				// 첨부파일 정보 조회
				AtchFileVO fileVO = new AtchFileVO();
				
				fileVO.setAtchFileId(list.get(0).getAtchFileId());
				
				IAtchFileService atchFileService = AtchFileServiceImpl.getInstance();
				List <AtchFileVO> atchFileList = atchFileService.getAtchFileList(fileVO);
				System.out.println(atchFileList.get(0).getAtchFileId());
				req.setAttribute("atchFileList",atchFileList);
		}
			req.setAttribute("list", list);
			req.setAttribute("sysdate", String.valueOf(sysdate));
			
			
			System.out.println(sysdate);
			System.out.println(req.getParameter("sysdate"));
			
			
			System.out.println("퇴장 Post update Haldler 퇴장");
			return VIEW_PAGE;
		}else {

		
		PostService postService = PostServiceImpl.getInstance();
		IAtchFileService fileService = AtchFileServiceImpl.getInstance();
		FileItem item = ((FileUploadRequestWrapper)req).getFileItem("atchFile");
		AtchFileVO atchFileVO = new AtchFileVO();
		
		atchFileVO.setAtchFileId(req.getParameter("atchFile")==null ?
				-1 : Long.parseLong(req.getParameter("atchFile")));
				
				if(item != null && !item.getName().equals("")) { // 기존 파일과 겹치지만 않는다면
					atchFileVO = fileService.saveAtchFile(item); // 첨부파일 저장 
				}
		
			PostVO pv = new PostVO();
			System.out.println("postNo : "+req.getParameter("postNo"));
			pv.setPostNo(req.getParameter("postNo"));
			pv.setPostTitle(req.getParameter("postTitle"));
			pv.setPostContent(req.getParameter("postContent"));
			pv.setAtchFileId(atchFileVO.getAtchFileId());
			
			postService.updatePost(pv);

		System.out.println("퇴장 Post update Haldler 퇴장");

		String redirectUrl = req.getContextPath() + "/post/main.do";
		
		return redirectUrl;
		}
	}
}
