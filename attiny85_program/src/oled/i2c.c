#include "serial/serial_timer.h"
#include "settings/pins.h"
#include "settings/registers.h"

void initialize_I2C(void);
void I2C_delay(uint8_t);
void I2C_write_byte(uint8_t);
void I2C_start_write(uint8_t);
void I2C_stop_write(void);
uint8_t I2C_read_ACK(void);

void initialize_I2C(void){
   PORTB |= (SCL_PIN << 1);
   PORTB |= (SDA_PIN << 1);
}

void I2C_delay(uint8_t delayCount){
   while (delayCount > 0){
      delay_us(5);
      delayCount--;
   }
}

void I2C_start_write(uint8_t address){
   PORTB |= (1 << SCL_PIN);
   PORTB &= ~(1 << SDA_PIN);
   I2C_delay(1);
   address <<= 1; //Let last bit to be 0 because write mode
   I2C_write_byte(address);
}

void I2C_stop_write(void){
   PORTB &= ~(1 << SDA_PIN);
   PORTB |= (1 << SCL_PIN);
   I2C_delay(1);
   PORTB |= (1 << SDA_PIN);

}

void I2C_write_byte(uint8_t byte){
   for (uint8_t i = 0; i < 8; i++){
      PORTB |= (1 << SCL_PIN);
      if (byte & 0x80){
         PORTB |= (1 << SDA_PIN);
      }else{
         PORTB &= ~(1 << SDA_PIN);
      }
      byte <<= 1;
      I2C_delay(1);
      PORTB &= ~(1 << SCL_PIN);
      I2C_delay(1);
   }
}

uint8_t I2C_read_ACK(void){
   PORTB |= (1 << SCL_PIN);
   uint8_t ack = !(PINB & (1 << SDA_PIN));   //LOW = SUCCESS, HIGH = FAILURE
   I2C_delay(1);
   PORTB &= ~(1 << SCL_PIN);
   return ack;
}

uint8_t I2C_write(uint8_t address, uint8_t data){
   I2C_start_write(address);
   I2C_write_byte(data);
   I2C_stop_write();
}


