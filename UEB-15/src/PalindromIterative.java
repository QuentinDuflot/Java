/**
 * PalindromIterative class to test palindroms in an iterative way
 * @author marie-louwechsler
 * @version 1.0
 */

public class PalindromIterative extends Palindrom {

	public PalindromIterative() { }

	/**
	 * isPalindrom iterative test of a string
	 * @param String testvalue 
	 * @return boolean, true = is palindrom, false = is not a palindrom
	 */
	@Override
	public boolean isPalindrom(String testValue) {
		// remove white spaces
		testValue = testValue.replaceAll("\\s+", "");
		testValue = testValue.toLowerCase();
		
		int i = 0;
		int testValueLength = testValue.length() - 1;
		boolean isEqual = true;
		
		while(i < testValueLength / 2 && isEqual == true) {
			if(testValue.charAt(i) == testValue.charAt(testValueLength - i)) {
				isEqual = true;
			} else {
				isEqual = false;
			}
			i++;
		}
		
		return isEqual;
	}
	
	public String toString() {
		return "Palindrom iterative";
	}
}