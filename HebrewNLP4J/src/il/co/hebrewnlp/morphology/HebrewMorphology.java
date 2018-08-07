package il.co.hebrewnlp.morphology;

import java.io.Serializable;
import java.util.Collection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import il.co.hebrewnlp.HebrewNLP;
import il.co.hebrewnlp.Util;

public class HebrewMorphology {
	
	public static final String MORPH_NORMALIZE_ENDPOINT = "/service/morphology/normalize";
    public static final String MORPH_ANALYZE_ENDPOINT = "/service/morphology/analyze";
    private static final Gson GSON = new GsonBuilder().create();
	
    public enum NormalizationType implements Serializable, Cloneable {
    	SEARCH,
    	INDEX,
    }
    
    
    private static class MorphologyRequest {
    	
    	@SuppressWarnings("unused")
		public String token;

    	@SuppressWarnings("unused")
		public String[] words;
    	
    	@SuppressWarnings("unused")
		public String text;
    	
    	@SuppressWarnings("unused")
		public String sentence;
    	
    	@SuppressWarnings("unused")
		public String[] sentences;
    }
    
    private static class NormalizationRequest {
    	
    	@SuppressWarnings("unused")
		public String token;
    	
    	@SuppressWarnings("unused")
		public NormalizationType type;

    	@SuppressWarnings("unused")
		public String[] words;
    	
    	@SuppressWarnings("unused")
		public String text;
    	
    	@SuppressWarnings("unused")
		public String sentence;
    	
    	@SuppressWarnings("unused")
		public String[] sentences;
    }
    
    private static class MorphErrorResponse {
    	public String error;
    }
    
    /*----------------------------------------------------------------------------*/

    public static String[][] normalizeText(String text) throws Exception {
    	return normalizeText(text, NormalizationType.SEARCH);
    }
    
    public static String[][] normalizeText(String text, NormalizationType type) throws Exception {
    	if(HebrewNLP.getPassword() == null) {
    		throw new IllegalStateException("Please set HebrewNLP.setPassword() method with your password before using this method. To get a password register at https://hebrew-nlp.co.il/registration.");
    	}
    	NormalizationRequest request = new NormalizationRequest();
    	request.token = HebrewNLP.getPassword();
    	request.type = type;
    	request.text = text;
    	String requestJson = GSON.toJson(request);
    	String responseJson = Util.postJSONData(MORPH_NORMALIZE_ENDPOINT, requestJson);
    	if(responseJson.startsWith("{\"error\":")) {
    		throw new Exception(GSON.fromJson(responseJson, MorphErrorResponse.class).error);
    	}
    	return GSON.fromJson(responseJson, String[][].class);
    }
    
    public static String[][] normalizeSentences(Collection<String> sentences) throws Exception {
    	return normalizeSentences(sentences, NormalizationType.SEARCH);
    }
    
    public static String[][] normalizeSentences(Collection<String> sentences, NormalizationType type) throws Exception {
    	return normalizeSentences(sentences.toArray(new String[sentences.size()]), type);
    }

    public static String[][] normalizeSentences(String[] sentences) throws Exception {
    	return normalizeSentences(sentences, NormalizationType.SEARCH);
    }
    
    public static String[][] normalizeSentences(String[] sentences, NormalizationType type) throws Exception {
    	if(HebrewNLP.getPassword() == null) {
    		throw new IllegalStateException("Please set HebrewNLP.setPassword() method with your password before using this method. To get a password register at https://hebrew-nlp.co.il/registration.");
    	}
    	NormalizationRequest request = new NormalizationRequest();
    	request.token = HebrewNLP.getPassword();
    	request.type = type;
    	request.sentences = sentences;
    	String requestJson = GSON.toJson(request);
    	String responseJson = Util.postJSONData(MORPH_NORMALIZE_ENDPOINT, requestJson);
    	if(responseJson.startsWith("{\"error\":")) {
    		throw new Exception(GSON.fromJson(responseJson, MorphErrorResponse.class).error);
    	}
    	return GSON.fromJson(responseJson, String[][].class);
    }
    
    public static String[] normalizeSentence(String sentence) throws Exception {
    	return normalizeSentence(sentence, NormalizationType.SEARCH);
    }
    
    public static String[] normalizeSentence(String sentence, NormalizationType type) throws Exception {
    	if(HebrewNLP.getPassword() == null) {
    		throw new IllegalStateException("Please set HebrewNLP.setPassword() method with your password before using this method. To get a password register at https://hebrew-nlp.co.il/registration.");
    	}
    	NormalizationRequest request = new NormalizationRequest();
    	request.token = HebrewNLP.getPassword();
    	request.type = type;
    	request.sentence = sentence;
    	String requestJson = GSON.toJson(request);
    	String responseJson = Util.postJSONData(MORPH_NORMALIZE_ENDPOINT, requestJson);
    	if(responseJson.startsWith("{\"error\":")) {
    		throw new Exception(GSON.fromJson(responseJson, MorphErrorResponse.class).error);
    	}
    	return GSON.fromJson(responseJson, String[].class);
    }
    
    public static String[] normalizeWords(Collection<String> words) throws Exception {
    	return normalizeWords(words, NormalizationType.SEARCH);
    }
    
