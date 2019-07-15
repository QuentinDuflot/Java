#include "readMethods.h"
double readValueDouble(char *message) {
    double result;
    printf("%s", message);
    scanf("%lf", &result);
    return result;
}

int readValueInt(char *message) {
    int result;
    printf("%s", message);
    scanf("%d", &result);
    return result;
}

float readValueFloat(char *message) {
    float result;
    printf("%s", message);
    scanf("%f", &result);
    return result;
}

short readValueShort(char *message) {
    short result;
    printf("%s", message);
    scanf("%hd", &result);
    return result;
}

char readValueChar(char *message) {
    char result;
    printf("%s", message);
    scanf("%s", &result);
    return result;
}

bool readValueBool(char *message){
	bool result;
	int temp;
	printf("%s", message);
	scanf("%d", &temp);
	result = (bool) temp;
	return result;
}