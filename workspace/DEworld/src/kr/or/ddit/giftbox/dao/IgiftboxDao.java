package kr.or.ddit.giftbox.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.giftbox.vo.GiftboxVO;

public interface IGiftboxDao {
	
	 
	public List<GiftboxVO> getAllGiftboxList(SqlMapClient smc)
	 					throws SQLException;
	

}
