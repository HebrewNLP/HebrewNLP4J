package il.co.hebrewnlp;

public final class HebrewNLP {
	
	private HebrewNLP() {
	}
	
	private static String password;
	
	public static String getPassword() {
		return password;
	}
	
	public static void setPassword(String password) {
		HebrewNLP.password = password;
	}
	
}
