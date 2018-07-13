package il.co.hebrewnlp.morphology;

import java.io.Serializable;

/**
 * גוף
 */
public enum Person implements Serializable, Cloneable {
	
	/**
	 * אין
	 */
	NONE,
	
	/**
	 * כל האפשרויות
	 */
	ALL,
	
	/**
	 * גוף ראשון
	 */
	FIRST_PERSON,
	
	/**
	 * גוף שני
	 */
	SECOND_PERSON,
	
	/**
	 * גוף שלישי
	 */
	THIRD_PERSON,
	
}
