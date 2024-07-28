// Uses timer/counter0
#include "timer.h"
#include "settings/settings.h"
#include "settings/registers.h"




void initializeTimer(){
   TCCR0A = 0;                               //Set "mode" to normal, no PWM in use for this
   TCCR0B |= (0 << 2) | (0 << 1) | (1 << 0); //Set prescaler to "none" (table 11-6: CS02 = 0,  CS01 = 0, CS00 = 1)
}

void msDelay(uint8_t delayLenght){     //this is for 






}