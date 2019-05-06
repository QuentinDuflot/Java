<<<<<<< HEAD
public class OperationSuperClass implements Operation {
=======
/**
 * OperationsSuperClass that implements the Operation interface
 * @author Quentin Duflot/ Marie-Lou Wechsler
 * @version 05/05/2019
 */
public class OperationSuperClass implements Operation{
>>>>>>> 24773169211f54dc5e92b9e189e4aa6157d55cd8

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
