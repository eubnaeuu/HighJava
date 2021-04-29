package kr.or.ddit.itemcollection.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.item.dao.IItemCollectionDao;
import kr.or.ddit.item.dao.ItemCollectionDaoImpl;
import kr.or.ddit.item.vo.ItemCollectionVO;
import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.util.SqlMapClientUtil;

public class ItemServiceImpl implements IItemService {
	
	private IItemCollectionDao itemDao;
	private SqlMapClient smc;
	
	private static IItemService service;
	
	private ItemServiceImpl() {
		itemDao = ItemCollectionDaoImpl.getInstance();
		smc = SqlMapClientUtil.getInstance();
	}
	
	public static IItemService getInstance() {
		if(service == null) {
			service = new ItemServiceImpl();
		}
		
		return service;
	}

	
	@Override
	public List<ItemCollectionVO> getAllItemList() {
		
		List<ItemCollectionVO> itemList = new ArrayList<>();
		
		try {
			itemList = itemDao.getAllItemList(smc);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return itemList;
	}

	@Override
	public List<ItemCollectionVO> getSearchItem(String searchItemName) {
		List<ItemCollectionVO> itemList = new ArrayList<>();
		
		try {
			itemList = itemDao.getSearchItem(smc, searchItemName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	      
	    return itemList;
	}

	@Override
	public ItemCollectionVO getItem(String itemId) {
		
		ItemCollectionVO iv = null;
		
		try {
			iv = itemDao.getItem(smc, itemId);
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return iv;
	}

	@Override
	public int insertWishlist(ItemCollectionVO iv) {
		int cnt = 0;
		try {
			cnt = itemDao.insertWishlist(smc, iv);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return cnt;
	}

	@Override
	public List<ItemCollectionVO> getFriendList(String memId) {
		List<ItemCollectionVO> friendList = new ArrayList<>();
		
		try {
			friendList = itemDao.getFriendList(smc, memId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return friendList;
	}

	@Override
	public int buyItem(ItemCollectionVO iv) {
		int cnt = 0;
		try {
			cnt = itemDao.buyItem(smc, iv);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return cnt;
	}

	@Override
	public int giftItem(ItemCollectionVO iv) {
		int cnt = 0;
		try {
			cnt = itemDao.giftItem(smc, iv);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return cnt;
	}
	

}
