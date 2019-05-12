/**
 * NumberCruncherTopLevel class that extends the NumberCruncherSuperClass
 * Operations of the crunch-method are implemented with top-level classes
 * @author Quentin Duflot/ Marie-Lou Wechsler
 * @version 05/05/2019
 */
public class NumberCruncherTopLevel extends NumberCruncherSuperClass {

    //Attributes
    private Divide divide;
    private Swirl swirl;
    private Sum sum;
    private Substract substract;
    private Average average;

    /**
     *Constructor with 1 parameter
     * Initialise an array of random floats but also the different top-level classes needed
     * @param groesse size of the array
     * @throws SizeArrayNegative 
     */
<<<<<<< HEAD
    public NumberCruncherTopLevel(int groesse) throws SizeArrayNegative {
=======
    public NumberCruncherTopLevel(int groesse) throws SizeArrayNegative{
>>>>>>> 18412a3c7217cb5107c3fcaff3b7446b93a1a52e
        super(groesse);
        this.divide = new Divide(super.getArray(),super.getGroesse());
        this.swirl = new Swirl(super.getArray(),super.getGroesse());
        this.sum = new Sum(super.getArray(),super.getGroesse());
        this.substract = new Substract(super.getArray(),super.getGroesse());
        this.average = new Average(super.getArray(),super.getGroesse());
    }

    /**
     * crunch method
     * possible operations are sum, swirl, divide, subtract and average
     * @param operations array of String that contains the operations to do
     */
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
<<<<<<< HEAD
=======
           

>>>>>>> 18412a3c7217cb5107c3fcaff3b7446b93a1a52e
        }
    }
}