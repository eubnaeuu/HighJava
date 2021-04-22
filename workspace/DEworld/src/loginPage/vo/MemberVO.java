package loginPage.vo;

/**
 * DB 테이블에 있는 컬럼을 기준으로 데이터를 객체화한 클래스이다.
 * @author SEM-pc
 * <p>
 * DB테이블의 '컬럼'이 이 클래스의 '멤버변수'가 된다 <br>
 * DB테이블의 컬럼과 클래스의 멤버변수를 매핑하는 역할을 수행한다.<br>
 * </p>
 */


public class MemberVO {
	private String memId;
	private String memPass;
	private String memName;
	private String memNickname;
	private String memGender;
	private String memBir;
	private String memZip;
	private String memAdd1;
	private String memAdd2;
	private String memHp;
	private String memMail;
	private int memCyberMoney;
	
	private long atchFileId = -1;
	
	public long getAtchFileId() {
		return atchFileId;
	}
	public void setAtchFileId(long atchFileId) {
		this.atchFileId = atchFileId;
	}
	
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getMemPass() {
		return memPass;
	}
	public void setMemPass(String memPass) {
		this.memPass = memPass;
	}
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public String getMemNickname() {
		return memNickname;
	}
	public void setMemNickname(String memNickname) {
		this.memNickname = memNickname;
	}
	public String getMemGender() {
		return memGender;
	}
	public void setMemGender(String memGender) {
		this.memGender = memGender;
	}
	public String getMemBir() {
		return memBir;
	}
	public void setMemBir(String memBir) {
		this.memBir = memBir;
	}
	public String getMemZip() {
		return memZip;
	}
	public void setMemZip(String memZip) {
		this.memZip = memZip;
	}
	public String getMemAdd1() {
		return memAdd1;
	}
	public void setMemAdd1(String memAdd1) {
		this.memAdd1 = memAdd1;
	}
	public String getMemAdd2() {
		return memAdd2;
	}
	public void setMemAdd2(String memAdd2) {
		this.memAdd2 = memAdd2;
	}
	public String getMemHp() {
		return memHp;
	}
	public void setMemHp(String memHp) {
		this.memHp = memHp;
	}
	public String getMemMail() {
		return memMail;
	}
	public void setMemMail(String memMail) {
		this.memMail = memMail;
	}
	public int getMemCyberMoney() {
		return memCyberMoney;
	}
	public void setMemCyberMoney(int memCyberMoney) {
		this.memCyberMoney = memCyberMoney;
	}

	
}
