package kr.or.ddit.friendreq.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.friendreq.vo.FriendReqVO;


public class FriendReqDaoImpl implements FriendReqDao {

   private static FriendReqDao FriendReqDao;
   
   private FriendReqDaoImpl() {
	   
   }
   
   public static FriendReqDao getInstance() {
	   if(FriendReqDao == null) {
		   FriendReqDao = new FriendReqDaoImpl();
	   }
	   return FriendReqDao;
   }

@Override
public int insertFriendReq(SqlMapClient smc, FriendReqVO fv) throws SQLException {
 	int cnt = 0;
	   
    Object obj = smc.insert("friendreq.insertFriendReq", fv);
    
    if(obj == null) {
    	cnt = 1;
    }
  return cnt;
}

@Override
public boolean checkFriendReq(SqlMapClient smc, String FriendReqNo) throws SQLException {
	 boolean chk = false;
     
     int cnt = (int) smc.queryForObject("friendreq.getFriendReq", FriendReqNo);
     
     if(cnt > 0) {
   	  chk = true;
     }
     return chk;
}

@Override
public List<FriendReqVO> getAllFriendReqList(SqlMapClient smc) throws SQLException {
	 List<FriendReqVO> FriendReqList = smc.queryForList("friendreq.getFriendReqAll");
     return FriendReqList;
}

@Override
public int updateFriendReq(SqlMapClient smc, FriendReqVO fv) throws SQLException {
    int cnt = 0;
    cnt = smc.update("friendreq.updateFriendReq", fv);
    return cnt;
}

@Override
public int deleteFriendReq(SqlMapClient smc, String FriendReqNo) throws SQLException {
	 int cnt = smc.delete("friendreq.deleteFriendReq", FriendReqNo);
     return cnt;
}

@Override
public List<FriendReqVO> getSearchFriendReq(SqlMapClient smc, FriendReqVO fv) throws SQLException {
	List<FriendReqVO> FriendReqList = smc.queryForList("friendreq.getSearchFriendReq", fv);
    return FriendReqList;
	}
}



































