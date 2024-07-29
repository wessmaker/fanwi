#include <stdio.h>
#include <stdint.h>
#ifndef SERIAL_H
#define SERIAL_H

enum serialMessage{   //This enum is used in TX and RX
   NULL_DATA = 0xFF,
   RECEIVE_START = 0xAA,
   RECEIVE_STOP = 0xEE,
   SPINNING_START = 0xB1,
   SPINNING_STOP = 0xB2,
   TEMPERATURE_DRIVEN_START = 0xB3,
   TEMPERATURE_DRIVEN_STOP = 0xB4
};

void sendByte(uint8_t byte);
int serialAvailable();
uint8_t serialData();
uint8_t readingSerial;
extern enum serialMessage serialMessage;

#endif