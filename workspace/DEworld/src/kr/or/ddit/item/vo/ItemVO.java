package kr.or.ddit.item.vo;

public class ItemVO {
	private String 	memId; // 회원 ID
	private int 	memCyBermoney; // 회원 ID
	private String 	friendId; // 친구 ID
	private String 	friendNickname; // 친구 Nickname
	private String 	giftMessage;
	private String 	itemId; // 아이템 ID
	private String 	litemGu; // 아이템 분류 코드
	private String 	itemName; // 아이템 명
	private String 	itemDesc; // 아이템 설명 : 아이템 설명
	private int 	itemPrice; // 아이템 가격
	private int 	itemTotalstock; // 아이템 재고 수량
	private String 	itemImg; // 아이템 이미지
	private String 	itemDetail; // 아이템 정보 : 아이템 정보
	private String 	searchItemName; // 검색어
	private int wishNo;
	
	
	public int getWishNo() {
		return wishNo;
	}
	public void setWishNo(int wishNo) {
		this.wishNo = wishNo;
	}
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
	public String getGiftMessage() {
		return giftMessage;
	}
	public void setGiftMessage(String giftMessage) {
		this.giftMessage = giftMessage;
	}
	public String getFriendNickname() {
		return friendNickname;
	}
	public void setFriendNickname(String friendNickname) {
		this.friendNickname = friendNickname;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getLitemGu() {
		return litemGu;
	}
	public void setLitemGu(String litemGu) {
		this.litemGu = litemGu;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemDesc() {
		return itemDesc;
	}
	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}
	public int getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	public int getItemTotalstock() {
		return itemTotalstock;
	}
	public void setItemTotalstock(int itemTotalstock) {
		this.itemTotalstock = itemTotalstock;
	}
	public String getItemImg() {
		return itemImg;
	}
	public void setItemImg(String itemImg) {
		this.itemImg = itemImg;
	}
	public String getItemDetail() {
		return itemDetail;
	}
	public void setItemDetail(String itemDetail) {
		this.itemDetail = itemDetail;
	}
	public String getSearchItemName() {
		return searchItemName;
	}
	public void setSearchItemName(String searchItemName) {
		this.searchItemName = searchItemName;
	}
}


















