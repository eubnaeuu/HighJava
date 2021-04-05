package kr.or.ddit.basic;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonSimpleRead_HW {

	private String svcKey ="Ee6PerfZMkzruLEP%2Fe8ZV76lRwME%2BxW00Gwmr8CVUZv7Sv%2F3E6rki3kB5o%2BP%2F6hqStpsdW%2FAKvNraqXsKbfdnw%3D%3D"; 
//	private String apiKey="";
	private String pageNo = "1";
	private String numOfRows = "10";
	private String toilet_nm = "";
	
	
	
	private JSONObject getJSONObject() throws IOException, ParseException{
		URL url = new URL("http://apis.data.go.kr/3660000/PublicToiletListService/getPublicToiletList?"
				+"serviceKey="+ svcKey
				+""+pageNo + "\n"
				+""+numOfRows + ""
				+""+toilet_nm);
		
		// http://apis.data.go.kr/3660000/PublicToiletListService/getPublicToiletList?
		//serviceKey=
		//&pageNo=1
		//&numOfRows=10
		//&toilet_nm=%EB%92%A4%EB%9C%B0%EC%96%B4%EB%A6%B0%EC%9D%B4%EA%B3%B5%EC%9B%90
		
		URLConnection urlcon = url.openConnection();
		
		JSONParser parser = new JSONParser();
		
		Object obj = parser.parse(new InputStreamReader(urlcon.getInputStream()));
		
		
		return (JSONObject)obj;
	}
}
