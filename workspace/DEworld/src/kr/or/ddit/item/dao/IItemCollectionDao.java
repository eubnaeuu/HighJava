package kr.or.ddit.item.dao;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.item.vo.ItemCollectionVO

public interface IItemCollectionDao {
	
	 
	public List<ItemCollection VO> getAllItemCollectionList(SqlMapClient smc)
	 					throws SQLException;
	
	
	public List<ItemCollection VO> getSearchItemCollection(SqlMapClient smc, String searchItemCollectionName) throws SQLException;
 

	public ItemCollection VO getItemCollection(SqlMapClient smc, String itemId) throws SQLException;
	
	public int insertWishlist(SqlMapClient smc, ItemCollection VO iv) throws SQLException;

	public List<ItemCollection VO> getFriendList(SqlMapClient smc, String memId) throws SQLException;

	public int buyItemCollection(SqlMapClient smc, ItemCollection VO iv) throws SQLException;

	public int giftItemCollection(SqlMapClient smc, ItemCollection VO iv) throws SQLException;
}
