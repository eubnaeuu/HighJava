package kr.or.ddit.hompi.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.hompi.dao.HompiDao;
import kr.or.ddit.hompi.vo.HompiVO;


public class HompiDaoImpl implements HompiDao {

   private static HompiDao hompiDao;
   
   private HompiDaoImpl() {
	   
   }
   
   public static HompiDao getInstance() {
	   if(hompiDao == null) {
		   hompiDao = new HompiDaoImpl();
	   }
	   
	   return hompiDao;
   }
   
   @Override
   public int insertHompi(SqlMapClient smc, HompiVO pv) throws SQLException {
	   	int cnt = 0;
	   
        Object obj = smc.insert("hompi.insertHompi", pv);
        
        if(obj == null) {
        	cnt = 1;
        }
      return cnt;
   }

   @Override
   public boolean checkHompi(SqlMapClient smc, String hompiNo) throws SQLException {
      boolean chk = false;
      
      int cnt = (int) smc.queryForObject("hompi.getHompi", hompiNo);
      
      if(cnt > 0) {
    	  chk = true;
      }
      return chk;
   }

   @Override
   public List<HompiVO> getHompiList(SqlMapClient smc, HompiVO apv) throws SQLException {
      
      List<HompiVO> hompiList = smc.queryForList("hompi.getHompi", apv);
      return hompiList;
   }

   @Override
   public int updateHompi(SqlMapClient smc, HompiVO pv) throws SQLException {
      
      int cnt = 0;
      cnt = smc.update("hompi.updateHompi", pv);
      return cnt;
   }
   @Override
   public int updateHompiView(SqlMapClient smc, HompiVO pv) throws SQLException {
	   
	   int cnt = 0;
	   cnt = smc.update("hompi.updateHompiView", pv);
	   return cnt;
   }

   @Override
   public int deleteHompi(SqlMapClient smc, String hompiNo) throws SQLException {
      
      int cnt = smc.delete("hompi.deleteHompi", hompiNo);
      
      return cnt;
   }

   @Override
   public List<HompiVO> getSearchHompi(SqlMapClient smc,HompiVO apv) throws SQLException {
      
      List<HompiVO> hompiList = 
    		  smc.queryForList("hompi.getSearchHompi", apv);
      
      return hompiList;
   }

   @Override
   public HompiVO getHompiView(SqlMapClient smc, HompiVO pv) throws SQLException {
	   HompiVO hompivo = 
			(HompiVO)smc
			.queryForObject("hompi.getHompiView", pv);
	
			return hompivo;
	}
   @Override
public int getHompiListCount(SqlMapClient smc,HompiVO pv) throws SQLException {
	int cnt = 0;
    cnt = (int) smc.queryForObject("hompi.getHompiAllCount", pv);
	return cnt;
}
}


































