#include <stdio.h>
#include <limits.h>
#define MWST 0.2
#define SKONTO 0.02
#define EXIT 0
#define BETRAG 1
#define FIBO 2
#define LIMITS 3

/*--------------------------AUFGABE 1---------------------------------------------------------------*/

double berechneSteuer(double betrag, double steuer)
{
	return betrag * steuer;
}

double berechneBrutto(double netto)
{
	return netto + berechneSteuer(netto, MWST);
}

double berechneRechnungBetrag(double brutto)
{
	return brutto + berechneSteuer(brutto, SKONTO);
}

double readBetrag()
{
	int loop = 0;
	double netto;
	while (loop == 0)
	{
		printf("\nGeben Sie bitte den Netto-Betrag.\n");
		scanf("%lf", &netto);

		if (netto <= 0)
		{
			printf("\nFehler: %lf ist kleiner als 0!\n", netto);
		}
		else
		{
			loop = 1;
		}
	}
	return netto;
}

void printRechnungBetrag()
{
	double netto = readBetrag();
	double brutto = berechneBrutto(netto);
	double rechnungBetrag = berechneRechnungBetrag(brutto);
	double mwst = berechneSteuer(netto, MWST);
	double skonto = berechneSteuer(brutto, SKONTO);
	printf("\nNettopreis                  Euro %.2lf", netto);
	printf("\n+ 20 Prozent MwSt           Euro %.2lf", mwst);
	printf("\n====================================");
	printf("\nBruttopreis                 Euro %.2lf", brutto);
	printf("\n- 2 Prozent Skonto          Euro %.2lf", skonto);
	printf("\n=====================================");
	printf("\nRechnungsbetrag             Euro %.2lf\n", rechnungBetrag);
}

/*--------------------------AUFGABE 2---------------------------------------------------------------*/

int readInt()
{
	int loop = 0;
	int nummer;
	while (loop == 0)
	{
		printf("\nGeben Sie bitte ein Integer.\n");
		scanf("%d", &nummer);

		if (nummer <= 0)
		{
			printf("\nFehler: %d ist kleiner als 0!\n", nummer);
		}
		else
		{
			loop = 1;
		}
	}
	return nummer;
}

int berechneFibStelleN(int n)
{
	int u = 0;
	int v = 1;
	int i, temp;

	for (i = 2; i <= n; i++)
	{
		temp = u + v;
		u = v;
		v = temp;
	}
	return v;
}

void printFib()
{
	int i;
	int n = readInt();
	for (i = 0; i <= n; i++)
	{
		printf("\nFibonnacci(%d): %d\n", i, berechneFibStelleN(i));
	}
}

/*--------------------------AUFGABE 3---------------------------------------------------------------*/

void printMinChar() {
    char c = 1;
    while (c + 1 > 0) {
        ++c;
    }
    printf("\nMin value char: %d", (int)c);
    return 0;
}

void printMaxChar() {
    char c = 1;
    while (c + 1 < 0) {
        --c;
    }
    printf("\nMin value char: %d", (int)c);
    return 0;
}

void printMinShort() {
    short s = 1;
    while (s + 1 > 0) {
        ++s;
    }
    printf("\nMin value char: %d", (int)s);
    return 0;
}

void printMaxShort() {
    short s = 1;
    while (s + 1 < 0) {
        --s;
    }
    printf("\nMin value char: %d", (int)s);
    return 0;
}

void printLimitsTyp() {
    printf("\nMin & max value char: %d - %d\n", CHAR_MIN, CHAR_MAX);
    printf("\nMin & max value short: %d - %d\n", SHORT_MIN, SHORT_MAX);
    printf("\nMin & max value unisgned char: %d - %d\n", UCHAR_MIN, UCHAR_MAX);
    printf("\nMin & max value unsigned short: %d - %d\n", USHORT_MIN, USHORT_MAX);
    printf("\nMin & max value unsigned int: %d - %d\n", UINT_MIN, UINT_MAX);
}

/*--------------------------MAIN--------------------------------------------------------------------*/

int main()
{
	int choice;
	do
	{
		printf("\nRechnungsbetrag: %d\nFibonnacci: %d\nLimits: %d\nExit: %d\n", BETRAG, FIBO, LIMITS, EXIT);
		scanf("%d", &choice);
		switch (choice)
		{
		case EXIT: printf("\nEnd of the programm\n");break;
		case BETRAG: printRechnungBetrag();break;
		case FIBO: printFib();break;
        case LIMITS: printLimitsTyp(); break;
		default: printf("\nDiese Funktion existiert nicht\n");choice = EXIT;break;
		}
	} while (choice != EXIT);
	return 0;
}