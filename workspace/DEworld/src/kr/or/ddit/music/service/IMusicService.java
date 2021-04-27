package kr.or.ddit.music.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.music.vo.MusicVO;


public interface IMusicService {

	public int insertWishlist(MusicVO iv);
	public MusicVO getMusic(String musicId);
	public List<MusicVO> getAllMusicList();
	public List<MusicVO> getSearchMusic(String searchMusicName);
	public List<MusicVO> getFriendList(String memId);
	public int buyMusic(MusicVO iv);
	public int giftMusic(MusicVO iv);

}
