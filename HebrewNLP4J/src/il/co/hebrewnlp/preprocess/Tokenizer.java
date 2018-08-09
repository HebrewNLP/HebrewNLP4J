package il.co.hebrewnlp.preprocess;

import java.util.Collection;

import org.json.JSONArray;
import org.json.JSONObject;

import il.co.hebrewnlp.HebrewNLP;
import il.co.hebrewnlp.HttpUtils;

public class Tokenizer {
	
	public static final String PREPROCESS_TOKENIZER_ENDPOINT = "/service/preprocess/tokenizer";

    public static String[][] tokenizeText(String text) throws Exception {
		if(HebrewNLP.getPassword() == null) {
    		throw new IllegalStateException("Please set HebrewNLP.setPassword() method with your password before using this method. To get a password register at https://hebrew-nlp.co.il/registration.");
    	}
		JSONObject request = new JSONObject();
    	request.put("token", HebrewNLP.getPassword());
    	request.put("text", text);
    	String requestJson = request.toString();
    	String responseJson = HttpUtils.postJSONData(PREPROCESS_TOKENIZER_ENDPOINT, requestJson);
    	if(!responseJson.startsWith("[")) {
    		JSONObject object = new JSONObject(responseJson);
    		throw new Exception(object.optString("error", "Expected String[][], got: " + object.toString()));
    	}
    	return HttpUtils.toDoubleStringArray(new JSONArray(responseJson));
	}
    
    public static String[][] tokenizeSentences(Collection<String> sentences) throws Exception {
    	return tokenizeSentences(sentences.toArray(new String[sentences.size()]));
    }
    
    public static String[][] tokenizeSentences(String[] sentences) throws Exception {
		if(HebrewNLP.getPassword() == null) {
    		throw new IllegalStateException("Please set HebrewNLP.setPassword() method with your password before using this method. To get a password register at https://hebrew-nlp.co.il/registration.");
    	}
		JSONObject request = new JSONObject();
    	request.put("token", HebrewNLP.getPassword());
    	request.put("sentences", sentences);
    	String requestJson = request.toString();
    	String responseJson = HttpUtils.postJSONData(PREPROCESS_TOKENIZER_ENDPOINT, requestJson);
    	if(!responseJson.startsWith("[")) {
    		JSONObject object = new JSONObject(responseJson);
    		throw new Exception(object.optString("error", "Expected String[][], got: " + object.toString()));
    	}
    	return HttpUtils.toDoubleStringArray(new JSONArray(responseJson)); 	
	}
    
	public static String[] tokenizeSentence(String sentence) throws Exception {
		if(HebrewNLP.getPassword() == null) {
    		throw new IllegalStateException("Please set HebrewNLP.setPassword() method with your password before using this method. To get a password register at https://hebrew-nlp.co.il/registration.");
    	}
		JSONObject request = new JSONObject();
    	request.put("token", HebrewNLP.getPassword());
    	request.put("sentence", sentence);
    	String requestJson = request.toString();
    	String responseJson = HttpUtils.postJSONData(PREPROCESS_TOKENIZER_ENDPOINT, requestJson);
    	if(!responseJson.startsWith("[")) {
    		JSONObject object = new JSONObject(responseJson);
    		throw new Exception(object.optString("error", "Expected String[], got: " + object.toString()));
    	}
    	return HttpUtils.toStringArray(new JSONArray(responseJson));
	}
	
}
