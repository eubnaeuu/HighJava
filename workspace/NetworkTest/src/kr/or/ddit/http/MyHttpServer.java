package kr.or.ddit.http;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URLConnection;
import java.util.StringTokenizer;



/**
 * 간단한 웹서버 예제
 * 
 * ☆과정 : 요청 -> 응답 인가?  
 */
public class MyHttpServer {
	private final int port = 80;
	private final String encoding = "UTF-8";

	/**
	 * 응답 헤더 생성하기
	 * 
	 * @param contentLength 응답내용 크기
	 * @param mimeType 마임타입
	 * @return 바이트 배열
	 */
	private byte[] makeResponseHeader(int contentLength, String mimeType) {

		String header = "HTTP/1.1 200 OK\r\n" // status 라인
				+ "Server: MyHTTPServer 1.0\r\n" // 헤더....
				+ "Content-length : " + contentLength + "\r\n" + "Content-type : " + mimeType + "; charset="
				+ this.encoding + "\r\n\r\n "; // emptyline
		return header.getBytes();
	}

	/**
	 * 
	 * 응답 내용 생성하기
	 * - [파일경로]를 파라미터로 받아 데이터를 반환
	 * 
	 * @param filePath 응답으로 사용할 파일경로
	 * @return 바이트배열 데이터
	 * @throws IOException
	 * 
	 */
	private byte[] makeResponseBody(String filePath) throws IOException {
		FileInputStream fis = null;
		byte[] data = null;
		try {
			File file = new File(filePath);
			data = new byte[(int) file.length()];   // 파일 크기의 byte만듬
			fis = new FileInputStream(file); // file 바이트기반 읽기위한 기반 스트림                    
			fis.read(data);
		} finally {
			if (fis != null) {
				fis.close();
			}
		}
		return data;
	}

