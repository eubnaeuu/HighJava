package kr.or.ddit.music.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.music.dao.IMusicDao;
import kr.or.ddit.music.dao.MusicDaoImpl;
import kr.or.ddit.music.vo.MusicVO;
import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.util.SqlMapClientUtil;

public class MusicServiceImpl implements IMusicService {
	
	private IMusicDao MusicDao;
	private SqlMapClient smc;
	
	private static IMusicService service;
	
	private MusicServiceImpl() {
		MusicDao = MusicDaoImpl.getInstance();
		smc = SqlMapClientUtil.getInstance();
	}
	
	public static IMusicService getInstance() {
		if(service == null) {
			service = new MusicServiceImpl();
		}
		
		return service;
	}

	
	@Override
	public List<MusicVO> getAllMusicList() {
		
		List<MusicVO> musicList = new ArrayList<>();
		
		try {
			musicList = MusicDao.getAllMusicList(smc);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return musicList;
	}

	@Override
	public List<MusicVO> getSearchMusic(String searchMusicName) {
		List<MusicVO> musicList = new ArrayList<>();
		
		try {
			musicList = MusicDao.getSearchMusic(smc, searchMusicName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	      
	    return musicList;
	}

	@Override
	public MusicVO getMusic(String musicId) {
		
		MusicVO iv = null;
		
		try {
			iv = MusicDao.getMusic(smc, musicId);
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return iv;
	}

	@Override
	public int insertWishlist(MusicVO iv) {
		int cnt = 0;
		try {
			cnt = MusicDao.insertWishlist(smc, iv);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return cnt;
	}

	@Override
	public List<MusicVO> getFriendList(String memId) {
		List<MusicVO> friendList = new ArrayList<>();
		
		try {
			friendList = MusicDao.getFriendList(smc, memId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return friendList;
	}

	@Override
	public int buyMusic(MusicVO iv) {
		int cnt = 0;
		try {
			cnt = MusicDao.buyMusic(smc, iv);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return cnt;
	}

	@Override
	public int giftMusic(MusicVO iv) {
		int cnt = 0;
		try {
			cnt = MusicDao.giftMusic(smc, iv);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return cnt;
	}
	

}
