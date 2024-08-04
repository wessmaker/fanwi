#ifndef I2C_H
#define I2C_H
#include <stdint.h>

void initialize_I2C(void);
void I2C_delay(uint8_t);
void I2C_write(uint8_t, uint8_t);
//uint8_t I2C_read(void);

#endif