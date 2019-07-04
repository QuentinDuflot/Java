#include <stdio.h>
#define MWST 0.2
#define SKONTO 0.02
#define SMALLER_THAN_0(x) ((x) <= 0)
#define EXIT 0
#define BETRAG 1
#define FIBO 2

/*--------------------------AUFGABE 1---------------------------------------------------------------*/
double berechneSteuer(double netto, double steuer)
{
	return netto*steuer;
}

double berechneBrutto(double netto)
{
	return netto + berechneSteuer(netto, MWST);
}

double berechneRechnungBetrag(double brutto)
{
	return brutto + berechneSteuer(brutto,SKONTO);
}

double readBetrag()
{
	int loop = 0;
	double netto;
	while(loop == 0)
	{
		printf("\nGeben Sie bitte den Netto-Betrag.");
		scanf("%lf",&netto);
		
		if(SMALLER_THAN_0(netto)
		{
			printf("\nFehler: %lf ist kleiner als 0!",netto);
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
	double mwst = berechneSteuer(netto,MWST);
	double skonto = berechneSteuer(brutto,SKONTO);
	printf("\nNettopreis           Euro %lf",netto);
	printf("\n+ 20% MwSt           Euro %lf",mwst);
	printf("\n============================");
	printf("\nBruttopreis          Euro %lf",brutto);
	printf("\n- 2% Skonto          Euro %lf",skonto);
	printf("\n============================");
	printf("\nRechnungsbetrag      Euro %lf",rechnungBetrag);
}
/*--------------------------AUFGABE 2---------------------------------------------------------------*/

int readInt()
{
	int loop = 0;
	int nummer;
	while(loop == 0)
	{
		printf("\nGeben Sie bitte ein Integer.");
		scanf("%d",&nummer);
		
		if(SMALLER_THAN_0(nummer)
		{
			printf("\nFehler: %d ist kleiner als 0!",nummer);
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

	for(i = 2; i <= n; i++) 
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
	for(i = 0; i <= n; i++) 
	{
		printf("\nFibonnacci(%d): %d",i,berechneFibStelleN(i));
	}
}

/*--------------------------MAIN--------------------------------------------------------------------*/

int main()
{
	int choice;
	do
	{
		printf("\nRechnungsbetrag: %d\nFibonnacci: %d\nExit: %d",BETRAG,FIBO,EXIT);
		switch(choice)
		{
			case EXIT: printf("\nEnd of the programm");break;
			case BETRAG: printRechnungBetrag();break;
			case FIBO: printFib();break;
			default: printf("Diese Funktion existiert nicht");break;
		}
	}while(choice != EXIT);
	return 0;
}