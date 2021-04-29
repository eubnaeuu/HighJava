package kr.or.ddit.post.handler;

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
import kr.or.ddit.post.vo.AllPostVO;
import kr.or.ddit.post.vo.PostVO;
import util.FileUploadRequestWrapper;

public class UpdatePostHandler implements CommandHandler {
		
	private static final String VIEW_PAGE = "/WEB-INF/view/post/postupdate2.jsp";
	
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
			String hompiId = req.getParameter("hompiId");
			
			// 회원정보 조회
			PostService postService = PostServiceImpl.getInstance();
			PostVO pv = new PostVO();
			AllPostVO apv = new AllPostVO();
			
			pv.setPostNo(postNo);
			apv.setPostNo(postNo);
			
			System.out.println("구분1");
//			List<PostVO> list = postService.getSearchPost(apv);
//			long atchFileId = list.get(0).getAtchFileId();

			PostVO postpv = postService.getPostView(pv);
			
			System.out.println("구분2");
//			req.setAttribute("list", list);
			req.setAttribute("pv", postpv);
			System.out.println("퇴장 Post update Haldler 퇴장");
			return VIEW_PAGE;
		}else {

			PostService postService = PostServiceImpl.getInstance();
			// FileItem 추출
			FileItem item = ((FileUploadRequestWrapper)req).getFileItem("atchFile");
			
			AtchFileVO atchFileVO = new AtchFileVO();
			
			// 기존의 첨부파일아이디 정보 가져오기
			
			atchFileVO.setAtchFileId(req.getParameter("atchFile")==null ?
			-1 : Long.parseLong(req.getParameter("atchFile")));
			
			PostVO pv = new PostVO();
			if(item != null && !item.getName().equals("")) { // 기존 파일과 겹치지만 않는다면
				System.out.println("if문 들어옴");
				IAtchFileService fileService = AtchFileServiceImpl.getInstance();
				atchFileVO = fileService.saveAtchFile(item); // 첨부파일 저장
				
				pv.setAtchFileId(atchFileVO.getAtchFileId());
				} 
		
			pv.setPostNo(req.getParameter("postNo"));
			pv.setPostTitle(req.getParameter("postTitle"));
			pv.setPostContent(req.getParameter("postContent"));
			
			postService.updatePost(pv);

		System.out.println("퇴장 Post update Haldler 퇴장");

		String redirectUrl = req.getContextPath() 
				+ "/post/select.do?postNo="
				+ req.getParameter("postNo");
		
		return null;
		}
	}
}
