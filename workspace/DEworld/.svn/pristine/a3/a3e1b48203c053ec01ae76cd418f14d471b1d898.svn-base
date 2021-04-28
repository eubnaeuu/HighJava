package kr.or.ddit.music.handler;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.comm.handler.CommandHandler;
import kr.or.ddit.music.service.IMusicService;
import kr.or.ddit.music.service.MusicServiceImpl;
import kr.or.ddit.music.vo.MusicVO;
import kr.or.ddit.member.service.ZipService;
import kr.or.ddit.member.vo.ZipVO;

public class ListMusicHandler implements CommandHandler {
	
	private static final String VIEW_PAGE = "/WEB-INF/view/item/musicList.jsp";
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) {

		if(req.getMethod().equals("GET")) { //GET방식인 경우 isRedirect을 하지 않는다
			return VIEW_PAGE;
		}else {
		// 브라우저로 부터 받은 값을 사용하기 위해 request에서 parameter를 get.
			String flag = req.getParameter("flag");
			try {
				if("L".equals(flag)) { // 전체목록 불러오기
					IMusicService MusicService =  MusicServiceImpl.getInstance();
					List<MusicVO> musicList = MusicService.getAllMusicList();
					req.setAttribute("musicList", musicList);
					return "/WEB-INF/view/item/musicListResult.jsp";
				}
				
				else if("C".equals(flag)) { // 위시리스트 추가
					int resultCnt = insertWishlist(req);
					req.setAttribute("resultCnt", resultCnt);		
					return "/html/common/checkResult.jsp";
				}
				
				else if("S".equals(flag)) { // 검색
					String searchMusicName = req.getParameter("searchMusicName");
					IMusicService MusicService =  MusicServiceImpl.getInstance();
					List<MusicVO> musicList = MusicService.getSearchMusic(searchMusicName);
					req.setAttribute("musicList", musicList);
					return "/WEB-INF/view/item/musicListResult.jsp";
					
				}
				
				else if("GF".equals(flag)) { // 친구목록 불러오기
					String memId = req.getParameter("memId");		
					IMusicService musicService =  MusicServiceImpl.getInstance();
					List<MusicVO> friendList = musicService.getFriendList(memId);
//					System.out.println(friendList.get(0).getFriendId());
					req.setAttribute("friendList", friendList);
					return "/WEB-INF/view/item/mfriendListResult.jsp";
				}
				
				else if("BUY".equals(flag)) { // 구매
					String memId = req.getParameter("memId");
					String musicId =  req.getParameter("musicId");
					IMusicService MusicService =  MusicServiceImpl.getInstance();
					
					MusicVO iv = new MusicVO();
					iv.setMemId(memId);
					iv.setMusicId(musicId);
					
					int resultCnt = MusicService.buyMusic(iv);
					
					req.setAttribute("resultCnt", resultCnt);		
					return "/html/common/checkResult.jsp";
					
				}
				
				else if("SENDGF".equals(flag)) { // 선물보내기
					String memId = req.getParameter("memId");
					String friendId = req.getParameter("friendId"); 
					String musicId =  req.getParameter("musicId");
					String giftMessage =  req.getParameter("giftMessage");
					String lmusicGu = req.getParameter("litemGu");	
					IMusicService musicService =  MusicServiceImpl.getInstance();
					
					MusicVO iv = new MusicVO();
					iv.setMemId(memId);
					iv.setFriendId(friendId);
					iv.setMusicId(musicId);
					iv.setGiftMessage(giftMessage);
					iv.setLmusicGu(lmusicGu);
					
					int resultCnt = musicService.giftMusic(iv);
					
					req.setAttribute("resultCnt", resultCnt);		
					return "/html/common/checkResult.jsp";
					
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
		
	}
	private int insertWishlist(HttpServletRequest req) {
		IMusicService musicService =  MusicServiceImpl.getInstance();
		String musicId = req.getParameter("musicId");		
		String memId = req.getParameter("memId");		
		String lmusicGu = req.getParameter("litemGu");		
		
		MusicVO iv = new MusicVO();
		iv.setMemId(memId);
		iv.setMusicId(musicId);
		iv.setLmusicGu(lmusicGu);
		
		int cnt = musicService.insertWishlist(iv);
		return cnt;
	}

}
