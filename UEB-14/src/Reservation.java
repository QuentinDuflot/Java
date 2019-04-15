
/**
 * Class Reservation
 * Create a reservation-object with a begin of the reservation and an end
 * Every reservation has a comment
 * Each reservation is related to an employee who reserved it
 * @author marie-louwechsler/Quentin Duflot
 * @version 1.1
 */

public class Reservation {
	private String comment;
	private Time start;
	private Time end;
	private Employee employee;
	
	/**
	 * @param startG start time of the reservation
	 * @param endG end time of the reservation (end > start)
	 * @param commentG String subject of the reservation
	 * @param employeeG employee who is reserving the room
	 * @param roomG room to reserve
	 * @throws ReservationException 
	 */
	public Reservation(Time startG, Time endG, String commentG, Room roomG) throws ReservationException {
		ReservationException.endBeforeStart(startG, endG);
		
		this.start = startG;
		this.end = endG;
		this.comment = commentG;

	}
	
	/**
	 * @param commentG course
	 */
	public void setComment(String commentG) {
		this.comment = commentG;
	}
	
	/**
	 * @param employeeG who reserves
	 */
	public void setEmployee(Employee employeeG) {
		this.employee = employeeG;
	}
	
	/**
	 * @param roomG to reserve
	 */
	public void setRoom(Room roomG) {
	}

	public String getComment() {
		return comment;
	}

	public Time getStart() {
		return start;
	}

	public Time getEnd() {
		return end;
	}

	public Employee getEmployee() {
		return employee;
	}

	/* Methods */
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Gebucht von");
		sb.append(employee);
		sb.append(" von ").append(start);
		sb.append(" bis ").append(end);
		sb.append(" für ").append(comment).append('\'');
		return sb.toString();
	}
}