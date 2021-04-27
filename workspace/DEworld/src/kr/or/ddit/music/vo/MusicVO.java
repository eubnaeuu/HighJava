package kr.or.ddit.music.vo;

public class MusicVO {
	private String 	memId; // 회원 ID
	private int 	memCyBermoney; // 회원 
	private String 	friendId; // 친구 ID
	private String 	friendNickname; // 친구 Nickname
	private String 	giftMessage;
	private String musicId;
	private String musicTitle;
	private String musicArtist;
	private String lmusicGu;
	private String lmusicGenre;	
	private int musicCost;
	private String musicTime;
	private String 	searchMusicName; // 검색어
	
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public int getMemCyBermoney() {
		return memCyBermoney;
	}
	public void setMemCyBermoney(int memCyBermoney) {
		this.memCyBermoney = memCyBermoney;
	}
	public String getFriendId() {
		return friendId;
	}
	public void setFriendId(String friendId) {
		this.friendId = friendId;
	}
	public String getFriendNickname() {
		return friendNickname;
	}
	public void setFriendNickname(String friendNickname) {
		this.friendNickname = friendNickname;
	}
	public String getGiftMessage() {
		return giftMessage;
	}
	public void setGiftMessage(String giftMessage) {
		this.giftMessage = giftMessage;
	}

	public String getMusicId() {
		return musicId;
	}
	public void setMusicId(String musicId) {
		this.musicId = musicId;
	}
	public String getMusicTitle() {
		return musicTitle;
	}
	public void setMusicTitle(String musicTitle) {
		this.musicTitle = musicTitle;
	}
	public String getMusicArtist() {
		return musicArtist;
	}
	public void setMusicArtist(String musicArtist) {
		this.musicArtist = musicArtist;
	}
	public String getLmusicGu() {
		return lmusicGu;
	}
	public void setLmusicGu(String lmusicGu) {
		this.lmusicGu = lmusicGu;
	}
	
	public String getLmusicGenre() {
		return lmusicGenre;
	}
	public void setLmusicGenre(String lmusicGenre) {
		this.lmusicGenre = lmusicGenre;
	}
	public int getMusicCost() {
		return musicCost;
	}
	public void setMusicCost(int musicCost) {
		this.musicCost = musicCost;
	}
	public String getMusicTime() {
		return musicTime;
	}
	public void setMusicTime(String musicTime) {
		this.musicTime = musicTime;
	}
	public String getSearchMusicName() {
		return searchMusicName;
	}
	public void setSearchMusicName(String searchMusicName) {
		this.searchMusicName = searchMusicName;
	}
	
	
}
