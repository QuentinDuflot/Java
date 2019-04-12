
public class EmployeeException extends Exception {
	public static final String EMAIL_FORMAT = "^.*@.*$";
	private static final String MSG_EMAIL_INCORRECT =
			"Die Email-Adresse ist inkorrekt. Bitte respektieren Sie den Format: name@domaine.ext";

	public EmployeeException() {
		super();
	}

	/**
	 * @param message error
	 */
	public EmployeeException(String message) {
		super(message);
	}
	
	/**
	 * @param email employee
	 * @throws EmployeeException when email is invalid
	 */
	public static void emailRight(String email) throws EmployeeException {
		if(!email.matches(EMAIL_FORMAT)) {
			throw new EmployeeException(MSG_EMAIL_INCORRECT);
		}
	}
}