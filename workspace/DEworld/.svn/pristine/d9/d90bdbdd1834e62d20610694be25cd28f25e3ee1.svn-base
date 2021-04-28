package kr.or.ddit.friend.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.friend.dao.FriendDao;
import kr.or.ddit.friend.dao.FriendDaoImpl;
import kr.or.ddit.friend.vo.FriendVO;
import kr.or.ddit.util.SqlMapClientUtil;

public class FriendServiceImpl implements FriendService {
	
	private FriendDao FriendDao;
	private SqlMapClient smc;
	
	private static FriendService service;
	
	private FriendServiceImpl() {
		FriendDao = FriendDaoImpl.getInstance();
		smc = SqlMapClientUtil.getInstance();
	}
	
	public static FriendService getInstance() {
		if(service == null) {
			service = new FriendServiceImpl();
		}
		return service;
	}

	@Override
	public int insertFriend(FriendVO fv) {
		
		int cnt = 0;
		
		try {
			cnt = FriendDao.insertFriend(smc, fv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public boolean checkFriend(String FriendId) {
		
		boolean chk = false;
		
		try {
			chk = FriendDao.checkFriend(smc, FriendId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return chk;
	}

	@Override
	public List<FriendVO> getAllFriendList() {
		
		List<FriendVO> list = new ArrayList<>();
		
		try {
			list = FriendDao.getAllFriendList(smc);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int updateFriend(FriendVO fv) {
		int cnt = 0;
		
		try {
			cnt = FriendDao.updateFriend(smc, fv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int deleteFriend(FriendVO fv) {
		int cnt = 0;
		try {
			cnt = FriendDao.deleteFriend(smc, fv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}
	
	@Override
	public List<FriendVO> getSearchFriend(FriendVO fv) {
		
		List<FriendVO> list = new ArrayList<>();
		
		try {
			list = FriendDao.getSearchFriend(smc, fv);
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return list;
	}

}
