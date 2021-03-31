package kr.or.ddit.tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
// TCP
public class TcpServer {
	public static void main(String[] args) throws IOException {
		/*
 			ServerSocket(param : 포트번호)
			Socket 이용
		 */
		
		//TCP 소켓 통신을 하기 위해 ServerSocket 객체(param : 포트번호) 생성
		ServerSocket server = new ServerSocket(7777);
		System.out.println("서버가 접속을 기다립니다");
		
		// accept()메서드는 client에서 연결 요청이 올 때까지 계속 기다린다
		// 연결 요청이 오면 Socket객체를 생성해서 Client의 Socket과 연결한다
		Socket socket = server .accept(); // block 상태로 전환되고  client의 연결요청을 기다린다.
		
		// 이 이후는 클라이언트와 연결된 후의 작업을 진행하면 된다
		System.out.println("접속한 클라이언트 정보");
		System.out.println("주 소 : " + socket.getInetAddress());
		
		// client에 메시지 보내기
		
		// OutputStream객체를 구성하여 전송한다
		// 접속한 Socket의 getOutputStream()메서드를 이용하여 구한다
		OutputStream out = socket.getOutputStream();  // socket에 읽은 것을 write할 때 getOuputStream(), 읽은 것을 read 할 때 getInputStrea()
		DataOutputStream dos = new DataOutputStream(out); // 아래 writeUTF메서드를 사용하기 위해 만듦
		dos.writeUTF("어서오세요 이 메시지는 TcpServer에서 적어 TcpClient에게 전해질 메시지 입니다"); // TcpClient에게 전해질 메시지 보내기
		System.out.println("메시지를 ㅂ냈습니다");
		
		dos.close();
	}
}
