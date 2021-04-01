package kr.or.ddit.tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * 소켓을 통해서 메시지를 보내는 역할을 담당
 * @author PC-09
 */

public class Sender extends Thread{
	private Scanner scan;
	private String name;
	private DataOutputStream dos;
	
	public Sender(Socket socket) { // 객체 생성 Socket을 받는다
		name = "[" + socket.getInetAddress() + " : " + socket.getLocalPort() + "]";
		scan = new Scanner(System.in);
		
		try {
			dos = new DataOutputStream(socket.getOutputStream());
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		System.out.println("sender thread run 구분2");
		while (dos != null) {
			try {
//				dos.writeUTF(name + " >>>>" + scan.nextLine());
				dos.writeUTF("보내메시지");
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}
