import java.util.function.IntPredicate;
/**
 * 
 * @author Quentin Duflot/ Marie-Lou Wechsler
 * @version 10/05/2019
 *
 */
public class Functions {
	
	public void applyAndPrint(MyFunction myFunction, int i, int j)
    {
     for ( int lauf = i; lauf <= j; lauf++ )
       {
        System.out.println( lauf + " -> " + myFunction.apply(lauf) );
       }
    }
	
	public void run() {
		//i.)
		//Anonymous
		MyFunction xSquareAnonymous = new MyFunction() {
			public int apply(int x)
			{
				return x*x;
			}
		};
		System.out.println("\n x^2 (Anonyme Klasse)");
		applyAndPrint(xSquareAnonymous, 1, 5);
		
		//ii.)
		//Anonymous
		MyFunction xFactorialAnonymous = new MyFunction() {
			public int apply(int x)
			{
				int result = 1;
				for(int i = 0; i <=x; i++)
				{
					result *= i;
				}
				return result;
			}
		};
		System.out.println("\n x! (Anonyme Klasse)");
		applyAndPrint(xFactorialAnonymous,1,5);
		
		//iii.)
		//Lambda
		MyFunction xPowerxPlus1 = x -> {
			
			int result = x;
			for(int i = 2; i <= x+1; i++)
			{
				result *=x;
			}
			return result;
		
		};
		System.out.println("\n x^(x+1) (Lamda-Ausdruck");
		applyAndPrint(xPowerxPlus1, 1, 5);
		
		//iv.)
		//Lambda
		MyFunction fibonnacciLambda = x -> {
			if(x <= 1) {
				return x;
			}
			int fib = 1;
			int prevFib = 1;
			
			for(int i=2; i<x; i++) {
				int temp = fib;
				fib+= prevFib;
				prevFib = temp;
			}
			return fib;
		};
		System.out.println("\n fibonnacci(x) (Lambda)");
		
		applyAndPrint(fibonnacciLambda, 1, 5);
		//1.D)
		//odd
		IntPredicate odd = new IntPredicate(){
			
			public boolean test (int value)
			{
				return value % 2 == 1;
			}
		};
			
		//1.E)
		MyFunctionConditional  xSquare = x -> x*x;
		MyFunctionConditional  xFactorial = x -> {
									
			int result = 1;

			for ( int i = 2; i<=x; i++ )
			{
				result *= i;
			}
			return result;
        };
		System.out.println("\n Quadratzahlen für gerade Werte");
		applyAndPrint(xSquare.conditionateInput(even), 1, 5);
		System.out.println("\n Fakultät für ungerade Werte");
		applyAndPrint(xFactorial.conditionateOutput(odd), 1, 5);
		
		
	}
	
	
	public static void main(String[] args)
	{
		Functions test = new Functions();
		test.run();
	}
}
