// Uses timer/counter0
#include <stdio.h>
#include "serial_timer.h"
#include "settings/settings.h"
#include "settings/registers.h"

void timer_initialize(void);
void delay_us(uint16_t);
void delay_bits(uint8_t);

void timer_initialize(void){
   TCCR1 = 0;          //Clear all settings                              
   TCCR1 |= (1 << 0);  //CS12 = 0, CS11 = 0, CS10 = 1
}

void delay_us(uint16_t microSeconds){
   TCNT1 = 0x00;
   uint16_t delay_counts = F_CPU / 1000000 * microSeconds;
   while (TCNT0 < delay_counts){}
}

void delay_bits(uint8_t bitCount){
   delay_us(BIT_DELAY * bitCount);
}