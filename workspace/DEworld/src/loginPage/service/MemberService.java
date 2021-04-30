package loginPage.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.hompi.vo.HompiVO;
import kr.or.ddit.item.vo.ItemVO;
import kr.or.ddit.member.vo.MemberVO;
import loginPage.dao.MemberDao;
import loginPage.vo.AdminVO;

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

	public int updateCoin(MemberVO memberVO) throws SQLException {
		
		int updateCoin = dao.updateCoin(memberVO);
		return updateCoin;
	}

	public List<HompiVO> highVisitCnt(MemberVO memberVO) throws SQLException {
		
		List<HompiVO> highVisitCnt = dao.highVisitCnt(memberVO);
		
		System.out.println("highVisitCnt크기 : " + highVisitCnt.size());
		
		for(HompiVO vo : highVisitCnt) {
			System.out.println("visitCountToday : " + vo.getVisitCountToday());
			System.out.println("memId : " + vo.getMemId());
			System.out.println("memNickname : " + vo.getMemNickname());
			System.out.println("hompiProfileImg : " + vo.getHompiProfileImg());
		}
		
		return highVisitCnt;
	}

	public List<HompiVO> setHompi(HompiVO hompiVO) throws SQLException {
		
		List<HompiVO> setHompi = dao.setHompi(hompiVO);
		
		return setHompi;
	}
	
	public List<ItemVO> searchMyMinimi(ItemVO itemVO) throws SQLException {
		
		List<ItemVO> searchMyMinimi = dao.searchMyMinimi(itemVO);
		
		return searchMyMinimi;
	}
		public List<ItemVO> searchMyBg(ItemVO itemVO) throws SQLException {
			
			List<ItemVO> searchMyMinimi = dao.searchBg(itemVO);
			
			return searchMyMinimi;
	}
		public int updateBg(ItemVO itemVO) throws SQLException {
			
			int cnt = dao.updateBg(itemVO);
			
			return cnt;
		}
		public int updateMinimi(ItemVO itemVO) throws SQLException {
			
			int cnt = dao.updateMinimi(itemVO);
			
			return cnt;
		}


	
}
