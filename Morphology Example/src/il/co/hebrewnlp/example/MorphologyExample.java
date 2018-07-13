package il.co.hebrewnlp.example;

import il.co.hebrewnlp.HebrewNLP;
import il.co.hebrewnlp.morphology.HebrewMorphology;
import il.co.hebrewnlp.morphology.MorphInfo;

public class MorphologyExample {

	public static void main(String[] args) throws Exception {
		HebrewNLP.setPassword("...");
		
		MorphInfo[] options = HebrewMorphology.analyzeWord("מילה");
		int i = 0;
		for(MorphInfo option : options) {
			System.out.println((i++) + ".");
			System.out.println(option.toString().replace(" [", ":\n").replace("]", "").replace(", ", ",\n"));
			System.out.println();
		}
	}

}
