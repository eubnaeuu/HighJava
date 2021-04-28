package kr.or.ddit.hompi.vo;

import kr.or.ddit.comm.vo.BaseVO;

/**
 * DB 테이블에 있는 컬럼을 기준으로 데이터를 객체화한 클래스이다.
 *         <p>
 *         DB테이블의 '컬럼'이 이 클래스의 '멤버변수'가 된다 <br>
 *         DB테이블의 컬럼과 클래스의 멤버변수를 매핑하는 역할을 수행한다.<br>
 *         </p>
 */

public class HompiVO extends BaseVO {
	
	private String HOMPI_ID;
	private String MEM_ID;
	private long VISIT_COUNT_TODAY;
	private long VISIT_COUNT_TOTAL;
	private long SCRAP_COUNT;
	private String HOMPI_INFO;
	private String HOMPI_PROFILE_IMG;
	private String HOMPI_MINIROOM;
	private String HOMPI_BACKGROUND;
	private String HOMPI_TEXTCOLOR;
	
	
	public String getHOMPI_ID() {
		return HOMPI_ID;
	}
	public void setHOMPI_ID(String hOMPI_ID) {
		HOMPI_ID = hOMPI_ID;
	}
	public String getMEM_ID() {
		return MEM_ID;
	}
	public void setMEM_ID(String mEM_ID) {
		MEM_ID = mEM_ID;
	}
	public long getVISIT_COUNT_TODAY() {
		return VISIT_COUNT_TODAY;
	}
	public void setVISIT_COUNT_TODAY(long vISIT_COUNT_TODAY) {
		VISIT_COUNT_TODAY = vISIT_COUNT_TODAY;
	}
	public long getVISIT_COUNT_TOTAL() {
		return VISIT_COUNT_TOTAL;
	}
	public void setVISIT_COUNT_TOTAL(long vISIT_COUNT_TOTAL) {
		VISIT_COUNT_TOTAL = vISIT_COUNT_TOTAL;
	}
	public long getSCRAP_COUNT() {
		return SCRAP_COUNT;
	}
	public void setSCRAP_COUNT(long sCRAP_COUNT) {
		SCRAP_COUNT = sCRAP_COUNT;
	}
	public String getHOMPI_INFO() {
		return HOMPI_INFO;
	}
	public void setHOMPI_INFO(String hOMPI_INFO) {
		HOMPI_INFO = hOMPI_INFO;
	}
	public String getHOMPI_PROFILE_IMG() {
		return HOMPI_PROFILE_IMG;
	}
	public void setHOMPI_PROFILE_IMG(String hOMPI_PROFILE_IMG) {
		HOMPI_PROFILE_IMG = hOMPI_PROFILE_IMG;
	}
	public String getHOMPI_MINIROOM() {
		return HOMPI_MINIROOM;
	}
	public void setHOMPI_MINIROOM(String hOMPI_MINIROOM) {
		HOMPI_MINIROOM = hOMPI_MINIROOM;
	}
	public String getHOMPI_BACKGROUND() {
		return HOMPI_BACKGROUND;
	}
	public void setHOMPI_BACKGROUND(String hOMPI_BACKGROUND) {
		HOMPI_BACKGROUND = hOMPI_BACKGROUND;
	}
	public String getHOMPI_TEXTCOLOR() {
		return HOMPI_TEXTCOLOR;
	}
	public void setHOMPI_TEXTCOLOR(String hOMPI_TEXTCOLOR) {
		HOMPI_TEXTCOLOR = hOMPI_TEXTCOLOR;
	}
	
}