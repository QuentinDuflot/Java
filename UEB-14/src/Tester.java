/**
 * Class Tester
 * @author marie-louwechsler
 * @version 1.1
 */

public class Tester {
	public void run() throws TimeException, RoomException, EmployeeException, PersonException {
		testCaseReservation();
	}
	
	public void testCaseReservation() throws TimeException, RoomException, EmployeeException, PersonException {
		Employee e1 = new Employee("Max", "Patterson", "max.patterson@gmail.com");
		Employee e2 = new Employee("Arnold", "King", "arnking89@gmail.com");
		
		Room r1 = new Room(17, 2, 32);
		Room r2 = new Room(10, 1, 100);
		Room r3 = new Room(5, 3, 24);
		
		e1.reserve(r1, new Time(11, 45), new Time(13, 15), "PROG2");
		e1.reserve(r2, new Time(8, 15), new Time(23, 34), "WEB4");
		e2.reserve(r1, new Time(10, 15), new Time(11, 30), "WERK4");
		
		System.out.println(r1);
		System.out.println(r2);
		System.out.println(r3);
	}
	
	public static void main(String[] args) {
		Tester tester = new Tester();
		
		try {
			tester.run();
		} catch (TimeException | RoomException | EmployeeException | PersonException e) {
			System.err.println(e);
		}
	}
}