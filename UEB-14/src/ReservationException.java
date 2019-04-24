
/**
 * Class ReservationException
 * @author marie-louwechsler/Quentin Duflot
 * @version 1.1
 */

public class ReservationException extends Exception {
	public static final String MSG_HOURS_INCORRECT =
			"Die End-Stunde kann nicht kleiner als die Start-Stunde sein.";
	public static final String MSG_MINUTES_INNCORRECT =
			"Die End-Minute kann nicht kleiner als die Start-Minute sein.";
	
	public ReservationException() {
		super();
	}

	/**
	 * @param message error
	 */
	public ReservationException(String message) {
		super(message);
	}
	
	/**
	 * @param startG begin of the reservation
	 * @param endG end of the reservation
	 * @throws ReservationException when end time is inferior to start time
	 */
	public static void endBeforeStart(Time startG, Time endG) throws ReservationException {
		int startHour = startG.getHour();
		int startMinute = startG.getMinute();
		int endHour = endG.getHour();
		int endMinute = endG.getMinute();
		
		if(endHour < startHour) {
			throw new ReservationException(MSG_HOURS_INCORRECT);
		} else if(endHour == startHour) {
			if (endMinute < startMinute) {
				throw new ReservationException(MSG_MINUTES_INNCORRECT);
			}
		}
	}
}