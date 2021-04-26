package kr.or.ddit.notice.vo;

import kr.or.ddit.comm.vo.ConstVO;

public class NoticeVO {
	private int noticeNo;
	private String adminId;
//	private String registerId;
	private String noticeTitle;
	private String noticeContent;
	private String noticeDate;
	
	private int[] noticeNoArr;
	
	public NoticeVO() {
		this.adminId = ConstVO.ADMIN_ID;
	}
	
	public int getNoticeNo() {
		return noticeNo;
	}
	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}
//	public String getRegisterId() {
//		return registerId;
//	}
//
//	public void setRegisterId(String registerId) {
//		this.registerId = registerId;
//	}

	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public String getNoticeContent() {
		return noticeContent;
	}
	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}
	public String getNoticeDate() {
		return noticeDate;
	}
	public void setNoticeDate(String noticeDate) {
		this.noticeDate = noticeDate;
	}

	public int[] getNoticeNoArr() {
		return noticeNoArr;
	}

	public void setNoticeNoArr(int[] noticeNoArr) {
		this.noticeNoArr = noticeNoArr;
	}



	
}
