
/**
 * Eine Einfache Person Oberklasse
 *
 * @author Quentin Duflot
 * @version 10/04/2019
 */
public class Person
{
    //Konstanten
    private static final String NAME_LEER_FEHLER = "Der Name darf nicht leer sein";
    private static final String VORNAME_LEER_FEHLER = "Der Vorname darf nicht leer sein";

    //Attribute
    private String name;
    private String vorname;

    //Konstruktoren

    /**
     * Einfache Konstruktor mit zwei Parameter
     *
     * @param name String ist der Name der Person, darf nicht leer sein
     * @param vorname String ist der Vorname der Person, darf nicht leer sein
     */
    public Person(String name, String vorname) {
        setName(name);
        setVorname(vorname);
    }

    //Weitere Methoden

    /**
     * Einfache Check-Methode
     *
     * @param bedingung Bedingung, die man überprüfen möchtet
     * @param msg Fehler-Message
     */
    public static void check(boolean bedingung, String msg) {
        if (!bedingung)
            throw new IllegalArgumentException(msg);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        check(name != "", NAME_LEER_FEHLER);
        this.name = name;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        check(vorname != "", VORNAME_LEER_FEHLER);
        this.vorname = vorname;
    }

    /**
     *
     * @return String mit name vorname unsere Person
     */
    @Override
    public String toString() {
        return name +
                " " + vorname;
    }
}
