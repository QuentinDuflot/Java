package ex2;

import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.*;
/**
 * Einfache Klasse Lager
 * @author Duflot / Wechsler
 * @version 03/06/2019
 */

public class LagerDialog {

    //Klassenkonstanten
    private static final int ERZEUGE_STANDARD_LAGER = 1;
    private static final int ERZEUGE_LAGER = 2;
    private static final int LOESE_LAGER_AUF = 3;
    private static final int ZUGANG = 4;
    private static final int ABGANG = 5;
    private static final int LOESCHE_ARTIKEL = 6;
    private static final int ARTIKEL_EINFUEGEN = 7;
    private static final int PREIS_AENDERN = 8;
    private static final int ZEIGE_BESTANDS_LISTE = 9;
    private static final int ZEIGE_LAGER = 10;
    private static final int ENDE = 0;
    private static final int ERSTELLE_ZUFALLS_LAGER = 11;
    private static final int SORTIERT_LAGER = 12;
    private static final int ZEHN_PROZENT_REDUKTION = 13;
    private static final int SONDERANGEBOT = 14;
    private static final int ZEHN_PROZENT_SONDERANGEBOT = 15;
    private static final int ZEHN_PROZENT_ERHOEHUNG_CD = 16;
    private static final int FUNF_PROZENT_REDUKTION_ARTIKEL_MIT_2_EX = 17;
    private static final int FUNF_PROZENT_REDUKTION_BESTIMMTES_AUTHOR = 18;
    private static final int ZEHN_PROZENT_ERHOEHUNG_CD_UND_FUNF_PROZENT_REDUKTION_BESTIMMTES_AUTHOR = 19;
    private static final int LISTE_BUECHER_SORTIERT_NACH_AUTOR = 20;
    private static final int TEST_FILTER_ALL = 21;

    private static final String MENUE_FEHLER = "Falsche Funktion \n";

    private enum auswahl { ARTIKEL, CD, VIDEO, BUCH };

    private StringBuffer auswahlString;

    //Attribute
    private Lager lager1;
    private Scanner input;

    //Konstruktor
    /**
     * Standard-Konstruktor des Dialogs
     */
    public LagerDialog() {
        lager1 = null;
        input = new Scanner(System.in);

        auswahlString = new StringBuffer (" Welchen Typ von ARtikel wollen Sie aufnehmen ? \n");
        for (auswahl a : auswahl.values())
        {
            auswahlString.append(a).append("\t Dann geben Sie --> ")
            .append(a.ordinal()).append("\n ");
        }
        auswahlString.append("waehle : ");
    }

    /**
     * Hauptschleife des Testprogramms
     */
    public void start() {
        int funktion = -1;
        while(funktion != ENDE) {
            try{
                funktion = einlesenFunktion();
                ausfuehrenFunktion(funktion);
            } catch (IllegalArgumentException e) {
                System.out.println("Ausnahme gefangen: " + e);
            } catch (InputMismatchException e) {
                System.out.println(e);
                input.next();
            } catch (Exception e) {
                System.out.println("Ausnahme gefangen: " + e);
                e.printStackTrace(System.out);
            }
        }

        if(lager1 != null) {
            System.out.println("Der aktuelle Bestand : \n " +
                lager1 + " \n ");
        }
    }

