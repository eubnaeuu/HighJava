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
				if("L".equals(flag)) { // 등록
					IMusicService MusicService =  MusicServiceImpl.getInstance();
					List<MusicVO> musicList = MusicService.getAllMusicList();
					req.setAttribute("musicList", musicList);
					return "/WEB-INF/view/item/musicListResult.jsp";
				}else if("S".equals(flag)) { // 검색
					String searchMusicName = req.getParameter("searchMusicName");
					IMusicService MusicService =  MusicServiceImpl.getInstance();
					List<MusicVO> musicList = MusicService.getSearchMusic(searchMusicName);
					req.setAttribute("musicList", musicList);
					return "/WEB-INF/view/item/musicListResult.jsp";
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
		
	}

}
