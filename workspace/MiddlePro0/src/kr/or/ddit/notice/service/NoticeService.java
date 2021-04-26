package kr.or.ddit.notice.service;

import java.sql.SQLException;


import java.util.List;

import kr.or.ddit.notice.dao.NoticeDao;
import kr.or.ddit.notice.vo.NoticeVO;

public class NoticeService {
	// singleton 패턴 적용
	private NoticeDao dao;
	
	public NoticeService() {
		if(dao == null)
			dao = new NoticeDao();
	}
	//조회
	public NoticeVO searchNotice(NoticeVO nv) throws SQLException {
		return dao.searchNotice(nv);
	}
	
	//여러개조회
	public List<NoticeVO> searchNoticeList(NoticeVO noticeVo) throws SQLException {
		List<NoticeVO> list = dao.searchNoticeList(noticeVo);
		return list;
	}
	
	//추가
	public void createNotice(NoticeVO noticeVo) throws SQLException {
//		noticeVo.setRegisterId(session.loninId);
		dao.createNotice(noticeVo);
	}
	//삭제
	public int deleteNotice(int noticeNo) throws SQLException {
		return dao.deleteNotice(noticeNo);
	}
	//여러개 삭제
	public int deleteNoticeList(NoticeVO noticeVo) throws SQLException {
		// 방법1)
		return dao.deleteNoticeList(noticeVo);
		
//		// 방법2)
//		int cnt = 0;
//		int[] noticeNoArr = noticeVo.getNoticeNoArr();
//		for(int i = 0 ; i<noticeNoArr.length ; i++) {
//			dao.deleteNotice(noticeNoArr[i]);
//			cnt++;
//		}
//		return cnt;
	}
	//수정
	public int updateNotice(NoticeVO noticeVo) throws SQLException {
		return dao.updateNotice(noticeVo);
	}
	
}
