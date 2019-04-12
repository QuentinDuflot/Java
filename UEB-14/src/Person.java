
/**
 * Class Person
 * @author marie-louwechsler
 * @version 1.1
 */

public class Person {
	protected String firstName;
	protected String lastName;
	
	/**
	 * @param firstNameG person first name
	 * @param lastNameG person last name
	 * @throws PersonException when name is incorrect
	 */
	public Person(String firstNameG, String lastNameG) throws PersonException {
		PersonException.nameRight(firstNameG);
		PersonException.nameRight(lastNameG);
		
		this.firstName = firstNameG;
		this.lastName = lastNameG;
	}
	
	@Override
	public String toString() {
		return firstName +" "+ lastName;
	}
}