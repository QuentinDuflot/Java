#pragma once
#include <stdio.h>

void addCar(CAR car, CAR *carsArray, int position, int *numberOfCars);
void removeCar(CAR *carsArray, int position, int *numberOfCars);
void printAllCars(CAR carsArray[], int numberOfCars);