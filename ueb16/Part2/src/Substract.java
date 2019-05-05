/**
 * Subtract class that extends of OperationSuperClass
 * Substitutes the elements of the array in pairs from left to right and saves them as
 * the new value in the right-hand data field.
 * @author Quentin Duflot/ Marie-Lou Wechsler
 * @version 05/05/2019
 */
public class Substract extends OperationSuperClass{


	/**
	 * Constructor
	 * @param array array of floats
	 * @param groesse size of the array
	 */
	public Substract(float[] array, int groesse){

		super(array,groesse);
	}

	/**
	 * Substitutes the elements of the array in pairs from left to right and saves them as
	 * the new value in the right-hand data field.
	 */
	@Override
	public void doOperation() {
		for(int i = 1; i < super.getGroesse(); i++) {
			super.getArray()[i] = super.getArray()[i - 1] - super.getArray()[i];
		}
	}
}