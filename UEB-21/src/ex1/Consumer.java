package ex1;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author Quentin Duflot / Marie-Lou Wechsler
 * @version 21/06/2019
 */
public class Consumer {
	TreeMap<Integer, LinkedList<Long>> map;
	
	public Consumer() {
		map = new TreeMap<>();
	}
	
	/**
	 * consume() berechnet die Quersumme einer Zahl u. dessen Zeistempel
	 * @param int number
	 */
	public void consume(int number) {
		int digitSum = calculateDigitSum(number);
		long timestamp = System.currentTimeMillis();
		
		/* Falls die gegebene Quersumme noch nicht berechnet wurde,
		 * Erzeut man eine neue LinkedList, indem man die ≠ Zeitstempel lagert */
		if(map.get(digitSum) == null) {
			LinkedList<Long> list = new LinkedList<>();
			list.add(timestamp);
			map.put(digitSum, list);
		} else {
			map.get(digitSum).add(timestamp);
		}
		
		System.out.println("Eingebene Zahl:\t\t"+ number +"\n"
				+ "Dessen Quersumme:\t"+ digitSum +"\n"
				+ "Zeitstempel:\t\t"+ timestamp +" ms\n"
				+ "Die Map:\t\t"+ map +"\n"
		);
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
	 * numberOfOccurences() zaehlt wie viel Mal eine Quersumme berechnet wurde
	 * @return
	 */
	public int numberOfOccurences(int number) {
		if(map.containsKey(number)) {
			return map.get(number).size();
		}
		return 0;
	}
	
	/**
	 * getCrossTotalAscending() zeigt die Quersummen in aufsteigender Reihenfolge
	 * @return 
	 */
	public Set<Integer> getCrossTotalAscending() {
		return map.keySet();
	}
	
	/**
	 * getCrossTotalDescending() zeigt die Quersummen in absteigender Reihenfolge
	 * @return
	 */
	public Set<Integer> getCrossTotalDescending() {
		return map.descendingKeySet();
	}
	
	/* Richtiger Datenformat? */
	/**
	 * getTimestampsForResult() zeigt die gegebene Zeitstempel fuer eine gegebene Quersumme 
	 * @param int number
	 * @return
	 */
	public List<Long> getTimestampsForResult(int number) {
		if(map.containsKey(number)) {
			return map.get(number);
		}
		return null;
	}
	
	/**
	 * toString()
	 * return String str
	 */
//	public String toString() {}
}