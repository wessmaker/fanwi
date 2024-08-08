#ifndef OLED_DRIVER_H
#define OLED_DRIVER_H
#include <stdint.h>
#define OLED_ADDRESS 0x3C

enum OledValueType{
   SPEED,
   TEMPERATURE
};

enum CommandType{
   CONTRAST_CONTROL = 0x81,
   ADRESSING_MODE_SELECTION = 0x20,
   ADRESSING_HORIZONTAL_MODE = 0x00,
   COLUMN_RANGE_SELECTION = 0x21,
   PAGE_ADDRESS_RANGE = 0x22
};



void show_oled_label(enum OledValueType);
void set_oled_value(enum OledValueType, uint8_t);
void set_oled_contrast(uint8_t);
#endif