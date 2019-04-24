
/**
 * Class EmployeeException
 * @author marie-louwechsler/Quentin Duflot
 * @version 1.1
 */

import java.util.regex.*;
public class EmployeeException extends Exception {

	public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
			Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	//Insensitive ==> This == this == ThIs usw..
	// \\. to have '.' as a non regex

	private static final String MSG_EMAIL_INCORRECT =
			"Die Email-Adresse ist inkorrekt. Bitte respektieren Sie den Format: name@domain.ext";

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
	 * @param email email address that has to be checked
	 * @throws EmployeeException when email is invalid
	 */
	public static void emailRight(String email) throws EmployeeException {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
		if(!matcher.find()) {
			throw new EmployeeException(MSG_EMAIL_INCORRECT);
		}
	}
}