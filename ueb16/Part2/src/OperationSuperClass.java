public class OperationSuperClass implements Operation{

    private float[] array;
    private int groesse;

    public OperationSuperClass(float[] array, int groesse) {
        this.array = array;
        this.groesse = groesse;
    }

    @Override
    public void doOperation() {

    }

    public float[] getArray() {
        return array;
    }

    public int getGroesse() {
        return groesse;
    }

    public void setArray(float[] array) {
        this.array = array;
    }

    public void setGroesse(int groesse) {
        this.groesse = groesse;
    }
}
