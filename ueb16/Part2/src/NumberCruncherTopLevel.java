public class NumberCruncherTopLevel extends NumberCruncherSuperClass{

    private Divide divide;
    private Swirl swirl;
    private Sum sum;
    private Substract substract;
    private Average average;

    public NumberCruncherTopLevel(int groesse) {
        super(groesse);
        this.divide = new Divide(super.getArray(),super.getGroesse());
        this.swirl = new Swirl(super.getArray(),super.getGroesse());
        this.sum = new Sum(super.getArray(),super.getGroesse());
        this.substract = new Substract(super.getArray(),super.getGroesse());
        this.average = new Average(super.getArray(),super.getGroesse());
    }

    public void crunch(String[] operations) {
        for(int counter = 0; counter < operations.length; counter++) {
            switch (operations[counter]) {
                case "sum":
                    sum.doOperation();
                    this.sum = new Sum(super.getArray(),super.getGroesse());
                    break;
                case "swirl":
                    swirl.doOperation();
                    this.swirl = new Swirl(super.getArray(),super.getGroesse());
                    break;
                case "divide":
                    divide.doOperation();
                    this.divide = new Divide(super.getArray(),super.getGroesse());
                    break;
                case "subtract":
                    substract.doOperation();
                    this.substract = new Substract(super.getArray(),super.getGroesse());
                    break;
                case "average":
                    average.doOperation();
                    this.average = new Average(super.getArray(),super.getGroesse());
                    break;
                default:
                    System.out.println("Falsche Operation");
            }
        }
    }
}