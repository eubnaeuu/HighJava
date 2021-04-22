package kr.or.ddit.member.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.member.dao.ZipDao;
import kr.or.ddit.member.vo.ZipVO;

public class ZipService {
	private ZipDao dao;
	
	public ZipService() {
		if(dao == null)
			dao = new ZipDao();
	}
	
	public List<ZipVO> retrieveSidoList() throws SQLException {
		return dao.retrieveSidoList();
	}
	
	public List<ZipVO> retrieveGugunList(ZipVO zipVO) throws SQLException {
		return dao.retrieveGugunList(zipVO);
	}
	
	public List<ZipVO> retrieveDongList(ZipVO zipVO) throws SQLException {
		return dao.retrieveDongList(zipVO);
	}
	
	public List<ZipVO> retrieveZipList(ZipVO zipVO) throws SQLException {
		return dao.retrieveZipList(zipVO);
	}
	
}
