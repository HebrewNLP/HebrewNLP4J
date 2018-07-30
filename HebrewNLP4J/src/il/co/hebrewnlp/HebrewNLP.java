package il.co.hebrewnlp;

public final class HebrewNLP {
	
	private HebrewNLP() {
	}
	
	private static String password;
	
	public static String getPassword() {
		return password;
	}
	
	/**
	 * 
	 * To get a password register at https://hebrew-nlp.co.il/registration.
	 * 
	 * @param password your password
	 */
	public static void setPassword(String password) {
		HebrewNLP.password = password;
	}
	
}
