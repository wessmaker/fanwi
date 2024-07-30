#include "drivers/pins.h"
#include "serial.c"
#include "drivers/serial.h"

enum serialMessage serialMessage;

uint8_t handelingData = 0;

void handle_receive_start(void){
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
            receive_speed_value();
            break;
         case RECEIVE_OFFSET_VALUE:
            receive_offset_value();
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
   initializePins();
   timer_initialize();
   while (1){
      handle_receive_start();


   }
   return 0;
}


