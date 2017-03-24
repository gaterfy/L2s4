int sensorValue;
int sensorLow=1023;
int sensorHigh=0;
const int ledPin=13;
const int SensorPin=A0;
void setup(){
  Serial.begin(9600);
  pinMode(ledPin,OUTPUT);
  digitalWrite(ledPin,HIGH);/*on en voie du courant*/
  while(millis()<5000){
    sensorValue=analogRead(SensorPin);
    if(sensorValue >sensorHigh){
      sensorHigh=sensorValue;
      }
    if(sensorValue <sensorLow){
      sensorLow = sensorValue;
      }
    }
  digitalWrite(ledPin,LOW);
  }



void loop(){
  sensorValue=analogRead(SensorPin);
  int pitch=map(sensorValue,sensorLow,sensorHigh,50,4000);
  Serial.print("\t ");
  Serial.print(pitch);
  tone(8,pitch,20);
  delay(1000);/*temps d'attente pour vérifier les valeurs de la variable pitch */
  }
