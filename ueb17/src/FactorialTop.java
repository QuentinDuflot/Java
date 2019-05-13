/**
 * 
 * @author Quentin Duflot/ Marie-Lou Wechsler
 * @version 10/05/2019
 *
 */
public class FactorialTop {
	//1.B)
	//ii.)
	public int apply(int x) {
		int result = 1;
		for(int i = 1; i <=x; i++) {
			result *= i;
		}
		return result;
	}
}