    /**
     * Menue ausgeben und Funktion einlesen
     * @return eingelesene Funktion als ganzzahliger Wert
     */
    private int einlesenFunktion() {
        int funktion;

        System.out.print(
            ERZEUGE_STANDARD_LAGER +
            ": standard Lager erzeugen \n"+

            ERZEUGE_LAGER +
            ": Lager mit Parametern erzeugen \n"+

            LOESE_LAGER_AUF +": Lager aufloesen \n"+

            ZUGANG + ": ein Zugang buchen \n"+

            ABGANG + " : ein Abgang buchen \n" +

            LOESCHE_ARTIKEL +
            " : ein Artikel loeschen \n"+

            ARTIKEL_EINFUEGEN + ": ein Artikel ins Lager einfuegen\n" +

            PREIS_AENDERN + ": die Preise aller Artikeln aendern\n"+

            ZEIGE_BESTANDS_LISTE + ": die Bestandsliste anzeigen \n" +

            ZEIGE_LAGER + ": Inhalt des Lager anzeigen \n" +

            ERSTELLE_ZUFALLS_LAGER + ": Erstelle ein Testlager mit zufï¿½llige Werte \n" +

            SORTIERT_LAGER + ": Sortiert den Lager nach Kategorie, dann nach Bestand und danach nach Preis \n" +

            ZEHN_PROZENT_REDUKTION + ": Reduziert alle Preise um 10% \n" +

            SONDERANGEBOT + ": Spezifiert ein Sonderangebot auf alle Artikel \n" +

            ZEHN_PROZENT_SONDERANGEBOT + ": Reduziert alle Preise um 10% und Spezifiert"
            		+ " ein Sonderangebot auf alle Artikel \n" +

            ZEHN_PROZENT_ERHOEHUNG_CD + ": Erhï¿½ht die Preise aller CD's um 10% \n" +

			FUNF_PROZENT_REDUKTION_ARTIKEL_MIT_2_EX + ": Reduziert die Preise aller Artikel mit 2 Examplare um 5%\n"+

			FUNF_PROZENT_REDUKTION_BESTIMMTES_AUTHOR + ":  Reduziert alle Bï¿½cher eines gegebenen Autors um 5% \n" +

			ZEHN_PROZENT_ERHOEHUNG_CD_UND_FUNF_PROZENT_REDUKTION_BESTIMMTES_AUTHOR + ": Erhï¿½ht die Preise aller CD's um 10% "
					+ "und Reduziert die Preise aller Artikel mit 2 Examplare um 5% \n" +

			LISTE_BUECHER_SORTIERT_NACH_AUTOR + ": Gibt eine Liste aller Bï¿½cher, sortiert nach Autor \n" +

            TEST_FILTER_ALL + ": Tested die filterAll-Methode mit 3 Kriterien\n" +

            ENDE + ": Ende des Programms \n");

        funktion = input.nextInt();
        input.nextLine();
        return funktion;
    }

    /**
     * Ausfuehren der ausgewaehlten Funktion
     * @param die auszufuehrende Funktion als ganze Zahl
     */
    private void ausfuehrenFunktion(int funktion) {
        int lagerGroesse;
        int artikelNr;

        switch(funktion) {
            case ERZEUGE_STANDARD_LAGER :
            existiertLager( false );
            lager1 = new Lager();
            break;

            case ERZEUGE_LAGER :
            existiertLager( false );
            System.out.println("Geben sie die Groesse des Lagers an : ");
            lagerGroesse = input.nextInt();
            lager1 = new Lager(lagerGroesse );
            break;

            case LOESE_LAGER_AUF :
            existiertLager( true );
            lager1 = null;
            break;

            case ARTIKEL_EINFUEGEN:
            existiertLager( true );
            erzeugeLagerPosition();
            break;

            case LOESCHE_ARTIKEL:
            existiertLager( true );
            System.out.println("Geben Sie die Artikel-Nummer " +
                " des zu loeschen Artikels ein : ");
            artikelNr =  input.nextInt();
            lager1.loeschen( artikelNr);
            break;

            case ZUGANG:
            existiertLager( true );
            System.out.println("Geben Sie die Artikelnummer " +
                " des zu buchenden Artikels ein : ");
            artikelNr =  input.nextInt();
            lager1.bucheZugang( artikelNr, frageZugang() );
            break;

            case ABGANG :
            existiertLager( true );
            System.out.println("Geben Sie die Artikelnummer " +
                " des zu buchenden Artikels ein : ");
            artikelNr =  input.nextInt();
            lager1.bucheAbgang( artikelNr, frageAbgang() );
            break;

            case PREIS_AENDERN :
            existiertLager( true );
            double prozent;
            System.out.println("Geben Sie Prozentzahl ein : " +
                "\n --> positive Zahl == Preiserhoehung," +
                "\n --> negative Zahl == Preisverminderung");
            prozent = input.nextDouble();
            lager1.preisaenderung( prozent );
            break;

            case ZEIGE_BESTANDS_LISTE :
            existiertLager(true);
            System.out.println( lager1.bestandsListeAusgeben() );
            break;

            case ZEIGE_LAGER :
            existiertLager(true);
            System.out.println( lager1 );
            break;

            case ERSTELLE_ZUFALLS_LAGER:
            	erstelleRandomLager();
            	break;

            case SORTIERT_LAGER:
            	existiertLager(true);
            	testSortiertLager();
            	break;

            case ZEHN_PROZENT_REDUKTION:
            	existiertLager(true);
            	reduzierePreise10Proz();
            	break;

            case SONDERANGEBOT:
            	existiertLager(true);
            	sonderAngebot();
            	break;

            case ZEHN_PROZENT_SONDERANGEBOT:
            	existiertLager(true);
            	zehnProzentSonderangebot();
            	break;

            case ZEHN_PROZENT_ERHOEHUNG_CD:
            	existiertLager(true);
            	zehnProzentErhoehungCD();
            	break;

            case FUNF_PROZENT_REDUKTION_ARTIKEL_MIT_2_EX:
            	existiertLager(true);
            	funfProzentReduktionArtikelMitZweiEx();
            	break;

            case FUNF_PROZENT_REDUKTION_BESTIMMTES_AUTHOR:
            	existiertLager(true);
            	funfProzentReduktionBestimmtesAuthor();
            	break;

            case ZEHN_PROZENT_ERHOEHUNG_CD_UND_FUNF_PROZENT_REDUKTION_BESTIMMTES_AUTHOR:
            	existiertLager(true);
            	zehnProzentErhoehungCDUndFunfProzentReduktionArtikelMitZweiEx();
            	break;

            case LISTE_BUECHER_SORTIERT_NACH_AUTOR:
            	existiertLager(true);
            	gebeListeBuecherSortiertNachAutor();
            	break;

            case TEST_FILTER_ALL:
            	existiertLager(true);
            	testedFilterAll();
            	break;

            case ENDE :
            System.out.println("Programmende\n");
            break;

            default :
            System.out.println(MENUE_FEHLER);
            break;
        }
    }


