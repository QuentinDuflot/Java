#include <stdio.h>
#include "car.h"
#include "carDealerShip.h"

int main(void) {
    char extras[10][100] = {"Climatisation", "Cabriolet"};
    CAR carsArray[5];
	int numberOfCars = 0;

    CAR c1 = createCar("BMW", 120, 5, true, extras[0], 150, 6, 2340);
    CAR c2 = createCar("Porsche", 350, 3, true, extras[0], 150, 6, 2340);
    CAR c3 = createCar("Skoda", 140, 5, true, extras[0], 150, 6, 2340);
    CAR c4 = createCar("Volkswagen", 260, 5, true, extras[0], 150, 6, 2340);
    CAR c5 = createCar("Renault", 110, 3, true, extras[0], 150, 6, 2340);

    addCar(c1, carsArray, 0, &numberOfCars);
    addCar(c2, carsArray, 1, &numberOfCars);
    addCar(c3, carsArray, 2, &numberOfCars);

	//Passage en paramètre de carsArray
    printAllCars(carsArray, numberOfCars);
}