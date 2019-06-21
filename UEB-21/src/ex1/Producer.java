package ex1;
import java.util.Random;

/**
 * @author Quentin Duflot / Marie-Lou Wechsler
 * @version 21/06/2019
 */
public class Producer {
	
	/**
	 * produce() gibt eine Zufallszahl zw. 1 und 1000 zurueck
	 * @return int number
	 */
	public int produce() {
		Random random = new Random();
		int number = random.nextInt(1000) + 1;
		return number;
	}
	
	public static void main(String[] args) {}
}