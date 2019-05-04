import java.util.Random;
import java.util.Arrays;

public class NumberCruncherAnonyme {
    private int groesse;
    private float[] array;

    public NumberCruncherAnonyme(int groesse) {
        this.groesse = groesse;
        this.array = new float[groesse];
        for(int i = 0; i < groesse; i++) {
            this.array[i] =  (float)Math.random();
        }
    }
    
    public void crunch(String[] operations) {
        for(int counter = 0; counter < operations.length; counter++) {
            switch (operations[counter]) {
                case "sum":
                	Operation sum = new Operation() {
                        @Override
                		public void doOperation() {
                			for(int i = 1; i < groesse; i++) {
                				array[i] = array[i - 1] + array[i];
                			}
                		}
                	};
                    break;
                case "swirl":
                	Operation swirl = new Operation() {
                        @Override
                		public void doOperation() {
                			Random randomNumber = new Random();
                			for(int i = 1; i < groesse; i++) {
                				array[randomNumber.nextInt(groesse)] = array[randomNumber.nextInt(groesse)]; 
                			}
                		}
                	};
                    break;
                case "divide":
                	Operation divide = new Operation() {

                        @Override
                        public void doOperation() {
                            Arrays.sort(array);
                            for(int i = 0; i < groesse/2; i++) {
                                array[groesse-i-1] /= array[i];
                            }
                        }
                    };
                    break;
                case "subtract":
                    Operation sub = new Operation() {
                        @Override
                        public void doOperation() {
                            for(int i = 1; i < groesse; i++) {
                                array[i] = array [i-1] - array[i];
                            }
                        }
                    };
                    break;
                case "average":
                    Operation avg = new Operation() {
                        @Override
                        public void doOperation() {
                            float average = array[0];
                            float biggestValue = array[0];
                            int position = 0;

                            for (int i = 1; i < groesse; i++) {
                                average += array[i];
                                if (array[i] > biggestValue) {
                                    biggestValue = array[i];
                                    position = i;
                                }
                            }
                            average /= groesse;
                            array[position] = average;
                        }
                    };
                    break;
                    default:
                        System.out.println("Falsche Operation");
            }
        }
    }
}