package kr.or.ddit.rmi.inf;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import kr.or.ddit.rmi.vo.FileInfoVO;
import kr.or.ddit.rmi.vo.TestVO;


// RMI용 인터페이스는 Remote를 상속해야 한다.
public interface RemoteInterface extends Remote {
	// 이 인터페이스는 선언된 모든 메서드에서 RemoteException을
	// throws 해야 한다.
	/**
	 *  클라이언트에서 보내온 메시지 출력
	 *  
	 * @param str
	 * @return 
	 * @throws RemoteException
	 */
	public int doRemotePrint(String str) 
			throws RemoteException;
	/**
	 * 클라이언트에서 보내온 list 출력
	 * 
	 * @param list
	 * @throws RemoteException
	 */
	public void doPrintList(List<String> list) 
			throws RemoteException;
	/**
	 * 클라이언트에서 보내온 TestVO 출력
	 * 
	 * @param vo
	 * @throws RemoteException
	 */
	public void doPrintVO(TestVO vo) 
			throws RemoteException;
	/**
	 * 클라이언트로부터 받은 파일을 읽어 로컬에 파일로 저장
	 * @param fInfo
	 * @throws RemoteException
	 */
	public void setFiles(FileInfoVO[] fInfo) 
			throws RemoteException;
}
