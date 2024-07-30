#include <stdio.h>
#include <stdint.h>
#ifndef SERIAL_H
#define SERIAL_H

enum{   //This enum is used in TX and RX
   NULL_DATA = 0xFF,
   RECEIVE_START = 0xA1,
   RECEIVE_STOP = 0xA2,
   SPINNING_START = 0xB1,
   SPINNING_STOP = 0xB2,
   TEMPERATURE_DRIVEN_START = 0xB3,
   TEMPERATURE_DRIVEN_STOP = 0xB4,
   RECEIVE_SPEED_VALUE = 0xC1,
   RECEIVE_OFFSET_VALUE = 0xC2,
   RECEIVE_TARGET_TEMPERATURE_VALUE = 0xC3
}serialMessage;

void send_byte(uint8_t byte);
int is_serial_available(void);
uint8_t get_serial_data(void);
uint8_t readingSerial;
#endif