// Uses timer/counter0
#include "timer.h"
#define CYCLE_SPEED 1000000   //1Mhz
#define TCCR0A *((volatile unsigned char*) 0x2A)
#define TCCR0B *((volatile unsigned char*) 0x33)

void initializeTimer(){
   TCCR0A = 0;                               //Set "mode" to normal, no PWM in use for this
   TCCR0B |= (0 << 2) | (0 << 1) | (1 << 0); //Set prescaler to "none" (table 11-6: CS02 = 0,  CS01 = 0, CS00 = 1)
}