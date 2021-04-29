package kr.or.ddit.itemcollection.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.item.vo.ItemCollectionVO;
import kr.or.ddit.member.vo.MemberVO;

public interface IItemDao {
	
	 
	public List<ItemCollectionVO> getAllItemList(SqlMapClient smc)
	 					throws SQLException;
	
	
	public List<ItemCollectionVO> getSearchItem(SqlMapClient smc, String searchItemName) throws SQLException;
 

	public ItemCollectionVO getItem(SqlMapClient smc, String itemId) throws SQLException;
	
	public int insertWishlist(SqlMapClient smc, ItemCollectionVO iv) throws SQLException;

	public List<ItemCollectionVO> getFriendList(SqlMapClient smc, String memId) throws SQLException;

	public int buyItem(SqlMapClient smc, ItemCollectionVO iv) throws SQLException;

	public int giftItem(SqlMapClient smc, ItemCollectionVO iv) throws SQLException;
}
