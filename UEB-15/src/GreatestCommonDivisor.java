/**
 * GreatestCommonDivisor class to calculate the gcd between two numbers (recursive)
 * @author marie-louwechsler/ Quentin Duflot
 * @version 1.0
 */

public class GreatestCommonDivisor {

	public GreatestCommonDivisor() { }
	
	/**
	 * @param a int first natural number
	 * @param b int second natural number
	 * @return the greatest common divisor of both numbers
	 */
	public long calculateGCD(long a, long b) {
		long result;
		
		if(b == 0) {
			result = a;
		} else {
			result = calculateGCD(b, (a % b));
		}
		
		return result;
	}
	
	public String toString() {
		return "Greatest common divisor recursive";
	}
}