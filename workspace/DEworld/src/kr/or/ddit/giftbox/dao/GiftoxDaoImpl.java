package kr.or.ddit.giftbox.dao;

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


public class GiftoxDaoImpl implements IgiftboxDao {

   private static IgiftboxDao giftboxDao;
   
   private GiftoxDaoImpl() {
	   
   }
   
   public static IgiftboxDao getInstance() {
	   if(giftboxDao == null) {
		   giftboxDao = new GiftoxDaoImpl();
	   }
	   
	   return giftboxDao;
   }
   

   @Override
   public List<ItemVO> getAllGiftboxist(SqlMapClient smc) throws SQLException {
      
      List<GiftboxVO> giftboxList = smc.queryForList("giftbox.getItemAll");
     
      return giftboxList;
   }

  
  


}






