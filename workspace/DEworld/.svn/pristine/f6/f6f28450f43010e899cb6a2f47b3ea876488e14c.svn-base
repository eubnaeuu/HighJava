package kr.or.ddit.notice.base;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.notice.ibatis.SqlMapClientFactory;

public class BaseDao {
	private SqlMapClient smc;

	protected SqlMapClient getSqlMapClient() {
		if(smc == null)
			smc = SqlMapClientFactory.getInstance();
		
		return smc;
	}
	
}
