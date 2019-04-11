
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

    private static final String NEG_GEB_FEHLER = "Der Gebaudenummer darf nicht negativ sein !";
    private static final String NEG_ETG_FEHLER = "Der Etagenummer darf nicht negativ sein !";
    private static final String NEG_RAUM_FEHLER = "Der Raumnummer darf nicht negativ sein !";

    //Attribute
    private int geb;
    private int etage;
    private int raum;
    private Reservierung[] reservierungArray;
    private int anzReservierung;


    //Konstruktoren

    public Raum(int geb, int etage, int raum) {
        check(geb > 0, NEG_GEB_FEHLER );
        check(etage > 0, NEG_ETG_FEHLER);
        check(raum > 0, NEG_RAUM_FEHLER);

        this.geb = geb;
        this.etage = etage;
        this.raum = raum;
        this.reservierungArray = new Reservierung[ANZAHL_MOEGLICHE_RESERVIERUNG];
        anzReservierung = 0;
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

    public int getGeb() {
        return geb;
    }

    public int getEtage() {
        return etage;
    }

    public int getRaum() {
        return raum;
    }

    public int getAnzReservierung() {
        return anzReservierung;
    }
}
