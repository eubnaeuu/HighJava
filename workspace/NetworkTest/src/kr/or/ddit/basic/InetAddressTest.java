package kr.or.ddit.basic;

import java.net.InetAddress;
import java.net.UnknownHostException;

// 서브넷마스크로 네트워크주소와  호스트주소를 구분할 수 있다.
// ip주소 : 네트워크주소 + 호스트주소

public class InetAddressTest {
	public static void main(String[] args) throws UnknownHostException {
		// InetAddress 클래스 => IP주소를 다루기 위한 클래스
		
		// naver사이트의 ip정보 가져오기
		// machin name 또는 텍스트 형식의 ip주소 (.getByName)
		InetAddress naverIp = InetAddress.getByName("www.naver.com");
		System.out.println("Host Name => " + naverIp.getHostName());
		System.out.println("Host Address => " + naverIp.getHostAddress());
	
		System.out.println();
		
		// 자기 자신 컴퓨터의 IP정보 가져오기 (.getLocalHost())
		InetAddress localIp = InetAddress.getLocalHost();
		System.out.println("내 컴퓨터의 Host Name => " + localIp.getHostName());
		System.out.println("내 컴퓨터의 Host Address => " + localIp.getHostAddress());
		
		
		// ip주소가 여러개인 호스트의 정보 가져오기 => 많은 사람이 접속해야하기에 같은 도메인 이름에 여러개의 ip주소를 가진다
		// (.getAllByName)
		InetAddress[] naverIps = InetAddress.getAllByName("www.naver.com");
		for(InetAddress nIp : naverIps) {
			System.out.println(nIp.toString());
		}
		
	}
}