	/**
     *  Fragt den Benutzer die Daten fuer einen Artikel
     *  und steckt den Artikel in dem Lager
     */
    private void erzeugeLagerPosition() {
        auswahl typ = null;
        int typEingabe = -1;

        //Attribute Artikel
        int artikelNr, artikelBestand;
        double artikelPreis;
        String artikelBezeichnung;

        //Attribute Buch
        String autor, titel, verlag;

        //Attribute CD
        //Titel schon deklariert
        String interpret;
        int trackcount;

        //Attribute Video
        //Titel schon deklariert
        float spieldauer;
        int erscheinungsjahr;

        //Was soll erzeugt werden
        while( (typEingabe < 0) || (typEingabe > auswahl.values().length) ) {
            typEingabe = readlnInt(input, auswahlString.toString() );

            if(typEingabe >= 0 && typEingabe < auswahl.values().length) {
                typ = auswahl.values()[typEingabe];
            }
        }

        //Allgemeine Daten
        artikelNr = readlnInt(input, "\n Geben Sie die Artikel-Nummer ein : ");
        artikelBezeichnung = readlnString(input, "\n Geben Sie die Artikel-Bezeichnung ein : ");
        artikelBestand = readlnInt(input, "\n Geben Sie den Artikel-Bestand ein : ");
        artikelPreis = readlnDouble(input, "\n Geben Sie den Artikel-Preis ein : ");

        switch (typ) {
            case ARTIKEL:
	            lager1.anlegen( new Artikel(artikelNr, artikelBezeichnung,
	                    artikelBestand, artikelPreis));
	            break;
            case BUCH:
	            autor = readlnString(input, "\n Geben Sie den Autor  ein : ");
	            titel = readlnString(input, "\n Geben Sie den Titel ein : ");
	            verlag = readlnString(input, "\n Geben Sie den Verlag ein : ");
	            lager1.anlegen( new Buch(
	                    artikelNr,
	                    artikelBezeichnung,
	                    artikelBestand,
	                    artikelPreis, autor,
	                    titel, verlag));
	            break;
            case CD:
	            interpret =readlnString(input, "\n Geben Sie den Interpret  ein : ");
	            titel = readlnString(input, "\n Geben Sie den Titel ein : ");
	            trackcount =readlnInt(input, "\n Geben Sie den Trackcount ein : ");

	            lager1.anlegen( new CD(
	                    artikelNr,
	                    artikelBezeichnung,
	                    artikelBestand,
	                    artikelPreis, interpret,
	                    titel, trackcount));
	            break;
            case VIDEO:
	            titel =readlnString(input, "\n Geben Sie den Titel ein : ");
	            spieldauer =readlnFloat(input, "\n Geben Sie die Spieldauer ein : ");
	            erscheinungsjahr =readlnInt(input, "\n  Geben Sie das Erscheinugnsjahr ein : ");
	
	            lager1.anlegen( new Video( 
	                    artikelNr, 
	                    artikelBezeichnung,
	                    artikelBestand,
	                    artikelPreis, titel,
	                    spieldauer, erscheinungsjahr));
	            break;
            default:
            	throw new RuntimeException("Falschen Auswahl !");
        }
    }

