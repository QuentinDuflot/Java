package ex2;


/**
 *Klasse CD.java
 *realisiert eine CD-klasse 
 *erbt von Artikel.java
 *
 *@version 19/01/2019
 *@author Quentin/Raymonde/Arnold
 */
public class CD extends Artikel
{
    //Konstanten
    private static final int NO_TRACK = 0;
    
    //Fehler-Meldung Konstanten
    private static final String INTERPRET_MELDUNG = "Interpret ist ungueltig ==> Leer-String";
    private static final String TITEL_MELDUNG = "Titel ist ungueltig ==> Leer-String";
    private static final String TRACKCOUNT_MELDUNG = "Anzahl von Musiktitel ist ungueltig ==> Anzahl <= " + NO_TRACK;
    
    //Attribute
    private String interpret;
    private String titel;
    private int trackcount;
    
    //Konstruktor
    /**
     * Ein Voll-Init Konstruktor
     * 
     * @param artikelNr CD-ArtikelNr
     * @param bezeichnung CD-Bezeichnung
     * @param bestand CD-Bestand
     * @param preis CD-Preis
     * @param interpret CD-Interpret
     * @param titel CD-Titel
     * @param trackcount CD-Trackcount
     */
    public CD(int artikelNr, String bezeichnung, int bestand,
        double preis, String interpret, String titel, int trackcount)
    {
        super(artikelNr, bezeichnung, bestand, preis);
        setAllAttribute(interpret, titel, trackcount);
    }
    
    //get-Methoden
        /**
     * gibt titel zuruck
     * 
     * @return CD-Titel
     */
    public String getTitel()
    {
        return this.titel;
    }
    
    /**
     * gibt autor zuruck
     * 
     * @return CD-Interpret
     */
    public String getInterpret()
    {
        return this.interpret;
    }
    
    /**
     * gibt trackcount zuruck
     * 
     * @return CD-trackcount
     */
    public int getTrackcount()
    {
        return this.trackcount;
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
     * set interpret
     * 
     * @param interpret neuerInterpret
     */
    public void setInterpret(String neuerInterpret)
    {
        check((neuerInterpret != null) && 
            (neuerInterpret.trim().length() > 0) , INTERPRET_MELDUNG );
        this.interpret = neuerInterpret;
    }
    
    /**
     * set trackcount
     * 
     * @param trackcount neuerTrackcount
     */
    public void setTrackcount(int neuerTrackcount)
    {
        check(neuerTrackcount > NO_TRACK , TRACKCOUNT_MELDUNG );
        this.trackcount = neuerTrackcount;
    }
    
     /**
     * eine set-Methode, um alle CD-Attribute zu setzen
     * 
     * @param interpret neuer Interpret
     * @param titel neuer Titel
     * @param trackcount neuen Trackcount
     */
    private void setAllAttribute(String interpret, String titel, int trackcount)
    {
        setInterpret(interpret);
        setTitel(titel);
        setTrackcount(trackcount);
    }
    
    //sonstige Methoden
    /**
     * gibt eine Beschreibung der CD als Zeichenkette
     * 
     * @return eine Beschreibung der CD
     */
    public String getBeschreibung()
    {
        return String.format(" %10s : %10s", this.interpret, this.titel);
    }
    
    /**
     * toString-Methode
     * 
     * @return die CD als Zeichenkette
     */
    public String toString()
    {
        return String.format( "%s --> %10s %10s %10d ",
            super.toString(), this.interpret, this.titel, this.trackcount);
    }
}

