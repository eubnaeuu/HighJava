package kr.or.ddit.basic;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
/**
 * oreilly의 MultipartRequest를 이용한 파일 업로드 예제
 * (생성자 호출과 동시에 파일이 생성되기 때문에 선택적인 파일 생성처리 불가)
 */
public class UploadServlet1 extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	resp.setContentType("text/html"); 
	// 슬래시(/) 포함되면 일단 자동다운로드.
	// 그냥 문자만 들어가면 41행이 print되긴하는데 깨져서 나옴...
														
	PrintWriter out = resp.getWriter();
	
	String encType = "UTF-8";
	int maxFileSize = 5*1024*1024;
	// MultipartRequest(request, 저장경로, [최대허용크기, 인코딩캐릭터셋, 동일한 파일명 보호여부]) []는 필수아님
	// DefaultFileRenamePolicy => name.zip, name1.zip, name2.zip
	// => 업로드 된 파일이 덮어씌워지지 않도록
	
	MultipartRequest mr = new MultipartRequest(req, "d:/D_Other/", maxFileSize, encType, new DefaultFileRenamePolicy());
	File file = mr.getFile("fname"); //   // name값이 fname인 요소의 value를 File로 저장		
			System.out.println(file); // 첨부된 파일의 전체경로 출력
			// name="str"에 해당하는 요소의 value값 반환
			System.out.println(mr.getParameter("tmpnm1")); // 파라미터값 가져오기 ( title이지만 왜 value값을 가져오는지? 실제 title값을 가져오지는 못하는지? 아..그런데 form에서 값을 전달할때 name과 value만 전달하는듯?)

			out.print("업로드 완료됨");
	}
}
