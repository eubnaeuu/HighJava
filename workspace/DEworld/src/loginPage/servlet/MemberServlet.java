package loginPage.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import loginPage.service.MemberService;
import kr.or.ddit.member.vo.MemberVO;

@WebServlet("/MemberServlet")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 브라우저로 부터 받은 값을 사용하기 위해 request에서 parameter를 get.
		
		try {
				List<MemberVO> list = matchinIdPw(req);
				
				req.setAttribute("list", list);
				RequestDispatcher disp = req.getRequestDispatcher("/html/loginResult.jsp");
				disp.forward(req, resp);
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private List<MemberVO> matchinIdPw(HttpServletRequest req) throws SQLException {

		String memId = req.getParameter("memId");
		String memPass = req.getParameter("memPass");
		System.out.println("memId : " + memId + "memNAme : " + memPass);
		// form serialize를 사용해서 파라미터를 전달한 경우, request에 요소의 name으로 parameter가 매핑됨.
		// 예) <input type="text" name="userId"> ==> req.getParameter("userId")

		MemberVO memberVo = new MemberVO();
		memberVo.setMemId(memId);
		memberVo.setMemPass(memPass);

		// 회원 목록 조회
		MemberService service = new MemberService();
		List<MemberVO> list = service.matchinIdPw(memberVo);
		return list;
	}
}
