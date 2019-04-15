
/**
 * Class Time
 * @author marie-louwechsler
 * @version 1.1
 */

public class Time {
	private int hour;
	private int minute;
	
	/**
	 * @param hourG time
	 * @param minuteG time
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