package kr.or.ddit.notice.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.notice.service.NoticeService;
import kr.or.ddit.notice.vo.NoticeVO;

@WebServlet("/NoticeServlet")
public class NoticeServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	String flag = req.getParameter("flag");

	try {
		if("L".equals(flag)) { // 목록조회
			List<NoticeVO> list = searchNoticeList(req);
			 
			req.setAttribute("list", list);
			RequestDispatcher  disp = req.getRequestDispatcher("/html/notice/noticeListResult.jsp");
			disp.forward(req, resp);
		}else if("D".equals(flag)) { // 삭제
			deleteNoticeList(req);
			 
			req.setAttribute("resultCnt", 1);
			RequestDispatcher  disp = req.getRequestDispatcher("/html/common/checkResult.jsp");
			disp.forward(req, resp);
		}	
//		} else if("C".equals(flag)) { // 등록
//			createMember(req);
//			
//			req.setAttribute("resultCnt",1);
//			RequestDispatcher disp = req.getRequestDispatcher("/html/common/checkResult.jsp");
//			disp.forward(req, resp);
//			
//		} else if("R".equals(flag)) { // 단건 조회
//			
//		} else if("U".equals(flag)) { // 수정
//			
//		} else if("CHKID".equals(flag)) { // ID 체크
//			MemberVO memberVo = checkMemberId(req);
//
//			int resultCnt = 0;
//			if(memberVo != null) {
//				resultCnt = 1;
//			}
//			
//			req.setAttribute("resultCnt", resultCnt);
//			RequestDispatcher  disp 
//			  = req.getRequestDispatcher("/html/common/checkResult.jsp");
//			disp.forward(req, resp);
//		}
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

	private void deleteNoticeList(HttpServletRequest req) throws SQLException {
		String strNoticeNoArr = req.getParameter("noticeNoArr");
		String[] tmpArr = strNoticeNoArr.split(",");
		int[] arr = new int[tmpArr.length];
		for (int i = 0; i < tmpArr.length; i++) {
			arr[i]= Integer.parseInt(tmpArr[i]);
		}
		
		NoticeVO noticeVo = new NoticeVO();
		noticeVo.setNoticeNoArr(arr);
		
		NoticeService service = new NoticeService();
		service.deleteNoticeList(noticeVo);
	}

	private List<NoticeVO> searchNoticeList(HttpServletRequest req) throws SQLException {
		NoticeVO noticeVo = new NoticeVO();
		
		NoticeService service = new NoticeService();
		List<NoticeVO> list = service.searchNoticeList(noticeVo);
		return list;
	}
}
