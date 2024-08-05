#ifndef OLED_DRIVER_H
#define OLED_DRIVER_H
#include <stdint.h>
#define OLED_ADDRESS 0x3C

enum OledValueType{
   SPEED,
   TEMEPERATURE
};

enum CommandType{
   CONTRAST_CONTROL = 81,
   
};


void show_oled_label(enum OledValueType);
void set_oled_value(enum OledValueType, uint8_t);
void set_oled_contrast(uint8_t);
#endif