package kr.or.ddit.whishlist.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.whishlist.vo.WhishlistVO;


public class WhishlistDaoImpl implements IWhishlistDao {

   private static IWhishlistDao whishlistDao;
   
   private WhishlistDaoImpl() {
	   
   }
   
   public static IWhishlistDao getInstance() {
	   if(whishlistDao == null) {
		   whishlistDao = new WhishlistDaoImpl();
	   }
	   
	   return whishlistDao;
   }
   

   @Override
   public List<WhishlistVO> getAllWhishlistList(SqlMapClient smc) throws SQLException {
      
      List<WhishlistVO> whishlistList = smc.queryForList("whishlist.getWhishlistAll");
     
      return whishlistList;
   }

  
  


}






