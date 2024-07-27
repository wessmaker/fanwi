#include "serial.h"
#define BAUDRATE 9600
#define TX_PIN 4
#define RX_PIN 3
#define BIT_DELAY (1000000 / BAUDRATE)
#define START_BIT_DELAY BIT_DELAY
#define END_BIT_DELAY BIT_DELAY

void initializeSerial();
void sendByte(uint8_t byte);
uint8_t readByte();

void initializeSerial(){}

void sendByte(uint8_t byte){};

