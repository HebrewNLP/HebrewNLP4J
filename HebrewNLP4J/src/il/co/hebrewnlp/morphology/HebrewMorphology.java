package il.co.hebrewnlp.morphology;

import java.io.Serializable;
import java.util.Collection;

import org.json.JSONArray;
import org.json.JSONObject;

import il.co.hebrewnlp.HebrewNLP;
import il.co.hebrewnlp.HttpUtils;

public class HebrewMorphology {
	
	public static final String MORPH_NORMALIZE_ENDPOINT = "/service/morphology/normalize";
    public static final String MORPH_ANALYZE_ENDPOINT = "/service/morphology/analyze";
	
    public enum NormalizationType implements Serializable, Cloneable {
    	SEARCH,
    	INDEX,
    }
    
    public static String[][] normalizeText(String text) throws Exception {
    	return normalizeText(text, NormalizationType.SEARCH);
    }
    
    public static String[][] normalizeText(String text, NormalizationType type) throws Exception {
    	if(HebrewNLP.getPassword() == null) {
    		throw new IllegalStateException("Please set HebrewNLP.setPassword() method with your password before using this method. To get a password register at https://hebrew-nlp.co.il/registration.");
    	}
    	JSONObject request = new JSONObject();
    	request.put("token", HebrewNLP.getPassword());
    	request.put("type", type);
		request.put("text", text);
    	String requestJson = request.toString();
    	String responseJson = HttpUtils.postJSONData(MORPH_NORMALIZE_ENDPOINT, requestJson);
    	if(!responseJson.startsWith("[")) {
    		JSONObject object = new JSONObject(responseJson);
    		throw new Exception(object.optString("error", "Expected String[][], got: " + object.toString()));
    	}
    	return HttpUtils.toDoubleStringArray(new JSONArray(responseJson));
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
    	JSONObject request = new JSONObject();
    	request.put("token", HebrewNLP.getPassword());
		request.put("type", type);
		request.put("sentences", sentences);
    	String requestJson = request.toString();
    	String responseJson = HttpUtils.postJSONData(MORPH_NORMALIZE_ENDPOINT, requestJson);
    	if(!responseJson.startsWith("[")) {
    		JSONObject object = new JSONObject(responseJson);
    		throw new Exception(object.optString("error", "Expected String[][], got: " + object.toString()));
    	}
    	return HttpUtils.toDoubleStringArray(new JSONArray(responseJson));
    }
    
    public static String[] normalizeSentence(String sentence) throws Exception {
    	return normalizeSentence(sentence, NormalizationType.SEARCH);
    }
    
    public static String[] normalizeSentence(String sentence, NormalizationType type) throws Exception {
    	if(HebrewNLP.getPassword() == null) {
    		throw new IllegalStateException("Please set HebrewNLP.setPassword() method with your password before using this method. To get a password register at https://hebrew-nlp.co.il/registration.");
    	}
    	JSONObject request = new JSONObject();
    	request.put("token", HebrewNLP.getPassword());
		request.put("type", type);
		request.put("sentence", sentence);
    	String requestJson = request.toString();
    	String responseJson = HttpUtils.postJSONData(MORPH_NORMALIZE_ENDPOINT, requestJson);
    	if(!responseJson.startsWith("[")) {
    		JSONObject object = new JSONObject(responseJson);
    		throw new Exception(object.optString("error", "Expected String[], got: " + object.toString()));
    	}
    	return HttpUtils.toStringArray(new JSONArray(responseJson));
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
    	JSONObject request = new JSONObject();
    	request.put("token", HebrewNLP.getPassword());
    	request.put("type", type);
    	request.put("words", words);
    	String requestJson = request.toString();
    	String responseJson = HttpUtils.postJSONData(MORPH_NORMALIZE_ENDPOINT, requestJson);
    	if(!responseJson.startsWith("[")) {
    		JSONObject object = new JSONObject(responseJson);
    		throw new Exception(object.optString("error", "Expected String[], got: " + object.toString()));
    	}
    	return HttpUtils.toStringArray(new JSONArray(responseJson));
    }

    public static String normalizeWord(String word) throws Exception {
    	return normalizeWord(word, NormalizationType.SEARCH)[0];
    }
    
