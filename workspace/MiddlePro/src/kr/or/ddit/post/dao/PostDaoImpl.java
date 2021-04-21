package kr.or.ddit.post.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.post.vo.PostVO;


public class PostDaoImpl implements PostDao {

   private static PostDao postDao;
   
   private PostDaoImpl() {
	   
   }
   
   public static PostDao getInstance() {
	   if(postDao == null) {
		   postDao = new PostDaoImpl();
	   }
	   
	   return postDao;
   }
   
   @Override
   public int insertPost(SqlMapClient smc, PostVO pv) throws SQLException {
	   	int cnt = 0;
	   
        Object obj = smc.insert("post.insertPost", pv);
        
        if(obj == null) {
        	cnt = 1;
        }
      return cnt;
   }

   @Override
   public boolean checkPost(SqlMapClient smc, String postNo) throws SQLException {
      boolean chk = false;
      
      int cnt = (int) smc.queryForObject("post.getPost", postNo);
      
      if(cnt > 0) {
    	  chk = true;
      }
      return chk;
   }

   @Override
   public List<PostVO> getAllPostList(SqlMapClient smc) throws SQLException {
      
      List<PostVO> postList = smc.queryForList("post.getPostAll");
      return postList;
   }

   @Override
   public int updatePost(SqlMapClient smc, PostVO pv) throws SQLException {
      
      int cnt = 0;
      cnt = smc.update("post.updatePost", pv);
      return cnt;
   }

   @Override
   public int deletePost(SqlMapClient smc, String postNo) throws SQLException {
      
      int cnt = smc.delete("post.deletePost", postNo);
      
      return cnt;
   }

   @Override
   public List<PostVO> getSearchPost(SqlMapClient smc,PostVO pv) throws SQLException {
      
      List<PostVO> postList = 
    		  smc.queryForList("post.getSearchPost", pv);
      
      return postList;
   }

   @Override
   public PostVO getPost(SqlMapClient smc, String postNo) throws SQLException {
	   PostVO pv = 
			(PostVO)smc
			.queryForObject("post.getPostInfo", postNo);
	
			return pv;
	}
}

































