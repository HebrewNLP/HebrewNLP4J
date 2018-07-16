package il.co.hebrewnlp.preprocess;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import il.co.hebrewnlp.HebrewNLP;
import il.co.hebrewnlp.Util;

public class Tokenizer {
	
	public static final String PREPROCESS_TOKENIZER_ENDPOINT = "/service/preprocess/tokenizer";
    private static final Gson GSON = new GsonBuilder().create();

	private static class SentencerRequest {
    	@SuppressWarnings("unused")
		public String text;

    	@SuppressWarnings("unused")
		public String[] sentences;

    	@SuppressWarnings("unused")
		public String sentence;
    	
    	@SuppressWarnings("unused")
		public String token;
    }
    
    private static class MorphErrorResponse {
    	public String error;
    }
	
    public static String[][] tokenizeText(String text) throws Exception {
		if(HebrewNLP.getPassword() == null) {
    		throw new IllegalStateException("Please set HebrewNLP.setPassword() method with your password before using this method");
    	}
		SentencerRequest request = new SentencerRequest();
    	request.token = HebrewNLP.getPassword();
    	request.text = text;
    	String requestJson = GSON.toJson(request);
    	String responseJson = Util.postJSONData(PREPROCESS_TOKENIZER_ENDPOINT, requestJson);
    	if(responseJson.startsWith("{\"error\":")) {
    		throw new Exception(GSON.fromJson(responseJson, MorphErrorResponse.class).error);
    	}
    	return GSON.fromJson(responseJson, String[][].class);    	
	}
    
    public static String[][] tokenizeSentences(String[] sentences) throws Exception {
		if(HebrewNLP.getPassword() == null) {
    		throw new IllegalStateException("Please set HebrewNLP.setPassword() method with your password before using this method");
    	}
		SentencerRequest request = new SentencerRequest();
    	request.token = HebrewNLP.getPassword();
    	request.sentences = sentences;
    	String requestJson = GSON.toJson(request);
    	String responseJson = Util.postJSONData(PREPROCESS_TOKENIZER_ENDPOINT, requestJson);
    	if(responseJson.startsWith("{\"error\":")) {
    		throw new Exception(GSON.fromJson(responseJson, MorphErrorResponse.class).error);
    	}
    	return GSON.fromJson(responseJson, String[][].class);    	
	}
    
	public static String[] tokenizeSentence(String sentence) throws Exception {
		if(HebrewNLP.getPassword() == null) {
    		throw new IllegalStateException("Please set HebrewNLP.setPassword() method with your password before using this method");
    	}
		SentencerRequest request = new SentencerRequest();
    	request.token = HebrewNLP.getPassword();
    	request.sentence = sentence;
    	String requestJson = GSON.toJson(request);
    	String responseJson = Util.postJSONData(PREPROCESS_TOKENIZER_ENDPOINT, requestJson);
    	if(responseJson.startsWith("{\"error\":")) {
    		throw new Exception(GSON.fromJson(responseJson, MorphErrorResponse.class).error);
    	}
    	return GSON.fromJson(responseJson, String[].class);    	
	}
	
}
