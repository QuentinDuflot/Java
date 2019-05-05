import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Divide class that extends of OperationSuperClass
 * Divides the n/2 largest values in the array by the n/2 smallest values and saves the new
 * Value in the data field of the larger value.
 * @author Quentin Duflot/ Marie-Lou Wechsler
 * @version 05/05/2019
 */
public class Divide extends OperationSuperClass{


    /**
     * Constructor
     * @param array array of floats
     * @param groesse size of the array
     */
    public Divide(float[] array, int groesse){

        super(array,groesse);
    }

    /**
     * Divides the n/2 largest values in the array by the n/2 smallest values and saves the new
     * Value in the data field of the larger value.
     */
    @Override
    public void doOperation() {
        Arrays.sort(super.getArray());
        for(int i = 0; i < super.getGroesse()/2; i++) {
            super.getArray()[super.getGroesse()-i-1] /= super.getArray()[i];
        }
    }
}