    public static String[] normalizeWord(String word, NormalizationType type) throws Exception {
    	return normalizeWords(new String[] { word }, type);
    }
    
    /*----------------------------------------------------------------------------*/
    
    public static MorphInfo[][][] analyzeText(String text) throws Exception {
    	if(HebrewNLP.getPassword() == null) {
    		throw new IllegalStateException("Please set HebrewNLP.setPassword() method with your password before using this method. To get a password register at https://hebrew-nlp.co.il/registration.");
    	}
    	JSONObject request = new JSONObject();
    	request.put("token", HebrewNLP.getPassword());
    	request.put("text", text);
    	String requestJson = request.toString();
    	String responseJson = HttpUtils.postJSONData(MORPH_ANALYZE_ENDPOINT, requestJson);
    	if(!responseJson.startsWith("[")) {
    		JSONObject object = new JSONObject(responseJson);
    		throw new Exception(object.optString("error", "Expected MorphInfo[][][], got: " + object.toString()));
    	}
    	return HttpUtils.toTrippleMorphInfoArray(new JSONArray(responseJson));
    }

    public static MorphInfo[][][] analyzeSentences(Collection<String> sentences) throws Exception {
    	return analyzeSentences(sentences.toArray(new String[sentences.size()]));
    }
    
    public static MorphInfo[][][] analyzeSentences(String[] sentences) throws Exception {
    	if(HebrewNLP.getPassword() == null) {
    		throw new IllegalStateException("Please set HebrewNLP.setPassword() method with your password before using this method. To get a password register at https://hebrew-nlp.co.il/registration.");
    	}
    	JSONObject request = new JSONObject();
    	request.put("token", HebrewNLP.getPassword());
    	request.put("sentences", sentences);
    	String requestJson = request.toString();
    	String responseJson = HttpUtils.postJSONData(MORPH_ANALYZE_ENDPOINT, requestJson);
    	if(!responseJson.startsWith("[")) {
    		JSONObject object = new JSONObject(responseJson);
    		throw new Exception(object.optString("error", "Expected MorphInfo[][][], got: " + object.toString()));
    	}
    	return HttpUtils.toTrippleMorphInfoArray(new JSONArray(responseJson));
    }
    
    public static MorphInfo[][] analyzeSentence(String sentence) throws Exception {
    	if(HebrewNLP.getPassword() == null) {
    		throw new IllegalStateException("Please set HebrewNLP.setPassword() method with your password before using this method. To get a password register at https://hebrew-nlp.co.il/registration.");
    	}
    	JSONObject request = new JSONObject();
    	request.put("token", HebrewNLP.getPassword());
    	request.put("sentence", sentence);
    	String requestJson = request.toString();
    	String responseJson = HttpUtils.postJSONData(MORPH_ANALYZE_ENDPOINT, requestJson);
    	if(!responseJson.startsWith("[")) {
    		JSONObject object = new JSONObject(responseJson);
    		throw new Exception(object.optString("error", "Expected MorphInfo[][], got: " + object.toString()));
    	}
    	return HttpUtils.toDoubleMorphInfoArray(new JSONArray(responseJson));
    }
    
    public static MorphInfo[][] analyzeWords(Collection<String> words) throws Exception {
    	return analyzeWords(words.toArray(new String[words.size()]));
    }
    
    public static MorphInfo[][] analyzeWords(String[] words) throws Exception {
    	if(HebrewNLP.getPassword() == null) {
    		throw new IllegalStateException("Please set HebrewNLP.setPassword() method with your password before using this method. To get a password register at https://hebrew-nlp.co.il/registration.");
    	}
    	JSONObject request = new JSONObject();
    	request.put("token", HebrewNLP.getPassword());
    	request.put("words", words);
    	String requestJson = request.toString();
    	String responseJson = HttpUtils.postJSONData(MORPH_ANALYZE_ENDPOINT, requestJson);
    	if(!responseJson.startsWith("[")) {
    		JSONObject object = new JSONObject(responseJson);
    		throw new Exception(object.optString("error", "Expected MorphInfo[][], got: " + object.toString()));
    	}
    	return HttpUtils.toDoubleMorphInfoArray(new JSONArray(responseJson));
    }

    public static MorphInfo[] analyzeWord(String word) throws Exception {
    	return analyzeWords(new String[] { word })[0];
    }
    
    
}
