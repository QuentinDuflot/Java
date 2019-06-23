package ex2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Formatter;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Einfache Klasse Lager
 * @author Duflot / Wechsler
 * @version 23/06/2019
 */

public class Lager {
    //Konstanten
    public static int STANDARD_DIM = 10;
    public static final String STANDARD_ORT =
        "( Kein Ort wurde jetzt bestimmt)";

    //Meldungs-Konstanten
    private static final String UNGUELTIGE_DIM=
        "Ein Lager muss mindestens 1 Artikel aufnehmen koennen !";

    private static final String LAGER_KOMPLETT =
        "Alle Lager-Plaetze sind besetzt !";

    private static final String ARTIKEL_SCHON_IN_LAGER=
        "Dieses Artikel befindet sich schon im Lager!";

    private static final String ARTIKEL_NICHT_IN_LAGER=
        "Dieses Artikel befindet sich nicht im Lager!";

    private static final String INDEX_MELDUNG=
        "Der Index ist entweder zu gross oder zu klein !";

    //Attribute
    private  Map<Integer, Artikel> lager;
    private int letzterIndexBesetzt;
	private Formatter format1;

    //Konstruktoren

    /**
     * Konstruktor max Anzahl von Plaetzen
     * @param (int) dimMax = Anzahl von maximal Plaetze
     */
    public Lager (int dimMax) {
        check(dimMax > 0,UNGUELTIGE_DIM);
        lager = new LinkedHashMap<Integer, Artikel>(dimMax);
        letzterIndexBesetzt = -1;
    }

    /**
     * Konstruktor zur Standard-Initialisierung
     */
    public Lager () {
        this(STANDARD_DIM);
    }

    //Artikel anlegen
    /**
     * Anlegen eines Artikel und ins Lager einordnen
     * @param artikel : der neue Artikel
     */
    public void anlegen (Artikel artikel) {
        check((lager.containsKey(artikel.getArtikelnummer() )),
            ARTIKEL_SCHON_IN_LAGER);
        check( (letzterIndexBesetzt < lager.size() - 1),
            LAGER_KOMPLETT);

        lager.put(artikel.getArtikelnummer(), artikel);
    }

    //Artikel loeschen
    /**
     * loescht ein Artikel anhand seiner Nummer 
     * @param (int) loeschArtikelNr
     */
    public void loeschen (int loeschArtikelNr) {
    	lager.remove(loeschArtikelNr);
    }

    //zugang buchen
    /**
     *  bucht einen Zugang von Artikeln
     *  @param (int) artikelNr
     *  @param (int) erhoehung
     */
    public void bucheZugang(int artikelNr, int erhoehung) {
        check(!lager.containsKey(artikelNr), ARTIKEL_NICHT_IN_LAGER);
        lager.get(artikelNr).bucheZugang( erhoehung );;
    }

    //abgang buchen
    /**
     *  bucht einen Zugang von Artikeln
     *  @param (int) artikelNr
     *  @param (int) verminderung
     */
    public void bucheAbgang(int artikelNr, int verminderung) {
        check(!lager.containsKey(artikelNr), ARTIKEL_NICHT_IN_LAGER);
        lager.get(artikelNr).bucheAbgang( verminderung );
    }
    
    //Preis aendern
    /**
     * erhoehung oder verminderung des preises aller artikeln
     * @param (double)prozent negtaiv == -, positiv == +
     */
    public void preisaenderung(double prozent) {
    	lager.values().stream().forEach((Artikel a) -> a.aenderePreis( prozent ));
    }
    
    /**
     * erzeugt einen Zeichenkette, um eine Bestandsliste auszugeben
     * @return eine String-Repraesentgation des Lagers
     */
    public String bestandsListeAusgeben() {
        double zeilenWert, wert = 0;
        
        StringBuilder liste = new StringBuilder();
        format1 = new Formatter( liste, Locale.GERMAN );
        
        format1.format("\n\t Bestandliste " +
                    "\n\n %6s %6s \t\t%6s " +
                    "\t\t%6s \t\t%6s","Artikelnummer","Beschreibung","Preis", "Bestand","Gesamt");
                    
        Iterator<Artikel> iter = lager.values().iterator();               
        Artikel next;                                                     
        while(iter.hasNext()){                                            
        	next = iter.next();                                          
     
            zeilenWert = next.getArtikelPreis() * next.getBestand();             
            wert += zeilenWert;                                     

            format1.format( "\n %6d   %45s %10.2f %10d %10.2f ",
                                next.getArtikelnummer(),                      
                                next.getBeschreibung(),                   
                                next.getArtikelPreis(),                         
                                next.getBestand(),                                      
                                zeilenWert
                              );
        format1.format("\n\n\t GesamtWert: \t\t %.2f", wert);
        }
        return liste.toString();
        
    }
    
