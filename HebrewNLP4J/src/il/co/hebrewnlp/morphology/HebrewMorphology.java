package il.co.hebrewnlp.morphology;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import il.co.hebrewnlp.HebrewNLP;
import il.co.hebrewnlp.Util;

public class HebrewMorphology {
	
	public static final String MORPH_NORMALIZE_ENDPOINT = "/service/morphology/normalize";
    public static final String MORPH_ANALYZE_ENDPOINT = "/service/morphology/analyze";
    private static final Gson GSON = new GsonBuilder().create();
	
    private static class MorphRequest {
    	@SuppressWarnings("unused")
		public String[] words;
    	
    	@SuppressWarnings("unused")
		public String token;
    }
    
    private static class MorphErrorResponse {
    	public String error;
    }
    
    public static String[] normalizeWords(String[] words) throws Exception {
    	if(HebrewNLP.getPassword() == null) {
    		throw new IllegalStateException("Please set HebrewNLP.setPassword() method with your password before using this method");
    	}
    	MorphRequest request = new MorphRequest();
    	request.token = HebrewNLP.getPassword();
    	request.words = words;
    	String requestJson = GSON.toJson(request);
    	String responseJson = Util.postJSONData(MORPH_NORMALIZE_ENDPOINT, requestJson);
    	if(responseJson.startsWith("{\"error\":")) {
    		throw new Exception(GSON.fromJson(responseJson, MorphErrorResponse.class).error);
    	}
    	return GSON.fromJson(responseJson, String[].class);    	
    }
    
    public static String[] normalizeWords(List<String> words) throws Exception {
    	return normalizeWords(words.toArray(new String[words.size()]));
    }
    
    public static String normalizeWord(String word) throws Exception {
    	return normalizeWords(new String[] { word })[0];
    }
    
    public static MorphInfo[][] analyzeWords(String[] words) throws Exception {
    	if(HebrewNLP.getPassword() == null) {
    		throw new IllegalStateException("Please set HebrewNLP.setPassword() method with your password before using this method");
    	}
    	MorphRequest request = new MorphRequest();
    	request.token = HebrewNLP.getPassword();
    	request.words = words;
    	String requestJson = GSON.toJson(request);
    	String responseJson = Util.postJSONData(MORPH_ANALYZE_ENDPOINT, requestJson);
    	if(responseJson.startsWith("{\"error\":")) {
    		throw new Exception(GSON.fromJson(responseJson, MorphErrorResponse.class).error);
    	}
    	return GSON.fromJson(responseJson, MorphInfo[][].class);
    }
    
    public static MorphInfo[][] analyzeWords(List<String> words) throws Exception {
    	return analyzeWords(words.toArray(new String[words.size()]));
    }
    
    public static MorphInfo[] analyzeWord(String word) throws Exception {
    	return analyzeWords(new String[] { word })[0];
    }
    
    
}
