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
		
//	private static final String VIEW_PAGE = "/WEB-INF/view/post/postlist.jsp";
	
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
			System.out.println("DELETE POST 핸들러 : "+postNo);
			System.out.println("DELETE POST 핸들러 : "+hompiId);
			System.out.println("DELETE POST 핸들러 : "+flag);
			
			
			System.out.println("atch delete전");
			fileService.deleteAtchFile(postNo); // atchFile 삭제(detail 종속삭제)
			System.out.println("atch delete후");
			
			
			System.out.println("post delete전");
			postService.deletePost(postNo); // post 삭제
			System.out.println("post delete후");
			
//		System.out.println("퇴장 Post DELETE Haldler 퇴장");
		
		String redirectUrl = req.getContextPath() + "/post/list.do";
		
		
		if("pos".equals(flag)) {
			System.out.println("pos탐");
			System.out.println(hompiId);
			System.out.println(flag);
//			return redirectUrl+"?hompiId="+hompiId+"&flag=pos";
			return null;
			
		}else if("pho".equals(flag)) {
			System.out.println("pho탐");
//			return redirectUrl+"?hompiId="+hompiId+"&flag=pho";
			return null;
			
		}else if("dia".equals(flag)) {
			System.out.println("dia탐");
//			return redirectUrl+"?hompiId="+hompiId+"&flag=dia";
			return null;
			
		} else 
//			return redirectUrl+"?hompiId="+hompiId+"&flag=pos";
		return null;

		}
	}
