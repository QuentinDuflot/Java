public class NumberCruncherTopLevel {
    private int groesse;
    private float[] array;
    private Divide divide;
    private Swirl swirl;
    private Sum sum;
    private Substract substract;
    private Average average;

    public NumberCruncherTopLevel(int groesse) {
        this.groesse = groesse;
        this.array = new float[groesse];
        for(int i = 0; i < groesse; i++) {
            this.array[i] =  (float)Math.random();
        }
        this.divide = new Divide(array,groesse);
        this.swirl = new Swirl(array,groesse);
        this.sum = new Sum(array,groesse);
    }

    public void crunch(String[] operations) {
        for(int counter = 0; counter < operations.length; counter++) {
            switch (operations[counter]) {
                case "sum":
                    sum.doOperation();
                    break;
                case "swirl":
                    swirl.doOperation();
                    break;
                case "divide":
                    divide.doOperation();
                    break;
                case "subtract":
                    substract.doOperation();
                    break;
                case "average":
                    average.doOperation();
                    break;
                default:
                    System.out.println("Falsche Operation");
            }
        }
    }
}