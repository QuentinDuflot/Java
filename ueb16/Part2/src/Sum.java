public class Sum extends Operation{
    float[] array;
    int groesse;

    public Sum(float[] array, int groesse){

        this.array = array;
        this.groesse = groesse;
    }
    @Override
    public void doOperation() {
        for(int i = 1; i < groesse; i++)
        {
            array[i] = array [i-1] - array[i];
        }

    }
}
