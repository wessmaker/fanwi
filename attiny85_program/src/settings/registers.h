#ifndef REGISTER_H
#define REGISTER_H

#define DDRB *((volatile unsigned char*) 0x17)
#define TCCR1 *((volatile unsigned char*) 0x30)
#define TCNT1 *((volatile unsigned char*) 0x2F)
#define TCCR0A *((volatile unsigned char*) 0x2A)
#define TCNT0 *((volatile unsigned char*)0x32)
#define OCR0A *((volatile unsigned char*)0x29)
#define PINB *((volatile unsigned char*)0x16)
#define PORTB *((volatile unsigned char*)0x18)
#define PINB3 3

#endif