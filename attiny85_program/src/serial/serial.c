#include "serial.h"
#include "settings/settings.h"
#include "settings/registers.h"
#include "settings/pins.h"
#include "serial_timer.h"
#include "fan/fan.h"
#include "settings/pins.h"

void transmit_message(enum SerialMessage SerialMessage, uint8_t value);
void readingSerialData(uint8_t);
void receive_fan_speed_value(void);
void receive_fan_offset_value(void);
int is_serial_available(void);

uint8_t get_serial_data(void);
uint8_t readingSerial = 0;
uint8_t data;

void write_serial_data(uint8_t data){
   PORTB &= ~(1 << PINB3);
   delay_bits(1);
   for (uint8_t i = 0; i < 8; i++){
      if (data & 0x01){
         PORTB |= (1 << PINB3);
      }else{
         PORTB &= ~(1 << PINB3);
      }
      delay_bits(1);
   }
   PORTB &= ~(1 << PINB3);  //No parity bit
   delay_bits(1);
   PORTB |= (1 << PINB3);
   delay_bits(2); //Two end bits
}


void transmit_message(enum SerialMessage serialMessage, uint8_t value){
   switch (serialMessage){
   case NULL_DATA:
      break;
   case RECEIVE_START:
      write_serial_data(RECEIVE_START);
      break;
   case RECEIVE_STOP:
      write_serial_data(RECEIVE_STOP);
      break;
   case SPINNING_START:
      write_serial_data(SPINNING_START);
      break;
   case SPINNING_STOP:
      write_serial_data(SPINNING_STOP);
      break;
   case TEMPERATURE_DRIVEN_START:
      write_serial_data(TEMPERATURE_DRIVEN_START);
      break;
   case TEMPERATURE_DRIVEN_STOP:
      write_serial_data(TEMPERATURE_DRIVEN_STOP);
      break;
   case SPEED_VALUE:
      write_serial_data(SPEED_VALUE);
      write_serial_data(value);
      break;
   case OFFSET_VALUE:
      write_serial_data(OFFSET_VALUE);
      write_serial_data(value);
      break;
   case TARGET_TEMPERATURE_VALUE:
      write_serial_data(TARGET_TEMPERATURE_VALUE);
      write_serial_data(value);
      break;
   case TEMPERATURE_VALUE:
      write_serial_data(TEMPERATURE_VALUE);
      write_serial_data(value);
      break;
   }
}

int is_serial_available(void){     //Check if PB3 is high (RX pin) and return 1 / 0
   if ((PINB & (1 << PINB3)) == 0 && readingSerial == 0){  
      data = 0x00;
      delay_bits(1);  
      return 1;
   }
   return 0;
}

uint8_t get_serial_data(void){
   data = NULL_DATA;
   if (is_serial_available()){
      readingSerial = 1;   //Prevents serialAvailable functioning while reading
      data = 0x00;
      for(int i = 0; i < 8; i++){
         data >>= 1;
         if (PINB & (1 << PINB3)) {
            data |= (1 << 7);
         }
         delay_bits(1);
      }
   }
   readingSerial = 0;   
   return data;   
}

//These "receive" functions may need a handshake with master
//Asks master if it send this type of data and then send data for compare
//More weight on master code side because more space for code
void receive_fan_speed_value(void){
   uint8_t speedValue = get_serial_data();
   set_fan_speed_value(speedValue);
}

void receive_fan_offset_value(void){
   uint8_t offsetValue = get_serial_data();
   set_fan_offset_value(offsetValue);
}

void receive_fan_target_temperature_value(void){
   uint8_t targetTemperatureValue = get_serial_data();   //0-255 BUT NOT ACTUAL TEMPERATURE
   set_target_temperature_value(targetTemperatureValue);
}