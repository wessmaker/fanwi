#ifndef PWM_H
#define PWM_H

#include <stdint.h>
#include "settings/pins.h"
#include "settings/registers.h"
#include "settings/settings.h"

void set_fan_pwm(uint8_t);
void pwm_initialize(void);

#endif