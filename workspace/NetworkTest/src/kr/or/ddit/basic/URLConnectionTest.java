package kr.or.ddit.basic;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class URLConnectionTest {
	public static void main(String[] args) throws IOException {
			// URLConnection => 애플리케이션과 URL간의 통신 연결을 위한 추상클래스
		
		// 특정서버(예: naver)의 정보와 파일 내용을 출력하기
		URL url = new URL("https://www.naver.com/index.html");
		
		// Header 정보 가져오기
		
		//URLConnection 객체 구하기 (url.openConnection())
		// URLConnection은 추상클래스
		URLConnection urlCon = url.openConnection(); // 연결

		// 헤더값 구하기(?) URLConnection 
		System.out.println("Content - Type : " // text/html
												+ urlCon.getContentType());
		System.out.println("Encoding : " // utf-8
												+ urlCon.getContentEncoding());
		System.out.println("Content : "
												+ urlCon.getContent());
		System.out.println();
		
		// 전체 Header 정보 출력하기
		
		Map<String, List<String>> headerMap = urlCon.getHeaderFields();
		
		// Header의 key값 구하기
		System.out.println("햏");
		Iterator<String >	it = headerMap.keySet().iterator();
		while(it.hasNext()) {
			String key = it.next();
			System.out.println(key + " : " + headerMap.get(key));
		}
		System.out.println("-----------------------------");
		
		// 해당 호스트의 페이지 내용 가져오기
		
		
		// 파일을 읽어오기 위한 스트림 생성 ( URLConnection.getInputStream() )
		InputStream is = urlCon.getInputStream();
		InputStreamReader isr = new InputStreamReader(is, "utf-8"); // 한글을 읽기 위해 보조스티림 이용
		
		int c = 0;
		while((c=isr.read()) != -1){
			System.out.print((char) c);
		}
		isr.close();
		
		
		}
	}

