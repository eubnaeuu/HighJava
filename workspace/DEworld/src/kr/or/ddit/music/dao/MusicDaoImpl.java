package kr.or.ddit.music.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.music.vo.MusicVO;


public class MusicDaoImpl implements IMusicDao {

   private static IMusicDao MusicDao;
   
   private MusicDaoImpl() {
	   
   }
   
   public static IMusicDao getInstance() {
	   if(MusicDao == null) {
		   MusicDao = new MusicDaoImpl();
	   }
	   
	   return MusicDao;
   }
   

   @Override
   public List<MusicVO> getAllMusicList(SqlMapClient smc) throws SQLException {
      
      List<MusicVO> musicList = smc.queryForList("music.getMusicAll");
     
      return musicList;
   }

  
   @Override
   public List<MusicVO> getSearchMusic(SqlMapClient smc,String searchMusicName) throws SQLException {
      
      List<MusicVO> musicList = 
    		  smc.queryForList("music.getSearchMusic", searchMusicName);
      
      return musicList;
   }

	@Override
	public MusicVO getMusic(SqlMapClient smc, String musicId) throws SQLException {
		MusicVO iv = (MusicVO) smc.queryForObject("music.getMusic",musicId);
		return iv;
	}

	@Override
	public int insertWishlist(SqlMapClient smc, MusicVO iv) throws SQLException {
	
		int cnt = 0;
		Object obj = smc.insert("music.insertWishlist",iv);
		if(obj == null) {
			cnt = 1;
		}
		
		return cnt;
	}

	@Override
	public List<MusicVO> getFriendList(SqlMapClient smc, String memId) throws SQLException {
		List<MusicVO> friendList = smc.queryForList("music.getFriendList", memId);
		return friendList;
	}

	@Override
	public int buyMusic(SqlMapClient smc, MusicVO iv) throws SQLException {
		smc.update("music.payment",iv); // 결제
		
		int cnt = 0;
		Object obj = smc.insert("music.buyMusic",iv); // collection에 추가
		if(obj == null) {
			cnt = 1;
		}
		
		return cnt;
	}

	@Override
	public int giftMusic(SqlMapClient smc, MusicVO iv) throws SQLException {
		smc.update("music.payment",iv); // 결제
		
		int cnt = 0;
		Object obj = smc.insert("music.giftMusic",iv); // collection에 추가
		if(obj == null) {
			cnt = 1;
		}
		
		return cnt;
	}


}






