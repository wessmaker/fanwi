#include <stdio.h>
#include <stdint.h>
#ifndef SERIAL_H
#define SERIAL_H

enum SerialMessage {   //This enum is used in TX and RX
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
};


void transmit_message(enum SerialMessage, uint8_t); //If no value has to be transmitted, set value to 0
void write_serial_data(uint8_t);
void receive_fan_speed_value(void);
void receive_fan_offset_value(void);
int is_serial_available(void);
uint8_t get_serial_data(void);
uint8_t readingSerial;
#endif