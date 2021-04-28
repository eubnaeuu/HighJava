package kr.or.ddit.guestbook.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.guestbook.vo.GuestBookVO;

/**
 * 실제 DB와 연결해서 SQL문을 수행하여 결과를 작성하여 서비스에 전달하는 DAO 인터페이스
 *
 */
public interface GuestBookDao {

	
	public int insertGuestBook(SqlMapClient smc, GuestBookVO pv) throws SQLException;

	

	public boolean checkGuestBook(SqlMapClient smc, String postNo) throws SQLException;

	

	public List<GuestBookVO> getGuestBookList(SqlMapClient smc, GuestBookVO apv) throws SQLException;

	
	public int updateGuestBook(SqlMapClient smc, GuestBookVO pv) throws SQLException;

	public int updateGuestBookView(SqlMapClient smc, GuestBookVO pv) throws SQLException;

	
	public int deleteGuestBook(SqlMapClient smc, String postNo) throws SQLException;

	
	public List<GuestBookVO> getSearchGuestBook(SqlMapClient smc, GuestBookVO apv) throws SQLException;



	public GuestBookVO getGuestBookView(SqlMapClient smc, GuestBookVO pv) throws SQLException;

	public int getGuestBookListCount(SqlMapClient smc, GuestBookVO pv) throws SQLException;
}
