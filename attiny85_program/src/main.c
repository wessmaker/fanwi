#include "settings/pins.h"
#include "serial/serial.h"
#include "fan/fan.h"
#include "fan/pwm.h"

enum serialMessage serialMessage;
uint8_t handelingData = 0;
uint8_t get_serial_data(void);

void handle_received_command(void);
void set_fan_spinning_mode(int);
void set_fan_spinning_mode(int);
void set_fan_temperature_driven_mode(int);
void set_fan_temperature_driven_mode(int);
void receive_fan_speed_value(void);
void receive_fan_offset_value(void);
void handle_fan_spinning_modes(void);
void pins_initialize(void);
void timer_initialize(void);
void handle_receiving(void);
void handle_fan_spinning_modes(void);

void handle_receiving(void){
   if (get_serial_data() == RECEIVE_START && !handelingData){
      handelingData = 1;
      handle_received_command();
   } else{
      handelingData = 0;
   }
}

void handle_received_command(void){
   if (handelingData){
      switch (get_serial_data()){
         case SPINNING_START:
            set_fan_spinning_mode(1);
            break;
         case SPINNING_STOP:
            set_fan_spinning_mode(0);
            break;
         case TEMPERATURE_DRIVEN_START:
            set_fan_temperature_driven_mode(1);
            break;
         case TEMPERATURE_DRIVEN_STOP:
            set_fan_temperature_driven_mode(0);
            break;
         case RECEIVE_SPEED_VALUE:
            receive_fan_speed_value();
            break;
         case RECEIVE_OFFSET_VALUE:
            receive_fan_offset_value();
            break;
         case RECEIVE_START:
            handelingData = 0;
            break;
         case NULL_DATA:
            handelingData = 0;
         case RECEIVE_STOP:
            handelingData = 0;
            break;
         default:
            handelingData = 0;
            break;
      }
   }
   handelingData = 0;
}

int main(){
   pins_initialize();
   timer_initialize();
   pwm_initialize();
   while (1){
      handle_receiving();
      handle_fan_spinning_modes();
   }
   return 0;
}