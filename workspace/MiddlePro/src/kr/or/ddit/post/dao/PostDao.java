package kr.or.ddit.post.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.post.vo.PostVO;

/**
 * 실제 DB와 연결해서 SQL문을 수행하여 결과를 작성하여 서비스에 전달하는 DAO 인터페이스
 *
 */
public interface PostDao {
	
	/**
	 * PostVO 객체에 담겨진 자료를 DB에 insert하는 메서드
	 * @param smc SqlMapClient 객체
	 * @param pv DB에 insert할 자료가 저장된 PostVO객체
	 * @return DB작업이 성공하면 1이상의 값이 반환되고, 실패하면 0이 반환된다.
	 * @throws SQLException JDBC관련 예외객체 발생
	 */
	public int insertPost(SqlMapClient smc, PostVO pv) throws SQLException;
	
	/**
	 * 주어진 회원ID가 존재하는지 여부를 알아내는 메서드
	 * @param smc SqlMapClient 객체
	 * @param postNo 회원ID
	 * @return 해당 회원ID가 존재하면 true, 존재하지 않으면 false
	 * @throws SQLException JDBC관련 예외객체 발생
	 */
	public boolean checkPost(SqlMapClient smc, String postNo)
						throws SQLException;
	
	/**
	 * DB의 myPOST테이블의 전체 레코드를 가져와서 List에 담아 반환하는 메서드
	 * @param smc SqlMapClient 객체
	 * @return 회원정보를 담고있는 List객체
	 * @throws SQLException JDBC관련 예외객체
	 */
	
	public List<PostVO> getAllPostList(SqlMapClient smc)
	 					throws SQLException;
	
	/**
	 * 하나의 회원정보를 이용하여 DB를 update하는 메서드
	 * @param smc SqlMapClient 객체
	 * @param pv 회원정보 객체
	 * @return 작업성공: 1, 작업실패: 0
	 * @throws SQLException JDBC 예외객체
	 */
	public int updatePost(SqlMapClient smc, PostVO pv)
						throws SQLException;
	/**
	 * 회원 ID를 매개변수로 받아서 그 회원정보를 삭제하는 메서드
	 * @param smc SqlMapClient 객체
	 * @param postNo 삭제할 회원ID
	 * @return 작업성공 : 1, 작업실패: 0 
	 * @throws SQLException JDBC관련 예외 객체
	 */
	public int deletePost(SqlMapClient smc, String postNo)
						throws SQLException;
	
	/**
	 * PostVO 객체에 담긴 자료를 이용하여 회원을 검색하는 메서드
	 * @param smc SqlMapClient 객체
	 * @param pv 검색할 자료가 들어있는 PostVO 객체
	 * @return 검색된 결과를 담은 List
	 * @throws SQLException JDBC관련 예외 객체
	 */
	public List<PostVO> getSearchPost(SqlMapClient smc, PostVO pv) 
						throws SQLException;
	
	/**
	 * 주어진 회원 ID에 해당하는 회원정보를 조회하는 메서드
	 * @param smc SqlMapClient 객체
	 * @param postNo 검색할 회원 ID
	 * @return 해당 회원 ID 에 해당하는 회원 정보
	 */
	public PostVO getPost(SqlMapClient smc, String postNo) throws SQLException;;
}
