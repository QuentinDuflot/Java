public class NumberOperationsNegative extends Exception {
	public static final String OPERATIONS_NUMBER_NOT_NEG =
			"Die Nummer der Operationen kann nicht negativ sein.";
	
	public NumberOperationsNegative() {
		super();
	}
	
	/**
	 * @param message
	 */
	public NumberOperationsNegative(String message) {
		super(message);
	}
	
	/**
	 * @param nbrOperations
	 * @throws OperationsException
	 */
	public static void cannotBeNegative(int nbrOperations) throws NumberOperationsNegative {
		if(nbrOperations <= 0) {
			throw new NumberOperationsNegative(OPERATIONS_NUMBER_NOT_NEG);
		}
	}
}