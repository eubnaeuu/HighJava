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
		}else if("N".equals(flag)){
			List<MemberVO> list = searchMemberNameList(req);
			
			req.setAttribute("list", list);
			RequestDispatcher  disp = req.getRequestDispatcher("/html/adminRoom/adminRoom.jsp");
			disp.forward(req, resp);
		}else if("NI".equals(flag)){
			List<MemberVO> list = searchMemberNicknameList(req);
			
			req.setAttribute("list", list);
			RequestDispatcher  disp = req.getRequestDispatcher("/html/adminRoom/adminRoom.jsp");
			disp.forward(req, resp);
		}else if("I".equals(flag)){
			List<MemberVO> list = searchMemberIdList(req);
			
			req.setAttribute("list", list);
			RequestDispatcher  disp = req.getRequestDispatcher("/html/adminRoom/adminRoom.jsp");
			disp.forward(req, resp);
		}

		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}


	//이름
	private List<MemberVO> searchMemberNameList(HttpServletRequest req) throws SQLException {
		String memName = req.getParameter("memName");
		
		MemberVO mv = new MemberVO();
		mv.setMemName(memName);
		
		MemberService service = new MemberService();
		List<MemberVO> list = service.getSearchMemberName(mv);
		
		return list;
	}
	//닉네임
	private List<MemberVO> searchMemberNicknameList(HttpServletRequest req) throws SQLException {
		String memNickname = req.getParameter("memNickname");
		
		MemberVO mv = new MemberVO();
		mv.setMemNickname(memNickname);
		
		MemberService service = new MemberService();
		List<MemberVO> list = service.getSearchMemberNickname(mv);
		
		return list;
	}
	//아이디
	private List<MemberVO> searchMemberIdList(HttpServletRequest req) throws SQLException {
		String memId = req.getParameter("memId");
		
		MemberVO mv = new MemberVO();
		mv.setMemId(memId);
		
		MemberService service = new MemberService();
		List<MemberVO> list = service.getSearchMemberId(mv);
		
		return list;
	}

	private List<MemberVO> searchMemberAllList(HttpServletRequest req) throws SQLException {
		MemberVO mv = new MemberVO();
		
		MemberService service = new MemberService();
		List<MemberVO> list = service.getSearchMember(mv);
		return list;
	}
}
