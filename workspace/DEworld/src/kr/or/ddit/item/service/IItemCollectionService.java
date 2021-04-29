package kr.or.ddit.item.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.item.vo.ItemCollectionVO;


public interface IItemCollectionService {

	public int insertWishlist(ItemCollectionVO iv);
	public ItemCollectionVO getItem(String itemId);
	public List<ItemCollectionVO> getAllItemList();
	public List<ItemCollectionVO> getSearchItem(String searchItemName);
	public List<ItemCollectionVO> getFriendList(String memId);
	public int buyItem(ItemCollectionVO iv);
	public int giftItem(ItemCollectionVO iv);

}
