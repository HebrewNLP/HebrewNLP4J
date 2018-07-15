package il.co.hebrewnlp.example;

import il.co.hebrewnlp.HebrewNLP;
import il.co.hebrewnlp.preprocess.Sentencer;

public class SentencerExample {

	public static void main(String[] args) throws Exception {
		HebrewNLP.setPassword("...");
		
		String[] sentences = Sentencer.sentences("התשובה הקצרה - כי אין תשתית כזו זמינה כיום. התשובה המלאה יותר - כקבוצה של מתכנתים העוסקים בתחום נאלצנו תמיד ללכת בדרך הקשה כשבאנו לפתח מוצרים הדורשים ניתוח שפה בעברית. וכך נוצר שיתוף הפעולה בעזרתו אנו בונים את השרותים והתשתיות. הציבור הישראלי תמיד סובל ממוצרים נחותים כשמגיעים ליכולות עיבוד שפה טבעית, למעט כמה יוצאי דופן הטכנולוגיה כמעט לא נגישה בעברית אם זה בגלל תמחור גבוהה, ואם מפני שהטכנולוגיה היא בשימוש פנימי בלבד.");
		
		for(String sentence : sentences) {
			System.out.println(sentence);
		}
	}

}
