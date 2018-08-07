package il.co.hebrewnlp;

import java.util.Collection;

import org.json.JSONArray;
import org.json.JSONObject;

public class Soundexer {
	
	public static final String SOUNDEX_ENDPOINT = "/service/soundex";

	public static String[][] soundex(String[] words) throws Exception {
		if(HebrewNLP.getPassword() == null) {
    		throw new IllegalStateException("Please set HebrewNLP.setPassword() method with your password before using this method. To get a password register at https://hebrew-nlp.co.il/registration.");
    	}
		JSONObject request = new JSONObject();
    	request.put("token", HebrewNLP.getPassword());
    	request.put("words", words);
    	String requestJson = request.toString();
    	String responseJson = Util.postJSONData(SOUNDEX_ENDPOINT, requestJson);
    	if(!responseJson.startsWith("[")) {
    		JSONObject object = new JSONObject(responseJson);
    		throw new Exception(object.optString("error", "Expected String[][], got: " + object.toString()));
    	}
    	return Util.toDoubleStringArray(new JSONArray(responseJson));
    }
    
    public static String[][] soundex(Collection<String> words) throws Exception {
    	return soundex(words.toArray(new String[words.size()]));
    }
	
}
