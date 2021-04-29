package kr.or.ddit.collection.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.collection.dao.CollectionDao;
import kr.or.ddit.collection.dao.CollectionDaoImpl;
import kr.or.ddit.collection.vo.CollectionVO;
import kr.or.ddit.util.SqlMapClientUtil;

public class CollectionServiceImpl implements CollectionService {
	
	private SqlMapClient smc;
	private CollectionDao collectionDao;
	private static CollectionService service;
	
	private CollectionServiceImpl() {
		collectionDao = CollectionDaoImpl.getInstance();
		smc = SqlMapClientUtil.getInstance();
	}
	
	public static CollectionService getInstance() {
		if(service == null) {
			service = new CollectionServiceImpl();
		}
		
		return service;
	}

	@Override
	public List<CollectionVO> getSearchItemCollection(CollectionVO cv) {
List<CollectionVO> itemCollectionList = new ArrayList<>();
		
		try {
			itemCollectionList = collectionDao.getSearchItemCollection(smc, cv);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	      
	    return itemCollectionList;
	}

	@Override
	public List<CollectionVO> getSearchMusicCollection(String memId) {
		List<CollectionVO> musicCollectionList = new ArrayList<>();
				
				try {
					musicCollectionList = collectionDao.getSearchMusicCollection(smc, memId);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			      
			    return musicCollectionList;
			}

	
	

}
