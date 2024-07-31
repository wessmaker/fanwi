#ifndef TIMER_H
#define TIMER_H
#include <stdint.h>

void timer_initialize(void);
void delay_us(uint16_t);
void delay_bits(uint8_t);
#endif