    public static String[] normalizeWords(Collection<String> words, NormalizationType type) throws Exception {
    	return normalizeWords(words.toArray(new String[words.size()]), type);
    }

    public static String[] normalizeWords(String[] words) throws Exception {
    	return normalizeWords(words, NormalizationType.SEARCH);
    }
    
    public static String[] normalizeWords(String[] words, NormalizationType type) throws Exception {
    	if(HebrewNLP.getPassword() == null) {
    		throw new IllegalStateException("Please set HebrewNLP.setPassword() method with your password before using this method. To get a password register at https://hebrew-nlp.co.il/registration.");
    	}
    	NormalizationRequest request = new NormalizationRequest();
    	request.token = HebrewNLP.getPassword();
    	request.type = type;
    	request.words = words;
    	String requestJson = GSON.toJson(request);
    	String responseJson = Util.postJSONData(MORPH_NORMALIZE_ENDPOINT, requestJson);
    	if(responseJson.startsWith("{\"error\":")) {
    		throw new Exception(GSON.fromJson(responseJson, MorphErrorResponse.class).error);
    	}
    	return GSON.fromJson(responseJson, String[].class);
    }

    public static String normalizeWord(String word) throws Exception {
    	return normalizeWord(word, NormalizationType.SEARCH);
    }
    
    public static String normalizeWord(String word, NormalizationType type) throws Exception {
    	return normalizeWords(new String[] { word }, type)[0];
    }
    
    /*----------------------------------------------------------------------------*/
    
    public static MorphInfo[][][] analyzeText(String text) throws Exception {
    	if(HebrewNLP.getPassword() == null) {
    		throw new IllegalStateException("Please set HebrewNLP.setPassword() method with your password before using this method. To get a password register at https://hebrew-nlp.co.il/registration.");
    	}
    	MorphologyRequest request = new MorphologyRequest();
    	request.token = HebrewNLP.getPassword();
    	request.text = text;
    	String requestJson = GSON.toJson(request);
    	String responseJson = Util.postJSONData(MORPH_ANALYZE_ENDPOINT, requestJson);
    	if(responseJson.startsWith("{\"error\":")) {
    		throw new Exception(GSON.fromJson(responseJson, MorphErrorResponse.class).error);
    	}
    	return GSON.fromJson(responseJson, MorphInfo[][][].class);
    }

    public static MorphInfo[][][] analyzeSentences(Collection<String> sentences) throws Exception {
    	return analyzeSentences(sentences.toArray(new String[sentences.size()]));
    }
    
    public static MorphInfo[][][] analyzeSentences(String[] sentences) throws Exception {
    	if(HebrewNLP.getPassword() == null) {
    		throw new IllegalStateException("Please set HebrewNLP.setPassword() method with your password before using this method. To get a password register at https://hebrew-nlp.co.il/registration.");
    	}
    	MorphologyRequest request = new MorphologyRequest();
    	request.token = HebrewNLP.getPassword();
    	request.sentences = sentences;
    	String requestJson = GSON.toJson(request);
    	String responseJson = Util.postJSONData(MORPH_ANALYZE_ENDPOINT, requestJson);
    	if(responseJson.startsWith("{\"error\":")) {
    		throw new Exception(GSON.fromJson(responseJson, MorphErrorResponse.class).error);
    	}
    	return GSON.fromJson(responseJson, MorphInfo[][][].class);
    }
    
    public static MorphInfo[][] analyzeSentence(String sentence) throws Exception {
    	if(HebrewNLP.getPassword() == null) {
    		throw new IllegalStateException("Please set HebrewNLP.setPassword() method with your password before using this method. To get a password register at https://hebrew-nlp.co.il/registration.");
    	}
    	MorphologyRequest request = new MorphologyRequest();
    	request.token = HebrewNLP.getPassword();
    	request.sentence = sentence;
    	String requestJson = GSON.toJson(request);
    	String responseJson = Util.postJSONData(MORPH_ANALYZE_ENDPOINT, requestJson);
    	if(responseJson.startsWith("{\"error\":")) {
    		throw new Exception(GSON.fromJson(responseJson, MorphErrorResponse.class).error);
    	}
    	return GSON.fromJson(responseJson, MorphInfo[][].class);
    }
    
    public static MorphInfo[][] analyzeWords(Collection<String> words) throws Exception {
    	return analyzeWords(words.toArray(new String[words.size()]));
    }
    
    public static MorphInfo[][] analyzeWords(String[] words) throws Exception {
    	if(HebrewNLP.getPassword() == null) {
    		throw new IllegalStateException("Please set HebrewNLP.setPassword() method with your password before using this method. To get a password register at https://hebrew-nlp.co.il/registration.");
    	}
    	MorphologyRequest request = new MorphologyRequest();
    	request.token = HebrewNLP.getPassword();
    	request.words = words;
    	String requestJson = GSON.toJson(request);
    	String responseJson = Util.postJSONData(MORPH_ANALYZE_ENDPOINT, requestJson);
    	if(responseJson.startsWith("{\"error\":")) {
    		throw new Exception(GSON.fromJson(responseJson, MorphErrorResponse.class).error);
    	}
    	return GSON.fromJson(responseJson, MorphInfo[][].class);
    }

    public static MorphInfo[] analyzeWord(String word) throws Exception {
    	return analyzeWords(new String[] { word })[0];
    }
    
    
}
