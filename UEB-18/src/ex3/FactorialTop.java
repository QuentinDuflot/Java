package ex3;

/**
 * @author Quentin Duflot/ Marie-Lou Wechsler
 * @version 16/05/2019
 */
public class FactorialTop implements MyFunction {
	public int calculate(int x) {
		int result = 1;
		for(int i = 1; i <=x; i++) {
			result *= i;
		}
		return result;
	}
}