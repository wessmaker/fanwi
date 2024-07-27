#include "pins.h"

#define DDRB *((volatile unsigned char*) 0x17)

void initializePins(void){
   DDRB |= (0 << 3); //PB3 (pin 2) as input for RX
   DDRB |= (1 << 4); //PB3 (pin 2) as output for TX
   DDRB |= (1 << 1); //PB1 (pin 6) as output for PWM, OC0A is used for delay -> PB0 is unusable
};



