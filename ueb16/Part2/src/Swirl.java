import java.util.Random;

public class Swirl implements Operation{

    float[] array;
    int groesse;
    Random random;

    public Swirl(float[] array, int groesse){

        this.array = array;
        this.groesse = groesse;
        this.random = new Random();
    }

    @Override
    public void doOperation() {

        int random1, random2;
        float save;
        for (int i = 0; i < groesse; i++)
        {
            random1 = random.nextInt(groesse);
            random2 = random.nextInt(groesse);
            save = array[random1];
            array[random1] = array[random2];
            array[random2] = save;
        }
    }
}
