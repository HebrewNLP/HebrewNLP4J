package il.co.hebrewnlp;

import java.io.Serializable;
import java.util.Collection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class NameTranslation {
	
	public static final String NAME_TRANSLATION_ENDPOINT = "/service/translation/names";
    private static final Gson GSON = new GsonBuilder().create();

    public enum Language implements Serializable, Cloneable {
    	
    	HEBREW,
    	
    }
    
	private static class TranslationRequest {
		@SuppressWarnings("unused")
		public Language type;
		
		@SuppressWarnings("unused")
		public int threshold;
		
    	@SuppressWarnings("unused")
		public String token;

    	@SuppressWarnings("unused")
		public String[] words;	
	}
    
    private static class ErrorResponse {
    	public String error;
    }
    
    public static String[] translate(Collection<String> names, Language language) throws Exception {
    	return translate(names.toArray(new String[names.size()]), language);
    }
    
    public static String[] translate(String[] names, Language language) throws Exception {
    	String[][] translated = translate(names, language, 1);
    	String[] options = new String[translated.length];
    	for(int i = 0; i < translated.length; i++) {
    		String[] optionsForWord = translated[i];
    		if(optionsForWord.length != 0) {    			
    			options[i] = optionsForWord[0];
    		}else {
    			options[i] = null;
    		}
    	}
    	return options;
    }
    
    public static String translate(String name, Language language) throws Exception {
    	String[] translated = translate(new String[] { name }, language, 1)[0];
    	if(translated.length != 0) {
    		return translated[0];
    	}else {
    		return null;
    	}
    }   
    
    public static String[][] translate(Collection<String> names, Language language, int threshold) throws Exception {
    	return translate(names.toArray(new String[names.size()]), language, threshold);
    }
    
    public static String[][] translate(String[] names, Language language, int threshold) throws Exception {
    	if(HebrewNLP.getPassword() == null) {
    		throw new IllegalStateException("Please set HebrewNLP.setPassword() method with your password before using this method. To get a password register at https://hebrew-nlp.co.il/registration.");
    	}
    	TranslationRequest request = new TranslationRequest();
    	request.token = HebrewNLP.getPassword();
    	request.threshold = threshold;
    	request.type = language;
    	request.words = names;
    	String requestJson = GSON.toJson(request);
    	String responseJson = Util.postJSONData(NAME_TRANSLATION_ENDPOINT, requestJson);
    	if(responseJson.startsWith("{\"error\":")) {
    		throw new Exception(GSON.fromJson(responseJson, ErrorResponse.class).error);
    	}
    	return GSON.fromJson(responseJson, String[][].class);
    }
    
    public static String[] translate(String name, Language language, int threshold) throws Exception {
    	return translate(new String[] { name }, language, threshold)[0];
    }
	
}
