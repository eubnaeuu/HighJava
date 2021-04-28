package kr.or.ddit.guestbook.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.guestbook.dao.GuestBookDao;
import kr.or.ddit.guestbook.dao.GuestBookDaoImpl;
import kr.or.ddit.guestbook.vo.GuestBookVO;
import kr.or.ddit.util.SqlMapClientUtil;

public class GuestBookServiceImpl implements GuestBookService {
	
	private GuestBookDao postDao;
	private SqlMapClient smc;
	
	private static GuestBookService service;
	
	private GuestBookServiceImpl() {
		postDao = GuestBookDaoImpl.getInstance();
		smc = SqlMapClientUtil.getInstance();
	}
	
	public static GuestBookService getInstance() {
		if(service == null) {
			service = new GuestBookServiceImpl();
		}
		return service;
	}

	@Override
	public int insertGuestBook(GuestBookVO pv) {
		
		int cnt = 0;
		
		try {
			cnt = postDao.insertGuestBook(smc, pv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public boolean checkGuestBook(String postId) {
		
		boolean chk = false;
		
		try {
			chk = postDao.checkGuestBook(smc, postId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return chk;
	}

	@Override
	public List<GuestBookVO> getGuestBookList(GuestBookVO apv) {
		
		List<GuestBookVO> list = new ArrayList<>();
		
		try {
			list = postDao.getGuestBookList(smc, apv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int updateGuestBook(GuestBookVO pv) {
		int cnt = 0;
		
		try {
			cnt = postDao.updateGuestBook(smc, pv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}
	@Override
	public int updateGuestBookView(GuestBookVO pv) {
		int cnt = 0;
		
		try {
			cnt = postDao.updateGuestBookView(smc, pv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int deleteGuestBook(String postId) {
		int cnt = 0;
		try {
			cnt = postDao.deleteGuestBook(smc, postId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}
	
	@Override
	public List<GuestBookVO> getSearchGuestBook(GuestBookVO apv) {
		
		List<GuestBookVO> memList = new ArrayList<>();
		
		try {
			memList = postDao.getSearchGuestBook(smc, apv);
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return memList;
	}


	@Override
	public GuestBookVO getGuestBookView(GuestBookVO pv) {
		
		GuestBookVO postvo = null;
		
		try {
			postvo = postDao.getGuestBookView(smc, pv);
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return postvo;
	}

	@Override
	public int getAllGuestBookListCount(GuestBookVO pv) {
		int cnt=-1;
		try {
			cnt = postDao.getGuestBookListCount(smc,pv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}



}
