
/**
 * Class TimeException
 * @author marie-louwechsler
 * @version 1.1
 */

public class TimeException extends Exception {
	public static final int MAX_HOURS = 23;
	public static final int MIN_HOURS = 0;
	public static final int MAX_MINUTES = 59;
	public static final int MIN_MINUTES = 0;
	
	public static final String MSG_HOURS_INCORRECT =
			"Die Stunden müssen zw. "+ MIN_HOURS +" und "+ MAX_HOURS +" liegen.";
	public static final String MSG_MIN_INCORRECT =
			"Die Minuten müssen zw. "+ MIN_MINUTES +" und "+ MAX_MINUTES +" liegen.";
	
	public TimeException() {
		super();
	}
	
	/**
	 * @param message error
	 */
	public TimeException(String message) {
		super(message);
	}
	
	/**
	 * @param hoursG time
	 * @throws TimeException when hour is incorrect
	 */
	public static void hoursRight(int hoursG) throws TimeException {
		if((hoursG > MAX_HOURS) || (hoursG < MIN_HOURS)) {
			throw new TimeException(MSG_HOURS_INCORRECT);
		}
	}
	
	/**
	 * @param minutesG time
	 * @throws TimeException when minutes are incorrect
	 */
	public static void minutesRight(int minutesG) throws TimeException {
		if((minutesG > MAX_MINUTES) || (minutesG < MIN_MINUTES)) {
			throw new TimeException(MSG_MIN_INCORRECT);
		}
	}
}