    /**
     * fragt den Benutzer den Zugang fuer einen Artikel
     *
     * @return die Erhoehung-Zahl
     */
    private int frageZugang() {
        System.out.println("Geben Sie die Erhoehung-Zahl ein : ");
        return input.nextInt();
    }

    /**
     * fragt den Benutzer den Abgang fuer einen Artikel
     *
     * @return die Verminderung-Zahl
     */
    private int frageAbgang() {
        System.out.println("Geben Sie die Verminderung-Zahl ein : ");
        return input.nextInt();
    }

    /**
     * Ueberpruft ob ein Lager schon existiert
     *
     * @param (boolean)bedingung
     */
    private void existiertLager(boolean bedingung) {
        if (bedingung) {
            if(lager1 == null) {
                throw new RuntimeException("Lager existiert noch nicht!");
            }
        } else {
            if(lager1 != null) {
                throw new RuntimeException("Lager exisiert schon !");
            }
        }
    }

    //Aufgabe KW23
    /**
     * Reduziert alle Preise, um 10 Prozent
     */
    private void reduzierePreise10Proz() {
    	lager1.applyToArticles(a -> a.setPreis( a.getArtikelPreis() - a.getArtikelPreis()*0.1 ) );
    }

    /**
     * Apply eine Sonderangebot auf alle Arikel
     */
    private void sonderAngebot() {
    	lager1.applyToArticles(a -> a.setArtikelbezeichnung(a.getBezeichnung() + " Sonderangebot"));
    }

    /**
     * Reduziert alle Preise, um 10 Prozent und apply eine Sonderangebot auf alle Arikel
     */
    private void zehnProzentSonderangebot() {
    	Consumer<Artikel> minus10Prozent = a -> a.setPreis( a.getArtikelPreis() - a.getArtikelPreis()*0.1 );
    	Consumer<Artikel> sonderangebot = a -> a.setArtikelbezeichnung(a.getBezeichnung() + " Sonderangebot");

    	lager1.applyToArticles(minus10Prozent.andThen(sonderangebot));
    }

    /**
     * Erhöht die Preiser aller CD's um 10 Prozent
     */
	private void zehnProzentErhoehungCD() {

		lager1.applyToSomeArticles(a -> a instanceof CD,
				a -> a.setPreis(a.getArtikelPreis() + a.getArtikelPreis()*0.1));
	}

	/**
	 * Reduziert die Preise von alle Artikel mit nur 2 Examplare um 5 Prozent
	 */
	private void funfProzentReduktionArtikelMitZweiEx() {

		lager1.applyToSomeArticles(a -> a.getBestand() == 2,
				a -> a.setPreis(a.getArtikelPreis() - a.getArtikelPreis()*0.05));
	}

	/**
	 * Reduziert die Preise der Bücher eines bestimmtes Autor um 5 Prozent
	 */
	private void funfProzentReduktionBestimmtesAuthor() {
		String author = "author0";
		Predicate<Artikel> filterAuthor =
				a -> {
					if(a instanceof Buch) {
						if(((Buch) a).getAutor().equals(author)) {
							return true;
						}
					}
					return false;
				};
		lager1.applyToSomeArticles(filterAuthor, a -> a.setPreis(a.getArtikelPreis() - a.getArtikelPreis()*0.05));
	}

	/**
	 * Erhöht die Preiser aller CD's um 10 Prozent und 
	 * reduziert die Preise von alle Artikel mit nur 2 Examplare um 5 Prozent
	 */
	private void zehnProzentErhoehungCDUndFunfProzentReduktionArtikelMitZweiEx() {

		lager1.applyToSomeArticles(a -> a instanceof CD,
				a -> a.setPreis(a.getArtikelPreis() + a.getArtikelPreis()*0.1));
		lager1.applyToSomeArticles(a -> a.getBestand() == 2,
				a -> a.setPreis(a.getArtikelPreis() - a.getArtikelPreis()*0.05));

	}

