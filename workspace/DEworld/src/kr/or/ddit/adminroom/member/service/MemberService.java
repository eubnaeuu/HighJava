package kr.or.ddit.adminroom.member.service;

import java.sql.SQLException;

import java.util.List;

import kr.or.ddit.adminroom.member.dao.NoticeDao;
import kr.or.ddit.adminroom.member.vo.MemberVO;

public class MemberService {
	// singleton 패턴 적용
	private NoticeDao dao;

	public MemberService() {
		if (dao == null)
			dao = new NoticeDao();
	}

//	// 조회
//	public MemberVO searchNotice(MemberVO nv) throws SQLException {
//		return dao.searchNotice(nv);
//	}

	// 여러개조회
	public List<MemberVO> getSearchMember(MemberVO mv) throws SQLException {
		List<MemberVO> list = dao.getSearchMember(mv);
		return list;
	}

//	// 추가
//	public void createNotice(MemberVO noticeVo) throws SQLException {
//		// noticeVo.setRegisterId(session.loninId);
//		dao.createNotice(noticeVo);
//	}
//
//	// 삭제
//	public int deleteNotice(int noticeNo) throws SQLException {
//		return dao.deleteNotice(noticeNo);
//	}
//
//	// 여러개 삭제
//	public int deleteNoticeList(MemberVO noticeVo) throws SQLException {
//		// 방법1)
//		return dao.deleteNoticeList(noticeVo);
//
//		// // 방법2)
//		// int cnt = 0;
//		// int[] noticeNoArr = noticeVo.getNoticeNoArr();
//		// for(int i = 0 ; i<noticeNoArr.length ; i++) {
//		// dao.deleteNotice(noticeNoArr[i]);
//		// cnt++;
//		// }
//		// return cnt;
//	}
//
//	// 수정
//	public int updateNotice(MemberVO noticeVo) throws SQLException {
//		return dao.updateNotice(noticeVo);
//	}

}
