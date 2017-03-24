/*
 * montage 3
 */
#define MAX 3
#include <stdio.h>

int digit(int);
const int sensorAnalog=0;
int led[MAX]={2,3,4};
int cpt=0;
int lireAn=0;
float temperature=0.0;
const int baselineTemp=162.0;
void setup(){
  Serial.begin(9600);/*vitesse de transmission*/
  for(cpt;cpt<MAX;cpt++){
    pinMode(led[cpt],OUTPUT);
    digitalWrite(led[cpt],0);
    }
  }

void loop(){
  lireAn=analogRead(sensorAnalog);
  Serial.print("valeur capteur : ");
  Serial.print(lireAn); //valeur de sensor val
  /*convertir la lecture du Can en tension */
  float voltage = (lireAn/1024.0)*5.0;
  Serial.print(", Volts : ");
  Serial.print(voltage);//on imprime la valeur du voltage(tension)
  //convertir la tension en température en dégrés
  float temperature =(voltage - 0.5)*100;
  Serial.print(temperature);
  if(temperature < baselineTemp){
    digit(0);
    }
  else if(temperature >= baselineTemp +2 && temperature < baselineTemp+4){
    digit(1);
    }
  else if(temperature >= baselineTemp +2 && temperature < baselineTemp+6){
    digit(2);
    }
  else if(temperature >= baselineTemp +6){
    digit(3);
    }
    delay(1500);
  }
  
 int digit(int n){
  switch(n){
    case 0:
       for(cpt;cpt<MAX;cpt++){
        digitalWrite(led[cpt],LOW);
        }
        //break;
    
    case 1:
      digitalWrite(2,HIGH);
      //break;
     //on allume 2 leds
    case 2:
      for(cpt;cpt<MAX -1 ;cpt++){
        digitalWrite(led[cpt],HIGH);
        }
        //break;
    case 3 :
    for(cpt;cpt<MAX;cpt++){
        digitalWrite(led[cpt],HIGH);
        }
       // break;
    
    }
  }
