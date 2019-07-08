#include <stdio.h>
#include <limits.h>
#define MWST 0.2
#define SKONTO 0.02
#define MINIMUM_SIGNED "Minimum signed"
#define MAXIMUM_SIGNED "Maximum signed"
#define MAXIMUM_UNSIGNED "Maximum unsigned"
#define EXIT 0
#define BETRAG 1
#define FIBO 2
#define LIMITS 3
#define LIMITS_VARIANT 4

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
    while (c + 1 < 0) {
        --c;
    }
    printf("\nMin value char: %d", (int)c);
}

void printMaxChar() {
    char c = 1;
    while (c + 1 > 0) {
        ++c;
    }
    printf("\nMax value char: %d", (int)c);
}

void printMinShort() {
    short s = 1;
    while (s + 1 < 0) {
        --s;
    }
    printf("\nMin value char: %d", (int)s);
}

void printMaxShort() {
    short s = 1;
    while (s + 1 > 0) {
        ++s;
    }
    printf("\nMax value char: %d", (int)s);
}

void printMinUChar() {
    unsigned char c = 1;
    while (c + 1 < 0) {
        --c;
    }
    printf("\nMin value char: %d", (int)c);
}

void printMaxUChar() {
    unsigned char c = 1;
    while (c + 1 > 0) {
        ++c;
    }
    printf("\nMax value char: %d", (int)c);
}

void printMinUShort() {
    unsigned short s = 1;
    while (s + 1 < 0) {
        --s;
    }
    printf("\nMin value char: %d", (int)s);
}

void printMaxUShort() {
    unsigned short s = 1;
    while (s + 1 > 0) {
        ++s;
    }
    printf("\nMax value char: %d", (int)s);
}

void printMinUInt() {
    unsigned int i = 1;
    while (i + 1 < 0) {
        --i;
    }
    printf("\nMin value char: %d", (int)i);
}

void printMaxUInt() {
    unsigned int i = 1;
    while (i + 1 > 0) {
        ++i;
    }
    printf("\nMax value char: %d", (int)i);
}

void printLimitsTyp() {
    printf("\nMin & max value char:\n"); printMinChar(); printMaxChar();
    printf("\n[LIMITS] Min & max value char: %d - %d\n", CHAR_MIN, CHAR_MAX);
    printf("\nMin & max value short:\n"); printMinShort(); printMaxShort();
    printf("\n[LIMITS] Min & max value short: %d - %d\n", SHRT_MIN, SHRT_MAX);
    printf("\nMin & max value unisgned char:\n"); /*printMinUChar();*/ printMaxUChar();
    printf("\n[LIMITS] Min & max value unisgned char: %d - %d\n", 0, UCHAR_MAX);
    printf("\nMin & max value unsigned short:\n"); /*printMinUShort();*/ printMaxUShort();
    printf("\n[LIMITS] Min & max value unsigned short: %d - %d\n", 0, USHRT_MAX);
    printf("\nMin & max value unsigned int: \n"); /*printMinUInt();*/ printMaxUInt();
    printf("\n[LIMITS] Min & max value unsigned int: %d - %d\n", 0, UINT_MAX);
}
/*--------------------------AUFGABE 3 Variant---------------------------------------------------------------*/

void printMaxSignedValues() {
	printf("%s Char %d\n", MAXIMUM_SIGNED, (char)((unsigned char)~0 >> 1));
	printf("%s Short %d\n", MAXIMUM_SIGNED, (short)((unsigned short)~0 >> 1));
	printf("%s Int %d\n", MAXIMUM_SIGNED, (int)((unsigned int)~0 >> 1));
}

void printMaxUnsignedValues() {
	printf("%s Char %d\n", MAXIMUM_UNSIGNED, (unsigned char)~0);
	printf("%s Short %d\n", MAXIMUM_UNSIGNED, (unsigned short)~0);
	printf("%s Int %d\n", MAXIMUM_UNSIGNED, (unsigned int)~0);
}

void printMaxSignedConst() {
	printf("%s Char coonstant %d\n", MAXIMUM_SIGNED, CHAR_MAX);
	printf("%s Short constant %d\n", MAXIMUM_SIGNED, SHRT_MAX);
	printf("%s Int constant %d\n", MAXIMUM_SIGNED, INT_MAX);
}
void printMaxUnsignedConst() {
	printf("%s Char coonstant %d\n", MAXIMUM_UNSIGNED, UCHAR_MAX);
	printf("%s Short constant %d\n", MAXIMUM_UNSIGNED, USHRT_MAX);
	printf("%s Int constant %d\n", MAXIMUM_UNSIGNED, UINT_MAX);
}

void printMinSignedConst() {
	printf("%s Char coonstant %d\n", MINIMUM_SIGNED, CHAR_MIN);
	printf("%s Short constant %d\n", MINIMUM_SIGNED, SHRT_MIN);
	printf("%s Int constant %d\n", MINIMUM_SIGNED, INT_MIN);
}

void printMinSignedValues() {

	printf("%s Char %d\n", MINIMUM_SIGNED, -(char)((unsigned char)~0 >> 1) - 1);
	printf("%s Short %d\n", MINIMUM_SIGNED, -(short)((unsigned short)~0 >> 1) - 1);
	printf("%s Int %d\n", MINIMUM_SIGNED, -(int)((unsigned int)~0 >> 1) - 1);
}

void printMaxValues() {
	printMaxSignedValues();
	printMaxSignedConst();
	printMaxUnsignedValues();
	printMaxUnsignedConst();
}

void printMinValues() {

	printMinSignedValues();
	printMinSignedConst();
}

void printMaxAndMinValues()
{
	printMaxValues();
	printMinValues();
}

/*--------------------------MAIN--------------------------------------------------------------------*/

int main()
{
	int choice;
	do
	{
		printf("\nRechnungsbetrag: %d\nFibonnacci: %d\nLimits: %d\nLimits variant: %d\nExit: %d\n", BETRAG, FIBO, LIMITS,LIMITS_VARIANT, EXIT);
		scanf("%d", &choice);
		switch (choice)
		{
		case EXIT: printf("\nEnd of the programm\n");break;
		case BETRAG: printRechnungBetrag();break;
		case FIBO: printFib();break;
        case LIMITS: printLimitsTyp(); break;
		case LIMITS_VARIANT: printMaxAndMinValues();break;
		default: printf("\nDiese Funktion existiert nicht\n");choice = EXIT;break;
		}
	} while (choice != EXIT);
	return 0;
}