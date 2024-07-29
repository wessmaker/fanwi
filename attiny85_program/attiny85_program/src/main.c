#include "drivers/pins.h"
#include "serial.c"
#include "drivers/serial.h"

enum serialMessage serialMessage;

int main(){
   initializePins();

   while (1){
      handleSerial();
   }
   return 0;
}


void handleSerial(){
   switch (serialMessage){
   case RECEIVE_START:
      break;
   case NULL_DATA:
      break;
   }
}