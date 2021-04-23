package loginPage.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import baseDao.BaseDao;
import kr.or.ddit.member.vo.MemberVO;

public class MemberDao extends BaseDao {
	private SqlMapClient smc;
	
	private static MemberDao memberDao = null;
	
	public static MemberDao getInstance() {
		if(memberDao == null) {
			memberDao = new MemberDao();
		}
		return memberDao;
	}
	
	public MemberDao() {
		smc = super.getSqlMapClient();
	}
	
	public List<MemberVO> matchinIdPw (MemberVO memberVo) throws SQLException {
		return smc.queryForList("member.matchinIdPw", memberVo);
	}
	
	public List<MemberVO> findId (MemberVO memberVo) throws SQLException {
		return smc.queryForList("member.matchinIdEmail", memberVo);
	}

	public List<MemberVO> findIdEmail(MemberVO memberVO) throws SQLException {
		return smc.queryForList("member.findIdEmail", memberVO);
	}

	public List<MemberVO> findPw(MemberVO memberVO) throws SQLException {
		return smc.queryForList("member.findPw", memberVO);
	}

	
}	