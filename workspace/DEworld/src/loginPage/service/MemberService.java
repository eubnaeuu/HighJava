package loginPage.service;

import java.sql.SQLException;
import java.util.List;

import loginPage.dao.MemberDao;
import kr.or.ddit.member.vo.MemberVO;

public class MemberService {
	// singleton 패턴 적용
	private MemberDao dao;
	
	public MemberService() {
		if(dao == null)
			dao = new MemberDao();
	}
	
	public List<MemberVO> matchinIdPw(MemberVO memberVo) throws SQLException {
		// 검증 작업
		
		List<MemberVO> list = dao.matchinIdPw(memberVo);
		return list;
	}
	
	public List<MemberVO> findId(MemberVO memberVo) throws SQLException {
		// 검증 작업
		
		List<MemberVO> list = dao.findId(memberVo);
		return list;
	}

	public List<MemberVO> findIdEmail(MemberVO memberVO) throws SQLException {
		
		
		List<MemberVO> list = dao.findIdEmail(memberVO);
		return list;
	}
	
}
