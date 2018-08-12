package il.co.hebrewnlp.names;

import java.util.Collection;

import org.json.JSONArray;
import org.json.JSONObject;

import il.co.hebrewnlp.HebrewNLP;
import il.co.hebrewnlp.HttpUtils;

public class NameAnalyzer {
	
	public static final String NAME_TRANSLATION_ENDPOINT = "/service/names/analyze";
    
    public static NameInfo[] analyze(Collection<String> names) throws Exception {
    	return analyze(names.toArray(new String[names.size()]));
    }
    
    public static NameInfo[] analyze(String[] names) throws Exception {
    	if(HebrewNLP.getPassword() == null) {
    		throw new IllegalStateException("Please set HebrewNLP.setPassword() method with your password before using this method. To get a password register at https://hebrew-nlp.co.il/registration.");
    	}
    	JSONObject request = new JSONObject();
    	request.put("token", HebrewNLP.getPassword());
    	request.put("names", names);
    	String requestJson = request.toString();
    	String responseJson = HttpUtils.postJSONData(NAME_TRANSLATION_ENDPOINT, requestJson);
    	if(!responseJson.startsWith("[")) {
    		JSONObject object = new JSONObject(responseJson);
    		throw new Exception(object.optString("error", "Expected NameInfo[], got: " + object.toString()));
    	}
    	return HttpUtils.toNameInfoArray(new JSONArray(responseJson));
    }
    
    public static NameInfo translate(String name) throws Exception {
    	return analyze(new String[] { name })[0];
    }
	
}
