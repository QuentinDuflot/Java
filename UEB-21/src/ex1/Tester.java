package ex1;

public class Tester {

	public static void main(String[] args) {
		Consumer consumer = new Consumer();
		consumer.consume(321);
		consumer.consume(21);
		consumer.consume(321);
		consumer.consume(153527);
		consumer.consume(1234);
		consumer.consume(128);
		/* Warum ist die TreeMap schon gesorted? */
		System.out.println("Anzahl der verschiedenen berechneten Quersummmen: "+ consumer.numberOfDifferentResults());
		System.out.println("Häufigkeit der berechneten Quersumme 6: "+ consumer.numberOfOccurences(6));
		System.out.println("Quersummen in aufsteigender Reihenfolge: "+ consumer.getCrossTotalAscending());
		System.out.println("Quersummen in absteigender Reihenfolge: "+ consumer.getCrossTotalDescending());
		System.out.println("Zeitstempel für die Quersumme 6: "+ consumer.getTimestampsForResult(6));
	}
}