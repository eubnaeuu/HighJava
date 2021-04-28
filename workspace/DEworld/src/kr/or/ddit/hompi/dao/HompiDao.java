package kr.or.ddit.hompi.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.hompi.vo.HompiVO;

/**
 * 실제 DB와 연결해서 SQL문을 수행하여 결과를 작성하여 서비스에 전달하는 DAO 인터페이스
 *
 */
public interface HompiDao {

	
	public int insertHompi(SqlMapClient smc, HompiVO hv) throws SQLException;

	

	public boolean checkHompi(SqlMapClient smc, String postNo) throws SQLException;

	

	public List<HompiVO> getHompiList(SqlMapClient smc, HompiVO apv) throws SQLException;

	
	public int updateHompi(SqlMapClient smc, HompiVO hv) throws SQLException;

	public int updateHompiView(SqlMapClient smc, HompiVO hv) throws SQLException;

	
	public int deleteHompi(SqlMapClient smc, String postNo) throws SQLException;

	
	public List<HompiVO> getSearchHompi(SqlMapClient smc, HompiVO apv) throws SQLException;



	public HompiVO getHompiView(SqlMapClient smc, HompiVO hv) throws SQLException;

	public int getHompiListCount(SqlMapClient smc, HompiVO hv) throws SQLException;
}
