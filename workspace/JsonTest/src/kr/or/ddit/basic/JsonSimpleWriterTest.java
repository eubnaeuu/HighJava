package kr.or.ddit.basic;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * JSON : JavaScript Object Notation
 * 
 * - JSON 에서 value값으로 가능한 데이터 타입
 * 
 * 1. string 
 * 2. number 
 * 3. Object(JSON object) 
 * 4. array 
 * 5. boolean 
 * 6. null
 * 
 * @author PC-09
 */
public class JsonSimpleWriterTest {
	public static void main(String[] args) throws IOException {
			// JSON 데이터 설정
		JSONObject jsonObj = new JSONObject();
		
		jsonObj.put("name", "홍홍홍");
		jsonObj.put("job", "학생");
		jsonObj.put("age", 30);
		jsonObj.put("addr", "대전시 중구 대흥동 대덕인재개발원");
		
		// JSONArray 데이터 설정
		JSONArray singerList = new JSONArray();
		
		JSONObject singer = new JSONObject();
		singer.put("name", "싸이");
		singer.put("gender", "남자");
		singer.put("age", 22);
		singerList.add(singer);
		
		singer = new JSONObject();
		singer.put("name", "비욘세");
		singer.put("gender", "여자");
		singer.put("age", 32);
		singerList.add(singer);
		
		singer = new JSONObject();
		singer.put("name", "BTS");
		singer.put("gender", false);
		singer.put("age", 25);
		singerList.add(singer);
		
		jsonObj.put("singerList", singerList);
		
		FileWriter fw = new FileWriter("d:/D_Other/myJsonFile.txt");
		fw.write(jsonObj.toString());
		fw.flush();
		fw.close();
		System.out.println("JSON객체 내용 출력 : " + jsonObj);
	

		// Json Object 형식으로 출력됨.
		
	}
}
