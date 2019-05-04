
public class Average extends OperationSuperClass{


	public Average(float[] array, int groesse){

		super(array,groesse);
	}

	@Override
	public void doOperation() {
		float average = 0;
		for(int i = 0; i < super.getGroesse(); i++) {
			average += super.getArray()[i];
		}
		average /= super.getGroesse();
		super.getArray()[searchBiggestValueIndex(super.getArray())] = average;
	}
	
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