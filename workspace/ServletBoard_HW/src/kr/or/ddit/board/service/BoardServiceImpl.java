package kr.or.ddit.board.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.board.dao.BoardDao;
import kr.or.ddit.board.dao.BoardDaoImpl;
import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.SqlMapClientUtil;

public class BoardServiceImpl implements BoardService {

	// 사용할 DAO의 객체변수를 선언한다.
	private BoardDao boardDao; // ★다형성 관련 알아보기
	private SqlMapClient smc;
	
	private static BoardService boardService;
	
	public BoardServiceImpl() {
		boardDao = BoardDaoImpl.getInstance();
		smc = SqlMapClientUtil.getInstance(); 
	}
	public static BoardService getInstance() {
		if(boardService == null) {
			boardService = new BoardServiceImpl();
		}
		return boardService;
	}
	
	@Override
	public int insertBoard(BoardVO bv) {
		int cnt =0;
			
			try {
				cnt = boardDao.insertBoard(smc, bv);
			} catch (SQLException e) {
				e.printStackTrace();
			} // 이전에 예외처리를 하지않고 throw던졌기에 error나는 것
			
		return cnt;
	}

	@Override
	public boolean checkBoard(String boardNo){
	
		boolean chk =false;
		try {
			chk = boardDao.checkBoard(smc, boardNo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return chk;
	}

	
	@Override
	public List<BoardVO> getAllBoardlist() {
		List<BoardVO> boardList = new ArrayList<>();
		try {
			System.out.println("서비스 전");
			boardList = boardDao.getAllBoardlist(smc);
			System.out.println("서비스 후");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return boardList;
	}

	@Override
	public int updateBoard(BoardVO bv) {
		int cnt=0;
		try {
			cnt = boardDao.updateBoard(smc, bv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public List<BoardVO> searchBoard(BoardVO bv) {
		
		List<BoardVO> boardList = new ArrayList<>();
		
		try {
			boardList = boardDao.searchBoard(smc, bv);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return boardList;
	}

	@Override
	public int deleteBoard(String boardNo) {
		
		int cnt=0;
		try {
			cnt = boardDao.deleteBoard(smc, boardNo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

}
