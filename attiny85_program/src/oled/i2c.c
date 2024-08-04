#include "serial/serial_timer.h"
#include "settings/pins.h"
#include "settings/registers.h"

void initialize_I2C(void);
void I2C_delay(uint8_t);
void I2C_write(uint8_t, uint8_t);

void I2C_start_write(void);
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

void I2C_start_write(){
   PORTB |= (1 << SCL_PIN);
   PORTB &= ~(1 << SDA_PIN);
}

void I2C_stop_write(){
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

uint8_t I2C_read_ACK(){
   PORTB |= (1 << SCL_PIN);
   uint8_t ack = !(PINB & (1 << SDA_PIN));   //LOW = SUCCESS, HIGH = FAILURE
   I2C_delay(1);
   PORTB &= ~(1 << SCL_PIN);
   return ack;
}

void I2C_write(uint8_t data, uint8_t address){
   I2C_start_write();
   I2C_delay(1);
   address <<= 1;
   address |= 1;  //Add write bit
   I2C_write_byte(address);
   I2C_delay(1);
   if (I2C_read_ACK()){
      I2C_write_byte(data);
   }else{
      //TODO do ACK checking
   }
   I2C_delay(1);
   I2C_stop_write();
}
