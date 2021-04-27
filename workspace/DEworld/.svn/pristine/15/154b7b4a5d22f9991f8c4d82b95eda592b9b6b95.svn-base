package kr.or.ddit.music.handler;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.comm.handler.CommandHandler;
import kr.or.ddit.music.service.IMusicService;
import kr.or.ddit.music.service.MusicServiceImpl;
import kr.or.ddit.music.vo.MusicVO;

public class DetailMusicHandler implements CommandHandler{
private static final String VIEW_PAGE = "/WEB-INF/view/music/musicDetail.jsp";
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) {	
		String flag = req.getParameter("flag");
		
		try {
			if("L".equals(flag)) { // 등록
				String musicId = req.getParameter("musicId");		
				IMusicService MusicService =  MusicServiceImpl.getInstance();
				MusicVO iv = MusicService.getMusic(musicId);
				req.setAttribute("MusicVO", iv);
				return VIEW_PAGE;
			}
			else if("C".equals(flag)) { // 위시리스트 추가
				int resultCnt = insertWishlist(req);
				req.setAttribute("resultCnt", resultCnt);		
				return "/html/common/checkResult.jsp";
			}
			else if("GF".equals(flag)) { // 친구목록 불러오기
				String memId = req.getParameter("memId");		
				IMusicService musicService =  MusicServiceImpl.getInstance();
				List<MusicVO> friendList = musicService.getFriendList(memId);
//				System.out.println(friendList.get(0).getFriendId());
				req.setAttribute("friendList", friendList);
				return "/WEB-INF/view/Music/friendListResult.jsp";
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
				IMusicService musicService =  MusicServiceImpl.getInstance();
				
				MusicVO iv = new MusicVO();
				iv.setMemId(memId);
				iv.setFriendId(friendId);
				iv.setMusicId(musicId);
				iv.setGiftMessage(giftMessage);
				
				int resultCnt = musicService.giftMusic(iv);
				
				req.setAttribute("resultCnt", resultCnt);		
				return "/html/common/checkResult.jsp";
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return VIEW_PAGE;
	}

	private int insertWishlist(HttpServletRequest req) {
		IMusicService musicService =  MusicServiceImpl.getInstance();
		String musicId = req.getParameter("musicId");		
		String memId = req.getParameter("memId");		
		
		MusicVO iv = new MusicVO();
		iv.setMemId(memId);
		iv.setMusicId(musicId);
		
		int cnt = musicService.insertWishlist(iv);
		return cnt;
	}

}
