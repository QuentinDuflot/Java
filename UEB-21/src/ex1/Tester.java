package ex1;

import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

/**
 * @author Quentin Duflot / Marie-Lou Wechsler
 * @version 21/06/2019
 */
public class Tester {
	Queue<Integer> queue;
	Consumer consumer;
	Producer producer;
	Random random;
	
	public Tester() {
		queue = new PriorityQueue<Integer>();
		consumer = new Consumer();
		producer = new Producer();
		random = new Random();
	}
	
	public void start() {
		System.out.println("Starten der Tests\n"
				+ "-----------------");
		
		for(int i = 0; i < 20; i++) {
			if(random.nextInt(2) > 0) {
				/* Erzeugen eines neuen Integers durch den Producer und speichern in einer Collection */
				queue.add(producer.produce());
			} else {
				/* Entnehmen eines Integeres aus der Collection und Berechnung der Quersumme durch den Consumer */
				try {
					consumer.consume(queue.remove());
				} catch(NoSuchElementException e) { }
			}
		}
		
		System.out.println("Unkonsumierte Zahlen:\t\t\t\t\t"+ queue);
		System.out.println("Anzahl der verschiedenen berechneten Quersummmen:\t"+ consumer.numberOfDifferentResults());
		System.out.println("Quersummen in aufsteigender Reihenfolge:\t\t"+ consumer.getCrossTotalAscending());
		System.out.println("Quersummen in absteigender Reihenfolge:\t\t\t"+ consumer.getCrossTotalDescending());
		System.out.println("Häufigkeit der berechneten Quersumme 6:\t\t\t"+ consumer.numberOfOccurences(6));
		System.out.println("Zeitstempel für die Quersumme 6:\t\t\t"+ consumer.getTimestampsForResult(6));
	}

	public static void main(String[] args) {
		Tester tester = new Tester();
		tester.start();
	}
}