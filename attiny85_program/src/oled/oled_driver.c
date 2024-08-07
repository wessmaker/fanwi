#include "oled_driver.h"
#include "i2c.h"

void show_oled_label(enum OledValueType);
void set_oled_value(enum OledValueType, uint8_t);

// 8.1.5.1 : I2C-bus Write data (1306 datasheet)
void send_command(uint8_t);
void send_data(enum OledValueType);
void set_oled_contrast(uint8_t);
void show_oled_speed_label(void);
void show_oled_temperature_label(void);
void set_oled_temperature_value(uint8_t value);
void set_oled_speed_value(uint8_t value);

uint8_t labelOffset = 10;
uint8_t charSpacing = 1;
const uint8_t speedPageNumber = 0x01;

void send_command(uint8_t command){
   I2C_start_write(OLED_ADDRESS);
   I2C_write_byte(0x00);         //Write "command bit" (0)
   I2C_write_byte(command);
}

void show_oled_speed_label(void){
   send_command(ADRESSING_MODE_SELECTION);
   send_command(ADRESSING_HORIZONTAL_MODE);

   for (int i = 0; i < 5; i++){
      send_command(PAGE_ADDRESS_RANGE);
      send_command(speedPageNumber);   //Start page
      send_command(speedPageNumber);   //End page
      send_command(COLUMN_RANGE_SELECTION);
      send_command(8 * i + labelOffset);     //Start column
      send_command(8 * i + 8 + labelOffset); //End column
      for (int j = 0; i < 7; i++){
         send_command(SPEED_WORD[i][j]);
      }
   }
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
      case TEMPERATURE:
         show_oled_temperature_label();
         break;
   }
}


void set_oled_value(enum OledValueType OledValueType, uint8_t value){
   switch (OledValueType){
      case SPEED:
         set_oled_speed_value(value);
         break;
      case TEMPERATURE:
         set_oled_temperature_value(value);
         break;
   }
}

void set_oled_contrast(uint8_t contrastValue){
   I2C_write(OLED_ADDRESS, CONTRAST_CONTROL);
   I2C_write(OLED_ADDRESS, contrastValue);
}