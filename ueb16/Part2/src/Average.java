
public class Average implements Operation {
	float[] array;
	int groesse;
	
	public Average(float[] array, int groesse) {
		this.array = array;
		this.groesse = groesse;
	}
	
	@Override
	public void doOperation() {
		float average = 0;
		for(int i = 0; i < groesse; i++) {
			average += array[i];
		}
		average /= groesse;
		array[searchBiggestValueIndex(array)] = average;
	}
	
	public int searchBiggestValueIndex(float[] array) {
		int index = 0;
		float indexValue = array[index];
		
		for(int i = 0; i < groesse; i++) {
			if(array[i] > indexValue) {
				indexValue = array[i];
				index = i;
			}
		}
		
		return index;
	}
}