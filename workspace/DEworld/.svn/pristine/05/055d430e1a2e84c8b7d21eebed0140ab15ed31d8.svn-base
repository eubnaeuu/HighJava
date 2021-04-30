package kr.or.ddit.member.handler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.comm.handler.CommandHandler;
import kr.or.ddit.hompi.service.HompiService;
import kr.or.ddit.hompi.service.HompiServiceImpl;
import kr.or.ddit.hompi.vo.HompiVO;
import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.service.ZipService;
import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.member.vo.ZipVO;

public class InsertMemberHandler implements CommandHandler {
	private static final String VIEW_PAGE 
					= "/WEB-INF/view/member/insertForm.jsp";
	
	@Override
	public boolean isRedirect(HttpServletRequest req) {
		return false;
	}
//신규회원 등록
	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) 
			throws Exception {
		if(req.getMethod().equals("GET")) { //GET방식인 경우 isRedirect을 하지 않는다
			return VIEW_PAGE;
		}else {
		// 브라우저로 부터 받은 값을 사용하기 위해 request에서 parameter를 get.
				String flag = req.getParameter("flag");
				
				try {
					if("C".equals(flag)) { // 등록
						createMember(req);						
						req.setAttribute("resultCnt", 1);		
						return "/html/common/checkResult.jsp";
					} else if("CHKID".equals(flag)) { // ID 체크
						boolean checkM = checkMemberId(req);

						int resultCnt = 0;
						if(checkM != false) {
							resultCnt = 1;
						}
						
						req.setAttribute("resultCnt", resultCnt);
						return "/html/common/checkResult.jsp";
						
					} else if("CHKNickname".equals(flag)) { // ID 체크
						boolean checkM = checkMemberNickname(req);

						int resultCnt = 0;
						if(checkM != false) {
							resultCnt = 1;
						}
						
						req.setAttribute("resultCnt", resultCnt);
						return "/html/common/checkResult.jsp";
						
					} else if("Z".equals(flag)) { 
						ZipService zipService = new ZipService();
						List<ZipVO> list = new ArrayList<ZipVO>();
						String flag_zip = req.getParameter("flag_zip");
						
						if("SI".equals(flag_zip)) {
							list = zipService.retrieveSidoList();
							
						} else if("GU".equals(flag_zip)) {
							ZipVO zipVo = new ZipVO();
							zipVo.setSido(req.getParameter("sido"));
							list = zipService.retrieveGugunList(zipVo);
							
						} else if("DONG".equals(flag_zip)) {
							ZipVO zipVo = new ZipVO();
							zipVo.setSido(req.getParameter("sido"));
							zipVo.setGugun(req.getParameter("gugun"));
							list = zipService.retrieveDongList(zipVo);
							
						} else {
							ZipVO zipVo = new ZipVO();
							zipVo.setSido(req.getParameter("sido"));
							zipVo.setGugun(req.getParameter("gugun"));
							zipVo.setDong(req.getParameter("dong"));
							list = zipService.retrieveZipList(zipVo);
							
						}
						
						req.setAttribute("list", list);
						
						return "/html/common/zipListResult.jsp";
					}
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return null;
				
	}
	private boolean checkMemberId(HttpServletRequest req) throws SQLException {
		String memId = req.getParameter("memId");

		IMemberService memberService = MemberServiceImpl.getInstance();
		boolean checkM = memberService.checkMember(memId);
		return checkM;
	}
	
	private boolean checkMemberNickname(HttpServletRequest req) throws SQLException {
		String memNickname = req.getParameter("memNickname");

		IMemberService memberService = MemberServiceImpl.getInstance();
		boolean checkM = memberService.checkMemberNickname(memNickname);
		return checkM;
	}

	private void createMember(HttpServletRequest req) throws Exception {

		MemberVO memberVo = new MemberVO();
		BeanUtils.populate(memberVo, req.getParameterMap());
		IMemberService memberService = MemberServiceImpl.getInstance();
		memberService.insertMember(memberVo);
		String memId = memberVo.getMemId();
		
		HompiService hompiService = HompiServiceImpl.getInstance();
		HompiVO hv = new HompiVO();
		hv.setHompiId(memId);
		hv.setMemId(memId);
		hv.setScrapCount(0);
		hv.setHompiProfileImg("dftProfileImg.png");
		hv.setHompiMiniroom("dftMn.png");
		
		hompiService.insertHompi(hv);
		
		
		
		
	}
}
