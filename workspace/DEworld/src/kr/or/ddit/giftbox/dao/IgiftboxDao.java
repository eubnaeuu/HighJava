package kr.or.ddit.giftbox.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.item.vo.ItemVO;
import kr.or.ddit.member.vo.MemberVO;

public interface IgiftboxDao {
	
	 
	public List<GiftboxVO> getAllItemList(SqlMapClient smc)
	 					throws SQLException;
	

}
