import java.util.LinkedList;
import java.util.TreeMap;

/**
 * @author Quentin Duflot / Marie-Lou Wechsler
 * @version 21/06/2019
 */
public class Consumer {
	TreeMap<Integer, LinkedList<Long>> map;
	int digitSum, number;
	long timestamp;
	
	public Consumer() {
		map = new TreeMap<>();
	}
	
//	public Consumer(int number, int digitSum, long timestamp) {
//		this.number = number;
//		this.digitSum = digitSum;
//		this.timestamp = timestamp;
//	}
	
	/**
	 * consume() berechnet die Quersumme einer Zahl u. dessen Zeistempel
	 * @param int number
	 */
	public void consume(int number) {
		this.digitSum = calculateDigitSum(number);
		this.timestamp = System.currentTimeMillis();
		
		/* Falls die gegebene Quersumme noch nicht berechnet wurde,
		 * Erzeut man eine neue LinkedList, indem man die ≠ Zeitstempel lagert */
		if(map.get(digitSum) == null) {
			LinkedList<Long> list = new LinkedList<>();
			list.add(timestamp);
			map.put(digitSum, list);
		} else {
			map.get(digitSum).add(timestamp);
		}
		
		System.out.println(toString());
	}
	
	/**
	 * calculateDigitSum() berechnet die Quersumme einer Zahl
	 * @param int number
	 * @return int digitSum
	 */
	public int calculateDigitSum(int numberDS) {
		int digitSum = 0;
		while(numberDS > 0) {
			digitSum = digitSum + numberDS % 10;
			numberDS = numberDS / 10;
		}
		return digitSum;
	}
	
	/**
	 * numberOfDifferentResults() gibt Anzahl der ≠ keys der Map zurück
	 * @return int map size
	 */
	public int numberOfDifferentResults() {
		return map.size();
	}
	
	/**
	 * numberOfOccurences()
	 * @return
	 */
	public int numberOfOccurences() {
		return 0;
	}
	
	/**
	 * toString()
	 * return String str
	 */
	public String toString() {
		String str = "Eingebene Zahl:\t\t"+ number +"\n"
				+ "Dessen Quersumme:\t"+ digitSum +"\n"
				+ "Zeitstempel:\t\t"+ timestamp +" ms\n"
				+ "Die Map:\t\t"+ map +"\n";
		return str;
	}
	
	public static void main(String[] args) {
		Consumer consumer = new Consumer();
		consumer.consume(321);
		consumer.consume(21);
		consumer.consume(321);
		consumer.consume(153527);
		System.out.println("Anzahl der verschiedenen berechneten Quersummmen: "+ consumer.numberOfDifferentResults());
	}
}