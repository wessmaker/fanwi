#ifndef TIMER_H
#define TIMER_H
#include <stdint.h>

void initializeTimer();
void delay_us(uint16_t microSeconds);
void delay_bits(uint8_t bitCount);
#endif