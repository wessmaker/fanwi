#include "pins.h"
#include "registers.h"

void pins_initialize(void){
   DDRB |= (1 << 3); //PB4 (pin 2) as output TX
   PORTB |= (1 << PINB3); //Set TX pin high at initial state
   DDRB &= ~(0 << 4); //PB3 (pin 3) as RX input 
   DDRB |= (1 << 0); //PB0 (pin 5) as PWM output (OC0A)
   DDRB |= (1 << 5);  //PB5 (pin 1) as SDA output !!RESET PIN, SET FUSES!!
   DDRB |= (1 << 2);  //PB2 (pin 7) as SCL output
   PORTB |= (1 << SDA_PIN);   //Set I2C pins high at initial state
   PORTB |= (1 << SCL_PIN);
};