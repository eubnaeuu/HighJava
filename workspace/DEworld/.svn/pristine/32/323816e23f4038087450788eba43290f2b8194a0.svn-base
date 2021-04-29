package kr.or.ddit.post.handler;

import java.io.PrintWriter;
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

public class DeletePostHandler implements CommandHandler {
		
	private static final String VIEW_PAGE = "/WEB-INF/view/post/postlist.jsp";
	
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
		
		System.out.println("입장 Post DELETE Haldler 입장");

		PostService postService = PostServiceImpl.getInstance();
		IAtchFileService fileService = AtchFileServiceImpl.getInstance();
		
			String postNo = req.getParameter("postNo");
			String hompiId = req.getParameter("hompiId");
			String flag = req.getParameter("flag");
			System.out.println("제발베자베랍제랍ㅈ베잘"+postNo);
			System.out.println("제발베자베랍제랍ㅈ베잘"+hompiId);
			System.out.println("제발베자베랍제랍ㅈ베잘"+flag);
			
			
			System.out.println("여기맞는지");
			fileService.deleteAtchFile(postNo); // atchFile 삭제(detail 종속삭제)
			
			System.out.println("여기맞는지2");
			postService.deletePost(postNo); // post 삭제
			
			
			
		System.out.println("퇴장 Post DELETE Haldler 퇴장");
		
		String redirectUrl = req.getContextPath() + "/post/list.do";
		
		
		if("pos".equals(flag)) {
			System.out.println("pos탐");
			return redirectUrl+"?hompiId="+hompiId+"&flag=pos";
			
		}else if("pho".equals(flag)) {
			System.out.println("pho탐");
			return redirectUrl+"?hompiId="+hompiId+"&flag=pho";
			
		}else if("dia".equals(flag)) {
			System.out.println("dia탐");
			return redirectUrl+"?hompiId="+hompiId+"&flag=dia";
			
		} else 
			return redirectUrl+"?hompiId="+hompiId+"&flag=pos";

		}
	}
