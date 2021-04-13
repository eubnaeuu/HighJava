package kr.or.ddit.member.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.comm.handler.CommandHandler;

public class DeleteMemberHandler implements CommandHandler{

	@Override
	public boolean isRedirect(HttpServletRequest req) {
		
		return true; // 리다이렉트가 필요하기에 true로 바꾼다
	}

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		return null;
	}

}
