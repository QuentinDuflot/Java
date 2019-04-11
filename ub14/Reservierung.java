
/**
 * Eine Reservierung-Klasse
 *
 * Enthält eine Bemerkung und eine bestimmte Zeitraum
 *
 * @author Quentin Duflot
 * @version 10/04/2019
 */
public class Reservierung
{
    //Konstanten
    private static final String BEMERKUNG_LEER_FEHLER = "Es muss eine Bemerkung stehen !";
    private static final String BEGINN_NULL_FEHLER = "Die Beginnstunde ist null !";
    private static final String ENDE_NULL_FEHLER = "Die Endestunde ist null !";
    private static final String ENDE_VOR_BEGINN_FEHLER = "Die Endestunde befindet sich vor die Beginnstunde !";

    //Attribute
    private String bemerkung;
    private Uhrzeit beginn;
    private Uhrzeit ende;

    //Konstruktoren

    public Reservierung(String bemerkung, Uhrzeit beginn, Uhrzeit ende) {
        check(bemerkung != "", BEMERKUNG_LEER_FEHLER);
        check(beginn != null, BEGINN_NULL_FEHLER);
        check(ende != null, ENDE_NULL_FEHLER);
        checkEndeNachBeginn(beginn, ende);
        this.bemerkung = bemerkung;
        this.beginn = beginn;
        this.ende = ende;
    }


    //Weitere Methoden

    /**
     * Eine Methode, die überprüft, ob Endestunde vor die Beginnstunde steht
     * Werft eine Ausnahme, wenn es der Fall ist
     *
     * @param beginn Beginnstunde als Uhrzeit
     * @param ende Endestunde als Uhrzeit
     */
    private static void checkEndeNachBeginn(Uhrzeit beginn, Uhrzeit ende){
        if(ende.getStunde() == beginn.getStunde()){
            check(ende.getMinute() > beginn.getStunde(), ENDE_VOR_BEGINN_FEHLER);
        }
        check(ende.getStunde() > beginn.getStunde(), ENDE_VOR_BEGINN_FEHLER);
    }

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

    public String getBemerkung() {
        return bemerkung;
    }

    public void setBemerkung(String bemerkung) {
        this.bemerkung = bemerkung;
    }

    public Uhrzeit getBeginn() {
        return beginn;
    }

    public void setBeginn(Uhrzeit beginn) {
        this.beginn = beginn;
    }

    public Uhrzeit getEnde() {
        return ende;
    }

    public void setEnde(Uhrzeit ende) {
        this.ende = ende;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("gebucht von");
        sb.append(" von ").append(beginn);
        sb.append(" bis ").append(ende);
        sb.append(" für ").append(bemerkung).append('\'');
        return sb.toString();
    }
}
