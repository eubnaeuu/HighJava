package kr.or.ddit.comments.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.comments.vo.CommentsVO;


public class CommentsDaoImpl implements CommentsDao {

   private static CommentsDao CommentsDao;
   
   private CommentsDaoImpl() {
	   
   }
   
   public static CommentsDao getInstance() {
	   if(CommentsDao == null) {
		   CommentsDao = new CommentsDaoImpl();
	   }
	   
	   return CommentsDao;
   }

@Override
public int insertComments(SqlMapClient smc, CommentsVO cv) throws SQLException {
 	int cnt = 0;
	   
    Object obj = smc.insert("comments.insertComments", cv);
    
    if(obj == null) {
    	cnt = 1;
    }
  return cnt;
}

@Override
public boolean checkComments(SqlMapClient smc, String CommentsNo) throws SQLException {
	 boolean chk = false;
     
     int cnt = (int) smc.queryForObject("comments.getComments", CommentsNo);
     
     if(cnt > 0) {
   	  chk = true;
     }
     return chk;
}

@Override
public List<CommentsVO> getAllCommentsList(SqlMapClient smc) throws SQLException {
	 List<CommentsVO> CommentsList = smc.queryForList("comments.getCommentsAll");
     return CommentsList;
}

@Override
public int updateComments(SqlMapClient smc, CommentsVO cv) throws SQLException {
    int cnt = 0;
    cnt = smc.update("comments.updateComments", cv);
    return cnt;
}

@Override
public int deleteComments(SqlMapClient smc, String CommentsNo) throws SQLException {
	 int cnt = smc.delete("comments.deleteComments", CommentsNo);
     
     return cnt;
}

@Override
public List<CommentsVO> getSearchComments(SqlMapClient smc, CommentsVO cv) throws SQLException {
	List<CommentsVO> CommentsList = smc.queryForList("comments.getSearchComments", cv);
    return CommentsList;
}

@Override
public CommentsVO getComments(SqlMapClient smc, String CommentsId) throws SQLException {
	  CommentsVO cv = 
				(CommentsVO)smc
				.queryForObject("comments.getCommentsInfo", CommentsId);
		
				return cv;
}
   
}


































