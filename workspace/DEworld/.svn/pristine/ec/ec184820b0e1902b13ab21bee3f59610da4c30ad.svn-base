package kr.or.ddit.giftbox.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.giftbox.dao.GiftboxDaoImpl;
import kr.or.ddit.giftbox.dao.IGiftboxDao;
import kr.or.ddit.giftbox.vo.GiftboxVO;
import kr.or.ddit.util.SqlMapClientUtil;

public class GiftboxServiceImpl implements IGiftboxService {
	
	private IGiftboxDao giftboxDao;
	private SqlMapClient smc;
	
	private static IGiftboxService service;
	
	private GiftboxServiceImpl() {
		giftboxDao = GiftboxDaoImpl.getInstance();
		smc = SqlMapClientUtil.getInstance();
	}
	
	public static IGiftboxService getInstance() {
		if(service == null) {
			service = new GiftboxServiceImpl();
		}
		
		return service;
	}

	
	@Override
	public List<GiftboxVO> getAllGiftboxList(GiftboxVO gv) {
		
		List<GiftboxVO> giftboxList = new ArrayList<>();
		
		try {
			giftboxList = giftboxDao.getAllGiftboxList(smc,gv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return giftboxList;
	}

	@Override
	public List<GiftboxVO> getMusicAllGiftboxList(GiftboxVO gv) {
		List<GiftboxVO> giftboxList = new ArrayList<>();
		
		try {
			giftboxList = giftboxDao.getMusicAllGiftboxList(smc,gv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return giftboxList;
	}

	
	

}
