import java.lang.reflect.Array;
import java.util.Arrays;

public class Divide implements Operation {

    float[] array;
    int groesse;

    public Divide(float[] array, int groesse){

        this.array = array;
        this.groesse = groesse;
    }

    @Override
    public void doOperation() {

        Arrays.sort(array);
        for(int i = 0; i < groesse/2; i++)
        {
            array[groesse-i-1] /= array[i];
        }

    }
}
