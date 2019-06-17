package ueb20;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Tester {
	private Scanner in;
	
	private static final int CREATE_HEAP = 	1;
	private static final int SHOW_HEAP =	2;
	private static final int PEEK_HEAP =	3;
	private static final int POLL_HEAP =	4;
	private static final int QUIT =			0;
	
	private static final String CHOICE_ERROR =
			"Bitte geben Sie eine Zahl der vorhandenen Liste ein.";
	
	private MinHeap<Integer> minheap;
	public int lengthHeap;
	
	Tools t = new Tools();
	
	/**
	 * Tester() default constructor
	 * Erzeugen des Heaps + Scanners
	 */
	public Tester() throws Exception {
		System.out.println("TESTEN DER UEBUNG 20:");
		minheap = new MinHeap<Integer>();
		lengthHeap = minheap.getLength();
		System.out.println("Erzeugen eines MinHeaps Objekt dessen Größe "+ lengthHeap +" beträgt.");
		
		in = new Scanner(System.in);
	}
	
	/**
	 * Launcher
	 */
	public void run() {
		int userChoice = -1;
		Random random = new Random();
		
		while(userChoice != QUIT) {
			try {
				userChoice = chooseFunction();
				
				switch(userChoice) {
					case CREATE_HEAP:
						for (int i = 0; i < lengthHeap; i++) {
							minheap.offer(random.nextInt(50));
						}
						break;
					case SHOW_HEAP:
						System.out.println(minheap.showContent());
						break;
					case PEEK_HEAP:
						int peek = minheap.peek();
						System.out.println(peek +" Zahl");
						break;
					case POLL_HEAP:
						int poll = minheap.poll();
						System.out.println(poll + " Zahl");
						break;
					case QUIT:
						System.out.println("Schließen des Programms.");
						break;
					default:
						System.out.println(CHOICE_ERROR);
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
	
	/**
	 * chooseFunction()
	 * @return die Nummer der Methode, die zu testen ist
	 */
	public int chooseFunction() {
		System.out.println(
			"-----\n"
			+ "• Heap erzeugen:\t\t"+ CREATE_HEAP +"\n"
			+ "• Heap anzeigen:\t\t"+ SHOW_HEAP +"\n"
			+ "• Niedrigstes Wert anzeigen:\t"+ PEEK_HEAP +"\n"
			+ "• Niedrigstes Wert entfernen:\t"+ POLL_HEAP + "\n"
			+ "• Programm beenden:\t\t"+ QUIT +"\n"
			+ "-----"
		);
		return InputReaders.readInt(in);
	}

	public static void main(String[] args) throws Exception {
		Tester t = new Tester();
		t.run();
	}
}