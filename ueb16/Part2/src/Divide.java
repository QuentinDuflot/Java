import java.lang.reflect.Array;
import java.util.Arrays;

public class Divide extends OperationSuperClass{


    public Divide(float[] array, int groesse){

        super(array,groesse);
    }

    @Override
    public void doOperation() {
        Arrays.sort(super.getArray());
        for(int i = 0; i < super.getGroesse()/2; i++) {
            super.getArray()[super.getGroesse()-i-1] /= super.getArray()[i];
        }
    }
}