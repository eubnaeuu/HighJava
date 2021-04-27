package kr.or.ddit.post.service;

import java.util.List;

import kr.or.ddit.paging.PagingVO;
import kr.or.ddit.post.vo.AllPostVO;
import kr.or.ddit.post.vo.PostVO;

/**
 * 회원정보 처리를 수행하는 서비스 
 */
public interface PostService {
	
	/**
	 * 회원등록하는 메서드
	 * @param pv DB에 insert할 자료가 저장된 PostVO객체
	 * @return DB작업이 성공하면 1이상의 값이 반환되고, 실패하면 0이 반환된다.
	 */
	public int insertPost(PostVO pv);
	
	/**
	 * 주어진 회원ID가 존재하는지 여부를 알아내는 메서드
	 * @param postNo 회원ID
	 * @return 해당 회원ID가 존재하면 true, 존재하지 않으면 false
	 */
	public boolean checkPost(String postNo);
	
	/**
	 * 전체 회원정보 조회 메서드
	 * @return 회원정보를 담고있는 List객체
	 */
	public List<PostVO> getAllPostList(AllPostVO apv);
	
	/**
	 * 하나의 회원정보를 수정하는 메서드
	 * @param pv 회원정보 객체
	 * @return 작업성공: 1, 작업실패: 0
	 */
	public int updatePost(PostVO pv);
	public int updatePostView(PostVO pv);
	
	/**
	 * 회원정보를 삭제하는 메서드
	 * @param postNo 삭제할 회원ID
	 * @return 작업성공 : 1, 작업실패: 0 
	 */
	public int deletePost(String postNo);
	
	
	/**
	 * PostVO 객체에 담긴 자료를 이용하여 회원을 검색하는 메서드
	 * @param pv 검색할 자료가 들어있는 PostVO 객체
	 * @return 검색된 결과를 담은 List
	 */
	public List<PostVO> getSearchPost(AllPostVO apv);
	public List<PostVO> getSearchPhoto(AllPostVO apv);
	
	/**
	 * 주어진 회원ID에 해당하는 회원정보를 조회하는 메서드
	 * @param postNo 검색할 회원ID
	 * @return 해당 회원ID에 해당하는 회원정보
	 */
	public PostVO getPost(String postNo);
	
	public int getAllPostListCount(PostVO pv);
	
}