	/**
	 * Gibt eine Liste der Buecher sortiert nach Autor
	 */
	private void gebeListeBuecherSortiertNachAutor() {

		Artikel[] result = lager1.getArticles(a -> a instanceof Buch,
				(a,b) -> ((Buch)a).getAutor().compareTo(((Buch)b).getAutor()) >= 0 ? true : false);

		int laenge = result.length;
		int i;

		for(i = 0; i < laenge; i++) {
			System.out.println(result[i]);
		}
	}

	/**
	 * Filtert die Buecher, die weniger als 50 euros kosten 
	 * und mehr als 1 Exemplar haben
	 */
	private void testedFilterAll() {

		Predicate<Artikel> filterBuch = a -> {
			if (a instanceof Buch) {
				return true;
			}
			return false;
		};

		Predicate<Artikel> filterPreis = a -> {
			if (a.getArtikelPreis() < 50) {
				return true;
			}
			return false;
		};

		Predicate<Artikel> filterBestand = a -> {
			if (a.getBestand() > 1) {
				return true;
			}
			return false;
		};

		List<Artikel> list = lager1.filterAll(filterBuch, filterPreis, filterBestand);
		int laenge = list.size();
		System.out.println("Filtert die Bï¿½cher mit mehr als ein Examplar und weniger als 50 euro kosten");
		if(laenge == 0){
			System.out.println("Kein Artikel erfï¿½llt die Kriterien");
		}else {

			for(int i = 0; i < laenge; i++) {
				System.out.println(list.get(i));
			}
		}

	}

	/**
	 * Sortiert die Artikel im Lager nach folgen-den Kategorien sortiert:
	 * (a)  Unterkategorie (alphabetisch)
	 * (b)  Bestand
	 * (c)  Preis
	 */
    private void testSortiertLager() {

    	BiPredicate<Artikel, Artikel> sortiertKriterium = (Artikel artikel1, Artikel artikel2) -> {
    		//Sortierung nach Kategorien
 		   BiFunction<Artikel, Artikel, Integer> kritKat = (Artikel artikelA, Artikel artikelB) -> {
 			   if (artikelA instanceof Buch) {
 				   if(artikelB instanceof Buch)
 					   return 0;
 				   else return -1;
 			   }
 			   else if(artikelA instanceof CD) {
 				   if(artikelB instanceof CD)
 					   return 0;
 				   else if(artikelB instanceof Buch)
 					   return 1;
 				   else
 					   return -1;
 			   }
 			   else if(artikelA instanceof Video) {
 				   if(artikelB instanceof Video)
 					   return 0;
 				   else return 1;
 			   }
 			   return 0;
 		   };


			//Sortierung nach Bestand
			BiFunction<Artikel, Artikel, Integer> kritBest = (Artikel artikelA, Artikel artikelB) -> {
				return artikelA.getBestand() - artikelB.getBestand();
			};

			//Sortierung nach Preis
			BiFunction<Artikel, Artikel, Integer> kritPreis = (Artikel artikelA, Artikel artikelB) -> {
				if(artikelA.getArtikelPreis() - artikelB.getArtikelPreis() > 0) {
					return 1;
				}
				else {
					return 0;
				}
			};

			int krit1 = kritKat.apply(artikel1,artikel2);

			if(krit1 != 0) {
				return krit1 > 0 ? true : false;
			}
			else {
				int krit2 = kritBest.apply(artikel1, artikel2);

				if(krit2 != 0)
				{
					return krit2 > 0 ? true : false;
				}
				else
				{
					int krit3 = kritPreis.apply(artikel1, artikel2);

					return krit3 > 0 ? true : false;
				}
			}
    	};

    	Artikel[] sortierteListe = lager1.getSorted(sortiertKriterium);
    	int laenge = sortierteListe.length;
    	for(int i = 0; i < laenge ; i++) {
    		System.out.println(sortierteListe[i]);
    	}
	}

