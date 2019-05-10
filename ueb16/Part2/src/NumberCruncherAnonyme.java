import java.util.Random;
import java.util.Arrays;

/**
 * NumberCruncherAnonyme class that extends the NumberCruncherSuperClass
 * Operations of the crunch-method are implemented with anonymous classes
 * @author Quentin Duflot/ Marie-Lou Wechsler
 * @version 05/05/2019
 */
public class NumberCruncherAnonyme extends NumberCruncherSuperClass{


    /**
     * Constructor with 1 parameter
     * Array is set with random floats
     * @param groesse size of the array
     */
    public NumberCruncherAnonyme(int groesse) throws SizeArrayNegative {
        super(groesse);
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
                	Operation sum = new Operation() {
                        @Override
                		public void doOperation() {
                			for(int i = 1; i < NumberCruncherAnonyme.super.getGroesse(); i++) {
                				NumberCruncherAnonyme.super.getArray()[i] =
                                        NumberCruncherAnonyme.super.getArray()[i - 1] + NumberCruncherAnonyme.super.getArray()[i];
                			}
                		}
                	};
                	sum.doOperation();
                    break;
                case "swirl":
                	Operation swirl = new Operation() {
                        @Override
                		public void doOperation() {
                			Random randomNumber = new Random();
                			for(int i = 1; i < NumberCruncherAnonyme.super.getGroesse(); i++) {
                                NumberCruncherAnonyme.super.getArray()[randomNumber.nextInt(NumberCruncherAnonyme.super.getGroesse())] =
                                        NumberCruncherAnonyme.super.getArray()[randomNumber.nextInt(NumberCruncherAnonyme.super.getGroesse())];
                			}
                		}
                	};
                	swirl.doOperation();
                    break;
                case "divide":
                	Operation divide = new Operation() {

                        @Override
                        public void doOperation() {
                            Arrays.sort(NumberCruncherAnonyme.super.getArray());
                            for(int i = 0; i < NumberCruncherAnonyme.super.getGroesse()/2; i++) {
                                NumberCruncherAnonyme.super.getArray()[NumberCruncherAnonyme.super.getGroesse()-i-1] /=
                                        NumberCruncherAnonyme.super.getArray()[i];
                            }
                        }
                    };
                    divide.doOperation();
                    break;
                case "subtract":
                    Operation sub = new Operation() {
                        @Override
                        public void doOperation() {
                            for(int i = 1; i < NumberCruncherAnonyme.super.getGroesse(); i++) {
                                NumberCruncherAnonyme.super.getArray()[i] =
                                        NumberCruncherAnonyme.super.getArray() [i-1] - NumberCruncherAnonyme.super.getArray()[i];
                            }
                        }
                    };
                    sub.doOperation();
                    break;
                case "average":
                    Operation avg = new Operation() {
                        @Override
                        public void doOperation() {
                            float average = NumberCruncherAnonyme.super.getArray()[0];
                            float biggestValue = NumberCruncherAnonyme.super.getArray()[0];
                            int position = 0;

                            for (int i = 1; i < NumberCruncherAnonyme.super.getGroesse(); i++) {
                                average += NumberCruncherAnonyme.super.getArray()[i];
                                if (NumberCruncherAnonyme.super.getArray()[i] > biggestValue) {
                                    biggestValue = NumberCruncherAnonyme.super.getArray()[i];
                                    position = i;
                                }
                            }
                            average /= NumberCruncherAnonyme.super.getGroesse();
                            NumberCruncherAnonyme.super.getArray()[position] = average;
                        }
                    };
                    avg.doOperation();
                    break;
                    default:
                        System.out.println("Falsche Operation: " + operations[counter]);
            }
            

        }
    }
}