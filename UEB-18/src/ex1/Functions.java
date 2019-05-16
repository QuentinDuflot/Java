package ex1;
/**
 * @author Marie-Lou Wechsler / Quentin Duflot
 * @version 16/05/2019
 */
public class Functions {
	
	// 1.A)
	public double iterate(double startValue, int iteration, IterateInterface function) {
		System.out.println("\n## Iterate method:");
		double result = startValue;
		
		for(int i = 0; i < iteration; i++) {
			result = function.calculate(result);
			System.out.println("Value at " +i+ ": " +result);
		}
		return result;
	}
	
	public void run() {
		// 1.B)
		IterateInterface test1 = x -> 2 * x;
		IterateInterface test2 = x -> 0.5 * x;
		IterateInterface test3 = x -> {
			return (0.4 * x) * (x - 1);
		};
		
//		a als gegebenes Wert, how do you implement that?
//		IterateInterface test3 = (double x, double a) -> {
//			return (a * x) * (x - 1);
//		};
		
		System.out.println(iterate(1.0, 5, test1));
		System.out.println(iterate(2.0, 4, test2));
		System.out.println(iterate(3.0, 7, test3));
	}
	
	public static void main(String[] args) {
		Functions tester = new Functions();
		tester.run();
	}
}