package kr.or.ddit.collection.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.collection.vo.CollectionVO;
import kr.or.ddit.item.vo.ItemVO;


public class CollectionDaoImpl implements CollectionDao {

   private static CollectionDao collectionDao;
   
   private CollectionDaoImpl() {
	   
   }
   
   public static CollectionDao getInstance() {
	   if(collectionDao == null) {
		   collectionDao = new CollectionDaoImpl();
	   }
	   
	   return collectionDao;
   }

@Override
public List<CollectionVO> getSearchItemCollection(SqlMapClient smc, CollectionVO cv) throws SQLException {
	  List<CollectionVO> itemList = 
    		  smc.queryForList("collection.getSearchItemCollection", cv);
      
      return itemList;
}

@Override
public List<CollectionVO> getSearchMusicCollection(SqlMapClient smc, String memId) throws SQLException {
	  List<CollectionVO> itemList = 
    		  smc.queryForList("collection.getSearchItemCollection", memId);
      
      return itemList;
}
   



}






