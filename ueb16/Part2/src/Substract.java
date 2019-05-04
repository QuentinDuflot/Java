
public class Substract extends OperationSuperClass{


	public Substract(float[] array, int groesse){

		super(array,groesse);
	}
	
	@Override
	public void doOperation() {
		for(int i = 1; i < super.getGroesse(); i++) {
			super.getArray()[i] = super.getArray()[i - 1] - super.getArray()[i];
		}
	}
}