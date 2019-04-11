
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
    private static final String TAB_UBERSCHREITEN = "Es ist nicht mehr möglich für dieses Raum zu reservieren !";
    private static final String RES_NULL_FEHLER = "Ihre Reservierung ist nicht vollständig !";

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

    //TODO : find how to add the name of the prof.

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

    /**
     *
     * Eine einfache Methode, um eine Rersierung für unsere Raum hinzufügen
     *
     * @param neueReservierung Die Reservierung, die hingefügt werden muss
     */
    public void addReservierung(Reservierung neueReservierung)
    {
        check(anzReservierung < 50, TAB_UBERSCHREITEN);
        check(neueReservierung != null, RES_NULL_FEHLER);
        reservierungArray[anzReservierung++] = neueReservierung;

    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Raum");
        sb.append(" ")
                .append(geb)
                .append("-")
                .append(etage)
                .append(".")
                .append(raum);
        for (int i = 0; i < anzReservierung; i++){
            sb.append("\n").append(reservierungArray[i]);
        }
        return sb.toString();
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
