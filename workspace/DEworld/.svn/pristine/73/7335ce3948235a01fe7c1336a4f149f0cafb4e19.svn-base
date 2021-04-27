package kr.or.ddit.post.vo;

import kr.or.ddit.comm.vo.BaseVO;

/**
 * DB 테이블에 있는 컬럼을 기준으로 데이터를 객체화한 클래스이다.
 *         <p>
 *         DB테이블의 '컬럼'이 이 클래스의 '멤버변수'가 된다 <br>
 *         DB테이블의 컬럼과 클래스의 멤버변수를 매핑하는 역할을 수행한다.<br>
 *         </p>
 */

public class AllPostVO extends BaseVO {
	
	private String postNo;
	private String hompiId;
	private String lpostGu;
	private String memId;
	private String postTitle;
	private String postContent;
	private String postDate;
	
	private String streFileNm;
	private String fileExtsn;
	
	private String memNickname;
	
	private long postView =0;
	private long atchFileId = -1;
	
	
	public String getPostNo() {
		return postNo;
	}
	public void setPostNo(String postNo) {
		this.postNo = postNo;
	}
	public String getHompiId() {
		return hompiId;
	}
	public void setHompiId(String hompiId) {
		this.hompiId = hompiId;
	}
	public String getLpostGu() {
		return lpostGu;
	}
	public void setLpostGu(String lpostGu) {
		this.lpostGu = lpostGu;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getPostTitle() {
		return postTitle;
	}
	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
	public String getPostContent() {
		return postContent;
	}
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	public String getPostDate() {
		return postDate;
	}
	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}
	public long getPostView() {
		return postView;
	}
	public void setPostView(long postView) {
		this.postView = postView;
	}
	public long getAtchFileId() {
		return atchFileId;
	}
	public void setAtchFileId(long atchFileId) {
		this.atchFileId = atchFileId;
	}
	public String getMemNickname() {
		return memNickname;
	}
	public void setMemNickname(String memNickname) {
		this.memNickname = memNickname;
	}
	public String getFileExtsn() {
		return fileExtsn;
	}
	public void setFileExtsn(String fileExtsn) {
		this.fileExtsn = fileExtsn;
	}
	public String getStreFileNm() {
		return streFileNm;
	}
	public void setStreFileNm(String streFileNm) {
		this.streFileNm = streFileNm;
	}
	

	
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
}