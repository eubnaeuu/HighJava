package kr.or.ddit.item.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.item.vo.ItemVO;


public interface IItemService {
	public int insertWishlist(ItemVO iv);
	
	public ItemVO getItem(String itemId);
	
	public List<ItemVO> getAllItemList();
	
	public List<ItemVO> getSearchItem(ItemVO iv);
	
}
