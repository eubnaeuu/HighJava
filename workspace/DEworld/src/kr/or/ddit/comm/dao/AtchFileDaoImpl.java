package kr.or.ddit.comm.dao;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.comm.vo.AtchFileVO;
import kr.or.ddit.util.SqlMapClientUtil;


public class AtchFileDaoImpl implements IAtchFileDao {
	private static IAtchFileDao dao;
	private SqlMapClient smc;

	private AtchFileDaoImpl() {
		smc = SqlMapClientUtil.getInstance();
	}

	public static IAtchFileDao getInstance() {
		if(dao == null) {
			dao = new AtchFileDaoImpl();
		}

		return dao;
	}

	@Override
	public List<AtchFileVO> getAtchFileList(AtchFileVO fileVO) throws SQLException {

		List<AtchFileVO> atchFileList = Collections.EMPTY_LIST;
		atchFileList = smc.queryForList("atchFile.getAtchFileList", fileVO);

		return atchFileList;
	}

	@Override
	public AtchFileVO getAtchFileDetail(AtchFileVO fileVO) throws SQLException {
		AtchFileVO atchFileVO = (AtchFileVO) smc.queryForObject("atchFile.getAtchFileDetail", fileVO); // AtchFileVO에 여러 파일이 첨부될 수 있음.key값2개 .(atch파일 key값ㄱ과 파일의 순번)
		return atchFileVO;
	}
	
	@Override
	public AtchFileVO searchAtchFileDetail(AtchFileVO fileVO) throws SQLException {
		AtchFileVO atchFileVO = (AtchFileVO) smc.queryForObject("atchFile.searchAtchFileDetail", fileVO); 
		return atchFileVO;
	}

	@Override
	public int insertAtchFile(AtchFileVO atchFileVO) throws SQLException {

		int cnt = 0;

		Object obj = smc.insert("atchFile.insertAtchFile", atchFileVO);

		if(obj == null) {
			cnt = 1;
		}
		return cnt;
	}

	@Override
	public int insertAtchFileDetail(AtchFileVO atchFileVO) throws SQLException {

		int cnt = 0;

		Object obj = smc.insert("atchFile.insertAtchFileDetail", atchFileVO);

		if(obj == null) {
			cnt = 1;
		}
		return cnt;
	}

	@Override
	public int deleteAtchFile(String postNo) throws SQLException {

		int cnt = 0;
		System.out.println("Dao :"+ postNo);
		Object obj = smc.delete("atchFile.deleteAtchFile", postNo);
		
		if(obj == null) {
			cnt = 1;
		}

		return cnt;
	}

	@Override
	public int deleteAtchFileDetail(String atchFileId) throws SQLException {
		int cnt = 0;
		System.out.println("Dao :"+ atchFileId);
		Object obj = smc.delete("atchFile.deleteAtchFileDetail", atchFileId);
		
		if(obj == null) {
			cnt = 1;
		}

		return cnt;
	}

}