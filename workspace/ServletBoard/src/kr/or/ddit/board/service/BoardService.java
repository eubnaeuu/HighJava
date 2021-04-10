package kr.or.ddit.board.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.board.vo.BoardVO;

/**
 * 게시글 처리를 수행하는 서비스 
 */

public interface BoardService {
	/**
	 * 게시글 작성하는 메서드
	 * @param bv DB에 insert할 자료가 저장된 BoardVO객체
	 * @return DB작업이 성공하면 1이상의 값이 반환되고, 실패하면 0이 된다
	 */
	public int insertBoard(BoardVO bv);
	
	/**
	 * 주어진 글번호가 존재하는지 여부를 알아내는 메서드
	 * @param board_no 글번호
	 * @return 해당 게시글이 존재하면 true, 존재하지 않으면 false
	 */
	public boolean checkBoard(String board_no);

	/**
	 * 전체 게시글 조회 메서드
	 * DB의 jdbc_board테이블의 전체 레코드를 가져와서 List에 담아 반환하는 메서드
	 * @return 게시글 정보를 담고있는 List 객체
	 */
	public List<BoardVO> getAllBoardlist();
	
	/**
	 * 하나의 게시글정보를 update하는 메서드
	 * @param column 수정을 요하는 속성(컬럼)
	 * @param content 수정내용
	 * @param boardno 게시글번호
	 * @return 작업성공 : 1, 작업실패 : 0
	 */
	public int updateBoard(BoardVO bv);
	
	/**
	 * 글번호를 매개변수로 받아서 그 게시글을 삭제하는 메서드
	 * @param board_no 삭제할 글번호
	 * @return 작업성공 :1, 작업실패 : 0
	 */
	
	public int deleteBoard(String board_no);
	
/**
 * 검색
 * @param column
 * @param keword
 * @return
 */
	public List<BoardVO> searchBoard(BoardVO bv);
	
}
