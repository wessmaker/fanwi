#include "pwm.h"
#include <stdint.h>

void set_fan_spinning_mode(int);
void set_fan_temperature_driven_mode(int);
void set_fan_speed_value(uint8_t);
void set_fan_offset_value(uint8_t);
void set_target_temperature_value(uint8_t);
void handle_fan_spinning_modes(void);

int fanSpinning = 0;
int fanTemperatureDriven = 0;
uint8_t fanSpeed = 0;
uint8_t fanOffset = 0;
uint8_t fanTargetTemperature = 0;

uint8_t sensorTemperature = 0;

void set_fan_spinning_mode(int mode){
   fanSpinning = mode;
}
void set_fan_temperature_driven_mode(int mode){
   fanTemperatureDriven = mode;
}
void set_fan_speed_value(uint8_t value){
   fanSpeed = value;
   set_fan_pwm(value);
}
void set_fan_offset_value(uint8_t value){
   fanOffset = value;
}
void set_target_temperature_value(uint8_t value){
   fanTargetTemperature = value;
}

void handle_fan_spinning_modes(){
   switch (fanTemperatureDriven){
   case 0:
      set_fan_pwm(fanSpeed);

      break;
   case 1:
      //TODO implement PID-like control here

      break;
   }
}