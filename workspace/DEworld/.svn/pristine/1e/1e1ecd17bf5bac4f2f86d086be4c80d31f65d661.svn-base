package loginPage.servlet;

import java.util.Random;
import java.util.List;
import java.util.Properties;

import java.io.IOException;
import java.sql.SQLException;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import kr.or.ddit.member.vo.MemberVO;
import loginPage.service.MemberService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MailServlet")
public class MailServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		

		int resultCnt = 0;
		String flag = req.getParameter("flag");
		String memMail = null;
		
		System.out.println("flag : " + flag);
		
		if(flag.equals("findId")) {
			
			memMail = req.getParameter("memMail");
			System.out.println("memMail : " + memMail);
			MemberVO memberVo = new MemberVO();
			memberVo.setMemMail(memMail);
			
			try {
				MemberService service = new MemberService();
				List<MemberVO> list = service.findId(memberVo);
				System.out.println(list);
				if(list.size() == 0) {
					resultCnt = 1;
					System.out.println("매칭되는 이메일 정보 없음 !");
				}	
				req.setAttribute("resultCnt", resultCnt);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} else if(flag.equals("findPw")) {
			
			memMail = req.getParameter("memMail");
			String memId = req.getParameter("memId");
			System.out.println(memMail);
			System.out.println(memId);
			MemberVO memberVO = new MemberVO();
			memberVO.setMemMail(memMail);
			memberVO.setMemId(memId);
			
			try {
				MemberService service = new MemberService();
				List<MemberVO> list = service.findIdEmail(memberVO);
				System.out.println(list);
				if(list.size() == 0) {
					resultCnt = 1;
					System.out.println("매칭되는 정보 없음 !");
				}
				req.setAttribute("resultCnt", resultCnt);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		if(resultCnt == 0) {
			String host = "smtp.naver.com";
			String user = "kdhz1001@naver.com";
			String password = "en1590ghks7586#";
			
			String to_email = memMail;
			
			Properties props = new Properties();
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.port", 465);
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.ssl.enable", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.debug", "true");
			
			StringBuffer temp = new StringBuffer();
			Random rnd = new Random();
			for (int i = 0; i < 10; i++) {
				int rIndex = rnd.nextInt(3);
				switch (rIndex) {
				case 0:
					// a-z
					temp.append((char) ((int) (rnd.nextInt(26)) + 97));
					break;
				case 1:
					// A-Z
					temp.append((char) ((int) (rnd.nextInt(26)) + 65));
					break;
				case 2:
					// 0-9
					temp.append((rnd.nextInt(10)));
					break;
				}
			}
			String AuthenticationKey = temp.toString();
			System.out.println(AuthenticationKey);
			
			Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(user, password);
				}
			});
			
			try {
				MimeMessage msg = new MimeMessage(session);
				msg.setFrom(new InternetAddress(user, "KDH"));
				msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to_email));
				
				// ���� ����
				msg.setSubject("DEWorld 인증 메일 입니다.");
				// ���� ����
				msg.setText("인증번호 :" + temp);
				
				Transport.send(msg);
				
			} catch (Exception e) {
				e.printStackTrace();// TODO: handle exception
			}
			HttpSession saveKey = req.getSession();
			saveKey.setAttribute("AuthenticationKey", AuthenticationKey);
		}
		RequestDispatcher disp = req.getRequestDispatcher("/html/findIdResult.jsp");
		disp.forward(req, resp);
	}

}