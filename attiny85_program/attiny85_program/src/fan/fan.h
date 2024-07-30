#ifndef FAN_H
#define FAN_H
#include <stdint.h>

void set_fan_spinning_mode(int);
void set_fan_temperature_driven_mode(int);
void set_fan_speed_value(uint8_t);
void set_fan_offset_value(uint8_t);
void set_target_temperature_value(uint8_t);
void handle_fan_spinning_modes();
#endif