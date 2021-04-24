package kr.or.ddit.faq.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.faq.dao.FaqDaoImpl;
import kr.or.ddit.faq.dao.IFaqDao;
import kr.or.ddit.faq.vo.FaqVO;
import kr.or.ddit.util.SqlMapClientUtil;

public class FaqServiceImpl implements IFaqService {
	
	private IFaqDao faqDao;
	private SqlMapClient smc;
	
	private static IFaqService service;
	
	private FaqServiceImpl() {
		faqDao = FaqDaoImpl.getInstance();
		smc = SqlMapClientUtil.getInstance();
	}
	
	public static IFaqService getInstance() {
		if(service == null) {
			service = new FaqServiceImpl();
		}
		
		return service;
	}

	
	@Override
	public List<FaqVO> getAllFaqList() {
		
		List<FaqVO> faqList = new ArrayList<>();
		
		try {
			faqList = faqDao.getAllFaqList(smc);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return faqList;
	}

	@Override
	public List<FaqVO> getSearchFaq(FaqVO iv) {
		List<FaqVO> faqList = new ArrayList<>();
		
		try {
			faqList = smc.queryForList("faq.getSearchFaq", iv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	      
	    return faqList;
	}

	@Override
	public FaqVO getFaq(String faqId) {
		
		FaqVO iv = null;
		
		try {
			iv = faqDao.getFaq(smc, faqId);
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return iv;
	}
	

}
