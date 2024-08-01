#include "settings/pins.h"
#include "settings/registers.h"
#include "settings/settings.h"
#include "pwm.h"
#include <stdint.h>

void pwm_initialize(void);
void set_fan_pwm(uint8_t);

void pwm_initialize(void){
   TCCR0A |= (1 << 1) | (1 << 0);      //Fast PWM mode (WGM01 = 1, WGM00 = 1)
   TCCR0A |= (1 << 7) | (1 << 5);      //Clear OC0A on match, non inverting
   TCCR0A &= ~(1 << 6) | ~(1 << 4);    //Clear OC0A on match, non inverting
   OCR0A = 0;  //This will set fan PWM to zero when RESET
}

void set_fan_pwm(uint8_t dutyCycle) {
   OCR0A = dutyCycle;
}