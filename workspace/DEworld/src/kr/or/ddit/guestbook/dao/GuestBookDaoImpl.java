package kr.or.ddit.guestbook.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.guestbook.vo.GuestBookVO;


public class GuestBookDaoImpl implements GuestBookDao {

   private static GuestBookDao guestbookDao;
   
   private GuestBookDaoImpl() {
	   
   }
   
   public static GuestBookDao getInstance() {
	   if(guestbookDao == null) {
		   guestbookDao = new GuestBookDaoImpl();
	   }
	   
	   return guestbookDao;
   }
   
   @Override
   public int insertGuestBook(SqlMapClient smc, GuestBookVO pv) throws SQLException {
	   	int cnt = 0;
	   
        Object obj = smc.insert("guestbook.insertGuestBook", pv);
        
        if(obj == null) {
        	cnt = 1;
        }
      return cnt;
   }

   @Override
   public boolean checkGuestBook(SqlMapClient smc, String guestbookNo) throws SQLException {
      boolean chk = false;
      
      int cnt = (int) smc.queryForObject("guestbook.getGuestBook", guestbookNo);
      
      if(cnt > 0) {
    	  chk = true;
      }
      return chk;
   }

   @Override
   public List<GuestBookVO> getGuestBookList(SqlMapClient smc, GuestBookVO apv) throws SQLException {
      
      List<GuestBookVO> guestbookList = smc.queryForList("guestbook.getGuestBook", apv);
      return guestbookList;
   }

   @Override
   public int updateGuestBook(SqlMapClient smc, GuestBookVO pv) throws SQLException {
      
      int cnt = 0;
      cnt = smc.update("guestbook.updateGuestBook", pv);
      return cnt;
   }
   @Override
   public int updateGuestBookView(SqlMapClient smc, GuestBookVO pv) throws SQLException {
	   
	   int cnt = 0;
	   cnt = smc.update("guestbook.updateGuestBookView", pv);
	   return cnt;
   }

   @Override
   public int deleteGuestBook(SqlMapClient smc, String guestbookNo) throws SQLException {
      
      int cnt = smc.delete("guestbook.deleteGuestBook", guestbookNo);
      
      return cnt;
   }

   @Override
   public List<GuestBookVO> getSearchGuestBook(SqlMapClient smc,GuestBookVO apv) throws SQLException {
      
      List<GuestBookVO> guestbookList = 
    		  smc.queryForList("guestbook.getSearchGuestBook", apv);
      
      return guestbookList;
   }

   @Override
   public GuestBookVO getGuestBookView(SqlMapClient smc, GuestBookVO pv) throws SQLException {
	   GuestBookVO guestbookvo = 
			(GuestBookVO)smc
			.queryForObject("guestbook.getGuestBookView", pv);
	
			return guestbookvo;
	}
   @Override
public int getGuestBookListCount(SqlMapClient smc,GuestBookVO pv) throws SQLException {
	int cnt = 0;
    cnt = (int) smc.queryForObject("guestbook.getGuestBookAllCount", pv);
	return cnt;
}
}


































