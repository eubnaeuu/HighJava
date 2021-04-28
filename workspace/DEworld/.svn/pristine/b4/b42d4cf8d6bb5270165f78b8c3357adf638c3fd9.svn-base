package kr.or.ddit.guestbook.vo;

import java.util.List;

import kr.or.ddit.comm.vo.BaseVO;
import kr.or.ddit.post.vo.PostVO;

/**
 * DB 테이블에 있는 컬럼을 기준으로 데이터를 객체화한 클래스이다.
 *         <p>
 *         DB테이블의 '컬럼'이 이 클래스의 '멤버변수'가 된다 <br>
 *         DB테이블의 컬럼과 클래스의 멤버변수를 매핑하는 역할을 수행한다.<br>
 *         </p>
 */

public class GuestBookVO extends BaseVO {
	
	private String guestbookNo;
	private String hompiId;
	private String guestbookTitle;
	private String guestbookContent;
	private String gusetbookWriter;
	private String guestbookDate;
	

	private int pageCount = 10;			// 페이지 목록 게시되는 페이지 수 (초기값: 10)
	private int countPerPage = 10;		// 한 페이지당 게시되는 게시물 건 수(초기값: 10)
	private int currentPageNo;			// 현재 페이지 번호
	private int totalCount;				// 전체 게시물 건 수
	
	private int totalPageCount;			// 전체 페이지 수
	private int firstPageNo;			// 현재 페이지 목록의 첫 페이지 번호
	private int lastPageNo;				// 현재 페이지 목록의 마지막 페이지 번호
	private int firstRecNo;				// 첫번째 레코드 번호
	private int lastRecNo;				// 마지막 레코드 번호

	public int getCountPerPage() {
		return countPerPage;
	}

	public void setCountPerPage(int countPerPage) {
		this.countPerPage = countPerPage;
	}

	public int getPageSize() {
		return pageCount;
	}

	public void setPageSize(int pageSize) {
		this.pageCount = pageSize;
	}

	public int getCurrentPageNo() {
		return currentPageNo;
	}

	public void setCurrentPageNo(int currentPageNo) {
		this.currentPageNo = currentPageNo;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalCount() {
		return totalCount;
	}


	// 전체 페이지 수
	public int getTotalPageCount() {
		totalPageCount = ((getTotalCount() - 1) / getCountPerPage()) + 1;
		return totalPageCount;
	}

	// 시작페이지 번호
	public int getFirstPageNo() {
		firstPageNo = ((getCurrentPageNo() - 1) / getPageSize()) * getPageSize() + 1;
		return firstPageNo;
	}
	
	// 마지막 페이지 번호
	public int getLastPageNo() {
		lastPageNo = getFirstPageNo() + getPageSize() - 1;
		if (lastPageNo > getTotalPageCount()) {
			lastPageNo = getTotalPageCount();
		}
		return lastPageNo;
	}
	
	// 첫번째 레코드 번호
	public int getFirstRecNo() {
		firstRecNo = (getCurrentPageNo() - 1) * getCountPerPage() + 1;
		return firstRecNo;
	}
	
	// 마지막 레코드 번호
	public int getLastRecNo() {
		lastRecNo = getCurrentPageNo() * getCountPerPage();
		return lastRecNo;
	}

	public String getGuestbookNo() {
		return guestbookNo;
	}

	public void setGuestbookNo(String guestbookNo) {
		this.guestbookNo = guestbookNo;
	}

	public String getHompiId() {
		return hompiId;
	}

	public void setHompiId(String hompiId) {
		this.hompiId = hompiId;
	}

	public String getGuestbookTitle() {
		return guestbookTitle;
	}

	public void setGuestbookTitle(String guestbookTitle) {
		this.guestbookTitle = guestbookTitle;
	}

	public String getGuestbookContent() {
		return guestbookContent;
	}

	public void setGuestbookContent(String guestbookContent) {
		this.guestbookContent = guestbookContent;
	}

	public String getGusetbookWriter() {
		return gusetbookWriter;
	}

	public void setGusetbookWriter(String gusetbookWriter) {
		this.gusetbookWriter = gusetbookWriter;
	}

	public String getGuestbookDate() {
		return guestbookDate;
	}

	public void setGuestbookDate(String guestbookDate) {
		this.guestbookDate = guestbookDate;
	}
	
	
}