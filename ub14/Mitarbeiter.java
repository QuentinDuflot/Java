
/**
 * Eine Einfache Mitarbeiter-Klasse, die von der Person-Klasse erbt
 *
 * @author Quentin
 * @version 10/04//2019
 */
public class Mitarbeiter extends Person
{
    //Meldungskonstanten

    private static final String MISSING_AT_FEHLER = "Ihre E-Mail braucht ein @ !";
    private static final String MISSING_DOT_FEHLER = "Ihre E-Mail braucht ein '.' !";
    private static final String LEER_EMAIL_FEHLER = "Ihre E-Mail ist leer !";

    //Attribute

    private String eMail;

    //Konstruktor
    //TODO : If time try to check @ and . with regex !

    public Mitarbeiter(String name, String vorname, String eMail) {
        super(name, vorname);
        check(eMail != "", LEER_EMAIL_FEHLER);
        check(eMail.indexOf('@') != -1, MISSING_AT_FEHLER);
        check(eMail.indexOf('.') != -1, MISSING_DOT_FEHLER);
        this.eMail = eMail;
    }


    //Weitere Methode

    /**
     * Einfache Check-Methode
     *
     * @param bedingung Bedingung, die man überprüfen möchtet
     * @param msg Fehler-Message
     */
    private static void check(boolean bedingung, String msg) {
        if (!bedingung)
            throw new IllegalArgumentException(msg);
    }

    public void reserviere(Raum raum, Uhrzeit beginn, Uhrzeit ende, String bez){

    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(super.getVorname());
        sb.append(super.toString()).append(" (").append(eMail).append(") ");
        return sb.toString();
    }

    public String geteMail() {
        return eMail;
    }
}
