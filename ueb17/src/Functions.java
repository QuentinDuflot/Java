
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
		MyFunction xCubeAnonymous = new MyFunction() {
			public int apply(int x)
			{
				return x*x;
			}
		};
		System.out.println("\n x^2 (Anonyme Klasse)");
		applyAndPrint(xCubeAnonymous, 1, 5);
		
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
	}
	
	public static void main(String[] args)
	{
		Functions test = new Functions();
		test.run();
	}
}
