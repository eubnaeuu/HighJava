package kr.or.ddit.giftbox.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.item.dao.IItemDao;
import kr.or.ddit.item.dao.ItemDaoImpl;
import kr.or.ddit.item.vo.ItemVO;
import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.util.SqlMapClientUtil;

public class GiftboxServiceImpl implements IGiftboxService {
	
	private IGiftboxDao giftboxDao;
	private SqlMapClient smc;
	
	private static IGiftboxService service;
	
	private GiftboxServiceImpl() {
		giftboxDao = giftboxDaoImpl.getInstance();
		smc = SqlMapClientUtil.getInstance();
	}
	
	public static IGiftboxService getInstance() {
		if(service == null) {
			service = new GiftboxServiceImpl();
		}
		
		return service;
	}

	
	@Override
	public List<giftboxVO> getAllGiftboxList() {
		
		List<GiftboxVO> giftboxList = new ArrayList<>();
		
		try {
			giftboxList = giftboxDao.getAllGiftboxList(smc);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return giftboxList;
	}

	
	

}
