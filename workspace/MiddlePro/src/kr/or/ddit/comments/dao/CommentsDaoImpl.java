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
	   
    Object obj = smc.insert("Comments.insertComments", cv);
    
    if(obj == null) {
    	cnt = 1;
    }
  return cnt;
}

@Override
public boolean checkComments(SqlMapClient smc, String CommentsNo) throws SQLException {
	 boolean chk = false;
     
     int cnt = (int) smc.queryForObject("Comments.getComments", CommentsNo);
     
     if(cnt > 0) {
   	  chk = true;
     }
     return chk;
}

@Override
public List<CommentsVO> getAllCommentsList(SqlMapClient smc) throws SQLException {
	 List<CommentsVO> CommentsList = smc.queryForList("Comments.getCommentsAll");
     return CommentsList;
}

@Override
public int updateComments(SqlMapClient smc, CommentsVO cv) throws SQLException {
    int cnt = 0;
    cnt = smc.update("Comments.updateComments", cv);
    return cnt;
}

@Override
public int deleteComments(SqlMapClient smc, String CommentsNo) throws SQLException {
	 int cnt = smc.delete("Comments.deleteComments", CommentsNo);
     
     return cnt;
}

@Override
public List<CommentsVO> getSearchComments(SqlMapClient smc, CommentsVO cv) throws SQLException {
	// TODO Auto-generated method stub
	return null;
}

@Override
public CommentsVO getComments(SqlMapClient smc, String CommentsId) throws SQLException {
	  CommentsVO cv = 
				(CommentsVO)smc
				.queryForObject("Comments.getCommentsInfo", CommentsId);
		
				return cv;
}
   
}


































