/**
 * NumberCruncher interface
 * @author Quentin Duflot/ Marie-Lou Wechsler
 * @version 05/05/2019
 */
public interface NumberCruncher {

    /**
     *Crunch-method
     * Do different operations on an array
     * @param operations array of String that contains the operations to do
     */
    void crunch(String[] operations);

    //Getters & Setters
    /**
     *
     * @return size of the array
     */
    int getGroesse();

    /**
     *
     * @return array of random float
     */
    float[] getArray();

    /**
     *
     * @param groesse size of the array
     */
    void setGroesse(int groesse);

    /**
     *
     * @param array array of floats
     */
    void setArray(float[] array);

    String toString();
}
