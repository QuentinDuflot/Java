
import java.util.*;

public class Test {

    //Konstanten
    private static final String MENUE_FEHLER = "Falsche Funktion \n";
    private static final int ENDE = 0;

    //Attribute
    private Scanner input;

    //Konstruktor
    /**
     * Standard-Konstruktor des Dialogs
     */
    public Test()
    {
        input = new Scanner(System.in);

    }

    //Start-Methode
    /**
     * Hauptschleife des Testprogramms
     */
    public void start()
    {
        int funktion = -1;
        while(funktion != ENDE)
        {
            try
            {
                funktion = einlesenFunktion();
                ausfuehrenFunktion(funktion);
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
        }
    }

    /**
     * Menue ausgeben und Funktion einlesen
     *
     * @return eingelesene Funktion als ganzzahliger Wert
     */
    private int einlesenFunktion(){
        int funktion;

        System.out.print(
                        ENDE +
                        ": Ende des Programms \n");
        funktion = input.nextInt();
        input.nextLine();
        return funktion;
    }

    /**
     * Ausfuehren der ausgewaehlten Funktion
     *
     * @param funktion die auszufuehrende Funktion als ganze Zahl
     */
    private void ausfuehrenFunktion(int funktion)
    {
        Object save;

        switch(funktion)
        {


            case ENDE:
                System.out.println("Programmende\n");
                break;

            default:
                System.out.println(MENUE_FEHLER);
                break;
        }
    }


    public static void main(String[] args)
    {


    }
}
