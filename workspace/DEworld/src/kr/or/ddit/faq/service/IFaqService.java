package kr.or.ddit.faq.service;

import java.util.List;

import kr.or.ddit.faq.vo.FaqVO;


public interface IFaqService {
	
	public FaqVO getFaq(String faqId);
	
	public List<FaqVO> getAllFaqList();
	
	public List<FaqVO> getSearchFaq(FaqVO iv);
	
}
