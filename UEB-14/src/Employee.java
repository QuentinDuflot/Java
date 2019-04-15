
/**
 * Class Employee
 * @author marie-louwechsler/Quentin Duflot
 * @version 1.1
 */

public class Employee extends Person {
	private String email;
	
	/**
	 * @param firstNameG employee first name
	 * @param lastNameG employee last name
	 * @param emailG employee's email
	 * @throws EmployeeException when employee is incorrect
	 * @throws PersonException when name is invalid
	 */
	public Employee(String firstNameG, String lastNameG, String emailG) throws EmployeeException, PersonException {
		super(firstNameG, lastNameG);
		
		EmployeeException.emailRight(emailG);
		this.email = emailG;
	}
	
	/**
	 * @param room to reserve
	 * @param start time
	 * @param end time
	 * @param comment String course
	 * @throws ReservationException 
	 */
	public void reserve(Room room, Time start, Time end, String comment) throws ReservationException {
		Reservation newReservation = new Reservation(start, end, comment, this, room);
		room.addReservation(newReservation);
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder(super.toString());
		sb..append(" (").append(eMail).append(") ");
		return sb.toString();
	}

}