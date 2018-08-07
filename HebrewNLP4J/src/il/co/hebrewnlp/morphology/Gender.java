package il.co.hebrewnlp.morphology;

import java.io.Serializable;

/**
 *  מין
 */
public enum Gender implements Serializable, Cloneable {
	
	/**
	 * שניהם
	 */
	BOTH,
	
	/**
	 * אף אחד
	 */
	NONE,
	
	/**
	 * זכר
	 */
	MALE,
	
	/**
	 * נקבה
	 */
	FEMALE	
}
