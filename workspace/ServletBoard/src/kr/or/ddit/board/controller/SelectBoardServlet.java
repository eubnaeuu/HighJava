package kr.or.ddit.board.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.vo.BoardVO;

public class SelectBoardServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet 실행중..");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		// 1. 요청 파라미터 끌어옴
//		
//		// ☆ 헤더 에서 불러오는 파라미터 값의 이름은 어떤게 맞는지? 왼쪽은 board.xml에서 속성이름을 변경한값. 오른쪽은 그 전의 column값
//		String boardNo = req.getParameter("bord_no");
//		String boardTitle = req.getParameter("board_title");
//		String boardWriter = req.getParameter("board_writer");
//		String boardContent = req.getParameter("board_content");
//		String boardDate = req.getParameter("board_data");
//		
		System.out.println("post 진행중인지");
		
		// 1. 서비스 객체 생성

		BoardService boardService = BoardServiceImpl.getInstance(); 
		
		
		// 2. req.파라미터 값을 list에 담기
		List<BoardVO> boardList = boardService.getAllBoardlist();
		
		System.out.println(boardList);
		
		req.setAttribute("list", boardList);
		
		
		for(int i=0; i<boardList.size(); i++){
			BoardVO vo = boardList.get(i);
			
//			String boardNo = vo.getBoardNo();
//			String boardTitle = vo.getBoardTitle();
//			String boardWriter =vo.getBoardWriter();
//			String boardContent = vo.getBoardContent(); 
//			String boardDate = vo.getBoardDate();
//			
//			System.out.println("boardNo : "+ boardNo);
//			System.out.println("boardTitle : "+ boardTitle);
//			System.out.println("boardWriter : "+ boardWriter);
//			System.out.println("boardContent : "+ boardContent);
//			System.out.println("boardDate : "+ boardDate);
		}
		
		
		
		
		
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/board/listResult.jsp");
		
		// 뷰페이지로 전달
		dispatcher.forward(req, resp); // ☆  req,resp를 파라미터로 가지는 이유?

		
//		// 3. 끌어온 값으로 정보 등록
//		BoardVO bv = new BoardVO();
//		bv.setBoardNo(boardNo);
//		bv.setBoardTitle(boardTitle);
//		bv.setBoardWriter(boardWriter);
//		bv.setBoardContent(boardContent);
//		bv.setBoardDate(boardDate);
//		
//		
//		
		
		
		
	}
	
	

}