    //Sortierung
    
    /**
     * Sortiert Artikeln des Lagers nach einer uebergegebene Sortierkriterium
     * 
     * @param sortierKriterium Praedikat, das Sortierkriterium implementiert
     * @return eine sortierte Liste den Artikeln im Lager
     */
    public List<Artikel> getSorted(Comparator<Artikel> comparator){
		return lager.values().stream().sorted(comparator).collect(Collectors.toList());
	}
       
    //Filter
    /**
     * Filtert Artikeln des Lagers nach einem uebergegebenen Filterkriterium
     * 
     * @param filterKriterium Praedikat, das Filterkriterium implementiert
     * @return eine Liste, die nur die Artikel, die das Filterkriterium erfuellen, enthaelt.
     */
    public List<Artikel> filter(Predicate<Artikel> filter)
	{
		return lager.values().stream().filter(filter).collect(Collectors.toList());
	}
    
    //applyToArticles
    /**
     * wendet eine Operation auf alle Artikel des Lagers an
     * @param consumer Ein Consumer für die Operation
     */
    public void applyToArticles(Consumer<Artikel> consumer)
	{
		lager.values().stream().forEach(consumer);
	}
    
    //applyToSomeArticles
    /**
     * Wendet eine Operation auf die Artikel an, welche ein bestimmtes Kriterium erfüllen
     * 
     * @param filterKriterium Praedikat, das Filterkriterium implementiert
     * @param operation Ein Consumer für die Operation
     */
    public void applyToSomeArticles(Predicate<Artikel> filter, Consumer<Artikel> consumer)
	{
		lager.values().stream().filter(filter).forEach(consumer);                           
	}
    
    //getArticles
    /**
     * Gibt eine sortierte Liste der Artikel zurück,  welche ein bestimmtes Suchkriterium erfüllen
     * 
     * @param suchKriterium Praedikat, das Filterkriterium implementiert
     * @param sortierKriterium Praedikat, das Sortierkriterium implementiert
     * @return Eine Liste dieser Artikeln
     */
    public List<Artikel> getArticles(Predicate<Artikel> filter, Comparator<Artikel> comparator)
	{
		return lager.values().stream().filter(filter).sorted(comparator).collect(Collectors.toList()); 
	}
    
    //filterAll
    /**
     * Nimmt eine beliebige Menge an Filterkriterien als Parameter entgegennimmt 
     * und gibt die Artikel des Lagers zurück , die alle Filterkriterien erfüllen
     * 
     * @param filterKriterium Praedikat, das Filterkriterium implementiert
     * @return
     */
	public List<Artikel> filterAll(Predicate<Artikel>... filterKriterium){
		
		for(Predicate<Artikel> j : filterKriterium) {
			lager.values().stream().filter(j);
		}
		return lager.values().stream().collect(Collectors.toList());
    }
	
	 /**
     * 
     * @param bedingung Bedigung, die man überprüfen muss
     * @param msg Fehlermessage
     */
    public static void check(boolean bedingung, String msg) {
        if (!bedingung)
            throw new IllegalArgumentException(msg);
    }
	
	//toString
    /**
     * Eine toString Methode
     * @return eine Repraesentation des Lagers
     */
    public String toString() {

        StringBuffer lagerString = new StringBuffer(
                                   String.format( "\n\nIm Lager sind von %5d Lagerplaetzen %5d ",
                                                 lager.size(), (letzterIndexBesetzt + 1)  
                                   )
                     );
                                   
        lagerString.append( " belegt, mit folgenden Artikeln : \n");
        Iterator<Artikel> iter = lager.values().iterator();                            
        int i=0;                                                                       
        while ( iter.hasNext() )                                                       
          {
        	i++;                                                                      
            lagerString.append( String.format( "\n\t %3d \t-> %s", i, iter.next()) );  
          }
     

       return lagerString.toString(); 
    }
}