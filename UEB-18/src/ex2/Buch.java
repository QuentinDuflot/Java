package ex2;


/**
 *Klasse Buch.java
 *realisiert eine Buch-klasse 
 *erbt von Artikel.java
 *
 *@version 19/01/2019
 *@author Quentin/Raymonde/Arnold
 */



public class Buch extends Artikel
{

    //Fehler-Meldung Konstanten
    private static final String AUTOR_MELDUNG = "Autor ist ungueltig ==> Leer-String";
    private static final String TITEL_MELDUNG = "Titel ist ungueltig ==> Leer-String";
    private static final String VERLAG_MELDUNG = "Verlag ist ungueltig ==> Leer-String";
    
    //Attribute
    private String autor;
    private String titel;
    private String verlag;
    
    //Konstruktor
    /**
     * Ein Voll-Init Konstruktor
     * 
     * @param artikelNr Buch-ArtikelNr
     * @param bezeichnung Buch-Bezeichnung
     * @param bestand Buch-Bestand
     * @param preis Buch-Preis
     * @param autor Buch-Autor
     * @param titel Buch-Titel
     * @param verlag Buch-Verlag
     */
    public Buch(int artikelNr, String bezeichnung, int bestand,
        double preis, String autor, String titel, String verlag)
    {
        super(artikelNr, bezeichnung, bestand, preis);
        setAllAttribute(autor, titel, verlag);
    }
    
    //get-Methoden
    /**
     * gibt titel zuruck
     * 
     * @return Buch-Titel
     */
    public String getTitel()
    {
        return this.titel;
    }
    
    /**
     * gibt autor zuruck
     * 
     * @return Buch-Autor
     */
    public String getAutor()
    {
        return this.autor;
    }
    
    /**
     * gibt verlag zuruck
     * 
     * @return Buch-Verlag
     */
    public String getVerlag()
    {
        return this.verlag;
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
     * set autor
     * 
     * @param autor neuerAutor
     */
    public void setAutor(String neuerAutor)
    {
        check((neuerAutor != null) && 
            (neuerAutor.trim().length() > 0) , AUTOR_MELDUNG );
        this.autor = neuerAutor;
    }
    
    /**
     * set verlag
     * 
     * @param verlag neuerVerlag
     */
    public void setVerlag(String neuerVerlag)
    {
        check((neuerVerlag != null) && 
            (neuerVerlag.trim().length() > 0) , VERLAG_MELDUNG );
        this.verlag = neuerVerlag;
    }
    
    /**
     * eine set-Methode, um alle Buchattribute zu setzen
     * 
     * @param autor neuerAutor
     * @param titel neuerTitel
     * @param verlag neuenVerlag
     */
    private void setAllAttribute(String autor, String titel, String verlag)
    {
        setAutor(autor);
        setTitel(titel);
        setVerlag(verlag);
    }
    
    //sonstige Methoden
    /**
     * gibt eine Beschreibung des Buches als Zeichenkette
     * 
     * @return eine Beschreibung des Buches
     */
    public String getBeschreibung()
    {
        return String.format(" %10s : %10s", this.autor, this.titel);
    }
    
    
    /**
     * toString-Methode
     * 
     * @return der Buch als Zeichenkette
     */
    public String toString()
    {
        return String.format( "%s --> %10s %10s %10s ",
            super.toString(), this.autor, this.titel, this.verlag);
    }
    
    
}

