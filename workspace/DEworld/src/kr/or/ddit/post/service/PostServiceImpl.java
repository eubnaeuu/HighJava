package kr.or.ddit.post.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.post.dao.PostDao;
import kr.or.ddit.post.dao.PostDaoImpl;
import kr.or.ddit.post.vo.AllPostVO;
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
	public List<PostVO> getAllPostList(AllPostVO apv) {
		
		List<PostVO> list = new ArrayList<>();
		
		try {
			list = postDao.getAllPostList(smc, apv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
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
	public int updatePostView(PostVO pv) {
		int cnt = 0;
		
		try {
			cnt = postDao.updatePostView(smc, pv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int deletePost(String postId) {
		int cnt = 0;
		try {
			System.out.println("deleteDAO 전 ");
			cnt = postDao.deletePost(smc, postId);
			System.out.println("deleteDAO 후");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}
	
	@Override
	public List<PostVO> getSearchPost(AllPostVO apv) {
		
		List<PostVO> memList = new ArrayList<>();
		
		try {
			memList = postDao.getSearchPost(smc, apv);
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return memList;
	}
	@Override
	public List<PostVO> getSearchPhoto(AllPostVO apv) {
		
		List<PostVO> memList = new ArrayList<>();
		
		try {
			memList = postDao.getSearchPhoto(smc, apv);
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return memList;
	}

	@Override
	public PostVO getPostView(PostVO pv) {
		
		PostVO postvo = null;
		
		try {
			postvo = postDao.getPostView(smc, pv);
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return postvo;
	}

	@Override
	public int getAllPostListCount(PostVO pv) {
		int cnt=-1;
		try {
			cnt = postDao.getAllPostListCount(smc,pv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

}
