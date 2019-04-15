
/**
 * Class Reservation
 * @author marie-louwechsler/Quentin Duflot
 * @version 1.1
 */

public class Reservation {
	private String comment;
	private Time start;
	private Time end;
	private Employee employee;
	
	/**
	 * @param startG time
	 * @param endG time
	 * @param commentG String course
	 * @param employeeG employee who reserves room
	 * @param roomG to reserve
	 * @throws ReservationException 
	 */
	public Reservation(Time startG, Time endG, String commentG, Employee employeeG, Room roomG) throws ReservationException {
		ReservationException.endBeforeStart(startG, endG);
		
		this.start = startG;
		this.end = endG;
		this.comment = commentG;
		this.employee = employeeG;
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