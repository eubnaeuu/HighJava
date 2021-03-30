package kr.or.ddit.tcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Receiver extends Thread {
	private DataInputStream dis;

	public Receiver(Socket socket) { // 객체 생성 Socket을 받는다
		try {
			dis = new DataInputStream(socket.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {   // block 된다니?????
		System.out.println("receiver thread run구분1");
		while (dis != null) {
			try {
				System.out.println(dis.readUTF());
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}
