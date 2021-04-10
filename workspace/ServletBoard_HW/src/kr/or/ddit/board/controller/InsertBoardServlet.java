package kr.or.ddit.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.vo.BoardVO;

public class InsertBoardServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet 실행중..");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		// 1. 요청 파라미터 끌어옴
		
		// ☆ 헤더 에서 불러오는 파라미터 값의 이름은 어떤게 맞는지? 왼쪽은 board.xml에서 속성이름을 변경한값. 오른쪽은 그 전의 column값
		String boardNo = req.getParameter("bord_no");
		String boardTitle = req.getParameter("board_title");
		String boardWriter = req.getParameter("board_writer");
		String boardContent = req.getParameter("board_content");
		String boardDate = req.getParameter("board_data");
		
		
		// 2. 서비스 객체 생성
		BoardService boardService = BoardServiceImpl.getInstance(); 
		
		// 3. 끌어온 값으로 정보 등록
		BoardVO bv = new BoardVO();
		bv.setBoardNo(boardNo);
		bv.setBoardTitle(boardTitle);
		bv.setBoardWriter(boardWriter);
		bv.setBoardContent(boardContent);
		bv.setBoardDate(boardDate);
		
		
		
		
		
		
		
		
		
		
		
	}
	
	

}
