package ex2;


/**
 * eine Klasse Artikel für eine einfache Bestandsführung 
 *
 * @author Quentin Duflot/Arnold Tegninko
 * @version 30.11
 */

public class Artikel
{
        //Konstanten
    private static final int STANDARD_BESTAND = 0;
    private static final int MIN_ARTIKELNR = 1000;
    private static final int MAX_ARTIKELNR = 9999;
    private static final int MIN_ZUGANG = 1;
    private static final int MIN_ABGANG = 1;
    private static final int MIN_BESTAND = 0;
    private static final double MIN_PREIS = 0.0;
    private static final double MIN_PROZENT = -100.0;
    //Meldungs-Konstanten 
    private static final String  ARTIKEL_NUMMER_MELDUNG =
        "Uebergebene Artikelnummer ist ungueltig, " + 
        "da kleiner 1000 oder mehr als 4-Stellig";

    private static final String  BESTANDS_MELDUNG =
        "Uebergebener Bestand ist ungueltig, da kleiner 0 !!!";

    private static final String  BEZEICHNUNGS_MELDUNG =
        "Uebergebene Bezeichnung ist ungueltig, da ein" + 
        " LEER-String o. null-Referenz!";

    private static final String  ZUGANG_NEGATIV_MELDUNG =
        "Uebergebener Zugang ist ungueltig, da negativ (kleiner 0) !!!";

    private static final String  ABGANG_NEGATIV_MELDUNG =
        "Uebergebener Abgang ist ungueltig, da negativ (kleiner 0) !!!";

    private static final String  ABGANG_ZUGROSS_MELDUNG =
        "Uebergebener Abgang Uebersteigt Anzahl der vorraetigen Artikel !!!"; 
    
    private static final String PROZENT_FEHLER_MELDUNG =
        "Uebergegebene Prozentzahl muss > " + MIN_PROZENT + "sein !";
        
    private static final String PREIS_FEHLER_MELDUNG=
        "Der Artikelpreis muss >=" +MIN_PREIS + "sein!";
        

    
    
    //Attribute
    private int artikelnummer;
    private String artikelbezeichnung;
    private int artikelbestand;
    private double preis;
    //Konstruktoren
        /**
     * Konstruktor einen Artikel-Objekt mit 4 Parameter
     * @param1 (int) ein 4-stellig Artikelnummer 
     * @param2 (String) ein Artikelbezeichnung != null
     * @param3 (int) ein Artikelbestand >= 0
     * @param4 (double) ein Preis >=0 
     */
    public Artikel(int artikelnummer, String artikelbezeichnung, 
                    int artikelbestand, double preis)
    {
        check(artikelnummer >= MIN_ARTIKELNR && artikelnummer <= MAX_ARTIKELNR,
        ARTIKEL_NUMMER_MELDUNG);
        check(artikelbestand >= 0, BESTANDS_MELDUNG);
        check(preis >= 0, PREIS_FEHLER_MELDUNG);
        
        this.artikelnummer=artikelnummer;
        setArtikelbezeichnung(artikelbezeichnung);
        this.artikelbestand = artikelbestand;
        this.preis = preis;
    }

    /**
     * Konstruktor einen Artikel-Objekt mit 2 Parameter
     * @param1 (int) ein Artikelnummer >  0
     * @param2 (String) ein Artikelbezeichnung != null
     */
    public Artikel(int artikelnummer, String artikelbezeichnung)
    {
        this(artikelnummer, artikelbezeichnung, 
        STANDARD_BESTAND, MIN_PREIS);
    }
    
    //get/set Methoden
    
    /**
     * Eine get-Methode zum Artikelnummer
     * @return den Artikelnummer (int)
     */
    public int getArtikelnummer()
    {
        return artikelnummer;
    }

    /**
     * Eine get-Methode zur Artikelbezeichnung
     * @return die Artikelbezeichnung (String)
     */
    public String getBezeichnung()
    {
        return artikelbezeichnung;
    }

    /**
     * Eine get-Methode zum Artikelbestand
     * @return das Bestand (int)
     */
    public int getBestand()
    {
        return artikelbestand;
    }
    
    /**
     * Eine get-Methode zum Preis
     * @return Artikel-Preis
     */
    public double getArtikelPreis()
    {
        return preis;
    }
    
    /**
     * Eine set-Methode des Preises
     * @param (double) neuer Preis => 0
     */
    public void setPreis(double neuerPreis)
    {
        check((neuerPreis >= MIN_PREIS), PREIS_FEHLER_MELDUNG);
        preis = neuerPreis;
    }
    
    /**
     * Eine set-Methode der Artikelbezeichnung
     * @param (String) eine Artikelbezeichnung
     */
    public void setArtikelbezeichnung(String artikelbezeichnung)
    {
        check(artikelbezeichnung != null && artikelbezeichnung.trim().length()>0,BEZEICHNUNGS_MELDUNG);
        this.artikelbezeichnung = artikelbezeichnung.trim();
    }
    
    // Andere Methoden
    /**
     * Eine Methode, die den neuen Bestand nach einen Zugang rechnet
     * @param (int) erhoehung
     */
    public void bucheZugang(int erhoehung)
    {         
        check(erhoehung > MIN_ZUGANG, ZUGANG_NEGATIV_MELDUNG);
        
        this.artikelbestand +=  erhoehung;

    }

    /**
     * Eine Methode, die den neuen Bestand nach einen Abgang rechnet
     * @param (int) verminderung 
     */
    public void bucheAbgang(int verminderung)
    {
        check(verminderung > 0, ABGANG_NEGATIV_MELDUNG);
        
        check(this.artikelbestand - verminderung >= 0, 
        ABGANG_ZUGROSS_MELDUNG);
        
        this.artikelbestand -= verminderung;
    }
    
    /**
     * Methode, um den Preis eines Artikels zu aendern
     * 
     * @param (double) prozent 
     * (negativ == Preisverminderung; positiv == Preiserhoehung)
     */
    public void aenderePreis( double prozent)
    {
        check( (prozent >= MIN_PROZENT), PROZENT_FEHLER_MELDUNG);
        preis += preis * prozent/100.0;
    }
    
    /**
     * Eine toString-Methode, um ein Artikel-Objekt als Zeichenkette aufbereiten zu können
     * @return Eine Zeichenkette (String)
     */
    public String toString()
    {
        return ("Artikel : " + artikelnummer +
        ",Bezeichnung : " + artikelbezeichnung +
        ", Bestand : " + artikelbestand +
        ", Preis : " +preis);
    }


    public String getBeschreibung()
    {
        return String.format(" %10s ", this.artikelbezeichnung);
    }

    public static void check(boolean bedingung, String msg) {
        if (!bedingung)
            throw new IllegalArgumentException(msg);
    }

	public static int getMinAbgang() {
		return MIN_ABGANG;
	}

	public static int getMinBestand() {
		return MIN_BESTAND;
	}

}

