#include <stdio.h>
#include <stdint.h>
#ifndef SERIAL_H
#define SERIAL_H

enum {   //This enum is used in TX and RX
   RECEIVE_START = 0xAA,
   RECEIVE_STOP = 0xFF,
   SPINNING_START = 0xB1,
   SPINNING_STOP = 0xB2,
   TEMPERATURE_DRIVEN_START = 0xB3,
   TEMPERATURE_DRIVEN_STOP = 0xB4
};

void initializeSerial();
void sendByte(uint8_t byte);
uint8_t readByte();

#endif