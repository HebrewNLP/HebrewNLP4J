package il.co.hebrewnlp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.ws.http.HTTPException;

import org.json.JSONArray;
import org.json.JSONObject;

import il.co.hebrewnlp.morphology.MorphInfo;

public class HttpUtils {
	
	public static final String API_DOMAIN = "https://hebrew-nlp.co.il";
	
	public static String postJSONData(String url, String data) throws IOException {
		URL obj = new URL(API_DOMAIN + url);
		HttpURLConnection con = (HttpURLConnection)obj.openConnection();
		con.setDoOutput(true);
		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "application/json; encoding='utf-8'");
		con.setRequestProperty("Content-Length", Integer.toString(data.getBytes().length));
		con.getOutputStream().write(data.getBytes());
		
		int responseCode = con.getResponseCode();
		if(responseCode == HttpURLConnection.HTTP_OK) {
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			return response.toString();
		}else {
			throw new HTTPException(responseCode);
		}
	}
	
	public static String[] toStringArray(JSONArray array) {
		String[] arr = new String[array.length()];
		int i = 0;
		for(Object obj : array) {
			arr[i++] = obj.toString();
		}
		return arr;
	}
	
	public static String[][] toDoubleStringArray(JSONArray array) {
		String[][] arr = new String[array.length()][];
		int i = 0;
		for(Object obj : array) {
			if(obj instanceof JSONArray) {
				arr[i++] = toStringArray((JSONArray)obj);
			}else {
				throw new IllegalStateException("Expected JSONArray got " + obj.getClass());
			}
		}
		return arr;
	}
	
	public static MorphInfo[] toMorphInfoArray(JSONArray array) {
		MorphInfo[] arr = new MorphInfo[array.length()];
		int i = 0;
		for(Object obj : array) {
			if(obj instanceof JSONObject) {
				arr[i++] = MorphInfo.fromJson((JSONObject)obj);				
			}else {
				throw new IllegalStateException("Expected JSONObject got " + obj.getClass());
			}
		}
		return arr;
	}
	
	public static MorphInfo[][] toDoubleMorphInfoArray(JSONArray array) {
		MorphInfo[][] arr = new MorphInfo[array.length()][];
		int i = 0;
		for(Object obj : array) {
			if(obj instanceof JSONArray) {
				arr[i++] = toMorphInfoArray((JSONArray)obj);
			}else {
				throw new IllegalStateException("Expected JSONArray got " + obj.getClass());
			}
		}
		return arr;
	}
	
	public static MorphInfo[][][] toTrippleMorphInfoArray(JSONArray array) {
		MorphInfo[][][] arr = new MorphInfo[array.length()][][];
		int i = 0;
		for(Object obj : array) {
			if(obj instanceof JSONArray) {
				arr[i++] = toDoubleMorphInfoArray((JSONArray)obj);
			}else {
				throw new IllegalStateException("Expected JSONArray got " + obj.getClass());
			}
		}
		return arr;
	}
	
}
