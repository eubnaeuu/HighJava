package kr.or.ddit.board.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.comm.handler.CommandHandler;

public class ListBoardHandler implements CommandHandler{

	@Override
	public boolean isRedirect(HttpServletRequest req) {
		if(req.getMethod().equals("GET")) {
			return false;
		}else {
			return true;
		}
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		
		// 2. 서비스 객체 생성
		BoardService boardService = BoardServiceImpl.getInstance(); 
		
		// 3. 끌어온 값으로 정보 등록
		BoardVO bv = new BoardVO();
		
		List boardList = boardService.getAllBoardlist();
		
		
//		String redirectUrl = req.getContextPath() + "/board.list.do?msg="+ URLEncoder.encode(msg, "UTF-8");
		String redirectUrl = req.getContextPath() + "/board/list.do";
		resp.sendRedirect(redirectUrl);
		
		return null;
	}
		
		

}
