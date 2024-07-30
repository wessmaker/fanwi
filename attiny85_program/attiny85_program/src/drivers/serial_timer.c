// Uses timer/counter0
#include <stdio.h>
#include "serial_timer.h"
#include "settings/settings.h"
#include "settings/registers.h"

void timer_initialize(void){
   TCCR0A = 0;                               //Set "mode" to normal, no PWM in use for this
   TCCR0B |= (0 << 2) | (0 << 1) | (1 << 0); //Set prescaler to "none" (table 11-6: CS02 = 0,  CS01 = 0, CS00 = 1)
}

void delay_us(uint16_t microSeconds){
   TCNT0 = 0x00;
   uint16_t delay_counts = CYCLE_SPEED / 1000000 * microSeconds;
   while (TCNT0 < delay_counts){}
}

void delay_bits(uint8_t bitCount){
   delay_us(BIT_DELAY * bitCount);
}