/**
 * OperationsSuperClass that implements the Operation interface
 */
public class OperationSuperClass implements Operation{

    //Attributes
    private float[] array;
    private int groesse;

    /**
     * Constructor
     *
     * @param array array of float on which the operation is done
     * @param groesse size of the array
     */
    public OperationSuperClass(float[] array, int groesse) {
        this.array = array;
        this.groesse = groesse;
    }

    /**
     * doOperation method
     * Method that do an operation on our array
     */
    @Override
    public void doOperation() {

    }

    //Getters & Setters

    /**
     *
     * @return an array of float
     */
    public float[] getArray() {
        return array;
    }

    /**
     *
     * @return size of the array
     */
    public int getGroesse() {
        return groesse;
    }

    /**
     *
     * @param array new array of float
     */
    public void setArray(float[] array) {
        this.array = array;
    }

    /**
     *
     * @param groesse new size of the array
     */
    public void setGroesse(int groesse) {
        this.groesse = groesse;
    }
}
