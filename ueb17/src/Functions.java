
public class Functions {
	
	public void applyAndPrint(MyFunction myFunction, int i, int j)
    {
     for ( int lauf = i; lauf <= j; lauf++ )
       {
        System.out.println( lauf + " -> " + myFunction.apply(lauf) );
       }
    }
	
	public void run() {
		//1.A)
		//Anonymous
		MyFunction xCubeAnonymous = new MyFunction() {
			public int apply(int x)
			{
				return x*x;
			}
		};
		System.out.println("\n x^2 (Anonyme Klasse)");
		applyAndPrint(xCubeAnonymous, 1, 5);
		
		//1.B)
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
		
		
	}
}
