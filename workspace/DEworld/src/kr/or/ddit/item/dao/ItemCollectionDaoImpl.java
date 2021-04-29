package kr.or.ddit.item.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;



public class ItemCollectionDaoImpl implements IItemCollectionCollectionDao {

   private static IItemCollectionCollectionDao itemDao;
   
   private ItemCollectionDaoImpl() {
	   
   }
   
   public static IItemCollectionCollectionDao getInstance() {
	   if(itemDao == null) {
		   itemDao = new ItemCollectionDaoImpl();
	   }
	   
	   return itemDao;
   }
   

   @Override
   public List<ItemCollection VO> getAllItemCollectionList(SqlMapClient smc) throws SQLException {
      
      List<ItemCollection VO> itemList = smc.queryForList("item.getItemCollectionAll");
     
      return itemList;
   }

  
   @Override
   public List<ItemCollection VO> getSearchItemCollection(SqlMapClient smc,String searchItemCollectionName) throws SQLException {
      
      List<ItemCollection VO> itemList = 
    		  smc.queryForList("item.getSearchItemCollection", searchItemCollectionName);
      
      return itemList;
   }

	@Override
	public ItemCollection VO getItemCollection(SqlMapClient smc, String itemId) throws SQLException {
		ItemCollection VO icv = (ItemCollection VO) smc.queryForObject("item.getItemCollection",itemId);
		return icv;
	}

	@Override
	public int insertWishlist(SqlMapClient smc, ItemCollection VO icv) throws SQLException {
	
		int cnt = 0;
		Object obj = smc.insert("item.insertWishlist",icv);
		if(obj == null) {
			cnt = 1;
		}
		
		return cnt;
	}

	@Override
	public List<ItemCollection VO> getFriendList(SqlMapClient smc, String memId) throws SQLException {
		List<ItemCollection VO> friendList = smc.queryForList("item.getFriendList", memId);
		return friendList;
	}

	@Override
	public int buyItemCollection(SqlMapClient smc, ItemCollection VO icv) throws SQLException {
		smc.update("item.payment",icv); // 결제
		
		int cnt = 0;
		Object obj = smc.insert("item.buyItemCollection",icv); // collection에 추가
		if(obj == null) {
			cnt = 1;
		}
		
		return cnt;
	}

	@Override
	public int giftItemCollection(SqlMapClient smc, ItemCollection VO icv) throws SQLException {
		smc.update("item.payment",icv); // 결제
		
		int cnt = 0;
		Object obj = smc.insert("item.giftItemCollection",icv); // collection에 추가
		if(obj == null) {
			cnt = 1;
		}
		
		return cnt;
	}


}






