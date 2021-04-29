package kr.or.ddit.whishlist.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.util.SqlMapClientUtil;
import kr.or.ddit.whishlist.dao.IWhishlistDao;
import kr.or.ddit.whishlist.dao.WhishlistDaoImpl;
import kr.or.ddit.whishlist.vo.WhishlistVO;

public class WhishlistServiceImpl implements IWhishlistService {
	
	private IWhishlistDao whishlistDao;
	private SqlMapClient smc;
	
	private static IWhishlistService service;
	
	private WhishlistServiceImpl() {
		whishlistDao = WhishlistDaoImpl.getInstance();
		smc = SqlMapClientUtil.getInstance();
	}
	
	public static IWhishlistService getInstance() {
		if(service == null) {
			service = new WhishlistServiceImpl();
		}
		
		return service;
	}

	
	@Override
	public List<WhishlistVO> getAllWhishlistList() {
		
		List<WhishlistVO> whishlistList = new ArrayList<>();
		
		try {
			whishlistList = whishlistDao.getAllWhishlistList(smc);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return whishlistList;
	}

	
	

}
