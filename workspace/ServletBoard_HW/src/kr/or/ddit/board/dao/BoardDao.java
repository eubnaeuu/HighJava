package kr.or.ddit.board.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.board.vo.BoardVO;

/**
 * 실제 DB와 연결해서 SQL문을 수행하여 결과를 작성한여 서비스에 전달하는 DAO 인터페이스
 */
	
public interface BoardDao {
	/**
	 * BoardVO : 객체에 담겨진 자료를 DB에 insert하는 메서드
	 * @param smc SqlMapclient 객체
	 * @param bv DB에 insert할 자료가 저장된 BoardVO객체
	 * @return DB작업이 성공하면 1이상의 값이 반환되고, 실패하면 0이 된다
	 * @throws SQLException JDBC관련 예외객체 발생
	 */
	public int insertBoard (SqlMapClient smc, BoardVO bv) throws SQLException;
	
	/**
	 * 주어진 게시글번호(boardNo)가 존재하는지 여부를 알아내는 메서드
	 * @param smc SqlMapclient 객체
	 * @param boardNo 게시글번호
	 * @return 해당 게시글번호(boardNo)가 존재하면 true, 존재하지 않으면 false
	 * @throws SQLException SQLException JDBC관련 예외객체 발생
	 */
	public boolean checkBoard (SqlMapClient smc, String boardNo) throws SQLException;

	/**
	 * DB의 jdbc_board테이블의 전체 레코드를 가져와서 List에 담아 반환하는 메서드
	 * @param smc SqlMapclient 객체 
	 * @return 게시글정보를 담고있는 List 객체
	 * @throws SQLException JDBC관련 예외객체
	 */
	public List<BoardVO> getAllBoardlist(SqlMapClient smc) throws SQLException;
	
	
	/**
	 * 하나의 게시글번호(boardNo)를 이용하여 DB를 update하는 메서드
	 * @param smc SqlMapclient 객체
	 * @param column 수정하고 싶은 속성(컬럼)
	 * @param content 수정내용
	 * @param board_no 글번호
	 * @return 작업성공 : 1, 작업실패 : 0
	 * @throws SQLException JDBC관련 예외객체
	 */
	public int updateBoard(SqlMapClient smc, BoardVO bv) throws SQLException;
	
	/**
	 * 게시글번호(boardNo)를 매개변수로 받아서 그 게시글을 삭제하는 메서드
	 * @param smc SqlMapclient 객체
	 * @param boardNo 삭제할 게시글번호
	 * @return 작업성공 :1, 작업실패 : 0
	 * @throws SQLException JDBC관련 예외 객체
	 */
	
	public int deleteBoard(SqlMapClient smc,String boardNo) throws SQLException;
	
	/**
	 * 주어진 키워드를 포함하고 있는 레코드를 List에 담아 반환하는 메서드
	 * @param smc SqlMapclient 객체
	 * @param column  검색 범위(e.g. 어느 속성에서 검색할건지)
	 * @param keyword  검색 키워드
	 * @return 검색 키워드를 포함하고 있는 게시판 List 객체
	 * @throws SQLException JDBC관련 예외객체
	 */
	public List<BoardVO> searchBoard(SqlMapClient smc,BoardVO bv) throws SQLException;
	
}
