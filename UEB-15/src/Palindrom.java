/**
 * Palindrom abstract parent class for testing Palindroms
 * @author marie-louwechsler/ Quentin Duflot
 * @version 1.0
 */

public abstract class Palindrom {
	/**
	 * isPalindrom test if a string is a palindrom
	 * @param String testValue
	 * @return boolean 
	 */
	public abstract boolean isPalindrom(String testValue);
	
	public String toString() {
		return "Palindrom";
	}
}