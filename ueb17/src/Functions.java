import java.util.function.IntPredicate;
/**
 * 
 * @author Quentin Duflot/ Marie-Lou Wechsler
 * @version 10/05/2019
 *
 */
public class Functions {
    //1.A)
    public void applyAndPrint(MyFunction myFunction, int i, int j) {
        for ( int lauf = i; lauf <= j; lauf++ ) {
            System.out.println( lauf + " -> " + myFunction.apply(lauf) );
        }
    }
    //Static Nested Class
    public static class FactorialStaticNested 
    {
        public static int calculate(int x) 
        {
            int result = 1;
            for(int i = 2; i <=x; i++) 
            {
                result *= i;
            }
            return result;
        }
    }

    public void run() {
        //1.B)
        //i.)
        //Lambda
        MyFunction xSquareLambda = x -> {
                return x*x;
            };
        System.out.println(" x^2 (Lambda Ausdruck)");
        applyAndPrint(xSquareLambda, 1, 5);
        //OR applyAndPrint(x -> x*x, 1, 5);

        //Anonymous
        MyFunction xSquareAnonymous = new MyFunction() {
                public int apply(int x) {
                    return x*x;
                }
            };
        System.out.println("\n x^2 (Anonyme Klasse)");
        applyAndPrint(xSquareAnonymous, 1, 5);

        //ii.)
        //Lambda
        MyFunction xFactorialLambda = x -> {
                int result = 1;
                for (int i = 1; i <= x; i++) {
                    result *= i;
                }
                return result;
            };
        System.out.println("\n x! (Lambda Ausdruck)");
        applyAndPrint(xFactorialLambda, 1, 5);

        //Anonymous
        MyFunction xFactorialAnonymous = new MyFunction() {
                public int apply(int x) {
                    int result = 1;
                    for(int i = 2; i <=x; i++) {
                        result *= i;
                    }
                    return result;
                }
            };
        System.out.println("\n x! (Anonyme Klasse)");
        applyAndPrint(xFactorialAnonymous,1,5);

        //Top Level Class
        FactorialTop factorialTop = new FactorialTop();
        System.out.println("\n Top Level Klasse\n"
            + factorialTop.apply(5));

	//Static Nested Class	
        System.out.println("\n Static Nested Klasse\n"
            + FactorialStaticNested.calculate(5));

		
        //iii.)
        //Lambda
        MyFunction xPowerxPlus1 = x -> {
                int result = x;
                for(int i = 2; i <= x+1; i++) {
                    result *=x;
                }
                return result;

            };
        System.out.println("\n x^(x+1) (Lamda Ausdruck)");
        applyAndPrint(xPowerxPlus1, 1, 5);

        //Anonymous
        MyFunction xPowerxPlus1Anonymous = new MyFunction() {
                public int apply(int x) {
                    int result = x;
                    for(int i = 1; i < x + 1; i++) {
                        result *= x;
                    }
                    return result;
                }
            };
        System.out.println("\n x^(x+1) (Anonyme Klasse)");
        applyAndPrint(xPowerxPlus1Anonymous, 1, 5);

        //iv.)
        //Lambda
        MyFunction fibonacciLambda = x -> {
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
        System.out.println("\n fibonnacci(x) (Lambda Ausdruck)");
        applyAndPrint(fibonacciLambda, 1, 5);

        //Anonymous
        MyFunction fibonacciAnonymous = new MyFunction() {
                public int apply(int x) {
                    if(x <= 1) {
                        return x;
                    }
                    int fib = 1;
                    int prevFib = 1;

                    for(int i = 2; i < x; i++) {
                        int temp = fib;
                        fib += prevFib;
                        prevFib = temp;
                    }
                    return fib;
                }
            };
        System.out.println("\n fibonnacci(x) (Anonyme Klasse)");
        applyAndPrint(fibonacciAnonymous, 1, 5);

        //1.D)
        //odd
        IntPredicate odd = new IntPredicate() {
                public boolean test (int value) {
                    return value % 2 == 1;
                }
            };
        System.out.println("\n Praedikat odd");
        System.out.println("Is 2 odd? "+ odd.test(2));
        System.out.println("Is 3 odd? "+ odd.test(3));

        //even
        IntPredicate even = new IntPredicate() {
                public boolean test (int value) {
                    return value % 2 == 0;
                }
            };
        System.out.println("\n Praedikat even");
        System.out.println("Is 4 even? "+ even.test(4));
        System.out.println("Is 5 even? "+ even.test(5));

        //1.E)
        MyFunctionConditional  xSquare = x -> x*x;
        System.out.println("\n Quadratzahlen fuer gerade Werte");
        applyAndPrint(xSquare.conditionateInput(even), 1, 10);

        //1.F)
        MyFunctionConditional  xFactorial = x -> {				
                int result = 1;
                for ( int i = 2; i<=x; i++ ) {
                    result *= i;
                }
                return result;
            };
        System.out.println("\n Fakultaet ungerade Werte");
        applyAndPrint(xFactorial.conditionateOutput(odd), 1, 10);
        System.out.println("\n Fakultaet gerade Werte");
        applyAndPrint(xFactorial.conditionateOutput(even), 1, 10);
    }

    public static void main(String[] args) {
        Functions test = new Functions();
        test.run();
    }
}