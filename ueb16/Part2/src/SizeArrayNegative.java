
public class SizeArrayNegative extends Exception {
	private static final String NEGATIVE_SIZE =
			"Die Länge des Arrays kann nicht negativ sein";
	
	public SizeArrayNegative() {
		super();
	}
	
	/**
	 * @param message
	 */
	public SizeArrayNegative(String message) {
		super(message);
	}
	
	/**
	 * @param array
	 * @throws SizeArrayNegative
	 */
	public static void cannotBeNegative(int groesse) throws SizeArrayNegative {
		if(groesse < 0) {
			throw new SizeArrayNegative(NEGATIVE_SIZE);
		}
	}
}