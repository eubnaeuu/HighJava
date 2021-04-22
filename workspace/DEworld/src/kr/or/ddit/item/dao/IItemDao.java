package kr.or.ddit.item.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.item.vo.ItemVO;
import kr.or.ddit.member.vo.MemberVO;

public interface IItemDao {
	
	 
	public List<ItemVO> getAllItemList(SqlMapClient smc)
	 					throws SQLException;
	
	
	public List<ItemVO> getSearchItem(SqlMapClient smc, ItemVO iv) 
						throws SQLException;
	

}
