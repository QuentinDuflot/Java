
/**
 * Einfache QueueDialog-Klasse zum Testen unsere Programm
 *
 * @author Quentin Duflot/ Marie-Lou Wechsler
 * @version 05/05/2019
 */

import java.util.*;

public class QueueDialog
{
    //Konstanten
    private static final String MENUE_FEHLER = "Falsche Funktion \n";
    private static final String TYP_QUEUE_FEHLER ="Es ist nur moeglich eine Queue von Typ String(s)" + 
        " oder von Typ Person(p) zu erzeugen";
    private static final String TYPE_STRING_FEHLER_MELDUNG =
        "Aktuelle Queue ist eine StringQueue und nicht eine PersonQueue";
    private static final String TYPE_PERSON_FEHLER_MELDUNG =
        "Aktuelle Queue ist eine PersonQueue und nicht eine StringQueue";
    private static final int ADD_LAST = 1;
    private static final int REMOVE_FIRST = 2;
    private static final int QUEUE_ANZEIGEN = 3;
    private static final int ENDE = 0;
    private static final char STRING_QUEUE = 's';
    private static final char PERSON_QUEUE = 'p';

    //Attribute
    private Scanner input;
    private Queue queue1;

    //Konstruktor
    /**
     * Standard-Konstruktor des Dialogs
     */
    public QueueDialog(char typQueue)
    {
        input = new Scanner(System.in);

        if(typQueue == STRING_QUEUE)
        {
            queue1 = new StringQueue();
        }
        else if(typQueue == PERSON_QUEUE)
        {
            queue1 = new PersonQueue();
        }
        else
        {
            throw new InputMismatchException(TYP_QUEUE_FEHLER);
        }
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
        if( !queue1.empty())
        {
            System.out.println("Aktuel Inhalt Ihrer Queue : \n " +
                queue1 + "\n");
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
            ADD_LAST +
            ": Ein Element am Ende der Queue hinzufuegen \n" +
            REMOVE_FIRST +
            ": Erste Element der Queue loeschen \n" +
            QUEUE_ANZEIGEN +
            ": Alle Elementen der Queue anzeigen \n" +
            ENDE +
            ": Ende des Programms \n");
        funktion = input.nextInt();
        input.nextLine();
        return funktion;
    }

    /**
     * Ausfuehren der ausgewaehlten Funktion
     * 
     * @param die auszufuehrende Funktion als ganze Zahl
     */
    private void ausfuehrenFunktion(int funktion)
    {
        Object save;

        switch(funktion)
        {
            case ADD_LAST:
            queue1.addLast(elementLesen());
            break;

            case REMOVE_FIRST:
            save = queue1.removeFirst();
            System.out.println("Der Element " + save +
                " wurde geloescht \n");
            break;

            case QUEUE_ANZEIGEN:
            print(queue1);
            break;

            case ENDE:
            System.out.println("Programmende\n");
            break;

            default:
            System.out.println(MENUE_FEHLER);
            break;
        }
    }

    /**
     * Methode um alle Elementen einer Queue zu schreiben
     */
    public void print(Queue q)
    {
        if(!q.empty())
        {
            q.print();
            
        }
        else
        {
            System.out.println("Diese Queue ist leer !");
        }

    }

    /**
     * Eine Methode, um entweder einen String oder einen Personn zu lesen
     * 
     * @return typ ein Objekt vom Typ String oder Person
     */
    private Object elementLesen()
    {
        Object newObject = null;
        String name, vorname;

        if(queue1 instanceof StringQueue)
        {
            newObject = new String( readlnString(input, "\n Geben Sie " +
                    "einen String ein : "));
        }

        else 
        {

            name = readlnString(input, "\n Geben Sie der Name der Person ein :");
            vorname = readlnString(input, "\n Geben Sie der Vorname der Person ein :");

            newObject = new Person(name,vorname);

        }
        return newObject;
    }

    /**
     * gibt eine Eingabeaufforderungs-Text aus und
     * liest aus einem Eingabestrom die ganze Zeile als Zeichenkette ( String )
     *  bis zum Zeilenende
     *
     *  @param  in der zu lesende Eingabestrom
     *  @param  eingabeAufforderung der Eingabe-Aufforderungs-Text
     *  @return den eingegebenen String == ganze Zeile
     */
    public static String readlnString(Scanner in, String eingabeAufforderung)
    {
        System.out.print( eingabeAufforderung );
        String zeile = in.nextLine();
        return zeile;
    }

    /**
     * gibt eine Eingabeaufforderungs-Text aus und
     * liest aus einem Eingabestrom genau das erste Zeichen ( Char )
     * und ueberliest bis zum Zeilenende alle weiteren Zeichen
     *
     *  @param  in der zu lesende Eingabestrom
     *  @param  eingabeAufforderung der Eingabe-Aufforderungs-Text
     *  @return das eingegebene Zeichen ( char )
     */
    public static char readlnChar(Scanner in, String eingabeAufforderung)
    {
        System.out.print( eingabeAufforderung );
        String zeile = in.nextLine();
        char zeichen = zeile.toCharArray()[0];
        return zeichen;
    }

    public static void main(String[] args)
    {
        char choice = ' ';
        while((choice != 's') && (choice != 'p'))
        {
            choice = readlnChar(new Scanner(
                    System.in),"Welche Typ von Queue moechten Sie herstellen ?\n"
                +"\t StringQueue --> " + STRING_QUEUE +
                "\n\t PersonQueue --> " + PERSON_QUEUE + "\n");
            try
            {
                QueueDialog dialog = new QueueDialog(choice);
                dialog.start(); 
            } catch (InputMismatchException e) {
                System.out.println(e);
            }
        }

    }
}

