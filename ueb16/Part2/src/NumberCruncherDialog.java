
import java.util.InputMismatchException;
import java.util.Scanner;
import javax.management.OperationsException;

/**
 * NumberCruncherDialog is a dialog class that permits
 * the tests of NumberCruncherAnonym and NumberCruncherTopLevel
 * @author Quentin Duflot/ Marie-Lou Wechsler
 * @version 05/05/2019
 */
public class NumberCruncherDialog {

    //Constants
    //Exceptions messages
    private static final String TYP_CRUNCHER_EX = "Es ist nur möglich ein cruncher vom Typ anonym (a) " +
            "or top level (t) zu erzeugen !\n";

    //Menu constants
    private static final char ANONYME_CRUNCHER = 'a';
    private static final char TOP_LEVEL_CRUNCHER = 't';

    private static final String AVERAGE = "average";
    private static final String  DIVIDE = "divide";
    private static final String SUBTRACT = "subtract";
    private static final String  SUM = "sum";
    private static final String  SWIRL = "swirl";

    //Messages constants
    private static final String AVERAGE_DESC = ":  Bestimmt den Durchschnitt aller Werte im Array \n";
    private static final String DIVIDE_DESC = ":  Teilt die n/2 größten Werte im Array durch die n/2 Kleinsten und speichert den neuen " +
            "Wert im Datenfeld des jeweils größeren Wertes \n";
    private static final String SUBTRACT_DESC = ":  Substriert die Elemente des Arrays " +
            "paarweise von links nach rechts auf\n";
    private static final String SUM_DESC = ": Summiert die Elemente des Arrays paarweise von " +
            "links nach rechts auf\n";
    private static final String SWIRL_DESC = ": Führt n zufällige Vertauschungen " +
            "der Datenfelder durch; n ist durch die Länge des" +
            "float-Arrays gegeben\n";
    private static final String TYP_OP_MSG = "Welche Operation möchten Sie durchführen ?\n";
    private static final String NB_OP_TO_EX = "Wie viele Operationen möchten Sie durchführen ? \n";

    //Attributes
    private Scanner input;
    private NumberCruncher numberCruncher;

    /**
     * Constructor of NumberCruncherDialog
     *
     * @param typCruncher typ of cruncher (a == anonymous t == top-level)
     * @param groesse size of the array
     */
    public NumberCruncherDialog(char typCruncher, int groesse)throws SizeArrayNegative{

        input = new Scanner(System.in);

        if (typCruncher == ANONYME_CRUNCHER) {
            numberCruncher = new NumberCruncherAnonyme(groesse);
        }else if (typCruncher == TOP_LEVEL_CRUNCHER){
            numberCruncher = new NumberCruncherTopLevel(groesse);
        }else {
            throw new InputMismatchException(TYP_CRUNCHER_EX);
        }
    }

    /**
     * read-method that reads the operations given by the user
     * @param nbOp number of operation that must be executed
     * @return String-array with all the operations
     */
    private String[] readOperations(int nbOp){
        String[] operations = new String[nbOp];


        System.out.print(
                AVERAGE + AVERAGE_DESC +
                DIVIDE + DIVIDE_DESC +
                SUBTRACT + SUBTRACT_DESC +
                SUM + SUM_DESC +
                SWIRL + SWIRL_DESC
        );

        for (int i = 0; i < nbOp; i++)
        {
            operations[i] = readlnString(input,TYP_OP_MSG);
        }
        return operations;
    }

    /**
     * execute all the operations
     * @param operations String-array with all the operations
     */
    private void executeFunction(String[] operations){

        numberCruncher.crunch(operations);

    }

    /**
     * start method with try-catch
     * @param nbOP number of operations
     */
    public void start(int nbOP){

        try {

            executeFunction(readOperations(nbOP));

        } catch (IllegalArgumentException e) {
        System.out.println("Ausnahme gefangen: " + e);
        input.next();

        } catch (InputMismatchException e) {
        System.out.println(e);
        input.next();

        }catch (RuntimeException e) {
        System.out.println(e);
        input.next();

        } catch (Exception e) {
        System.out.println("Ausnahme gefangen: " + e);
        e.printStackTrace(System.out);

        }
        if (numberCruncher.getArray().length != 0 && numberCruncher.getArray() != null)
        {
            System.out.println("Inhalt des Arrays : \n" +
                    numberCruncher + "\n");
        }

    }

    /**
     * main-method
     * @param args
     */
    public static void main(String[] args)throws NumberOperationsNegative, SizeArrayNegative{

    char choice = ' ';
        int nbOp = readlnInt(new Scanner(
                System.in), NB_OP_TO_EX);
        NumberOperationsNegative.cannotBeNegative(nbOp);
        while((choice != ANONYME_CRUNCHER) && (choice != TOP_LEVEL_CRUNCHER))
        {
            choice = readlnChar(new Scanner(
                    System.in),"Welche Typ von NumberCruncher möchten Sie herstellen ?\n"
                    +"\t NumberCruncherAnonyme --> " + ANONYME_CRUNCHER +
                    "\n\t NumberCruncherTopLevel --> " + TOP_LEVEL_CRUNCHER + "\n");
            try
            {
                NumberCruncherDialog dialog = new NumberCruncherDialog(choice,nbOp);
                dialog.start(nbOp);
            } catch (InputMismatchException e) {
                System.out.println(e);
            }
        }

    }

    //Helpers

    /**
     * Read a String
     * @param in
     * @param eingabeAufforderung
     * @return a String given by the user
     */
    public static String readlnString(Scanner in, String eingabeAufforderung)
    {
        System.out.print( eingabeAufforderung );
        String zeile = in.nextLine();
        return zeile;
    }

    /**
     * read a character
     * @param in
     * @param eingabeAufforderung
     * @return a char given by the user
     */
    public static char readlnChar(Scanner in, String eingabeAufforderung)
    {
        System.out.print( eingabeAufforderung );
        String zeile = in.nextLine();
        char zeichen = zeile.toCharArray()[0];
        return zeichen;
    }


    /**
     * read an integer
     * @param in
     * @param eingabeAufforderung
     * @return an int given by the user
     */
    public static int readlnInt(Scanner in, String eingabeAufforderung)
    {
        System.out.print( eingabeAufforderung );
        int integer = in.nextInt();
        return integer;
    }


}
