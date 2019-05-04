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
                    this.sum = new Sum(super.getArray(),super.getGroesse());
                    sum.doOperation();
                    break;
                case "swirl":
                    this.swirl = new Swirl(super.getArray(),super.getGroesse());
                    swirl.doOperation();
                    break;
                case "divide":
                    this.divide = new Divide(super.getArray(),super.getGroesse());
                    divide.doOperation();
                    break;
                case "subtract":
                    this.substract = new Substract(super.getArray(),super.getGroesse());
                    substract.doOperation();
                    break;
                case "average":
                    this.average = new Average(super.getArray(),super.getGroesse());
                    average.doOperation();
                    break;
                default:
                    System.out.println("Falsche Operation: " + operations[counter]);
            }

        }
    }

}