#include "oled_driver.h"
#include "i2c.h"

void show_oled_label(enum OledValueType);
void set_oled_value(enum OledValueType, uint8_t);

// 8.1.5.1 : I2C-bus Write data (1306 datasheet)
void send_command();
void send_data(enum OledValueType);
void set_oled_contrast(uint8_t);
void show_oled_speed_label(void);
void show_oled_temperature_label(void);
void set_oled_temperature_value(uint8_t value);
void set_oled_speed_value(uint8_t value);


void send_command(void){

}

void show_oled_speed_label(void){

}

void show_oled_temperature_label(void){

}

void set_oled_speed_value(uint8_t value){

}

void set_oled_temperature_value(uint8_t value){

}

void show_oled_label(enum OledValueType OledValueType){
   switch (OledValueType){
      case SPEED:
         show_oled_speed_label();
         break;
      case TEMEPERATURE:
         show_oled_temperature_label();
         break;
   }
}


void set_oled_value(enum OledValueType OledValueType, uint8_t value){
   switch (OledValueType){
      case SPEED:
         set_oled_speed_value(value);
         break;
      case TEMEPERATURE:
         set_oled_temperature_value(value);
         break;
   }
}

void set_oled_contrast(uint8_t contrastValue){
   I2C_write(OLED_ADDRESS, CONTRAST_CONTROL);
   I2C_write(OLED_ADDRESS, contrastValue);
}