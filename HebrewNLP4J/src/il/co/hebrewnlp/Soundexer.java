package il.co.hebrewnlp;

import java.util.Collection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Soundexer {
	
	public static final String SOUNDEX_ENDPOINT = "/service/soundex";
    private static final Gson GSON = new GsonBuilder().create();

	private static class SoundexRequest {
    	@SuppressWarnings("unused")
		public String token;

    	@SuppressWarnings("unused")
		public String[] words;	
	}
    
    private static class ErrorResponse {
    	public String error;
    }
    
    public static String[][] soundex(String[] words) throws Exception {
		if(HebrewNLP.getPassword() == null) {
    		throw new IllegalStateException("Please set HebrewNLP.setPassword() method with your password before using this method. To get a password register at https://hebrew-nlp.co.il/registration.");
    	}
		SoundexRequest request = new SoundexRequest();
    	request.token = HebrewNLP.getPassword();
    	request.words = words;
    	String requestJson = GSON.toJson(request);
    	String responseJson = Util.postJSONData(SOUNDEX_ENDPOINT, requestJson);
    	if(responseJson.startsWith("{\"error\":")) {
    		throw new Exception(GSON.fromJson(responseJson, ErrorResponse.class).error);
    	}
    	return GSON.fromJson(responseJson, String[][].class);
    }
    
    public static String[][] soundex(Collection<String> words) throws Exception {
    	return soundex(words.toArray(new String[words.size()]));
    }
	
}
