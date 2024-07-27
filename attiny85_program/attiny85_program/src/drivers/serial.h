#include <stdio.h>
#include <stdint.h>
#ifndef SERIAL_H
#define SERIAL_H

void initializeSerial();
void sendByte(uint8_t byte);
uint8_t readByte();

#endif