#include "pins.h"
#include "settings/registers.h"

void pins_initialize(void){
   DDRB |= (0 << 3); //PB3 (pin 2) as input for RX
   DDRB |= (1 << 4); //PB3 (pin 2) as output for TX
   DDRB |= (1 << 0); //PB0 (pin 5) as output for PWM (OC0A)
// DDRB |= (0 << ?); //PB? (pin ?) as input for sensor voltage value 
};