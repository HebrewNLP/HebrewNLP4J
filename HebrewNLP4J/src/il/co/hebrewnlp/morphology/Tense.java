package il.co.hebrewnlp.morphology;

import java.io.Serializable;

/**
 * זמן
 */
public enum Tense implements Serializable, Cloneable {
	
	/**
	 * אין
	 */
    NONE,

	/**
	 * עבר
	 */
    PAST,

	/**
	 * הווה
	 */
    PRESENT,

	/**
	 * עתיד
	 */
    FUTURE,

	/**
	 * הווה סביל (פעול)
	 */
    PRESENT_PASSIVE,

	/**
	 * ציווי
	 */
    IMPERATIVE,

	/**
	 * מקור
	 */
    INFINITIVE
	
	
}
