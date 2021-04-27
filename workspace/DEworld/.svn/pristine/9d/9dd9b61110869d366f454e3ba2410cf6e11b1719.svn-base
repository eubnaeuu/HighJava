package kr.or.ddit.music.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.music.vo.MusicVO;
import kr.or.ddit.member.vo.MemberVO;

public interface IMusicDao {
	
	 
	public List<MusicVO> getAllMusicList(SqlMapClient smc)
	 					throws SQLException;
	
	
	public List<MusicVO> getSearchMusic(SqlMapClient smc, String searchMusicName) throws SQLException;
 

	public MusicVO getMusic(SqlMapClient smc, String musicId) throws SQLException;
	
	public int insertWishlist(SqlMapClient smc, MusicVO iv) throws SQLException;

	public List<MusicVO> getFriendList(SqlMapClient smc, String memId) throws SQLException;

	public int buyMusic(SqlMapClient smc, MusicVO iv) throws SQLException;

	public int giftMusic(SqlMapClient smc, MusicVO iv) throws SQLException;
}
