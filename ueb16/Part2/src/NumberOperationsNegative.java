public class NumberOperationsNegative extends Exception {
<<<<<<< HEAD
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
=======
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
     * @throws NumberOperationsNegative
     */
    public static void cannotBeNegative(int nbrOperations) throws NumberOperationsNegative {
        if(nbrOperations <= 0) {
            throw new NumberOperationsNegative(OPERATIONS_NUMBER_NOT_NEG);
        }
    }
}
>>>>>>> 18412a3c7217cb5107c3fcaff3b7446b93a1a52e
