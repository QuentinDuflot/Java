import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Tester-class that permits to test all the methods of the exercise
 *
 * @author marie-louwechsler/ Quentin Duflot
 * @version 1.0
 */
public class Tester {
	private Scanner in;
	
	private static final int USER_GCD = 		1;
	private static final int TEST_CASE_GCD = 	2;
	private static final int USER_PAL =			3;
	private static final int TEST_CASE_PALIT =	4;
	private static final int TEST_CASE_PALREC =	5;
	private static final int QUIT = 			9;
	
	private static final String PAL1 =		"Anna";
	private static final String PAL2 =		"Geben Sie eine";
	private static final String PAL3 =		"Red rum sir is murder";
	private static final String PAL4 =		"Dis beau lama t'as mal au bide";
	private static final String PAL5 =		"Ce satrape repart a sec";
	
	GreatestCommonDivisor gcd = new GreatestCommonDivisor();
	PalindromIterative pi = new PalindromIterative();
	PalindromRecursive pr = new PalindromRecursive();
	Tools t = new Tools();
	
	public Tester() {
		System.out.println("TESTEN DER UEBUNG 15:");
		in = new Scanner(System.in);
	}
	
	public void run() {
		int userChoice = 0;
		
		while(userChoice != QUIT) {
			try {
				userChoice = chooseFunction();
				
				switch(userChoice) {
					case USER_GCD:
						System.out.println("Geben Sie eine natuerliche Zahl ein:");
						long a = InputReaders.readLong(in);
						System.out.println("Geben Sie eine zweite natuerliche Zahl ein:");
						long b = InputReaders.readLong(in);
						System.out.println("a = "+ a +",\t\tb = "+ b +":\t\t"+ gcd.calculateGCD(a, b) +"\n");
						break;
					case TEST_CASE_GCD:
						testCaseGCD();
						break;
					case USER_PAL:
						boolean isIterativ = isIterativeWay();
						boolean isFile = isReadingFromFile();
						
						if(isFile == true) {
							System.out.println("Geben Sie den Namen der Datei ein:");
							String fileName = InputReaders.readString(in);
							readFromFile(fileName, isIterativ);
						} else {
							readFromString(isIterativ);
						}
						break;
					case TEST_CASE_PALIT:
						testCasePalIt();
						break;
					case TEST_CASE_PALREC:
						testCasePalRec();
						break;
					case QUIT:
						System.out.println("Programm wurde beendeet.");
						in.close();
						break;
					default:
						System.out.println("Falsche Eingabe. Versuchen Sie erneut.");
						break;
				}
			} catch (InputMismatchException e) {
				System.err.println(e);
			} catch (NumberFormatException e) {
				System.err.println(e);
			} catch (RuntimeException e) {
				System.err.println(e);
			} catch (Exception e) {
				System.err.println(e);
			}
		}
	}

	/* Test cases for all the implemented functions */
	/**
	 * Test cases for greatest common divisor
	 */
	public void testCaseGCD() {
		GreatestCommonDivisor gcd = new GreatestCommonDivisor();
		System.out.println("TESTFALL GROESSTE GEMEINSAME TEILER:\n"
				+ "a = 20,\t\tb = 5:\t\t"+ gcd.calculateGCD(20, 5) +"\n"		// 5
				+ "a = 62,\t\tb = 8:\t\t"+ gcd.calculateGCD(62, 8) +"\n"		// 2
				+ "a = 53,\t\tb = 7:\t\t"+ gcd.calculateGCD(53, 7) +"\n"		// 1
				+ "a = 754,\tb = 12:\t\t"+ gcd.calculateGCD(754, 12) +"\n"		// 2
				+ "a = 2340,\tb = 24:\t\t"+ gcd.calculateGCD(2340, 24) +"\n"	// 12
				+ "a = 52309,\tb = 361:\t"+ gcd.calculateGCD(52309, 361) +"\n"	// 1
		);
	}

	/**
	 * Test cases for the recursiv palindrom test
	 */
	public void testCasePalRec() {
		PalindromRecursive pr = new PalindromRecursive();
		System.out.println("TESTFALL PALINDROM REKURSIV:\n"
				+ PAL1 +": "+ pr.isPalindrom(PAL1) +"\n"
				+ PAL2 +": "+ pr.isPalindrom(PAL2) +"\n"
				+ PAL3 +": "+ pr.isPalindrom(PAL3) +"\n"
				+ PAL4 +": "+ pr.isPalindrom(PAL4) +"\n"
				+ PAL5 +": "+ pr.isPalindrom(PAL5) +"\n"
		);
	}

