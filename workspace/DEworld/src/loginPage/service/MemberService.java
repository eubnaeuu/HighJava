package loginPage.service;

import java.sql.SQLException;
import java.util.List;

import loginPage.dao.MemberDao;
import loginPage.vo.AdminVO;
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

	public List<MemberVO> findPw(MemberVO memberVO) throws SQLException {
		
		List<MemberVO> list = dao.findPw(memberVO);
		return list;
	}

	public List<MemberVO> setMyPage(MemberVO memberVO) throws SQLException {
		
		List<MemberVO> list = dao.setMyPage(memberVO);
		return list;
	}

	public int updateInfo(MemberVO memberVo) throws SQLException {
		
		int cnt = dao.updateInfo(memberVo);
		return cnt;
	}

	public List<AdminVO> adminConfirm(AdminVO adminVO) throws SQLException {
		
		List<AdminVO> adminConfirm = dao.adminConfirm(adminVO);
		return adminConfirm;
	}


	
}
