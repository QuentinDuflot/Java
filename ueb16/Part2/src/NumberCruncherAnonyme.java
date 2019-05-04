import java.util.Random;
import java.util.Arrays;

public class NumberCruncherAnonyme extends NumberCruncherSuperClass{


    public NumberCruncherAnonyme(int groesse) {
        super(groesse);
    }


    
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
                    break;
                    default:
                        System.out.println("Falsche Operation: " + operations[counter]);
            }

        }
    }
}