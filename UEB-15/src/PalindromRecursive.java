/**
 * PalindromRecursive class to test palindroms in a recursive way
 * @author marie-louwechsler/ Quentin Duflot
 * @version 1.0
 */

public class PalindromRecursive extends Palindrom {
	
	public PalindromRecursive() { }
	
	/**
	 * Method that tells if a string is a palindrom or not
	 * The test is done on a recursiv way
	 *
	 * @param String string that must be test
	 * @return boolean, true = is palindrom, false = is not a palindrom
	 */
	@Override
	public boolean isPalindrom(String testValue) {
		testValue = testValue.replaceAll("\\s+", "");
		testValue = testValue.toLowerCase();
		
		if (testValue.length() == 0 || testValue.length() == 1) {
			return true;
		}
		
		if (testValue.charAt(0) == testValue.charAt(testValue.length() - 1)) {
			// first and last characters are equal
			// then take substring and test again
			return isPalindrom(testValue.substring(1, testValue.length() - 1));
		}
		
		return false;
	}
	
	public String toString() {
		return "Palindrom recursive";
	}
}