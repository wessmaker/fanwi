#ifndef REGISTER_H
#define REGISTER_H

#define DDRB *((volatile unsigned char*) 0x17)
#define TCCR0A *((volatile unsigned char*) 0x2A)
#define TCCR0B *((volatile unsigned char*) 0x33)
#define TCNT0 *((volatile unsigned char*)0x32)
#define TIFR *((volatile unsigned char*)0x38)
#define PINB *((volatile unsigned char*)0x16)
#endif