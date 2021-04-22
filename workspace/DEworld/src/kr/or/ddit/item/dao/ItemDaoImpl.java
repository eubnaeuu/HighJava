package kr.or.ddit.item.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.item.vo.ItemVO;
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
   public List<ItemVO> getAllItemList(SqlMapClient smc) throws SQLException {
      
      List<ItemVO> itemList = smc.queryForList("item.getItemAll");
     
      return itemList;
   }

  
   @Override
   public List<ItemVO> getSearchItem(SqlMapClient smc,ItemVO iv) throws SQLException {
      
      List<ItemVO> itemList = 
    		  smc.queryForList("item.getSearchItem", iv);
      
      return itemList;
   }


}






