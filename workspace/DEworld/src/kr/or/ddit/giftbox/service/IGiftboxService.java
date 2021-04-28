package kr.or.ddit.giftbox.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.item.vo.ItemVO;


public interface IGiftboxService {


	public List<giftboxVO> getAllGiftboxList();


}
