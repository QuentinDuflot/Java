
/**
 * Class Employee
 * Extend from Person
 * Create an Employee-object with a first and last name and an email
 * @author marie-louwechsler/Quentin Duflot
 * @version 1.1
 */

public class Employee extends Person {
	private String email;
	
	/**
	 * Constructor
	 *
	 * @param firstNameG employee first name (can't be null)
	 * @param lastNameG employee last name (can't be null)
	 * @param emailG employee's email (can't be null and has to follow the format name@domain.ext)
	 * @throws EmployeeException when employee is incorrect
	 * @throws PersonException when name is invalid
	 */
	public Employee(String firstNameG, String lastNameG, String emailG) throws EmployeeException, PersonException {
		super(firstNameG, lastNameG);
		
		EmployeeException.emailRight(emailG);
		this.email = emailG;
	}
	
	/**
	 * A reserve-method
	 *
	 * @param room room to reserve
	 * @param start start of the reservation
	 * @param end end of the reservation (end > start)
	 * @param comment String subject
	 * @throws ReservationException
	 */
	public void reserve(Room room, Time start, Time end, String comment) throws ReservationException {
		Reservation newReservation = new Reservation(start, end, comment, this, room);
		room.addReservation(newReservation);
		Employee employee = new Employee(super.getFirstName(),super.getLastName(),this.email);
		room.setEmployee(employee);
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