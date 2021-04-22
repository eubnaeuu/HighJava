package kr.or.ddit.comments.service;

import java.util.List;

import kr.or.ddit.comments.vo.CommentsVO;

/**
 * 회원정보 처리를 수행하는 서비스 
 */
public interface CommentsService {
	
	/**
	 * 회원등록하는 메서드
	 * @param pv DB에 insert할 자료가 저장된 CommentsVO객체
	 * @return DB작업이 성공하면 1이상의 값이 반환되고, 실패하면 0이 반환된다.
	 */
	public int insertComments(CommentsVO cv);
	
	/**
	 * 주어진 회원ID가 존재하는지 여부를 알아내는 메서드
	 * @param CommentsNo 회원ID
	 * @return 해당 회원ID가 존재하면 true, 존재하지 않으면 false
	 */
	public boolean checkComments(String CommentsNo);
	
	/**
	 * 전체 회원정보 조회 메서드
	 * @return 회원정보를 담고있는 List객체
	 */
	public List<CommentsVO> getAllCommentsList();
	
	/**
	 * 하나의 회원정보를 수정하는 메서드
	 * @param pv 회원정보 객체
	 * @return 작업성공: 1, 작업실패: 0
	 */
	public int updateComments(CommentsVO cv);
	
	/**
	 * 회원정보를 삭제하는 메서드
	 * @param CommentsNo 삭제할 회원ID
	 * @return 작업성공 : 1, 작업실패: 0 
	 */
	public int deleteComments(String CommentsNo);
	
	
	/**
	 * CommentsVO 객체에 담긴 자료를 이용하여 회원을 검색하는 메서드
	 * @param pv 검색할 자료가 들어있는 CommentsVO 객체
	 * @return 검색된 결과를 담은 List
	 */
	public List<CommentsVO> getSearchComments(CommentsVO cv);
	
	/**
	 * 주어진 회원ID에 해당하는 회원정보를 조회하는 메서드
	 * @param CommentsNo 검색할 회원ID
	 * @return 해당 회원ID에 해당하는 회원정보
	 */
	public CommentsVO getComments(String CommentsNo);
	
}
