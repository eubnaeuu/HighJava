package kr.or.ddit.buy.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.buy.dao.BuyDaoImpl;
import kr.or.ddit.buy.dao.IBuyDao;
import kr.or.ddit.buy.vo.BuyVO;
import kr.or.ddit.util.SqlMapClientUtil;

public class BuyServiceImpl implements IBuyService {
	
	private IBuyDao buyDao;
	private SqlMapClient smc;
	
	private static IBuyService service;
	
	private BuyServiceImpl() {
		buyDao = BuyDaoImpl.getInstance();
		smc = SqlMapClientUtil.getInstance();
	}
	
	public static IBuyService getInstance() {
		if(service == null) {
			service = new BuyServiceImpl();
		}
		
		return service;
	}

	
	@Override
	public List<BuyVO> getAllBuyList(BuyVO wv) {
		
		List<BuyVO> buyList = new ArrayList<>();
		
		try {
			buyList = buyDao.getAllBuyList(smc, wv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return buyList;
	}

	
	

}
