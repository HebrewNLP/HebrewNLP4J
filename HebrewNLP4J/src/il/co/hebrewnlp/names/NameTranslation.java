package il.co.hebrewnlp.names;

import java.io.Serializable;
import java.util.Collection;

import org.json.JSONArray;
import org.json.JSONObject;

import il.co.hebrewnlp.HebrewNLP;
import il.co.hebrewnlp.HttpUtils;

public class NameTranslation {
	
	public static final String NAME_TRANSLATION_ENDPOINT = "/service/names/translation";

    public enum Language implements Serializable, Cloneable {
    	HEBREW,
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
    	JSONObject request = new JSONObject();
    	request.put("token", HebrewNLP.getPassword());
    	request.put("threshold", threshold);
    	request.put("type", language);
    	request.put("words", names);
    	String requestJson = request.toString();
    	String responseJson = HttpUtils.postJSONData(NAME_TRANSLATION_ENDPOINT, requestJson);
    	if(!responseJson.startsWith("[")) {
    		JSONObject object = new JSONObject(responseJson);
    		throw new Exception(object.optString("error", "Expected String[][], got: " + object.toString()));
    	}
    	return HttpUtils.toDoubleStringArray(new JSONArray(responseJson));
    }
    
    public static String[] translate(String name, Language language, int threshold) throws Exception {
    	return translate(new String[] { name }, language, threshold)[0];
    }
	
}
