/**
 * Sum class that extends of OperationSuperClass
 * Add the elements of the array in pairs from left to right and stores
 * the new value in the right-hand data field.
 */
public class Sum extends OperationSuperClass{

    /**
     * Constructor
     * @param array array of floats
     * @param groesse size of the array
     */
    public Sum(float[] array, int groesse){

        super(array,groesse);
    }

    /**
     * Add the elements of the array in pairs from left to right and stores
     * the new value in the right-hand data field.
     */
    @Override
    public void doOperation() {
        for(int i = 1; i < super.getGroesse(); i++)
        {
            super.getArray()[i] = super.getArray() [i-1] + super.getArray()[i];
        }

    }
}
