
/**
 * Eine einfache Uhrzeit-Klasse
 *
 * @author Quentin Duflot
 * @version 09/04/2019
 */
public class Uhrzeit {
    //Konstanten
    private static final String ILLEGAL_STUNDE_ARGUMENT = "Die Stunden muessen zwischen 0 und 23 stehen";
    private static final String ILLEGAL_MINUTE_ARGUMENT = "Die Minuten muessen zwischen 0 und 59 stehen";
    //Attribute
    private int stunde;
    private int minute;

    //Konstruktoren


    /**
     * Konstruktor
     *
     * Stellt ein Uhrzeit-Objekt
     *
     * @param stunde gibt die Stunde an (muss zwischen 0 und 23 sein)
     * @param minute gibt die Minuten an (mussen zwischen 0 und 59 sein)
     */
    public Uhrzeit(int stunde, int minute) {
        check(stunde >= 0 && stunde < 24 , ILLEGAL_STUNDE_ARGUMENT);
        check(minute >= 0 && minute < 60, ILLEGAL_MINUTE_ARGUMENT);
        this.stunde = stunde;
        this.minute = minute;
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

    public int getStunde() {
        return stunde;
    }

    public int getMinute() {
        return minute;
    }

    /**
     * Einfache toString Methode
     * gibt der Zeit als stunde:minute Uhr
     * @return String mit stunde:minute Uhr
     */

    @Override
    public String toString() {
        return stunde +
                ":" + minute +
                "Uhr";
    }
}
