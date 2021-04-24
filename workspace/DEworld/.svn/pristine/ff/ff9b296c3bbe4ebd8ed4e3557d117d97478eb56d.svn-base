package kr.or.ddit.message.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.message.dao.MessageDao;
import kr.or.ddit.message.dao.MessageDaoImpl;
import kr.or.ddit.message.vo.MessageVO;
import kr.or.ddit.util.SqlMapClientUtil;

public class MessageServiceImpl implements MessageService {
	
	private MessageDao MessageDao;
	private SqlMapClient smc;
	
	private static MessageService service;
	
	private MessageServiceImpl() {
		MessageDao = MessageDaoImpl.getInstance();
		smc = SqlMapClientUtil.getInstance();
	}
	
	public static MessageService getInstance() {
		if(service == null) {
			service = new MessageServiceImpl();
		}
		return service;
	}

	@Override
	public int insertMessage(MessageVO mv) {
		
		int cnt = 0;
		
		try {
			cnt = MessageDao.insertMessage(smc, mv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public boolean checkMessage(String MessageId) {
		
		boolean chk = false;
		
		try {
			chk = MessageDao.checkMessage(smc, MessageId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return chk;
	}

	@Override
	public List<MessageVO> getAllMessageList() {
		
		List<MessageVO> list = new ArrayList<>();
		
		try {
			list = MessageDao.getAllMessageList(smc);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int updateMessage(MessageVO mv) {
		int cnt = 0;
		
		try {
			cnt = MessageDao.updateMessage(smc, mv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int deleteMessage(String MessageId) {
		int cnt = 0;
		try {
			cnt = MessageDao.deleteMessage(smc, MessageId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}
	
	@Override
	public List<MessageVO> getSearchMessage(MessageVO mv) {
		
		List<MessageVO> list = new ArrayList<>();
		
		try {
			list = MessageDao.getSearchMessage(smc, mv);
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int getAllMessageListCount() {
		int cnt=-1;
		try {
			cnt = MessageDao.getAllMessageListCount(smc);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

}