	/**
	 * 에러 페이지 생성
	 * 
	 * @param out
	 * @param statusCode
	 * @param errMsg
	 */
	private void makeErrorPage(OutputStream out, int statusCode, String errMsg) {
		String statusLine = "HTTP/1.1" + " " + statusCode + " " + errMsg; // statusCode : 정상이라면 200
		try {
			out.write(statusLine.getBytes());
			out.flush();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}
	/**
	 * HTTP 서버 시작
	 */
	public void startServer() {
		
		try(ServerSocket server = new ServerSocket(this.port)) {
			
			while(true) {
				try {
				Socket socket = server.accept();
				
				//Http 요청처리를 위한 스레드 객체 생성
				HttpHandler handler = new HttpHandler(socket);  // ☆ 요 socket은 자웅동체인가?
				new Thread(handler).start();
				
				}catch(IOException ex) {
					System.err.println("커넥션 오류....!");
					ex.printStackTrace();
				}catch(RuntimeException ex) {
					System.err.println("알 수 없는 오류...!");
					ex.printStackTrace();
				}
			}
			
		} catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	/**
	 * HTTP 요청 처리를 위한 Runnable 객체
	 */
	private class HttpHandler implements Runnable {
		private final Socket socket;
		
		public  HttpHandler(Socket socket) {
			this.socket = socket;
		}
		@Override
		public void run() {
			OutputStream out = null;
			BufferedReader br = null;
			try {
				out=new BufferedOutputStream (socket.getOutputStream());
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				// ☆ 버퍼와 리더는 누가감싸든 상관 없는건가(?) 그럼 여기서 자리를 바꿔도 똑같이 나오는 건지(?)
				
				// 요청헤더 정보 파싱하기
				StringBuilder request = new StringBuilder();
				while(true) {
					String str = br.readLine();
					if(str.equals(""))break; // emptyLine체크
					request.append(str + "\n");
					
				}
				
				System.out.println("요청헤더 : \n" + request.toString());
				String reqPath = "";
				// 요청페이지 정보 가져오기
				StringTokenizer st = new StringTokenizer(request.toString());
				while(st.hasMoreTokens()) {
					String token = st.nextToken();
					if(token.startsWith("/")) { //        GET /index.html ....... 
						reqPath = token; //    [/index.html]
					}
				}
				// 상대경로(프로젝트 폴더 기준) 설정
				String fileName = "./WebContent" + reqPath;
				// 해당 파일 이름을 이용하여 Countent-type 정보 추출하기
				String contentType = URLConnection.getFileNameMap().getContentTypeFor(fileName);
				System.out.println("contentType => " + contentType);
				File file = new File(fileName);
				if(!file.exists()) {
					makeErrorPage(out, 404, "Not Found");
					return;
				}
				byte[] body = makeResponseBody(fileName);
				byte[] header = makeResponseHeader(body.length, contentType);
				// 요청헤더가 HTTP/1.0이나 그 이후의 버전을 지원할 경우 MIME헤더를 전송한다
				if(request.toString().indexOf("HttP/") != -1){
					out.write(header);   //응답헤더 보내기
				}
				System.out.println("응답헤더 : \n" + new String(header));
				out.write(body); // 응답내용 보내기
				out.flush();
						} catch(IOException ex) {
				System.err.println("입출력 오류...!");
				ex.printStackTrace();
			}finally {
				try {
					socket.close();
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public static void main(String[] args) {
		new MyHttpServer().startServer();
	}


//	 요청헤더 : 
//GET /NewFile.html HTTP/1.1
//Host: localhost
//Connection: keep-alive
//sec-ch-ua: "Google Chrome";v="89", "Chromium";v="89", ";Not A Brand";v="99"
//sec-ch-ua-mobile: ?0
//DNT: 1
//Upgrade-Insecure-Requests: 1
//User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.4389.114 Safari/537.36
//Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9
//Sec-Fetch-Site: none
//Sec-Fetch-Mode: navigate
//Sec-Fetch-User: ?1
//Sec-Fetch-Dest: document
//Accept-Encoding: gzip, deflate, br
//Accept-Language: ko,en-US;q=0.9,en;q=0.8
//
//contentType => text/html
//HTTP/1.1 200 OK
//Server: MyHTTPServer 1.0
//Content-length : 135
//Content-type : text/html; charset=UTF-8
//
// 
//응답헤더 ; 
//HTTP/1.1 200 OK
//Server: MyHTTPServer 1.0
//Content-length : 135
//Content-type : text/html; charset=UTF-8
//
// 
//요청헤더 : 
//GET /favicon.ico HTTP/1.1
//Host: localhost
//Connection: keep-alive
//sec-ch-ua: "Google Chrome";v="89", "Chromium";v="89", ";Not A Brand";v="99"
//DNT: 1
//sec-ch-ua-mobile: ?0
//User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.4389.114 Safari/537.36
//Accept: image/avif,image/webp,image/apng,image/svg+xml,image/*,*/*;q=0.8
//Sec-Fetch-Site: same-origin
//Sec-Fetch-Mode: no-cors
//Sec-Fetch-Dest: image
//Referer: http://localhost/NewFile.html
//Accept-Encoding: gzip, deflate, br
//Accept-Language: ko,en-US;q=0.9,en;q=0.8
//
//contentType => null
//요청헤더 : 
//GET /NewFile.html HTTP/1.1
//Host: localhost
//Connection: keep-alive
//Cache-Control: max-age=0
//sec-ch-ua: "Google Chrome";v="89", "Chromium";v="89", ";Not A Brand";v="99"
//sec-ch-ua-mobile: ?0
//DNT: 1
//Upgrade-Insecure-Requests: 1
//User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.4389.114 Safari/537.36
//Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9
//Sec-Fetch-Site: none
//Sec-Fetch-Mode: navigate
//Sec-Fetch-User: ?1
//Sec-Fetch-Dest: document
//Accept-Encoding: gzip, deflate, br
//Accept-Language: ko,en-US;q=0.9,en;q=0.8
//
//contentType => text/html
//HTTP/1.1 200 OK
//Server: MyHTTPServer 1.0
//Content-length : 135
//Content-type : text/html; charset=UTF-8
//
// 
//응답헤더 ; 
//HTTP/1.1 200 OK
//Server: MyHTTPServer 1.0
//Content-length : 135
//Content-type : text/html; charset=UTF-8

 

	 

}