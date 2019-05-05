import java.util.Random;

/**
 * Swirl class that extends of OperationSuperClass
 * Performs n random permutations of the data fields; n is equal to the length of the
 * float arrays.
 */
public class Swirl extends OperationSuperClass{

    //Attributes
    Random random;
    /**
     * Constructor
     * @param array array of floats
     * @param groesse size of the array
     */
    public Swirl(float[] array, int groesse){

        super(array,groesse);
        random = new Random();
    }

    /**
     * Performs n random permutations of the data fields; n is equal to the length of the
     * float arrays.
     */
    @Override
    public void doOperation() {
        int random1, random2;
        float save;
        for (int i = 0; i < super.getGroesse(); i++) {
            random1 = random.nextInt(super.getGroesse());
            random2 = random.nextInt(super.getGroesse());
            save = super.getArray()[random1];
            super.getArray()[random1] = super.getArray()[random2];
            super.getArray()[random2] = save;
        }
    }
}