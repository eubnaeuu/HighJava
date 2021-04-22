package kr.or.ddit.member.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.member.vo.ZipVO;
import kr.or.ddit.util.SqlMapClientUtil;

class BaseDao {
	private SqlMapClient smc;

	protected SqlMapClient getSqlMapClient() {
		if(smc == null)
			smc = SqlMapClientUtil.getInstance();
		
		return smc;
	}
}

public class ZipDao extends BaseDao {
	private SqlMapClient smc;
	
	public ZipDao() {
		smc = super.getSqlMapClient();
	}
	//TB_ZIP
	public List<ZipVO> retrieveSidoList() throws SQLException {
		return smc.queryForList("zip.retrieveSidoList");
	}
	public List<ZipVO> retrieveGugunList(ZipVO zipVO) throws SQLException {
		return smc.queryForList("zip.retrieveGugunList", zipVO);
	}
	public List<ZipVO> retrieveDongList(ZipVO zipVO) throws SQLException {
		return smc.queryForList("zip.retrieveDongList", zipVO);
	}
	public List<ZipVO> retrieveZipList(ZipVO zipVO) throws SQLException {
		return smc.queryForList("zip.retrieveZipList", zipVO);
	}

}
