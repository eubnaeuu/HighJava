package kr.or.ddit.friend.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.friend.vo.FriendVO;


public class FriendDaoImpl implements FriendDao {

   private static FriendDao FriendDao;
   
   private FriendDaoImpl() {
	   
   }
   
   public static FriendDao getInstance() {
	   if(FriendDao == null) {
		   FriendDao = new FriendDaoImpl();
	   }
	   return FriendDao;
   }

@Override
public int insertFriend(SqlMapClient smc, FriendVO fv) throws SQLException {
 	int cnt = 0;
	   
    Object obj = smc.insert("friend.insertFriend", fv);
    
    if(obj == null) {
    	cnt = 1;
    }
  return cnt;
}

@Override
public boolean checkFriend(SqlMapClient smc, String FriendNo) throws SQLException {
	 boolean chk = false;
     
     int cnt = (int) smc.queryForObject("friend.getFriend", FriendNo);
     
     if(cnt > 0) {
   	  chk = true;
     }
     return chk;
}

@Override
public List<FriendVO> getAllFriendList(SqlMapClient smc) throws SQLException {
	 List<FriendVO> FriendList = smc.queryForList("friend.getFriendAll");
     return FriendList;
}

@Override
public int updateFriend(SqlMapClient smc, FriendVO fv) throws SQLException {
    int cnt = 0;
    cnt = smc.update("friend.updateFriend", fv);
    return cnt;
}

@Override
public int deleteFriend(SqlMapClient smc, FriendVO fv) throws SQLException {
	 int cnt = smc.delete("friend.deleteFriend", fv);
     return cnt;
}

@Override
public List<FriendVO> getSearchFriend(SqlMapClient smc, FriendVO fv) throws SQLException {
	List<FriendVO> FriendList = smc.queryForList("friend.getSearchFriend", fv);
    return FriendList;
	}
}



































