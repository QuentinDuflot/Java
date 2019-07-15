#include <stdio.h>
#include "car.h"
#include "carDealerShip.h"
#define SHOW_GARAGE 1
#define ADD_CAR 2
#define REMOVE_CAR 3
#define QUICK_TESTER 4
#define QUIT 0

double readValueDouble(char *message) {
    double result;
    printf("%s", message);
    scanf("%lf", &result);
    return result;
}

int readValueInt(char *message) {
    int result;
    printf("%s", message);
    scanf("%d", &result);
    return result;
}

float readValueFloat(char *message) {
    float result;
    printf("%s", message);
    scanf("%f", &result);
    return result;
}

short readValueShort(char *message) {
    short result;
    printf("%s", message);
    scanf("%hd", &result);
    return result;
}

/*char[] readValueString(char *message) {
	char result[20];
    printf("%s", message);
    scanf("%s", result);
    return result;
}*/

char readValueChar(char *message) {
    char result;
    printf("%s", message);
    scanf("%s", &result);
    return result;
}

bool readValueBool(char *message){
	bool result;
	int temp;
	printf("%s", message);
	scanf("%d", &temp);
	result = (bool) temp;
	return result;
}
void quickTest() {
    CAR carsArray[5];
	int numberOfCars = 0;
    char extras[10][100] = {"Climatisation", "Cabriolet", "Cruise Control"};

    CAR c1 = createCar("BMW", 120, 5, true, extras[0], 150, 6, 2340);
    CAR c2 = createCar("Porsche", 350, 3, false, extras[0], 150, 6, 2340);
    CAR c3 = createCar("Skoda", 140, 5, true, extras[0], 150, 6, 2340);
    CAR c4 = createCar("Volkswagen", 260, 5, true, extras[0], 150, 6, 2340);
    CAR c5 = createCar("Renault", 110, 3, false, extras[0], 150, 6, 2340);

    addCar(c1, carsArray, 0, &numberOfCars);
    addCar(c2, carsArray, 1, &numberOfCars);
    addCar(c3, carsArray, 2, &numberOfCars);
    printAllCars(carsArray, numberOfCars);

    removeCar(carsArray, 1, &numberOfCars);
    printf("\n-----REMOVING CARS-----\n");
    printAllCars(carsArray, numberOfCars);
}

void printMenu() {
    printf(
        "\n\tMANAGE CARS\n"
        "----------------------------------\n"
        "\t%d. Show garage\n"
        "\t%d. Add new car to garage\n"
        "\t%d. Remove car from garage\n"
        "\t%d. Quick test\n"
        "\t%d. Quit program\n",
        SHOW_GARAGE, ADD_CAR, REMOVE_CAR, QUICK_TESTER, QUIT
    );
}

int main() {
    int maxNumbersOfCars = 5;
    CAR carsArray[maxNumbersOfCars];
	int numberOfCars = 0;
    int position = 0;
    char extras[10][100] = {"Climatisation", "Cabriolet", "Cruise Control"};

    int choice;

    do {
        printMenu();
        printf("\nChoose an option: ");
        scanf("%d", &choice);
		int pos; 

        switch (choice) {
        case SHOW_GARAGE:
            printAllCars(carsArray, numberOfCars);
            break;

        case ADD_CAR:
            if (numberOfCars <= maxNumbersOfCars) {
				char name[20];
				printf("Car's brand name: ");
				scanf("%s",name);
				addCar(createCar(
                        name,
                        readValueFloat("Car's max speed: "),
                        readValueShort("Car's doors number: "),
                        readValueBool("ABS (0:true/1:false): "),
                        extras[0],
                        readValueFloat("Car's horsepower: "),
                        readValueChar("Car's cylinder: "),
                        readValueFloat("Car's capacity: ")
                    ),
					carsArray,
					position,
					&numberOfCars);
            } else {
                printf("Garage is full");
            }
            break;

        case REMOVE_CAR:
            
			pos = readValueInt("Which position would you like to remove?");
            removeCar(carsArray, pos - 1, &numberOfCars);
            break;

        case QUICK_TESTER:
            quickTest();
            break;
        
        case QUIT:
            printf("Quit program\n");
            break;
        
        default:
            printf("Wrong choice\n");
            break;
        }

    } while (choice != 0);
	
	return 0;
}