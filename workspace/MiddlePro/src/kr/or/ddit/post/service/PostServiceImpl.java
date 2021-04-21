package kr.or.ddit.post.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.post.dao.PostDao;
import kr.or.ddit.post.dao.PostDaoImpl;
import kr.or.ddit.post.vo.PostVO;
import kr.or.ddit.util.SqlMapClientUtil;

public class PostServiceImpl implements PostService {
	
	private PostDao postDao;
	private SqlMapClient smc;
	
	private static PostService service;
	
	private PostServiceImpl() {
		postDao = PostDaoImpl.getInstance();
		smc = SqlMapClientUtil.getInstance();
	}
	
	public static PostService getInstance() {
		if(service == null) {
			service = new PostServiceImpl();
		}
		return service;
	}

	@Override
	public int insertPost(PostVO pv) {
		
		int cnt = 0;
		
		try {
			cnt = postDao.insertPost(smc, pv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public boolean checkPost(String postId) {
		
		boolean chk = false;
		
		try {
			chk = postDao.checkPost(smc, postId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return chk;
	}

	@Override
	public List<PostVO> getAllPostList() {
		
		List<PostVO> memList = new ArrayList<>();
		
		try {
			memList = postDao.getAllPostList(smc);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return memList;
	}

	@Override
	public int updatePost(PostVO pv) {
		int cnt = 0;
		
		try {
			cnt = postDao.updatePost(smc, pv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int deletePost(String postId) {
		int cnt = 0;
		try {
			cnt = postDao.deletePost(smc, postId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}
	
	@Override
	public List<PostVO> getSearchPost(PostVO pv) {
		
		List<PostVO> memList = new ArrayList<>();
		
		try {
			memList = postDao.getSearchPost(smc, pv);
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return memList;
	}

	@Override
	public PostVO getPost(String postId) {
		
		PostVO pv = null;
		
		try {
			pv = postDao.getPost(smc, postId);
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return pv;
	}

}
