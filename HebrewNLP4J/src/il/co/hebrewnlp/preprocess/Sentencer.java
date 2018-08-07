package il.co.hebrewnlp.preprocess;

import org.json.JSONArray;
import org.json.JSONObject;

import il.co.hebrewnlp.HebrewNLP;
import il.co.hebrewnlp.Util;

public class Sentencer {
	
	public static final String PREPROCESS_SENTENCER_ENDPOINT = "/service/preprocess/sentencer";
	
	public static String[] sentences(String text) throws Exception {
		if(HebrewNLP.getPassword() == null) {
    		throw new IllegalStateException("Please set HebrewNLP.setPassword() method with your password before using this method. To get a password register at https://hebrew-nlp.co.il/registration.");
    	}
		JSONObject request = new JSONObject();
    	request.put("token", HebrewNLP.getPassword());
    	request.put("text", text);
    	String requestJson = request.toString();
    	String responseJson = Util.postJSONData(PREPROCESS_SENTENCER_ENDPOINT, requestJson);
    	if(!responseJson.startsWith("[")) {
    		JSONObject object = new JSONObject(responseJson);
    		throw new Exception(object.optString("error", "Expected String[], got: " + object.toString()));
    	}
    	return Util.toStringArray(new JSONArray(responseJson));  	
	}
	
}