    /**
     * Erstellt ein Lager mit zufälligen Werten
     */
	private void erstelleRandomLager() {
  	  Random ran = new Random();
  	  int anzahlBuecher = ran.nextInt(10);
  	  int anzahlVideos = ran.nextInt(10);
  	  int anzahlCds = ran.nextInt(10);
  	  int lagerGroesse = 3 + anzahlBuecher + anzahlCds + anzahlVideos;
  	  lager1 = new Lager(lagerGroesse);

  	  lager1.anlegen(new Buch(ran.nextInt(9000)+1000, "buch"+ran.nextInt(10000), ran.nextInt(5), ran.nextDouble() * 100, "autor0", "titel"+ran.nextInt(100), "verlag"+ran.nextInt(100)));
  	  lager1.anlegen(new Video(ran.nextInt(9000)+1000, "video"+ran.nextInt(10000), ran.nextInt(100), ran.nextDouble() * 100, "titel0", ran.nextFloat() * 100, 2000));
  	  lager1.anlegen(new CD(ran.nextInt(9000)+1000, "cd"+ran.nextInt(10000), 2, ran.nextDouble() * 100, "interpret0", "titel"+ran.nextInt(100), ran.nextInt(19)+1 ));
  	  
  	  for(int i=0; i<anzahlVideos; i++)
  		  lager1.anlegen(new Video(ran.nextInt(9000)+1000, "video"+ran.nextInt(10000), ran.nextInt(100), ran.nextDouble() * 100, "titel"+ran.nextInt(100), ran.nextFloat() * 100, 2000));
  	  for(int i=0; i<anzahlCds; i++)
  		  lager1.anlegen(new CD(ran.nextInt(9000)+1000, "cd"+ran.nextInt(10000), ran.nextInt(50), ran.nextDouble() * 100, "interpret"+ran.nextInt(100), "titel"+ran.nextInt(100), ran.nextInt(19)+1 ));
  	  for(int i=0; i<anzahlBuecher; i++)
  		  lager1.anlegen(new Buch(ran.nextInt(9000)+1000, "buch"+ran.nextInt(10000), ran.nextInt(5), ran.nextDouble() * 100, "autor"+ran.nextInt(100), "titel"+ran.nextInt(100), "verlag"+ran.nextInt(100)));
    }

    /**
     * gibt eine Eingabeaufforderungs-Text aus und
     * liest aus einem Eingabestrom genau die erste Integer-Zahl
     * und ueberliest bis zum Zeilenende alle weiteren Zeichen
     *
     *  @param  in der zu lesende Eingabestrom
     *  @param  eingabeAufforderung der Eingabe-Aufforderungs-Text
     *  @return die eingegebene Integer-Zahl
     */
    public int readlnInt(Scanner in, String eingabeAufforderung) {
        System.out.print( eingabeAufforderung );
        int zahl = in.nextInt();
        in.nextLine();
        return zahl;
    }

    /**
     * gibt eine Eingabeaufforderungs-Text aus und
     * liest aus einem Eingabestrom genau die erste Double-Zahl
     * und ueberliest bis zum Zeilenende alle weiteren Zeichen
     *
     *  @param  in der zu lesende Eingabestrom
     *  @param  eingabeAufforderung der Eingabe-Aufforderungs-Text
     *  @return die eingegebene Double-Zahl
     */
    public static double readlnDouble(Scanner in, String eingabeAufforderung) {
        System.out.print( eingabeAufforderung );
        double zahl = in.nextDouble();
        in.nextLine();
        return zahl;
    }

    /**
     * gibt eine Eingabeaufforderungs-Text aus und
     * liest aus einem Eingabestrom genau die erste Float-Zahl
     * und ueberliest bis zum Zeilenende alle weiteren Zeichen
     *
     *  @param  in der zu lesende Eingabestrom
     *  @param  eingabeAufforderung der Eingabe-Aufforderungs-Text
     *  @return die eingegebene Float-Zahl
     */
    public static float readlnFloat(Scanner in, String eingabeAufforderung) {
        System.out.print( eingabeAufforderung );
        float zahl = in.nextFloat();
        in.nextLine();
        return zahl;
    }

    /**
     * gibt eine Eingabeaufforderungs-Text aus und
     * liest aus einem Eingabestrom die ganze Zeile als Zeichenkette ( String )
     * bis zum Zeilenende
     *
     *  @param  in der zu lesende Eingabestrom
     *  @param  eingabeAufforderung der Eingabe-Aufforderungs-Text
     *  @return den eingegebenen String == ganze Zeile
     */
    public static String readlnString(Scanner in, String eingabeAufforderung) {
        System.out.print( eingabeAufforderung );
        String zeile = in.nextLine();
        return zeile;
    }

    public static void main(String[] args) {
    	LagerDialog dialog = new LagerDialog();
    	dialog.start();
    }
}
