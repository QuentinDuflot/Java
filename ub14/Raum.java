
/**
 *
 *Eine Raum-Klasse, die Reservierungen enthält
 *
 * @author Quentin
 * @version 10/04/2019
 */
public class Raum
{
    //Konstanten

    private static final int ANZAHL_MOEGLICHE_RESERVIERUNG = 50;

    //Meldung-Konstanten

    private static final String NEG_GEB_FEHLER = "Das Gebaudenummer darf nicht negativ sein !";
    //Attribute
    private int geb;
    private int etage;
    private int raum;
    private Reservierung[] reservierungArray;


    //Konstruktoren

    public Raum(int geb, int etage, int raum, Reservierung[] reservierungArray) {
        check(geb > 0, NEG_GEB_FEHLER );
        this.geb = geb;
        this.etage = etage;
        this.raum = raum;
        this.reservierungArray = new Reservierung[ANZAHL_MOEGLICHE_RESERVIERUNG];
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

}
