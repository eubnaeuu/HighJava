package kr.or.ddit.board.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.board.vo.BoardVO;

public class BoardDaoImpl implements BoardDao{
	
	private static BoardDao boardDao;
	
	private BoardDaoImpl () {
		
	}
	public static BoardDao getInstance() {
		if(boardDao == null) {
			boardDao = new BoardDaoImpl();
		}
		return boardDao;
	}
	
	
	@Override
	public int insertBoard(SqlMapClient smc, BoardVO bv) throws SQLException {
		int cnt=0;
		if(smc.insert("board.insertBoard",bv)==null) {
			cnt = 1;
		}
		return cnt;
	}

	@Override
	public boolean checkBoard(SqlMapClient smc, String boardNo) throws SQLException {
		boolean chk = false;
		int cnt = (int)smc.queryForObject("board.selectBoard", boardNo);
			if(cnt > 0) {
				chk = true;
			}
		return chk;
	}

	@Override
	public List<BoardVO> getAllBoardlist(SqlMapClient smc) throws SQLException {
		System.out.println("dao전");
		List<BoardVO> boardList =smc.queryForList("board.getAllBoardlist");
				//smc.queryForList("board.getAllBoardlist");
		System.out.println("dao후");
		return boardList;
	}

	@Override
	public int updateBoard(SqlMapClient smc, BoardVO bv) throws SQLException {
		int cnt = smc.update("board.updateBoard",bv);
		return cnt;
	}

	@Override
	public int deleteBoard(SqlMapClient smc, String boardNo) throws SQLException {
		int cnt = smc.delete("board.deleteBoard", boardNo);
	return cnt;
	}
	
	@Override
public List<BoardVO> searchBoard(SqlMapClient smc, BoardVO bv) throws SQLException {
		List<BoardVO> boardList = smc.queryForList("board.searchBoard",bv);
		System.out.println(bv);
		
		return boardList;
	} 
	
}
