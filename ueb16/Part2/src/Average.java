/**
 * Average class that extends OperationSuperClass
 * Determines the average of all values in the array and stores the average value.
 * in the data field with the largest value.
 */
public class Average extends OperationSuperClass{


	/**
	 *Constructor
	 * @param array array of floats
	 * @param groesse size of the array
	 */
	public Average(float[] array, int groesse){

		super(array,groesse);
	}

	/**
	 * Determines the average of all values in the array and stores the average value.
	 * in the data field with the largest value.
	 */
	@Override
	public void doOperation() {
		float average = 0;
		for(int i = 0; i < super.getGroesse(); i++) {
			average += super.getArray()[i];
		}
		average /= super.getGroesse();
		super.getArray()[searchBiggestValueIndex(super.getArray())] = average;
	}

	/**
	 *Search for the index of the biggest value in a float array
	 * @param array array of floats
	 * @return the index of the biggest value
	 */
	private int searchBiggestValueIndex(float[] array) {
		int index = 0;
		float indexValue = array[index];
		
		for(int i = 0; i < super.getGroesse(); i++) {
			if(array[i] > indexValue) {
				indexValue = array[i];
				index = i;
			}
		}
		
		return index;
	}
}