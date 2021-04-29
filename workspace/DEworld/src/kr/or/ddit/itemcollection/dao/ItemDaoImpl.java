package kr.or.ddit.itemcollection.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.item.vo.ItemCollectionVO;
import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.util.SqlMapClientUtil;


public class ItemDaoImpl implements IItemDao {

   private static IItemDao itemDao;
   
   private ItemDaoImpl() {
	   
   }
   
   public static IItemDao getInstance() {
	   if(itemDao == null) {
		   itemDao = new ItemDaoImpl();
	   }
	   
	   return itemDao;
   }
   

   @Override
   public List<ItemCollectionVO> getAllItemList(SqlMapClient smc) throws SQLException {
      
      List<ItemCollectionVO> itemList = smc.queryForList("item.getItemAll");
     
      return itemList;
   }

  
   @Override
   public List<ItemCollectionVO> getSearchItem(SqlMapClient smc,String searchItemName) throws SQLException {
      
      List<ItemCollectionVO> itemList = 
    		  smc.queryForList("item.getSearchItem", searchItemName);
      
      return itemList;
   }

	@Override
	public ItemCollectionVO getItem(SqlMapClient smc, String itemId) throws SQLException {
		ItemCollectionVO iv = (ItemCollectionVO) smc.queryForObject("item.getItem",itemId);
		return iv;
	}

	@Override
	public int insertWishlist(SqlMapClient smc, ItemCollectionVO iv) throws SQLException {
	
		int cnt = 0;
		Object obj = smc.insert("item.insertWishlist",iv);
		if(obj == null) {
			cnt = 1;
		}
		
		return cnt;
	}

	@Override
	public List<ItemCollectionVO> getFriendList(SqlMapClient smc, String memId) throws SQLException {
		List<ItemCollectionVO> friendList = smc.queryForList("item.getFriendList", memId);
		return friendList;
	}

	@Override
	public int buyItem(SqlMapClient smc, ItemCollectionVO iv) throws SQLException {
		smc.update("item.payment",iv); // 결제
		
		int cnt = 0;
		Object obj = smc.insert("item.buyItem",iv); // collection에 추가
		if(obj == null) {
			cnt = 1;
		}
		
		return cnt;
	}

	@Override
	public int giftItem(SqlMapClient smc, ItemCollectionVO iv) throws SQLException {
		smc.update("item.payment",iv); // 결제
		
		int cnt = 0;
		Object obj = smc.insert("item.giftItem",iv); // collection에 추가
		if(obj == null) {
			cnt = 1;
		}
		
		return cnt;
	}


}






