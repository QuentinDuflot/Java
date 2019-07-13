#include <stdio.h>
#include "linearMotionFunctions.h"
#include "mecanicalQuantitiesFunctions.h"

void printMenu() 
{

	printf(
		"1: Geschwindigkeit berechnen \n"
		"2: Beschleunigung berechnen \n"
		"3: Impuls berechnen \n"
		"4: Weg einer gleichfoermigen geradlinie Bewegung \n"
		"5: Weg einer gleichmaessig beschleunigten geradlinigen Bewegung\n"
		"6: Geschwindigkeit einer gleichmaessig beschleunigung \n"
		"0: Exit\n"
	);
}

double readValue(char *msg)
{
	double result;
	printf("%s", msg);
	scanf("%lf", &result);
	return result;
}
int main() 
{
	int choice;
	do
	{
		printMenu();
		scanf("%d", &choice);

		switch (choice)
		{
		case 1:
			printf("Geschwindigkeit: %lf m/s \n",
				calculateSpeed(
				readValue("Geben Sie S2 in Meter ein\n"), 
				readValue("Geben Sie S1 in Meter ein\n"),
				readValue("Geben Sie T2 in Sekunde ein\n"),
				readValue("Geben Sie T1 in Sekunde ein\n")
				)
			);
			break;

		case 2:
			printf("Beschleunigung: %lf m/(s^2) \n",
				calculateAcceleration
				(
					readValue("Geben Sie V2 in Meter/Sekunde ein\n"),
					readValue("Geben Sie V1 in Meter/Sekunde  ein\n"),
					readValue("Geben Sie T2 in Sekunde ein\n"),
					readValue("Geben Sie T1 in Sekunde ein\n")
				)
			);
			break;

		case 3:
			printf("Impuls : %lf (Kg*m)/s \n",
				calculateMomentum
				(
					readValue("Geben Sie M in Kilogramm ein\n"),
					readValue("Geben Sie V in Meter/Sekunde ein\n")
				)
			);
			break;

		case 4:
			printf("Strecke : %lf m \n",
				calculateDistanceUniformLinearMotion(
					readValue("Geben Sie V in Meter/Sekunde ein\n"),
					readValue("Geben Sie T in Sekunde ein\n"),
					readValue("Geben Sie T0 in Sekunde ein\n")
				)
			);
			break;

		case 5:
			printf("Strecke : %lf m \n",
				calculateDistanceNonUniformLinearMotion(
					readValue("Geben Sie V in Meter/Sekunde ein\n"),
					readValue("Geben Sie V0 in Meter/Sekunde ein\n"),
					readValue("Geben Sie A in Meter/(Sekunde^2) ein\n")
				)
			);
			break;

		case 6:
			printf("Geschwindigkeit : %lf m/s \n",
				calculateSpeedNonUniformLinearMotion(
					readValue("Geben Sie A in Meter/(Sekunde^2) ein\n"),
					readValue("Geben Sie T in Sekunde ein\n"),
					readValue("Geben Sie T0 in Sekunde ein\n"),
					readValue("Geben Sie V0 in Meter/Sekunde ein\n")
				)
			);
			break;

		case 0:
			printf("Ende des Programms!");
			break;

		default:
			printf("Falsche Eingabe!\n");
			break;
		}
	} while (choice != 0);

	return 0;
}