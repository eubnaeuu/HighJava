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

public class PostMainHandler implements CommandHandler {
	
	private static final String VIEW_PAGE = "/WEB-INF/view/post/post.html";
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception, Exception {
		
		System.out.println("입장 Post Main Haldler 입장");
		

			System.out.println("퇴장 Post Main Haldler 퇴장");

			return VIEW_PAGE;
		}
	}
