package kr.or.ddit.faq.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.faq.vo.FaqVO;

public interface IFaqDao {
	
	 
	public List<FaqVO> getAllFaqList(SqlMapClient smc)
	 					throws SQLException;
	
	
	public List<FaqVO> getSearchFaq(SqlMapClient smc, FaqVO iv) 
						throws SQLException;
 

	public FaqVO getFaq(SqlMapClient smc, String faqId) throws SQLException;
	

}
