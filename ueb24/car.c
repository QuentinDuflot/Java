#include <stdio.h>
#include <stdbool.h>
#include <string.h>
#include "car.h"

CAR createCar(char brand[], float maxSpeed, short numberDoors, bool ABS, char extras[],
    float horsepower, char cylinder, float capacity) {
    
    ENGINE engine = {horsepower, cylinder, capacity};
    CAR result = {"", maxSpeed, numberDoors, ABS};

    for(int i = 0; i < 20; i++) {
        result.brand[i] = brand[i];
    }

    for (int i = 0; i < 10; i++) {
        for (int j = 0; j < 100; j++) {
            result.extras[i][j] = extras[i * 100 + j];
        }
    }

    return result;
}

int estimateValue(CAR car) {
    int carValue = 50;
    carValue *= car.maxSpeed;
    carValue *= car.numberDoors;
    
    if (car.ABS == true) {
        carValue += 5000;
    }
    
    if (strncmp(car.brand, "Porsche", 20) == 0) {
        carValue *= 2;
    }

    return carValue;
}

void printCar(CAR car) {
    printf("CAR CHARACTERISTICS\n");
    printf("--------------------\n");
    printf("BRAND: \t\t\t%s\n", car.brand);
    printf("MAX SPEED: \t\t%.2f km/h\n", car.maxSpeed);
    printf("DOORS NUMBER: \t\t%i\n", car.numberDoors);
    /* printf("ABS: \t\t%i\n", car.ABS); */

    printf("EXTRAS: \t\t");
    for (int i = 0; i < 10; i++) {
        if (car.extras[i][0] != '\0') {
            printf("%s\t", car.extras[i]);
        }
    }

    printf("\nENGINE: \t\thorsepower: %.2f \tcylinder: %i \tcapacity: %.2f\n", car.engine.horsepower, car.engine.cylinder, car.engine.capacity);
    printf("ESTIMATED VALUE: \t%d€\n", estimateValue(car));
}