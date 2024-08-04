#include "pins.h"
#include "registers.h"

void pins_initialize(void){
   DDRB |= (1 << 3); //PB4 (pin 2) as output for TX
   PORTB |= (1 << 3); //Set TX pin high as initial state
   DDRB |= (0 << 4); //PB3 (pin 3) as input for RX
   DDRB |= (1 << 0); //PB0 (pin 5) as output for PWM (OC0A)
   
};