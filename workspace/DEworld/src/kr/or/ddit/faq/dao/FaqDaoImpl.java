package kr.or.ddit.faq.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.faq.vo.FaqVO;


public class FaqDaoImpl implements IFaqDao {

   private static IFaqDao faqDao;
   
   private FaqDaoImpl() {
	   
   }
   
   public static IFaqDao getInstance() {
	   if(faqDao == null) {
		   faqDao = new FaqDaoImpl();
	   }
	   
	   return faqDao;
   }
   

   @Override
   public List<FaqVO> getAllFaqList(SqlMapClient smc) throws SQLException {
      
      List<FaqVO> faqList = smc.queryForList("faq.getFaqAll");
     
      return faqList;
   }

  
   @Override
   public List<FaqVO> getSearchFaq(SqlMapClient smc,FaqVO iv) throws SQLException {
      
      List<FaqVO> faqList = 
    		  smc.queryForList("faq.getSearchFaq", iv);
      
      return faqList;
   }

	@Override
	public FaqVO getFaq(SqlMapClient smc, String faqId) throws SQLException {
		FaqVO iv = (FaqVO) smc.queryForObject("faq.getFaq",faqId);
		return iv;
	}


}






