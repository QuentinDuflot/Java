package ex2;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Einfache Klasse Lager
 * @author Duflot / Wechsler
 * @version 30.11.2018
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
    private Artikel[] lager;
    private int letzterIndexBesetzt;
	private Formatter format1;

    //Konstruktoren

    /**
     * Konstruktor max Anzahl von Plaetzen
     * @param (int) dimMax = Anzahl von maximal Plaetze
     */
    public Lager (int dimMax) {
        check(dimMax > 0,UNGUELTIGE_DIM);
        lager = new Artikel[dimMax];
        letzterIndexBesetzt = -1;
        for(int i = 0; i < dimMax; i++) {
            lager[i] = null;
        }
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
        check((sucheArtikel(artikel.getArtikelnummer())==-1),
            ARTIKEL_SCHON_IN_LAGER);
        check( (letzterIndexBesetzt < lager.length - 1),
            LAGER_KOMPLETT);

        lager[++letzterIndexBesetzt] = artikel;
    }

    //Artikel loeschen
    /**
     * loescht ein Artikel anhand seiner Nummer 
     * @param (int) loeschArtikelNr
     */
    public void loeschen (int loeschArtikelNr) {
        int stelle, schieber;

        stelle = sucheArtikel(loeschArtikelNr);

        check( (stelle != -1),ARTIKEL_NICHT_IN_LAGER);

        lager[stelle]=null;
        letzterIndexBesetzt--;

        for(schieber = stelle; schieber <= letzterIndexBesetzt; schieber++) {
            lager[schieber] = lager[schieber+1];
        }
        if(schieber + 1 < lager.length) {
            lager[schieber + 1] = null;
        }
    }

    //zugang buchen
    /**
     *  bucht einen Zugang von Artikeln
     *  @param (int) artikelNr
     *  @param (int) erhoehung
     */
    public void bucheZugang(int artikelNr, int erhoehung) {
        int index = sucheArtikel(artikelNr);
        check((index != 1), ARTIKEL_NICHT_IN_LAGER);
        lager[index].bucheZugang(erhoehung);
    }

    //abgang buchen
    /**
     *  bucht einen Zugang von Artikeln
     *  @param (int) artikelNr
     *  @param (int) verminderung
     */
    public void bucheAbgang(int artikelNr, int verminderung) {
        int index = sucheArtikel(artikelNr);
        check((index != 1), ARTIKEL_NICHT_IN_LAGER);
        lager[index].bucheAbgang(verminderung);
    }
    
    //Preis aendern
    /**
     * erhoehung oder verminderung des preises aller artikeln
     * @param (double)prozent negtaiv == -, positiv == +
     */
    public void preisaenderung(double prozent) {
        for( int i = 0; i <= letzterIndexBesetzt; i++) {
            lager[i].aenderePreis(prozent);
        }
    }
    
    //andere Methoden
    /**
     * suche ein Artikel anhand sein Nummer
     * @param (int)suchNummer
     * @return Index des Artikels oder -1, falls dieses nicht existiert
     */
    public int sucheArtikel(int suchNummer) {
        int i, gefunden;
        for(i=0, gefunden =-1; ((i <= letzterIndexBesetzt) && (gefunden == -1)); i++) {
            if(lager[i].getArtikelnummer() == suchNummer) {
                gefunden = i;
            }
        }
        return gefunden;
    }
    
    /**
     * get-Methode zu die Groesse des Lagers
     */
    public int getLagerDim() {
        return lager.length;
    }
    
    /**
     * get-Methode zu ein Artikel des Lagers
     * @param (int) index : index des Artikels
     * @return der Artikel, der an diese Index steht
     */
    public Artikel getArtikel(int index) {
        check((index < getLagerDim() && index >= 0),
            INDEX_MELDUNG);
        return lager[index];
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
                    
        for(int i = 0; i <= letzterIndexBesetzt; i++) {
            zeilenWert = lager[i].getArtikelPreis() * lager[i].getBestand();
            wert += zeilenWert;
            
            format1.format(" \n %6d %6s \t\t%6.2f \t\t%6d \t\t%6.2f ",
                            lager[i].getArtikelnummer(),
                            lager[i].getBeschreibung(),
                            lager[i].getArtikelPreis(),
                            lager[i].getBestand(),
                            zeilenWert);
        }
        format1.format("\n\n\t GesamtWert: \t\t %.2f", wert);
        
        return liste.toString();
    }
    
    //Sortierung
    
    /**
     * Sortiert Artikeln des Lagers nach einer uebergegebene Sortierkriterium
     * 
     * @param sortierKriterium Praedikat, das Sortierkriterium implementiert
     * @return eine sortierte Liste den Artikeln im Lager
     */
    public Artikel[] getSorted(BiPredicate<Artikel, Artikel> sortierKriterium) {
    	Artikel[] sortierteListe = lager.clone();
    	sort(sortierKriterium, sortierteListe);
    	return sortierteListe;
    }
    
    /**
     * Hilfsmethode, um ein Array zu sortieren (Bubblesort)
     * 
     * @param sortKrit Praedikat, das Sortierkriterium implementiert
     * @param art Array von Artikeln, den man sortieren muss
     */
    private void sort(BiPredicate<Artikel, Artikel> sortKrit, Artikel[] art) {
    	int laenge = art.length;
    	for (int i= 0 ; i < laenge ; i++) {
    		for (int j = 1 ; j < laenge - i ; j++) {
    			if (sortKrit.test(art[j - 1] , art[j])) {
    				tausch(j - 1 , j , art);
                }
    		}
    	}
    }

    /**
     * Vertauscht zwei Elementen eines Arrays
     * 
     * @param i Index des ersten Elements
     * @param j Index des zweiten Elements
     * @param art Array fuer die Vertauschung
     */
    private void tausch(int i, int j, Artikel[] art) {
      Artikel aux = art[i];
      art[i] = art[j];
      art[j] = aux;		
    }
    
    //Filter
    /**
     * Filtert Artikeln des Lagers nach einem uebergegebenen Filterkriterium
     * 
     * @param filterKriterium Praedikat, das Filterkriterium implementiert
     * @return eine Liste, die nur die Artikel, die das Filterkriterium erfuellen, enthaelt.
     */
    public List<Artikel> filter(Predicate<Artikel> filterKriterium) {
    	List<Artikel> gefilterteListe = new ArrayList<Artikel>();
    	
    	int laenge = lager.length;
    	
    	for(int i = 0; i < laenge; i++) {
    		if( filterKriterium.test(lager[i]) ) {
    			gefilterteListe.add(lager[i]);
    		}
    	}
    	return gefilterteListe;
    }
    
    //applyToArticles
    /**
     * wendet eine Operation auf alle Artikel des Lagers an
     * @param consumer Ein Consumer
     */
    public void applyToArticles(Consumer<Artikel> consumer) {
    	int laenge = lager.length;
    	
    	for (int i = 0; i < laenge; i++) {
    		consumer.accept(lager[i]);
    	}
    }
    
    // e)
    /**
     * @param filterKriterium
     * @param operation
     */
    public void applyToSomeArticles(Predicate<Artikel> filterKriterium, Consumer<Artikel> operation) {
    	for(Artikel article : filter(filterKriterium)) {
    		operation.accept(article);
    	}
    }
    
    // f)
    /**
     * @param suchKriterium
     * @param sortierKriterium
     * @return
     */
    public Artikel[] getArticles(Predicate<Artikel> suchKriterium, BiPredicate<Artikel, Artikel> sortierKriterium) {
    	List<Artikel> getArticlesList = new ArrayList<Artikel>();
    	getArticlesList = filter(suchKriterium);
    	Artikel[] ergebnis = getArticlesList.toArray(new Artikel[getArticlesList.size()]);
    	sort(sortierKriterium, ergebnis);
    	return ergebnis;
    }
    
	//toString
    /**
     * Eine toString Methode
     * @return eine Repraesentation des Lagers
     */
    public String toString() {
        String lagerString = new String("Im Lager sind von "+getLagerDim()+
                                        " Plaetze "+ (letzterIndexBesetzt + 1) +
                                        " belegt, mit folgenden Artikeln :\n");
        for(int i = 0; i <= letzterIndexBesetzt; i++) {
            lagerString += "\n\t"+ i + "\t -> " + lager[i];
        }
        return lagerString;                                   
    }
    
    public static void check(boolean bedingung, String msg) {
        if (!bedingung)
            throw new IllegalArgumentException(msg);
    }    
}