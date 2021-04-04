package kr.or.ddit.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Whisper_Clinet {


	Scanner scan = new Scanner(System.in);
	private String nickName; // 대화명

	// 프로그램 시작
	public void startClient() {
		// 대화명 입력받기
		System.out.println("대화명 >>");
		nickName = scan.next();

		Socket socket = null;

		try {
			socket = new Socket("localhost", 7777);
			System.out.println("서버에 연결되었습다");

			// 송신용 스레드 생성
			ClientSender sender = new ClientSender(socket, nickName);
			
			// 수신용 스레드 생성
			ClientReceiver receiver  = new ClientReceiver(socket);
			
			sender.start();
			receiver.start();
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	// 메시지를 전송하듣 스레드
	class ClientSender extends Thread {
		Socket socket;
		DataOutputStream dos;
		String name;
		Scanner scan = new Scanner(System.in);

		public ClientSender(Socket socket, String name) { // 생성자 파라미터 추가 (socket, name)
			this.socket = socket;
			this.name = name;

			try {
				dos = new DataOutputStream(socket.getOutputStream());
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

		@Override
		public void run() {
			try {
				// 시작하자 마자 자신의 대화명을 서버로 전송
				if (dos != null) {
					dos.writeUTF(name);
				}
				while (dos != null) {
					// 키보드를 입력받은 메시지를 서버로 전송
					// dos는 server 1사람에게만 보내기에  전역변수로 두었음
					//(server에서 모든 client에게 뿌릴때는 회원수만큼 dos 생성해야함)
					// 귓속말 기능 /w 사용자명 메시지
					
					dos.writeUTF(scan.nextLine()); 
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	class ClientReceiver extends Thread {
		Socket socket;
		DataInputStream dis;

		public ClientReceiver(Socket socket) {
			this.socket = socket;
			try {
				dis = new DataInputStream(socket.getInputStream());
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

		@Override
		public void run() {
			while (dis != null) {
				try {
					System.out.println(dis.readUTF());
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
			new MultichatClient().startClient();
	}
}