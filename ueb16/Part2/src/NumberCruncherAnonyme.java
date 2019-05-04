public class NumberCruncherAnonyme {

    private int groesse;
    private float[] array;

    public NumberCruncherAnonyme(int groesse) {
        this.groesse = groesse;
        this.array = new float[groesse];
        for(int i = 0; i < groesse; i++)
        {
            this.array[i] =  (float)Math.random();
        }
    }
}
