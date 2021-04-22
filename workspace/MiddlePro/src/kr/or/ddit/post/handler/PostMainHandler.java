package kr.or.ddit.post.handler;

import java.io.PrintWriter;
import java.util.List;

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
			String postNo = req.getParameter("postNo");
			System.out.println(postNo);
			long atchFileId = fileService.searchAtchFileDetail(postNo).getAtchFileId();
			
			fileService.deleteAtchFile(postNo); // atchFile 삭제
			fileService.deleteAtchFileDetail(String.valueOf(atchFileId)); // atchFileDetail 삭제
			postService.deletePost(req.getParameter("postNo")); // post 삭제
			
		} else if("u".equals(req.getParameter("flag")) ){
			System.out.println("update중update중update중update중update중update중update중");
			PostVO pv = new PostVO();
			pv.setPostNo(req.getParameter("postNo"));
			pv.setPostTitle(req.getParameter("postTitle"));
			postService.updatePost(pv);
		}else if("s".equals(req.getParameter("flag")) ){
			System.out.println("search중search중search중search중search중search중");
			PostVO pv = new PostVO();
			pv.setPostNo(req.getParameter("postNo"));
			List<PostVO> list = postService.getSearchPost(pv);
			System.out.println(list.get(0).getAtchFileId());
		}else if("se".equals(req.getParameter("flag")) ){
			System.out.println("조회중 조회중 조회중 조회중 조회중 조회중 조회중 조회중 조회중 조회중 ");
			List<PostVO> list = postService.getAllPostList();

			//printwriter사용
			
//			resp.setContentType("application/json");
//			resp.setCharacterEncoding("UTF-8");
//			PrintWriter out = resp.getWriter();
//			out.print(strJson);
////			out.flush();

		}
		System.out.println("퇴장 Post Main Haldler 퇴장");

			return VIEW_PAGE;
		}
	}
