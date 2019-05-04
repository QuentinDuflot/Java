import java.util.Random;

public class Swirl extends OperationSuperClass{

    Random random = new Random();
    public Swirl(float[] array, int groesse){

        super(array,groesse);
    }

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