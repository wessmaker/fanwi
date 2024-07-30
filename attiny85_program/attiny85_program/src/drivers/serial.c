#include "serial.h"
#include "settings/settings.h"
#include "settings/registers.h"
#include "pins.h"
#include "serial_timer.h"

void initializeSerial(void);
void send_byte(uint8_t byte);
void readingSerialData(uint8_t mode);
int is_serial_available(void);
uint8_t get_serial_data(void);
uint8_t readingSerial = 0;
uint8_t data;

int is_serial_available(void){     //Check if PB3 is high (RX pin) and return 1 / 0
   if ((PINB & 0x08) == 0 && readingSerial == 0){  
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
         if (PINB & 0x08) {
            data |= (1 << 7);
         }
         delay_bits(1);
      }
   }
   readingSerial = 0;   
   return data;   
}

