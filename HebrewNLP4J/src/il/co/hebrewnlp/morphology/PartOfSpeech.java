package il.co.hebrewnlp.morphology;

import java.io.Serializable;

/**
 * חלק דיבור
 */
public enum PartOfSpeech implements Serializable, Cloneable {
	
	/**
	 * אין
	 */
	NONE,
	
	/**
	 * פועל
	 */
	VERB,
	
	/**
	 * עצם
	 */
	NOUN,
	
	/**
	 * תואר
	 */
	ADJECTIVE,
	
	/**
	 * מיספר
	 */
	NUMBER,
	
	/**
	 * מילת יחס
	 */
	PREPOSITION,
	
	/**
	 * מילת גוף
	 */
	PRONOUN,
	
	/**
	 * מילת שאלה
	 */
	QUESTION_WORD,
	
	/**
	 * מילת חיבור
	 */
	CONJUNCTION,
	
	/**
	 * מילית
	 */
	PARTICLE,
	
	/**
	 * תואר הפועל
	 */
	ADVERB,
	
	/**
	 * פועל עזר
	 */
	MODAL,
	
	/**
	 * שם פרטי
	 */
	PROPER_NOUN,
	
}
