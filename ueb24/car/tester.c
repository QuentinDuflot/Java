#include <stdio.h>
#include "car.h"
#include "carDealerShip.h"
#define SHOW_GARAGE 1
#define ADD_CAR 2
#define REMOVE_CAR 3
#define QUIT 0

double readValueDouble(char *message) {
    double result;
    printf("%s", message);
    scanf("%lf", &result);
    return result;
}

float readValueFloat(char *message) {
    float result;
    printf("%s", message);
    scanf("%s", &result);
    return result;
}

short readValueShort(char *message) {
    short result;
    printf("%s", message);
    scanf("%lf", &result);
    return result;
}

bool readValueBool(char *message) {
    bool result;
    printf("%s", message);
    scanf("%lf", &result);
    return result;
}

char readValueChar(char *message) {
    char result;
    printf("%s", message);
    scanf("%lf", &result);
    return result;
}

void printMenu() {
    printf(
        "\n\tMANAGE CARS\n"
        "----------------------------------\n"
        "\t1. Create a new car\n"
        "\t2. Print a car\n"
        "\t3. Create a garage\n"
        "\t4. Show cars in garage\n"
        "\t5. Add car to carage\n"
        "\t6. Remove a car from the garage\n"
    );
}

int main() {
    CAR carsArray[5];
	int numberOfCars = 0;
    int position = 0;
    char extras[10][100] = {"Climatisation", "Cabriolet", "Cruise Control"};

    int choice;

    do {
        printMenu();
        printf("\nChoose an option: ");
        scanf("%d", &choice);

        switch (choice) {
        case SHOW_GARAGE:
            printAllCars(carsArray, numberOfCars);
            break;

        case ADD_CAR:
            addCar(
                createCar(
                    readValueChar("\nCar's brand name: "),
                    readValueFloat("\nCar's max speed: "),
                    readValueShort("\nCar's doors number: "),
                    readValueBool("\nABS (true/false): "),
                    extras,
                    readValueFloat("\nCar's horsepower: "),
                    readValueChar("\nCar's cylinder: "),
                    readValueFloat("\nCar's capacity: ")
                ),
                carsArray,
                position,
                numberOfCars
            );
            break;

        case REMOVE_CAR:
            break;
        
        case QUIT:
            printf("Quit program\n");
            break;
        
        default:
            printf("Wrong choice\n");
            break;
        }

        return 0;
    } while (choice != 0);
}

/*int main(void) {

    char extras[10][100] = {"Climatisation", "Cabriolet", "Cruise Control"};
    CAR carsArray[5];
	int numberOfCars = 0;

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
    printf("\nREMOVING CARS\n");
    printAllCars(carsArray, numberOfCars);
}*/