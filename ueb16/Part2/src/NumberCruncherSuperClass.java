public class NumberCruncherSuperClass implements NumberCruncher {
    private int groesse;
    private float[] array;

    public NumberCruncherSuperClass(int groesse) {
        this.groesse = groesse;
        this.array = new float[groesse];
        for (int i = 0; i < groesse; i++) {
            this.array[i] = (float) Math.random();
        }
    }

    @Override
    public void crunch(String[] operations) {

    }

    @Override
    public int getGroesse() {
        return groesse;
    }

    @Override
    public float[] getArray() {
        return array;
    }

    @Override
    public void setGroesse(int groesse) {
        this.groesse = groesse;
    }

    @Override
    public void setArray(float[] array) {
        this.array = array;
    }
}
