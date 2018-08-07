package il.co.hebrewnlp.example;

import il.co.hebrewnlp.HebrewNLP;
import il.co.hebrewnlp.Soundexer;

public class SentencerExample {

	public static boolean contains(String[] array, String word) {
		for(String str : array) {
			if(word.equals(str)) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) throws Exception {
		HebrewNLP.setPassword("...");

        String[] words = new String[] { "itay", "איתי" };
        String[][] phoneticCodes = Soundexer.soundex(words);
        boolean found = false;
        String code = null;
        System.out.println(words[0] + ":");
        for (String str : phoneticCodes[0])
        {
        	System.out.println("\t" + str);
            if(contains(phoneticCodes[1], str))
            {
                found = true;
                code = str;
                break;
            }
        }

        System.out.println(words[1] + ":");
        for (String str : phoneticCodes[1])
        {
        	System.out.println("\t" + str);
        }

        System.out.println();

        if (found)
        {
        	System.out.println("words are probably the same (" + code + ")");
        }else
        {
        	System.out.println("words are probably different");
        }
	}

}
