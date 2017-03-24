#define CUSTOM_SETTINGS
#define INCLUDE_GAMEPAD_SHIELD
#include <OneSheeld.h>
const int switchPin=2;
const int motorPin=9;
int switchState=0;
void setup()
{
  OneSheeld.begin();
  pinMode(motorPin,OUTPUT);
  pinMode(switchPin,INPUT);
}
void loop()
{
  switchState=digitalRead(switchPin);
  //if(switchState==HIGH)
  if (GamePad.isUpPressed())
  {
    digitalWrite(motorPin,HIGH);
    delay(10);
    digitalWrite(motorPin,LOW);
  }
  else if (GamePad.isDownPressed())
  {
      analogWrite(motorPin, 255);
      digitalWrite(motorPin,HIGH);
      delay(10);
      digitalWrite(motorPin,LOW);
  }   
  }
