package kr.or.ddit.friendreq.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.friendreq.dao.FriendReqDao;
import kr.or.ddit.friendreq.dao.FriendReqDaoImpl;
import kr.or.ddit.friendreq.vo.FriendReqVO;
import kr.or.ddit.util.SqlMapClientUtil;

public class FriendReqServiceImpl implements FriendReqService {
	
	private FriendReqDao FriendReqDao;
	private SqlMapClient smc;
	
	private static FriendReqService service;
	
	private FriendReqServiceImpl() {
		FriendReqDao = FriendReqDaoImpl.getInstance();
		smc = SqlMapClientUtil.getInstance();
	}
	
	public static FriendReqService getInstance() {
		if(service == null) {
			service = new FriendReqServiceImpl();
		}
		return service;
	}

	@Override
	public int insertFriendReq(FriendReqVO fv) {
		
		int cnt = 0;
		
		try {
			cnt = FriendReqDao.insertFriendReq(smc, fv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public boolean checkFriendReq(String FriendReqId) {
		
		boolean chk = false;
		
		try {
			chk = FriendReqDao.checkFriendReq(smc, FriendReqId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return chk;
	}

	@Override
	public List<FriendReqVO> getAllFriendReqList() {
		
		List<FriendReqVO> list = new ArrayList<>();
		
		try {
			list = FriendReqDao.getAllFriendReqList(smc);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int updateFriendReq(FriendReqVO fv) {
		int cnt = 0;
		
		try {
			cnt = FriendReqDao.updateFriendReq(smc, fv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int deleteFriendReq(FriendReqVO fv) {
		int cnt = 0;
		try {
			cnt = FriendReqDao.deleteFriendReq(smc, fv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}
	
	@Override
	public List<FriendReqVO> getSearchFriendReq(FriendReqVO fv) {
		
		List<FriendReqVO> list = new ArrayList<>();
		
		try {
			list = FriendReqDao.getSearchFriendReq(smc, fv);
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return list;
	}

}
