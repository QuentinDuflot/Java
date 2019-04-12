
/**
 * Eine Einfache Mitarbeiter-Klasse, die von der Person-Klasse erbt
 *
 * @author Quentin
 * @version 10/04//2019
 */
import java.util.regex.*;
public class Mitarbeiter extends Person
{
    //Meldungskonstanten

    private static final String EMAIL_UNGUELTIG = "Ihre EMail-Adresse ist ungültig !";
    private static final String INVALID_RAUM_FEHLER = "Die angegebene Raum ist ungültig !";

    //Konstanten
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    //Insensitive ==> This == this == ThIs usw..
    // \\. to have '.' as a non regex

    //Attribute

    private String eMail;
    //Konstruktor

    public Mitarbeiter(String name, String vorname, String eMail) {
        super(name, vorname);
        check(validateEMail(eMail),EMAIL_UNGUELTIG);
        this.eMail = eMail;
    }


    //Weitere Methoden

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

        check(raum != null, INVALID_RAUM_FEHLER);
        Reservierung res = new Reservierung(bez,beginn,ende);
        raum.addReservierung(res);
        Mitarbeiter mitarbeiter = new Mitarbeiter(super.getName(),super.getVorname(),this.eMail);
        res.setMitarbeiter(mitarbeiter);
    }

    /**
     * Methode, um zu wissen, ob eine Email-Addresse gültig ist
     * @param email String angegebene Email-Adresse
     * @return boolean, true wenn es gültig und false wenn nicht
     */
    public static boolean validateEMail(String email) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(email);
        return matcher.find();
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
