package kr.or.ddit.tcp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpFileServer {
/*
 	서버는 클라이언트가 접속하면 서버 컴퓨터의 D:\D_Other\ 폴더에 있는 
 	Tulips.jpg 파일을 클라이언트로 전송한다
 */
	
	private ServerSocket serverSocket;
	private Socket socket;
	private OutputStream out;
	private FileInputStream fis;
	private File file = new File("D:\\D_Other\\dolphin1.jpg");
	
	public void startServer() {
		while(true) {
			try {
				serverSocket = new ServerSocket(7777);
				System.out.println("서버 준비 완료....");
				
				socket = serverSocket. accept();
				System.out.println("파일 전송 시작...");
				
				fis = new FileInputStream(file);
				out = socket.getOutputStream();
				
				// 한꺼번에 읽어와 전송할 데이터 저장 변수 선언
				byte[] tmp = new byte[1024];
				int c = 0;
				while((c = fis.read(tmp)) != -1 ) { // c = 1024 1024 1024  ... 252 -1
					//서버 준비 완료....	
					out.write(tmp, 0, c); // param : (byte b[],  int off,  int len) 
					// tmp를 OutputStream을 이용하여 socket에 write
				}
				out.flush();
			} catch(IOException ex) {
				ex.printStackTrace();
			}finally {
				if(fis != null) {
					try {fis.close();}catch(IOException ex) {}
				}
				if(out != null) {
					try {out.close();}catch(IOException ex) {}
				}
				if(socket != null) {
					try {socket.close();}catch(IOException ex) {}
				}
				if(serverSocket != null) {
					try {serverSocket.close();}catch(IOException ex) {}
				}
			}
		}
	}
	public static void main(String[] args) {
		new TcpFileServer().startServer();
	}
}
