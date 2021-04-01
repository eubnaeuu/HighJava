package kr.or.ddit.tcp;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpFileReceiver {
	public static final int DEFAULT_BUFFER_SIZE = 1000;
	
	public static void main(String[] args) throws IOException {
		int port = 8888;
		long fileSize;
		long totalReadBytes = 0;
		byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
		
		int readBytes = 0;
		
		System.out.println("파일 수신 대기중...");
		DatagramSocket ds = new DatagramSocket(port);
		FileOutputStream fos = null;
		fos = new FileOutputStream("d:/D_Other/Test_UdpFileReceiver.jpg");
		
		DatagramPacket dp = new  DatagramPacket(buffer,buffer.length);
		ds.receive(dp);
		
		String str = new String (dp.getData()).trim();
		
		if(str.equals("start")) { // sender에서 전송을 시작하는 경우....
			
			dp = new DatagramPacket(buffer, buffer.length); // 새로운 그릇
			ds.receive(dp);
			str = new String(dp.getData()).trim(); //sender에서 총파일사이즈 전송했음.(바이트타입을 string타입으로)
			System.out.println(str);
			fileSize = Long.parseLong(str);
			
			double startTime = System.currentTimeMillis();
			
			while(true) {
				ds.receive(dp); // 실제 파일 받기 시작
				str = new String(dp.getData()).trim(); // str로 정하는 이유(?)  
				readBytes = dp.getLength(); // 읽어온 패킷 사이즈 (총파일사이즈와 혼동 X)
				fos.write(dp.getData(), 0, readBytes);
				
				totalReadBytes += readBytes;
				System.out.println("In progress : " + totalReadBytes + "/" + fileSize + "Bytes ( " + (totalReadBytes * 100 / fileSize) + "%)");
				
				if(totalReadBytes >= fileSize) { // 다 읽었는지
					break;
				}
			}
			
			double endTime = System.currentTimeMillis();
			double diffTime = (endTime - startTime) / 1000;
			double transferSpeed = (fileSize / 1000) / diffTime ;
			
			System.out.println("걸린 시간 : " + diffTime + " 초");
			System.out.println("평균전송속도 : " + transferSpeed + "KB/s");
			System.out.println("수신 처리 완료...");
			
			fos.close();
			ds.close();
		}else {
			System.out.println("수신 처리 불가...");
			fos.close();
			ds.close();
		}
	}
}
