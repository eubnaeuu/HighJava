package kr.or.ddit.adminroom.member.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.adminroom.member.service.MemberService;
import kr.or.ddit.adminroom.member.vo.MemberVO;



@WebServlet("/AdminroomServlet")
public class AdminroomServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	String flag = req.getParameter("flag");

	try {
		if("L".equals(flag)){//목록조회
			List<MemberVO> list = searchMemberAllList(req);
			
			req.setAttribute("list", list);
			RequestDispatcher  disp = req.getRequestDispatcher("/html/adminRoom/adminRoom.jsp");
			disp.forward(req, resp);
		}
//		if("L".equals(flag)) { // 목록조회
//			List<NoticeVO> list = searchNoticeList(req);
//			 
//			req.setAttribute("list", list);
//			RequestDispatcher  disp = req.getRequestDispatcher("/html/notice/noticeListResult.jsp");
//			disp.forward(req, resp);
//		}else if("D".equals(flag)) { // 삭제
//			deleteNoticeList(req);
//			 
//			req.setAttribute("resultCnt", 1);
//			RequestDispatcher  disp = req.getRequestDispatcher("/html/common/checkResult.jsp");
//			disp.forward(req, resp);
//			
//		} else if("C".equals(flag)) { // 등록
//			createNotice(req);
//			
//			req.setAttribute("resultCnt",1);
//			RequestDispatcher disp = req.getRequestDispatcher("/html/common/checkResult.jsp");
//			disp.forward(req, resp);
//		} else if("R".equals(flag)) { // 단건 조회
//			NoticeVO nv = searchNotice(req);
//			
//			req.setAttribute("NoticeVO", nv);
//			RequestDispatcher  disp = req.getRequestDispatcher("/html/notice/noticeShowResult.jsp");
//			disp.forward(req, resp);
//		} else if("U".equals(flag)) { // 수정
//			updateNotice(req);
//			
//			req.setAttribute("resultCnt",1);
//			RequestDispatcher disp = req.getRequestDispatcher("/html/common/checkResult.jsp");
//			disp.forward(req, resp);
//		} else if("D1".equals(flag)) {//단건 삭제
//			deleteNotice1(req);
//			
//			req.setAttribute("resultCnt", 1);
//			RequestDispatcher  disp = req.getRequestDispatcher("/html/common/checkResult.jsp");
//			disp.forward(req, resp);
//		}
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

//	private List<NoticeVO> searchNoticeList(HttpServletRequest req) throws SQLException {
//		NoticeVO noticeVo = new NoticeVO();
//		
//		NoticeService service = new NoticeService();
//		List<NoticeVO> list = service.searchNoticeList(noticeVo);
//		return list;
//	}


//	private void deleteNotice1(HttpServletRequest req) throws SQLException {
//		int noticeNo = Integer.parseInt(req.getParameter("noticeNo"));
//		
//		NoticeService service = new NoticeService();
//		service.deleteNotice(noticeNo);
//	}
//
//	private void updateNotice(HttpServletRequest req) throws SQLException {
//		int noticeNo = Integer.parseInt(req.getParameter("noticeNo"));
//		String adminId = req.getParameter("adminId");
//		String noticeContent = req.getParameter("noticeContent");
//		String noticeTitle = req.getParameter("noticeTitle");
//		
//		NoticeVO nv = new NoticeVO();
//		nv.setNoticeNo(noticeNo);
//		nv.setAdminId(adminId);
//		nv.setNoticeContent(noticeContent);
//		nv.setNoticeTitle(noticeTitle);
//		
//		NoticeService service = new NoticeService();
//		service.updateNotice(nv);
//	}
//
//	private NoticeVO searchNotice(HttpServletRequest req) throws SQLException {
//		int noticeNo = Integer.parseInt(req.getParameter("noticeNo"));
//		
//		NoticeVO nv = new NoticeVO();
//		nv.setNoticeNo(noticeNo);
//		
//		NoticeService service = new NoticeService();
//		NoticeVO resultnv = service.searchNotice(nv);
//		return resultnv;
//	}
//
//	private void createNotice(HttpServletRequest req) throws SQLException {
//		String adminId = req.getParameter("adminId");
//		String noticeTitle = req.getParameter("noticeTitle");
//		String noticeContent = req.getParameter("noticeContent");
//		
//		NoticeVO noticeVo = new NoticeVO();
//		noticeVo.setAdminId(adminId);
//		noticeVo.setNoticeTitle(noticeTitle);
//		noticeVo.setNoticeContent(noticeContent);
//		
//		NoticeService service = new NoticeService();
//		service.createNotice(noticeVo);
//	}
//
//	private void deleteNoticeList(HttpServletRequest req) throws SQLException {
//		
//		String[] tmpArr = req.getParameterValues("noticeNoArr");
//		int[] arr = new int[tmpArr.length];
//		for (int i = 0; i < tmpArr.length; i++) {
//			
//			
//			arr[i]= Integer.parseInt(tmpArr[i]);
//		}
//		
//		NoticeVO noticeVo = new NoticeVO();
//		noticeVo.setNoticeNoArr(arr);
//		
//		NoticeService service = new NoticeService();
//		service.deleteNoticeList(noticeVo);
//	}
//
	private List<MemberVO> searchMemberAllList(HttpServletRequest req) throws SQLException {
		MemberVO mv = new MemberVO();
		
		MemberService service = new MemberService();
		List<MemberVO> list = service.getSearchMember(mv);
		return list;
	}
}
