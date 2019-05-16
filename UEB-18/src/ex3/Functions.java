package ex3;

/**
 * @author Quentin Duflot/ Marie-Lou Wechsler
 * @version 16/05/2019
 */
public class Functions {
    //1.A)
    public void applyAndPrint(MyFunction myFunction, int i, int j) {
        for ( int lauf = i; lauf <= j; lauf++ ) {
            System.out.println( lauf + " -> " + myFunction.calculate(lauf) );
        }
    }
    
    //1.B) Static Nested Class
    public static class FactorialStaticNested {
        public static int calculate(int x) {
            int result = 1;
            for(int i = 2; i <=x; i++) {
                result *= i;
            }
            return result;
        }
    }

    public void run() {
        //Lambda
        MyFunction xFactorialLambda = x -> {
            int result = 1;
            for (int i = 1; i <= x; i++) {
                    result *= i;
            }
            return result;
        };
        System.out.println("\n## x! (Lambda Ausdruck)");
        applyAndPrint(xFactorialLambda, 1, 5);

        //Anonymous
        MyFunction xFactorialAnonymous = new MyFunction() {
        	public int calculate(int x) {
                    int result = 1;
                    for(int i = 2; i <=x; i++) {
                        result *= i;
                    }
                    return result;
            }
        };
        System.out.println("\n## x! (Anonyme Klasse)");
        applyAndPrint(xFactorialAnonymous,1,5);

        //Top Level Class
        FactorialTop factorialTop = new FactorialTop();
        
        System.out.println("\n## Top Level Klasse");
        applyAndPrint(x -> factorialTop.calculate(x), 1, 5);
        
        System.out.println("\n## Top Level Klasse Objekt Methode Referenz");
        applyAndPrint(factorialTop::calculate, 1, 5);

        //Static Nested Class	
        System.out.println("\n## Static Nested Klasse");
        applyAndPrint(x -> FactorialStaticNested.calculate(x), 1, 5);
        
        System.out.println("\n## Static Nested Klasse statische Methode Referenz");
        applyAndPrint(FactorialStaticNested::calculate, 1, 5);
    }

    public static void main(String[] args) {
        Functions test = new Functions();
        test.run();
    }
}