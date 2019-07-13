#pragma once
#include <stdio.h>

void addCar(CAR car, CAR *carsArray, int pos, int *numberOfCars);
int removeCar(CAR car);
void printAllCars(CAR carsArray[], int numberOfCars);