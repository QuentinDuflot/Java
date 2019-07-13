#include <stdio.h>
#include "car.h"
#include "carDealerShip.h"
//CAR carsArray[5]; inutile car tu auras accès à celui du main lors de la compilation

void addCar(CAR car, CAR *carsArray) {
    for (int i = 0; i < 5; i++) {
        carsArray[i] = car;
    }
}

int removeCar(CAR car);

//Il faut mettre le tableau en paramètre sinon il ne sait pas ce qu'est carsArray
//alternative void printAllCars(CAR *carsArray){...}
void printAllCars(CAR carsArray[]) {
    for (int i = 0; i < 5; i++) {
        printCar(carsArray[i]);
    }
}