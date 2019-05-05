import java.util.Arrays;

/**
 * NumberCruncherSuperClass that implements the NumberCruncher interface
 * @author Quentin Duflot/ Marie-Lou Wechsler
 * @version 05/05/2019
 */
public class NumberCruncherSuperClass implements NumberCruncher {

    //Attributes
    private int groesse;
    private float[] array;

    /**
     * Constructor with 1 parameter
     * Array is set with random floats
     * @param groesse size of the array
     */
    public NumberCruncherSuperClass(int groesse) {
        this.groesse = groesse;
        this.array = new float[groesse];
        for (int i = 0; i < groesse; i++) {
            this.array[i] = (float) Math.random();
        }
    }

    /**
     *Crunch-method
     * Do different operations on an array
     * @param operations array of String that contains the operations to do
     */
    @Override
    public void crunch(String[] operations) {

    }

    //Getters & Setters
    /**
     *
     * @return size of the array
     */
    @Override
    public int getGroesse() {
        return groesse;
    }

    /**
     *
     * @return array of random float
     */
    @Override
    public float[] getArray() {
        return array;
    }

    /**
     *
     * @param groesse size of the array
     */
    @Override
    public void setGroesse(int groesse) {
        this.groesse = groesse;
    }

    /**
     *
     * @param array array of floats
     */
    @Override
    public void setArray(float[] array) {
        this.array = array;
    }

    /**
     *
     * @return array of floats in a String representation
     */
    @Override
    public String toString() {
        return  Arrays.toString(array);
    }
}
