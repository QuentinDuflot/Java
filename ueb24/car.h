#include <stdio.h>
#include <stdbool.h>

typedef struct {
    float horsepower;
    char cylinder;
    float capacity;
} ENGINE;

typedef struct {
    char brand[20];
    float maxSpeed;
    short numberDoors;
    bool ABS;
    char extras[10][100];
    ENGINE engine;
} CAR;

CAR creadteCar(char brand[], float maxSpeed, short numberDoors, bool ABS, char extras[], float horsepower, char cylinder, float capacity);
int estimateValue();