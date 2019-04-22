/**
 * PalindromIterative class to test palindroms in an iterative way
 * @author marie-louwechsler/ Quentin Duflot
 * @version 1.0
 */

public class PalindromIterative extends Palindrom {

	public PalindromIterative() { }

	/**
	 * Method that tells if a string is a palindrom or not
	 * The test is done on an iterativ way
	 *
	 * @param String string that must be test
	 * @return boolean, true = is palindrom, false = is not a palindrom
	 */
	@Override
	public boolean isPalindrom(String testValue) {
		// removing white spaces
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