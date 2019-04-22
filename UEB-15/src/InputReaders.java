import java.util.Scanner;

/**
 * InputReaders class to read inputs from different types
 * @author marie-louwechsler/ Quentin Duflot
 * @version 1.0
 */
public class InputReaders {

	public InputReaders() { }

	/**
	 * @param in scanner type int
	 * @return
	 */
	public static int readInt(Scanner in) {
		int number = in.nextInt();
		in.nextLine();
		return number;
	}
	
	/**
	 * @param in scanner type long
	 * @return
	 */
	public static long readLong(Scanner in) {
		long number = in.nextLong();
		in.nextLine();
		return number;
	}
	
	/**
	 * @param in scanner type String
	 * @return
	 */
	public static String readString(Scanner in) {
		String str = null;
		if(in.hasNextLine()) {
			str = in.nextLine();
		}
		return str;
	}
	
	/**
	 * @param in scanner type char
	 * @return
	 */
	public static char readChar(Scanner in) {
		char result = in.nextLine().charAt(0);
		return result;
	}
}
