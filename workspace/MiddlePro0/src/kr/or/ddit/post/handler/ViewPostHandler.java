package kr.or.ddit.post.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.comm.handler.CommandHandler;
import kr.or.ddit.comm.service.AtchFileServiceImpl;
import kr.or.ddit.comm.service.IAtchFileService;
import kr.or.ddit.comm.vo.AtchFileVO;
import kr.or.ddit.post.service.PostService;
import kr.or.ddit.post.service.PostServiceImpl;
import kr.or.ddit.post.vo.PostVO;

public class ViewPostHandler implements CommandHandler{

	private static final String VIEW_PAGE = "/WEB-INF/view/post/select.jsp";
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}
	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		String postNo = req.getParameter("postNo");
		// 회원정보 조회
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
		return VIEW_PAGE;
	}

}