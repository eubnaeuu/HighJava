package kr.or.ddit.hompi.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.hompi.dao.HompiDao;
import kr.or.ddit.hompi.dao.HompiDaoImpl;
import kr.or.ddit.hompi.vo.HompiVO;
import kr.or.ddit.util.SqlMapClientUtil;

public class HompiServiceImpl implements HompiService {
	
	private HompiDao HompiDao;
	private SqlMapClient smc;
	
	private static HompiService service;
	
	private HompiServiceImpl() {
		HompiDao = HompiDaoImpl.getInstance();
		smc = SqlMapClientUtil.getInstance();
	}
	
	public static HompiService getInstance() {
		if(service == null) {
			service = new HompiServiceImpl();
		}
		return service;
	}

	@Override
	public int insertHompi(HompiVO pv) {
		
		int cnt = 0;
		
		try {
			cnt = HompiDao.insertHompi(smc, pv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public boolean checkHompi(String postId) {
		
		boolean chk = false;
		
		try {
			chk = HompiDao.checkHompi(smc, postId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return chk;
	}

	@Override
	public List<HompiVO> getHompiList(HompiVO apv) {
		
		List<HompiVO> list = new ArrayList<>();
		
		try {
			list = HompiDao.getHompiList(smc, apv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int updateHompi(HompiVO pv) {
		int cnt = 0;
		
		try {
			cnt = HompiDao.updateHompi(smc, pv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}
	@Override
	public int updateHompiView(HompiVO pv) {
		int cnt = 0;
		
		try {
			cnt = HompiDao.updateHompiView(smc, pv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int deleteHompi(String postId) {
		int cnt = 0;
		try {
			cnt = HompiDao.deleteHompi(smc, postId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}
	
	@Override
	public List<HompiVO> getSearchHompi(HompiVO apv) {
		
		List<HompiVO> memList = new ArrayList<>();
		
		try {
			memList = HompiDao.getSearchHompi(smc, apv);
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return memList;
	}


	@Override
	public HompiVO getHompiView(HompiVO pv) {
		
		HompiVO postvo = null;
		
		try {
			postvo = HompiDao.getHompiView(smc, pv);
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return postvo;
	}

	@Override
	public int getAllHompiListCount(HompiVO pv) {
		int cnt=-1;
		try {
			cnt = HompiDao.getHompiListCount(smc,pv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}



}
