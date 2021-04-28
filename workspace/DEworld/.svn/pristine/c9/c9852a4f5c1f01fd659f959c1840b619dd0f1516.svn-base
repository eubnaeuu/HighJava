package kr.or.ddit.adminroom.member.dao;

import java.sql.SQLException;


import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.adminroom.member.vo.MemberVO;
import kr.or.ddit.notice.base.BaseDao;
import kr.or.ddit.notice.vo.NoticeVO;

public class NoticeDao extends BaseDao {
	private SqlMapClient smc;
	
	public NoticeDao() {
		smc = super.getSqlMapClient();
	}

	//여러개조회
	public List<MemberVO> getSearchMember(MemberVO mv) throws SQLException {
		return smc.queryForList("adminroom.getSearchMember", mv);
	}
	//이름조회
	public List<MemberVO> getSearchMemberName(MemberVO mv) throws SQLException {
		return smc.queryForList("adminroom.getSearchMemberName", mv);
	}
	//닉네임조회
	public List<MemberVO> getSearchMemberNickname(MemberVO mv) throws SQLException {
		return smc.queryForList("adminroom.getSearchMemberNickname", mv);
	}
	//아이디조회
	public List<MemberVO> getSearchMemberId(MemberVO mv) throws SQLException {
		return smc.queryForList("adminroom.getSearchMemberId", mv);
	}
	
	
	
	
//	//추가
//	public void createNotice(NoticeVO noticeVo) throws SQLException {
//		smc.insert("notice.createNotice", noticeVo);
//	}
//	//삭제
//	public int deleteNotice(int noticeNo) throws SQLException {
//		return smc.delete("notice.deleteNotice", noticeNo);
//	}
//	//여러개삭제
//	public int deleteNoticeList(NoticeVO noticeVo) throws SQLException{
//		return smc.delete("notice.deleteNoticeList", noticeVo);
//		
//	}
//	//수정
//	public int updateNotice(NoticeVO noticeVo) throws SQLException {
//		return smc.update("notice.updateNotice", noticeVo);
//	}
	
}
