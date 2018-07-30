package il.co.hebrewnlp.preprocess;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import il.co.hebrewnlp.HebrewNLP;
import il.co.hebrewnlp.Util;

public class Sentencer {
	
	public static final String PREPROCESS_SENTENCER_ENDPOINT = "/service/preprocess/sentencer";
    private static final Gson GSON = new GsonBuilder().create();

	private static class SentencerRequest {
    	@SuppressWarnings("unused")
		public String text;
    	
    	@SuppressWarnings("unused")
		public String token;
    }
    
    private static class MorphErrorResponse {
    	public String error;
    }
	
	public static String[] sentences(String text) throws Exception {
		if(HebrewNLP.getPassword() == null) {
    		throw new IllegalStateException("Please set HebrewNLP.setPassword() method with your password before using this method. To get a password register at https://hebrew-nlp.co.il/registration.");
    	}
		SentencerRequest request = new SentencerRequest();
    	request.token = HebrewNLP.getPassword();
    	request.text = text;
    	String requestJson = GSON.toJson(request);
    	String responseJson = Util.postJSONData(PREPROCESS_SENTENCER_ENDPOINT, requestJson);
    	if(responseJson.startsWith("{\"error\":")) {
    		throw new Exception(GSON.fromJson(responseJson, MorphErrorResponse.class).error);
    	}
    	return GSON.fromJson(responseJson, String[].class);    	
	}
	
}
