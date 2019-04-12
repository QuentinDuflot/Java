
public class PersonException extends Exception {
	private static final String MSG_NAME_INCORRECT = 
			"Der Name darf nicht leer sein";

	public PersonException() {
		super();
	}

	/**
	 * @param message error
	 */
	public PersonException(String message) {
		super(message);
	}
	
	/**
	 * @param name first or last name of person
	 * @throws PersonException when name is invalid
	 */
	public static void nameRight(String name) throws PersonException {
		if((name == null) || (name.trim().length() == 0)) {
			throw new PersonException(MSG_NAME_INCORRECT);
		}
	}
}