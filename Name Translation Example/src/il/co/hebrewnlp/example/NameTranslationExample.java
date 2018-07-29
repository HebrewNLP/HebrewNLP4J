package il.co.hebrewnlp.example;

import il.co.hebrewnlp.HebrewNLP;
import il.co.hebrewnlp.NameTranslation;
import il.co.hebrewnlp.NameTranslation.Language;

public class NameTranslationExample {

	public static void main(String[] args) throws Exception {
		HebrewNLP.setPassword("...");

		String[] options = NameTranslation.translate(new String[] { "haim", "haym" } , Language.HEBREW);

		for(String option : options) {
			System.out.println(option);
		}
	}

}
