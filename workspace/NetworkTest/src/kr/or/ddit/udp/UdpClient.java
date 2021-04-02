package kr.or.ddit.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpClient {
	public void start() throws IOException {
		
		DatagramSocket datagramSocket = new DatagramSocket();
		
		InetAddress serverAddress = InetAddress.getByName("127.0.0.1");
		
		// 데이터가 저장될 공간으로 byte배열을 생성한다(패킷 수신용)
		byte[] msg = new byte[100];
																													// 1byte만 보낼 것(내 아이피랑, 포트번호 주는 목적으로)
																												//byte buf[], int length, InetAddress address, int port
		DatagramPacket outPacket = new DatagramPacket(msg, 1, serverAddress, 8888); // 데이터 송신용
		DatagramPacket inPacket = new DatagramPacket(msg, msg.length);  // 데이터 수신용
				
		
		// 실제 연결은 여기서
		datagramSocket.send(outPacket); // 패킷송신
		datagramSocket.receive(inPacket); // 패킷수신 (server에서 보내주는 데이터 받기위해)
																															// ☆  DatagramPacket.getData() 메서드
				System.out.println("현재 서버 시간 => " + new String(inPacket.getData()));
				datagramSocket.close(); // 소켓종료
	}
public static void main(String[] args) throws IOException {
	new UdpClient().start();
}
}
