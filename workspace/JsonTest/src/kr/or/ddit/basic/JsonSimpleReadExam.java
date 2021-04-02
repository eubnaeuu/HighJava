package kr.or.ddit.basic;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * 공공데이터 포털의 OPEN API 예제
 * (레시피 재료정보 가져오는 예제)
 * @author macween
 *
 */
public class JsonSimpleReadExam {
	private String svcKey = "Grid_20150827000000000227_1";  // 레시피 재료 정보 조회 서비스
	private String apiKey = "1df7e8571e8df3f8cbc9b87691ca7d3e4d04f03c593d477e52bf67b03f0b6e1c"; // 개인별 발급.
	private String startIdx = "1";  	// 레시피 재료 시작 순번    //사이트에서 이렇게 시작과 끝 인덱스 입력하게끔 만들었음?
	private String endIdx = "5";		// 레시피 재료 종료 순번 // default로 5를 넣어서 실행하고 거기서 totalCnt를 따옴. 그래서 이를 이용하여 다시 출력함(59-66line)
	private String recipeId = "195428";	// 래시피가 궁금한 음식 ID

	/**
	 * JSON
	 * @return
	 * @throws IOException
	 * @throws ParseException
	 */
	private JSONObject getJSONObject() throws IOException, ParseException {
		URL url = new URL("http://211.237.50.150:7080/openapi/"+ apiKey
				+ "/json/"+ svcKey + "/"+startIdx +"/" + endIdx
				+"?RECIPE_ID=" +  recipeId);
		URLConnection urlConnection = url.openConnection();

		JSONParser parser = new JSONParser();

		Object obj = parser.parse(new InputStreamReader(urlConnection.getInputStream()));

		return (JSONObject)obj;
	}

	/**
	 * 시작
	 * @throws IOException
	 * @throws ParseException
	 */
	public void start() throws IOException, ParseException {


		JSONObject jsonfile = getJSONObject();

		JSONObject rootObj = (JSONObject) jsonfile.get(svcKey);

		long totalCnt = (long)rootObj.get("totalCnt"); // 전체 레시피 재료 수

		endIdx = totalCnt + ""; // 레시피 재료 마지막 순번 설정
		//-----------------------------------------------------------------------
		// 구해온 전체 재료수를 이용하여 다시 요청함.


		jsonfile = getJSONObject();

		rootObj = (JSONObject) jsonfile.get(svcKey);

		JSONObject result = (JSONObject)rootObj.get("result");
		String code = (String)result.get("code");

		if(code.equals("INFO-000")) { // 정상 상태이면... (정상이면 INFO-000 던진다고함)

			JSONArray list = (JSONArray)rootObj.get("row");

//			for(Object tempObj : list) {
//
//				JSONObject tempJson = (JSONObject) tempObj;
//
//				System.out.println("순번 : " + tempJson.get("ROW_NUM"));
//				System.out.println("레시피ID : " + tempJson.get("RECIPE_ID"));
//				System.out.println("재료명 : " + tempJson.get("IRDNT_NM"));
//				System.out.println("용량 : " + tempJson.get("IRDNT_CPCTY"));
//				System.out.println("재료구분 : " + tempJson.get("IRDNT_TY_NM"));
//
//				System.out.println("-------------------------");
//			}


			@SuppressWarnings("unchecked")
			Iterator<JSONObject> it = list.iterator();

			while(it.hasNext()){

				JSONObject tempJson = it.next();

				System.out.println("순번 : " + tempJson.get("ROW_NUM"));
				System.out.println("레시피ID : " + tempJson.get("RECIPE_ID"));
				System.out.println("재료명 : " + tempJson.get("IRDNT_NM"));
				System.out.println("용량 : " + tempJson.get("IRDNT_CPCTY"));
				System.out.println("재료구분 : " + tempJson.get("IRDNT_TY_NM"));

				System.out.println("-------------------------");
			}
		}
	}

	public static void main(String[] args) throws IOException, ParseException {
		new JsonSimpleReadExam().start();
	}
}