	/**
	 * Test cases for the iterativ palindrom test
	 */
	public void testCasePalIt() {
		PalindromIterative pi = new PalindromIterative();
		System.out.println("TESTFALL PALINDROM ITERATIV:\n"
				+ PAL1 +": "+ pi.isPalindrom(PAL1) +"\n"
				+ PAL2 +": "+ pi.isPalindrom(PAL2) +"\n"
				+ PAL3 +": "+ pi.isPalindrom(PAL3) +"\n"
				+ PAL4 +": "+ pi.isPalindrom(PAL4) +"\n"
				+ PAL5 +": "+ pi.isPalindrom(PAL5) +"\n"
		);
	}
	
	/* Utilities */

	/**
	 * Method that permit the user to choose which function he would like to test
	 *
	 * @return the number choosen by the user. This number is associated to a function
	 */
	public int chooseFunction() {
		System.out.println("-----\n"
				+ "• Eigene Werten, um der GGT auszuprobieren:\t\t"+ USER_GCD +" eingeben.\n"
				+ "• Test Fall GGT ausprobieren:\t\t\t"+ TEST_CASE_GCD +" eingeben.\n"
				+ "• Eigene Werte, um das Palindrom auszuprobieren:\t"+ USER_PAL +" eingeben.\n"
				+ "• Test Fall PalIt ausprobieren:\t\t\t"+ TEST_CASE_PALIT +" eingeben.\n"
				+ "• Test Fall PalRec ausprobieren:\t\t"+ TEST_CASE_PALREC +" eingeben.\n"
				+ "• Programm beenden:\t\t\t\t"+ QUIT +" eingeben.\n"
				+ "-----"
		);
		return InputReaders.readInt(in);
	}

	/**
	 * Method that permits the user to choose if he wants to test palindrom by the recursiv or by the
	 * iterativ way
	 *
	 * @return true if he wants it iterativ or false if he wants recursiv
	 */
	public boolean isIterativeWay() {
		return t.yesOrNo(in, "Wollen Sie das Palindrom iterativ (Y) or rekursiv (N) berechnen?");
	}

	/**
	 * Method that permits the user to choose if he wants to test palindroms from a file or not
	 *
	 * @return true if it's reading from file and false if not
	 */
	public boolean isReadingFromFile() {
		return t.yesOrNo(in, "Wollen Sie das Palindrom aus einer Datei testen? (Y: Ja, N: Nein");
	}

	/**
	 * method that read a palindrom  and write if it's one or not
	 * also give the execution time
	 *
	 * @param way the way the palindrom should be analyse, true is iterativ and false recursiv
	 */
	public void readFromString(boolean way) {
		String str;
		
		if(way == true) {
			System.out.println("\n Geben Sie irgendwelche Zeichenkette ein, um iterativ zu ueberpruefen, ob es ein Palindrom ist:");
			str = InputReaders.readString(in);
			int startTime = System.nanoTime();
			System.out.println("\n" + str + ": " + pi.isPalindrom(str));
			System.out.println("\n Verstrichene Zeit : " + System.nanoTime() - startTime);
		} else {
			System.out.println("\n Geben Sie irgendwelche Zeichenkette ein, um rekursiv zu ueberpruefen, ob es ein Palindrom ist:");
			int startTime = System.nanoTime();
			str = InputReaders.readString(in);
			System.out.println("\n" + str + ": " + pr.isPalindrom(str));
			System.out.println("\n Verstrichene Zeit : " + System.nanoTime() - startTime);
		}
	}

	/**
	 * method that read a palindrom from a file and write if it's one or not
	 * also give the execution time
	 *
	 * @param fileName file that must be read
	 * @param way the way the palindrom should be analyse, true is iterativ and false recursiv
	 * @throws IOException if there is a problem with the file
	 */
	public void readFromFile(String fileName, boolean way) throws IOException {
		String str;
		
		File file = new File(fileName);
		BufferedReader br = new BufferedReader(new FileReader(file));

		if(way == true) {
			while((str = br.readLine()) != null) {
				int startTime = System.nanoTime();
				System.out.println("\n" + str + ": "+ pi.isPalindrom(str));
				System.out.println("\n Verstrichene Zeit : " + System.nanoTime() - startTime);
			}
		} else {
			while((str = br.readLine()) != null) {
				int startTime = System.nanoTime();
				System.out.println("\n" + str + ": "+ pr.isPalindrom(str));
				System.out.println("\n Verstrichene Zeit : " + System.nanoTime() - startTime);
			}
		}
	}
	
	public static void main(String[] args) {
		Tester t = new Tester();
		t.run();
	}
}