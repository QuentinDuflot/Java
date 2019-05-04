import java.util.InputMismatchException;
import java.util.Scanner;

public class NumberCruncherDialog {

    private static final String TYP_CRUNCHER_EX = "Es ist nur möglich ein cruncher vom Typ anonym (a) " +
            "or top level (t) zu erzeugen !";

    private static final char ANONYME_CRUNCHER = 'a';
    private static final char TOP_LEVEL_CRUNCHER = 't';

    private static final int AVERAGE = 1;
    private static final int  DIVIDE = 2;
    private static final int SUBTRACT = 3;
    private static final int  SUM = 4;
    private static final int  SWIRL = 5;
    private static final int EXIT = 0;

    private static final String AVERAGE_DESC = ") Average: Bestimmt den Durchschnitt aller Werte im Array \n";
    private static final String DIVIDE_DESC = ") Divide: Teilt die n/2 größten Werte im Array durch die n/2 Kleinsten und speichert den neuen " +
            "Wert im Datenfeld des jeweils größeren Wertes \n";
    private static final String SUBTRACT_DESC = ") Subtract: Substriert die Elemente des Arrays " +
            "paarweise von links nach rechts auf";
    private static final String SUM_DESC = ") Sum: Summiert die Elemente des Arrays paarweise von " +
            "links nach rechts auf";
    private static final String SWIRL_DESC = ") Swirl: Führt n zufällige Vertauschungen " +
            "der Datenfelder durch; n ist durch die Länge des" +
            "float-Arrays gegeben.";
    private static final String EXIT_DESC = ") Ende des Programms";

    private Scanner input;
    private Operation operation;
    private NumberCruncher numberCruncher;

    public NumberCruncherDialog(char typCruncher, int groesse) {

        input = new Scanner(System.in);

        if (typCruncher == ANONYME_CRUNCHER) {
            numberCruncher = new NumberCruncherAnonyme(groesse);
        }else if (typCruncher == TOP_LEVEL_CRUNCHER){
            numberCruncher = new NumberCruncherTopLevel(groesse);
        }else {
            throw new InputMismatchException(TYP_CRUNCHER_EX);
        }
    }

    private int readFunction(){
        int funktion;

        System.out.print(
                AVERAGE + AVERAGE_DESC +
                DIVIDE + DIVIDE_DESC +
                SUBTRACT + SUBTRACT_DESC +
                SUM + SUM_DESC +
                SWIRL + SWIRL_DESC +
                EXIT + EXIT_DESC
        );

        funktion = input.nextInt();
        input.nextLine();
        return funktion;
    }
}
