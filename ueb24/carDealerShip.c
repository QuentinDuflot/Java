#include <stdio.h>
#include "carDealerShip.h"
CAR carsArray[5];

void addCar(CAR car, CAR *carsArray) {
    for (int i = 0; i < 5; i++) {
        carsArray[i] = car;
    }
}

int removeCar(CAR car);

void printAllCars() {
    for (int i = 0; i < 5; i++) {
        printCar(carsArray[i]);
    }
}