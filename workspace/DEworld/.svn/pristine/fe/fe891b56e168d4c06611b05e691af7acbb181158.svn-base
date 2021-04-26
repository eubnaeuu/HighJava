package kr.or.ddit.message.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.message.vo.MessageVO;


public class MessageDaoImpl implements MessageDao {

   private static MessageDao MessageDao;
   
   private MessageDaoImpl() {
	   
   }
   
   public static MessageDao getInstance() {
	   if(MessageDao == null) {
		   MessageDao = new MessageDaoImpl();
	   }
	   return MessageDao;
   }

@Override
public int insertMessage(SqlMapClient smc, MessageVO mv) throws SQLException {
 	int cnt = 0;
	   
    Object obj = smc.insert("message.insertMessage", mv);
    
    if(obj == null) {
    	cnt = 1;
    }
  return cnt;
}

@Override
public boolean checkMessage(SqlMapClient smc, String MessageNo) throws SQLException {
	 boolean chk = false;
     
     int cnt = (int) smc.queryForObject("message.getMessage", MessageNo);
     
     if(cnt > 0) {
   	  chk = true;
     }
     return chk;
}

@Override
public List<MessageVO> getAllMessageList(SqlMapClient smc) throws SQLException {
	 List<MessageVO> MessageList = smc.queryForList("message.getMessageAll");
     return MessageList;
}

@Override
public int updateMessage(SqlMapClient smc, MessageVO mv) throws SQLException {
    int cnt = 0;
    cnt = smc.update("message.updateMessageStatus", mv);
    return cnt;
}

@Override
public int deleteMessage(SqlMapClient smc, String MessageNo) throws SQLException {
	 int cnt = smc.delete("message.deleteMessage", MessageNo);
     return cnt;
}

@Override
public List<MessageVO> getSearchMessage(SqlMapClient smc, MessageVO mv) throws SQLException {
	List<MessageVO> MessageList = smc.queryForList("message.getSearchMessage", mv);
    return MessageList;
	}

@Override
public int getAllMessageListCount(SqlMapClient smc) throws SQLException {
	int cnt = 0;
    cnt = (int) smc.queryForObject("message.getMessageAllCount");
	return cnt;
}
}



































