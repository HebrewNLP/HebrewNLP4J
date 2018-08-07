package il.co.hebrewnlp.example;

import il.co.hebrewnlp.HebrewNLP;
import il.co.hebrewnlp.morphology.HebrewMorphology;
import il.co.hebrewnlp.morphology.HebrewMorphology.NormalizationType;

public class NormalizeExample {

	public static void main(String[] args) throws Exception {
		HebrewNLP.setPassword("...");
		
		String[] options = HebrewMorphology.normalizeSentence("הילד שהלך לפרק ישב", NormalizationType.INDEX);

		for(String option : options) {
			System.out.println(option);
		}
	}

}
