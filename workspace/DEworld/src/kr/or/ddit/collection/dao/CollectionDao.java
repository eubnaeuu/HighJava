package kr.or.ddit.collection.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.collection.vo.CollectionVO;

public interface CollectionDao {
	
	public List<CollectionVO> getSearchItemCollection(SqlMapClient smc, CollectionVO cv) throws SQLException;
	public List<CollectionVO> getSearchMusicCollection(SqlMapClient smc, String memId) throws SQLException;
 
}