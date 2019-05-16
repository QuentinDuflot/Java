package ex2;


/**
 *Klasse DVD.java
 *realisiert eine DVD-klasse 
 *erbt von Artikel.java
 *
 *@version 20/01/2019
 *@author Quentin/Raymonde/Arnold
 */
public class DVD extends Artikel
{
  //Konstanten
  public static final int MIN_ERSCHEINUNGSJAHR = 1950;
  public static final int MAX_ERSCHEINUNGSJAHR = 2014;
  public static final float KEIN_SPIELDAUER = 0;
    
    //Fehler-Meldung Konstanten
    private static final String TITEL_MELDUNG = "Titel ist ungueltig ==> Leer-String";
    private static final String SPIELDAUER_MELDUNG = "Anzahl von Musiktitel ist ungueltig ==> Anzahl <= " + KEIN_SPIELDAUER;
    private static final String ERSCHEINUNGSJAHR_MELDUNG = "Erscheinungsjahr ist ungueltig:" + 
                    "nicht zwischen " + MIN_ERSCHEINUNGSJAHR + " und " + MAX_ERSCHEINUNGSJAHR;
    
    //Attribute
    private String titel;
    private float spieldauer;
    private int erscheinungsjahr;
    
    //Konstruktor
    /**
     * Ein Voll-Init Konstruktor
     * 
     * @param artikelNr DVD-ArtikelNr
     * @param bezeichnung DVD-Bezeichnung
     * @param bestand DVD-Bestand
     * @param preis DVD-Preis
     * @param titel DVD-Titel
     * @param spieldauer DVD-Spieldauer
     * @param erscheinungsjahr DVD-Erscheinungsjahr
     */
    public DVD(int artikelNr, String bezeichnung, int bestand,
        double preis, String titel, float spieldauer, int erscheinungsjahr)
    {
        super(artikelNr, bezeichnung, bestand, preis);
        setAllAttribute(titel, spieldauer, erscheinungsjahr);
    }
    
    //get-Methoden
    /**
     * gibt titel zuruck
     * 
     * @return DVD-Titel
     */
    public String getTitel()
    {
        return this.titel;
    }
    
    /**
     * gibt spieldauer zuruck
     * 
     * @return DVD-Spieldauer
     */
    public float getSpieldauer()
    {
        return this.spieldauer;
    }
    
    /**
     * gibt erscheinungsjahr zuruck
     * 
     * @return DVD-Erscheinungsjahr
     */
    public int getErscheinungsjahr()
    {
        return this.erscheinungsjahr;
    }
    
    //set-Methoden
    /**
     * set titel
     * 
     * @param titel neuerTitel
     */
    public void setTitel(String neuerTitel)
    {
        check((neuerTitel != null) && 
            (neuerTitel.trim().length() > 0) , TITEL_MELDUNG );
        this.titel = neuerTitel;
    }
    
    /**
     * set spieldauer
     * 
     * @param spieldauer neueSpieldauer
     */
    public void setSpieldauer(float neueSpieldauer)
    {
        check(neueSpieldauer > KEIN_SPIELDAUER , SPIELDAUER_MELDUNG );
        this.spieldauer = neueSpieldauer;
    }
    
    /**
     * set erscheinungsjahr
     * 
     * @param erscheinungsjahr neueErscheinungsjahr
     */
    public void setErscheinungsjahr(int neueErscheinungsjahr)
    {
        check((neueErscheinungsjahr >= MIN_ERSCHEINUNGSJAHR && neueErscheinungsjahr <= MAX_ERSCHEINUNGSJAHR), ERSCHEINUNGSJAHR_MELDUNG );
        this.erscheinungsjahr = neueErscheinungsjahr;
    }
    
     /**
     * eine set-Methode, um alle DVD-Attribute zu setzen
     * 
     * @param titel neuer Titel
     * @param spieldauer neue Spieldauer
     * @param erscheinungsjahr neue Erscheinungsjahr
     */
    private void setAllAttribute(String titel, float spieldauer, int erscheinungsjahr)
    {
        setTitel(titel);
        setSpieldauer(spieldauer);
        setErscheinungsjahr(erscheinungsjahr);
    }
    
    //sonstige Methoden
    /**
     * gibt eine Beschreibung der DVD als Zeichenkette
     * 
     * @return eine Beschreibung der DVD
     */
    public String getBeschreibung()
    {
        return String.format(" %10s ", this.titel);
    }
    
    /**
     * toString-Methode
     * 
     * @return die DVD als Zeichenkette
     */
    public String toString()
    {
        return String.format( "%s --> %10s %10s %10d ",
            super.toString(),this.titel, this.spieldauer, this.erscheinungsjahr);
    }
}

