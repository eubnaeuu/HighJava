package kr.or.ddit.comments.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.comments.dao.CommentsDao;
import kr.or.ddit.comments.dao.CommentsDaoImpl;
import kr.or.ddit.comments.vo.CommentsVO;
import kr.or.ddit.util.SqlMapClientUtil;

public class CommentsServiceImpl implements CommentsService {
	
	private CommentsDao CommentsDao;
	private SqlMapClient smc;
	
	private static CommentsService service;
	
	private CommentsServiceImpl() {
		CommentsDao = CommentsDaoImpl.getInstance();
		smc = SqlMapClientUtil.getInstance();
	}
	
	public static CommentsService getInstance() {
		if(service == null) {
			service = new CommentsServiceImpl();
		}
		return service;
	}

	@Override
	public int insertComments(CommentsVO cv) {
		
		int cnt = 0;
		
		try {
			cnt = CommentsDao.insertComments(smc, cv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public boolean checkComments(String CommentsId) {
		
		boolean chk = false;
		
		try {
			chk = CommentsDao.checkComments(smc, CommentsId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return chk;
	}

	@Override
	public List<CommentsVO> getAllCommentsList() {
		
		List<CommentsVO> list = new ArrayList<>();
		
		try {
			list = CommentsDao.getAllCommentsList(smc);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int updateComments(CommentsVO cv) {
		int cnt = 0;
		
		try {
			cnt = CommentsDao.updateComments(smc, cv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int deleteComments(String CommentsId) {
		int cnt = 0;
		try {
			cnt = CommentsDao.deleteComments(smc, CommentsId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}
	
	@Override
	public List<CommentsVO> getSearchComments(CommentsVO cv) {
		
		List<CommentsVO> memList = new ArrayList<>();
		
		try {
			memList = CommentsDao.getSearchComments(smc, cv);
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return memList;
	}

	@Override
	public CommentsVO getComments(String CommentsId) {
		
		CommentsVO cv = null;
		
		try {
			cv = CommentsDao.getComments(smc, CommentsId);
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return cv;
	}

}
