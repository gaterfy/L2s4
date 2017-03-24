
/*
Author : KUNSANGABO NDONGALA Berfy
Mayo Jaune V1.0.1
Pilotable avec Android
*/
#define CUSTOM_SETTINGS
#define INCLUDE_GAMEPAD_SHIELD
#include <OneSheeld.h>
const int controlPin1=2;
const int controlPin2=3;
const int enablePin=9;
const int directionswitchPin=4;
const int onOffSwitchStateSwitchPin=5;
const int potPin =A0;

int onOffSwitchState=0;
int previousOnOffSwitchState=0;
int directionSwitchState=0;
int previousDirectionSwitchState=0;

int motorEnabled=0;
int motorSpeed=150;
int motorDirection=1;

void setup()
{
  OneSheeld.begin();
  pinMode(directionswitchPin, INPUT);
  pinMode(onOffSwitchStateSwitchPin,INPUT);
  pinMode(controlPin1,OUTPUT);
  pinMode(controlPin2,OUTPUT);
  pinMode(enablePin,OUTPUT);

  digitalWrite(enablePin,OUTPUT);
}
void loop()
{
  onOffSwitchState=digitalRead(onOffSwitchStateSwitchPin);

  delay(1);
  directionSwitchState=digitalRead(directionswitchPin);
  //motorSpeed=analogRead(potPin)/4;
  //if(switchState==HIGH)
  if (onOffSwitchState != previousOnOffSwitchState)
  {
    if(onOffSwitchState==HIGH){
      motorEnabled= !motorEnabled;
    }
  }
  if(directionSwitchState != previousDirectionSwitchState){
    if(directionSwitchState==HIGH){
      motorDirection = !motorDirection;}
  }
  if(motorDirection==1){
    digitalWrite(controlPin1,HIGH);
    digitalWrite(controlPin2,LOW);

  }
  else{
    digitalWrite(controlPin1,LOW);
    digitalWrite(controlPin2,HIGH);
  }

  

  if (motorEnabled==1){
    analogWrite(enablePin, motorSpeed);
  } 
  
  else{
    analogWrite(enablePin, 0);
  }
  previousDirectionSwitchState=directionSwitchState;
  previousOnOffSwitchState=onOffSwitchState;
  }
