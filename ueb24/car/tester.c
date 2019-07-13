#include <stdio.h>
#include "car.c"

int main(void) {
    char extras[10][100] = {"Climatisation", "Cabriolet"};

    CAR c1 = createCar("BMW", 260, 5, false, extras[0], 150, 6, 2340);
    printCar(c1);
}