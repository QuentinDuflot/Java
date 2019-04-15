
/**
 * Class Time
 * @author marie-louwechsler/Quentin Duflot
 * @version 1.1
 */

public class Time {
	private int hour;
	private int minute;
	
	/**
	 * @param hourG hours number (between 0 and 23)
	 * @param minuteG minutes number (between 0 and 59)
	 * @throws TimeException when time is incorrect
	 */
	public Time(int hourG, int minuteG) throws TimeException {
		TimeException.hoursRight(hourG);
		TimeException.minutesRight(minuteG);
		
		this.hour = hourG;
		this.minute = minuteG;
	}
	
	public int getHour() {
		return hour;
	}
	
	public int getMinute() {
		return minute;
	}
	
	@Override
	public String toString() {
		return hour +":"+ minute +" Uhr";
	}
}