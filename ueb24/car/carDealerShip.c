#include <stdio.h>
#include "car.h"
#include "carDealerShip.h"
#define MAX_NUMBER_CARS 5

void addCar(CAR car, CAR *carsArray, int position, int *numberOfCars) {
    if (position >= 0 && position < MAX_NUMBER_CARS){
        carsArray[position] = car;
		*numberOfCars = *numberOfCars + 1;
    } else {
		printf("Invalid position!");
	}
}

void removeCar(CAR *carsArray, int position, int *numberOfCars) {
    if (position >= 0 && position < MAX_NUMBER_CARS) {
        for (int i = position; i < MAX_NUMBER_CARS; i++) {
            carsArray[i] = carsArray[i + 1];
        }
        *numberOfCars = *numberOfCars - 1;
    } else {
        printf("Invalid position");
    }
}

void printAllCars(CAR carsArray[], int numberOfCars) {
    for (int i = 0; i < numberOfCars; i++) {
        printCar(carsArray[i]);
    }
}