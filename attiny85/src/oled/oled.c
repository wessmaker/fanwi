#include "oled_driver.h"

void intialize_oled(void);


void intialize_oled(void){
   show_oled_label(SPEED);
   show_oled_label(TEMPERATURE);
}
