import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Tools Class methods that can be useful
 * @author marie-louwechsler
 * @version 1.0
 */
public class Tools {
	
	public Tools() { }
	
	/**
	 * @param in Scanner that reads input
	 * @param instruction String
	 * @return true if Y, false if N
	 */
	public boolean yesOrNo(Scanner in, String instruction) {
		char userInput = ' ';

		do {
			System.out.println(instruction + " (Y/N)");
			userInput = in.nextLine().charAt(0);
			
			if(userInput == 'Y') {
				return true;
			} else if(userInput == 'N') {
				return false;
			}
		} while (userInput != 'Y' && userInput != 'N');
		
		return false;
	}
}