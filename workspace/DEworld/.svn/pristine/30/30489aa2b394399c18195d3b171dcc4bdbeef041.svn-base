package kr.or.ddit.buy.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.buy.vo.BuyVO;


public class BuyDaoImpl implements IBuyDao {

   private static IBuyDao buyDao;
   
   private BuyDaoImpl() {
	   
   }
   
   public static IBuyDao getInstance() {
	   if(buyDao == null) {
		   buyDao = new BuyDaoImpl();
	   }
	   
	   return buyDao;
   }
   

   @Override
   public List<BuyVO> getAllBuyList(SqlMapClient smc, BuyVO wv) throws SQLException {
      
      List<BuyVO> buyList = smc.queryForList("buy.getBuyAll", wv);
     
      return buyList;
   }

  
  


}






