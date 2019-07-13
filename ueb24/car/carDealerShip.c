#include <stdio.h>
#include "car.h"
#include "carDealerShip.h"
#define MAX_NUMBER_CARS 5
//CAR carsArray[5]; inutile car tu auras accès à celui du main lors de la compilation

void addCar(CAR car, CAR *carsArray, int pos, int *numberOfCars) {
    if(pos >= 0 && pos < MAX_NUMBER_CARS){
        carsArray[pos] = car;
		*numberOfCars = *numberOfCars + 1;
    }else{
		printf("Invalid position!");
	}
}

int removeCar(CAR car);

//Il faut mettre le tableau en paramètre sinon il ne sait pas ce qu'est carsArray
//alternative void printAllCars(CAR *carsArray){...}
void printAllCars(CAR carsArray[], int numberOfCars) {
    for (int i = 0; i < numberOfCars; i++) {
        printCar(carsArray[i]);
    }
}