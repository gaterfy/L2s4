/*
 * projet 5
 * Réalisé par Kunsangabo ndongala Berfy
 */

#include <Servo.h>

Servo myServo;

int const potPin=A0;/*entrée analogique du potentiomètre */
int potVal;
int angle;

void setup(){
  Serial.begin(9600);
  myServo.attach(9);
  
  }


void loop(){
  potVal=analogRead(potPin);
  Serial.print("potVal : ");
  delay(500);
  Serial.print(potVal);
  
  angle=map(potVal,0,1023,0,179);
  Serial.print(" , angle : ");
  Serial.print(angle);
  myServo.write(angle);
  delay(15);
  }
